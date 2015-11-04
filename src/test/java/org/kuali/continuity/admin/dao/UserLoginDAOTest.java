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
package org.kuali.continuity.admin.dao;

import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.User;

public class UserLoginDAOTest extends AdminDAOTest {
	
	private UserLoginDAO dao;
	private UserDAO userDAO;
	
	public void setUserLoginDAO(UserLoginDAO dao) {
		this.dao = dao;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	public void testInjection() {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}
	
	public void testAuthenticate() {
		boolean success = this.dao.authenticate(PlanTestData.uc_institution, "UCSFAdmin", "test");
		assertTrue(success);
	}

	public void testChangePassword() {
		String newPassword = "testing";
		this.dao.changePassword(PlanTestData.uc_user, newPassword);
		User user = this.userDAO.getById(PlanTestData.uc_user);
		boolean success = this.dao.authenticate(user.getSystemDomainId(), user.getAuthId(), newPassword);
		assertTrue(success);
	}
	
	public void testApproveUserLogin() {
		List<User> testUsers = 
			this.userDAO.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
		long origCount = testUsers.size();
		if (origCount > 0) {
			User user = testUsers.get(0);
			this.dao.approveUserLogin(user, true);
			testUsers = 
				this.userDAO.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
			long newCount = testUsers.size();
			assertEquals(origCount, newCount+1);
		}
	}
	
	public void testApproveUserLogins() {
		List<User> users = new ArrayList<User>();
		List<User> testUsers = 
			this.userDAO.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
		long origCount = testUsers.size();
		if (origCount > 0) {
			for (int i=0; i < 2; i++) 
				users.add(testUsers.get(i));
			this.dao.approveUserLogins(users, true);
			testUsers = 
				this.userDAO.getUnapprovedListBySystemDomainId(PlanTestData.uc_institution);
			long newCount = testUsers.size();
			assertEquals(origCount, newCount+2);
		}
	}

}