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

import org.kuali.continuity.admin.dao.FAQDAO;
import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.FAQ;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class FAQDAOImpl extends BaseAdminOrderedDAOImpl implements FAQDAO, SimpleAdminDao {

	public void create(FAQ dObj) {
		super.create(dObj);
	}
	
	public void update(FAQ dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public FAQ getById(int id) {
		return (FAQ) super.getById(id);
	}
	
	@Override
	public FAQ getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (FAQ) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public FAQ getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (FAQ) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public FAQ getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (FAQ) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<FAQ> getListBySystemDomainId(int systemDomainId) {
		return (List<FAQ>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<FAQ> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<FAQ>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FAQ> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<FAQ>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<FAQ> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<FAQ>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FAQ> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<FAQ>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return FAQ.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "FAQ.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "FAQ.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM FAQ dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
