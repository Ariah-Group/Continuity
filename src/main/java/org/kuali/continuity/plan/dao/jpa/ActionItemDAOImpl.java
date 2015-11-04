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
package org.kuali.continuity.plan.dao.jpa;

import java.util.List;

import org.kuali.continuity.dao.jpa.BaseDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.ActionItemDAO;
import org.kuali.continuity.plan.domain.ActionItem;

public class ActionItemDAOImpl extends BaseDomainObjectDAOImpl implements
		ActionItemDAO {

	public void create(ActionItem dObj) {
		super.create(dObj);
	}
	
	public void update(ActionItem dObj) {
		super.update(dObj);
	}
	
	public void updateListStatus(List<ActionItem> dObjs) {
		for (ActionItem actionItem : dObjs) {
			ActionItem origActionItem = this.getById(actionItem.getId());
			if (origActionItem.getStatus().equals(actionItem.getStatus())) continue;
			origActionItem.setStatus(actionItem.getStatus());
			super.update(origActionItem);
		}
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public ActionItem getById(int id) {
		return (ActionItem) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends ActionItem> getListByOwnerId(int ownerId) {
		return (List<ActionItem>) super.getListByOwnerId(ownerId);
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return ActionItem.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "ContinuityPlan.ActionItem.list";
	}

}
