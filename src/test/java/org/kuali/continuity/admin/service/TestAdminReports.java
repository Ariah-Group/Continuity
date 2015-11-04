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
package org.kuali.continuity.admin.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.kuali.continuity.BasePlanTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class TestAdminReports extends BasePlanTest {
	
	AdmReportService admReportService;
	AdminReportRunService adminReportRunService;
	AdminReportDisplayService adminReportDisplayService =
		new AdminReportDisplayService();
	public void setAdminReportRunService(AdminReportRunService adminReportRunService) {
		this.adminReportRunService = adminReportRunService;
	}
	public void setAdmReportService(AdmReportService admReportService) {
		this.admReportService = admReportService;
	}


	DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void testSortLoad() {
		 String p1="Label 1 part 1, Label 1 part 2'TSA.sort1, sort2|Label 2 part 1, label 2 part 2|sort2, sort1";
		 AdminReport a = new AdminReport("a","b","c");
		 a.loadSortMap(a.splitup(p1));
		 
		 
	}
	public void testCreate(int x) {
		  
		  String [] sorts ="Plan Name/u_plan_name,Plan Status/status,Date of Last Access/last_accessed".split(",");
		  AdminReport ar = new AdminReport("status",
				  "Status of Continuity Plan",
				  "This report lists, plan-by-plan, the completion status, date of last access, date of leadership review.", 
				   sorts);
		  System.out.println(ar.id);
		  
	}
	public void testDataSource(int x) {
		System.out.println("DataSource: ");
		
	}
	public void testOldService1(int x) {
//		AdminReportService ars = AdminReportService.getInstance();
//		Set keyset =ars.reports.keySet();
//
//		AdminReport ar = (AdminReport) ars.reports.get("status");
//		System.out.println(ar.getName());
//		int i=1;
//		for (Object key: keyset) {
//			ar = (AdminReport) ars.reports.get(key);
//			System.out.println(""+(i++)+". "+ar.getName());
//		}
	}
    public void testReport() throws Exception {
    	 String[] params = {"1"}; 
    	 List list = reportRun("SELECT pid, plan_name from plans where institutionId = ?", params, "");
    	 
         
    	
    }
    public void testService() {
    	HashMap reports =admReportService.getReports();
        Set reportKeys = reports.keySet();
        for (Object key : reportKeys) {
        	System.out.print(key.toString());
        	
        }
        SelectionSet selectionSet = new SelectionSet();
        selectionSet.selectedInstitution="1";
        selectionSet.selectedSort=	"Plan Name";
        AdminReport statusAr = (AdminReport) reports.get("status");
        List<String[]> reportData = adminReportRunService.runReport(statusAr, selectionSet);
        String grid=adminReportDisplayService.displayGrid(statusAr, reportData);
        
//        for (String[] row: reportData) {
//        	for (String item: row) {
//        		 System.out.print(item);
//        	 }
//        	 System.out.println("\n");
//        }
        System.out.println(grid);
    }
    public String subsq(String sql, String subs) { 
    	int qloc = sql.indexOf('?');
    	String ret = sql.substring(0,qloc)+subs+sql.substring(qloc+1);
    	return ret;
    }
    public List reportRun(String sql, String[] args, String optional) {
    	 JdbcTemplate jtemplate = new JdbcTemplate(dataSource);
    	 StringRowMapper stringRowMapper = new StringRowMapper();
    	 String sql2run=sql+optional;
    	 String sqlsubs= subsq(sql2run, args[0]);
    	 System.out.println(sqlsubs);
    	 return jtemplate.query(sql2run, args, stringRowMapper);
    	
       
    	
    }
    
    public List reportRunJdbc(String sql, String[] args, String optional) throws SQLException {
   	  Connection conn = dataSource.getConnection();
   	  String sql2run=sql+optional;
   	  PreparedStatement pst = conn.prepareStatement(sql2run);
   	  
   	  if (null!=args)
   	  for (int i=0;i<args.length;i++) {
   		  pst.setString(i, args[i]);
   	  }
       ResultSet rs = pst.executeQuery();
       StringRowMapper stringRowMapper = new StringRowMapper();
       ArrayList list=  new ArrayList();
       int line=0;
       System.out.println("Retrieved: ");
       while (rs.next()) {
    	   list.add(stringRowMapper.mapRow(rs, line));
       }
       return (List) list;
   	 // return jtemplate.query(sqlsubs, stringRowMapper);
   	
       // return jtemplate.query(sql2run, args, stringRowMapper);
      
   	
   }
    public  class StringResultSetExtractor implements ResultSetExtractor {

    	//Override
    	public Object extractData(ResultSet rs) throws SQLException {
    	    ResultSetMetaData rsmd = rs.getMetaData();

    	    int numCols = rsmd.getColumnCount();

    		String[] stringarray = new String[numCols];
    		
    	    for (int i=1;i<=numCols;i++) {
    	    	stringarray[i-1]=rs.getString(i);
    	    }
    		return (Object) stringarray;
    	}

    }
    public class StringRowMapper implements RowMapper {

    	// @Override
    	public Object mapRow(ResultSet rs, int line) throws SQLException {
    		StringResultSetExtractor extractor = new StringResultSetExtractor();
    		return extractor.extractData(rs);
    	}

    }


	public List select(String firstname, String lastname) {
		JdbcTemplate select = new JdbcTemplate(dataSource);
		return select
				.query(
						"select  FIRSTNAME, LASTNAME from PERSON where FIRSTNAME = ? AND LASTNAME= ?",
						new Object[] { firstname, lastname },
						new StringRowMapper());
	}


}
