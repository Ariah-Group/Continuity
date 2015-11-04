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

import org.kuali.continuity.plan.action.dto.PlanActionExecutionConstants;
import org.kuali.continuity.plan.action.dto.PlanNavigation;
import org.kuali.continuity.plan.service.ActionItemServiceFactory;

@SuppressWarnings("serial")
public class FacultyPreparednessActionItemsAction extends ActionItemsAction implements PlanNavigationSession {

	public FacultyPreparednessActionItemsAction(ActionItemServiceFactory actionItemServiceFactory) {
		super(actionItemServiceFactory);
	}
	
	public PlanNavigation getPlanNavigation() {
		return PlanNavigation.STEP4;
	}
	
	public String list() throws Exception {
		if (this.getSessionSystemDomain().settings.isInstructionVisible)
			return PlanActionExecutionConstants.STEP_4I;
		return super.list();
	}

}
