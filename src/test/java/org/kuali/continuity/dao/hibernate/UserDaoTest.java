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
package org.kuali.continuity.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.dao.UserDao;
import org.kuali.continuity.domain.User;
import org.kuali.continuity.domain.valueobject.UserListValue;

public class UserDaoTest extends AbstractHibernateDaoItests {
	private static final Logger log = Logger
	.getLogger(UserDaoTest.class);
	UserDao userDao;
	
	// Spring injected.
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
		
	}
	@Test
	public void testUser() {
		User u = (User) userDao.get(PlanTestData.known_user);
		System.out.println(u.getFirstName()+" "+u.getLastName());
		List<User>users =userDao.list(PlanTestData.wellknown_institution);
		for (User iu: users) {
			System.out.println(iu.getFirstName()+" "+iu.getLastName()+", "+iu.getEmailregular()+" "+iu.getDirectoryId());
		}
	}
	@Test
	public void testUserValue() {
		List <UserListValue> uvl = userDao.valueList(PlanTestData.wellknown_institution);
        String cma="";
       
		for (UserListValue uv : uvl) {
        	System.out.print(cma+uv.getName());
        	cma=", ";
        }
		System.out.println("");
	}
	@Test
	public void testUserUpdate() {
		User u = (User) userDao.get(PlanTestData.known_changable_user);
		System.out.println(u.getFirstName()+" "+u.getLastName());
	 
		u.setDepartmentName("Billing & Payments Dept");
	    userDao.update(u);
	    List<User>users =userDao.list(PlanTestData.wellknown_institution);
		for (User iu: users) {
			if (iu.getUserId()==PlanTestData.known_changable_user) {
				System.out.println(iu.getFirstName()+" "+iu.getLastName()+", "+iu.getEmailregular()+" "+iu.getDirectoryId());
				System.out.println(iu.getDepartmentName());
	
			}
			
		}
		
	}
	@Test
	public void testUserUpdated() {
		User u = (User) userDao.get(PlanTestData.known_changable_user);
		System.out.println(u.getDepartmentName());

		
	}

}
