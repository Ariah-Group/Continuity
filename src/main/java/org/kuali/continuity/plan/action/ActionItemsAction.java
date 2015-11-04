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
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.ActionItemDTO;
import org.kuali.continuity.plan.domain.ActionItem;
import org.kuali.continuity.plan.domain.CriticalFunctionActionItem;
import org.kuali.continuity.plan.domain.FacultyPreparednessActionItem;
import org.kuali.continuity.plan.domain.InformationTechnologyActionItem;
import org.kuali.continuity.plan.domain.InstructionActionItem;
import org.kuali.continuity.plan.service.ActionItemService;
import org.kuali.continuity.plan.service.ActionItemServiceFactory;

@SuppressWarnings("serial")
public abstract class ActionItemsAction extends BasePlanFormAction {
	
	// services
	private ActionItemServiceFactory actionItemServiceFactory;
	
	public ActionItemsAction(ActionItemServiceFactory actionItemServiceFactory) {
		super();
		this.actionItemServiceFactory = actionItemServiceFactory;
		this.setValidateAction(new ValidateAction());
	}

	@Override
	protected int getOwnerId() {
		return this.getSessionPlan().id;
	}
	
	protected ActionItemService getActionItemService() {
		String t = this.getActionItemType();
		Class<? extends ActionItem> testClass = ActionItem.class;
		if (t.equals(ActionItemDTO.Type.C.name()))
			testClass = CriticalFunctionActionItem.class;
		else if (t.equals(ActionItemDTO.Type.F.name()))
			testClass = FacultyPreparednessActionItem.class;
		else if (t.equals(ActionItemDTO.Type.I.name()))
			testClass = InformationTechnologyActionItem.class;
		else if (t.equals(ActionItemDTO.Type.T.name()))
			testClass = InstructionActionItem.class;
		return this.actionItemServiceFactory.getActionItemService(testClass);	
	}
	
	protected String getActionItemType() {
		return ((ActionItemDTO) this.getDto()).type.name();
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setService(this.getActionItemService());
	}
	
	public class ValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			ActionItemDTO dto = (ActionItemDTO) dObjDTO;
			if ((dto.name != null && dto.name.trim().length() != 0) ||
				(dto.cost != null && dto.cost.id.trim().length() != 0) ||
				(dto.costCycle != null && dto.costCycle.id.trim().length() != 0) ||
			    (dto.scope != null && dto.scope.id.trim().length() != 0) ||
			    (dto.status != null && dto.status.id.trim().length() != 0) ||
			    (dto.comment != null && dto.comment.trim().length() != 0)) return true;
			return null;
		}
	}
	
}
