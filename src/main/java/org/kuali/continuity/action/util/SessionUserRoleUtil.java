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
package org.kuali.continuity.action.util;

import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.service.SystemDomainService;

public class SessionUserRoleUtil {
	
	private SystemDomainService systemDomainService;
	
	public SessionUserRoleUtil(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}
	
	public void setSessionUserRole(SessionUserDTO userDTO, int systemDomainId) {
		SystemDomain systemDomain = (SystemDomain) this.systemDomainService.getById(systemDomainId);
		this.setSessionUserRole(userDTO, systemDomain);
	}
	
	private void setSessionUserRole(SessionUserDTO userDTO, SystemDomain systemDomain) {
		// set system domain dto
		SessionSystemDomainDTO systemDomainDTO = new SessionSystemDomainDTO(systemDomain);
		
		// set user dto
		userDTO.systemDomain = systemDomainDTO;
		userDTO.isLBNLUser = systemDomainDTO.isLBNL;
		userDTO.systemDomainAccess = new RefDTO(systemDomain.getSystemDomainAccess());		
		userDTO.isShibMode = systemDomain.isShibMode();
	}
}
