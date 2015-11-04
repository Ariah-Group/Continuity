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
package org.kuali.continuity.plan.action;

import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.action.BaseReadListAction;
import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.SaveAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.SaveTypeEnum;
import org.kuali.continuity.action.util.DTO2DomainObjectConverter;
import org.kuali.continuity.plan.action.dto.TeamDTO;
import org.kuali.continuity.plan.action.dto.TeamMemberDTO;
import org.kuali.continuity.plan.domain.Team;
import org.kuali.continuity.plan.service.TeamService;

@SuppressWarnings("serial")
public class KeyResourcesTeamsAction extends KeyResourcesAction {
	
	// service
	private TeamService teamService;
	
	// bean
	private List<TeamDTO> teams = new ArrayList<TeamDTO>();
	
	// row number.  used in add team member
	private int rowNo;
	
	// max no of rows
	private final static int MAX_ROWS = 3;
	
	public KeyResourcesTeamsAction(TeamService teamService) {
		super();
		this.teamService = teamService;
	}

	public int getRowNo() {
		return this.rowNo;
	}

	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	
	public List<TeamDTO> getTeams() {
		return this.teams;
	}

	public void setTeams(List<TeamDTO> teams) {
		this.teams = teams;
	}

	@Override
	public String save() throws Exception {
		String retVal = this.update();
		if (!retVal.equals(SUCCESS)) return retVal;
		this.list();
		((TeamMemberDTO)this.getDto()).teamId = this.getTeams().get(this.rowNo-1).id;
		return SUCCESS;
	}
	
	@Override
	public String update() throws Exception {
		this.setSaveActionType(1);
		return super.save();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String list() throws Exception {
		// if setting not visiblie
		if (!this.getSessionSystemDomain().settings.isTeamsScreenVisible)
			return SaveTypeEnum.CONTINUE.getActionReturnValue();
		
		super.list();
		
		// set teams
		this.teams = (List<TeamDTO>)this.getDtos();
		
		// fill list to max
		for (int i = this.getTeams().size(); i < MAX_ROWS; i++) {
			TeamDTO teamDTO = new TeamDTO();
			teamDTO.plan = this.getSessionPlan();
			List<TeamDTO> dtos = (List<TeamDTO>)this.getTeams();
			dtos.add(teamDTO);
		}
		
		// return
		return SUCCESS;
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.getSaveActions().put(new Integer(1), new TeamUpdateAction());
		this.setReadListAction(new TeamReadListAction());
		this.setValidateAction(new TeamMemberValidateAction());
	}
	
	// ----- actions -----//
	
	public class TeamUpdateAction implements SaveAction {
		@SuppressWarnings("unchecked")
		public String execute() throws Exception {
			List<TeamDTO> teamDTOs = KeyResourcesTeamsAction.this.getTeams();
			DTO2DomainObjectConverter dto2doConverter = KeyResourcesTeamsAction.this.getDto2doConverter();
			if (teamDTOs != null && !teamDTOs.isEmpty()) {
				List<Team> svcTeams = (List<Team>) dto2doConverter.getDomainObjectList(teamDTOs);
				KeyResourcesTeamsAction.this.teamService.updateList(svcTeams);
			}
			return SUCCESS;
		}
	}

	public class TeamReadListAction extends BaseReadListAction {
		public TeamReadListAction() {
			super();
			this.setService(KeyResourcesTeamsAction.this.teamService);
		}
	}
	
	public class TeamMemberValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			TeamMemberDTO dto = (TeamMemberDTO) dObjDTO;
			if (dto != null && 
			  ((dto.firstName != null && dto.firstName.trim().length() != 0) ||
			   (dto.lastName  != null && dto.lastName.trim().length()  != 0))) return true;
			return null;
		}
	}

}
