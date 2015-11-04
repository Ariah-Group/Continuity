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
package org.kuali.continuity.action.dto;

import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.domain.BaseDomainObject;

@SuppressWarnings("serial")
public class SystemDomainDTO extends DomainObjectDTO implements DTOValue {

	public boolean isLBNL;
	public boolean isDirAccessible;
	public String systemDomainGroup = "";
	public String url;
	
	public SystemDomainDTO() {
		super();
	}
	
	public SystemDomainDTO(int id) {
		super(id);
	}

	public SystemDomainDTO(int id, String name) {
		super(id, name);
	}
	
	public SystemDomainDTO(SystemDomain dObj) {
		this.copyFromDomainObject(dObj);
	}
	
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof SystemDomain)) return;
		SystemDomain dObj = (SystemDomain) copyObj;
		
		// set other fields
		this.isLBNL = dObj.isLBNL();
		this.systemDomainGroup = dObj.getSystemDomainGroup() == null ? "" : dObj.getSystemDomainGroup();
	}

}
