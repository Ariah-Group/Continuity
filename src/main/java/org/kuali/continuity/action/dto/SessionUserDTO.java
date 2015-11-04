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

@SuppressWarnings("serial")
public class SessionUserDTO extends UserDTO implements SessionValue {
	
	@Deprecated
	public SystemDomainDTO memberSystemDomain;		// MemberInstitutionId (id), SubLocation (name)
	public RefDTO systemDomainAccess;				// SystemAccess	(either from primary or member)		
	public boolean isDirAccessible;					// DirectoryAccess (either from primary or member)
	public boolean isShibMode;						// AuthType (either from primary or member)
	public boolean isLBNLUser;						// LBNL (from systemDomainDTO.isLBNL)
	
	public SessionUserDTO() {
		super();
	}
	
	public SessionUserDTO(int id) {
		super(id);
	}
	
	public SessionUserDTO(User user) {
		super(user);
	}
	
	@Override
	public User getDomainObject() {
		User user = super.getDomainObject();
		return user;
	}
	
}
