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

import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.Team;
import org.kuali.continuity.plan.domain.TeamMember;

@SuppressWarnings("serial")
public class TeamDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {

	public PlanDTO plan = new PlanDTO();
	public String purpose;
	public String comment;
	public List<TeamMemberDTO> teamMembers = new ArrayList<TeamMemberDTO>();

	public TeamDTO() {
		super();
	}

	public TeamDTO(BaseDomainObject obj) {
		super(obj);
	}

	public TeamDTO(int id, String name) {
		super(id, name);
	}

	public TeamDTO(int id) {
		super(id);
	}
	
	public TeamDTO(Team dObj) {
		this.copyFromDomainObject(dObj);
	}

	public Team getDomainObject() {
		Team dObj = new Team();
		dObj.setId(this.id == 0 ? null : this.id);
		dObj.setName(this.name);
		dObj.setPurpose(this.purpose);
		dObj.setComment(this.comment);
		if (plan != null) dObj.setPlan(plan.getDomainObject());
		return dObj;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof Team)) return;
		Team dObj = (Team) copyObj;
		
		// set other fields
		this.purpose = dObj.getPurpose();
		this.comment = dObj.getComment();
//		if (dObj.getPlan() != null) this.plan = new PlanDTO(dObj.getPlan());
		if (dObj.getTeamMembers() != null && !dObj.getTeamMembers().isEmpty()) {
			for (TeamMember member : dObj.getTeamMembers()) {
				this.teamMembers.add(new TeamMemberDTO(member));
			}
		}
	}

}
