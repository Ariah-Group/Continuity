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
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.StaffingRequirement;

public class StaffingRequirementDAOTest extends DomainObjectTest {

	private StaffingRequirementDAO dao;
	
	public void setStaffingRequirementDAO(StaffingRequirementDAO dao) {
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
		this.doTestDelete();
	}

	private void doTestCreate() throws Exception {
		// get list
		List<StaffingRequirement> dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		CriticalFunction cf = new CriticalFunction(PlanTestData.known_critical_function);
		Shift shift = new Shift(34);
		StaffCategory staffCategory = new StaffCategory(1);
		StaffingRequirement dObj = new StaffingRequirement();
		dObj.setCriticalFunction(cf);
		dObj.setShift(shift);
		dObj.setStaffCategory(staffCategory);
		
		// create
		this.dao.create(dObj);
		
		// assert
		dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestRead() throws Exception {
		// get list
		List<StaffingRequirement> dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// test
		StaffingRequirement dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		Shift shift = dObj.getShift();
		
		// get
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(shift, dObj.getShift());
	}

	private void doTestDelete() throws Exception {
		// get test plan
		List<StaffingRequirement> dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// delete
		StaffingRequirement dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.dao.delete(dObj.getId());
		
		// assert
		dObj = this.dao.getById(id);
		assertNull(dObj);
	}
	
}
