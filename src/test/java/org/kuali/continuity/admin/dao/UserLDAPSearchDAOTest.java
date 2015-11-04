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

import java.util.List;

import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.User;

public class UserLDAPSearchDAOTest extends AdminDAOTest {

	private UserSearchDAO dao;
	
	public void setDAO(UserSearchDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}
	
	public void testGetList() throws Exception {
		String firstName = "Tom";
		String lastName  = "";
		List<User> users = this.dao.getListBySystemDomainIdAndNames(PlanTestData.wellknown_institution, firstName, lastName);
//		this.doTestList(users);
		for (User user : users) {
			if (user == null) continue;
			System.out.println("User: " + user.getFirstName() + " " + user.getLastName());
			
		}
	}
	
}
