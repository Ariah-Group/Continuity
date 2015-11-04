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

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.jdbc.core.JdbcTemplate;

public class AdminReportService {
//
//	public static ArrayList<AdminReport> list =  new ArrayList<AdminReport>() {
//		{   
//			System.out.println("AdminReportService: Initialize Report List");
//			
//		    AdminReport statusReport = new AdminReport(
//		    		"status",
//		    		"Status of Continuity Plan",
//		    		"This report lists, plan-by-plan, the completion status, date of last access, date of leadership review.",
//		    		"Plan Name,Plan Status,Date of Last Access",
//		    		"select plan_name, upper(plan_name) u_plan_name, status, last_modified, approved_date, approved_by, acronym.acronym "
//		    			+" from plans left join acronym on plans.acronymid = acronym.acronymid "
//		    			+" where disabled = 'N' and plans.institutionid = #request.userdata.MEMBERINSTITUTIONID#" 
//		    		
//		    		);
//             TotalProcess statusTotalProcess = new TotalProcess() {
//        
//				@Override
//				public String runProcess() {
//					String ret="";
//					
//					
//					return ret;
//				}
//             };
//		    statusReport.setTotalProcess(statusTotalProcess);
//		    
//		    add(statusReport);
//		    
//		    add(new AdminReport(
//		    		"contact",
//		    		"Contact Persons",
//		    		"This report lists, plan-by-plan, the contact persons for the plan."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"building",
//		    		"Location of Departments",
//		    		"This report associates departments with buildings."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"evacuation",
//		    		"Evacuation Plans",
//		    		"This report lists, for each department, the status of building evacuation plans."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"criticalFunctions",
//		    		"Critical Functions",
//		    		"Listing of critical functions by department and by criticality level."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"upstream",
//		    		"Dependencies - Upstream",
//		    		"This report lists each department&#39;s upstream dependencies: the other departments, people, or organizations that the subject department depends on (needs to be functional)."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"downstream",
//		    		"Dependencies - Downstream",
//		    		"This report lists each department&#39;s downstream dependencies: the other departments, people, or organizations that depend on the subject department (need the subject department to be functional)."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"documents",
//		    		"Documents",
//		    		"This report lists all external documents that are named within each plan, indicating which documents have been uploaded into the plan&#39;s database."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"actionItems",
//		    		"Action Items",
//		    		"This report lists action items, with several ways to sort."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"backup",
//		    		"Workstation Backup",
//		    		"This report lists, for each department, the percent utilization of various backup arrangements for desktop computers."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"support",
//		    		"Workstation Support",
//		    		"This report lists, for each department, who provides tech support."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"ITApplications",
//		    		"Centrally-Owned IT Applications",
//		    		"This report lists the central IT applications used by each department, along with the department&#39;s ranking of each application for criticality."
//		    		)
//		       );
//
//		    add(new AdminReport(
//		    		"skills",
//		    		"Skills",
//		    		"This report lists, for each department, some skills, licenses, or certifications that may be needed post-disaster"
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"vendors",
//		    		"Vendors",
//		    		"This report lists vendors identified in plans."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"other",
//		    		"Other Stakeholders",
//		    		"This report lists stakeholders identified in plans (excluding vendors).  Several sorting options are offered."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"strategies",
//		    		"Strategies if Normal Workspace is Unavailable",
//		    		"This report lists strategies identified by departments for carrying on critical functions if the normal workspace is not available."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"available",
//		    		"Personnel Available for Reassignment",
//		    		"This report lists, by department, various categories and numbers of personnel who may be &#34;not-needed&#34; for carrying on critical functions post-disaster, hence available for temporary reassignment elsewhere."
//		    		)
//		       );
//		    add(new AdminReport(
//		    		"staffing",
//		    		"Staffing Requirements During Crisis",
//		    		"This report displays, for certain types of staff, the number of staff required during crisis versus the number required under normal circumstances."
//		    		)
//		       );
//		}
//
//	};
//	public HashMap getReports() {
//		return reports;
//	}
//	public void runSql(AdminReport adminReport, SelectionSet selectionSet) { 
//		// Clean Selection Set 
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        
//		
//	}
//	
//	
//	public static HashMap reports = new HashMap() {
//		{ 
//			for (AdminReport ar : list) {
//    			put(ar.getId(), ar);
//    	    }
//		
//			
//		}
//	};
//	
//	// Eagar
//	static AdminReportService INSTANCE = new AdminReportService() {
//    	{ 
//    		System.out.println("Init static ars");
//    	}
//	};
//	
//    public static AdminReportService getInstance() {
//    	return INSTANCE;
//    }
//	
//	private AdminReportService() {}

}
