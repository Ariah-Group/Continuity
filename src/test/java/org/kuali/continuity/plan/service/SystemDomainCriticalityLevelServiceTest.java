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
import org.kuali.continuity.admin.domain.SystemDomainCentralApplicationCriticalityLevel;
import org.kuali.continuity.admin.domain.SystemDomainCriticalFunctionCriticalityLevel;
import org.kuali.continuity.admin.domain.SystemDomainCriticalityLevel;
import org.kuali.continuity.admin.service.SystemDomainCriticalityLevelService;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;

public class SystemDomainCriticalityLevelServiceTest extends DomainObjectTest {

	private SystemDomainCriticalityLevelService service;
	
	public void setService(SystemDomainCriticalityLevelService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		assertNotNull(this.service);
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
	}

	@SuppressWarnings("unchecked")
	public void testCRUD() throws Exception {
		Class[] levelClasses = {
			SystemDomainCriticalFunctionCriticalityLevel.class, 
			SystemDomainCentralApplicationCriticalityLevel.class};
		for (Class levelClass : levelClasses) {
			doTestCreateSystemDomainCriticalityLevel(levelClass);
			doTestReadSystemDomainCriticalityLevel(levelClass);
			doTestUpdateSystemDomainCriticalityLevel(levelClass);
			doTestDeleteSystemDomainCriticalityLevel(levelClass);
		}
	}

	private void doTestCreateSystemDomainCriticalityLevel(Class<? extends SystemDomainCriticalityLevel> levelClass) 
			throws Exception {
		// init
		SystemDomainCriticalityLevel cLevel = 
				SystemDomainCriticalFunctionCriticalityLevel.class.isAssignableFrom(levelClass) ?
				new SystemDomainCriticalFunctionCriticalityLevel() : 
				new SystemDomainCentralApplicationCriticalityLevel();
		String testString = this.getRandomTestString();
		cLevel.setCriticalityLevelEnum(CriticalityLevelEnum.LEVEL3);
		cLevel.setDescription(testString);
		cLevel.setLongDescription(testString);
		cLevel.setName(testString);
		cLevel.setSystemDomainId(PlanTestData.wellknown_institution);
		
		// create
		this.service.create(cLevel);
		
		// assert
		Integer testId = cLevel.getId();
		assertNotNull(testId);
		cLevel = this.service.getById(levelClass, testId);
		assertNotNull(cLevel);
		
	}

	private void doTestReadSystemDomainCriticalityLevel(Class<? extends SystemDomainCriticalityLevel> levelClass) 
			throws Exception {
		// get map
		Map<CriticalityLevelEnum, ? extends CriticalityLevel> dObjMap = 
			this.service.getListByOwnerId(levelClass, PlanTestData.wellknown_institution);
		this.doTestMap(dObjMap);
		
		// test
		CriticalityLevel dObj = dObjMap.get(CriticalityLevelEnum.LEVEL3);
		assert(levelClass.isAssignableFrom(dObj.getClass()));
		int id = dObj.getId();
		String name = dObj.getName();
		
		// get
		dObj = this.service.getById(levelClass, id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}
	
	private void doTestUpdateSystemDomainCriticalityLevel(Class<? extends SystemDomainCriticalityLevel> levelClass) 
			throws Exception {
		// get map
		Map<CriticalityLevelEnum, ? extends CriticalityLevel> dObjMap = 
			this.service.getListByOwnerId(levelClass, PlanTestData.wellknown_institution);
		this.doTestMap(dObjMap);
		
		// set attributes
		CriticalityLevel dObj = dObjMap.get(CriticalityLevelEnum.LEVEL3);
		assert(levelClass.isAssignableFrom(dObj.getClass()));
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setName(test);
		
		// update
		this.service.update((SystemDomainCriticalityLevel)dObj);
		
		// assert
		dObj = this.service.getById(levelClass, id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());
	}
	
	private void doTestDeleteSystemDomainCriticalityLevel(Class<? extends SystemDomainCriticalityLevel> levelClass) 
			throws Exception {
		// get map
		Map<CriticalityLevelEnum, ? extends CriticalityLevel> dObjMap = 
			this.service.getListByOwnerId(levelClass, PlanTestData.wellknown_institution);
		this.doTestMap(dObjMap);
		
		// set attributes
		CriticalityLevel dObj = dObjMap.get(CriticalityLevelEnum.LEVEL3);
		assert(levelClass.isAssignableFrom(dObj.getClass()));
		int id = dObj.getId();
		this.service.delete(levelClass, id);
		
		// assert
		dObj = this.service.getById(levelClass, id);
		assertNull(dObj);
	}

}
