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
import java.util.Map;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.domain.InstructionSelect1;
import org.kuali.continuity.domain.InstructionSelect2;
import org.kuali.continuity.domain.InstructionSelect3;
import org.kuali.continuity.plan.domain.AllCoursesPractice;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.DepartmentalPractice;
import org.kuali.continuity.plan.domain.Instruction;

public class InstructionServiceTest extends DomainObjectTest {

	private InstructionService service;
	
	public void setService(InstructionService service) {
		this.service = service;
	}
	
	public void testInjection() {
		String message = "DAO is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestReadAllCoursesPractices();
		this.doTestReadDepartmentalPractices();
		this.doTestUpdate();
		this.doTestUpdateAllCoursesPractices();
		this.doTestUpdateDepartmentalPractices();
		this.doTestDelete();
	}

	private void doTestCreate() throws Exception {
		// get list
		List<Instruction> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		int size = (dObjs == null ? 0 : dObjs.size());

		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		Instruction dObj = new Instruction();
		InstructionalDepartment dept = new InstructionalDepartment(15);
		String test = this.getRandomTestString();
		dObj.setPlan(plan);
		dObj.setDepartment(dept);
		dObj.setName(test);
		
		// create
		this.service.create(dObj);
		
		// assert
		dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestRead() throws Exception {
		// list
		List<Instruction> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);

		// single
		Instruction dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// assert
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	private void doTestReadAllCoursesPractices() throws Exception {
		// get test cf
		int id = this.getTestInstruction().getId();
		
		// get consequences
		Map<AllCoursesPractice.Type, AllCoursesPractice> dObjs = this.service.getById(id).getAllCoursesPractices();
		this.doTestMap(dObjs);
	}

	private void doTestReadDepartmentalPractices() throws Exception {
		// get test cf
		int id = this.getTestInstruction().getId();
		
		// get consequences
		Map<DepartmentalPractice.Type, DepartmentalPractice> dObjs = this.service.getById(id).getDepartmentalPractices();
		this.doTestMap(dObjs);
	}

	private void doTestUpdate() throws Exception {
		// get test cf
		Instruction dObj = this.getTestInstruction();
		int id = dObj.getId();
		
		// set attributes
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

	private void doTestUpdateAllCoursesPractices() throws Exception {
		// get test instruction
		Instruction ins = this.getTestInstruction();
		Map<AllCoursesPractice.Type, AllCoursesPractice> dObjs = ins.getAllCoursesPractices();
		this.doTestMap(dObjs);
		int id = ins.getId();
		
		// set attributes
		AllCoursesPractice dObj = new AllCoursesPractice();
		String test = this.getRandomTestString();
		dObj.setComment(test);
		dObj.setCurrentUsage(new InstructionSelect1("1"));
		dObj.setDepartmentExpansion(new InstructionSelect2("1"));
		dObjs.put(AllCoursesPractice.Type.GSI_COMMUNICATION, dObj);
		ins.setAllCoursesPractices(dObjs);
		
		// update
		this.service.update(ins);
		
		// assert
		dObjs = this.service.getById(id).getAllCoursesPractices();
		dObj = dObjs.get(AllCoursesPractice.Type.GSI_COMMUNICATION);
		this.doTestMap(dObjs);
		assertEquals(test, dObj.getComment());
	}

	private void doTestUpdateDepartmentalPractices() throws Exception {
		// get test instruction
		Instruction ins = this.getTestInstruction();
		Map<DepartmentalPractice.Type, DepartmentalPractice> dObjs = ins.getDepartmentalPractices();
		this.doTestMap(dObjs);
		int id = ins.getId();
		
		// set attributes
		DepartmentalPractice dObj = new DepartmentalPractice();
		String test = this.getRandomTestString();
		dObj.setComment(test);
		dObj.setCurrentUsage(new InstructionSelect3("1"));
		dObjs.put(DepartmentalPractice.Type.BACKUP_PERSONNEL, dObj);
		ins.setDepartmentalPractices(dObjs);
		
		// update
		this.service.update(ins);
		
		// assert
		dObjs = this.service.getById(id).getDepartmentalPractices();
		dObj = dObjs.get(DepartmentalPractice.Type.BACKUP_PERSONNEL);
		this.doTestMap(dObjs);
		assertEquals(test, dObj.getComment());
	}

	private void doTestDelete() throws Exception {
		int id = this.getTestInstruction().getId();
		this.service.delete(id);
		assertNull(this.service.getById(id));
	}

	private Instruction getTestInstruction() throws Exception {
		List<Instruction> ins = this.service.getSortedSubListByOwnerId(PlanTestData.known_plan, 0, 1, Instruction.SortBy.id, false);
		assertNotNull(ins);
		assertFalse(ins.isEmpty());
		return ins.get(0);
	}

}
