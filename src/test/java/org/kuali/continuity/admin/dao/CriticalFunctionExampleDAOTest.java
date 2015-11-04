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
import org.kuali.continuity.admin.domain.CriticalFunctionExample;

public class CriticalFunctionExampleDAOTest extends AdminDAOTest {
	
	private GenericAdminDAOFactory factory;
	private GenericAdminDAO<CriticalFunctionExample> dao;
	
	@SuppressWarnings("unchecked")
	public void setFactory(GenericAdminDAOFactory factory) {
		this.factory = factory;
		this.dao = (GenericAdminDAO<CriticalFunctionExample>)
			factory.getGenericAdminDAO(CriticalFunctionExample.class);
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
	
	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestDelete();
	}

	private void doTestCreate() throws Exception {
		CriticalFunctionExample dObj = new CriticalFunctionExample();
		dObj.setSystemDomainId(PlanTestData.wellknown_institution);
		dObj.setPlans("TEST");
		
		// create
		this.dao.create(dObj);
		
		// test
		assertNotNull(dObj.getId());
	}
	
	private void doTestRead() throws Exception {
		CriticalFunctionExample dObj = this.getLatest();
		CriticalFunctionExample dSameObj = this.dao.getById(dObj.getId());
		assertNotNull(dSameObj);
	}
	
	private void doTestUpdate() throws Exception {
		CriticalFunctionExample dObj = this.getLatest();
		String modPlans = dObj.getPlans() + "-Modified";
		dObj.setPlans(modPlans);
		
		// update
		this.dao.update(dObj);
		
		// test
		CriticalFunctionExample modObj = this.dao.getById(dObj.getId());
		assertEquals(modPlans, modObj.getPlans());
	}
	
	private void doTestDelete() throws Exception {
		CriticalFunctionExample dObj = this.getLatest();
		
		// delete
		this.dao.delete(dObj.getId());
		
		// test
		CriticalFunctionExample nullObj = this.dao.getById(dObj.getId());
		assertNull(nullObj);
	}
	
	private CriticalFunctionExample getLatest() throws Exception {
		List<CriticalFunctionExample> dObjs = this.dao.getListBySystemDomainId(PlanTestData.wellknown_institution);
		return dObjs.get(dObjs.size()-1);
	}

}
