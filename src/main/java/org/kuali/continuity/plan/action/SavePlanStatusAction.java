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
package org.kuali.continuity.plan.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.PlanStatusEnum;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.plan.service.ContinuityPlanService;

@SuppressWarnings("serial")
public class SavePlanStatusAction extends BasePlanActionSupport implements ServletRequestAware, SessionPlanRequired {
	
	private ContinuityPlanService continuityPlanService;
	private HttpServletRequest request;
	
	public SavePlanStatusAction(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}
	
	public String execute() {
		PlanStatus status = new PlanStatus(this.getSessionPlan().status.id);
		if (status.equals(PlanStatusEnum.IN_PROGRESS.getRefDomainObject()))
			status = PlanStatusEnum.COMPLETE.getRefDomainObject();
		else
			status = PlanStatusEnum.IN_PROGRESS.getRefDomainObject();

		// log info
		SystemLogInfo systemLogInfo = new SystemLogInfo();
		systemLogInfo.setUserId(this.getSessionUser().id);
		systemLogInfo.setSystemDomainId(this.getSessionUser().systemDomain.id);
		systemLogInfo.setHostIP(this.request.getRemoteAddr());
		systemLogInfo.setModule(this.request.getRequestURI());
		
		// service
		this.continuityPlanService.updateStatus(this.getSessionPlan().id, status, systemLogInfo);
		this.getSessionPlan().status = new RefDTO(status);
		return SUCCESS;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}