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

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.CriticalFunctionActionItem;

public class CriticalFunctionActionItemDAOImpl extends ActionItemDAOImpl {

	public void create(CriticalFunctionActionItem dObj) {
		super.create(dObj);
	}
	
	public void update(CriticalFunctionActionItem dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public CriticalFunctionActionItem getById(int id) {
		return (CriticalFunctionActionItem) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CriticalFunctionActionItem> getListByOwnerId(int ownerId) {
		return (List<CriticalFunctionActionItem>) super.getListByOwnerId(ownerId);
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return CriticalFunctionActionItem.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "ContinuityPlan.CriticalFunctionActionItem.list";
	}

}
