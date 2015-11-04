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

import java.util.Map;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.plan.domain.KeyResources;

public class KeyResourcesServiceTest extends DomainObjectTest {

	private KeyResourcesService service;
	
	public void setService(KeyResourcesService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCreateSkill() throws Exception {
		// get test
		Map<Skill, String> dObjs = this.service.getSkillMap(PlanTestData.known_plan);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// set attributes
		Skill dObj = new Skill();
		dObj.setId(1);
		
		// create
		this.service.createSkill(PlanTestData.known_plan, dObj, this.getRandomTestString());
		
		// assert
		dObjs = this.service.getSkillMap(PlanTestData.known_plan);
		this.doTestMap(dObjs);
		assertEquals(++size, dObjs.size());
	}

	public void testCreateUtility() throws Exception {
		// get test kr
		Map<Utility, String> dObjs = this.service.getUtilities(PlanTestData.known_plan);
		
		// set attributes
		String test = "Test" + this.getRandomTestString();
		Utility dObj = new Utility();
		dObj.setId(1);
		this.service.createUtility(PlanTestData.known_plan, dObj, test);
		
		// assert
		dObjs = this.service.getUtilities(PlanTestData.known_plan);
		this.doTestMap(dObjs);
		assertEquals(test, dObjs.get(dObj));
	}

	public void testReadKeyResources() throws Exception {
		this.getTestKeyResources();
	}

	public void testReadSkills() throws Exception {
		// get list
		Map<Skill, String> dObjs = this.service.getSkillMap(PlanTestData.known_plan);
		this.doTestMap(dObjs);
	}

	public void testReadUtilities() throws Exception {
		// get list
		Map<Utility, String> dObjs = this.service.getUtilities(PlanTestData.known_plan);
		this.doTestMap(dObjs);
	}

	public void testUpdateEquipmentAndSupplies() throws Exception {
		// get test kr
		KeyResources dObj = this.getTestKeyResources();
		String test = this.getRandomTestString();
		
		// update
		this.service.updateEquipmentAndSupplies(PlanTestData.known_plan, dObj.getOfficeEquipmentMinimums(), test, test, test);
		
		// assert
		dObj = this.getTestKeyResources();
		assertNotNull(dObj);
		assertEquals(test, dObj.getSupplyCrisisActions());
	}

	public void testUpdateFacilitiesAndTransportations() throws Exception {
		// get test kr
		KeyResources dObj = this.getTestKeyResources();
		String test = this.getRandomTestString();
		
		// update
		this.service.updateFacilitiesAndTransportations(PlanTestData.known_plan, test, test, test);
		
		// assert
		dObj = this.getTestKeyResources();
		assertNotNull(dObj);
		assertEquals(test, dObj.getFacilitiesNeeds());
	}

	public void testUpdateStaffBasics() throws Exception {
		String test = this.getRandomTestString();
		this.service.updateStaffBasics(PlanTestData.known_plan, test, test, test, test, test, test, test, test);
		assertEquals(test, this.getTestKeyResources().getStaffBasicsComment());
	}

	public void testUpdateWorkFromHome() throws Exception {
		String test = this.getRandomTestString();
		this.service.updateWorkFromHome(PlanTestData.known_plan, true, test);
		assertEquals(test, this.getTestKeyResources().getWorkFromHomeNAExplanation());
	}

	public void testDeleteSkill() throws Exception {
		//get test kr
		Map<Skill, String> dObjs = this.service.getSkillMap(PlanTestData.known_plan);
		this.doTestMap(dObjs);
		int size = dObjs.size();
		
		// delete
		Skill dObj = dObjs.keySet().iterator().next();
		this.service.deleteSkill(PlanTestData.known_plan, dObj);
		
		// assert
		dObjs = this.service.getSkillMap(PlanTestData.known_plan);
		assertEquals(--size, dObjs.size());
	}

	public void testDeleteUtility() throws Exception {
		//get test kr
		Map<Utility, String> dObjs = this.service.getUtilities(PlanTestData.known_plan);
		this.doTestMap(dObjs);
		int size = dObjs.size();
		
		// delete
		Utility dObj = dObjs.keySet().iterator().next();
		this.service.deleteUtility(PlanTestData.known_plan, dObj);
		
		// assert
		dObjs = this.service.getUtilities(PlanTestData.known_plan);
		assertEquals(--size, dObjs.size());
	}

	private KeyResources getTestKeyResources() {
		KeyResources kr = this.service.getKeyResources(PlanTestData.known_plan);
		assertNotNull(kr);
		return kr;
	}
	
}
