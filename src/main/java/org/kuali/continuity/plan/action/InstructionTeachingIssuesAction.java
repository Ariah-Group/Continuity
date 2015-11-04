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

import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.CustomActionExecutionConstants;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.TeachingIssueDTO;
import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.plan.service.InstructionService;

@SuppressWarnings("serial")
public class InstructionTeachingIssuesAction extends InstructionAction {
	
	private int insId;
	private TeachingIssueDTO dto2;
	private InstructionService instructionService;
	
	public InstructionTeachingIssuesAction(InstructionService instructionService) {
		this.instructionService = instructionService;
	}
	
	@Override
	public int getInsId() {
		return this.insId;
	}

	@Override
	public void setInsId(int insId) {
		this.insId = insId;
	}

	public TeachingIssueDTO getDto2() {
		return this.dto2;
	}

	public void setDto2(TeachingIssueDTO dto2) {
		this.dto2 = dto2;
	}
	
	@Override
	public int getOwnerId() {
		return this.getInsId();
	}

	@Override
	public String list() throws Exception {
		if (this.getDeptName() == null || this.getDeptName().trim().length() == 0) {
			Instruction instruction = this.instructionService.getById(this.insId);
			if (instruction != null && instruction.getDepartment() != null)
				this.setDeptName(instruction.getDepartment().getName());
		}
		return super.list();
	}

	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setValidateAction(new TeachingIssuesValidateAction());
	}
	
	@Override
	public String save() throws Exception {
		String retValue = SUCCESS;
		if (this.getSaveActionType() != 2) {
			retValue = this.add();
			if (!retValue.equals(SUCCESS) && !retValue.equals(CustomActionExecutionConstants.CONTINUE)) return retValue;
		}
		if (this.getSaveActionType() != 1) {
			this.setDto(this.dto2);
			retValue = this.add();
			if (!retValue.equals(SUCCESS) && !retValue.equals(CustomActionExecutionConstants.CONTINUE)) {
				this.setDto(new TeachingIssueDTO());
				return retValue;
			}
		}
		return this.getSaveTypeEnum().getActionReturnValue();
	}

	public class TeachingIssuesValidateAction extends BaseValidateAction {
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			TeachingIssueDTO dto = (TeachingIssueDTO) dObjDTO;
			if (dto.instruction == null || dto.instruction.id == 0 ||
			   ((dto.name == null || dto.name.trim().length() == 0) &&
				(dto.impact == null || dto.impact.trim().length() == 0) &&
				(dto.alternatives == null || dto.alternatives.trim().length() == 0))) {
				return null;
			}
			
			if (dto.name == null || dto.name.trim().length() == 0) {
				this.addFieldError("dto.name", "Entries in this field require a corresponding selection in the 'special teaching issue' field.");
				return false;
			}
			
			return true;
		}
	}

}
