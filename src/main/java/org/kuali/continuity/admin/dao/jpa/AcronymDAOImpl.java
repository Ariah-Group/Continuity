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

import org.kuali.continuity.admin.dao.AcronymDAO;
import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class AcronymDAOImpl extends BaseAdminDAOImpl implements AcronymDAO, SimpleAdminDao {

	public void create(Acronym dObj) {
		super.create(dObj);
	}
	
	public void update(Acronym dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Acronym getById(int id) {
		return (Acronym) super.getById(id);
	}
	
	@Override
	public Acronym getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (Acronym) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Acronym> getListBySystemDomainId(int systemDomainId) {
		return (List<Acronym>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Acronym> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<Acronym>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Acronym> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<Acronym>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Acronym> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Acronym>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return Acronym.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Acronym.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Acronym.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM Acronym dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}