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
import org.kuali.continuity.admin.dao.ShiftDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class ShiftDAOImpl extends BaseAdminOrderedDAOImpl implements ShiftDAO, OrderingDao {

	public void create(Shift dObj) {
		super.create(dObj);
	}
	
	public void update(Shift dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Shift getById(int id) {
		return (Shift) super.getById(id);
	}
	
	@Override
	public Shift getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (Shift) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public Shift getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (Shift) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public Shift getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (Shift) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Shift> getListBySystemDomainId(int systemDomainId) {
		return (List<Shift>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Shift> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<Shift>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Shift> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<Shift>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Shift> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Shift>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Shift> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<Shift>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return Shift.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Shift.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Shift.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM Shift dObj WHERE dObj.systemDomainId = :systemDomainId";
	}

	@SuppressWarnings("unchecked")
	public List getSubList(int systemDomainId, int start, int limit) {

		 return (List<Shift>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}
	
}
