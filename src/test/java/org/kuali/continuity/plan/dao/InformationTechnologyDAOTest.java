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

import java.util.Map;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.plan.domain.InformationTechnology;
import org.kuali.continuity.plan.domain.RestartProcedure;
import org.kuali.continuity.plan.domain.WorkstationBackupMethod;
import org.kuali.continuity.plan.domain.WorkstationProcedure;

public class InformationTechnologyDAOTest extends DomainObjectTest {

	private InformationTechnologyDAO dao;
	
	public void setInformationTechnologyDAO(InformationTechnologyDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testRead() throws Exception {
		this.getTestInformationTechnology();
	}
	
	public void testReadRestartProcedure() throws Exception {
		RestartProcedure dObj = this.dao.getRestartProcedure(PlanTestData.known_plan);
		assertNotNull(dObj);
	}

	public void testReadWorkstationProcedure() throws Exception {
		WorkstationProcedure dObj = this.dao.getWorkstationProcedure(PlanTestData.known_plan);
		assertNotNull(dObj);
	}

	public void testUpdateRestartProcedure() throws Exception {
		// set attributes
		String test = this.getRandomTestString();
		RestartProcedure dObj = new RestartProcedure();
		dObj.setEnvironmentalRequirements(test);
		dObj.setOtherObstacles(test);
		dObj.setTechSupportStaff(test);
		dObj.setWhenToRebuild(test);
		dObj.setWhereToPurchase(test);
		dObj.setWorkAround(test);
		dObj.setWorkFromHome(test);
		
		// update
		this.dao.updateRestartProcedure(PlanTestData.known_plan, dObj);
		
		// assert
		dObj = this.dao.getRestartProcedure(PlanTestData.known_plan);
		assertNotNull(dObj);
		assertEquals(test, dObj.getEnvironmentalRequirements());
	}

	public void testUpdateWorkstationProcedure() throws Exception {
		// get test plan
		WorkstationProcedure wp = 
			this.dao.getWorkstationProcedure(PlanTestData.known_plan);
		Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> dObjs =
			wp.getBackupMethods();
		this.doTestMap(dObjs);
//		int size = dObjs.size();

		// set attributes
		String test = this.getRandomTestString();
		dObjs.put(WorkstationBackupMethod.Type.CENTRAL, new WorkstationBackupMethod(test, test));
		wp.setBackupMethods(dObjs);
		
		// update
		this.dao.updateWorkstationProcedure(PlanTestData.known_plan, wp);
		
		// assert
		wp = this.dao.getWorkstationProcedure(PlanTestData.known_plan);
		dObjs = wp.getBackupMethods();
		assertNotNull(wp);
		this.doTestMap(dObjs);
//		assertEquals(++size, dObjs.size());
	}

	private InformationTechnology getTestInformationTechnology() {
		InformationTechnology it = this.dao.get(PlanTestData.known_plan);
		assertNotNull(it);
		return it;
	}

}
