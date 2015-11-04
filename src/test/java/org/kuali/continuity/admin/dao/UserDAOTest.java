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

import java.util.Date;
import java.util.List;

import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.domain.User.SortBy;
import org.kuali.continuity.domain.AccessStatus;
import org.kuali.continuity.domain.SecurityType;

public class UserDAOTest extends AdminDAOTest {
	
	private UserDAO dao;
	
	public void setUserDAO(UserDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}
	
	public void testGetListSize() throws Exception {
		long size = this.dao.getListBySystemDomainIdSize(PlanTestData.wellknown_institution);
		assertTrue(size > 0L);
	}
	
	public void testGetList() throws Exception {
		this.doTestList(this.dao.getListBySystemDomainId(PlanTestData.wellknown_institution));
	}
	
	public void testGetSortedList() throws Exception {
		System.out.println("ascending sort by name");
		this.doTestSortedList(this.dao.getSortedListBySystemDomainId(PlanTestData.wellknown_institution, SortBy.name, true),  SortBy.name, true);
		System.out.println("descending sort by name");
		this.doTestSortedList(this.dao.getSortedListBySystemDomainId(PlanTestData.wellknown_institution, SortBy.name, false), SortBy.name, false);
	}
	
	public void testGetLimitedList() throws Exception {
		System.out.println("first Three");
		this.doTestLimitedList(this.dao.getSubListBySystemDomainId(PlanTestData.wellknown_institution, 0, 3), 3);
	}

	public void testGetSortedLimitedList() throws Exception {
		System.out.println("ascending sort by name");
		this.doTestSortedLimitedList(this.dao.getSortedSubListBySystemDomainId(PlanTestData.wellknown_institution, 0, 3, SortBy.name, true),  3, SortBy.name, true);
		System.out.println("descending sort by name");
		this.doTestSortedLimitedList(this.dao.getSortedSubListBySystemDomainId(PlanTestData.wellknown_institution, 0, 3, SortBy.name, false), 3, SortBy.name, false);
	}
	
	public void testGetUnapprovedList() throws Exception {
		this.doTestList(this.dao.getUnapprovedListBySystemDomainId(PlanTestData.wellknown_institution));
	}
	
	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestReadUnapprovedList();
		this.doTestUpdate();
		this.doTestDelete();
	}
	
	private void doTestCreate() throws Exception {
		User dObj = new User();
		dObj.setFirstName("TEST");
		dObj.setLastName("TEST");
		dObj.setSystemDomainId(PlanTestData.wellknown_institution);
		dObj.setAffiliations("TEST");
		dObj.setCellPhone("TEST");
		dObj.setDateCreated(new Date());
		dObj.setDepartmentName("TEST");
		dObj.setDepartmentOrg("TEST");
		dObj.setDepartmentOrgHierarchy("TEST");
		dObj.setEmailBackup("TEST");
		dObj.setEmailRegular("TEST");
		dObj.setHomeAddress("TEST");
		dObj.setHomePhone("TEST");
		dObj.setTitle("TEST");
		dObj.setWorkAddress("TEST");
		dObj.setWorkFax("TEST");
		dObj.setWorkPhone("TEST");
		
		// TODO: retrieve from database?
		SecurityType securityType = new SecurityType();
		securityType.setId("0");
		dObj.setSecurityType(securityType);
		AccessStatus accessStatus = new AccessStatus();
		accessStatus.setId("1");
		dObj.setAccessStatus(accessStatus);
		dObj.setLockStatus(accessStatus);

		// create
		this.dao.create(dObj);
		
		// test
		assertNotNull(dObj.getId());
		System.out.println("New User: " + dObj.getId());
	}
	
	private void doTestRead() throws Exception {
		User dObj = this.getLatest();
		User dSameObj = this.dao.getById(dObj.getId());
		assertNotNull(dSameObj);
	}
	
	private void doTestReadUnapprovedList() throws Exception {
		List<User> users = this.dao.getUnapprovedListBySystemDomainId(PlanTestData.wellknown_institution);
		assertNotNull(users);
		assertFalse(users.isEmpty());
	}

	private void doTestUpdate() throws Exception {
		User dObj = this.getLatest();
		String modName = dObj.getFirstName() + "-Modified";
		dObj.setFirstName(modName);
		
		// update
		this.dao.update(dObj);
		
		// test
		User modObj = this.dao.getById(dObj.getId());
		assertEquals(modName, modObj.getFirstName());
	}
	
	private void doTestDelete() throws Exception {
		User dObj = this.getLatest();
		
		// delete
		this.dao.delete(dObj.getId());
		
		// test
		User nullObj = this.dao.getById(dObj.getId());
		assertNull(nullObj);
	}
	
	private User getLatest() throws Exception {
		List<User> dObjs = this.dao.getSortedListBySystemDomainId(PlanTestData.wellknown_institution, SortBy.id, false);
		return dObjs.get(0);
	}

}