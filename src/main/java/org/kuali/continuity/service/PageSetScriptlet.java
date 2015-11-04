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
package org.kuali.continuity.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

import org.kuali.continuity.report.ReportParameterData;
import org.kuali.continuity.util.DataUtil;

/**
 * This Scriptlet moves the page number from the parameter to the PAGE_NUMBER
 * variable
 */
public class PageSetScriptlet extends JRDefaultScriptlet {

	public void afterReportInit() throws JRScriptletException {
		Integer pageNumber = 15;
		try {
			System.out.println("Getting page number");

			pageNumber = (Integer) getParameterValue("PAGE_NUMBER");
			System.out.println("Getting page number: " + pageNumber);

		} catch (Exception e) {
			System.out.println("Page Number Exception:" + e);
		}
		setVariableValue("PAGE_NUMBER", pageNumber);

	}

	public String cost() throws JRScriptletException {
		String ret = "";
		Integer cost = new Integer((String) this.getFieldValue("cost"));

		return ret;
	}

	public String scope() throws JRScriptletException {
		String ret = "";
		Integer scope = new Integer((String) this.getFieldValue("scope"));

		return ret;
	}

	/*
	 * funname Does this piece of CF code <cfloop query="qGetAI"> <cfif
	 * qGetAI.cfnameUpper is not ''> <cfelseif qGetAI.a_type is 'I'> <cfset
	 * qGetAI.cfnameUpper = "INFORMATION TECHNOLOGY" > <cfelseif qGetAI.a_type
	 * is 'G'> <cfset qGetAI.cfnameUpper = "FACULTY PREPAREDNESS" > <cfelse>
	 * <cfset qGetAI.cfnameUpper = "NOT ASSOCIATED WITH A CRITICAL FUNCTION">
	 * </cfif> </cfloop>
	 */
	public String funname() throws JRScriptletException {
		String ret = "";
		String fname = (String) this.getFieldValue("fname");
		String a_type = (String) this.getFieldValue("a_type");
		Integer pis = (Integer) this.getFieldValue("pis");
		
		if (null == fname || fname.trim().length() == 0) {
			if (pis.intValue() != 0){
				ret = "Instruction";
			}else if (a_type.equals("I")) {
				ret = "Information technology";
			} else if (a_type.equals("G")) {
				ret = "Faculty preparedness";
			} else {
				ret = "Not associated with a critical function";
			}
		} else {
			ret = fname;
		}
		return ret;
	}

	public String statname() throws JRScriptletException {
		String status = (String) this.getFieldValue("status");
		String statusname = (String) this.getFieldValue("statusname");
		String ret = statusname;
		if (statusname.startsWith("Please")) {
			ret = "";

		}
		return ret;
	}

