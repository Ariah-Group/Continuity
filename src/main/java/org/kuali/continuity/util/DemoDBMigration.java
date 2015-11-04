// 
// Copyright 2011 Kuali Foundation, Inc. Licensed under the
// Educational Community License, Version 2.0 (the "License"); you may
// not use this file except in compliance with the License. You may
// obtain a copy of the License at
// 
// http://www.opensource.org/licenses/ecl2.php
// 
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an "AS IS"
// BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied. See the License for the specific language governing
// permissions and limitations under the License.
// 
package org.kuali.continuity.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.sql.DataSource;

import org.apache.commons.validator.EmailValidator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

// TODO: test user email format and access status
// TODO: test user email duplicates
// TODO: test system log sql that includes blank institutionid
// TODO: test user lookup
// TODO: test institutionid in system log
// TODO: test migration count
// TODO: modify kr codes, etc.
// TODO: before migration, check blank and duplicate emails in ucready
// MUST BE RUN ONE SYSTEM DOMAIN ROW AT A TIME
// MUST RUN SQL: update systemdomain set moderation = tips where tips is not null and tips != ''
public class DemoDBMigration {
	
	public final static String KR_DEV = 
		"jdbc:sqlserver://krdy-ddb01.ist.berkeley.edu:1433;DatabaseName=KualiReady";
	public final static String KR_QA = 
		"jdbc:sqlserver://krdy-qdb01.ist.berkeley.edu:1433;DatabaseName=KualiReady";
	public final static String KR_STAGING = 
		"jdbc:sqlserver://krdy-sdb01.ist.berkeley.edu:1433;failoverPartner=krdy-sdb02.ist.berkeley.edu;databaseName=KualiReady;trustServerCertificate=true;encrypt=true";
	public final static String UR_PROD = 
		"jdbc:sqlserver://sql-pnon02.ist.berkeley.edu:1433;DatabaseName=UCReady";
	
	// data source
	private DataSource dsUCReady = new DriverManagerDataSource(
		"com.microsoft.sqlserver.jdbc.SQLServerDriver", 
		UR_PROD, 
		"restart_app", 
		"RB7erk.ley");
	private DataSource dsKRReady = new DriverManagerDataSource(
		"com.microsoft.sqlserver.jdbc.SQLServerDriver", 
		KR_QA, 
		"restart_app", 
		"RB7erk.ley");
	private JdbcTemplate jdbcTemplateUCReady = new JdbcTemplate(dsUCReady);
	private JdbcTemplate jdbcTemplateKRReady = new JdbcTemplate(dsKRReady);
	
	// queries
	private final static String TABLE_SD_QUERY = "select * from %s where institutionid = ?";
	private final static String TABLE_PL_QUERY = "select * from %s where pid = ?";
	private final static String TABLE_CF_QUERY = "select * from %s where cid = ?";
	private final static String TABLE_IN_QUERY = "select * from %s where pis_id = ?";
	private final static String TABLE_TM_QUERY = "select * from %s where kt_id = ?";
	private final static String TABLE_SD_NAME_QUERY = "select institution from systemdomain where institutionid = ?";
	
	// user queries
	private final static String TABLE_USER_EMAIL_QUERY = "select userid from usersecurity where institutionid = ? and emailregular = ?";
	private final static String TABLE_USER_ID_QUERY = "select * from usersecurity where userid = ?";
	
	// system log query
	private final static String TABLE_SL_QUERY = 
		"select sl.* " +
		  "from systemlog sl, usersecurity us " +
		 "where sl.objecttype not in ('pl','cr') " +
		   "and sl.userid = us.userid " +
		   "and us.institutionid = ? " +
		 "union " +
		"select sl.* " +
		  "from systemlog sl, plans p " +
		 "where sl.objecttype = 'pl' " +
		   "and sl.objectid = p.pid " +
		   "and p.institutionid = ? " +
		 "union " +
		"select sl.* " +
		  "from systemlog sl, critical_functions cf, plans p " +
		 "where sl.objecttype = 'cr' " +
		   "and sl.objectid = cf.cid " +
		   "and cf.pid = p.pid " +
		   "and p.institutionid = ? ";

	// tables and pks
	private static List<UCTable> tableList = new ArrayList<UCTable>();
	private static Map<UCTable, Map<Integer, Integer>> idMaps = new HashMap<UCTable, Map<Integer, Integer>>();

