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
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.StaffingRequirement;

public class StaffingRequirementServiceTest extends DomainObjectTest {

	private StaffingRequirementService service;
	
	public void setService(StaffingRequirementService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		doTestCreateStaffingRequirement();
		doTestReadStaffingRequirement();
		doTestDeleteStaffingRequirement();
	}

	private void doTestCreateStaffingRequirement() throws Exception {
		// get list
		List<StaffingRequirement> dObjs = this.service.getListByOwnerId(PlanTestData.known_critical_function);
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
		this.service.create(dObj);
		
		// assert
		dObjs = this.service.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestReadStaffingRequirement() throws Exception {
		// get list
		List<StaffingRequirement> dObjs = this.service.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// test
		StaffingRequirement dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		Shift shift = dObj.getShift();
		
		// get
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(shift, dObj.getShift());
	}

	private void doTestDeleteStaffingRequirement() throws Exception {
		// get test plan
		List<StaffingRequirement> dObjs = this.service.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// delete
		StaffingRequirement dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.delete(dObj.getId());
		
		// assert
		dObj = this.service.getById(id);
		assertNull(dObj);
	}
	
}
