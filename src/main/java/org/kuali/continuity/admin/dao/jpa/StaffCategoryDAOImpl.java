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

import org.kuali.continuity.admin.dao.StaffCategoryDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class StaffCategoryDAOImpl extends BaseAdminOrderedDAOImpl implements
		StaffCategoryDAO {

	public void create(StaffCategory dObj) {
		super.create(dObj);
	}
	
	public void update(StaffCategory dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public StaffCategory getById(int id) {
		return (StaffCategory) super.getById(id);
	}
	
	@Override
	public StaffCategory getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (StaffCategory) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public StaffCategory getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (StaffCategory) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public StaffCategory getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (StaffCategory) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<StaffCategory> getListBySystemDomainId(int systemDomainId) {
		return (List<StaffCategory>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<StaffCategory> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<StaffCategory>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StaffCategory> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<StaffCategory>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<StaffCategory> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<StaffCategory>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<StaffCategory> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<StaffCategory>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return StaffCategory.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "StaffCategory.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "StaffCategory.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM StaffCategory dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
