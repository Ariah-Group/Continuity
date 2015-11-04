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

import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.plan.service.ActionItemServiceFactory;
import org.kuali.continuity.plan.service.InstructionService;

@SuppressWarnings("serial")
public class InstructionActionItemsAction extends ActionItemsAction {

	private int insId;
	private String deptName;
	private InstructionService instructionService;
	
	public InstructionActionItemsAction(
			ActionItemServiceFactory actionItemServiceFactory) {
		super(actionItemServiceFactory);
		this.setSubNav(InstructionNavigation.ACTION_ITEMS);
	}

	public InstructionActionItemsAction(ActionItemServiceFactory actionItemServiceFactory, 
			InstructionService instructionService) {
		this(actionItemServiceFactory);
		this.instructionService = instructionService;
	}
	
	public int getInsId() {
		return this.insId;
	}

	public void setInsId(int insId) {
		this.insId = insId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	protected int getOwnerId() {
		return this.insId;
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

}
