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

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.dao.CriticalFunctionDAO;
import org.kuali.continuity.plan.domain.Consequence;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CopingMethod;
import org.kuali.continuity.plan.domain.CriticalFunction;

public class CriticalFunctionServiceTest extends DomainObjectTest {

	private CriticalFunctionService service;
	
	public void setService(CriticalFunctionService service) {
		this.service = service;
	}
	
	public void testInjection() {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		doTestCreateCriticalFunction();
		doTestCreateDependency();
		doTestReadConsequences();
		doTestReadCopingMethod();
		doTestReadDependencies();
		doTestUpdateDescriptions();
		doTestUpdateConsequences();
		doTestUpdateCopingMethods();
		doTestUpdateCriticalFunction();
		doTestUpdatePeakPeriods();
		doTestDeleteDependency();
		doTestDeleteCriticalFunction();
	}

	private void doTestCreateCriticalFunction() throws Exception {
		// get list
		List<CriticalFunction> dObjs = this.service.getCriticalFunctionList(PlanTestData.known_plan);
		this.doTestList(dObjs);
		int size = (dObjs == null ? 0 : dObjs.size());

		// construct
		ContinuityPlan plan = new ContinuityPlan(PlanTestData.known_plan);
		CriticalFunction dObj = new CriticalFunction();
		String test = this.getRandomTestString();
		dObj.setPlan(plan);
		dObj.setName(test);
		
		// create
		this.service.createCriticalFunction(dObj);
		
		// assert
		dObjs = this.service.getCriticalFunctionList(PlanTestData.known_plan);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestCreateDependency() throws Exception {
		// get test cf
		CriticalFunction cf = this.getTestCriticalFunction();
		Set<Dependency> dObjs = cf.getDependencies();
		int size = (dObjs == null ? 0 : dObjs.size());
		int id = cf.getId();
		
		// TODO: refactor
		// set attributes
		Dependency dObj = new Dependency();
		dObj.setId(700);
		
		// create
		this.service.createDependency(id, dObj);
		
		// assert
		dObjs = this.service.getDependencies(id);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	public void testReadCriticalFunction() throws Exception {
		// list
		List<CriticalFunction> dObjs = this.service.getCriticalFunctionList(PlanTestData.known_plan);
		this.doTestList(dObjs);

		// single
		CriticalFunction dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// assert
		dObj = this.service.getCriticalFunction(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	private void doTestReadConsequences() throws Exception {
		// get test cf
		int id = this.getTestCriticalFunction().getId();
		
		// get consequences
		Map<Consequence.Type, Consequence> dObjs = this.service.getConsequences(id);
		this.doTestMap(dObjs);
	}

	private void doTestReadCopingMethod() throws Exception {
		// get test cf
		int id = this.getTestCriticalFunction().getId();
		
		// get coping methods
		CopingMethod dObj = this.service.getCopingMethod(id);
		assertNotNull(dObj);
	}

	private void doTestReadDependencies() throws Exception {
		// get test cf
		int id = this.getTestCriticalFunction().getId();
		
		// get dependencies
		Set<Dependency> dObjs = this.service.getDependencies(id);
		this.doTestList(dObjs);
	}

	private void doTestUpdateCriticalFunction() throws Exception {
		// get test cf
		CriticalFunction dObj = this.getTestCriticalFunction();
		int id = dObj.getId();
		
		// set attributes
		String test = this.getRandomTestString(); 
		dObj.setName(test);
		dObj.setCriticalityLevelEnum(CriticalityLevelEnum.LEVEL1);
		
		// update
		this.service.updateCriticalFunction(dObj);
		
		// assert
		dObj = this.service.getCriticalFunction(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());		
	}

	private void doTestUpdateConsequences() throws Exception {
		// get test cf
		CriticalFunction cf = this.getTestCriticalFunction();
		Map<Consequence.Type, Consequence> dObjs = cf.getConsequences();
		this.doTestMap(dObjs);
		int id = cf.getId();
		
		// set attributes
		Consequence dObj = new Consequence();
		String test = this.getRandomTestString();
		dObj.setExplanation(test);
		dObj.setMayOccur(true);
		dObjs.put(Consequence.Type.DEPARTURE_FACULTY, dObj);
		
		// update
		this.service.updateConsequences(id, dObjs);
		
		// assert
		dObjs = this.service.getConsequences(id);
		dObj = dObjs.get(Consequence.Type.DEPARTURE_FACULTY);
		this.doTestMap(dObjs);
		assertEquals(test, dObj.getExplanation());
	}

	private void doTestUpdateCopingMethods() throws Exception {
		// get test cf
		CriticalFunction cf = this.getTestCriticalFunction();
		CopingMethod dObj = cf.getCopingMethod();
		int id = cf.getId();
		
		// set attributes
		String test = this.getRandomTestString();
		dObj.setCampusClosure("YES");
		dObj.setComment(test);
		
		// update
		this.service.updateCopingMethod(id, dObj);
		
		// assert
		dObj = this.service.getCopingMethod(id);
		assertNotNull(dObj);
		assertEquals(test, dObj.getComment());
	}

	private void doTestUpdateDescriptions() throws Exception {
		// get test cf
		CriticalFunction dObj = this.getTestCriticalFunction();
		int id = dObj.getId();
		
		// update
		String test = this.getRandomTestString();
		this.service.updateDescriptions(id, test, test, test, test);
		
		// assert
		dObj = this.service.getCriticalFunction(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getDescription());
	}

	private void doTestUpdatePeakPeriods() throws Exception {
		// get test cf
		CriticalFunction cf = this.getTestCriticalFunction();
		Set<Integer> dObjs = cf.getPeakMonths();
		assertNotNull(dObjs);
		int id = cf.getId();
		
		// set attributes
		String test = this.getRandomTestString();
		dObjs.add(Calendar.MAY);
		this.service.updatePeakPeriods(id, dObjs, test);
		
		// assert
		dObjs = this.service.getCriticalFunction(id).getPeakMonths();
		assertNotNull(dObjs);
		assertTrue(dObjs.contains(Calendar.MAY));
	}
	
	private void doTestDeleteDependency() throws Exception {
		// get test cf
		CriticalFunction cf = this.getTestCriticalFunction();
		Set<Dependency> dObjs = cf.getDependencies();
		this.doTestList(dObjs);
		int size = dObjs.size();
		int id = cf.getId();
		
		// delete
		this.service.deleteDependency(id, dObjs.iterator().next());
		
		// assert
		dObjs = this.service.getDependencies(id);
		assertNotNull(dObjs);
		assertEquals(--size, dObjs.size());
	}

	private void doTestDeleteCriticalFunction() throws Exception {
		int id = this.getTestCriticalFunction().getId();
		this.service.deleteCriticalFunction(id);
		assertNull(this.service.getCriticalFunction(id));
	}

	private CriticalFunction getTestCriticalFunction() throws Exception {
		List<CriticalFunction> cfs = this.service.getCriticalFunctionList(PlanTestData.known_plan, 0, 1, (SortByType)CriticalFunctionDAO.SortBy.id, false);
		assertNotNull(cfs);
		assertFalse(cfs.isEmpty());
		return cfs.get(0);
	}

	public void testGetNonDeferrableSubListByOwnerId() throws Exception {
		List<CriticalFunction> dObjs = this.service.getNonDeferrableCriticalFunctionSubList(PlanTestData.known_plan, 2074);
		assertNotNull(dObjs);
		assertFalse(dObjs.isEmpty());
		this.doTestList(dObjs);
	}

}
