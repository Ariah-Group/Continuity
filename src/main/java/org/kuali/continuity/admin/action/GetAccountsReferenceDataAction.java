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
package org.kuali.continuity.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
//import org.kuali.continuity.admin.domain.SystemDomain;
//import org.kuali.continuity.domain.UserAccess;
//import org.kuali.continuity.domain.UserRole;
//import org.kuali.continuity.service.RoleService;
//
import com.opensymphony.xwork2.Action;



public class GetAccountsReferenceDataAction implements Action {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
//	private RoleService roleService;
//	private Map<Integer, SystemDomain> systemDomains;
//	private SystemDomain currentSystemDomain;
//	private UserRole[] userRoles = UserRole.values();
//	private UserAccess[] userAccess = UserAccess.values();
//	
//	public GetAccountsReferenceDataAction(RoleService roleService) {
//		this.roleService = roleService;
//	}
//	
//	public Map<Integer, SystemDomain> getSystemDomains() {
//		return systemDomains;
//	}
//
//	public void setSystemDomains(Map<Integer, SystemDomain> systemDomains) {
//		this.systemDomains = systemDomains;
//	}
//
//	public UserRole[] getUserRoles() {
//		return userRoles;
//	}
//
//	public void setUserRoles(UserRole[] userRoles) {
//		this.userRoles = userRoles;
//	}
//
//	public UserAccess[] getUserAccess() {
//		return userAccess;
//	}
//
//	public void setUserAccess(UserAccess[] userAccess) {
//		this.userAccess = userAccess;
//	}
//
//	public void setCurrentSystemDomain(SystemDomain currentSystemDomain) {
//		this.currentSystemDomain = currentSystemDomain;
//	}
//
//	public SystemDomain getCurrentSystemDomain() {
//		return currentSystemDomain;
//	}
//
//	public String execute() {
//		List<SystemDomain> systemDomainList = this.roleService.getInstitutions();
//		Map<Integer, SystemDomain> map = new HashMap<Integer, SystemDomain>();
//		if (systemDomainList != null && !systemDomainList.isEmpty()) {
//			for (SystemDomain systemDomain : systemDomainList) {
//				map.put(systemDomain.getInstitutionId(), systemDomain);
//			}
//		}
//		this.setCurrentSystemDomain(map.get(1));  // TODO: refactor - for poc only.  should be getting from session
//		this.setSystemDomains(map);
//		return SUCCESS;
//	}
}