	public String position() {
		String ret = "Other";
		try {
			int p = (int) Integer.parseInt((String) super
					.getFieldValue("institution_position"));
			if (p == 1) {
				ret = "Faculty";
			} else if (p == 2) {
				ret = "Staff";
			} else {
				ret = "Other";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	public String broadband() {
		String ret = "No selection";
		try {
			int c = (int) Integer.parseInt((String) super
					.getFieldValue("broadband_connection"));
			if (c == 1) {
				ret = "Yes";
			} else if (c == 2) {
				ret = "No";
			} else if (c == 3) {
				ret = "Probably";
			} else if (c == 4) {
				ret = "Probably not";
			} else if (c == 5) {
				ret = "Don't know";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public String does() {
		String ret = "No selection";
		try {
			int c = (int) Integer.parseInt((String) super
					.getFieldValue("currently_does"));
			if (c == 1) {
				ret = "Yes";
			} else if (c == 2) {
				ret = "No";
			} else if (c == 3) {
				ret = "Probably";
			} else if (c == 4) {
				ret = "Probably not";
			} else if (c == 5) {
				ret = "Don't know";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	public String test() {
		return "return";
	}

	String memberSql = "SELECT kt_id, first_name+' ' +last_name as name "
			+ " from key_team_members" + " where kt_id = ?";

	public String members() {
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		try {
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			Integer id = (Integer) super.getFieldValue("kt_id");

			Map retmap = rpd.getNameValuePairSeries(conn, memberSql, id, ", ");
			ret = (String) retmap.get(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	// SELECT first_name,last_name,kt_id,ktm_id
	// from key_team_members
	// where kt_id =
	public String fteDiff() {
		String ret = "";
		BigDecimal fteNorm;
		try {
			fteNorm = new BigDecimal((String) super.getFieldValue("FTE_normal"));

			BigDecimal fteCrisis = new BigDecimal((String) super
					.getFieldValue("FTE_crisis"));
			BigDecimal diff = fteNorm.subtract(fteCrisis);
			ret = diff.toString();
		} catch (JRScriptletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;

	}
	
	
	String typeOfUnitSql = "select DepartmentType " + 
						   " from plan_department_types pdt, DepartmentType dt " + 
						   " where pdt.pid = ? " + 
						   " and pdt.DepartmentTypeID = dt.DepartmentTypeID";

	@SuppressWarnings("unchecked")
	public String typeOfUnits() {
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		List resultList = null;
		String sep = "\n";
		try {
			Connection conn = (Connection) super.getParameterValue("REPORT_CONNECTION");
			Integer id = (Integer) super.getParameterValue("PID");

			resultList = rpd.getValueListMap(conn, typeOfUnitSql, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int j=0; j < resultList.size(); j++){
			String unit = (String)((Map)resultList.get(j)).get("DepartmentType");
			ret += unit + sep;
		}
		return ret;
	}
	
	String functionSql = "select name, CriticalityLevel from critical_functions where pid=? order by priority,name";

	@SuppressWarnings("unchecked")
	public String functionListString(Boolean isLbnl) {
		System.out.println("getting functions");
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		List resultList = null;
		try {
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			Integer id = (Integer) super.getParameterValue("PID");
			//retList = rpd.getValueList(conn, functionSql, id, ", ");
			//resultMap = rpd.getParameters(conn, functionSql, id);
			resultList = rpd.getValueListMap(conn, functionSql, id);
			System.out.println("I got " + resultList.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 1;
		String sep = "\n";		
		
		for(int j=0; j < resultList.size(); j++){
			String criticalFunction = (String)((Map)resultList.get(j)).get("name");
			String level = "";
			if( ((Map)resultList.get(j)).get("CriticalityLevel") != null){
				if (((String)((Map)resultList.get(j)).get("CriticalityLevel")).equals("0")){
					level = "Criticality Not Rated";
				} else{
					level = this.getCriticalityLevel(true, (String)((Map)resultList.get(j)).get("CriticalityLevel"));
				}
			}
			ret += "" + (i++) + "   " + criticalFunction + " -- " + level + sep;
		}
		
		return ret;
	}
	
	String cfCriticalityLevelsSql = 
		"select 1 inst, sdclf.LevelNo lvl, sdclf.Name name, sdclf.descr descr, sdclf.LongDescr longdescr from SystemDomainCriticalLevelFunc sdclf, plans p "
			+ "where sdclf.institutionid = p.institutionid and p.pid = ? "
	        + "union "
	        + "select 0 inst, LevelNo lvl, Name name, Descr descr,  LongDescr longdescr from SystemCriticalLevelFunc "
	        + "order by inst, lvl";
	
	public String cfCriticalityLevels() {
		return this.getCriticalityLevels(true);
	}
 
	String itCriticalityLevelsSql = 
		"select 1 inst, sdcla.LevelNo lvl, sdcla.Name name, sdcla.descr descr, sdcla.LongDescr longdescr from SystemDomainCriticalLevelAppl sdcla, plans p "
			+ "where sdcla.institutionid = p.institutionid and p.pid = ? "
	        + "union "
	        + "select 0 inst, LevelNo lvl, Name name, Descr descr, LongDescr longdescr from SystemCriticalLevelAppl "
	        + "order by inst, lvl";
	
	public String itCriticalityLevels() {
		return this.getCriticalityLevels(false);
	}
	
	@SuppressWarnings("unchecked")
	private String getCriticalityLevels(boolean isCF) {
		String clSql = (isCF ? cfCriticalityLevelsSql : itCriticalityLevelsSql);
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		Map<String, String> clMap = new TreeMap<String, String>();
		try {
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			Integer id = (Integer) super.getParameterValue("PID");
			List resultList = rpd.getValueListMap(conn, clSql, id);
			for(int j=0; j < resultList.size(); j++){
				String lvlNo = (String)((Map)resultList.get(j)).get("lvl");
				String lvlName = (String)((Map)resultList.get(j)).get("name");
				String lvlDesc = (String)((Map)resultList.get(j)).get("descr");
				String lvlLongDesc = (String)((Map)resultList.get(j)).get("longdescr");
				if (isCF) 
					clMap.put(lvlNo, lvlDesc);
				else
					clMap.put(lvlNo, lvlName + ":  " + lvlLongDesc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String sep = "\n";
		for (String descr : clMap.values()) {
			ret += descr + sep;
		}
		return ret;		
	}
	
	String cfCriticalityLevelSql = 
		"select sdclf.Name from SystemDomainCriticalLevelFunc sdclf, plans p "
			+ "where sdclf.institutionid = p.institutionid and p.pid = ? and sdclf.LevelNo = ?";
	String cfDefCriticalityLevelSql =
		"select Name from SystemCriticalLevelFunc where LevelNo = ?";

	public String cfCriticalityLevel(String levelNo) {
		if ("0".equals(levelNo)) return "Criticality Not Rated";
		return this.getCriticalityLevel(true, levelNo);
	}
	
	String itCriticalityLevelSql = 
		"select sdcla.Name from SystemDomainCriticalLevelAppl sdcla, plans p "
			+ "where sdcla.institutionid = p.institutionid and p.pid = ? and sdcla.LevelNo = ?";
	String itDefCriticalityLevelSql =
		"select Name from SystemCriticalLevelAppl where LevelNo = ?";

	public String itCriticalityLevel(String levelNo) {
		if ("0".equals(levelNo)) return "Not important";
		return this.getCriticalityLevel(false, levelNo);
		
	}
	
	@SuppressWarnings("unchecked")
	private String getCriticalityLevel(boolean isCF, String levelNo) {
		String clSql = (isCF ? cfCriticalityLevelSql : itCriticalityLevelSql);
		String clDefSql = (isCF ? cfDefCriticalityLevelSql : itDefCriticalityLevelSql);
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		try {
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			Integer id = (Integer) super.getParameterValue("PID");
			List parmList = new ArrayList();
			parmList.add(id);
			parmList.add(levelNo);
			Map<String, String> resultMap = rpd.getParameters(conn, clSql, parmList);
			if (resultMap == null || resultMap.isEmpty()) {
				resultMap = rpd.getParameters(conn, clDefSql, levelNo);
			}
			if (resultMap != null && !resultMap.isEmpty()) {
				ret = resultMap.get("Name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;		
	}
 
	String buildingSql = "select BuildingName, Ownership, pb.BuildingComment from plan_buildings pb join Building b on pb.BuildingID = b.BuildingID where pb.pid=?";

	@SuppressWarnings("unchecked")
	public String buildingString() {
		System.out.println("getting building");
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		// List<String> retList = null;
		Map resultMap = null;
		try {
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			Integer id = (Integer) super.getParameterValue("PID");
			// retList = rpd.getValueList(conn, buildingSql, id, ",");
			resultMap = rpd.getParameters(conn, buildingSql, id);
			System.out.println("I got building list size at: "
					+ resultMap.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (((String) resultMap.get("Ownership")).equals("1")) {
			ret = ((String) resultMap.get("BuildingName")) + "		" + "Owned";
		} else {
			ret = ((String) resultMap.get("BuildingName")) + "		"
					+ "Not Owned";
		}
		
		if( resultMap.get("BuildingComment") != null && !"".equals((String)resultMap.get("BuildingComment"))){
			ret +=  "		" + (String)resultMap.get("BuildingComment");
		}
		return ret;
		// return (String)retList.get(0);
	}

	public String peakPeriods() {
		String[] months = "Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec"
				.split(" ");
		String ret = "";
		try {
			for (String s : months) {
				String fld = "peak_" + s.toLowerCase();
				String ismo = (String) this.getFieldValue(fld);
				if (ismo.equals("Y")) {
					ret += s + " ";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	String contactSql = "select FirstName + ' ' + LastName as ContactName "
			+ " from UserSecurity US, plan_contacts pc " + " where pc.pid = ? "
			+ " and pc.UserID = US.UserID  ";

	public String contactString() {
		System.out.println("getting functions");
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		List<String> retList = new ArrayList<String>();
		try {
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			Integer id = (Integer) super.getParameterValue("PID");
			retList = rpd.getValueList(conn, contactSql, id, ", ");
			System.out.println("I got " + retList.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 1;
		String sep = "";
		for (String s : retList) {
			ret += sep + s;
			sep = ", ";
		}
		return ret;
	}

	String streamSql = " select  d.Dependency "
			+ " from Dependency d, cf_dependency c "
			+ " where c.DependencyID = d.DependencyID "
			+ " and c.cid = ? " + " and d.DependencyType=";

	public String stream(int dir) {
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		List<String> retList = new ArrayList<String>();
		try {
			Integer id = (Integer) this.getFieldValue("cid");
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			// Integer id = (Integer) super.getParameterValue("PID");
			retList = rpd.getValueList(conn, streamSql + dir, id, ", ");
			System.out.println("I got " + retList.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i = 1;
		String sep = "";
		for (String s : retList) {
			ret += sep + s;
			sep = ", ";
		}
		return ret;

	}

	public String upstream() {
		return stream(1);
	}

	public String downstream() {
		return stream(0);
	}

	// Front3
	String countFormat = "%s   Faculty & other academic appointees \n"
			+ "%s   Residents/Fellows \n" 
			+ "%s   Staff (full-time) \n"
			+ "%s   Staff (part-time, excl. student-staff) \n"
			+ "%s   Student-staff \n" 
			+ "%s   Volunteers \n" 
			+ "%s   Guests \n"
			+ "%s   Other";

	public String formatCounts(Integer c1, Integer c2, Integer c3, Integer c4,
			Integer c5, Integer c6, Integer c7, Integer c8) {
		String counts = String.format(countFormat, c1, c2, c3, c4, c5, c6, c7,
				c8);
		System.out.println(counts);
		return counts;

	}

	String consequenceSql = " SELECT  con_disruption_teaching,con_disruption_teaching_explain,con_disruption_research, "
			+ " con_disruption_research_explain,con_loss_faculty,con_loss_faculty_explain,con_loss_staff, "
			+ " con_loss_staff_explain,con_loss_students,con_loss_students_explain,con_well_being_staff, "
			+ " con_well_being_staff_explain,con_well_being_students,con_well_being_students_explain, "
			+ " con_payment_deadline,con_payment_deadline_explain,con_loss_revenue,con_loss_revenue_explain, "
			+ " con_legal_obligations,con_legal_obligations_explain,con_legal_harm,con_legal_harm_explain, "
			+ " con_impact_other_campus,con_impact_other_campus_explain,con_impact_business,con_impact_business_explain, "
			+ " con_other,con_other_explain,con_disruption_patientcare,con_disruption_patientcare_explain "
			+ " from critical_functions where cid = ? and pid = ? and disabled <> 'Y';";

	@SuppressWarnings("unchecked")
	public String consequenceBuild() {
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		Map resultMap = null;
		try {
			Integer cid = (Integer) this.getFieldValue("cid");
			Integer pid = (Integer) super.getParameterValue("PID");
			System.out.println("cid is:  " + cid.toString() + "	  , PID is: "
					+ pid.toString());
			List<Integer> parmList = new ArrayList<Integer>();
			parmList.add(cid);
			parmList.add(pid);
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			resultMap = rpd.getParameters(conn, consequenceSql, parmList);
			System.out.println("I got " + resultMap.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int lineSize = 45;
		String sep = "\n";
		char pad = ' ';
		int padSize = 42;
		int paddingSize = 45;
		String padding = DataUtil.padGenerator(padSize + 17, pad);

		if (((String) resultMap.get("con_disruption_teaching")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_disruption_teaching_explain")), lineSize,
					sep);
			String key = DataUtil.postPaddingSpace("Disruption of teaching",
					paddingSize, pad);
			System.out.println("value is: " + value);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_disruption_research")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_disruption_research_explain")), lineSize,
					sep);
			String key = DataUtil.postPaddingSpace("Disruption of research",
					paddingSize, pad);
			System.out.println("value is: " + value);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_disruption_patientcare")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_disruption_patientcare_explain")),
					lineSize, sep);
			String key = DataUtil.postPaddingSpace(
					"Disruption of patient care", paddingSize, pad);
			System.out.println("value is: " + value);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_loss_faculty")).equals("1")) {
			String value = DataUtil.formatString(padding,
					DataUtil.nonulls((String) resultMap
							.get("con_loss_faculty_explain")), lineSize, sep);
			String key = DataUtil.postPaddingSpace("Departure of faculty",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_loss_staff")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap.get("con_loss_staff_explain")),
					lineSize, sep);
			String key = DataUtil.postPaddingSpace("Departure of staff",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_loss_students")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_loss_students_explain")), lineSize, sep);
			String key = DataUtil.postPaddingSpace("Departure of students",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_well_being_staff")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_well_being_staff_explain")), lineSize,
					sep);
			String key = DataUtil.postPaddingSpace(
					"Well-being of faculty/staff", paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_well_being_students")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_well_being_students_explain")), lineSize,
					sep);
			String key = DataUtil.postPaddingSpace("Well-being of students",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_payment_deadline")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_payment_deadline_explain")), lineSize,
					sep);
			String key = DataUtil.postPaddingSpace("Payment deadlines unmet",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_loss_revenue")).equals("1")) {
			String value = DataUtil.formatString(padding,
					DataUtil.nonulls((String) resultMap
							.get("con_loss_revenue_explain")), lineSize, sep);
			String key = DataUtil.postPaddingSpace("Loss of revenue",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_legal_obligations")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_legal_obligations_explain")), lineSize,
					sep);
			String key = DataUtil.postPaddingSpace("Legal obligations unmet",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_legal_harm")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap.get("con_legal_harm_explain")),
					lineSize, sep);
			String key = DataUtil.postPaddingSpace(
					"Legal harm to the University", paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_impact_other_campus")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap
							.get("con_impact_other_campus_explain")), lineSize,
					sep);
			String key = DataUtil.postPaddingSpace("Impact on other unit(s)",
					paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_impact_business")).equals("1")) {
			String value = DataUtil
					.formatString(padding, DataUtil.nonulls((String) resultMap
							.get("con_impact_business_explain")), lineSize, sep);
			String key = DataUtil
					.postPaddingSpace(
							"Impact on important business partner(s)",
							paddingSize, pad);
			ret += key + value + sep;
		}

		if (((String) resultMap.get("con_other")).equals("1")) {
			String value = DataUtil.formatString(padding, DataUtil
					.nonulls((String) resultMap.get("con_other_explain")),
					lineSize, sep);
			String key = DataUtil.postPaddingSpace("Other", paddingSize, pad);
			ret += key + value + sep;
		}

		return ret;
	}

	String temp1Sql = " select lookupvalue as lv, lookupdescription as ld "
			+ " from descriptionlookup where lookupname = 'InstructionSelect1'"
			+ " and lookupvalue = ? ";
	String temp2Sql = " select lookupvalue as lv, lookupdescription as ld "
			+ " from descriptionlookup where lookupname = 'InstructionSelect2'"
			+ " and lookupvalue = ? ";
	String temp3Sql = " select lookupvalue as lv, lookupdescription as ld "
			+ " from descriptionlookup where lookupname = 'InstructionSelect3'"
			+ " and lookupvalue = ? ";

	public String tempQuery(int queryNum, String parm) {
		String ret = "";
		ReportParameterData rpd = new ReportParameterData();
		try {
			Connection conn = (Connection) super
					.getParameterValue("REPORT_CONNECTION");
			if (queryNum == 1) {
				String lv = (String) super.getFieldValue(parm);
				Map retmap = rpd.getParameters(conn, temp1Sql, lv);
				ret = (String) retmap.get("ld");
			} else if (queryNum == 2) {
				String lv = (String) super.getFieldValue(parm);
				Map retmap = rpd.getParameters(conn, temp2Sql, lv);
				ret = (String) retmap.get("ld");
			}
			if (queryNum == 3) {
				String lv = (String) super.getFieldValue(parm);
				Map retmap = rpd.getParameters(conn, temp3Sql, lv);
				ret = (String) retmap.get("ld");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public String qTemp1() {
		return tempQuery(1, "b_bspace_usage");
	}

	public String qTemp2() {
		return tempQuery(2, "b_bspace_expand");
	}

	public String qTemp3() {
		return tempQuery(1, "b_bspace_grade_usage");
	}

	public String qTemp4() {
		return tempQuery(2, "b_bspace_grade_expand");
	}

	public String qTemp5() {
		return tempQuery(1, "b_gsi_communication_usage");
	}

	public String qTemp6() {
		return tempQuery(2, "b_gsi_communication_expand");
	}

	public String qTemp7() {
		return tempQuery(1, "b_common_materials_usage");
	}

	public String qTemp8() {
		return tempQuery(2, "b_common_materials_expand");
	}

	public String qTemp9() {
		return tempQuery(3, "c_prioritize_course");
	}

	public String qTemp10() {
		return tempQuery(3, "c_communication");
	}

	public String qTemp11() {
		return tempQuery(3, "c_backup_personnel");
	}

	public String qTemp12() {
		return tempQuery(3, "c_faculty_recall");
	}

	public String qTemp13() {
		return tempQuery(3, "c_pedagogy");
	}
}
