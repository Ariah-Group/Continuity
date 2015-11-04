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

import java.util.List;

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.ActionItemDAO;
import org.kuali.continuity.plan.dao.ActionItemDAOFactory;
import org.kuali.continuity.plan.domain.ActionItem;

public class ActionItemServiceImpl implements ActionItemService {
	
	private ActionItemDAOFactory actionItemDAOFactory;
	private Class<? extends ActionItem> actionItemClass;
	
	public ActionItemServiceImpl(ActionItemDAOFactory actionItemDAOFactory, Class<? extends ActionItem> actionItemClass) {
		this.actionItemDAOFactory = actionItemDAOFactory;
		this.actionItemClass = actionItemClass;
	}

	public void create(ActionItem obj) {
		this.getActionItemDAO().create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((ActionItem)obj);
	}

	public void delete(int id) {
		this.getActionItemDAO().delete(id);
	}

	public ActionItem getById(int id) {
		return this.getActionItemDAO().getById(id);
	}

	public List<? extends ActionItem> getListByOwnerId(int ownerId) {
		return this.getActionItemDAO().getListByOwnerId(ownerId);
	}

	public void update(ActionItem obj) {
		this.getActionItemDAO().update(obj);
	}
	
	public void update(BaseDomainObject obj) {
		this.update((ActionItem)obj);
	}

	public void updateListStatus(List<ActionItem> objs) {
		this.getActionItemDAO().updateListStatus(objs);
	}
	
	private ActionItemDAO getActionItemDAO() {
		return this.actionItemDAOFactory.getActionItemDAO(this.actionItemClass);
	}

}
