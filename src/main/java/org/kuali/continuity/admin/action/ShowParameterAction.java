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

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.admin.action.dto.AdminReportParameterDTO;
import org.kuali.continuity.admin.service.AdmReportService;
import org.kuali.continuity.admin.service.AdminReport;
import org.kuali.continuity.admin.service.Nvp;
import org.kuali.continuity.plan.action.BasePlanActionSupport;
/**
 * Display the Report Parameter page for the given report
 * @author richkatz
 *
 */
@SuppressWarnings("serial")
public class ShowParameterAction extends BasePlanActionSupport implements ServletRequestAware {
//	private final Logger logger = Logger
//	.getLogger(ShowParameterAction.class);

	HttpServletRequest request;
	public List<Nvp> sortList;
	public List<Nvp> pullList;
	public AdminReportParameterDTO adminReportParameterDTO;
	private String reportId;
	
	private enum ReportIdEnum {
		status, 
		contact, 
		building, 
		evacuation, 
		criticalFunctions, 
		upstream, 
		downstream, 
		documents, 
		actionItems, 
		backup, 
		support, 
		ITApplications, 
		skills, 
		vendors, 
		other, 
		strategies, 
		available, 
		staffing;
	}
	
	public AdminReportParameterDTO getAdminReportParameterDTO() {
		return adminReportParameterDTO;
	}
	public void setAdminReportParameterDTO(
			AdminReportParameterDTO adminReportParameterDTO) {
		this.adminReportParameterDTO = adminReportParameterDTO;
	}


	AdmReportService admReportService;
	
	public ShowParameterAction (AdmReportService admReportService) {
		this.admReportService=admReportService;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() {
		// Identifies the report to be processed.
		SystemDomainDTO memberSystemDomainDTO = this.getSessionUser().systemDomain;
		
		String selectedInstitution= ""+memberSystemDomainDTO.getId();
//		String reportId =  (String) request.getParameter("report");
	
		
		if (null!=reportId) {
			
			try {
				if (ReportIdEnum.valueOf(reportId) == null) return ERROR;
			} catch (IllegalArgumentException e) {
				return ERROR;
			}
			
			// Make parameter data accessible to JSP
			AdminReport ar = admReportService.getAdminReport(reportId);
			
			adminReportParameterDTO = new AdminReportParameterDTO();
			adminReportParameterDTO.reportId=reportId;
			adminReportParameterDTO.description=ar.getDescription();
			adminReportParameterDTO.reportName=ar.getName();
			adminReportParameterDTO.numberedReportName=ar.getNumberedName();
			adminReportParameterDTO.excludePhrase=ar.getExcludePhrase();
			adminReportParameterDTO.excludeItem=ar.getExcludeitem();
			adminReportParameterDTO.sortNvp=ar.sortList;
			if (ar.sortList.size()<=1) {
				adminReportParameterDTO.issort=false;
			}
			
			// Handle sort list.
			if (ar.sortList.size()==0) {
				adminReportParameterDTO.issort=false;
			}
			sortList= (List) ar.sortList;
			
			
			
			// Handle exclude
			if (ar.getExcludeitem().length()>0) { 
				
				adminReportParameterDTO.excludePhrase="";
				if (ar.getExcludePhrase().length()>0) {
					adminReportParameterDTO.excludePhrase=ar.getExcludePhrase();
				}
				
			}
			// Handle sort
//            <select name="s_sortby">
//
//            <option value="plannamekey">Plan Name</option>
//            <option value="status">Plan Status</option>
//            <option value="last_modified">Date of Last Access</option>
//          </select>
			
			String[] sortOptions =ar.getSortOptions();
			adminReportParameterDTO.sortNames=Arrays.asList(sortOptions);

			
			
			// Handle special selection
			
			if(ar.getSpecialSelectionSql()!=null) {
				pullList=admReportService.getSpecialList(ar, selectedInstitution);
				pullList.add(0, new Nvp("All "+ar.getSpecialName(),"all"));
				adminReportParameterDTO.ispull=true;
			} else {
			}
			
		} else {
		}
        // Handle special select
		
		
		return SUCCESS;
	}


	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}

	public String getReportId() {
		return this.reportId;
	}
	
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
     
}