	// logger
	private static final Logger logger = Logger.getLogger(DemoDBMigration.class);
	static {
		logger.setLevel(Level.DEBUG);
	}
	
	// system domain id
	Integer krSystemDomainId;
	
	// row count
	int rowcount = 0;

	// referenced tables
	static UCTable systemDomainTable = new UCTable("SystemDomain", "InstitutionID");
	static UCTable acronymTable = new UCTable("Acronym","AcronymID", systemDomainTable);
	static UCTable buildingTable = new UCTable("Building","BuildingID", systemDomainTable);
	static UCTable centralApplicationTable = new UCTable("CentralApplication","CentralApplicationID", systemDomainTable);
	static UCTable departmentTypeTable = new UCTable("DepartmentType","DepartmentTypeID", systemDomainTable);
	static UCTable dependencyTable = new UCTable("Dependency","DependencyID", systemDomainTable);
	static UCTable instructionalDepartmentTable = new UCTable("InstructionalDepartment", "InstructionalDepartmentID", systemDomainTable);
	static UCTable majorDivisionTable = new UCTable("MajorDivision", "MajorDivisionID", systemDomainTable);
	static UCTable shiftTable = new UCTable("Shift",  "ShiftID", systemDomainTable);
	static UCTable skillTable = new UCTable("Skill",  "SkillID", systemDomainTable);
	static UCTable staffCategoryTable = new UCTable("StaffCategory", "StaffCategoryID", systemDomainTable);
	static UCTable userSecurityTable = new UCTable("UserSecurity", "UserID", systemDomainTable);
	static UCTable utilityTable = new UCTable("Utility", "UtilityID", systemDomainTable);
	static UCTable planTable = new UCTable("plans", "pid", systemDomainTable, acronymTable, majorDivisionTable);
	static UCTable criticalFunctionTable = new UCTable("critical_functions", "cid", planTable);
	static UCTable instructionTable = new UCTable("plans_instructions", "pis_id", planTable, instructionalDepartmentTable);
	static UCTable teamTable = new UCTable("key_teams", "kt_id", planTable);
	
