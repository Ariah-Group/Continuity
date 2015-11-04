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
package org.kuali.continuity.action;

import org.kuali.continuity.admin.service.UserLoginService;

@SuppressWarnings("serial")
public class UserLoginAction extends BaseActionSupport {

	private UserLoginService userLoginService;
	private int systemDomainId = 29; // TODO: remove later.  for testing only
	private String authId;
	private String passwd;
	
	public UserLoginAction(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	public int getSystemDomainId() {
		return this.systemDomainId;
	}

	public void setSystemDomainId(int systemDomainId) {
		this.systemDomainId = systemDomainId;
	}

	public String getAuthId() {
		return this.authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String execute() throws Exception {
		boolean success = this.userLoginService.authenticate(this.systemDomainId, this.authId, this.passwd);
		if (success) return SUCCESS;
		this.addActionError("Unrecognized login name and password, please try again.");
		return INPUT;
	}

	@Override
	public void prepare() throws Exception {
		// do nothing;
	}

}
