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
package org.kuali.continuity.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.User;

public class UserLoginServiceTest extends BasePlanTest {

	private UserLoginService service;
	private UserService userService;

	public void setService(UserLoginService service) {
		this.service = service;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testChangePasswordAndAuthenticate() {
		String newPassword = "test123";
		this.service.changePassword(PlanTestData.uc_user, newPassword);
		User user = this.userService.getById(PlanTestData.uc_user);
		boolean success = this.service.authenticate(user.getSystemDomainId(), user.getAuthId(), newPassword);
		assertTrue(success);
	}
	
	public void testAutoApproveUserLogin() {
		List<User> testUsers = 
			this.userService.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
		long origCount = testUsers.size();
		if (origCount > 0) {
			User user = this.userService.getById(PlanTestData.uc_user);
			this.service.autoApproveUserLogin(user, null);
			testUsers = 
				this.userService.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
			long newCount = testUsers.size();
			assertEquals(origCount, newCount+1);
		}
	}
	
	public void testApproveUserLogins() {
		List<User> users = new ArrayList<User>();
		List<User> testUsers = 
			this.userService.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
		long origCount = testUsers.size();
		if (origCount > 0) {
			users.add(this.userService.getById(PlanTestData.uc_user));
			this.service.approveUserLogins(users, true, null);
			testUsers = 
				this.userService.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
			long newCount = testUsers.size();
			assertEquals(origCount, newCount+1);
		}
	}

}
