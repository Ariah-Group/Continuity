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
import org.kuali.continuity.action.UpdateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.util.DTO2DomainObjectConverter;
import org.kuali.continuity.plan.action.dto.HighPriorityCourseDTO;
import org.kuali.continuity.plan.domain.HighPriorityCourse;
import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.plan.service.HighPriorityCourseService;
import org.kuali.continuity.plan.service.InstructionService;

@SuppressWarnings("serial")
public class InstructionHighPriorityCoursesAction extends InstructionAction {
	
	private int insId;
	private InstructionService instructionService;
	
	public InstructionHighPriorityCoursesAction(InstructionService instructionService) {
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
		this.setValidateAction(new HighPriorityCoursesValidateAction());
		this.getSaveActions().put(1, this.getAddAction());
		this.getSaveActions().put(2, new HighPriorityCoursesUpdateAction());
	}
	
	public class HighPriorityCoursesUpdateAction implements UpdateAction {
		@SuppressWarnings("unchecked")
		@Override
		public String execute() throws Exception {
			List<HighPriorityCourseDTO> dtos = (List<HighPriorityCourseDTO>)
				InstructionHighPriorityCoursesAction.this.getDtos();
			HighPriorityCourseService service = (HighPriorityCourseService)
				InstructionHighPriorityCoursesAction.this.getService();
			DTO2DomainObjectConverter converter = 
				InstructionHighPriorityCoursesAction.this.getDto2doConverter();
			List<HighPriorityCourse> objs = (List<HighPriorityCourse>)
				converter.getDomainObjectList(dtos);
			service.update(objs);
			return SUCCESS;
		}
		
	}
	
	public class HighPriorityCoursesValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			HighPriorityCourseDTO dto = (HighPriorityCourseDTO) dObjDTO;
			if (dto.instruction == null || dto.instruction.id == 0 ||
			   ((dto.courseNum == null || dto.courseNum.trim().length() == 0) &&
				(dto.courseTitle == null || dto.courseTitle.trim().length() == 0))) {
				return null;
			}
			
			if (dto.courseNum == null || dto.courseNum.trim().length() == 0) {
				this.addFieldError("dto.courseNum", "Both Course Number and Course Title are required.");
				return false;
			}
			
			if (dto.courseTitle == null || dto.courseTitle.trim().length() == 0) {
				this.addFieldError("dto.courseTitle", "Both Course Number and Course Title are required.");
				return false;
			}

			return true;
		}
	}

}
