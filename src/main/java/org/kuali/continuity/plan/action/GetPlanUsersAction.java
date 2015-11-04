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
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.dto.AccessUserDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.plan.service.ContinuityPlanService;

@SuppressWarnings("serial")
public class GetPlanUsersAction extends BasePlanActionSupport implements SessionPlanRequired {
	
	private ContinuityPlanService continuityPlanService;
	private PlanActionServiceHelper serviceHelper;
	private List<AccessUserDTO> users;
	private List<RefDTO> planAccessTypes;
	private boolean isContactTable = false;
	
	public GetPlanUsersAction(ContinuityPlanService continuityPlanService, PlanActionServiceHelper serviceHelper) {
		this.continuityPlanService = continuityPlanService;
		this.serviceHelper = serviceHelper;
	}

	public List<RefDTO> getPlanAccessTypes() {
		return this.planAccessTypes;
	}

	public void setPlanAccessTypes(List<RefDTO> planAccessTypes) {
		this.planAccessTypes = planAccessTypes;
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

	public String execute() throws Exception {
		// access types
		this.planAccessTypes = this.serviceHelper.getRefDTOs(PlanAccessType.class);
		
		// user access
		this.users = new ArrayList<AccessUserDTO>();
		Map<User, PlanAccessTypeEnum> svcUserAccessMap = this.continuityPlanService.getUserAccessMap(this.getSessionPlan().id);
		if (svcUserAccessMap != null) {
			Set<User> svcUsers = svcUserAccessMap.keySet();
			for (User user : svcUsers) {
				PlanAccessTypeEnum en = svcUserAccessMap.get(user);
				AccessUserDTO accessUser = new AccessUserDTO(user);
				accessUser.planAccessType = new RefDTO(en.getRefDomainObject());
				if (PlanAccessTypeEnum.GATEKEEPER == en)
					accessUser.isGatekeeper = true;
				this.users.add(accessUser);
			}
		}
		
		return SUCCESS;
	}

}
