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
package org.kuali.continuity.report.jasper;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.report.ReportParameterData;
import org.kuali.continuity.util.DataUtil;

import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRScriptletException;

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
			System.out.println("Getting page number: "+pageNumber);
			
		} catch (Exception e) {
			System.out.println("Page Number Exception:"+e);
		}
		setVariableValue("PAGE_NUMBER", pageNumber);

	}
	public String cost() throws JRScriptletException{
		String ret="";
		Integer cost= new Integer((String)this.getFieldValue("cost"));
		
		return ret;
	}
	public String scope() throws JRScriptletException{
		String ret="";
		Integer scope=new Integer((String)this.getFieldValue("scope"));
		
		return ret;
	}
	
	/* funname Does this piece of CF code
	<cfloop query="qGetAI">
	<cfif qGetAI.cfnameUpper is not ''>
		<cfelseif qGetAI.a_type is 'I'>
			<cfset qGetAI.cfnameUpper = "INFORMATION TECHNOLOGY" >
		<cfelseif qGetAI.a_type is 'G'>
			<cfset qGetAI.cfnameUpper = "FACULTY PREPAREDNESS" >
		<cfelse>
			<cfset qGetAI.cfnameUpper = "NOT ASSOCIATED WITH A CRITICAL FUNCTION"> 
	</cfif>
	</cfloop>
*/
	public String funname() throws JRScriptletException{
		String ret="";
		String fname=(String) this.getFieldValue("fname");
		String a_type=(String) this.getFieldValue("a_type");
		
		if (null==fname || fname.trim().length()==0) {
			if (a_type.equals("I")) {
				ret="INFORMATION TECHNOLOGY";
			} else if (a_type.equals("G")) {
				ret="FACULTY PREPAREDNESS";
			} else {
				ret="NOT ASSOCIATED WITH A CRITICAL FUNCTION";
			}
		} else {
			ret=fname;
		}
		return ret;
	}
	public String statname() throws JRScriptletException {
		String status = (String) this.getFieldValue("status");
		String statusname= (String)  this.getFieldValue("statusname");
		String ret=statusname;
		if (statusname.startsWith("Please")) {
			ret="";
        
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
		String ret="";
		BigDecimal fteNorm;
		try {
			fteNorm = new BigDecimal ((String) super
			.getFieldValue("FTE_normal"));
	
		BigDecimal fteCrisis = new BigDecimal ((String) super
				.getFieldValue("FTE_crisis"));	
		BigDecimal diff = fteNorm.subtract(fteCrisis);
		ret = diff.toString();
		} catch (JRScriptletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return ret;

		}
	    String functionSql = "select name from critical_functions where pid=? order by priority,name";
	    
        public String functionListString() {
        	System.out.println("getting functions");
        	String ret="";
        	ReportParameterData rpd = new ReportParameterData();
        	List<String> retList = null;
        	try {
				Connection conn = (Connection) super
				.getParameterValue("REPORT_CONNECTION");
				Integer id = (Integer) super.getParameterValue("PID");
				 retList = rpd.getValueList(conn, functionSql, id, ", ");
				 System.out.println("I got "+retList.size());				 
				 setVariableValue("FUNCTION_HEIGHT", retList.size() * 20);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=1;
			String sep="\n";
            for (String s: retList) {
            	 ret+=""+(i++)+"   "+s+sep;
            }           
            
        	return ret;
        }
        
        String buildingSql = "select BuildingName, Ownership from plan_buildings pb join Building b on pb.BuildingID = b.BuildingID where pb.pid=?";
	    
        public String buildingString() {
        	System.out.println("getting building");
        	String ret="";
        	ReportParameterData rpd = new ReportParameterData();
        	//List<String> retList = null;
        	Map resultMap = null;
        	try {
				Connection conn = (Connection) super
				.getParameterValue("REPORT_CONNECTION");
				Integer id = (Integer) super.getParameterValue("PID");
				 //retList = rpd.getValueList(conn, buildingSql, id, ",");
				resultMap = rpd.getParameters(conn, buildingSql, id);
				System.out.println("I got building list size at: "+resultMap.size());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(((String)resultMap.get("Ownership")).equals("1")){
				return ((String)resultMap.get("BuildingName")) + "	" + "Owned";
			} else{
				return ((String)resultMap.get("BuildingName")) + "	" + "Not Owned";
			}
			
			//return (String)retList.get(0);
        }      
            
        
	    public String peakPeriods() {
	    	String [] months = "Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec".split(" ");
	    	String ret="";
	    	try {
	    	for (String s: months) {
	    		String fld="peak_"+s.toLowerCase();
	    		String ismo = (String) this.getFieldValue(fld) ;
	    		if (ismo.equals("Y")) {
	    			ret+=s+" ";
	    		}
	    	}
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	
	    	return ret;
	    }
        
        String contactSql = "select FirstName + ' ' + LastName as ContactName "
        	+ " from UserSecurity US, plan_contacts pc "
        	+ " where pc.pid = ? "
        		+ " and pc.UserID = US.UserID " 
        		+ " and pc.ContactType = ";
        
        public String contactString(int type) {
        	System.out.println("getting functions");
        	String ret="";
        	ReportParameterData rpd = new ReportParameterData();
        	List<String> retList = new ArrayList<String>();
    		try {
				Connection conn = (Connection) super
				.getParameterValue("REPORT_CONNECTION");
				Integer id = (Integer) super.getParameterValue("PID");
				 retList = rpd.getValueList(conn, contactSql+type, id, ", ");
				 System.out.println("I got "+retList.size());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=1;
			String sep="";
            for (String s: retList) {
            	 ret+=sep+s;
            	 sep=", ";
            }
        	return ret;
        }
        String streamSql =
        " select  d.Dependency "
        	+" from Dependency d, cf_dependency c "
        	+" where c.DependencyID = d.DependencyID "
        	+" and d.recordtype = 'U'"
        	+" and c.cid = ?"
        	+" and d.DependencyType=";
        
    	public String stream(int dir) {
        	String ret="";
        	ReportParameterData rpd = new ReportParameterData();
        	List<String> retList = new ArrayList<String>();
    		try {
				Integer id= (Integer) this.getFieldValue("cid");
				Connection conn = (Connection) super
				.getParameterValue("REPORT_CONNECTION");
				// Integer id = (Integer) super.getParameterValue("PID");
				 retList = rpd.getValueList(conn, streamSql+dir, id, ", ");
				 System.out.println("I got "+retList.size());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=1;
			String sep="";
            for (String s: retList) {
            	 ret+=sep+s;
            	 sep=", ";
            }
        	return ret;

    	}
    	public String upstream() {
    		return stream(0);
    	}
    	public String downstream() {
    		return stream(1);
    	}
    	
    	String consequenceSql =
            " SELECT  con_disruption_teaching,con_disruption_teaching_explain,con_disruption_research, "
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
            	String ret="";
            	ReportParameterData rpd = new ReportParameterData();
            	Map resultMap = null;
        		try {
    				Integer cid= (Integer) this.getFieldValue("cid");
    				Integer pid = (Integer) super.getParameterValue("PID");			
    				System.out.println("cid is:  " + cid.toString() + "	  , PID is: " + pid.toString());  				
    				List<Integer> parmList = new ArrayList<Integer>();
    				parmList.add(cid);
    				parmList.add(pid);
    				Connection conn = (Connection) super.getParameterValue("REPORT_CONNECTION");
    				resultMap = rpd.getParameters(conn, consequenceSql, parmList);
    				System.out.println("I got " + resultMap.size());

    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			String space="				";
    			String sep="\n";
    			
    			
    			
    			if(((String)resultMap.get("con_disruption_teaching")).equals("1")){
    				ret += "Disruption of teaching" + space + DataUtil.nonulls((String)resultMap.get("con_disruption_teaching_explain")) + sep + sep;
    			} else if(((String)resultMap.get("con_disruption_research")).equals("1")){
    				ret += "Disruption of research" + space + DataUtil.nonulls((String)resultMap.get("con_disruption_research_explain")) + sep + sep;
    			}  			
    			
    			return ret;
        	}
    	
}
