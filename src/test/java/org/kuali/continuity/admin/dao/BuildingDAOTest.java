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
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.Building.SortBy;
import org.kuali.continuity.domain.BuildingOwnership;

public class BuildingDAOTest extends AdminDAOTest {
	
	private GenericAdminDAOFactory factory;
	private GenericAdminDAO<Building> dao;
	
	@SuppressWarnings("unchecked")
	public void setFactory(GenericAdminDAOFactory factory) {
		this.factory = factory;
		this.dao = (GenericAdminDAO<Building>)
			factory.getGenericAdminDAO(Building.class);
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
		Building dObj = new Building();
		dObj.setName("TEST");
		dObj.setSystemDomainId(PlanTestData.wellknown_institution);
		dObj.setAddress("Some address");
		dObj.setCaan("CAAN");
		dObj.setCommonName("Some common name");
		
		// TODO: set ownership - retrieve from database?
		BuildingOwnership ownership = new BuildingOwnership();
		ownership.setId("1");
		dObj.setOwnership(ownership);
		
		// create
		this.dao.create(dObj);
		
		// test
		assertNotNull(dObj.getId());
	}
	
	private void doTestRead() throws Exception {
		Building dObj = this.getLatest();
		Building dSameObj = this.dao.getById(dObj.getId());
		assertNotNull(dSameObj);
	}
	
	private void doTestUpdate() throws Exception {
		Building dObj = this.getLatest();
		String modName = dObj.getName() + "-Modified";
		dObj.setName(modName);
		
		// update
		this.dao.update(dObj);
		
		// test
		Building modObj = this.dao.getById(dObj.getId());
		assertEquals(modName, modObj.getName());
	}
	
	private void doTestDelete() throws Exception {
		Building dObj = this.getLatest();
		
		// delete
		this.dao.delete(dObj.getId());
		
		// test
		Building nullObj = this.dao.getById(dObj.getId());
		assertNull(nullObj);
	}
	
	private Building getLatest() throws Exception {
		List<Building> dObjs = this.dao.getSortedListBySystemDomainId(PlanTestData.wellknown_institution, SortBy.id, false);
		return dObjs.get(0);
	}

}
