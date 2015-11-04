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
import org.kuali.continuity.plan.domain.ActionItem;
import org.kuali.continuity.plan.domain.ContinuityPlan;

public class ActionItemDAOTest extends DomainObjectTest {

	private ActionItemDAOFactory daoFactory;
	private ActionItemDAO dao;
	
	public void setActionItemDAOFactory(ActionItemDAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	public void onSetUp() throws Exception {
		this.dao = this.daoFactory.getActionItemDAO(ActionItem.class);
		
	}
	
	public void testInjection() throws Exception {
		String message = "DAO Factory is: " + this.daoFactory.toString();
		System.out.println(message);
		assertNotNull(this.daoFactory);
	}

	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestDelete();
	}

	@SuppressWarnings("unchecked")
	private void doTestCreate() throws Exception {
		// get list
		List<ActionItem> dObjs = (List<ActionItem>) this.dao.getListByOwnerId(PlanTestData.known_plan);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		String test = this.getRandomTestString();
		ActionItem dObj = new ActionItem();
		dObj.setPlan(plan);
		dObj.setComment(test);
		dObj.setName(test);
//		CriticalFunction criticalFunction = new CriticalFunction(7684);
//		criticalFunction.setPlan(plan);
//		dObj.setCriticalFunction(criticalFunction);
		
		// create
		this.dao.create(dObj);
		
		// assert
		dObjs = (List<ActionItem>) this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	@SuppressWarnings("unchecked")
	private void doTestRead() throws Exception {
		// get list
		List<ActionItem> dObjs = (List<ActionItem>) this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// test
		ActionItem dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// get
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	@SuppressWarnings("unchecked")
	private void doTestUpdate() throws Exception {
		// get list
		List<ActionItem> dObjs = (List<ActionItem>) this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// set attributes
		ActionItem dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setName(test);
		
		// update
		this.dao.update(dObj);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());
	}

	@SuppressWarnings("unchecked")
	private void doTestDelete() throws Exception {
		// get test plan
		List<ActionItem> dObjs = (List<ActionItem>) this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// delete
		ActionItem dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.dao.delete(dObj.getId());
		
		// assert
		dObj = this.dao.getById(id);
		assertNull(dObj);
	}
	
}
