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
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.SaveTypeEnum;
import org.kuali.continuity.admin.domain.SystemDomainCriticalFunctionCriticalityLevel;
import org.kuali.continuity.admin.service.SystemDomainCriticalityLevelService;
import org.kuali.continuity.domain.CriticalFunctionCriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.StaffingRequirementDTO;
import org.kuali.continuity.plan.action.dto.SystemDomainCriticalityLevelDTO;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.CriticalFunctionService;

@SuppressWarnings("serial")
public class KeyResourcesStaffReqsAction extends KeyResourcesAction {
	
	// services
	private CriticalFunctionService criticalFunctionService;
	private SystemDomainCriticalityLevelService systemDomainCriticalityLevelService;
	
	// beans
	private List<CriticalFunctionDTO> criticalFunctions = new ArrayList<CriticalFunctionDTO>();
	private List<SystemDomainCriticalityLevelDTO> criticalityLevels = new ArrayList<SystemDomainCriticalityLevelDTO>();
	
	public KeyResourcesStaffReqsAction(
			CriticalFunctionService criticalFunctionService,
			SystemDomainCriticalityLevelService systemDomainCriticalityLevelService) {
		super();
		this.criticalFunctionService = criticalFunctionService;
		this.systemDomainCriticalityLevelService = systemDomainCriticalityLevelService;
		this.setValidateAction(new ValidateAction());
	}
	
	public List<CriticalFunctionDTO> getCriticalFunctions() {
		return this.criticalFunctions;
	}

	public void setCriticalFunctions(List<CriticalFunctionDTO> criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}
	
	public List<SystemDomainCriticalityLevelDTO> getCriticalityLevels() {
		return this.criticalityLevels;
	}

	public void setCriticalityLevels(
			List<SystemDomainCriticalityLevelDTO> criticalityLevels) {
		this.criticalityLevels = criticalityLevels;
	}

	@Override
	public String list() throws Exception {
		// if setting not visiblie
		if (!KeyResourcesStaffReqsAction.this.getSessionSystemDomain().settings.isStaffRequirementsScreenVisible)
			return SaveTypeEnum.CONTINUE.getActionReturnValue();
		return super.list();
	}

	@SuppressWarnings("unchecked")
	public void prepare() throws Exception {
		super.prepare();
		
		// critical functions
		List<CriticalFunction> cfs = 
			this.criticalFunctionService.getCriticalFunctionList(this.getSessionPlan().id);
		if (cfs == null) return;
		
		// loop
		this.criticalFunctions = new ArrayList<CriticalFunctionDTO>();
		for (CriticalFunction cf : cfs) {
			CriticalFunctionDTO dto = new CriticalFunctionDTO(cf);
			String cfName = cf.getName();
			if (cfName != null && cfName.trim().length() > 40) 
				cfName = cfName.substring(0, 37);
			dto.name = cfName;
			if (cf.getCriticalityLevelEnum() != null) { 
				dto.name += " (" + dto.criticalityLevel.levelNo.id + ")";
			}
			this.criticalFunctions.add(dto);
		}

		// criticality levels
		Map<CriticalityLevelEnum, ? extends CriticalityLevel> levelMap = this.systemDomainCriticalityLevelService.getListByOwnerId(
				SystemDomainCriticalFunctionCriticalityLevel.class, 
				this.getSessionSystemDomain().id);
		Collection<? extends CriticalFunctionCriticalityLevel> levels = (Collection<CriticalFunctionCriticalityLevel>) levelMap.values();
		for (CriticalFunctionCriticalityLevel level : levels) {
			this.criticalityLevels.add(new SystemDomainCriticalityLevelDTO(level));
		}
	}

	// ----- actions ----- //
	
	public class ValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			StaffingRequirementDTO dto = (StaffingRequirementDTO)dObjDTO;
			if ((dto.criticalFunction == null || dto.criticalFunction.id == 0) &&
				(dto.staffCategory == null || dto.staffCategory.id == 0) &&
				(dto.shift == null || dto.shift.id == 0)) 
					return null;
			if (dto.criticalFunction.id == 0)
				this.addFieldError("dto.criticalFunction.id", "Critical Function is required");
			if (dto.staffCategory.id == 0)
				this.addFieldError("dto.staffCategory.id", "Staff category is required");
			if (dto.shift.id == 0)
				this.addFieldError("dto.shift.id", "Shift is required");
			return this.getFieldErrors().isEmpty();
		}
	}
	
}
