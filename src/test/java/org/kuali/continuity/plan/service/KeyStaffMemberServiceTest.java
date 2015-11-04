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
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.KeyStaffMember;

public class KeyStaffMemberServiceTest extends DomainObjectTest {

	private KeyStaffMemberService service;
	
	public void setService(KeyStaffMemberService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		doTestCreateKeyStaffMember();
		doTestReadKeyStaffMember();
		doTestUpdateKeyStaffMember();
		doTestDeleteKeyStaffMember();
	}

	private void doTestCreateKeyStaffMember() throws Exception {
		// get list
		List<KeyStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		String test = this.getRandomTestString();
		KeyStaffMember dObj = new KeyStaffMember();
		dObj.setPlan(plan);
		dObj.setFirstName(test);
		dObj.setLastName(test);
		dObj.setComment(test);
		dObj.setSpecialSkill(test);
		dObj.setTitleOrFunction(test);
		
		// create
		this.service.create(dObj);
		
		// assert
		dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestReadKeyStaffMember() throws Exception {
		// get list
		List<KeyStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// test
		KeyStaffMember dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String comment = dObj.getComment();
		
		// get
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(comment, dObj.getComment());
	}

	private void doTestUpdateKeyStaffMember() throws Exception {
		// get list
		List<KeyStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// set attributes
		KeyStaffMember dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setComment(test);
		
		// update
		this.service.update(dObj);
		
		// assert
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getComment());
	}

	private void doTestDeleteKeyStaffMember() throws Exception {
		// get test plan
		List<KeyStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// delete
		KeyStaffMember dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.delete(dObj.getId());
		
		// assert
		dObj = this.service.getById(id);
		assertNull(dObj);
	}
	
}
