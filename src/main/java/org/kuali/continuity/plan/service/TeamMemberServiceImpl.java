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

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.TeamMemberDAO;
import org.kuali.continuity.plan.domain.TeamMember;

public class TeamMemberServiceImpl implements TeamMemberService {

	private TeamMemberDAO teamMemberDAO;

	public void create(TeamMember obj) {
		this.teamMemberDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((TeamMember)obj);
	}

	public void update(TeamMember obj) {
		// no implementation
	}

	public void update(BaseDomainObject obj) {
		this.update((TeamMember)obj);
	}

	public void delete(int id) {
		this.teamMemberDAO.delete(id);
	}

	public TeamMember getById(int id) {
		return this.teamMemberDAO.getById(id);
	}

	public List<TeamMember> getListByOwnerId(int ownerId) {
		return this.teamMemberDAO.getListByOwnerId(ownerId);
	}

	public TeamMemberDAO getTeamMemberDAO() {
		return this.teamMemberDAO;
	}

	public void setTeamMemberDAO(TeamMemberDAO teamMemberDAO) {
		this.teamMemberDAO = teamMemberDAO;
	}

}
