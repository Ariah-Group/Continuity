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
import org.kuali.continuity.plan.dao.StakeholderDAO;
import org.kuali.continuity.plan.domain.Stakeholder;

public class StakeholderDAOImpl extends BaseDomainObjectDAOImpl implements
		StakeholderDAO {

	public void create(Stakeholder dObj) {
		super.create(dObj);
	}
	
	public void update(Stakeholder dObj) {
		// workaround to exception when updating
		// stakeholder type 0
		// super.update(dObj);
		this.delete(dObj.getId());
		dObj.setId(null);
		this.create(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Stakeholder getById(int id) {
		return (Stakeholder) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Stakeholder> getListByOwnerId(int ownerId) {
		return (List<Stakeholder>) super.getListByOwnerId(ownerId);
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return Stakeholder.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Stakeholder.list";
	}

}
