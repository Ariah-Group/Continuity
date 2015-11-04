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

import org.kuali.continuity.admin.dao.PlannerLogCategoryDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.PlannerLogCategory;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class PlannerLogCategoryDAOImpl extends BaseAdminOrderedDAOImpl implements
		PlannerLogCategoryDAO {

	public void create(PlannerLogCategory dObj) {
		super.create(dObj);
	}
	
	public void update(PlannerLogCategory dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public PlannerLogCategory getById(int id) {
		return (PlannerLogCategory) super.getById(id);
	}
	
	@Override
	public PlannerLogCategory getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (PlannerLogCategory) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public PlannerLogCategory getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (PlannerLogCategory) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public PlannerLogCategory getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (PlannerLogCategory) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PlannerLogCategory> getListBySystemDomainId(int systemDomainId) {
		return (List<PlannerLogCategory>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PlannerLogCategory> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<PlannerLogCategory>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PlannerLogCategory> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<PlannerLogCategory>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<PlannerLogCategory> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<PlannerLogCategory>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<PlannerLogCategory> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<PlannerLogCategory>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return PlannerLogCategory.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "PlannerLogCategory.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "PlannerLogCategory.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM PlannerLogCategory dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
