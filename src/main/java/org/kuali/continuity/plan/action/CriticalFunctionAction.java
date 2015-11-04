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

import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.CriticalFunctionNavigation;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.CriticalFunctionService;

@SuppressWarnings("serial")
public class CriticalFunctionAction extends BasePlanActionSupport implements SessionPlanRequired {

	private CriticalFunctionService criticalFunctionService;
	
	private CriticalFunctionDTO criticalFunction = new CriticalFunctionDTO();
	private List<CriticalFunctionDTO> criticalFunctions = new ArrayList<CriticalFunctionDTO>();
	private int selectedId;
	private String cfNav;
	private DomainObject2DTOConverter do2dtoConverter;

	public CriticalFunctionAction(CriticalFunctionService criticalFunctionService) {
		this.criticalFunctionService = criticalFunctionService;
	}

	public CriticalFunctionDTO getCriticalFunction() {
		return this.criticalFunction;
	}

	public void setCriticalFunction(CriticalFunctionDTO criticalFunction) {
		this.criticalFunction = criticalFunction;
	}
	
	public List<CriticalFunctionDTO> getCriticalFunctions() {
		return this.criticalFunctions;
	}

	public void setCriticalFunctions(List<CriticalFunctionDTO> criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}

	public int getSelectedId() {
		return this.selectedId;
	}

	public void setSelectedId(int selectedId) {
		this.selectedId = selectedId;
	}

	public String getCfNav() {
		return this.cfNav;
	}

	public void setCfNav(String cfNav) {
		this.cfNav = cfNav;
	}

	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

	public String execute() {
		CriticalFunction svcCriticalFunction = this.criticalFunctionService.getCriticalFunction(this.criticalFunction.id);
		this.criticalFunction = new CriticalFunctionDTO(svcCriticalFunction);
		return SUCCESS;
	}
	
	public String getDescriptions() {
		this.cfNav = CriticalFunctionNavigation.DESCRIPTIONS.name();
		return this.execute();
	}
	
	public String getPeakPeriods() {
		this.cfNav = CriticalFunctionNavigation.PEAK_PERIODS.name();
		return this.execute();
	}
	
	@SuppressWarnings("unchecked")
	public String getConsequences() {
		this.cfNav = CriticalFunctionNavigation.CONSEQUENCES.name();
		this.criticalFunctions = 
			(List<CriticalFunctionDTO>) this.do2dtoConverter.getDomainObjectDTOList(
				this.criticalFunctionService.getNonDeferrableCriticalFunctionSubList(this.getSessionPlan().id, this.criticalFunction.id));
		return this.execute();
	}
	
	public String getCopingMethod() {
		this.cfNav = CriticalFunctionNavigation.HOW_TO_COPE.name();
		return this.execute();
	}
	
	public String updateDescriptions() {
		// update
		this.criticalFunctionService.updateDescriptions(
			this.criticalFunction.id, 
			this.criticalFunction.name, 
			this.criticalFunction.description, 
			this.criticalFunction.performingUnits, 
			this.criticalFunction.responsiblePersons);
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public String updatePeakPeriods() {
		CriticalFunction svcCriticalFunction = this.criticalFunction.getDomainObject();
		this.criticalFunctionService.updatePeakPeriods(svcCriticalFunction.getId(), svcCriticalFunction.getPeakMonths(), svcCriticalFunction.getPeaksExplanation());
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public String updateConsequences() {
		CriticalFunction svcCriticalFunction = this.criticalFunction.getDomainObject();
		this.criticalFunctionService.updateConsequences(svcCriticalFunction.getId(), svcCriticalFunction.getConsequences());
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public String updateCopingMethod() {
		CriticalFunction svcCriticalFunction = this.criticalFunction.getDomainObject();
		this.criticalFunctionService.updateCopingMethod(svcCriticalFunction.getId(), svcCriticalFunction.getCopingMethod());
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public String copyConsequences() {
		if (selectedId != 0) {
			CriticalFunction svcCriticalFunction = this.criticalFunctionService.getCriticalFunction(this.selectedId);
			this.criticalFunctionService.updateConsequences(this.criticalFunction.id, svcCriticalFunction.getConsequences());
		}
		return SUCCESS;
	}

}