	static {
		// table list
		tableList.add(systemDomainTable);
		tableList.add(acronymTable);                                                                                                                         
		tableList.add(new UCTable("AnnualReview", "AnnualReviewID", systemDomainTable));                                                                                                                     
		tableList.add(buildingTable);                                                                                                                      
		tableList.add(new UCTable("BuildingSource", "BuildingID", systemDomainTable));                                                                                                                   
		tableList.add(centralApplicationTable);                                                                                                            
		tableList.add(new UCTable("ContactUs", "ContactID", systemDomainTable));                                                                                                                        
		tableList.add(departmentTypeTable);                                                                                                                  
		tableList.add(dependencyTable);                                                                                                                      
		tableList.add(new UCTable("FAQ", "FAQID", systemDomainTable));                                                                                                                              
		tableList.add(instructionalDepartmentTable);                                                                                                          
		tableList.add(majorDivisionTable);                                                                                                                    
		tableList.add(new UCTable("PlannerCategory", "PlannerCategoryId", systemDomainTable));                                                                                                                 
		tableList.add(new UCTable("Reference", "ReferenceID", systemDomainTable));                                                                                                                        
		tableList.add(shiftTable);                                                                                                                           
		tableList.add(skillTable);                                                                                                                           
		tableList.add(staffCategoryTable);                                                                                                                   
		tableList.add(new UCTable("ThingsToKnow", "ThingsToKnowID", systemDomainTable));                                                                                                                    
		tableList.add(utilityTable);
/*
		tableList.add(userSecurityTable);                                                                                                                    
		
		tableList.add(planTable);
		tableList.add(new UCTable("it_applications", "it_application_id", planTable));                                                                                                                 
		tableList.add(new UCTable("it_central_applications", "RecordID", planTable, centralApplicationTable));                                                                                                         
		tableList.add(new UCTable("it_servers", "it_server_id", planTable));                                                                                                                      
		tableList.add(new UCTable("key_communication", "k_id", planTable));                                                                                                               
		tableList.add(new UCTable("key_plan_documents", "kpd_id", planTable));                                                                                                              
		tableList.add(new UCTable("key_skills", "ks_id", planTable, skillTable));                                                                                                                      
		tableList.add(new UCTable("key_staff_other_units", "kso_id", planTable));                                                                                                           
		tableList.add(new UCTable("key_staff_unit", "ksu_id", planTable));                                                                                                                  
		tableList.add(new UCTable("key_stakeholders", "ks_id", planTable));                                                                                                               
		tableList.add(new UCTable("key_utility", "ku_id", planTable, utilityTable));                                                                                                                  
		tableList.add(new UCTable("key_work_home", "wh_id", planTable));                                                                                                                  
		tableList.add(new UCTable("plan_buildings", "", planTable, buildingTable));                                                                                                                  
		tableList.add(new UCTable("plan_contacts", "ContactID", planTable, userSecurityTable));                                                                                                                   
		tableList.add(new UCTable("plan_department_types", "", planTable, departmentTypeTable));                                                                                                           
		tableList.add(new UCTable("plan_reviewers", "pr_id", planTable));                                                                                                                  
		tableList.add(new UCTable("plan_unit_heads", "UnitHeadID", planTable, userSecurityTable));                                                                                                                 
		tableList.add(new UCTable("user_plan", "", planTable, userSecurityTable));
				
		tableList.add(criticalFunctionTable);                                                                                                              
		tableList.add(new UCTable("cf_dependency", "", criticalFunctionTable, dependencyTable));                                                                                                                   
		tableList.add(new UCTable("key_critical_function_documents", "kcd_id", criticalFunctionTable));                                                                                                 
		tableList.add(new UCTable("key_staffing_req", "ksr_id", planTable, criticalFunctionTable, shiftTable, staffCategoryTable));
		
		tableList.add(instructionTable);                                                                                                              
		tableList.add(new UCTable("instruction_high_priority", "ihp_id", instructionTable));                                                                                                       
		tableList.add(new UCTable("instruction_teaching_issues", "iti_id", instructionTable));
		
		tableList.add(teamTable);                                                                                                                       
		tableList.add(new UCTable("key_team_members", "ktm_id", teamTable));

		tableList.add(new UCTable("action_items", "a_id", planTable, criticalFunctionTable, instructionTable)); 
		tableList.add(new UCTable("FunctionExample", "FunctionExampleID", systemDomainTable));                                                                                                                 
		tableList.add(new UCTable("SystemLog", "SystemLogID", systemDomainTable, userSecurityTable));
*/		
		// id maps
		idMaps.put(systemDomainTable, new HashMap<Integer, Integer>());
		idMaps.put(acronymTable, new HashMap<Integer, Integer>());
		idMaps.put(buildingTable, new HashMap<Integer, Integer>());
		idMaps.put(centralApplicationTable, new HashMap<Integer, Integer>());
		idMaps.put(departmentTypeTable, new HashMap<Integer, Integer>());
		idMaps.put(dependencyTable, new HashMap<Integer, Integer>());
		idMaps.put(instructionalDepartmentTable, new HashMap<Integer, Integer>());
		idMaps.put(majorDivisionTable, new HashMap<Integer, Integer>());
		idMaps.put(shiftTable, new HashMap<Integer, Integer>());
		idMaps.put(skillTable, new HashMap<Integer, Integer>());
		idMaps.put(staffCategoryTable, new HashMap<Integer, Integer>());
		idMaps.put(userSecurityTable, new HashMap<Integer, Integer>());
		idMaps.put(utilityTable, new HashMap<Integer, Integer>());
		idMaps.put(planTable, new HashMap<Integer, Integer>());
		idMaps.put(criticalFunctionTable, new HashMap<Integer, Integer>());
		idMaps.put(teamTable, new HashMap<Integer, Integer>());
		idMaps.put(instructionTable, new HashMap<Integer, Integer>());
	}
	
	String getSystemDomainName(String systemDomainId) {
		return (String) this.jdbcTemplateUCReady.queryForObject(
			TABLE_SD_NAME_QUERY, new Object[] {systemDomainId}, String.class);
	}
	
