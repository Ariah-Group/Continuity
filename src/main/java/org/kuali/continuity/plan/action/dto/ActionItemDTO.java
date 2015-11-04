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
package org.kuali.continuity.plan.action.dto;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.ActionItem;
import org.kuali.continuity.plan.domain.ActionItemCost;
import org.kuali.continuity.plan.domain.ActionItemCostCycle;
import org.kuali.continuity.plan.domain.ActionItemScope;
import org.kuali.continuity.plan.domain.ActionItemStatus;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.CriticalFunctionActionItem;
import org.kuali.continuity.plan.domain.FacultyPreparednessActionItem;
import org.kuali.continuity.plan.domain.InformationTechnologyActionItem;
import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.plan.domain.InstructionActionItem;

@SuppressWarnings("serial")
public class ActionItemDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {
	
	public enum Type {

		I("Information Technology"), 
		C("Critical Function"), 
		F("Faculty Preparedness"),
		T("Instruction"),
		P("Not associated with a critical function");

		private String description;

		Type(final String description) {
			this.description = description;
		}
		
		public String getDescription() {
			return this.description;
		}

	};
	
	public RefDTO cost = new RefDTO();
	public RefDTO costCycle = new RefDTO();
	public RefDTO scope = new RefDTO();
	public RefDTO status = new RefDTO();
	public String comment = "";
	public PlanDTO plan = new PlanDTO();
	public CriticalFunctionDTO criticalFunction = new CriticalFunctionDTO();
	public DomainObjectDTO instruction = new DomainObjectDTO();
	public Type type;
	
	public ActionItemDTO() {
		super();
	}

	public ActionItemDTO(BaseDomainObject obj) {
		super(obj);
	}
	
	public ActionItemDTO(int id, String name) {
		super(id, name);
	}

	public ActionItemDTO(int id) {
		super(id);
	}
	
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public ActionItemDTO(ActionItem actionItem) {
		this.copyFromDomainObject(actionItem);
	}

	public BaseDomainObject getDomainObject() {
		ActionItem actionItem = null;
		
		if (this.type == Type.C) {
			actionItem = new CriticalFunctionActionItem();
			CriticalFunction cf = this.criticalFunction.getDomainObject();
			cf.setPlan(this.plan.getDomainObject());
			((CriticalFunctionActionItem)actionItem).setCriticalFunction(cf);
		} else if (this.type == Type.F) {
			actionItem = new FacultyPreparednessActionItem();
		} else if (this.type == Type.I) {
			actionItem = new InformationTechnologyActionItem();
		} else if (this.type == Type.T) {
			actionItem = new InstructionActionItem();
			Instruction in = new Instruction(this.instruction.id);
			in.setPlan(this.plan.getDomainObject());
			((InstructionActionItem)actionItem).setInstruction(in);
		} else {
			actionItem = new ActionItem();
		}
		
		actionItem.setId(this.id == 0 ? null : this.id);
		actionItem.setName(this.name);
		if (this.cost.id.trim().length() != 0)
			actionItem.setCost(new ActionItemCost(this.cost.id));
		if (this.costCycle.id.trim().length() != 0)
			actionItem.setCostCycle(new ActionItemCostCycle(this.costCycle.id));
		if (this.scope.id.trim().length() != 0)
			actionItem.setScope(new ActionItemScope(this.scope.id));
		if (this.status.id.trim().length() != 0)
			actionItem.setStatus(new ActionItemStatus(this.status.id));
		actionItem.setComment(this.comment);
		if (this.plan != null)
			actionItem.setPlan(this.plan.getDomainObject());
		
		return actionItem;
	}

	public void copyFromDomainObject(BaseDomainObject obj) {
		if (obj == null) return;
		this.id = (obj.getId() == null ? 0 : obj.getId());
		this.name = obj.getName();
		if (!(obj instanceof ActionItem)) return;
		ActionItem actionItem = (ActionItem) obj;
		this.cost = new RefDTO(actionItem.getCost());
		this.costCycle = new RefDTO(actionItem.getCostCycle());
		this.scope = new RefDTO(actionItem.getScope());
		this.status = new RefDTO(actionItem.getStatus());
		this.comment = actionItem.getComment();
		this.type = Type.P;
		if (actionItem instanceof CriticalFunctionActionItem) {
			this.type = Type.C;
			CriticalFunctionActionItem cfActionItem = (CriticalFunctionActionItem) actionItem;
			this.criticalFunction = new CriticalFunctionDTO(cfActionItem.getCriticalFunction());
		} else if (actionItem instanceof FacultyPreparednessActionItem) {
			this.type = Type.F;
		} else if (actionItem instanceof InformationTechnologyActionItem) {
			this.type = Type.I;
		} else if (actionItem instanceof InstructionActionItem) {
			this.type = Type.T;
			InstructionActionItem inActionItem = (InstructionActionItem) actionItem;
			this.instruction = new DomainObjectDTO(inActionItem.getInstruction());
		}
	}
	
}
