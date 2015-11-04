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

import java.math.BigDecimal;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.StaffingRequirement;

@SuppressWarnings("serial")
public class StaffingRequirementDTO extends DomainObjectDTO implements
		DomainObjectValue, DTOValue {

	public PlanDTO plan = new PlanDTO();
	public CriticalFunctionDTO criticalFunction = new CriticalFunctionDTO();
	public DomainObjectDTO staffCategory = new DomainObjectDTO();
	public DomainObjectDTO shift = new DomainObjectDTO();
	// problems with float conversion in struts when it is zero
	public BigDecimal fteNormal = new BigDecimal(0);
	public BigDecimal fteCrisis = new BigDecimal(0);

	public StaffingRequirementDTO() {
		super();
	}

	public StaffingRequirementDTO(BaseDomainObject obj) {
		super(obj);
	}

	public StaffingRequirementDTO(int id, String name) {
		super(id, name);
	}

	public StaffingRequirementDTO(int id) {
		super(id);
	}
	
	public StaffingRequirementDTO(StaffingRequirement dObj) {
		this.copyFromDomainObject(dObj);
	}

	public StaffingRequirement getDomainObject() {
		StaffingRequirement dObj = new StaffingRequirement();
		dObj.setId(this.id == 0 ? null : this.id);
		dObj.setName(this.name);
		dObj.setFteNormal(this.fteNormal == null ? 0 : this.fteNormal.floatValue());
		dObj.setFteCrisis(this.fteCrisis == null ? 0 : this.fteCrisis.floatValue());
		if (this.plan != null)
			dObj.setPlan(this.plan.getDomainObject());
		if (this.criticalFunction != null)
			dObj.setCriticalFunction(this.criticalFunction.getDomainObject());
		if (this.staffCategory != null)
			dObj.setStaffCategory(new StaffCategory(this.staffCategory.id));
		if (this.shift != null)
			dObj.setShift(new Shift(this.shift.id));
		return dObj;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof StaffingRequirement)) return;
		StaffingRequirement dObj = (StaffingRequirement) copyObj;
		
		// set other fields
		this.fteNormal = new BigDecimal(dObj.getFteNormal());
		this.fteCrisis = new BigDecimal(dObj.getFteCrisis());
		if (dObj.getCriticalFunction() != null)
			this.criticalFunction = new CriticalFunctionDTO(dObj.getCriticalFunction());
		if (dObj.getStaffCategory() != null)
			this.staffCategory = new DomainObjectDTO(dObj.getStaffCategory());
		if (dObj.getShift() != null)
			this.shift = new DomainObjectDTO(dObj.getShift());
	}

}
