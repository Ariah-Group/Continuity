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

import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.ReadRowAction;
import org.kuali.continuity.action.SaveAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.KeyStaffBasicsDTO;
import org.kuali.continuity.plan.action.dto.KeyStaffMemberDTO;
import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.service.KeyResourcesService;

@SuppressWarnings("serial")
public class KeyResourcesStaffAction extends KeyResourcesAction {
	
	// service
	private KeyResourcesService keyResourcesService;
	
	// beans
	private KeyStaffBasicsDTO keyStaffBasics = new KeyStaffBasicsDTO();
	
	public KeyResourcesStaffAction(KeyResourcesService keyResourcesService) {
		super();
		this.keyResourcesService = keyResourcesService;
		this.setValidateAction(new ValidateAction());
	}
	
	public KeyStaffBasicsDTO getKeyStaffBasics() {
		return this.keyStaffBasics;
	}

	public void setKeyStaffBasics(KeyStaffBasicsDTO keyStaffBasics) {
		this.keyStaffBasics = keyStaffBasics;
	}

	@Override
	public String list() throws Exception {
		String retVal = super.list();
		if (!(retVal.equals(SUCCESS))) return retVal;
		(new ReadBasicsAction()).execute();
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		// set saves
		this.getSaveActions().put(new Integer(1), new SaveBasicsAction());
		this.getSaveActions().put(new Integer(2), this.getAddAction());
	}
	
	// ----- actions ----- //
	
	public class SaveBasicsAction implements SaveAction {
		public String execute() throws Exception {
			KeyResourcesStaffAction.this.keyResourcesService.updateStaffBasics(
				KeyResourcesStaffAction.this.getSessionPlan().id,
				KeyResourcesStaffAction.this.keyStaffBasics.hasEmergencyContactList, 
				KeyResourcesStaffAction.this.keyStaffBasics.emergencyContactListHolders, 
				KeyResourcesStaffAction.this.keyStaffBasics.emergencyContactListUpdaters, 
				KeyResourcesStaffAction.this.keyStaffBasics.voiceMailMessagesCheckers, 
				KeyResourcesStaffAction.this.keyStaffBasics.voiceMailGreeters, 
				KeyResourcesStaffAction.this.keyStaffBasics.websiteMessagePosters, 
				KeyResourcesStaffAction.this.keyStaffBasics.sharedPasswordKeepers, 
				KeyResourcesStaffAction.this.keyStaffBasics.staffBasicsComment);
			return SUCCESS;
		}
	}
	
	public class ReadBasicsAction implements ReadRowAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesStaffAction.this.keyResourcesService;
			int rowId = KeyResourcesStaffAction.this.getOwnerId();
			KeyResources kr = service.getKeyResources(rowId);
			KeyResourcesStaffAction.this.keyStaffBasics = new KeyStaffBasicsDTO(kr);
			return SUCCESS;
		}
	}
	
	public class ValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			KeyStaffMemberDTO dto = (KeyStaffMemberDTO) dObjDTO;
			if ((dto.firstName != null && dto.firstName.trim().length() != 0) ||
			    (dto.lastName != null && dto.lastName.trim().length() != 0) ||
			    (dto.titleOrFunction != null && dto.titleOrFunction.trim().length() != 0) ||
			    (dto.specialSkill != null && dto.specialSkill.trim().length() != 0) ||
			    (dto.comment != null && dto.comment.trim().length() != 0)) return true;
			return null;
		}
	}
	
}
