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
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.domain.BaseDomainObject;

@SuppressWarnings("serial")
public class AcronymDTO extends DomainObjectDTO implements
		DomainObjectValue, DTOValue {

	public AcronymDTO() {
		super();
	}

	public AcronymDTO(BaseDomainObject obj) {
		super(obj);
	}

	public AcronymDTO(int id, String name) {
		super(id, name);
	}

	public AcronymDTO(int id) {
		super(id);
	}
	
	public AcronymDTO(Acronym dObj) {
		this.copyFromDomainObject(dObj);
	}

	@Override
	public Acronym getDomainObject() {
		return new Acronym(this.id, this.name);
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject dObj) {
		if (dObj == null) return;
		this.id = (dObj.getId() == null ? 0 : dObj.getId());
		if (!(dObj instanceof Acronym)) return;
		Acronym obj = (Acronym) dObj;
		this.name = obj.getName() + " (" + obj.getFullName() + ")";
	}

}
