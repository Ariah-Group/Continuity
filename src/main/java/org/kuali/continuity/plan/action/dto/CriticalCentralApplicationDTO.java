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
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CriticalCentralApplication;

@SuppressWarnings("serial")
public class CriticalCentralApplicationDTO extends DomainObjectDTO implements
		DomainObjectValue, DTOValue, Comparable<CriticalCentralApplicationDTO> {
	
	public PlanDTO plan = new PlanDTO();
	public DomainObjectDTO centralApplication = new DomainObjectDTO();
	public SystemDomainCriticalityLevelDTO criticalityLevel = new SystemDomainCriticalityLevelDTO();
	public String comment;
	
	public CriticalCentralApplicationDTO() {
		super();
	}

	public CriticalCentralApplicationDTO(BaseDomainObject obj) {
		super(obj);
	}

	public CriticalCentralApplicationDTO(int id, String name) {
		super(id, name);
	}

	public CriticalCentralApplicationDTO(int id) {
		super(id);
	}
	
	public CriticalCentralApplicationDTO(CriticalCentralApplication obj) {
		this.copyFromDomainObject(obj);
	}

	public BaseDomainObject getDomainObject() {
		CriticalCentralApplication obj = new CriticalCentralApplication();
		obj.setId(this.id);
		obj.setName(this.name);
		if (this.plan != null && this.plan.id != 0)
			obj.setPlan(new ContinuityPlan(this.plan.id));
		if (this.centralApplication != null && this.centralApplication.id != 0)
			obj.setCentralApplication(new CentralApplication(this.centralApplication.id));
		if (this.criticalityLevel != null)
			obj.setCriticalityLevelEnum(CriticalityLevelEnum.getEnum(this.criticalityLevel.levelNo.id));
		obj.setComment(this.comment);
		return obj;
	}

	public void copyFromDomainObject(BaseDomainObject dObj) {
		if (dObj == null) return;
		this.id = (dObj.getId() == null ? 0 : dObj.getId());
		this.name = dObj.getName();
		if (!(dObj instanceof CriticalCentralApplication)) return;
		CriticalCentralApplication obj = (CriticalCentralApplication) dObj;
		this.centralApplication = new DomainObjectDTO(obj.getCentralApplication());
		this.criticalityLevel = new SystemDomainCriticalityLevelDTO(obj.getCriticalityLevelEnum());
		this.comment = obj.getComment();
		this.plan = new PlanDTO(obj.getPlan().getId());
	}
	
	public int compareTo(CriticalCentralApplicationDTO o) {
        return this.centralApplication.name.toLowerCase().compareTo(o.centralApplication.name.toLowerCase());
    }
}
