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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.kuali.continuity.admin.domain.SystemDomainCentralApplicationCriticalityLevel;
import org.kuali.continuity.admin.service.util.PlanString;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.report.HeaderParameterData;

public class AdminReportServiceImpl implements AdmReportService {
	AdminReportRunService adminReportRunService;
	AdminReportDisplayService adminReportDisplayService = new AdminReportDisplayService();
	SystemDomainCriticalityLevelService systemDomainCriticalityLevelService;

	public void setAdminReportRunService(
			AdminReportRunService adminReportRunService) {
		this.adminReportRunService = adminReportRunService;
	}

	public void setAdminReportDisplayService(
			AdminReportDisplayService adminReportDisplayService) {
		this.adminReportDisplayService = adminReportDisplayService;
	}

	public void setSystemDomainCriticalityLevelService(
			SystemDomainCriticalityLevelService systemDomainCriticalityLevelService) {
		this.systemDomainCriticalityLevelService = systemDomainCriticalityLevelService;
	}

	/**
	 * None of this changes during execution. Place them in the order and
	 * numbering that they are to have in the Reports menu
	 */
	static ArrayList<AdminReport> list = new ArrayList<AdminReport>() {
		{
			// ? symbolizes #request.userdata.MEMBERINSTITUTIONID#
			System.out
					.println("AdminReportServiceImpl: Initialize Report List");
			System.out.println("AdminReportServiceImpl: statusReport");

			/**
			 * AdminReport has the general constructor form:
			 * 	   id, 
			 *    title, 
			 *    description, 
			 *    sorts, 
			 *    select, 
			 *    exclusion-clause
			 * This particular AdmInReport also requires an override to build rows in a different way,and contains a TotalProcess
			 */
			AdminReport statusReport = new AdminReport(
					"status",
					"Status of Continuity Plans",
					"This report lists, plan-by-plan, the completion status, plus the dates of last access, completion, and annual review.",
					"Plan Name/plannamekey,Plan Status/status,Last Access/last_modified, Completion/completion_date, Annual Review/annual_review_date",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, status, last_modified, approved_date, approved_by, acronym.acronym "
							+ ", isnull(acronym.acronym,'')+upper(plan_name) plannamekey, "
							+ " max(prc.review_date) completion_date, max(pra.review_date) annual_review_date" 
							+ " from plans left join acronym on plans.acronymid = acronym.acronymid "
							+ " left outer join plan_reviewers prc on plans.pid = prc.pid and prc.review_type = 'C' "
							+ " left outer join plan_reviewers pra on plans.pid = pra.pid and pra.review_type = 'A' "
							+ " where disabled = 'N' and plans.institutionid = ? "
							+ " group by isnull(acronym.acronym+' - ','')+plan_name, status, last_modified, "
							+ " approved_date, approved_by, acronym.acronym, isnull(acronym.acronym,'')+upper(plan_name) ",  
 					"Plan Name,Plan Status,Last Access,Completion,Annual Review"
                    // Has no exclusion
			) {
				@Override
				public StringBuffer buildRows(List<String[]> list, String[] heads) {
					StringBuffer retb = new StringBuffer();

					for (String[] cols : list) {
						retb.append( "<TR>");
						retb.append("<TD>"); // Column 1 is ABR - name

						// if (null!=row[6] && row[6].length()>0) {
						// ret+=row[6]+" - ";
						// }
						retb.append(cols[0] + "</TD>");
						
						retb.append("<TD>" + status(cols[1]) + "</TD>"); // Status

						retb.append("<TD>" + cols[2] + "</TD>"); // Date
						retb.append("<TD>" + cols[7] + "</TD>"); // Date
						retb.append("<TD>" + cols[8] + "</TD>"); // By

						retb.append("</TR>");
					}
					return retb;
				}

				public String status(String statin) {
					String ret = "";
					if (statin.equals("C")) {
						ret = "Complete";
					}
					if (statin.equals("N")) {
						ret = "In&nbsp;Progress";
					}
					return ret;
				}

				public String by(String in) {
					String ret = in;
					if (ret.length() == 0) {
						ret = "to be supplied";
					}
					return ret;
				}

			};
			
			TopBand statusTotalProcess = new TopBand() {

				@Override
				public String runProcess(DataSource dataSource, AdminReport ar, SelectionSet selectionSet) {
					String fmt =
						
					    "<table cellspacing=0 cellpadding=0 bgcolor=white border=0 style=\"width:250px;\"> "
					  + " <tr bgcolor=white><td bgcolor=white style=\"font-size:12px;padding:0;\" align=\"right\">Total Number of Completed Plans:&nbsp;</td><td style=\"font-size:12px;padding:0;\" align=\"right\">&nbsp;%s</td></tr>\n"
					  + " <tr bgcolor=white><td bgcolor=white style=\"font-size:12px;padding:0;\" align=\"right\">Total Number of In Progress Plans:&nbsp;</td><td style=\"font-size:12px;padding:0;\" align=\"right\">&nbsp;%s</td></tr>\n"
					  + " <tr bgcolor=white><td bgcolor=white style=\"font-size:12px;padding:0;\" align=\"right\">Total Number of Plans:&nbsp;</td><td style=\"font-size:12px;padding:0;\" align=\"right\">&nbsp;%s</td></tr>\n"
				      + "</table>\n";
					// Basic argument list and whereand.
					ArrayList<String> argList = new ArrayList();
					argList.add(selectionSet.selectedInstitution);
					
					String whereand="";
					
		
					
				   String args[] = new String[argList.size()];
				   
				   String sql1a = "select count(*) as total  from plans left join acronym on plans.acronymid  = acronym.acronymid where status = 'C' and disabled = 'N' and plans.institutionid = ? ";
				   String sql2a = "select count(*) as total from plans left join acronym on plans.acronymid = acronym.acronymid where status = 'N' and disabled = 'N' and plans.institutionid = ?";
				   String sql1 = "select count(*) as total  from plans  where status = 'C' and disabled = 'N' and plans.institutionid = ? ";
				   String sql2 = "select count(*) as total from plans  where status = 'N' and disabled = 'N' and plans.institutionid = ?";
				   
				   
				   String planString = PlanString.parse(selectionSet.selectedPlan, ar);

					HeaderParameterData hpd = new HeaderParameterData();	   
				   int tc =0;
				   int ti =0;
				  
				   int si =Integer.parseInt(selectionSet.selectedInstitution);
				   String running="tc query 1: +sql1";
				   try {
					   Connection conn  = dataSource.getConnection();
					   tc = hpd.getCountData(conn, sql1, si);
					   running="ti query 2: +sql2";
					   ti = hpd.getCountData(conn, sql2, si);
				   } catch (Exception e) {
					   System.out.println("Exception "+e+"Unable to run query: "+running);
					   e.printStackTrace();
				   }
//				   List<String[]> out1=runService.runSql(sql1,args, planString);		   
//				   tc=getFirstInt(out1);
//				   List<String[]> out2=runService.runSql(sql2,args, planString);
//				   ti=getFirstInt(out1);
				   
				   int ta = tc+ ti;
                   String ret = String.format(fmt,tc,ti,ta);
					
					return ret;
				}
				public int getFirstInt(List<String[]> result) {
					int ret=0;
					 String[] oa = result.get(0);
					 String sa = oa[0];
					 ret = Integer.parseInt(sa);
					return ret;
				}
			};
			statusReport.setTopBandProcess(statusTotalProcess);
			add(statusReport);

			add(new AdminReport(
					"contact",
					"Contact Persons",
					"This report lists, plan-by-plan, the contact persons for the plan.",
					"Plan Name/plannamekey, contacttype desc`First Name/name`Last Name/usersecurity.lastname, usersecurity.firstname",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan,   usersecurity.firstname+' '+usersecurity.lastname name,  usersecurity.emailregular"
							+ ", isnull(acronym.acronym,'')+upper(plan_name) plannamekey "
							+ " from ((plans left join plan_contacts on plans.pid = plan_contacts.pid)"
							+ " left join usersecurity on plan_contacts.userid = usersecurity.userid)"
							+ " left join acronym on plans.acronymid = acronym.acronymid"
							+ " 	where plans.disabled = 'N' and plans.institutionid = ?",
					"Plan Name,Contact Person(s),email address",
					"where \"contact person\" has no data.", "plan_contacts.userid"));

			AdminReport building = new AdminReport("building",
					"Location of Departments",
					"This report associates departments with buildings.",
					"Building Name:u_buildingcommonname, Department:plannamekey, Owned/Rented:u_ownership", 
					"select buildingcommonname, isnull(acronym.acronym+' - ','')+plan_name displayplan, ownership,  buildingcomment, building.buildingid,  upper(buildingcommonname) u_buildingcommonname, ownership, upper(ownership) u_ownership"
					 + ", isnull(acronym.acronym,'')+upper(plan_name) plannamekey " 
					 +" from (plans left join acronym on plans.acronymid = acronym.acronymid)"
					 +" left join plan_buildings on plans.pid = plan_buildings.pid"
					 +" left join building on plan_buildings.buildingid = building.buildingid"
					  +" where plans.disabled = 'N' and plans.institutionid = ? ",
					"Building Name,Department,Owned/rented,Comment",
					"where Building Name has no data","building.buildingid") {
				@Override
				public StringBuffer buildRows(List<String[]> list, String[] heads) {
					StringBuffer retb = new StringBuffer();
					String ret = "";

					for (String[] cols : list) {
						ret += "<TR>";
						ret += "<TD>"; // Column 1 is ABR - name

						// if (null!=row[6] && row[6].length()>0) {
						// ret+=row[6]+" - ";
						// }
						ret += cols[0] + "</TD>";
						ret += "<TD>" + cols[1] + "</TD>"; // Status

						ret += "<TD>" + owned(cols[2]) + "</TD>"; // Date
						ret += "<TD>" + cols[3] + "</TD>"; // Date
				

						ret += "</TR>";
					}
					retb.append(ret);  // Fast refactor.
					return retb;
			
				}

			
				String owned(String strin) {
					String ret="Not owned";
					if (null!=strin && strin.trim().equals("1")) {
						ret="Owned";
					}
					return ret;
				}
			};
			String specialSelectionSql="select buildingname description, buildingid id from building where institutionid=? ";
			
			building.setSpecialSelectionSql(specialSelectionSql);
			building.setSpecialSelectionClause(" and building.buildingid = ? ");
			building.setSpecialName("Buildings");
			add(building);
			AdminReport evacuation =new AdminReport(
					"evacuation",
					"Evacuation Plans",
					"This report lists, for each department, the status of building evacuation plans.",
					"Department/plannamekey, Answer/evacuation_plan",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, isnull(d.lookupdescription,''), evacuation_plan"
					    +" , isnull(acronym.acronym,'')+upper(plan_name) plannamekey "
					    +" from plans left join acronym on plans.acronymid = acronym.acronymid"
				        +" left join descriptionlookup d on d.LookupName='EvacuationPlan' and evacuation_plan=d.lookupvalue"
				        +" where disabled = 'N' and plans.institutionid = ?",
				    "Department, Do all bldgs occupied by this dept have evacuation plans?",
					"that have no data in this field.  ","evacuation_plan <> '0' AND evacuation_plan ") {
			};
			// evacuation.setSpecialSelectionSql(""); // Just remove plan pulldown.
			add(evacuation);
			add(new AdminReport(
					"criticalFunctions",
					"Critical Functions",
					"Listing of critical functions by department and by criticality level.",
					"Plan name, Criticality level:plannamekey,TCF.criticalitylevel`Criticality level, Plan Name:TCF.criticalitylevel,plannamekey",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan,  TCF.name,  case when SDCLF.name is not null then SDCLF.name else SCLF.name end levelname"
					  +", isnull(acronym.acronym,'')+upper(plan_name) plannamekey,  TCF.criticalitylevel"
					  +" from plans left join acronym on plans.acronymid = acronym.acronymid  "
					  +" left join (select * from critical_functions as TCF where disabled = 'N') TCF on plans.pid = TCF.pid "
					  +" left join (select * from systemdomaincriticallevelfunc as SDCLF) SDCLF on SDCLF.levelno = TCF.criticalitylevel and SDCLF.institutionid = plans.institutionid "
					  +" left join (select * from systemcriticallevelfunc as SCLF) SCLF on SCLF.levelno = TCF.criticalitylevel "
					  +" where plans.disabled = 'N' and plans.institutionid = ?  ",
					"Plan Name,Critical Function,Criticality Level",
					"where the Critical Function field has no data. ","cid"));
			add(new AdminReport(
					"upstream",
					"Dependencies - Upstream",
					"This report lists each department's upstream dependencies: the other departments, people, or organizations that the subject department depends on (needs to be functional).",
					"Upstream Dept, Subject Dept:dependency,TCF.name`Subject Dept, Upstream Dept:TCF.name,dependency`Criticality Level, Subject Dept:TCF.criticalitylevel,TCF.name",
					"select  dependency, isnull(acronym.acronym+' - ','')+plan_name displayplan,TCF.name, TCF.criticalitylevel, upper(dependency) u_dependency, "
							+ " isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
							+ " from (plans left join acronym on plans.acronymid = acronym.acronymid)"
							+ " left join (select * from critical_functions as TCF where disabled = 'N') TCF on plans.pid = TCF.pid"
							+ " left join (select CFD.cid, dependency.dependency from cf_dependency CFD, dependency"
							+ " where CFD.dependencyid = dependency.dependencyid and dependency.DependencyType = '1') CFD on TCF.cid = CFD.cid"
							+ " where plans.disabled = 'N' and plans.institutionid = ? ",
					"Upstream Dept,Subject Dept,Critical Function,Criticality Level",
					"where the Upstream Department field has no data.","CFD.cid"));
			add(new AdminReport(
					"downstream",
					"Dependencies - Downstream",
					"This report lists each department's downstream dependencies: the other departments, people, or organizations that depend on the subject department (need the subject department to be functional).",
					"Downstream Dept, Subject Dept:dependency,TCF.name`Subject Dept, Downstream Dept:TCF.name,dependency`Criticality Level, Subject Dept:TCF.criticalitylevel,TCF.name",
					"select dependency, isnull(acronym.acronym+' - ','')+plan_name displayplan,TCF.name, TCF.criticalitylevel, upper(dependency) u_dependency, "
							+ " isnull(acronym.acronym,'')+upper(plan_name) plannamekey "
							+ " from (plans left join acronym on plans.acronymid = acronym.acronymid)"
							+ " left join (select * from critical_functions as TCF where disabled = 'N') TCF on plans.pid = TCF.pid"
							+ " left join (select CFD.cid, dependency.dependency from cf_dependency CFD, dependency"
							+ " where CFD.dependencyid = dependency.dependencyid and dependency.DependencyType = '0') CFD on TCF.cid = CFD.cid"
							+ " where plans.disabled = 'N' and plans.institutionid = ? ",
					"Downstream Dept,Subject Dept,Critical Function,Criticality Level",
					"where the Downstream Department field has no data.", "CFD.cid"));
			add(new AdminReport(
					"documents",
					"Documents",
					"This report lists all external documents that are named within each plan, indicating which documents have been uploaded into the plan's database.",
					"Plan Name, Document Name/plannamekey, u_name`Uploaded?, Plan Name/uploaded, plannamekey",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, name, description, case when (original_file_name is not null and original_file_name <> '') then 'Yes' else 'No' end uploaded, key_plan_documents.comment, mediumID, location_kept,  owner_department, contacts, original_file_name, backup_measures,  upper(name) u_name, kpd_id as kd_id"
							+ " , isnull(acronym.acronym,'')+upper(plan_name) plannamekey "
							+ " from plans left join acronym on plans.acronymid = acronym.acronymid"
							+ " inner join key_plan_documents on plans.pid = key_plan_documents.pid"
							+ " where plans.disabled = 'N' and plans.institutionid = ? ",
					"Plan Name,Name of Document,Description,Uploaded?,Comment"));
			add(new AdminReport(
					"actionItems",
					"Action Items",
					"This report lists action items, with several ways to sort.",
					"Plan Name, Critical Function/plannamekey, cf_name`Cost, Plan Name/ cost, plannamekey`Status, Plan Name/status, plannamekey`Within whose scope, Plan Name/scope_lower, plannamekey",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, CF.name cf_name, AI.name ai_name, L.lookup_item_desc,  AI.cost_is, AI.scope, AI.comment,   AI.status,  AI.a_id, AI.a_type, AI.cost "
							+ " , isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
							+ " from (plans left join acronym on plans.acronymid = acronym.acronymid)"
							+ " left join (select * from action_items AI where disabled = 'N') AI on plans.pid = AI.pid"
							+ " left join (select * from critical_functions as CF where disabled = 'N') CF on AI.cid = CF.cid"
							+ " left join (select lookup_item_id, lookup_item_desc from lookup_items as L where lookup_id = 19 and lookup_item_no <> 1) L on AI.cost = L.lookup_item_id"
							+ " where plans.disabled = 'N' and plans.institutionid = ?",
					"Plan Name,Critical Function,Action Item,Cost,Cost is,Within whose scope,Comment,Status",
					"that have no action items.", "AI.a_id"));
			add(new AdminReport(
					"backup",
					"Workstation Backup",
					"This report lists, for each department, the percent utilization of various backup arrangements for desktop computers.",
					"",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, it_ws_file, it_ws_ucb, it_ws_local_auto, it_ws_local_manu, "
							+ " it_ws_other, it_ws_no_backup, it_ws_not_know"
							+ " , isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
							+ " from (plans left join acronym on plans.acronymid = acronym.acronymid)"
							+ " where plans.disabled = 'N' and plans.institutionid = ?",
					"Plan Name,Dept server,Central IT backup,By user(auto),by user(man),Other,No backup,Don't know",
					"that have no data in these fields. "
					,"it_ws_file <> '' and it_ws_ucb <> '' and it_ws_local_auto <> '' and it_ws_local_manu <> '' and it_ws_other <> '' and it_ws_no_backup <> '' and it_ws_not_know <> '' and it_ws_file"
					));
			add(new AdminReport(
					"support",
					"Workstation Support",
					"This report lists, for each department, who provides tech support.",
					"",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, it_ws_support_dept_flag, it_ws_support_dept_comment,"
							+ " it_ws_support_campus_flag, it_ws_support_campus_comment, it_ws_support_vendor_flag,"
							+ " it_ws_support_vendor_comment, it_ws_support_other_flag, it_ws_support_other_comment"
							+ " , isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
							+ " from (plans left join acronym on plans.acronymid = acronym.acronymid)"
							+ " where plans.disabled = 'N' and plans.institutionid = ? ",
					"Plan Name,Techs from this dept,Comment,Techs from another dept,Comment,By Vendor,Comment,by Other,Comment",
					"that have no data in these fields. "));
			AdminReport iTApplications = new AdminReport(
					"ITApplications",
					"Centrally-Owned IT Applications",
					"This report lists the central IT applications used by each department, along with the department's ranking of each application for criticality.",
					"Application, Plan Name/u_name, plannamekey`Plan Name, Application/plannamekey, u_name",
					"select CA.name, isnull(acronym.acronym+' - ','')+plan_name displayplan,  ICA.criticalitylevel, ICA.comment,  upper(CA.name) u_name, ICA.recordid"
					  +" , isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
					  +" from (plans left join acronym on plans.acronymid = acronym.acronymid)"
					  +" left join it_central_applications ICA on plans.pid = ICA.pid"
					  +" left join centralapplication CA on ICA.centralapplicationid = CA.centralapplicationid"
					  +" where plans.disabled = 'N' and plans.institutionid = ?", 
					"Application,Plan Name,Not Imp,Critical 1,Critical 2,Critical 3,Deferrable,Comment",
					"that have no data in the Application field.","ICA.recordid") {
				@Override
				public StringBuffer buildRows(List<String[]> list, String[] heads) {
					StringBuffer retb = new StringBuffer();
					String ret = "";

					for (String[] cols : list) {
						retb.append("<TR>");
						retb.append("<TD>" + cols[0] + "</TD>");
						retb.append("<TD>" + cols[1] + "</TD>");
						int criticality =5;
						if (null!=cols[2] && cols[2].length()>0) {
							char c = cols[2].charAt(0);
							if (c>='0' && c<='9') {
								criticality= Integer.parseInt(""+c);
							} 
						} else {
							criticality=5;
						}
						retb.append( "<TD>" + xit(criticality, 0) + "</TD>"); // Criticality
						retb.append( "<TD>" + xit(criticality, 1) + "</TD>");
						retb.append( "<TD>" + xit(criticality, 2) + "</TD>");
						retb.append( "<TD>" + xit(criticality, 3) + "</TD>");
						retb.append( "<TD>" + xit(criticality, 4) + "</TD>");
						retb.append( "<TD>" + cols[3] + "</TD>");
						retb.append( "</TR>");
					}
					
					return retb;
				}

				public int getVal(String isit) {
					
					int ret = 5; // Won't show if value is not numeric
					if (null != isit && isit.length() > 0) {
						Character isitChar = isit.charAt(0);
						if (isitChar >= '0' && isitChar <= '9') {
							ret = Integer.parseInt(isitChar.toString());
						}
					}
					return ret;
				}

				public String xit(int isitval, int that) {
					String ret = "&nbsp;";

					if (isitval == that) {
						ret = "X";
					}

					return ret;
				}
			};

			add(iTApplications);

			add(new AdminReport(
					"skills",
					"Skills",
					"This report lists, for each department, some skills, licenses, or certifications that may be needed post-disaster",
					"Skill, Plan Name/u_name, plannamekey`Plan Name, Skill/plannamekey, u_name",

					"select skill.name, skill.description , isnull(acronym.acronym+' - ','')+plan_name displayplan, KS.comment,  "
	     			    +" upper(plan_name) u_plan_name, acronym.acronym, KS.ks_id, upper(skill.name) u_name,  isnull(acronym.acronym,'')+upper(plan_name) plannamekey  "
		    		    +" from (plans left join acronym on plans.acronymid = acronym.acronymid)  "
			    	    +" left join key_skills KS on plans.pid = KS.pid  "
				        +" left join skill on KS.skillid = skill.skillid   "
	    			    +" where plans.disabled = 'N' and plans.institutionid = ?",
					"Skill,Description of Skill,Plan Name,Comment",
					"that have no data in the Skill field.","ks_id"));
			add(new AdminReport(
					"vendors",
					"Vendors",
					"This report lists vendors identified in plans.",
					"Organization, Plan Name/u_dept, plannamekey`Plan Name, Organization/plannamekey, u_dept",
					"select KS.first_name, KS.last_name, KS.dept, KS.product_service, KS.alternate_vendors,   KS.comment,  isnull(acronym.acronym+' - ','')+plan_name displayplan,     KS.ks_id,  upper(KS.dept) u_dept" 
					  +" , isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
					  +" from (plans left join acronym on plans.acronymid = acronym.acronymid)"
					  +" left join (select ks_id, pid, first_name, last_name, dept, product_service, alternate_vendors, comment"
					 			+" from key_stakeholders KS"
					 			+" where disabled = 'N' and stakeholder_type = '4') KS on plans.pid = KS.pid "
					  +" where plans.disabled = 'N' and plans.institutionid = ?",
					  
					"First Name,Last Name,Organization,Products/Services,Alternate Vendors,Comment,Plan Name",
					"that have no Vendors listed. ", "ks_id"));
			AdminReport other = new AdminReport(
					"other",
					"Other Stakeholders",
					"This report lists stakeholders identified in plans (excluding vendors).  Several sorting options are offered.",
					"Last Name, Organization/upper_last_name, upper_dept`Organization, Plan Name/upper_dept, plannamekey`Type, Plan Name/upper_stakeholder_type, plannamekey`Plan Name, Type/plannamekey, upper_stakeholder_type", 
					"select KS2.first_name, KS2.last_name, KS2.dept, isnull(KS2.stakeholder_type,''), KS2.comment, isnull(acronym.acronym+' - ','')+plan_name displayplan, isnull(acronym.acronym,'')+upper(plan_name) plannamekey, "
						+" upper(KS2.last_name) upper_last_name,  upper(KS2.stakeholder_type) upper_stakeholder_type,  upper(KS2.dept) upper_dept, KS2.product_service, KS2.address, KS2.email, KS2.work_phone, KS2.cell_phone, KS2.fax, KS2.alternate_vendors, KS2.comment, KS2.ks_id"
						+" from (plans left join acronym on plans.acronymid = acronym.acronymid)"
			        	+" left join (select ks_id, pid, first_name, last_name, stakeholder_type, dept, product_service, address, email, work_phone, cell_phone, fax, alternate_vendors, comment"
			        	+" from key_stakeholders"
			        	+" where disabled = 'N' ) KS2 on plans.pid = KS2.pid"
			        	+" where  plans.institutionid = ?",
					"First Name,Last Name,Organization,Type,Comment,Plan Name",
					"that have no data to show here.","ks_id"){
				
				@Override
				public StringBuffer buildRows(List<String[]> list, String[] heads) {
					StringBuffer retb= new StringBuffer();
					String ret = "";

					for (String[] cols : list) {
						ret += "<TR>";
						ret += "<TD>"; // Column 1 is ABR - name

						// if (null!=row[6] && row[6].length()>0) {
						// ret+=row[6]+" - ";
						// }
						ret += cols[0] + "</TD>";
						ret += "<TD>" + cols[1] + "</TD>"; 

						ret += "<TD>" + cols[2]+ "</TD>"; 
						ret += "<TD>" + nonulls(stakeholdertype(cols[3])) + "</TD>";
						ret += "<TD>" + cols[4] + "</TD>";
						ret += "<TD>" + cols[5] + "</TD>";
						ret += "</TR>";
					}
		            retb.append(ret);
					return retb;
			
				}
				String nonulls(String inStr) {
					String ret="";
					if (null!=inStr && inStr.length()>0 && !"null".equals(inStr)) {
						ret=inStr;
					}
					return ret;
				}
				String stakeholdertype(String strin) {
					String ret="";
					if (null!=strin && strin.trim().length()==1) {
					    ret=(String) stakeholderMap.get(strin.trim());
					}
					return ret;
				}
				Map stakeholderMap = new HashMap() {
					{
						put("0","");
						put("1","Client");
						put("2","Donor");
						put("3","Sponsor");
						put("5","Project partner");
						put("6","Other stakeholder");
						put("7","Other");
					}
				};
				
			};
			
			other.setSpecialSelectionClause(" AND KS2.stakeholder_type =  ? ");
			
			add(other);
			
			add(new AdminReport(
					"strategies",
					"Strategies if Normal Workspace is Unavailable",
					"This report lists strategies identified by departments for carrying on critical functions if the normal workspace is not available.",
					"Plan Name, Criticality Level/plannamekey, criticalitylevel`Criticality Level, Plan Name/criticalitylevel, plannamekey", 
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, CF.name, CF.criticalitylevel, CF.how_space, CF.cid"
			         +" , isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
			         +" from (plans left join acronym on plans.acronymid = acronym.acronymid)"
			         +" left join (select * from critical_functions as CF where disabled = 'N' and (criticalitylevel = '1' or criticalitylevel = '2' or criticalitylevel = '3')) CF on plans.pid = CF.pid"
			         +" where plans.disabled = 'N' and plans.institutionid = ? ",
					"Plan Name,Critical Function,Criticality Level,Strategy",
					"where there is no data in the Strategy field.", "cast(how_space as nvarchar(4000)) <> '' and how_space"));
			AdminReport available = new AdminReport(
					"available",
					"Personnel Available for Reassignment",
					"This report lists, by department, various categories and numbers of personnel who may be \"not-needed\" for carrying on critical functions post-disaster, hence available for temporary reassignment elsewhere.",
					"Category of staff, Plan Name/staffcategory, plannamekey`Plan Name, Category of staff/plannamekey, staffcategory",
					"select isnull(acronym.acronym+' - ','')+plan_name displayplan, KSR.staffcategory, KSR.fte_normal, KSR.staffcategoryid,  KSR.ksr_id, KSR.fte_crisis"
			         	+" , isnull(acronym.acronym,'')+upper(plan_name) plannamekey"
			         	+" from plans left join acronym on plans.acronymid = acronym.acronymid"
			         	+" left join (select ksr_id, pid, KSR2.staffcategoryid, fte_normal, fte_crisis, staffcategory"
				 			+" from key_staffing_req KSR2, staffcategory SC"
							+" where KSR2.staffcategoryid = SC.staffcategoryid"
			            +" ) KSR on plans.pid = KSR.pid"
			            +" where plans.disabled = 'N' and plans.institutionid = ?",
					"Plan Name,Category of staff,Number of FTE who may be available for reassignment",
					"where the number of FTE available field has no data.","KSR.ksr_id");
			
			String avspecialSelectionSql="select StaffCategory description, StaffCategoryID id from StaffCategory WHERE  InstitutionId =?   ORDER BY description";
			
			available.setSpecialSelectionSql(avspecialSelectionSql);
			available.setSpecialSelectionClause(" and KSR.staffcategoryid = ? ");
			available.setSpecialName("Staff Categories");
			add(available);
			add(new AdminReport(
					"staffing",
					"Staffing Requirements During Crisis",
					"This report displays, for certain types of staff, the number of staff required during crisis versus the number required under normal circumstances.",
					"Plan Name, Category of staff, Criiticality level/plannamekey, staffcategory, criticalitylevel`Category of staff, Plan Name, Criiticality level/staffcategory, plannamekey, criticalitylevel`Criticality level, Plan Name, Category of staff/criticalitylevel, plannamekey, staffcategory",
					"select isnull(acronym.acronym+' - ','')+plan_name plannamekey, KSR.cf_name, case when SDCLF.name is not null then SDCLF.name else SCLF.name end levelname, KSR.staffcategory, KSR.shift_name, KSR.fte_normal, KSR.fte_crisis, KSR.cf_name,  acronym.acronym, KSR.ksr_id, KSR.staffcategoryid, KSR.criticalitylevel"
							+ "  ,  plan_name"
							+ " from plans left join acronym on plans.acronymid = acronym.acronymid "
							+ " left join (select ksr_id, KSR2.pid, KSR2.staffcategoryid, fte_normal, fte_crisis, staffcategory, shift.name shift_name, CF.name cf_name, CF.criticalitylevel "
							+ "                from key_staffing_req KSR2, staffcategory SC, shift, critical_functions CF "
							+ "                where KSR2.staffcategoryid = SC.staffcategoryid "
							+ "                and KSR2.cid = CF.cid and CF.disabled = 'N' "
							+ "                and KSR2.shiftid = shift.shiftid "
							+ "                ) KSR on plans.pid = KSR.pid "
							+ " left join (select * from systemdomaincriticallevelfunc as SDCLF) SDCLF on SDCLF.levelno = KSR.criticalitylevel and SDCLF.institutionid = plans.institutionid "
							+ " left join (select * from systemcriticallevelfunc as SCLF) SCLF on SCLF.levelno = KSR.criticalitylevel "
							+ "                where plans.disabled = 'N' and plans.institutionid = ? ",
					"Plan Name,Function,Criticality Level,Category of Staff,Shift,#FTE required(normal),#FTE required(during crisis)"));
		}

	};

