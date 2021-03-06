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
import org.kuali.continuity.plan.domain.ContactInfo;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.OtherUnitStaffMember;

@SuppressWarnings("serial")
public class OtherUnitStaffMemberDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {

	public PlanDTO plan = new PlanDTO();
	public String firstName;
	public String lastName;
	public String department;
	public String address;
	public String workPhone;
	public String cellPhone;
	public String fax;
	public String email;
	public String comment;
	
	public OtherUnitStaffMemberDTO() {
		super();
	}

	public OtherUnitStaffMemberDTO(BaseDomainObject obj) {
		super(obj);
	}

	public OtherUnitStaffMemberDTO(int id, String name) {
		super(id, name);
	}

	public OtherUnitStaffMemberDTO(int id) {
		super(id);
	}
	
	public OtherUnitStaffMemberDTO(OtherUnitStaffMember dObj) {
		this.copyFromDomainObject(dObj);
	}

	public OtherUnitStaffMember getDomainObject() {
		OtherUnitStaffMember dObj = new OtherUnitStaffMember();
		dObj.setId(this.id == 0 ? null : this.id);
		dObj.setFirstName(this.firstName);
		dObj.setLastName(this.lastName);
		dObj.setDepartment(this.department);
		dObj.setComment(this.comment);
		ContactInfo cInfo = new ContactInfo();
		cInfo.setAddress(this.address);
		cInfo.setWorkPhone(this.workPhone);
		cInfo.setCellPhone(this.cellPhone);
		cInfo.setFax(this.fax);
		cInfo.setEmail(this.email);
		dObj.setContactInfo(cInfo);
		if (this.plan != null)
			dObj.setPlan(new ContinuityPlan(this.plan.id));
		return dObj;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof OtherUnitStaffMember)) return;
		OtherUnitStaffMember dObj = (OtherUnitStaffMember) copyObj;
		
		// set other fields
		this.firstName = dObj.getFirstName();
		this.lastName = dObj.getLastName();
		this.department = dObj.getDepartment();
		this.comment = dObj.getComment();
		if (dObj.getContactInfo() != null) {
			this.address = dObj.getContactInfo().getAddress();
			this.workPhone = dObj.getContactInfo().getWorkPhone();
			this.cellPhone = dObj.getContactInfo().getCellPhone();
			this.fax = dObj.getContactInfo().getFax();
			this.email = dObj.getContactInfo().getEmail();
		}
	}

}
