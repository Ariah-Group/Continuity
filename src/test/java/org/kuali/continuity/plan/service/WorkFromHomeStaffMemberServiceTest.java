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
import org.kuali.continuity.domain.BroadbandConnection;
import org.kuali.continuity.domain.ComputerRunning;
import org.kuali.continuity.domain.ConnectFromHome;
import org.kuali.continuity.domain.StaffPosition;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.WorkFromHomeStaffMember;

public class WorkFromHomeStaffMemberServiceTest extends DomainObjectTest {

	private WorkFromHomeStaffMemberService service;
	
	public void setService(WorkFromHomeStaffMemberService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		doTestCreateWorkFromHomeStaffMember();
		doTestReadWorkFromHomeStaffMember();
		doTestUpdateWorkFromHomeStaffMember();
		doTestDeleteWorkFromHomeStaffMember();
	}

	private void doTestCreateWorkFromHomeStaffMember() throws Exception {
		// get list
		List<WorkFromHomeStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		StaffPosition staffPosition = new StaffPosition("1");
		BroadbandConnection broadbandConnection = new BroadbandConnection("1");
		ComputerRunning computerRunning = new ComputerRunning("1");
		ConnectFromHome connectFromHome = new ConnectFromHome("1");
		String test = this.getRandomTestString();
		WorkFromHomeStaffMember dObj = new WorkFromHomeStaffMember();
		dObj.setPlan(plan);
		dObj.setName(test);
		dObj.setComment(test);
		dObj.setStaffPosition(staffPosition);
		dObj.setHasBroadbandConnection(broadbandConnection);
		dObj.setDoesConnectFromHome(connectFromHome);
		dObj.setMustOfficeComputerRunning(computerRunning);
		
		// create
		this.service.create(dObj);
		
		// assert
		dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestReadWorkFromHomeStaffMember() throws Exception {
		// get list
		List<WorkFromHomeStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// test
		WorkFromHomeStaffMember dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// get
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	private void doTestUpdateWorkFromHomeStaffMember() throws Exception {
		// get list
		List<WorkFromHomeStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// set attributes
		WorkFromHomeStaffMember dObj = dObjs.get(dObjs.size()-1);
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

	private void doTestDeleteWorkFromHomeStaffMember() throws Exception {
		// get test plan
		List<WorkFromHomeStaffMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_plan);
		this.doTestList(dObjs);
		
		// delete
		WorkFromHomeStaffMember dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.delete(dObj.getId());
		
		// assert
		dObj = this.service.getById(id);
		assertNull(dObj);
	}
	
}
