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
package org.kuali.continuity.plan.action.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.domain.OfficeEquipmentMinimum;

public class EquipmentRequirementsDTO {

	public Map<String, OfficeEquipmentMinimumDTO> officeEquipmentMins = 
		new HashMap<String, OfficeEquipmentMinimumDTO>();
	public String otherEquipmentNeeds;
	public String suppliesNeeds;
	public String supplyCrisisActions;

	public EquipmentRequirementsDTO() {
		super();
	}

	public EquipmentRequirementsDTO(KeyResources dObj) {
		if (dObj == null) return;
		this.otherEquipmentNeeds = dObj.getOtherEquipmentNeeds();
		this.suppliesNeeds = dObj.getSuppliesNeeds();
		this.supplyCrisisActions = dObj.getSupplyCrisisActions();
		Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> mins =
			dObj.getOfficeEquipmentMinimums();
		if (mins == null) return;
		Set<OfficeEquipmentMinimum.Type> minTypes = mins.keySet();
		for (OfficeEquipmentMinimum.Type minType : minTypes) {
			this.officeEquipmentMins.put(minType.name(), 
				new OfficeEquipmentMinimumDTO(mins.get(minType)));
		}
	}

}
