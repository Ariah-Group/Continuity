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
public class SessionSystemDomainDTO extends SystemDomainDTO implements SessionValue {
	
	// display constants
	public SystemDomainDisplayConstantsDTO displayConstants = new SystemDomainDisplayConstantsDTO(false);
	
	// settings
	public SystemDomainSettingsDTO settings = new SystemDomainSettingsDTO();
	
	// access
	public RefDTO systemDomainAccess = new RefDTO();
	
	// system name
	public String systemName = "";
	public String customUrl = "";
	public String shibUniqueId = "";
	
	public SessionSystemDomainDTO() {
		super();
	}
	
	public SessionSystemDomainDTO(int id) {
		super(id);
	}

	public SessionSystemDomainDTO(int id, String name) {
		super(id, name);
	}
	
	public SessionSystemDomainDTO(int id, String name, String customUrl) {
		super(id, name);
		this.customUrl = customUrl;
	}
	
	public SessionSystemDomainDTO(SystemDomain dObj) {
		this.copyFromDomainObject(dObj);
	}
	
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		if (copyObj == null) return;
		super.copyFromDomainObject(copyObj);
		if (!(copyObj instanceof SystemDomain)) return;
		SystemDomain dObj = (SystemDomain) copyObj;
		this.displayConstants = new SystemDomainDisplayConstantsDTO(dObj.isLBNL());
		this.settings.isCriticalFunctionsScreenVisible = dObj.getSettings().isCriticalFunctionsScreenVisible();
		this.settings.isSkillsScreenVisible = dObj.getSettings().isSkillsScreenVisible();
		this.settings.isStaffRequirementsScreenVisible = dObj.getSettings().isStaffRequirementsScreenVisible();
		this.settings.isTeamsScreenVisible = dObj.getSettings().isTeamsScreenVisible();
		this.settings.isInstructionVisible = dObj.getSettings().isInstructionVisible();
		this.settings.isCriticalLevelDetailsVisible = dObj.getSettings().isCriticalLevelDetailsVisible();
		this.systemDomainAccess = new RefDTO(dObj.getSystemDomainAccess());
		this.systemName = dObj.getSystemName();
		this.customUrl = dObj.getCustomUrl();
		this.shibUniqueId = dObj.getShibUniqueId();
	}

}
