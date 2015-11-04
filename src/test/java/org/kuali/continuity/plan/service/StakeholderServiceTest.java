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
package org.kuali.continuity.plan.service;

import java.util.List;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.domain.StakeholderType;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.Stakeholder;

public class StakeholderServiceTest extends DomainObjectTest {

	private StakeholderService service;
	
	public void setService(StakeholderService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		doTestCreateStakeholder();
		doTestReadStakeholder();
		doTestUpdateStakeholder();
		doTestDeleteStakeholder();
	}

	private void doTestCreateStakeholder() throws Exception {
		// get list
		List<Stakeholder> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
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
		
		// create
		this.service.create(dObj);
		
		// assert
		dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestReadStakeholder() throws Exception {
		// get list
		List<Stakeholder> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// test
		Stakeholder dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String dept = dObj.getDepartment();
		
		// get
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(dept, dObj.getDepartment());
	}

	private void doTestUpdateStakeholder() throws Exception {
		// get list
		List<Stakeholder> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// set attributes
		Stakeholder dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setDepartment(test);
		
		// update
		this.service.update(dObj);
		
		// assert
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getDepartment());
	}

	private void doTestDeleteStakeholder() throws Exception {
		// get test plan
		List<Stakeholder> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// delete
		Stakeholder dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.delete(dObj.getId());
		
		// assert
		dObj = this.service.getById(id);
		assertNull(dObj);
	}
	
}
