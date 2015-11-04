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
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.ReadRowAction;
import org.kuali.continuity.action.UpdateAction;
import org.kuali.continuity.plan.action.dto.EquipmentRequirementsDTO;
import org.kuali.continuity.plan.action.dto.OfficeEquipmentMinimumDTO;
import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.domain.OfficeEquipmentMinimum;
import org.kuali.continuity.plan.service.KeyResourcesService;

@SuppressWarnings("serial")
public class KeyResourcesEquipmentReqsAction extends KeyResourcesAction {
	
	// service
	private KeyResourcesService keyResourcesService;
	
	// bean
	private EquipmentRequirementsDTO equipReqs;
	
	public KeyResourcesEquipmentReqsAction(KeyResourcesService keyResourcesService) {
		super();
		this.keyResourcesService = keyResourcesService;
	}
	
	public EquipmentRequirementsDTO getEquipReqs() {
		return this.equipReqs;
	}

	public void setEquipReqs(EquipmentRequirementsDTO equipReqs) {
		this.equipReqs = equipReqs;
	}
	
	public void prepare() throws Exception {
		super.prepare();
		this.setUpdateAction(new EquipmentReqsUpdateAction());
		this.setReadRowAction(new EquipmentReqsReadRowAction());
	}

	//--- actions ---//
	
	public class EquipmentReqsUpdateAction implements UpdateAction {
		public String execute() throws Exception {
			// set service and owner id
			KeyResourcesService service = KeyResourcesEquipmentReqsAction.this.keyResourcesService;
			int ownerId = KeyResourcesEquipmentReqsAction.this.getOwnerId();
			
			// init
			Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> mins = 
				new HashMap<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum>();
			
			// dto
			Map<String, OfficeEquipmentMinimumDTO> dtoMins =
				KeyResourcesEquipmentReqsAction.this.equipReqs.officeEquipmentMins;
			if (dtoMins != null) {
				Set<String> keys = dtoMins.keySet();
				for (String key : keys) {
					mins.put(OfficeEquipmentMinimum.Type.valueOf(key), dtoMins.get(key).getOfficeEquipmentMinimum());
				}
			}
			
			// update
			service.updateEquipmentAndSupplies(ownerId, 
				mins, equipReqs.otherEquipmentNeeds, equipReqs.suppliesNeeds, equipReqs.supplyCrisisActions);
			
			// return
			return SUCCESS;
		}
	}
	
	public class EquipmentReqsReadRowAction implements ReadRowAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesEquipmentReqsAction.this.keyResourcesService;
			int ownerId = KeyResourcesEquipmentReqsAction.this.getOwnerId();
			KeyResources kr = service.getKeyResources(ownerId);
			KeyResourcesEquipmentReqsAction.this.equipReqs = new EquipmentRequirementsDTO(kr);
			return SUCCESS;
		}
	}
	

}
