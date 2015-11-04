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

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.domain.BaseDomainObject;

@SuppressWarnings("serial")
public class BuildingDTO extends DomainObjectDTO implements DTOValue {
	
	public String commonName;
	public String comment = "";
	public RefDTO ownership = new RefDTO();
	
	public BuildingDTO() {
		super();
	}
	
	public BuildingDTO(int id) {
		super(id);
	}
	
	public BuildingDTO(int id, String name) {
		super(id, name);
	}
	
	public BuildingDTO(BaseDomainObject dObj) {
		super(dObj);
	}
	
	public BuildingDTO(Building building) {
		this.copyFromDomainObject(building);
	}

	public void copyFromDomainObject(BaseDomainObject obj) {
		if (obj == null) return;
		this.id = (obj.getId() == null ? 0 : obj.getId());
		this.name = obj.getName();
		if (!(obj instanceof Building)) return;
		Building building = (Building) obj;
		this.commonName = building.getCommonName();
	    this.ownership = new RefDTO(building.getOwnership());
	}

}
