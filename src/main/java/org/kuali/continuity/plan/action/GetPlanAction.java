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
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.util.ActionHelper;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.plan.action.dto.Gatekeeper;
import org.kuali.continuity.plan.action.dto.PageAccessControlDTO;
import org.kuali.continuity.plan.action.dto.PlanNavigation;
import org.kuali.continuity.plan.action.dto.SessionPlanDTO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanService;

public class GetPlanAction extends BasePlanAction implements PlanNavigationSession, ServletRequestAware {
	
	private int planId;
	private ContinuityPlanService continuityPlanService;
	private SessionPlanDTO plan = new SessionPlanDTO();
	private boolean isDoRefresh = false;
	private HttpServletRequest request;

	public GetPlanAction(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getPlanId() {
		return this.planId;
	}

	public SessionPlanDTO getPlan() {
		return this.plan;
	}

	public void setPlan(SessionPlanDTO plan) {
		this.plan = plan;
	}

	public boolean isDoRefresh() {
		return this.isDoRefresh;
	}

	public void setDoRefresh(boolean isDoRefresh) {
		this.isDoRefresh = isDoRefresh;
	}

	public String execute() throws Exception {
		if (this.isDoRefresh) this.planId = this.getSessionPlan().id;
		if (this.planId != 0) {
			ContinuityPlan continuityPlan = null;
			// get security type
			SessionUserDTO sessionUserDTO = (SessionUserDTO) this.getSessionValue(SessionKey.systemAdminUser);
			if (sessionUserDTO == null) sessionUserDTO = this.getSessionUser();
			int testPlanId = this.getSessionPlan() == null ? 0 : this.getSessionPlan().id; // test if page is refreshed
			if (sessionUserDTO.securityType != null  && !this.isDoRefresh && this.planId != testPlanId) {
				// new system log info
				SystemLogInfo systemLogInfo = new SystemLogInfo();
				systemLogInfo.setUserId(this.getSessionUser().id);
				systemLogInfo.setSystemDomainId(this.getSessionUser().systemDomain.id);
				systemLogInfo.setHostIP(this.request.getRemoteAddr());
				systemLogInfo.setModule(this.request.getRequestURI());
				systemLogInfo.setSecurityType(new SecurityType(sessionUserDTO.securityType.id));
				continuityPlan = this.continuityPlanService.getContinuityPlan(this.planId, systemLogInfo);
			} else {
				continuityPlan = this.continuityPlanService.getContinuityPlan(this.planId);
			}
				
			if (continuityPlan != null) {
				// user
				SessionUserDTO userDTO = this.getSessionUser();
				if (userDTO == null) return ERROR;
				User user = userDTO.getDomainObject();
				RefDTO securityTypeDTO = userDTO.securityType;
				
				// set plan
				this.plan = new SessionPlanDTO(continuityPlan);
				
				// plan access
				SecurityType securityType = new SecurityType(securityTypeDTO.id);
				PlanAccessType planAccessType = ActionHelper.getInstance().getPlanAccess(securityType, continuityPlan.getUserAccess(user));
				this.plan.planAccess = new RefDTO(planAccessType);
				
				// is gatekeeper?
				this.removeFromSession(SessionKey.planGatekeeper);
				if (SecurityTypeEnum.isAdmin(securityType) || continuityPlan.getContacts().containsKey(user))
					this.putInSession(SessionKey.planGatekeeper, new Gatekeeper());
				
				// put in session
				this.putInSession(SessionKey.plan, this.plan);
				this.putInSession(SessionKey.planAccessControl, new PageAccessControlDTO(new PlanAccessType(this.plan.planAccess.id)));

			}
		}
		// return
		return SUCCESS;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public PlanNavigation getPlanNavigation() {
		return PlanNavigation.HOME;
	}

}
