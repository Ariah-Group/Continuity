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
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.PlanStatusEnum;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.DepartmentInfo;
import org.kuali.continuity.plan.domain.BaseContinuityPlan.SortBy;

// this is a simple test.
// test must be run by a single user.  
// test should not have concurrent transactions.
public class ContinuityPlanDAOTest extends DomainObjectTest {

	private ContinuityPlanDAO dao;
	
	public void setContinuityPlanDAO(ContinuityPlanDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testCreate() throws Exception {
		// construct
		String test = this.getRandomTestString();
		SystemDomain systemDomain = new SystemDomain(PlanTestData.wellknown_institution);
		PlanStatus status = new PlanStatus("N");
		PlanAccessType accessType = new PlanAccessType("2");
		User user = new User(PlanTestData.known_user);
		MajorDivision majorDivision = new MajorDivision(39);
		Acronym acronym = new Acronym(65);
		
		ContinuityPlan dObj = new ContinuityPlan();
		dObj.setName(test);
		dObj.setSystemDomain(systemDomain);
		dObj.setStatus(status);
		dObj.setDepartmentHead(user);
		dObj.setMajorDivision(majorDivision);
		dObj.setAcronym(acronym);
		dObj.addContact(user, true);
		dObj.addUserAccess(user, accessType);
		
		// create
		this.dao.create(dObj);
		assertTrue(dObj.getId() > 0);
		System.out.println("Plan: " + dObj.getId() + " - " + dObj.getAcronymPlusName());
	}

	public void testCreateUserAccess() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
		Map<User, PlanAccessType> dObjs = dObj.getUserAccessMap();
//		int size = (dObjs == null ? 0 : dObjs.size());
		int id = dObj.getId();
		
		// construct 
		// TODO: refactor
		PlanAccessType accessType = new PlanAccessType();
		accessType.setId("2");
		accessType.setDescription("Full");
		User user = new User();
		user.setId(PlanTestData.known_user);

		// set plan access
		this.dao.createUserAccess(dObj.getId(), user, accessType);
		
		// assert
		dObjs = this.dao.getUserAccessMap(id);
		this.doTestMap(dObjs);
		assertFalse(dObjs.isEmpty());
	}

	public void testGetListBySystemDomainIdSize() {
		assertTrue(this.dao.getListBySystemDomainIdSize(1) > 0);
	}
	
	public void testRead() throws Exception {
		// get known id
		int id = PlanTestData.known_plan;
		
		// assert
		ContinuityPlan dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		
		// OneToOne
		System.out.println();
		System.out.println("OneToOne -----");
		this.printDomainObject(dObj.getDepartmentHead());

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

	public void testReadUserAccessMap() throws Exception {
		// get test plan
		int id = this.getTestContinuityPlan().getId();
		
		// get map
		Map<User, PlanAccessType> dObjs = this.dao.getUserAccessMap(id);
		this.doTestMap(dObjs);
		
		// get single
		PlanAccessType accessType = 
			this.dao.getUserAccess(id, dObjs.keySet().iterator().next());
		assertNotNull(accessType);
	}

	public void testUpdate() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
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
		this.dao.updateDepartmentInfo(id, departmentInfo);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getDepartmentInfo().getComment());
	}

	public void testUpdateOrganizationData() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
		int id = dObj.getId();
		
		// update
		this.dao.updateOrganizationData(
			id, 
			dObj.getName(), 
			dObj.getMajorDivision(), 
			dObj.getAcronym(), 
			new User(PlanTestData.known_user), 
			dObj.getContacts()
		);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
	}

	public void testUpdateUserAccess() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
		Map<User, PlanAccessType> map = dObj.getUserAccessMap();
		this.doTestMap(map);
		int id = dObj.getId();
		
		// set attributes
		User user = map.keySet().iterator().next();
		PlanAccessType accessType = PlanAccessTypeEnum.VIEW_ONLY.getRefDomainObject();
		
		// update
		this.dao.updateUserAccess(id, user, accessType);

		// assert
		accessType = this.dao.getUserAccess(id, user);
		assertNotNull(accessType);
		assertEquals(PlanAccessTypeEnum.VIEW_ONLY.getRefDomainObject().getId(), accessType.getId());
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
		
		// update
		this.dao.updateStatus(id, status);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertNotSame(oldStatus, dObj.getStatus());
	}

	public void testDeleteUserAccess() throws Exception {
		// get test plan
		ContinuityPlan dObj = this.getTestContinuityPlan();
		Map<User, PlanAccessType> map = dObj.getUserAccessMap();
		this.doTestMap(map);
		int id = dObj.getId();
		
		// delete
		User user = map.keySet().iterator().next();
		this.dao.deleteUserAccess(id, user);
		
		// assert
		assertNull(this.dao.getUserAccess(id, user));
	}
	
	public void testDelete() throws Exception {
		int id = this.getTestContinuityPlan().getId();
		System.out.println();
		System.out.println("Id: " + id);
		this.dao.delete(id);
		assertNull(this.dao.getById(id));
	}

	private ContinuityPlan getTestContinuityPlan() throws Exception {
		List<ContinuityPlan> plans = this.dao.getSortedSubListByOwnerId(PlanTestData.wellknown_institution, 0, 1, SortBy.id, false);
		assertNotNull(plans);
		assertFalse(plans.isEmpty());
		return plans.get(0);
	}
	
}
