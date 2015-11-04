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
package org.kuali.continuity.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.admin.action.dto.AdminReportParameterDTO;
import org.kuali.continuity.admin.service.AdmReportService;
import org.kuali.continuity.admin.service.AdminReport;
import org.kuali.continuity.admin.service.SelectionSet;
import org.kuali.continuity.plan.action.BasePlanActionSupport;

/**
 * Display the Report Parameter page for the given report
 * 
 * @author richkatz
 * 
 */
public class RunAdminReportAction extends BasePlanActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private final Logger logger = Logger.getLogger(ShowParameterAction.class);

	HttpServletRequest request;
	HttpServletResponse response;
	
	protected AdminReportParameterDTO adminReportParameterDTO;

	public AdminReportParameterDTO getAdminReportParameterDTO() {
		return adminReportParameterDTO;
	}

	public void setAdminReportParameterDTO(
			AdminReportParameterDTO adminReportParameterDTO) {
		this.adminReportParameterDTO = adminReportParameterDTO;
	}

	AdmReportService admReportService;
	

	public void setAdmReportService(AdmReportService admReportService) {
		this.admReportService = admReportService;
	}

	public RunAdminReportAction(AdmReportService admReportService) {
		System.out.println("admReportService is set");
		this.admReportService = admReportService;
	}

	public String execute() {
		
		SystemDomainDTO memberSystemDomainDTO = this.getSessionUser().systemDomain;
		
		// Identifies the report to be processed.
		adminReportParameterDTO = new AdminReportParameterDTO();
		adminReportParameterDTO.location=memberSystemDomainDTO.name;

		String reportId = (String) request.getParameter("report_name");
		System.out.println("Run report: "+reportId);
		AdminReport ar = admReportService.getAdminReport(reportId);
		adminReportParameterDTO.reportId=reportId;
		adminReportParameterDTO.description=ar.getDescription();
		adminReportParameterDTO.reportName=ar.getName();
		adminReportParameterDTO.numberedReportName=ar.getNumberedName();
		// Get parameters into SelectionSet.
		
		SelectionSet selectionSet = new SelectionSet();
		selectionSet.selectedInstitution =  ""+memberSystemDomainDTO.getId(); //"1"; // Get this from session.
		String thisSort = "";
		
		try {
			if (null != request.getParameter("s_sortby")) {
				// Validate against known sorts.
                String reqSort=request.getParameter("s_sortby");
				if (ar.isASort(reqSort)) {
					thisSort = reqSort;
				} else {
					thisSort = reqSort;
					System.out.println("Sort parameter is incorrect: "+(String) request.getParameter("s_sortby"));
				}
				
				
			} else {
				System.out.println("Sort parameter is null!: ");
				
				System.out.println("plan is null!: "+request.getParameter("plan_name"));
				
			}
		} catch (Exception e) {
			System.out.println("No Sort requested ");
		}
		selectionSet.selectedSort = thisSort;
		//boolean isplan = request.getParameter("r_plan").equals("specifyplan");
		selectionSet.selectedPlan = request.getParameter("plan_name");
		if ("all plans".equals(request.getParameter("r_plan"))) { 
			selectionSet.selectedPlan = "";
		}
		selectionSet.specialSelection = request.getParameter("s_pullby");
		selectionSet.excludeEmpty = true; // If we don't get it, its' empty.
		System.out.println("Is it checked: "+request.getParameter("exclude"));
		if (null!=request.getParameter("exclude")) {
			   System.out.println("Action is excluding");
				selectionSet.excludeEmpty
				=!request.getParameter("exclude").equals("on");
		}
      
		adminReportParameterDTO.table = admReportService.runReport(reportId,
				selectionSet);
		System.out.println(adminReportParameterDTO.table);
		request.setAttribute("table",adminReportParameterDTO.table);
		  
		String forward = SUCCESS;
		// Set values for subsequent MS Word select.
		adminReportParameterDTO.exclude=request.getParameter("exclude");
		adminReportParameterDTO.sortby=request.getParameter("s_sortby");
		
		// For MS Word, set context type to application/msword
		Object isMsword=request.getParameter("type");
		
		if (null != isMsword && isMsword.equals("msword") ) { 
		      response.setContentType("application/msword");
		      forward="msword";
		}
		return forward;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;

	}

	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}

}
