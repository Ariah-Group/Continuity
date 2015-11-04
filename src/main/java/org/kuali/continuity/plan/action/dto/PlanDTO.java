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

import java.util.Calendar;
import java.util.Date;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.action.dto.UserDTO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.BaseContinuityPlan;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;

@SuppressWarnings("serial")
public class PlanDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {

	public String acronymPlusName;
	public RefDTO status = new RefDTO();
	public AcronymDTO acronym = new AcronymDTO();
	public DomainObjectDTO majorDivision = new DomainObjectDTO();
	public SystemDomainDTO systemDomain;
	public Date createdDate;
	public Date lastModifiedDate;
	public boolean isImported;
	public int contactsCount;
	public RefDTO planAccess = new RefDTO();
	public UserDTO departmentHead = new UserDTO();
	
	public PlanDTO() {
		super();
	}
	
	public PlanDTO(int id) {
		super(id);
	}
	
	public PlanDTO(int id, String name) {
		super(id, name);
	}
	
	public PlanDTO(BaseContinuityPlan plan) {
		this.copyFromDomainObject(plan);
	}
	
	public ContinuityPlan getDomainObject() {
		ContinuityPlan plan = new ContinuityPlan(this.id);
		// TODO: set
		return plan;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = copyObj.getId();
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof BaseContinuityPlan)) return;
		BaseContinuityPlan plan = (BaseContinuityPlan) copyObj;
		
		// set other fields
		this.acronymPlusName = plan.getAcronymPlusName();
		this.status = new RefDTO(plan.getStatus());
		this.createdDate = plan.getCreatedDate();
		this.lastModifiedDate = plan.getLastModifiedDate();
		
		if (plan instanceof SimpleContinuityPlan) {
			// set count
			this.contactsCount = ((SimpleContinuityPlan)plan).getContactsSize();

			// set imported
			Calendar cal = Calendar.getInstance();
			cal.setTime(plan.getCreatedDate());
			if (cal.get(Calendar.DAY_OF_MONTH) == 1 && 
				cal.get(Calendar.MONTH) == Calendar.JANUARY && 
				cal.get(Calendar.YEAR) == 1900) this.isImported = true;

		} else if (plan instanceof ContinuityPlan){
			
			// load
			this.systemDomain = new SystemDomainDTO(plan.getSystemDomain());
			this.acronym = new AcronymDTO(plan.getAcronym());
			this.majorDivision = new DomainObjectDTO(plan.getMajorDivision());

			// department head
			User deptHead = ((ContinuityPlan)plan).getDepartmentHead();
			if (deptHead != null)
				this.departmentHead = new UserDTO(deptHead);			
		}
			
	}

}
