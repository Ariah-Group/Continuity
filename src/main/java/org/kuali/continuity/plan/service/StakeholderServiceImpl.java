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
import org.kuali.continuity.plan.dao.StakeholderDAO;
import org.kuali.continuity.plan.domain.Stakeholder;

public class StakeholderServiceImpl implements StakeholderService {

	private StakeholderDAO stakeholderDAO;

	public void create(Stakeholder obj) {
		this.stakeholderDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((Stakeholder)obj);
	}

	public void update(Stakeholder obj) {
		this.stakeholderDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((Stakeholder)obj);
	}

	public void delete(int id) {
		this.stakeholderDAO.delete(id);
	}

	public Stakeholder getById(int id) {
		return this.stakeholderDAO.getById(id);
	}

	public List<Stakeholder> getListByOwnerId(int ownerId) {
		return this.stakeholderDAO.getListByOwnerId(ownerId);
	}

	public StakeholderDAO getStakeholderDAO() {
		return this.stakeholderDAO;
	}

	public void setStakeholderDAO(StakeholderDAO stakeholderDAO) {
		this.stakeholderDAO = stakeholderDAO;
	}

}
