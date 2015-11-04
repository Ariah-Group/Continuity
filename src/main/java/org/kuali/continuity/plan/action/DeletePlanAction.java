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
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanService;

public class DeletePlanAction extends BasePlanAction implements ServletRequestAware {
	
	private ContinuityPlanService planService;
	private int planId;
	private HttpServletRequest request;
	
	public DeletePlanAction(ContinuityPlanService planService) {
		this.planService = planService;
	}

	public int getPlanId() {
		return this.planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String execute() throws Exception {
		ContinuityPlan deletePlan = this.planService.getContinuityPlan(this.planId);
		SystemLogInfo systemLogInfo = new SystemLogInfo();
		systemLogInfo.setUserId(this.getSessionUser().id);
		systemLogInfo.setSystemDomainId(this.getSessionUser().systemDomain.id);
		systemLogInfo.setHostIP(this.request.getRemoteAddr());
		systemLogInfo.setModule(this.request.getRequestURI());
		this.planService.deleteContinuityPlan(deletePlan, systemLogInfo);
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void prepare() throws Exception {
		super.prepare();
		this.removeFromSession(SessionKey.plan);
	}

}
