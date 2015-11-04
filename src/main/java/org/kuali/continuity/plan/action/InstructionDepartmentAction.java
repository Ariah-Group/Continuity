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

import java.util.List;

import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.CustomActionExecutionConstants;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.InstructionDTO;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.CriticalFunctionService;

@SuppressWarnings("serial")
public class InstructionDepartmentAction extends InstructionAction {
	
	private CriticalFunctionService criticalFunctionService;

	public InstructionDepartmentAction(CriticalFunctionService criticalFunctionService) {
		super();
		this.criticalFunctionService = criticalFunctionService;
	}
	
	@Override
	public String add() throws Exception {
		String retVal = super.add();
		if (!retVal.equals(SUCCESS) && !retVal.equals(CustomActionExecutionConstants.CONTINUE))
			return retVal;

		// test instruction
		CriticalFunction criticalFunction = this.criticalFunctionService.getInstructionCriticalFunction(this.getSessionPlan().id);
		if (criticalFunction != null) return retVal;

		// create instruction
		criticalFunction = new CriticalFunction();
		criticalFunction.setName(CriticalFunction.CF_INSTRUCTION);
		criticalFunction.setPlan(this.getSessionPlan().getDomainObject());
		this.criticalFunctionService.createCriticalFunction(criticalFunction);
		
		// return
		return retVal;
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setValidateAction(new DepartmentValidateAction());
	}
	
	public class DepartmentValidateAction extends BaseValidateAction {
		@Override
		@SuppressWarnings("unchecked")
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			InstructionDTO dto = (InstructionDTO) dObjDTO;
			if (dto.instructionalDepartment == null || 
				dto.instructionalDepartment.id == 0) {
				return null;
			}
			
			DomainObjectDTO deptDTO = dto.instructionalDepartment;
			InstructionDepartmentAction.this.list();
			List<InstructionDTO> dtos = (List<InstructionDTO>)InstructionDepartmentAction.this.getDtos();
			for (InstructionDTO instructionDTO : dtos) {
				if (deptDTO.equals(instructionDTO.instructionalDepartment)) {
					this.addFieldError("dto.instructionalDepartment.id",
						"You have already added this Department.");
					return false;
				}
			}
			
			return true;
		}
	}

}
