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
package org.kuali.continuity.plan.action;

import org.kuali.continuity.admin.service.UserLoginService;


@SuppressWarnings("serial")
public class SaveUserPasswordAction extends UserProfileAction {

	private UserLoginService userLoginService;
	private String password;
	private String passwordConfirm;
	
	public SaveUserPasswordAction(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return this.passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	public String execute() throws Exception {
		this.userLoginService.changePassword(this.getUser().id, this.password);
		return SUCCESS;
	}
	
}
