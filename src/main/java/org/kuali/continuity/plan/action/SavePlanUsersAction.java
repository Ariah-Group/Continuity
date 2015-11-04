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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.dto.AccessUserDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.plan.service.ContinuityPlanService;

@SuppressWarnings("serial")
public class SavePlanUsersAction extends BasePlanActionSupport implements SessionPlanRequired {
	
	private ContinuityPlanService planService;
	private List<AccessUserDTO> users;
	private List<RefDTO> planAccessTypes;
	
	private boolean isContactTable = false;
	
	public SavePlanUsersAction(ContinuityPlanService planService) {
		this.planService = planService;
	}
	
	public List<AccessUserDTO> getUsers() {
		return this.users;
	}

	public void setUsers(List<AccessUserDTO> users) {
		this.users = users;
	}

	public boolean isContactTable() {
		return this.isContactTable;
	}

	public void setContactTable(boolean isContactTable) {
		this.isContactTable = isContactTable;
	}

	public List<RefDTO> getPlanAccessTypes() {
		return this.planAccessTypes;
	}

	public void setPlanAccessTypes(List<RefDTO> planAccessTypes) {
		this.planAccessTypes = planAccessTypes;
	}

	public String execute() {
		// set map
		Map<User, PlanAccessTypeEnum> userAccessMap = new HashMap<User, PlanAccessTypeEnum>();
		if (this.users != null) {
			for (AccessUserDTO accessUserDTO : this.users) {
				if (accessUserDTO == null) continue;
				User user = accessUserDTO.getDomainObject();
				PlanAccessTypeEnum en = accessUserDTO.isGatekeeper ?
					PlanAccessTypeEnum.GATEKEEPER :
					PlanAccessTypeEnum.getEnum(new PlanAccessType(accessUserDTO.planAccessType.id));
				userAccessMap.put(user, en);
			}
		}
		
		// planner
		User planner = this.getSessionUser().getDomainObject();
		
		// save
		this.planService.updateUserAccessMap(this.getSessionPlan().id, userAccessMap, planner);
		
		// return
		return SUCCESS;
	}

}
