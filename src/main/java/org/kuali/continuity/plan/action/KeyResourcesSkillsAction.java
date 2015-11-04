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
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.DeleteAction;
import org.kuali.continuity.action.ReadListAction;
import org.kuali.continuity.action.SaveAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.SaveTypeEnum;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.SkillDTO;
import org.kuali.continuity.plan.service.CriticalFunctionService;
import org.kuali.continuity.plan.service.KeyResourcesService;

@SuppressWarnings("serial")
public class KeyResourcesSkillsAction extends KeyResourcesAction {
	
	// services
	private KeyResourcesService keyResourcesService;
	private CriticalFunctionService criticalFunctionService;
	
	// beans
	private SkillDTO udDTO = new SkillDTO();
	private List<CriticalFunctionDTO> criticalFunctions = new ArrayList<CriticalFunctionDTO>();

	public KeyResourcesSkillsAction(KeyResourcesService keyResourcesService, 
			CriticalFunctionService criticalFunctionService) {
		super();
		this.keyResourcesService = keyResourcesService;
		this.criticalFunctionService = criticalFunctionService;
	}

	public SkillDTO getUdDTO() {
		return this.udDTO;
	}

	public void setUdDTO(SkillDTO udDTO) {
		this.udDTO = udDTO;
	}

	public List<CriticalFunctionDTO> getCriticalFunctions() {
		return this.criticalFunctions;
	}

	public void setCriticalFunctions(List<CriticalFunctionDTO> criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}

	@Override
	public String list() throws Exception {
		// if setting not visiblie
		if (!KeyResourcesSkillsAction.this.getSessionSystemDomain().settings.isSkillsScreenVisible)
			return SaveTypeEnum.CONTINUE.getActionReturnValue();
		return super.list();
	}

	@SuppressWarnings("unchecked")
	public void prepare() throws Exception {
		super.prepare();

		// critical functions
		this.criticalFunctions = 
			(List<CriticalFunctionDTO>) this.getDo2dtoConverter().getDomainObjectDTOList(
				this.criticalFunctionService.getNonDeferrableCriticalFunctionSubList(this.getSessionPlan().id, 0));
		
		// set actions
		this.getSaveActions().put(new Integer(1), new SkillAddAction());
		this.getSaveActions().put(new Integer(2), new SkillUserDefinedAddAction());
		this.setDeleteAction(new SkillDeleteAction());
		this.setReadListAction(new SkillReadListAction());

	}
	
	// ----- actions ----- //

	public class SkillAddAction implements SaveAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesSkillsAction.this.keyResourcesService;
			int planId = KeyResourcesSkillsAction.this.getSessionPlan().id;
			int systemDomainId = KeyResourcesSkillsAction.this.getSessionSystemDomain().id;
			SkillDTO dto = (SkillDTO) KeyResourcesSkillsAction.this.getDto();
			if (dto != null && dto.id != 0) {
				Skill svcSkill = dto.getDomainObject();
				svcSkill.setSystemDomainId(systemDomainId);
				svcSkill.setUserDefined(false);
				service.createSkill(planId, svcSkill, dto.comment);
			}
			return SUCCESS;
		}
	}
	
	public class SkillUserDefinedAddAction implements SaveAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesSkillsAction.this.keyResourcesService;
			int planId = KeyResourcesSkillsAction.this.getSessionPlan().id;
			int systemDomainId = KeyResourcesSkillsAction.this.getSessionSystemDomain().id;
			SkillDTO dto = KeyResourcesSkillsAction.this.udDTO;
			if ((dto.name != null && dto.name.trim().length() != 0) ||
			   (dto.description != null && dto.description.trim().length() != 0)) {
				Skill svcSkill = dto.getDomainObject();
				svcSkill.setSystemDomainId(systemDomainId);
				svcSkill.setUserDefined(true);
				service.createSkill(planId, svcSkill, dto.comment);
			}
			return SUCCESS;
		}
	}
	
	public class SkillDeleteAction implements DeleteAction {
		public String execute() throws Exception {
			int planId = KeyResourcesSkillsAction.this.getSessionPlan().id;
			int rowId = KeyResourcesSkillsAction.this.getRowId();
			if (rowId != 0)
				KeyResourcesSkillsAction.this.keyResourcesService.deleteSkill(planId, new Skill(rowId));
			return SUCCESS;
		}
	}
	
	public class SkillReadListAction implements ReadListAction {
		public String execute() throws Exception {
			int ownerId = KeyResourcesSkillsAction.this.getOwnerId();
			Map<Skill, String> svcSkillMap = 
				KeyResourcesSkillsAction.this.keyResourcesService.getSkillMap(ownerId);
			List<DomainObjectDTO> skillDTOs = new ArrayList<DomainObjectDTO>();
			if (svcSkillMap != null) {
				Set<Skill> svcSkills = svcSkillMap.keySet();
				for (Skill svcSkill : svcSkills) {
					SkillDTO dto = new SkillDTO(svcSkill);
					dto.comment = svcSkillMap.get(svcSkill);
					skillDTOs.add(dto);
				}
			}
			KeyResourcesSkillsAction.this.setDtos(skillDTOs);
			return SUCCESS;
		}
	}

}
