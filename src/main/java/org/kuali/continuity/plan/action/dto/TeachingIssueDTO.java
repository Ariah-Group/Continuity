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
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.plan.domain.TeachingIssue;

@SuppressWarnings("serial")
public class TeachingIssueDTO extends DomainObjectDTO  implements
	DomainObjectValue, DTOValue {

	public DomainObjectDTO instruction = new DomainObjectDTO();
	public String impact;
	public String alternatives;

	public TeachingIssueDTO() {
		super();
	}

	public TeachingIssueDTO(BaseDomainObject obj) {
		super(obj);
	}

	public TeachingIssueDTO(int id, String name) {
		super(id, name);
	}

	public TeachingIssueDTO(int id) {
		super(id);
	}

	public TeachingIssueDTO(TeachingIssue dObj) {
		this.copyFromDomainObject(dObj);
	}

	@Override
	public TeachingIssue getDomainObject() {
		TeachingIssue dObj = new TeachingIssue();
		dObj.setId(this.id == 0 ? null : this.id);
		dObj.setName(this.name);
		if (this.instruction != null && this.instruction.id != 0)
			dObj.setInstruction(new Instruction(this.instruction.id));
		dObj.setImpact(this.impact);
		dObj.setAlternatives(this.alternatives);
		return dObj;
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof TeachingIssue)) return;
		TeachingIssue obj = (TeachingIssue) copyObj;
		
		// set other fields
		this.impact = obj.getImpact();
		this.alternatives = obj.getAlternatives();
	}

}
