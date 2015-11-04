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
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.PlanStatusEnum;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.DepartmentInfo;

// this is a simple test.
// test must be run by a single user.  
// test should not have concurrent transactions.
public class ContinuityPlanServiceTest extends DomainObjectTest {

	private ContinuityPlanService service;
	
	public void setContinuityPlanService(ContinuityPlanService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCreateContinuityPlan() throws Exception {
		// get list
		List<ContinuityPlan> dObjs = this.service.getContinuityPlanList(PlanTestData.uc_institution);
		this.doTestList(dObjs);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		String test = this.getRandomTestString();
		SystemDomain systemDomain = new SystemDomain(PlanTestData.uc_institution);
		PlanStatus status = new PlanStatus("N");
		PlanAccessType accessType = new PlanAccessType("2");
//		User user = new User(PlanTestData.known_user);
		MajorDivision majorDivision = new MajorDivision(39);
		Acronym acronym = new Acronym(65);
		
		User user = new User();
		user.setFirstName("new");
		user.setLastName("user");
		user.setEmailRegular("kualiready-test@lists.berkeley.edu");

		// plan
		ContinuityPlan dObj = new ContinuityPlan();
		dObj.setName(test);
		dObj.setSystemDomain(systemDomain);
		dObj.setStatus(status);
		dObj.setDepartmentHead(user);
		dObj.setMajorDivision(majorDivision);
		dObj.setAcronym(acronym);
		dObj.addContact(user, true);
		dObj.addUserAccess(user, accessType);
		
		// log info
		SystemLogInfo systemLogInfo = new SystemLogInfo();
		systemLogInfo.setUserId(PlanTestData.known_user);
		systemLogInfo.setSystemDomainId(PlanTestData.uc_institution);
		systemLogInfo.setHostIP(test);
		systemLogInfo.setModule(test);

		// create
		this.service.createContinuityPlan(dObj, systemLogInfo);
		
		// assert
		dObjs = this.service.getContinuityPlanList(PlanTestData.uc_institution);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	public void testReadContinuityPlan() throws Exception {
		// get known id
		int id = PlanTestData.known_plan;
		
		// assert
		ContinuityPlan dObj = this.service.getContinuityPlan(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());

		// ManyToOne
		System.out.println();
		System.out.println("ManyToOne -----");
		this.printDomainObject    (dObj.getAcronym());
		this.printDomainObject    (dObj.getMajorDivision());
		this.printRefDomainObject (dObj.getStatus());
		this.printDomainObject    (dObj.getSystemDomain());
		this.printRefDomainObject (dObj.getDepartmentInfo().getEvacuationPlan());
		this.printDomainObject    (dObj.getCriticalFunctions().getCriticalFunctions().get(0).getPlan());
//		this.printDomainObject    (dObj.getInformationTechnology().getDepartmentOwnedApplications().get(0).getPlan());
//		this.printRefDomainObject (dObj.getInformationTechnology().getDepartmentOwnedApplications().get(0).getRecoveryProcedure().getBackupFrequency());
//		this.printRefDomainObject (dObj.getInformationTechnology().getServers().get(0).getRecoveryProcedure().getBackupFrequency());
//		this.printDomainObject    (dObj.getInformationTechnology().getServers().get(0).getPlan());
		this.printDomainObject    (dObj.getKeyResources().getKeyStaffMembers().get(0).getPlan());
		this.printDomainObject    (dObj.getKeyResources().getOtherUnitStaffMembers().get(0).getPlan());
//		this.printDomainObject    (dObj.getKeyResources().getStaffingRequirements().get(0).getCriticalFunction());
//		this.printDomainObject    (dObj.getKeyResources().getStaffingRequirements().get(0).getShift());
//		this.printDomainObject    (dObj.getKeyResources().getStaffingRequirements().get(0).getStaffCategory());
		this.printDomainObject    (dObj.getKeyResources().getStakeholders().get(0).getPlan());
		this.printRefDomainObject (dObj.getKeyResources().getStakeholders().get(0).getStakeholderType());
//		this.printDomainObject    (dObj.getKeyResources().getTeams().get(0).getPlan());
//		this.printDomainObject    (dObj.getKeyResources().getTeams().get(0).getTeamMembers().get(0).getTeam());
//		this.printDomainObject    (dObj.getKeyResources().getWorkFromHomeStaffMembers().get(0).getPlan());
		// OneToMany
		System.out.println();
		System.out.println("OneToMany -----");
		this.printDomainObjectList(dObj.getActionItems());
		this.printDomainObjectMap(dObj.getContacts());
		this.printDomainObjectMap(dObj.getUserAccessMap());
		this.printDomainObjectList(dObj.getCriticalFunctions().getCriticalFunctions());
		this.printDomainObjectList(dObj.getCriticalFunctions().getCriticalFunctions().get(0).getActionItems());
		this.printDomainObjectMap(dObj.getCriticalFunctions().getCriticalFunctions().get(0).getConsequences());
		this.printDomainObjectList(dObj.getCriticalFunctions().getCriticalFunctions().get(0).getDependencies());
		this.printDomainObjectList(dObj.getCriticalFunctions().getCriticalFunctions().get(0).getDocuments());
		this.printDomainObjectMap(dObj.getDepartmentInfo().getBuildings());
		this.printDomainObjectList(dObj.getDepartmentInfo().getDepartmentTypes());
		this.printDomainObjectList(dObj.getInformationTechnology().getActionItems());
		this.printDomainObjectList(dObj.getInformationTechnology().getCriticalCentralApplications());
		this.printDomainObjectList(dObj.getInformationTechnology().getDepartmentOwnedApplications());
		this.printDomainObjectList(dObj.getInformationTechnology().getServers());
		this.printDomainObjectMap(dObj.getInformationTechnology().getWorkstationProcedure().getBackupMethods());
		this.printDomainObjectMap(dObj.getInformationTechnology().getWorkstationProcedure().getTechSupports());
		this.printDomainObjectList(dObj.getFacultyPreparedness().getActionItems());
		this.printDomainObjectList(dObj.getKeyResources().getDocuments());
		this.printDomainObjectList(dObj.getKeyResources().getKeyStaffMembers());
		this.printDomainObjectMap(dObj.getKeyResources().getOfficeEquipmentMinimums());
		this.printDomainObjectList(dObj.getKeyResources().getOtherUnitStaffMembers());
		this.printDomainObjectMap(dObj.getKeyResources().getSkillMap());
		this.printDomainObjectList(dObj.getKeyResources().getStaffingRequirements());
		this.printDomainObjectList(dObj.getKeyResources().getStakeholders());
		this.printDomainObjectList(dObj.getKeyResources().getTeams());
//		this.printDomainObjectList(dObj.getKeyResources().getTeams().get(0).getTeamMembers());
		this.printDomainObjectMap(dObj.getKeyResources().getUtilities());
		this.printDomainObjectList(dObj.getKeyResources().getWorkFromHomeStaffMembers());
	}
	
	public void testReadSimpleContinuityPlanList() throws Exception {
		List<Object[]> list = this.service.getSimpleContinuityPlanList(PlanTestData.wellknown_institution);
		for (Object[] objects : list) {
			System.out.println("id: " + objects[0]);
			System.out.println("name: " + objects[1]);			
		}
	}

	public void testReadUserAccessMap() throws Exception {
		// get test plan
		int id = this.getTestContinuityPlan().getId();
		
		// get map
		Map<User, PlanAccessTypeEnum> dObjs = this.service.getUserAccessMap(id);
		this.doTestMap(dObjs);
	}

	public void testUpdateContinuityPlan() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
		int id = dObj.getId();
		
		// set attributes
		String test = this.getRandomTestString();
		dObj.setName(test);
		
		// update
		this.service.updateContinuityPlan(dObj, new User(PlanTestData.known_user));
		
		// assert
		dObj = this.service.getContinuityPlan(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());
	}

	public void testUpdateDepartmentInfo() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
		assertNotNull(dObj.getDepartmentInfo());
		int id = dObj.getId();
		
		// set attributes
		DepartmentInfo departmentInfo = new DepartmentInfo();
		String test = this.getRandomTestString();
		departmentInfo.setComment(test);
		departmentInfo.setAcademicStaffCount(1);
		departmentInfo.setFulltimeStaffCount(2);
		departmentInfo.setGuestsCount(3);
		departmentInfo.setOtherStaffCount(4);
		departmentInfo.setParttimeStaffCount(5);
		departmentInfo.setResidentsAndFellowsCount(6);
		departmentInfo.setStudentStaffCount(7);
		departmentInfo.setVolunteersCount(8);
		departmentInfo.setCostCenter(test);
		departmentInfo.setEmployFaculty("");
		
		// update
		this.service.updateDepartmentInfo(id, departmentInfo);
		
		// assert
		dObj = this.service.getContinuityPlan(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getDepartmentInfo().getComment());
	}

