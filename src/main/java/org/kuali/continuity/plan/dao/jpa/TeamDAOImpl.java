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
package org.kuali.continuity.plan.dao.jpa;

import java.util.List;

import org.kuali.continuity.dao.jpa.BaseDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.TeamDAO;
import org.kuali.continuity.plan.domain.Team;

public class TeamDAOImpl extends BaseDomainObjectDAOImpl implements
		TeamDAO {

	public void create(Team dObj) {
		super.create(dObj);
	}
	
	public void update(Team dObj) {
		super.update(dObj);
	}
	
	@Override
	public Team getById(int id) {
		return (Team) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Team> getListByOwnerId(int ownerId) {
		return (List<Team>) super.getListByOwnerId(ownerId);
	}

	public void createTeams(List<Team> teams) {
		for (Team team : teams) {
			super.create(team);
		}
	}
	
	public void updateTeams(List<Team> teams) {
		for (Team team : teams) {
			super.update(team);
		}
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return Team.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Team.list";
	}

}
