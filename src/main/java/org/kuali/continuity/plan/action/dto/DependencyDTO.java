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
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.DependencyType;
import org.kuali.continuity.domain.DependencyTypeEnum;

@SuppressWarnings("serial")
public class DependencyDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue, Comparable<DependencyDTO> {
	
	public boolean isUserDefined;
	public boolean isUpstream;
	public SystemDomainDTO systemDomain;
	
	public DependencyDTO() {
		super();
	}
	
	public DependencyDTO(BaseDomainObject obj) {
		super(obj);
	}
	
	public DependencyDTO(int id, String name) {
		super(id, name);
	}
	
	public DependencyDTO(int id) {
		super(id);
	}
	
	public DependencyDTO(Dependency dependency) {
		this.copyFromDomainObject(dependency);
	}
	
	public BaseDomainObject getDomainObject() {
		Dependency dependency = new Dependency(this.id);
		dependency.setName(this.name);
		dependency.setUserDefined(this.isUserDefined);
		dependency.setSystemDomainId(this.systemDomain.id);
		if (this.isUpstream)
			dependency.setDependencyType((DependencyType)DependencyTypeEnum.UPSTREAM.getRefDomainObject());
		else
			dependency.setDependencyType((DependencyType)DependencyTypeEnum.DOWNSTREAM.getRefDomainObject());
		return dependency;
	}
	
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof Dependency)) return;
		Dependency dependency = (Dependency) copyObj;
		
		// set other fields
		this.isUpstream = dependency.getDependencyType().equals(DependencyTypeEnum.UPSTREAM.getRefDomainObject());
		this.isUserDefined = dependency.isUserDefined();
	}
	
	public int compareTo(DependencyDTO o) {
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }

}
