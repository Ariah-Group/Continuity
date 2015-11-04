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
import org.kuali.continuity.domain.CourseCast;
import org.kuali.continuity.plan.domain.Course;
import org.kuali.continuity.plan.domain.HighPriorityCourse;
import org.kuali.continuity.plan.domain.Instruction;

public class HighPriorityCourseServiceTest extends DomainObjectTest {

	private HighPriorityCourseService service;
	
	public void setService(HighPriorityCourseService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestDelete();
	}

	private void doTestCreate() throws Exception {
		// get list
		List<HighPriorityCourse> dObjs = this.service.getListByOwnerId(PlanTestData.known_instruction);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		Instruction instruction = new Instruction(PlanTestData.known_instruction);
		String test = this.getRandomTestString();
		Course course = new Course(test, test);
		CourseCast courseCast = new CourseCast("1");
		HighPriorityCourse dObj = new HighPriorityCourse();
		
		dObj.setInstruction(instruction);
		dObj.setName(test);
		dObj.setCourse(course);
		dObj.setCourseCast(courseCast);
		dObj.setBspace(true);
		dObj.setOtherTeach(true);
		
		// create
		this.service.create(dObj);
		
		// assert
		dObjs = this.service.getListByOwnerId(PlanTestData.known_instruction);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestRead() throws Exception {
		// get list
		List<HighPriorityCourse> dObjs = this.service.getListByOwnerId(PlanTestData.known_instruction);
		this.doTestList(dObjs);
		
		// test
		HighPriorityCourse dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// get
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	private void doTestUpdate() throws Exception {
		// get list
		List<HighPriorityCourse> dObjs = this.service.getListByOwnerId(PlanTestData.known_instruction);
		this.doTestList(dObjs);
		
		// set attributes
		HighPriorityCourse dObj = dObjs.get(dObjs.size()-1);
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

	private void doTestDelete() throws Exception {
		// get test plan
		List<HighPriorityCourse> dObjs = this.service.getListByOwnerId(PlanTestData.known_instruction);
		this.doTestList(dObjs);
		
		// delete
		HighPriorityCourse dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.delete(dObj.getId());
		
		// assert
		dObj = this.service.getById(id);
		assertNull(dObj);
	}
	
}
