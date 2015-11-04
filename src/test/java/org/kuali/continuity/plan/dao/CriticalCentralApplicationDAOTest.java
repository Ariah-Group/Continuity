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
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CriticalCentralApplication;

public class CriticalCentralApplicationDAOTest extends DomainObjectTest {

	private CriticalCentralApplicationDAO dao;
	
	public void setCriticalCentralApplicationDAO(CriticalCentralApplicationDAO dao) {
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
		List<CriticalCentralApplication> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		CentralApplication ca = new CentralApplication(34);
		CriticalityLevelEnum levelEnum = CriticalityLevelEnum.LEVEL1;
		String test = this.getRandomTestString();
		CriticalCentralApplication dObj = new CriticalCentralApplication();
		dObj.setPlan(plan);
		dObj.setCentralApplication(ca);
		dObj.setComment(test);
		dObj.setCriticalityLevelEnum(levelEnum);
		
		// create
		this.dao.create(dObj);
		
		// assert
		dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestRead() throws Exception {
		// get list
		List<CriticalCentralApplication> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// test
		CriticalCentralApplication dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String comment = dObj.getComment();
		
		// get
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(comment, dObj.getComment());
	}

	private void doTestUpdate() throws Exception {
		// get list
		List<CriticalCentralApplication> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// set attributes
		CriticalCentralApplication dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setComment(test);
		
		// update
		this.dao.update(dObj);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getComment());
	}

	private void doTestDelete() throws Exception {
		// get test plan
		List<CriticalCentralApplication> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// delete
		CriticalCentralApplication dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.dao.delete(dObj.getId());
		
		// assert
		dObj = this.dao.getById(id);
		assertNull(dObj);
	}
	
}
