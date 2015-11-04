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
package org.kuali.continuity.admin.service;

import java.util.List;

import org.kuali.continuity.admin.dao.SystemDomainGroupDAO;
import org.kuali.continuity.admin.domain.SystemDomainGroup;
import org.kuali.continuity.domain.SortByType;

public class SystemDomainGroupServiceImpl implements SystemDomainGroupService {
	
	private SystemDomainGroupDAO institutionDAO;

	@Override
	public void create(SystemDomainGroup obj) {
		this.institutionDAO.create(obj);
	}

	@Override
	public void delete(int id) {
		this.institutionDAO.delete(id);
	}

	@Override
	public List<SystemDomainGroup> getAll() {
		return this.institutionDAO.getAll();
	}

	@Override
	public List<SystemDomainGroup> getAll(SortByType sortBy, boolean isAscending) {
		return this.institutionDAO.getAll(sortBy, isAscending);
	}

	@Override
	public List<SystemDomainGroup> getAll(int start, int limit) {
		return this.institutionDAO.getAll(start, limit);
	}

	@Override
	public List<SystemDomainGroup> getAll(int start, int limit, SortByType sortBy,
			boolean isAscending) {
		return this.institutionDAO.getAll(start, limit, sortBy, isAscending);
	}

	@Override
	public long getAllSize() {
		return this.institutionDAO.getAllSize();
	}

	@Override
	public SystemDomainGroup getById(int id) {
		return this.institutionDAO.getById(id);
	}

	@Override
	public void update(SystemDomainGroup obj) {
		this.institutionDAO.update(obj);
	}

	public SystemDomainGroupDAO getInstitutionDAO() {
		return this.institutionDAO;
	}

	public void setInstitutionDAO(SystemDomainGroupDAO institutionDAO) {
		this.institutionDAO = institutionDAO;
	}

}
