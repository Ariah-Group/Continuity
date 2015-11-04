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
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.domain.BaseDomainObject;


@SuppressWarnings("serial")
public class SkillDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {
	
	public String description;
	public boolean isUserDefined;
	public SystemDomainDTO systemDomain = new SystemDomainDTO();
	public String comment;

	public SkillDTO() {
		super();
	}

	public SkillDTO(BaseDomainObject obj) {
		super(obj);
	}

	public SkillDTO(int id, String name) {
		super(id, name);
	}

	public SkillDTO(int id) {
		super(id);
	}
	
	public SkillDTO(Skill dObj) {
		this.copyFromDomainObject(dObj);
	}

	public Skill getDomainObject() {
		Skill dObj = new Skill();
		dObj.setId(this.id == 0 ? null : this.id);
		dObj.setName(this.name);
		dObj.setDescription(this.description);
		dObj.setUserDefined(this.isUserDefined);
		if (this.systemDomain != null & this.systemDomain.id != 0)
			dObj.setSystemDomainId(this.systemDomain.id);
		return dObj;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof Skill)) return;
		Skill dObj = (Skill) copyObj;
		
		// set other fields
		this.name = dObj.getName();
		this.description = dObj.getDescription();
		this.isUserDefined = dObj.isUserDefined();
	}

}
