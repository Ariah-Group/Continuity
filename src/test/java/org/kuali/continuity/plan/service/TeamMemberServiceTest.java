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
import org.kuali.continuity.plan.domain.Team;
import org.kuali.continuity.plan.domain.TeamMember;

public class TeamMemberServiceTest extends DomainObjectTest {

	private TeamMemberService service;
	
	public void setService(TeamMemberService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testCRUD() throws Exception {
		doTestCreateTeamMember();
		doTestReadTeamMember();
		doTestDeleteTeamMember();
	}

	private void doTestCreateTeamMember() throws Exception {
		// get list
		List<TeamMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_team);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		Team team = new Team(PlanTestData.known_team);
		String test = this.getRandomTestString();
		TeamMember dObj = new TeamMember();
		dObj.setTeam(team);
		dObj.setFirstName(test);
		dObj.setLastName(test);
		
		// create
		this.service.create(dObj);
		
		// assert
		dObjs = this.service.getListByOwnerId(PlanTestData.known_team);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestReadTeamMember() throws Exception {
		// get list
		List<TeamMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_team);
		this.doTestList(dObjs);
		
		// test
		TeamMember dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getFirstName();
		
		// get
		dObj = this.service.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getFirstName());
	}

	private void doTestDeleteTeamMember() throws Exception {
		// get test plan
		List<TeamMember> dObjs = this.service.getListByOwnerId(PlanTestData.known_team);
		this.doTestList(dObjs);
		
		// delete
		TeamMember dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.delete(dObj.getId());
		
		// assert
		dObj = this.service.getById(id);
		assertNull(dObj);
	}
	
}
