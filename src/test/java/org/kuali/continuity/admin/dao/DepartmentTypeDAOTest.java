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
import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.admin.domain.DepartmentType.SortBy;

public class DepartmentTypeDAOTest extends AdminDAOTest {
	
	private GenericAdminDAOFactory factory;
	private GenericAdminDAO<DepartmentType> dao;
	
	@SuppressWarnings("unchecked")
	public void setFactory(GenericAdminDAOFactory factory) {
		this.factory = factory;
		this.dao = (GenericAdminDAO<DepartmentType>)
			factory.getGenericAdminDAO(DepartmentType.class);
	}
	
	public void testInjection() throws Exception {
		System.out.println("DAO is " + this.factory.getClass().getName());
	}

	public void testGetListSize() throws Exception {
		long size = this.dao.getListBySystemDomainIdSize(PlanTestData.wellknown_institution);
		assertTrue(size > 0L);
	}
	
	public void testGetList() throws Exception {
		this.doTestList(this.dao.getListBySystemDomainId(PlanTestData.wellknown_institution));
		this.doTestList(this.dao.getSubListBySystemDomainIdAndStartOrderNo(PlanTestData.wellknown_institution, 1));
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
	
	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestDelete();
	}

	private void doTestCreate() throws Exception {
		DepartmentType dObj = new DepartmentType();
		dObj.setName("TEST");
		dObj.setSystemDomainId(PlanTestData.wellknown_institution);
		dObj.setOrderNo(1000);
		
		// create
		this.dao.create(dObj);
		
		// test
		assertNotNull(dObj.getId());
	}
	
	private void doTestRead() throws Exception {
		// test 1
		DepartmentType dObj = this.getLatest();
		DepartmentType dSameObj = this.dao.getById(dObj.getId());
		assertNotNull(dSameObj);
		
		// test 2
		dObj = this.dao.getBySystemDomainIdAndOrderNo(PlanTestData.wellknown_institution, 1);
		assertNotNull(dObj);
		
		// test 3
		dObj = this.dao.getBySystemDomainIdAndName(PlanTestData.wellknown_institution, "Research");
		assertNotNull(dObj);
		
		// test 4
		dObj = this.dao.getHighestOrderedObjectBySystemDomainId(PlanTestData.wellknown_institution);
		assertNotNull(dObj);
	}
	
	private void doTestUpdate() throws Exception {
		DepartmentType dObj = this.getLatest();
		String modName = dObj.getName() + "-Modified";
		dObj.setName(modName);
		
		// update
		this.dao.update(dObj);
		
		// test
		DepartmentType modObj = this.dao.getById(dObj.getId());
		assertEquals(modName, modObj.getName());
	}
	
	private void doTestDelete() throws Exception {
		DepartmentType dObj = this.getLatest();
		
		// delete
		this.dao.delete(dObj.getId());
		
		// test
		DepartmentType nullObj = this.dao.getById(dObj.getId());
		assertNull(nullObj);
	}
	
	private DepartmentType getLatest() throws Exception {
		List<DepartmentType> dObjs = this.dao.getSortedListBySystemDomainId(PlanTestData.wellknown_institution, SortBy.id, false);
		return dObjs.get(0);
	}

}