	public void testUpdateStatus() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
		assertNotNull(dObj.getStatus());
		int id = dObj.getId();
		
		// set attributes
		PlanStatus oldStatus = dObj.getStatus();
		PlanStatus status = PlanStatusEnum.COMPLETE.getRefDomainObject();
		if (oldStatus.equals(PlanStatusEnum.COMPLETE.getRefDomainObject()))
			status = PlanStatusEnum.IN_PROGRESS.getRefDomainObject();
		
		// log info
		String test = this.getRandomTestString();
		SystemLogInfo systemLogInfo = new SystemLogInfo();
		systemLogInfo.setUserId(PlanTestData.known_user);
		systemLogInfo.setSystemDomainId(PlanTestData.wellknown_institution);
		systemLogInfo.setHostIP(test);
		systemLogInfo.setModule(test);

		// update
		this.service.updateStatus(id, status, systemLogInfo);
		
		// assert
		dObj = this.service.getContinuityPlan(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertNotSame(oldStatus, dObj.getStatus());
	}

	public void testDeleteContinuityPlan() throws Exception {
		ContinuityPlan testPlan = this.getTestContinuityPlan();
		User user = new User(PlanTestData.known_user);
		user.setSecurityType(new SecurityType("1"));

		// log info
		String test = this.getRandomTestString();
		SystemLogInfo systemLogInfo = new SystemLogInfo();
		systemLogInfo.setUserId(PlanTestData.known_user);
		systemLogInfo.setSystemDomainId(PlanTestData.wellknown_institution);
		systemLogInfo.setHostIP(test);
		systemLogInfo.setModule(test);

		this.service.deleteContinuityPlan(testPlan, systemLogInfo);
		assertNull(this.service.getContinuityPlan(testPlan.getId()));
	}

	public void testGetContinuityPlanListBySystemDomainIdSize() {
		assertTrue(this.service.getContinuityPlanListBySystemDomainIdSize(1) > 0);
	}
	
	private ContinuityPlan getTestContinuityPlan() throws Exception {
		List<ContinuityPlan> plans = this.service.getContinuityPlanList(PlanTestData.known_institution, 0, 1, (SortByType)ContinuityPlan.SortBy.id, false);
		assertNotNull(plans);
		assertFalse(plans.isEmpty());
		return plans.get(0);
	}

}