	public HashMap getReports() {
		return reports;
	}

	public AdminReport getAdminReport(String key) {
		return (AdminReport) reports.get(key);
	}

	
	// public void runReport(AdminReport adminReport, SelectionSet selectionSet)
	// {
	// // Clean Selection Set
	// JdbcTemplate jdbcTemplate = new JdbcTemplate();
	//        
	//		
	// }
	@SuppressWarnings("unchecked")
	public String runReport(String reportId, SelectionSet selectionSet) {
		List reportList = null;
		System.out.println("runReport: " + reportId);
		AdminReport ar = (AdminReport) reports.get(reportId);
		try {
			// special case: it applications
			if ("ITApplications".equals(reportId)) {
				Map<CriticalityLevelEnum, CriticalityLevel> clMap = 
					(Map<CriticalityLevelEnum, CriticalityLevel>) 
					this.systemDomainCriticalityLevelService.getListByOwnerId(
							SystemDomainCentralApplicationCriticalityLevel.class, 
							Integer.parseInt(selectionSet.selectedInstitution));
				String[] headings = {
					"Application", 
					"Plan Name", 
					"Not Imp", 
					clMap.get(CriticalityLevelEnum.LEVEL1).getName(),
					clMap.get(CriticalityLevelEnum.LEVEL2).getName(),
					clMap.get(CriticalityLevelEnum.LEVEL3).getName(),
					clMap.get(CriticalityLevelEnum.LEVEL4).getName(),
					"Comment"
				};
				ar.setHeadings(headings);
			}
			reportList = adminReportRunService.runReport(ar, selectionSet);
		} catch (Exception e) {
			System.out.println("runReport Exception " + e);
			e.printStackTrace();
		}
		System.out.println("I got: " + reportList.size());
		String top="";
		if(ar.getTopBandProcess()!=null) {
			
			top=adminReportRunService.runBand(ar, ar.getTopBandProcess(), selectionSet);
		}
		String mainrpt= adminReportDisplayService.displayGrid(ar, reportList);
		return top+mainrpt;
	}
    public List<Nvp> getSpecialList(AdminReport ar, String institution) {
    	List<Nvp> specialList=null;
    	if (ar.getSpecialSelectionSql()!=null && ar.getSpecialSelectionSql().length()>0 ) {
    		String [] args = {institution};
    	 	specialList= adminReportRunService.getNvpList(ar, ar.getSpecialSelectionSql(), args);
    		
    	}
    	return specialList;
    }
	public static HashMap reports = new HashMap() {
		{
			int i = 1;
			for (AdminReport ar : list) {
				ar.numberedName = "" + i + ". " + ar.name;
				put(ar.getId(), ar);
				i++;
			}

		}
	};

}
