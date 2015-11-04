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
import org.kuali.continuity.plan.dao.DepartmentOwnedApplicationDAO;
import org.kuali.continuity.plan.domain.DepartmentOwnedApplication;

public class DepartmentOwnedApplicationServiceImpl implements
		DepartmentOwnedApplicationService {

	private DepartmentOwnedApplicationDAO departmentOwnedApplicationDAO;

	public void create(DepartmentOwnedApplication obj) {
		this.departmentOwnedApplicationDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((DepartmentOwnedApplication)obj);
	}

	public void update(DepartmentOwnedApplication obj) {
		this.departmentOwnedApplicationDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((DepartmentOwnedApplication)obj);
	}

	public void delete(int id) {
		this.departmentOwnedApplicationDAO.delete(id);
	}

	public DepartmentOwnedApplication getById(int id) {
		return this.departmentOwnedApplicationDAO.getById(id);
	}

	public List<DepartmentOwnedApplication> getListByOwnerId(int ownerId) {
		return this.departmentOwnedApplicationDAO.getListByOwnerId(ownerId);
	}

	public DepartmentOwnedApplicationDAO getDepartmentOwnedApplicationDAO() {
		return this.departmentOwnedApplicationDAO;
	}

	public void setDepartmentOwnedApplicationDAO(DepartmentOwnedApplicationDAO departmentOwnedApplicationDAO) {
		this.departmentOwnedApplicationDAO = departmentOwnedApplicationDAO;
	}

}
