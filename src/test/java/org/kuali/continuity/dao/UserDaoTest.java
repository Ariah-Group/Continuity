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
package org.kuali.continuity.dao;

import java.util.List;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.domain.User;
import org.kuali.continuity.domain.valueobject.UserListValue;
import org.kuali.continuity.util.DataUtil;

public class UserDaoTest extends BasePlanTest {

	UserDao userDao;

	// Spring injected.
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	

	public void testUser() {
		User u = (User) userDao.get(PlanTestData.known_user);
		System.out.println(u.getFirstName() + " " + u.getLastName());
		List<User> users = userDao.list(PlanTestData.wellknown_institution);
		for (User iu : users) {
			System.out.println(iu.getFirstName() + " " + iu.getLastName()
					+ ", " + iu.getEmailregular() + " " + iu.getDirectoryId());
		}
	}

	public void testUserValue() {
		List<UserListValue> uvl = userDao
				.valueList(PlanTestData.wellknown_institution);
		String cma = "";
		for (UserListValue uv : uvl) {
			System.out.print(cma + uv.getName());
			cma = ", ";
		}
	}

	public void testUserValueSeq() {

		String[] seqs = { "lastName", "workPhone", "emailregular",
				"lastName + firstName" };
		for (String seq : seqs) {
			System.out.println(seq+":");
		
			List<UserListValue> uvl = userDao.valueListBy(
					PlanTestData.wellknown_institution, seq, 9999, "ASC");
			String cma = "";
			for (UserListValue uv : uvl) {
				System.out.print(cma + uv.getName());
				cma = ", ";
			}
			System.out.println("");
		}

	}
	public void testCreate() throws Exception {
		// create new key document

		User u  =  DataUtil.getEmptyUser();
		u.setFirstName("George");
		u.setLastName("Washington");
		
		u.setInstitutionId(1);
		u.setEmailbackup("gw@newyorkcity.gov");
		u.setEmailregular("gw@mountvernon.org");
		u.setAccessStatus("1");
		u.setAuthId("gw1");
		u.setCellPhone("");
	   
		u.setDepartmentName("Executive");
		if (null!=u.getUserId()) {
			System.out.println("User Id is other than null: "+u.getUserId());
		}
		
	    try {
	    	userDao.create(u);
	    }catch (Exception e) {
	    	System.out.println("Exception "+e);
	    	e.printStackTrace();
	    	fail();
	    }
	}
	public void testUserIdentityFields() {
	       User u = userDao.get(PlanTestData.known_complete_user);
	       assertEquals(u.getAuthId(),"rcoley");
	       assertEquals(u.getDirectoryId(),"96327");	       
	       
		
	}
}
