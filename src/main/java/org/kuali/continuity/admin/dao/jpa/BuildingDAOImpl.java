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

import org.kuali.continuity.admin.dao.BuildingDAO;
import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class BuildingDAOImpl extends BaseAdminDAOImpl implements BuildingDAO, SimpleAdminDao {

	public void create(Building dObj) {
		super.create(dObj);
	}
	
	public void update(Building dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Building getById(int id) {
		return (Building) super.getById(id);
	}
	
	@Override
	public Building getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (Building) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Building> getListBySystemDomainId(int systemDomainId) {
		return (List<Building>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Building> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<Building>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Building> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<Building>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Building> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Building>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return Building.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Building.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Building.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM Building dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
