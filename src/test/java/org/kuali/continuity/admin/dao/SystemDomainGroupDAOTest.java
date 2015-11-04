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

import org.kuali.continuity.admin.domain.SystemDomainGroup;
import org.kuali.continuity.admin.domain.SystemDomainGroup.SortBy;

public class SystemDomainGroupDAOTest extends AdminDAOTest {
	
	private SystemDomainGroupDAO dao;
	
	public void setDAO(SystemDomainGroupDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		System.out.println("DAO is " + this.dao.getClass().getName());
	}

	public void testGetListSize() throws Exception {
		long size = this.dao.getAllSize();
		assertTrue(size > 0L);
	}
	
	public void testGetList() throws Exception {
		this.doTestList(this.dao.getAll());
	}
	
	public void testGetSortedList() throws Exception {
		System.out.println("ascending sort by name");
		this.doTestSortedList(this.dao.getAll(SortBy.name, true),  SortBy.name, true);
		System.out.println("descending sort by name");
		this.doTestSortedList(this.dao.getAll(SortBy.name, false), SortBy.name, false);
	}
	
	public void testGetLimitedList() throws Exception {
		System.out.println("first Three");
		this.doTestLimitedList(this.dao.getAll(0, 3), 3);
	}

	public void testGetSortedLimitedList() throws Exception {
		System.out.println("ascending sort by name");
		this.doTestSortedLimitedList(this.dao.getAll(0, 3, SortBy.name, true),  3, SortBy.name, true);
		System.out.println("descending sort by name");
		this.doTestSortedLimitedList(this.dao.getAll(0, 3, SortBy.name, false), 3, SortBy.name, false);
	}
	
	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestDelete();
	}
	
	private void doTestCreate() throws Exception {
		SystemDomainGroup dObj = new SystemDomainGroup();
		dObj.setName(this.getRandomTestString());
		
		// create
		this.dao.create(dObj);
		
		// test
		assertNotNull(dObj.getId());
	}
	
	private void doTestRead() throws Exception {
		SystemDomainGroup dObj = this.getLatest();
		SystemDomainGroup dSameObj = this.dao.getById(dObj.getId());
		assertNotNull(dSameObj);
	}
	
	private void doTestUpdate() throws Exception {
		SystemDomainGroup dObj = this.getLatest();
		String modName = dObj.getName() + "-Modified";
		dObj.setName(modName);
		
		// update
		this.dao.update(dObj);
		
		// test
		SystemDomainGroup modObj = this.dao.getById(dObj.getId());
		assertEquals(modName, modObj.getName());
	}
	
	private void doTestDelete() throws Exception {
		SystemDomainGroup dObj = this.getLatest();
		
		// delete
		this.dao.delete(dObj.getId());
		
		// test
		SystemDomainGroup nullObj = this.dao.getById(dObj.getId());
		assertNull(nullObj);
	}
	
	private SystemDomainGroup getLatest() throws Exception {
		List<SystemDomainGroup> dObjs = this.dao.getAll(SortBy.id, false);
		return dObjs.get(0);
	}

}
