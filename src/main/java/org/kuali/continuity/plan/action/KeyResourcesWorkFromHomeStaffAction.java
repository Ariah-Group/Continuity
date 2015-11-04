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
import org.kuali.continuity.plan.action.dto.WorkFromHomeStaffBasicsDTO;
import org.kuali.continuity.plan.action.dto.WorkFromHomeStaffMemberDTO;
import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.service.KeyResourcesService;

@SuppressWarnings("serial")
public class KeyResourcesWorkFromHomeStaffAction extends KeyResourcesAction {

	// service
	private KeyResourcesService keyResourcesService;
	
	// bean
	private WorkFromHomeStaffBasicsDTO workFromHomeStaffBasics;
	
	public KeyResourcesWorkFromHomeStaffAction(KeyResourcesService keyResourcesService) {
		super();
		this.keyResourcesService = keyResourcesService;
		this.setValidateAction(new ValidateAction());
	}
	
	public WorkFromHomeStaffBasicsDTO getWorkFromHomeStaffBasics() {
		return this.workFromHomeStaffBasics;
	}

	public void setWorkFromHomeStaffBasics(WorkFromHomeStaffBasicsDTO workFromHomeStaffBasics) {
		this.workFromHomeStaffBasics = workFromHomeStaffBasics;
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
			WorkFromHomeStaffBasicsDTO dto = KeyResourcesWorkFromHomeStaffAction.this.workFromHomeStaffBasics;
			int id = KeyResourcesWorkFromHomeStaffAction.this.getSessionPlan().id;
			KeyResourcesWorkFromHomeStaffAction.this.keyResourcesService.updateWorkFromHome(id, dto.isWorkFromHomeNA, dto.workFromHomeNAExplanation);
			return SUCCESS;
		}
	}
	
	public class ReadBasicsAction implements ReadRowAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesWorkFromHomeStaffAction.this.keyResourcesService;
			int rowId = KeyResourcesWorkFromHomeStaffAction.this.getOwnerId();
			KeyResources kr = service.getKeyResources(rowId);
			KeyResourcesWorkFromHomeStaffAction.this.workFromHomeStaffBasics = new WorkFromHomeStaffBasicsDTO(kr);
			return SUCCESS;
		}
	}
	
	public class ValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			WorkFromHomeStaffMemberDTO dto = (WorkFromHomeStaffMemberDTO) dObjDTO;
			if (dto.name != null && dto.name.trim().length() != 0) return true;
			return null;
		}
	}
	
}
