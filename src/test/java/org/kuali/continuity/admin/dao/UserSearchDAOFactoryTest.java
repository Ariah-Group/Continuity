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

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;

@Deprecated
public class UserSearchDAOFactoryTest extends DomainObjectTest {

	private UserSearchDAOFactory factory;
	private SystemDomainDAO systemDomainDAO;
	
	public void setUserSearchDAOFactory(UserSearchDAOFactory factory) {
		this.factory = factory;
	}
	
	public void setSystemDomainDAO(SystemDomainDAO systemDomainDAO) {
		this.systemDomainDAO = systemDomainDAO;
	}
	
	public void testInjection() {
		String message = "Factory is: " + this.factory.toString();
		System.out.println(message);
		assertNotNull(this.factory);
	}
	
	public void testGetUserList() {
		List<SystemDomain> systemDomains = this.systemDomainDAO.getAll();
		for (SystemDomain systemDomain : systemDomains) {
			UserSearchDAO userSearchDAO  = this.factory.getUserSearchDAO(systemDomain.getId());
			System.out.println(
				String.format("%s Search for System Domain Id = %d (%s)", 
					(userSearchDAO instanceof UserDAO ? "DB" : "LDAP"), systemDomain.getId(), systemDomain.getName()));
			try {
				List<User> users = userSearchDAO.getListBySystemDomainIdAndNames(systemDomain.getId(), "", "Tom");
				this.printDomainObjectList(users);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
