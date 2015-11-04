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

import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.UserService;

@SuppressWarnings("serial")
public class SaveUserProfileAction extends UserProfileAction {
	
	private UserService userService;
	
	public SaveUserProfileAction(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() throws Exception {
		if (this.getUser().id != 0) {
			User user = this.userService.getById(this.getUser().id);
			user.setFirstName(this.getUser().firstName);
			user.setLastName(this.getUser().lastName);
			user.setTitle(this.getUser().title);
			user.setDepartmentName(this.getUser().departmentName);
			user.setEmailRegular(this.getUser().emailRegular);
			user.setWorkPhone(this.getUser().workPhone);
			this.userService.update(user, user);
		}
		return SUCCESS;
	}
	
}
