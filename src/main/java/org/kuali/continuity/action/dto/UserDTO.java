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

import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.AccessStatus;
import org.kuali.continuity.domain.AccessStatusEnum;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;

@SuppressWarnings("serial")
public class UserDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {
	
	public String authId = "";
	public String firstName = "";
	public String lastName = "";
	public String fullName = "";
	public String title = "";
	public String emailRegular = "";
	public String workPhone = "";
	public String workFax = "";
	public String departmentName = "";
	public String departmentOrg = "";
	public String departmentOrgHierarchy = "";
	public SystemDomainDTO systemDomain = new SystemDomainDTO();
	public RefDTO securityType = new RefDTO();
	public RefDTO accessStatus = new RefDTO(); // AcessStatus (id)
	public boolean isSelected;  // used in approval page
	
	public UserDTO() {
		
	}
	
	public UserDTO(int id) {
		this.id = id;
	}
	
	public UserDTO(User user) {
		this.copyFromDomainObject(user);
	}

	public User getDomainObject() {
		User user = new User();
		user.setId(this.id == 0 ? null : this.id);
		user.setAuthId(this.authId);
		user.setFirstName(this.firstName);
		user.setLastName(this.lastName);
		user.setTitle(this.title);
		user.setEmailRegular(this.emailRegular);
		user.setWorkPhone(this.workPhone);
		user.setWorkFax(this.workFax);
		user.setDepartmentName(this.departmentName);
		user.setDepartmentOrg(this.departmentOrg);
		user.setDepartmentOrgHierarchy(this.departmentOrgHierarchy);
		user.setSystemDomainId(this.systemDomain == null ? 0 : this.systemDomain.id);
		user.setSecurityType(this.securityType == null || this.securityType.id.trim().length() == 0 ? 
			SecurityTypeEnum.LOCAL_USER.getRefDomainObject() : new SecurityType(this.securityType.id));
		user.setAccessStatus(new AccessStatus(accessStatus.id));
		// misc
		user.setAccessStatus(AccessStatusEnum.ON.getRefDomainObject());
		user.setAffiliations("");
		user.setCellPhone("");
		user.setEmailBackup("");
		user.setHomeAddress("");
		user.setHomePhone("");
		user.setLockStatus(AccessStatusEnum.OFF.getRefDomainObject());
		user.setWorkAddress("");
		// return
		return user;
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof User)) return;
		User user = (User) copyObj;
		
		// set other fields
		this.authId = user.getAuthId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.fullName = user.getFullName();
		this.name = user.getName();
		this.title = user.getTitle();
		this.emailRegular = user.getEmailRegular();
		this.workPhone = user.getWorkPhone();
		this.workFax = user.getWorkFax();
		this.departmentName = user.getDepartmentName();
		this.departmentOrg = user.getDepartmentOrg();
		this.departmentOrgHierarchy = user.getDepartmentOrgHierarchy();
		this.systemDomain = new SystemDomainDTO(user.getSystemDomainId());
		this.securityType = new RefDTO(user.getSecurityType());
		this.accessStatus = new RefDTO(user.getAccessStatus());
	}
}
