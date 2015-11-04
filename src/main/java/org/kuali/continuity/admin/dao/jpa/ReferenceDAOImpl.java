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

import org.kuali.continuity.admin.dao.ReferenceDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Reference;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class ReferenceDAOImpl extends BaseAdminOrderedDAOImpl implements ReferenceDAO {

	public void create(Reference dObj) {
		super.create(dObj);
	}
	
	public void update(Reference dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Reference getById(int id) {
		return (Reference) super.getById(id);
	}
	
	@Override
	public Reference getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (Reference) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public Reference getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (Reference) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public Reference getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (Reference) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Reference> getListBySystemDomainId(int systemDomainId) {
		return (List<Reference>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Reference> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<Reference>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reference> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<Reference>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Reference> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Reference>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Reference> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<Reference>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return Reference.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Reference.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Reference.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM Reference dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
