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
import org.kuali.continuity.plan.domain.ActionItem;
import org.kuali.continuity.plan.domain.ContinuityPlan;

public class ActionItemServiceTest extends DomainObjectTest {

	private ActionItemServiceFactory serviceFactory;
	private ActionItemService service;
	
	public void setServiceFactory(ActionItemServiceFactory serviceFactory) {
		this.serviceFactory = serviceFactory;
	}
	
	public void onSetUp() throws Exception {
		this.service = this.serviceFactory.getActionItemService(ActionItem.class);
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		doTestCreateActionItem();
		doTestReadActionItem();
		doTestUpdateActionItem();
		doTestDeleteActionItem();
	}

	@SuppressWarnings("unchecked")
	private void doTestCreateActionItem() throws Exception {
		// get list
		List<ActionItem> dObjs = (List<ActionItem>) this.service.getListByOwnerId(PlanTestData.known_plan);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		String test = this.getRandomTestString();
		ActionItem dObj = new ActionItem();
		dObj.setPlan(plan);
		dObj.setComment(test);
		dObj.setName(test);
		
		// create
		this.service.create(dObj);
		
		// assert
		dObjs = (List<ActionItem>) this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	@SuppressWarnings("unchecked")
	private void doTestReadActionItem() throws Exception {
		// get list
		List<ActionItem> dObjs = (List<ActionItem>) this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// test
		ActionItem dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// get
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	@SuppressWarnings("unchecked")
	private void doTestUpdateActionItem() throws Exception {
		// get list
		List<ActionItem> dObjs = (List<ActionItem>) this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// set attributes
		ActionItem dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setName(test);
		
		// update
		this.service.update(dObj);
		
		// assert
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());
	}

	@SuppressWarnings("unchecked")
	private void doTestDeleteActionItem() throws Exception {
		// get test plan
		List<ActionItem> dObjs = (List<ActionItem>) this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// delete
		ActionItem dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.delete(dObj.getId());
		
		// assert
		dObj = this.service.getById(id);
		assertNull(dObj);
	}
	
}
