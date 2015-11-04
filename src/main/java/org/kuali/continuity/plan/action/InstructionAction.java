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

import org.kuali.continuity.plan.action.dto.InstructionDTO;
import org.kuali.continuity.plan.action.dto.PlanActionExecutionConstants;
import org.kuali.continuity.plan.action.dto.PlanNavigation;

@SuppressWarnings("serial")
public class InstructionAction extends BasePlanFormAction
	implements PlanNavigationSession {
	
	private InstructionNavigation inNav;
	private String deptName;
	
	public InstructionNavigation getInNav() {
		return this.inNav;
	}

	public int getInsId() {
		return this.getRowId();
	}

	public void setInsId(int insId) {
		this.setRowId(insId);
	}

	public void setInNav(InstructionNavigation inNav) {
		this.inNav = inNav;
		super.setSubNav(inNav);
	}

	@Override
	public PlanNavigation getPlanNavigation() {
		return PlanNavigation.STEP4;
	}

	public String getDeptName() {
		if (this.getDto() instanceof InstructionDTO) {
			InstructionDTO dto = (InstructionDTO)this.getDto();
			if (dto.instructionalDepartment != null)
				return dto.instructionalDepartment.name;
		}
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public String list() throws Exception {
		if (!this.getSessionSystemDomain().settings.isInstructionVisible)
			return PlanActionExecutionConstants.STEP_4F;
		return super.list();
	}

}