	void doMigrate(Integer systemDomainId) {
		for (UCTable table : tableList) {
			// set handler
			CallbackHandler handler = null;
			if (table.getName().equalsIgnoreCase("FunctionExample"))
				handler = new FunctionExampleCallbackHandler(table);
			else if (table.getName().equalsIgnoreCase("SystemLog"))
				handler = new SystemLogCallbackHandler(table);
			else if (table.getName().equalsIgnoreCase("UserSecurity"))
				handler = new UserSecurityCallbackHandler(table);
			else if (table.getName().equalsIgnoreCase("SystemDomain"))
				handler = new SystemDomainCallbackHandler(table);
			else 
				handler = new CallbackHandler(table);
			
			// system domain first
			if (table.getName().equals("SystemDomain")) {
				logger.debug("SQL: " + String.format(TABLE_SD_QUERY, table.getName()));
				this.jdbcTemplateUCReady.query(
					String.format(TABLE_SD_QUERY, table.getName()), 
					new Object[] {systemDomainId}, 
					handler);
				this.krSystemDomainId = idMaps.get(table).get(systemDomainId);
				
			// system log last
			} else if (table.getName().equals("SystemLog")) {
				logger.debug("SQL: " + String.format(TABLE_SL_QUERY, table.getName()));
				this.jdbcTemplateUCReady.query(
					String.format(TABLE_SL_QUERY, table.getName()), 
					new Object[] {systemDomainId, systemDomainId, systemDomainId}, 
					handler);

				// the rest
			} else {
				List<UCTable> depTables = table.getDependencies();
				boolean isDepSD = false;
				boolean isDepPL = false;
				boolean isDepCF = false;
				boolean isDepIN = false;
				boolean isDepTM = false;
				boolean isDepUS = false;
				for (UCTable ucTable : depTables) {
					String tName = ucTable.getName();
					if (tName.equals("key_teams"))
						isDepTM = true;
					else if (tName.equals("plans_instructions"))
						isDepIN = true;
					else if (tName.equals("critical_functions"))
						isDepCF = true;
					else if (tName.equals("plans"))
						isDepPL = true;
					else if (tName.equals("SystemDomain"))
						isDepSD = true;
					// user security?
					if (tName.equals("UserSecurity"))
						isDepUS = true;
				}
				
				UCTable depTable = new UCTable("");
				String query = "";
				String tableName = table.getName();
				if (tableName.equals("action_items")) {
					depTable = planTable;
					query = TABLE_PL_QUERY;
				} else if (isDepTM) {
					depTable = teamTable;
					query = TABLE_TM_QUERY;
				} else if (isDepIN) {
					depTable = instructionTable;
					query = TABLE_IN_QUERY;
				} else if (isDepCF) {
					depTable = criticalFunctionTable;
					query = TABLE_CF_QUERY;
				} else if (isDepPL) {
					depTable = planTable;
					query = TABLE_PL_QUERY;
				} else if (isDepSD) {
					depTable = systemDomainTable;
					query = TABLE_SD_QUERY;
				}
				
				// is user security dependent
				if (isDepUS) {
					query += " and userid in (select userid from usersecurity)";
				}
				
				Set<Integer> ucIds = idMaps.get(depTable).keySet();
				logger.debug("SQL: " + String.format(query, tableName));
				this.rowcount = 0;
				for (Integer ucId : ucIds) {
					this.jdbcTemplateUCReady.query(
						String.format(query, tableName), 
						new Object[] {ucId}, 
						handler);
				}
			}
			
			System.out.println(rowcount + " " + table.getName() + " rows processed.");
			logger.debug("COUNT: " + rowcount + " " + table.getName() + " rows processed.");
		}
	}
	
