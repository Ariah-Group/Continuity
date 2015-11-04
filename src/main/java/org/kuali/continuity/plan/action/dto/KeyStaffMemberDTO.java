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
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.KeyStaffMember;

@SuppressWarnings("serial")
public class KeyStaffMemberDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {

	public PlanDTO plan = new PlanDTO();
	public String firstName;
	public String lastName;
	public String titleOrFunction;
	public String specialSkill;
	public String comment;
	public boolean isFirstSuccessor;
	public boolean isSecondSuccessor;
	public boolean isThirdSuccessor;
	public boolean isHoldingDelegation;
	
	public KeyStaffMemberDTO() {
		super();
	}

	public KeyStaffMemberDTO(BaseDomainObject obj) {
		super(obj);
	}

	public KeyStaffMemberDTO(int id, String name) {
		super(id, name);
	}

	public KeyStaffMemberDTO(int id) {
		super(id);
	}

	public KeyStaffMemberDTO(KeyStaffMember keyStaffMember) {
		this.copyFromDomainObject(keyStaffMember);
	}
	
	public KeyStaffMember getDomainObject() {
		KeyStaffMember ksm = new KeyStaffMember();
		ksm.setComment(this.comment);
		ksm.setFirstName(this.firstName);
		ksm.setFirstSuccessor(this.isFirstSuccessor);
		ksm.setHoldingDelegation(this.isHoldingDelegation);
		ksm.setId(this.id);
		ksm.setLastName(this.lastName);
		ksm.setSecondSuccessor(this.isSecondSuccessor);
		ksm.setSpecialSkill(this.specialSkill);
		ksm.setThirdSuccessor(this.isThirdSuccessor);
		ksm.setTitleOrFunction(this.titleOrFunction);
		if (this.plan != null)
			ksm.setPlan(new ContinuityPlan(this.plan.id));
		return ksm;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof KeyStaffMember)) return;
		KeyStaffMember keyStaffMember = (KeyStaffMember) copyObj;
		
		// set other fields
		this.comment = keyStaffMember.getComment();
		this.firstName = keyStaffMember.getFirstName();
		this.lastName = keyStaffMember.getLastName();
		this.specialSkill = keyStaffMember.getSpecialSkill();
		this.titleOrFunction = keyStaffMember.getTitleOrFunction();
		this.isFirstSuccessor = keyStaffMember.isFirstSuccessor();
		this.isHoldingDelegation = keyStaffMember.isHoldingDelegation();
		this.isSecondSuccessor = keyStaffMember.isSecondSuccessor();
		this.isThirdSuccessor = keyStaffMember.isThirdSuccessor();
	}

}
