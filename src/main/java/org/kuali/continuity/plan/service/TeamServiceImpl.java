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
import org.kuali.continuity.plan.dao.TeamDAO;
import org.kuali.continuity.plan.domain.Team;

public class TeamServiceImpl implements TeamService {

	private TeamDAO teamDAO;

	public void create(Team obj) {
		this.teamDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((Team)obj);
	}

	public void update(Team obj) {
		this.teamDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((Team)obj);
	}

	public void delete(int id) {
		// no implementation
	}

	public Team getById(int id) {
		return this.teamDAO.getById(id);
	}

	public List<Team> getListByOwnerId(int ownerId) {
		return this.teamDAO.getListByOwnerId(ownerId);
	}

	public TeamDAO getTeamDAO() {
		return this.teamDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void updateList(List<Team> teams) {
		this.teamDAO.updateTeams(teams);
	}

}
