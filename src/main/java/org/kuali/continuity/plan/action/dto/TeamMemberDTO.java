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
package org.kuali.continuity.plan.action.dto;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.Team;
import org.kuali.continuity.plan.domain.TeamMember;

@SuppressWarnings("serial")
public class TeamMemberDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {
	
	public String firstName;
	public String lastName;
	public int teamId;

	public TeamMemberDTO() {
		super();
	}

	public TeamMemberDTO(BaseDomainObject obj) {
		super(obj);
	}

	public TeamMemberDTO(int id, String name) {
		super(id, name);
	}

	public TeamMemberDTO(int id) {
		super(id);
	}
	
	public TeamMemberDTO(TeamMember dObj) {
		this.copyFromDomainObject(dObj);
	}

	public TeamMember getDomainObject() {
		TeamMember dObj = new TeamMember();
		dObj.setId(this.id == 0 ? null : this.id);
		dObj.setFirstName(this.firstName);
		dObj.setLastName(this.lastName);
		dObj.setTeam(new Team(this.teamId));
		return dObj;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof TeamMember)) return;
		TeamMember dObj = (TeamMember) copyObj;
		
		// set other fields
		this.firstName = dObj.getFirstName();
		this.lastName = dObj.getLastName();
		if (dObj.getTeam() != null)
			this.teamId = dObj.getTeam().getId();
	}

}
