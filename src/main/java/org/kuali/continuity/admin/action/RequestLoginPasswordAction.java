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

import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionMessage;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.UserLoginService;
import org.kuali.continuity.admin.service.UserService;

@SuppressWarnings("serial")
public class RequestLoginPasswordAction extends BaseActionSupport {
	
	private UserService userService;
	private UserLoginService userLoginService;
	private String email;
	
	public RequestLoginPasswordAction(UserService userService, UserLoginService userLoginService) {
		this.userService = userService;
		this.userLoginService = userLoginService;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String start() throws Exception {
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		SystemDomainDTO systemDomainDTO = (SystemDomainDTO) this.getSessionValue(SessionKey.loginSystemDomain);
		if (systemDomainDTO == null)
			throw new Exception("Invalid page navigation!");
		User user = this.userService.getBySystemDomainIdAndEmail(systemDomainDTO.id, this.email);
		if (user == null) {
			this.addActionError("Email does not exist in the system.");
			return INPUT;
		}
		if (user.isModApproved() == null || !user.isModApproved()) {
			this.addActionError("User is pending approval.");
			return INPUT;
		}
		this.userLoginService.requestLoginPassword(user.getUserId());
		this.putInSession(SessionKey.tmpActionMessage, new SessionMessage("Request submitted. Thank you!"));
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		// do nothing;
	}
	
}
