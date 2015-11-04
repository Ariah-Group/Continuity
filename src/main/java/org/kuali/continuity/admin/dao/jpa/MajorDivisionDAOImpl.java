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

import org.kuali.continuity.admin.dao.MajorDivisionDAO;
import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class MajorDivisionDAOImpl extends BaseAdminDAOImpl implements
		MajorDivisionDAO, SimpleAdminDao {

	public void create(MajorDivision dObj) {
		super.create(dObj);
	}
	
	public void update(MajorDivision dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public MajorDivision getById(int id) {
		return (MajorDivision) super.getById(id);
	}
	
	@Override
	public MajorDivision getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (MajorDivision) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MajorDivision> getListBySystemDomainId(int systemDomainId) {
		return (List<MajorDivision>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MajorDivision> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<MajorDivision>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MajorDivision> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<MajorDivision>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<MajorDivision> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<MajorDivision>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return MajorDivision.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "MajorDivision.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "MajorDivision.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM MajorDivision dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
