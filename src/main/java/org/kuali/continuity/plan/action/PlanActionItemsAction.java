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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.plan.action.dto.ActionItemDTO;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.PlanNavigation;
import org.kuali.continuity.plan.domain.ActionItem;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.ActionItemService;
import org.kuali.continuity.plan.service.ActionItemServiceFactory;
import org.kuali.continuity.plan.service.CriticalFunctionService;

@SuppressWarnings("serial")
public class PlanActionItemsAction extends ActionItemsAction implements PlanNavigationSession {
	
	// service
	private CriticalFunctionService criticalFunctionService;
	
	// action item types
	private List<RefDTO> actionItemTypes = new ArrayList<RefDTO>();
	
	// beans
	Map<Integer, String> actionItemStatusMap = new HashMap<Integer, String>();
	
	// action item type
	private String actionItemType;

	public PlanActionItemsAction(ActionItemServiceFactory actionItemServiceFactory) {			
		super(actionItemServiceFactory);
		this.setActionItemType(ActionItemDTO.Type.P.name());
	}

	public PlanActionItemsAction(ActionItemServiceFactory actionItemServiceFactory, 
			CriticalFunctionService criticalFunctionService) {
		this(actionItemServiceFactory);
		this.criticalFunctionService = criticalFunctionService;
	}
	
	public List<RefDTO> getActionItemTypes() {
		return this.actionItemTypes;
	}

	public void setActionItemTypes(List<RefDTO> actionItemTypes) {
		this.actionItemTypes = actionItemTypes;
	}

	@Override
	public String getActionItemType() {
		return this.actionItemType;
	}

	public void setActionItemType(String actionItemType) {
		this.actionItemType = actionItemType;
	}

	public Map<Integer, String> getActionItemStatusMap() {
		return this.actionItemStatusMap;
	}

	public void setActionItemStatusMap(Map<Integer, String> actionItemStatusMap) {
		this.actionItemStatusMap = actionItemStatusMap;
	}
	
	private void getActionItemDTOs() throws Exception {
		super.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public String list() throws Exception {
		String retVal = super.list();
		if (this.getDtos() != null) {
			List<ActionItemDTO> dtos = (List<ActionItemDTO>)this.getDtos();
			for (ActionItemDTO actionItemDTO : dtos) {
				if (actionItemDTO.status != null)
					this.actionItemStatusMap.put(actionItemDTO.id, actionItemDTO.status.id);
			}
		}
		return retVal;
	}

	@Override
	public String get() throws Exception {
		if (this.getRowId() != 0) return super.get();
		this.setDto(new ActionItemDTO());
		((ActionItemDTO)this.getDto()).type = ActionItemDTO.Type.P;
		this.setActionItemType(ActionItemDTO.Type.P.name());
		return SUCCESS;
	}
	
	@Override
	public String add() throws Exception {
		ActionItemDTO.Type aType = null;
		try {
			aType = ActionItemDTO.Type.valueOf(this.getActionItemType());
		} catch (IllegalArgumentException e) {
			// do nothing;
		}
		if (aType == null) {
			ActionItemDTO actionItemDTO = (ActionItemDTO) this.getDto();
			actionItemDTO.criticalFunction = new CriticalFunctionDTO(new Integer(this.getActionItemType()));
			actionItemDTO.type = ActionItemDTO.Type.C;
			this.setActionItemType(ActionItemDTO.Type.C.name());
		} else{
			((ActionItemDTO)this.getDto()).type = ActionItemDTO.Type.valueOf(this.getActionItemType());
		}
		this.setService(this.getActionItemService());		
		return super.add();
	}

	@Override
	public String update() throws Exception {
		if (this.getDto().id == 0) return this.add();
		this.setService(this.getActionItemService());
		((ActionItemDTO)this.getDto()).type = ActionItemDTO.Type.valueOf(this.getActionItemType());
		return super.update();
	}

	@SuppressWarnings("unchecked")
	public String updateListStatus() throws Exception {
		this.getActionItemDTOs();
		Set<Integer> aiIds = this.actionItemStatusMap.keySet();
		for (Integer aiId : aiIds) {
			int aiIndex = this.getDtos().indexOf(new ActionItemDTO(aiId));
			if (aiIndex < 0) continue;
			ActionItemDTO ai = (ActionItemDTO) this.getDtos().get(aiIndex);
			ai.status = new RefDTO(this.actionItemStatusMap.get(aiId));
		}
		((ActionItemService)this.getService()).updateListStatus(
			(List<ActionItem>) this.getDto2doConverter().getDomainObjectList(this.getDtos()));
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public void prepare() throws Exception {
		super.prepare();
		this.actionItemTypes = new ArrayList<RefDTO>();
		this.actionItemTypes.add(new RefDTO(ActionItemDTO.Type.P.name(), ActionItemDTO.Type.P.getDescription()));
		this.actionItemTypes.add(new RefDTO(ActionItemDTO.Type.I.name(), ActionItemDTO.Type.I.getDescription()));
		this.actionItemTypes.add(new RefDTO(ActionItemDTO.Type.F.name(), ActionItemDTO.Type.F.getDescription()));
		List<CriticalFunction> cfs = this.criticalFunctionService.getCriticalFunctionList(this.getSessionPlan().id);
		for (CriticalFunction criticalFunction : cfs) {
			this.actionItemTypes.add(new RefDTO(criticalFunction.getId().toString(), criticalFunction.getName()));
		}
	}
	
	public PlanNavigation getPlanNavigation() {
		return PlanNavigation.SUMMARY;
	}

}
