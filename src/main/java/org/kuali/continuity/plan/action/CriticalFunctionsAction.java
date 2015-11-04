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

import org.kuali.continuity.action.dto.SaveTypeEnum;
import org.kuali.continuity.admin.domain.SystemDomainCriticalFunctionCriticalityLevel;
import org.kuali.continuity.admin.service.SystemDomainCriticalityLevelService;
import org.kuali.continuity.domain.CriticalFunctionCriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.CriticalFunctionDTOPrioritySort;
import org.kuali.continuity.plan.action.dto.PlanNavigation;
import org.kuali.continuity.plan.action.dto.SystemDomainCriticalityLevelDTO;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.plan.service.CriticalFunctionService;
import org.kuali.continuity.plan.service.InstructionService;

import edu.emory.mathcs.backport.java.util.Collections;

@SuppressWarnings("serial")
public class CriticalFunctionsAction extends BasePlanActionSupport implements PlanNavigationSession, SessionPlanRequired {
	
	private CriticalFunctionService criticalFunctionService;
	private InstructionService instructionService;
	private SystemDomainCriticalityLevelService systemDomainCriticalityLevelService;
	
	private List<SystemDomainCriticalityLevelDTO> criticalityLevels = new ArrayList<SystemDomainCriticalityLevelDTO>();
	private List<CriticalFunctionDTO> criticalFunctions = new ArrayList<CriticalFunctionDTO>();
	private String addCriticalFunctionName;
	private int criticalFunctionId;
	
	public CriticalFunctionsAction(
			CriticalFunctionService criticalFunctionService, 
			InstructionService instructionService,
			SystemDomainCriticalityLevelService systemDomainCriticalityLevelService) {
		this.criticalFunctionService = criticalFunctionService;
		this.instructionService = instructionService;
		this.systemDomainCriticalityLevelService = systemDomainCriticalityLevelService;
	}
	
	public List<SystemDomainCriticalityLevelDTO> getCriticalityLevels() {
		return this.criticalityLevels;
	}

	public void setCriticalityLevels(List<SystemDomainCriticalityLevelDTO> criticalityLevels) {
		this.criticalityLevels = criticalityLevels;
	}

	public List<CriticalFunctionDTO> getCriticalFunctions() {
		return this.criticalFunctions;
	}

	public void setCriticalFunctions(List<CriticalFunctionDTO> criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}
	
	public String getAddCriticalFunctionName() {
		return this.addCriticalFunctionName;
	}

	public void setAddCriticalFunctionName(String addCriticalFunctionName) {
		this.addCriticalFunctionName = addCriticalFunctionName;
	}

	public int getCriticalFunctionId() {
		return this.criticalFunctionId;
	}

