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
package org.kuali.continuity.admin.dao.jpa;

import java.util.List;

import org.kuali.continuity.admin.dao.InstructionalDepartmentDAO;
import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class InstructionalDepartmentDAOImpl extends BaseAdminDAOImpl implements
		InstructionalDepartmentDAO, SimpleAdminDao {

	public void create(InstructionalDepartment dObj) {
		super.create(dObj);
	}
	
	public void update(InstructionalDepartment dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public InstructionalDepartment getById(int id) {
		return (InstructionalDepartment) super.getById(id);
	}
	
	@Override
	public InstructionalDepartment getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (InstructionalDepartment) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<InstructionalDepartment> getListBySystemDomainId(int systemDomainId) {
		return (List<InstructionalDepartment>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<InstructionalDepartment> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<InstructionalDepartment>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<InstructionalDepartment> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<InstructionalDepartment>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<InstructionalDepartment> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<InstructionalDepartment>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return InstructionalDepartment.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "InstructionalDepartment.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "InstructionalDepartment.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM InstructionalDepartment dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
