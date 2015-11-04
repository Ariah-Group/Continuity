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
package org.kuali.continuity.plan.dao;

import java.util.Map;

import org.kuali.continuity.plan.domain.ActionItem;

public class ActionItemDAOFactoryImpl implements ActionItemDAOFactory {

	private Map<String, ActionItemDAO> actionItemDAOMap;

	public ActionItemDAO getActionItemDAO(Class<? extends ActionItem> actionItemClass) {
		return this.actionItemDAOMap.get(actionItemClass.getName());
	}

	public Map<String, ActionItemDAO> getActionItemDAOMap() {
		return this.actionItemDAOMap;
	}

	public void setActionItemDAOMap(Map<String, ActionItemDAO> actionItemDAOMap) {
		this.actionItemDAOMap = actionItemDAOMap;
	}

}
