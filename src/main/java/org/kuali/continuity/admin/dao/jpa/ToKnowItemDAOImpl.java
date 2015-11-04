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

import org.kuali.continuity.admin.dao.ToKnowItemDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.ToKnowItem;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class ToKnowItemDAOImpl extends BaseAdminOrderedDAOImpl implements ToKnowItemDAO {

	public void create(ToKnowItem dObj) {
		super.create(dObj);
	}
	
	public void update(ToKnowItem dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public ToKnowItem getById(int id) {
		return (ToKnowItem) super.getById(id);
	}
	
	@Override
	public ToKnowItem getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (ToKnowItem) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public ToKnowItem getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (ToKnowItem) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public ToKnowItem getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (ToKnowItem) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ToKnowItem> getListBySystemDomainId(int systemDomainId) {
		return (List<ToKnowItem>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ToKnowItem> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<ToKnowItem>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ToKnowItem> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<ToKnowItem>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ToKnowItem> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<ToKnowItem>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ToKnowItem> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<ToKnowItem>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return ToKnowItem.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "ToKnowItem.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "ToKnowItem.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM ToKnowItem dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
