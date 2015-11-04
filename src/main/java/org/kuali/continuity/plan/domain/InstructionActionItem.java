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
package org.kuali.continuity.plan.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@DiscriminatorValue("T")
@NamedQuery(name="ContinuityPlan.InstructionActionItem.list",
	query="SELECT dObj FROM InstructionActionItem dObj WHERE dObj.instruction.id = :ownerId")
@SuppressWarnings("serial")
public class InstructionActionItem extends ActionItem {
	
	private Instruction instruction;

	public InstructionActionItem() {
		this.setType("T");
	}

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pis_id", nullable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	public Instruction getInstruction() {
		return this.instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
		if (instruction != null)
			this.setPlan(instruction.getPlan());
	}
	
	@PreUpdate
	@PrePersist
	protected void setNullInstruction() {
		if (this.instruction == null) {
			this.instruction = new Instruction(0);
			this.setType(" ");
		}
		
	}
	
}
