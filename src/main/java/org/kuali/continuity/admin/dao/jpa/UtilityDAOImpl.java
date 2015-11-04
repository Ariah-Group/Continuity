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

import org.kuali.continuity.admin.dao.OrderingDao;
import org.kuali.continuity.admin.dao.UtilityDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class UtilityDAOImpl extends BaseAdminOrderedDAOImpl implements UtilityDAO, OrderingDao {

	public void create(Utility dObj) {
		super.create(dObj);
	}
	
	public void update(Utility dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Utility getById(int id) {
		return (Utility) super.getById(id);
	}
	
	@Override
	public Utility getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (Utility) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public Utility getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (Utility) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public Utility getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (Utility) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Utility> getListBySystemDomainId(int systemDomainId) {
		return (List<Utility>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Utility> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<Utility>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Utility> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<Utility>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Utility> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Utility>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Utility> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<Utility>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return Utility.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Utility.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Utility.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM Utility dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
