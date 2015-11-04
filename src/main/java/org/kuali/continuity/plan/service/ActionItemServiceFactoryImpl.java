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
package org.kuali.continuity.plan.service;

import org.kuali.continuity.plan.dao.ActionItemDAOFactory;
import org.kuali.continuity.plan.domain.ActionItem;

public class ActionItemServiceFactoryImpl implements ActionItemServiceFactory {
	
	private ActionItemDAOFactory actionItemDAOFactory;

	public ActionItemService getActionItemService(Class<? extends ActionItem> actionItemClass) {
		return new ActionItemServiceImpl(actionItemDAOFactory, actionItemClass);
	}

	public ActionItemDAOFactory getActionItemDAOFactory() {
		return this.actionItemDAOFactory;
	}

	public void setActionItemDAOFactory(ActionItemDAOFactory actionItemDAOFactory) {
		this.actionItemDAOFactory = actionItemDAOFactory;
	}

}
