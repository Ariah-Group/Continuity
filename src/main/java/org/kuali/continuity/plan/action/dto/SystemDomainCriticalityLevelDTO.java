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
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.admin.domain.SystemDomainCentralApplicationCriticalityLevel;
import org.kuali.continuity.admin.domain.SystemDomainCriticalFunctionCriticalityLevel;
import org.kuali.continuity.admin.domain.SystemDomainCriticalityLevel;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CriticalFunctionCriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;

@SuppressWarnings("serial")
public class SystemDomainCriticalityLevelDTO extends DomainObjectDTO
	implements DomainObjectValue, DTOValue {
	
	public enum LevelType {APPL, FUNC};
	public LevelType levelType;
	public RefDTO levelNo = new RefDTO();
	public String description;
	public String longDescription;
	public int systemDomainId;
	public String origDescription;

	public SystemDomainCriticalityLevelDTO() {
		super();
	}

	public SystemDomainCriticalityLevelDTO(BaseDomainObject obj) {
		super(obj);
	}

	public SystemDomainCriticalityLevelDTO(int id, String name) {
		super(id, name);
	}

	public SystemDomainCriticalityLevelDTO(int id) {
		super(id);
	}
	
	public SystemDomainCriticalityLevelDTO(CriticalityLevelEnum levelEnum) {
		super();
		if (levelEnum != null)
			this.levelNo = new RefDTO(levelEnum.getValue(), levelEnum.name());
	}

	public SystemDomainCriticalityLevelDTO(CriticalityLevel dObj) {
		if (dObj instanceof BaseDomainObject)
			this.copyFromDomainObject((BaseDomainObject)dObj);
	}

	@Override
	public SystemDomainCriticalityLevel getDomainObject() {
		SystemDomainCriticalityLevel cLevel = 
			this.levelType.equals(LevelType.FUNC) ?
			new SystemDomainCriticalFunctionCriticalityLevel() :
			new SystemDomainCentralApplicationCriticalityLevel();
		cLevel.setId(this.id);
		cLevel.setName(this.name);
		if (levelNo != null)
			cLevel.setCriticalityLevelEnum(CriticalityLevelEnum.getEnum(this.levelNo.id));
		cLevel.setDescription(description);
		cLevel.setLongDescription(longDescription);
		cLevel.setSystemDomainId(systemDomainId);
		return cLevel;
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject dObj) {
		if (dObj == null) return;
		this.id = (dObj.getId() == null ? 0 : dObj.getId());
		this.name = dObj.getName();
		if (!(dObj instanceof CriticalityLevel)) return;
		CriticalityLevel obj = (CriticalityLevel) dObj;
		this.levelType = obj instanceof CriticalFunctionCriticalityLevel ? 
			LevelType.FUNC : LevelType.APPL;
		this.description = obj.getDescription();
		this.origDescription = obj.getDescription();
		this.longDescription = obj.getLongDescription();
		CriticalityLevelEnum levelEnum = obj.getCriticalityLevelEnum();
		if (levelEnum != null)
			this.levelNo = new RefDTO(levelEnum.getValue(), levelEnum.name());
		if (obj instanceof SystemDomainCriticalityLevel)
			this.systemDomainId = ((SystemDomainCriticalityLevel)obj).getSystemDomainId();
	}

}
