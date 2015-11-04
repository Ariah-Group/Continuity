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

import org.kuali.continuity.admin.dao.DependencyDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class DependencyDAOImpl extends BaseAdminOrderedDAOImpl implements DependencyDAO {

	public void create(Dependency dObj) {
		super.create(dObj);
	}
	
	public void update(Dependency dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Dependency getById(int id) {
		return (Dependency) super.getById(id);
	}
	
	@Override
	public Dependency getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (Dependency) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public Dependency getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (Dependency) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public Dependency getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (Dependency) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Dependency> getListBySystemDomainId(int systemDomainId) {
		return (List<Dependency>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Dependency> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<Dependency>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Dependency> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<Dependency>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Dependency> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Dependency>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Dependency> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<Dependency>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return Dependency.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Dependency.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Dependency.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM Dependency dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
}
