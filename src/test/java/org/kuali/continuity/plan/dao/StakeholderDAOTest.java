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
package org.kuali.continuity.plan.dao;

import java.util.List;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.domain.StakeholderType;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.Stakeholder;

public class StakeholderDAOTest extends DomainObjectTest {

	private StakeholderDAO dao;
	
	public void setStakeholderDAO(StakeholderDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestDelete();
	}

	private void doTestCreate() throws Exception {
		// get list
		List<Stakeholder> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		StakeholderType stakeholderType = new StakeholderType("1");
		String test = this.getRandomTestString();
		Stakeholder dObj = new Stakeholder();
		dObj.setPlan(plan);
		dObj.setAlternateVendors(test);
		dObj.setDepartment(test);
		dObj.setFirstName(test);
		dObj.setLastName(test);
		dObj.setStakeholderType(stakeholderType);
		dObj.setSuppliedProductsOrServices(test);
		dObj.setComment(test);
		
		// create
		this.dao.create(dObj);
		
		// assert
		dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestRead() throws Exception {
		// get list
		List<Stakeholder> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// test
		Stakeholder dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String dept = dObj.getDepartment();
		
		// get
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(dept, dObj.getDepartment());
	}

	private void doTestUpdate() throws Exception {
		// get list
		List<Stakeholder> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// set attributes
		Stakeholder dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setDepartment(test);
		
		// update
		this.dao.update(dObj);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getDepartment());
	}

	private void doTestDelete() throws Exception {
		// get test plan
		List<Stakeholder> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// delete
		Stakeholder dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.dao.delete(dObj.getId());
		
		// assert
		dObj = this.dao.getById(id);
		assertNull(dObj);
	}
	
}