	public void setCriticalFunctionId(int criticalFunctionId) {
		this.criticalFunctionId = criticalFunctionId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void prepare() throws Exception {
		super.prepare();
		Map<CriticalityLevelEnum, ? extends CriticalityLevel> levelMap = this.systemDomainCriticalityLevelService.getListByOwnerId(
				SystemDomainCriticalFunctionCriticalityLevel.class, 
				this.getSessionSystemDomain().id);
		Collection<? extends CriticalFunctionCriticalityLevel> levels = (Collection<CriticalFunctionCriticalityLevel>) levelMap.values();
		for (CriticalFunctionCriticalityLevel level : levels) {
			this.criticalityLevels.add(new SystemDomainCriticalityLevelDTO(level));
		}
	}

	public String execute() {
		List<CriticalFunction> origCriticalFunctions = 
			this.criticalFunctionService.getCriticalFunctionList(this.getSessionPlan().id, CriticalFunction.SortBy.priority, true);
		if (origCriticalFunctions != null && !origCriticalFunctions.isEmpty()) {
			int pos = 0;
			this.criticalFunctions = new ArrayList<CriticalFunctionDTO>();
			List<CriticalFunction> cfs2Update = new ArrayList<CriticalFunction>();
			
			// iterate
			for (CriticalFunction origCriticalFunction : origCriticalFunctions) {
				
				// get cf to update 
				pos++;
				if (origCriticalFunction.getPriority() != pos) {
					origCriticalFunction.setPriority(pos);
					cfs2Update.add(origCriticalFunction);
				}
				
				// set dto
				CriticalFunctionDTO cfDTO = new CriticalFunctionDTO(origCriticalFunction);
				cfDTO.plan = this.getSessionPlan();
				this.criticalFunctions.add(cfDTO);
			}
			
			// re-sort
			this.criticalFunctionService.updateCriticalFunctions(cfs2Update);
		}
		return SUCCESS;
	}
	
	public String add() {
		//Validate if instruction already exists 
		if((this.criticalFunctions != null && !this.criticalFunctions.isEmpty()) || (this.addCriticalFunctionName != null && this.addCriticalFunctionName.trim().length() != 0)){
			//validate if instruction already exists
			if (this.getSessionSystemDomain().settings.isInstructionVisible && this.addCriticalFunctionName.equals(CriticalFunction.CF_INSTRUCTION)) {
				CriticalFunction cf = this.criticalFunctionService.getInstructionCriticalFunction(this.getSessionPlan().id);
				if (cf != null) {
					this.addCriticalFunctionName = "";
					this.addActionError("Critical Function 'Instruction' already exists");
					return INPUT;
				}
			}
		}
		
		//Save existing criticalfunctions first
		if (this.criticalFunctions != null && !this.criticalFunctions.isEmpty()) {			
			// validate
			for (CriticalFunctionDTO cfDTO : this.criticalFunctions) {
				if (cfDTO == null) continue;
				if (cfDTO.criticalityLevel.levelNo == null) {
					this.addActionError("One (or more) of the functions on your list has not been assigned a Level of Criticality");
					return INPUT;
				}
			}
		
			// sort
			Collections.sort(this.criticalFunctions, new CriticalFunctionDTOPrioritySort());

			// set
			int pos = 0;
			List<CriticalFunction> cfs = new ArrayList<CriticalFunction>();
			for (CriticalFunctionDTO cfDTO : this.criticalFunctions) {
				cfDTO.priority = ++pos;
				CriticalFunction cf = this.criticalFunctionService.getCriticalFunction(cfDTO.id);
				CriticalFunction modCF = cfDTO.getDomainObject();
				if (modCF.getPriority() != cf.getPriority() ||
					!modCF.getCriticalityLevelEnum().equals(cf.getCriticalityLevelEnum())) {
						cf.setPriority(modCF.getPriority());
						cf.setCriticalityLevelEnum(modCF.getCriticalityLevelEnum());
						cfs.add(cf);
				}
			}
			
			// update
			this.criticalFunctionService.updateCriticalFunctions(cfs);
		
		} 
		
		if (this.addCriticalFunctionName != null && this.addCriticalFunctionName.trim().length() != 0) {		
			// test instruction
			CriticalFunction criticalFunction = new CriticalFunction();
			criticalFunction.setName(this.addCriticalFunctionName);
			criticalFunction.setPlan(this.getSessionPlan().getDomainObject());
			criticalFunction.setPriority(0);
			this.criticalFunctionService.createCriticalFunction(criticalFunction);
		}
		return SUCCESS;
	}
	
	public String reorder() {
		return this.update();
	}
	
	
	public String update() {
		// check access for get descriptions action
		if (this.getSaveTypeEnum() != SaveTypeEnum.CONTINUE &&
			PlanAccessTypeEnum.VIEW_ONLY.getRefDomainObject().equals(
			new PlanAccessType(this.getSessionPlan().planAccess.id)))
			this.setSaveType(SaveTypeEnum.CONTINUE.getId());
		
		if (this.getSaveTypeEnum().isSaveAction()) {
			if (this.criticalFunctions != null && !this.criticalFunctions.isEmpty()) {
				// validate
				for (CriticalFunctionDTO cfDTO : this.criticalFunctions) {
					if (cfDTO == null) continue;
					if (cfDTO.criticalityLevel.levelNo == null || cfDTO.criticalityLevel.levelNo.id.equals(CriticalityLevelEnum.LEVEL0.getValue())) {
						this.addActionError("One (or more) of the functions on your list has not been assigned a Level of Criticality");
						return INPUT;
					}
				}
			
				// sort
				Collections.sort(this.criticalFunctions, new CriticalFunctionDTOPrioritySort());

				// set
				int pos = 0;
				List<CriticalFunction> cfs = new ArrayList<CriticalFunction>();
				for (CriticalFunctionDTO cfDTO : this.criticalFunctions) {
					cfDTO.priority = ++pos;
					CriticalFunction cf = this.criticalFunctionService.getCriticalFunction(cfDTO.id);
					CriticalFunction modCF = cfDTO.getDomainObject();
					if (modCF.getPriority() != cf.getPriority() ||
						!modCF.getCriticalityLevelEnum().equals(cf.getCriticalityLevelEnum())) {
							cf.setPriority(modCF.getPriority());
							cf.setCriticalityLevelEnum(modCF.getCriticalityLevelEnum());
							cfs.add(cf);
					}
				}
				
				// update
				this.criticalFunctionService.updateCriticalFunctions(cfs);
			
			} else {
				if (this.getSaveTypeEnum() == SaveTypeEnum.SAVE) return INPUT;
			}
		}
		// return
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public String delete() {
		if (this.getSessionSystemDomain().settings.isInstructionVisible) {
			CriticalFunction cf = this.criticalFunctionService.getCriticalFunction(this.criticalFunctionId);
			if (cf != null && cf.getName().equals(CriticalFunction.CF_INSTRUCTION)) {
				List<Instruction> ins = this.instructionService.getListByOwnerId(this.getSessionPlan().id);
				if (ins != null && !ins.isEmpty()) {
					this.addActionError("The 'Instruction' critical function cannot be deleted if Step 4 of this questionnaire contains any data. If you wish to delete 'Instruction' from your list of critical functions, please go to <a href='getInstructions'>Step4: Instruction</a> and delete all the entries on your 'Department' list. Then return to Step 2: Critical Functions, where you will be allowed to delete 'Instruction' from that list.");
					this.execute();
					return INPUT;
				}
			}
		}
		this.criticalFunctionService.deleteCriticalFunction(this.criticalFunctionId);
		return SUCCESS;
	}
	
	public PlanNavigation getPlanNavigation() {
		return PlanNavigation.STEP2;
	}

}