	public static void main (String[] args) {

		BufferedReader in = 
			new BufferedReader(new InputStreamReader(System.in));
		DemoDBMigration migration = new DemoDBMigration();
		String idStr = "";
		String name  = "";
		
		System.out.print("Enter System Domain Id: ");
		try {
			idStr = in.readLine();
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}

		if (idStr == null || idStr.trim().length() == 0) 
			return;

		name = migration.getSystemDomainName(idStr);
		if (name == null || name.trim().length() == 0) {
			System.out.println("Id not found!");
			return;
		}
		
		System.out.print("Migrate '" + name + "'? (yes/no): ");
		try {
			String resp = in.readLine();
			if ("yes".equalsIgnoreCase(resp)) {
				migration.doMigrate(Integer.parseInt(idStr));
				System.out.println("Migration completed!");
			} else {
				System.out.println("Migration aborted!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public class CallbackHandler implements RowCallbackHandler {
		
		final UCTable table;
		final List<String> depColumns = new ArrayList<String>();
		
		CallbackHandler(UCTable table) {
			this.table = table;
			if (this.table.getDependencies() != null && !this.table.getDependencies().isEmpty()) {
				List<UCTable> depTables = this.table.getDependencies();
				for (int i = 0; i < depTables.size(); i++) {
					depColumns.add(depTables.get(i).getKey().toLowerCase());
				}
			}
		}
		
		@Override
		public void processRow(ResultSet rs) throws SQLException {
			// get table name & pk
			final String tableName = this.table.getName();
			final String tableKey = this.table.getKey();
			
			// get all columns
			final List<String> insertCols = new ArrayList<String>();
			ResultSetMetaData md = rs.getMetaData();
			int colCount = md.getColumnCount();
			for (int i = 1; i <= colCount; i++) {
				String colName = md.getColumnName(i);
				if (colName.equalsIgnoreCase(tableKey)) continue;
				insertCols.add(colName);
			}
			
			logger.debug("TABLE: " + tableName);

			// iterate result set
			do {
				
				// init column/value map
				Map<String, Object> colValueMap = new HashMap<String, Object>();

				// set all values
				for (int i = 0; i < insertCols.size(); i++) {
					String insertCol = insertCols.get(i);
					Object insertObj = this.getColumnValue(insertCol, rs);
					if (insertObj != null) colValueMap.put(insertCol, insertObj);
				}
				
				Map<String, Object> newCols = this.getKRColumns();
				if (newCols != null && !newCols.isEmpty()) {
					colValueMap.putAll(newCols);
				}
				
				logger.debug("MAP: " + colValueMap);

				// insert new row
				SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(DemoDBMigration.this.dsKRReady);
				simpleInsert.setSchemaName("dbo");
				simpleInsert.setTableName(tableName);
				simpleInsert.setColumnNames(new ArrayList<String>(colValueMap.keySet()));

				// dependencies?
				if (this.table.isWithKey()) {
					simpleInsert.setGeneratedKeyName(tableKey);
					Number krId = simpleInsert.executeAndReturnKey(colValueMap);
					
					// store pk to idMap
					if (this.table.isWithKey() && idMaps.containsKey(table)) {
						Map<Integer, Integer> idMap = idMaps.get(table);
						Integer ucId = (Integer) rs.getObject(tableKey);
						idMap.put(ucId, krId.intValue());
					}
				} else {
					simpleInsert.execute(colValueMap);
				}

				// increment count
				rowcount++;

			} while (rs.next());
		}
		
		protected Object getColumnValue(String insertCol, ResultSet rs) throws SQLException {
			if ("InstitutionId".equalsIgnoreCase(insertCol)) 
				return krSystemDomainId;	// always return single id
			if (this.depColumns.contains(insertCol.toLowerCase())) {
				// get dependency id from idMap
				Integer testId = (Integer) rs.getObject(insertCol);
				Integer depId = 0;
				if (testId != 0) {
					depId = this.getDependentId(insertCol, testId);
					if (depId == null) depId = 0;
				}
				return depId;
			}
			return rs.getObject(insertCol);
		}
		
		protected Integer getDependentId(UCTable table, Integer id) {
			Integer krId = idMaps.get(table).get(id);
			if (krId == null) {
				logger.debug("NOT FOUND: " + table.getName() + "." + table.getKey() + " " + id);
				if (userSecurityTable.equals(table)) {
					// create a new user.  this user is in another domain
					jdbcTemplateUCReady.query(
						TABLE_USER_ID_QUERY, 
						new Object[] {id}, 
						new UserSecurityCallbackHandler(userSecurityTable));
					// then try again
					krId = idMaps.get(table).get(id);
					// if still
					if (krId == null)
						throw new RuntimeException(table.getName() + "." + table.getKey() + " " + id + " not found!");
				} else {
					krId = 0;
				}
			}
			return krId;
		}
		
		protected Integer getDependentId(String columnName, Integer id) {
			List<UCTable> depTables = this.table.getDependencies();
			for (UCTable depTable : depTables) {
				if (depTable.getKey().equalsIgnoreCase(columnName))
					return getDependentId(depTable, id);
			}
			throw new RuntimeException("Key Value (" + columnName + ", " + id + ") not Found!");
		}
		
		protected Map<String, Object> getKRColumns() {
			return null;
		}

	}
	
	public class FunctionExampleCallbackHandler extends CallbackHandler {

		FunctionExampleCallbackHandler(UCTable table) {
			super(table);
		}
		
		protected Object getColumnValue(String insertCol, ResultSet rs) throws SQLException {
			if (!insertCol.equals("PlanList")) return super.getColumnValue(insertCol, rs);
			
			// plan list
			String planListStr = (String) rs.getObject(insertCol);
			StringTokenizer tzer = new StringTokenizer(planListStr, ",");
			StringBuffer bfer = new StringBuffer();
			while (tzer.hasMoreTokens()) {
				String planIdStr = tzer.nextToken();
				Integer planId = Integer.parseInt(planIdStr);
				Integer krPlanId = this.getDependentId(planTable, planId);
				if (krPlanId != 0) bfer.append(krPlanId + ",");
			}
			if (bfer.toString().trim().length() != 0) {
				planListStr = bfer.substring(0, bfer.length()-1);
			} else {
				planListStr = bfer.toString();
			}
			return planListStr;
		}
	}
	
	public class SystemLogCallbackHandler extends CallbackHandler {

		SystemLogCallbackHandler(UCTable table) {
			super(table);
		}
		
		protected Object getColumnValue(String insertCol, ResultSet rs) throws SQLException {
			if (!insertCol.equals("ObjectID")) return super.getColumnValue(insertCol, rs);
			
			// object id
			String objectType = (String) rs.getObject("ObjectType");
			Integer oId = (Integer) rs.getObject("ObjectId");
			Integer krId = oId;
			if (objectType.equals("pl")) {
				krId = this.getDependentId(planTable, oId);
			} else if (objectType.equals("cr")) {
				krId = this.getDependentId(criticalFunctionTable, oId);
			}
			return krId;
		}
	}
	
	public class SystemDomainCallbackHandler extends CallbackHandler {

		SystemDomainCallbackHandler(UCTable table) {
			super(table);
		}
		
		protected Object getColumnValue(String insertCol, ResultSet rs) throws SQLException {
			if (insertCol.equals("Institution"))
				return "Demonstration Version (Public Access)";
			if (insertCol.equals("AuthType"))
				return "0";
			if (insertCol.equals("AuthLocation"))
				return " ";
			return super.getColumnValue(insertCol, rs);
		}

		protected Map<String, Object> getKRColumns() {
			Map<String, Object> newCols = new HashMap<String, Object>();
			newCols.put("CustomUrl", "demo");
			return newCols;
		}

	}

	public class UserSecurityCallbackHandler extends CallbackHandler {

		UserSecurityCallbackHandler(UCTable table) {
			super(table);
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public void processRow(ResultSet rs) throws SQLException {
			Integer ucId = (Integer) rs.getObject("UserId");
			String email = (String) rs.getObject("EMailRegular");
			List<Integer> krIds = (List<Integer>) jdbcTemplateKRReady.queryForList(
				TABLE_USER_EMAIL_QUERY, 
				new Object[] {krSystemDomainId, email},
				Integer.class);
			if (krIds == null || krIds.isEmpty()) {
				super.processRow(rs);
			} else {
				logger.debug("DUPLICATE USER: UC(" + ucId + ") = KR(" + krIds.get(0) + ")");
				Map<Integer, Integer> idMap = idMaps.get(this.table);
				idMap.put(ucId, krIds.get(0));
			}
		}
		
		protected Object getColumnValue(String insertCol, ResultSet rs) throws SQLException {
			if (!insertCol.equals("AccessStatus")) return super.getColumnValue(insertCol, rs);
			
			// access status
			String email = (String) rs.getObject("EMailRegular");
			String accessStatus = (String) rs.getObject("AccessStatus");
			if (!EmailValidator. getInstance().isValid(email)) {
				logger.debug("INVALID EMAIL: " + email + "");
				accessStatus = "0";
			}
			return accessStatus;
		}
		
		protected Map<String, Object> getKRColumns() {
			Map<String, Object> newCols = new HashMap<String, Object>();
			newCols.put("ModApprovedFlag", new Integer(1));
			return newCols;
		}
	}
}