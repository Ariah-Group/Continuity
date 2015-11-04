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

import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.plan.action.dto.ContactDTO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanService;

public class GetPlanContactsAction extends GetUsersAction {

	private ContinuityPlanService continuityPlanService;
	private int planId;
	
	public GetPlanContactsAction(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}

	public int getPlanId() {
		return this.planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public void buildUsers() {
		if (this.planId == 0) return;
		
		// get plan contacts
		ContinuityPlan plan = this.continuityPlanService.getContinuityPlan(this.planId);
		Map<User, Boolean> contactMap = plan.getContacts();
		
		// iterate
		List<ContactDTO> contacts = new ArrayList<ContactDTO>();
		Set<User> users = null;
		if (contactMap != null) {
			users = contactMap.keySet();
			for (User user : users) {
				ContactDTO dto = new ContactDTO(user);
				dto.isPrimary = contactMap.get(user);
				contacts.add(dto);
			}
		}
		
		// set contact list
		this.setUsers(contacts);
	}

}
