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

public class InstructionDAOTest extends DomainObjectTest {

	private InstructionDAO dao;
	
	public void setInstructionDAO(InstructionDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testCRUD() throws Exception {
		doTestCreate();
		doTestReadAllCoursesPractices();
		doTestReadDepartmentalPractices();
		doTestUpdate();
		doTestUpdateAllCoursesPractices();
		doTestUpdateDepartmentalPractices();
		doTestDelete();
	}

	private void doTestCreate() throws Exception {
		// get list
		List<Instruction> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
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
		this.dao.create(dObj);
		
		// assert
		dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	public void testRead() throws Exception {
		// list
		List<Instruction> dObjs = this.dao.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);

		// single
		Instruction dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	private void doTestReadAllCoursesPractices() throws Exception {
		// get test cf
		int id = this.getTestInstruction().getId();
		
		// get consequences
		Map<AllCoursesPractice.Type, AllCoursesPractice> dObjs = this.dao.getAllCoursesPractices(id);
		this.doTestMap(dObjs);
	}

	private void doTestReadDepartmentalPractices() throws Exception {
		// get test cf
		int id = this.getTestInstruction().getId();
		
		// get consequences
		Map<DepartmentalPractice.Type, DepartmentalPractice> dObjs = this.dao.getDepartmentalPractices(id);
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
		this.dao.update(dObj);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());		
	}

	private void doTestUpdateAllCoursesPractices() throws Exception {
		// get test cf
		Instruction cf = this.getTestInstruction();
		Map<AllCoursesPractice.Type, AllCoursesPractice> dObjs = cf.getAllCoursesPractices();
		this.doTestMap(dObjs);
		int id = cf.getId();
		
		// set attributes
		AllCoursesPractice dObj = new AllCoursesPractice();
		String test = this.getRandomTestString();
		dObj.setComment(test);
		dObj.setCurrentUsage(new InstructionSelect1("1"));
		dObj.setDepartmentExpansion(new InstructionSelect2("1"));
		dObjs.put(AllCoursesPractice.Type.GSI_COMMUNICATION, dObj);
		
		// update
		this.dao.updateAllCoursesPractices(id, dObjs);
		
		// assert
		dObjs = this.dao.getAllCoursesPractices(id);
		dObj = dObjs.get(AllCoursesPractice.Type.GSI_COMMUNICATION);
		this.doTestMap(dObjs);
		assertEquals(test, dObj.getComment());
	}

	private void doTestUpdateDepartmentalPractices() throws Exception {
		// get test cf
		Instruction cf = this.getTestInstruction();
		Map<DepartmentalPractice.Type, DepartmentalPractice> dObjs = cf.getDepartmentalPractices();
		this.doTestMap(dObjs);
		int id = cf.getId();
		
		// set attributes
		DepartmentalPractice dObj = new DepartmentalPractice();
		String test = this.getRandomTestString();
		dObj.setComment(test);
		dObj.setCurrentUsage(new InstructionSelect3("1"));
		dObjs.put(DepartmentalPractice.Type.BACKUP_PERSONNEL, dObj);
		
		// update
		this.dao.updateDepartmentalPractices(id, dObjs);
		
		// assert
		dObjs = this.dao.getDepartmentalPractices(id);
		dObj = dObjs.get(DepartmentalPractice.Type.BACKUP_PERSONNEL);
		this.doTestMap(dObjs);
		assertEquals(test, dObj.getComment());
	}

	private void doTestDelete() throws Exception {
		int id = this.getTestInstruction().getId();
		this.dao.delete(id);
		assertNull(this.dao.getById(id));
	}

	private Instruction getTestInstruction() throws Exception {
		List<Instruction> cfs = this.dao.getSortedSubListByOwnerId(PlanTestData.known_plan, 0, 1, Instruction.SortBy.id, false);
		assertNotNull(cfs);
		assertFalse(cfs.isEmpty());
		return cfs.get(0);
	}

}
