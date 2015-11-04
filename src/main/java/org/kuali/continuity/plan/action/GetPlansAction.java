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

import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.action.util.ActionHelper;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.action.dto.PlanDTO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanService;


// UCB/editPlan.cfm
public class GetPlansAction extends BasePlanAction {
	
	private ContinuityPlanService continuityPlanService;
	private String systemDomainName;
	private List<PlanDTO> plans = new ArrayList<PlanDTO>();

	public GetPlansAction(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}
	
	public String getSystemDomainName() {
		return this.systemDomainName;
	}

	public void setSystemDomainName(String systemDomainName) {
		this.systemDomainName = systemDomainName;
	}

	public List<PlanDTO> getPlans() {
		return this.plans;
	}

	public void setPlans(List<PlanDTO> plans) {
		this.plans = plans;
	}

	public String execute() throws Exception {
		// get query parameters
		SessionUserDTO userDTO = this.getSessionUser();
		SystemDomainDTO systemDomainDTO = userDTO.systemDomain;
		RefDTO securityTypeDTO = userDTO.securityType;
		
		// set domain name
		this.systemDomainName = systemDomainDTO.name;
		
		SortByType sortBy = null;
		if (SecurityTypeEnum.isAdmin(new SecurityType(userDTO.securityType.id)) ||
			SecurityTypeEnum.UNIVERSAL_VIEWER.getRefDomainObject().equals(new SecurityType(userDTO.securityType.id)))
			sortBy = ContinuityPlan.SortBy.acronymPlusName;
		else
			sortBy = ContinuityPlan.SortBy.access;
	
		// set plans
		List<SimpleContinuityPlan> sPlans = this.continuityPlanService.getSimpleContinuityPlanList(systemDomainDTO.id, userDTO.id, sortBy, true);
		this.plans = new ArrayList<PlanDTO>();
		
		if (sPlans != null) {
			
			for (SimpleContinuityPlan sPlan : sPlans) {
				
				PlanDTO planDTO = new PlanDTO(sPlan);
				
				// set plan access
				SecurityType securityType = new SecurityType(securityTypeDTO.id);
				PlanAccessType planAccessType = ActionHelper.getInstance().getPlanAccess(securityType, sPlan.getUserAccess(userDTO.getDomainObject()));
				planDTO.planAccess = new RefDTO(planAccessType);
				
				// add to list
				this.plans.add(planDTO);
				
			}
		}

		// return
		return SUCCESS;
	}

	public void prepare() throws Exception {
		super.prepare();
		//this.removeFromSession(SessionKey.plan);
	}

}
