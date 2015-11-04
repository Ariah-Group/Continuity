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

import org.kuali.continuity.admin.dao.CentralApplicationDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class CentralApplicationDAOImpl extends BaseAdminOrderedDAOImpl implements
		CentralApplicationDAO {


	public void create(CentralApplication dObj) {
		super.create(dObj);
	}
	
	public void update(CentralApplication dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public CentralApplication getById(int id) {
		return (CentralApplication) super.getById(id);
	}
	
	@Override
	public CentralApplication getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (CentralApplication) super.getBySystemDomainIdAndName(systemDomainId, name);
	}

	@Override
	public CentralApplication getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (CentralApplication) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public CentralApplication getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (CentralApplication) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}
	
	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CentralApplication> getListBySystemDomainId(int systemDomainId) {
		return (List<CentralApplication>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CentralApplication> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<CentralApplication>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CentralApplication> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<CentralApplication>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CentralApplication> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<CentralApplication>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CentralApplication> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<CentralApplication>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}
	
	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return CentralApplication.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "CentralApplication.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "CentralApplication.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM CentralApplication dObj WHERE dObj.systemDomainId = :systemDomainId";
	}

}
