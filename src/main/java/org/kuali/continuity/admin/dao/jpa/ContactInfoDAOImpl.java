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

import org.kuali.continuity.admin.dao.ContactInfoDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.ContactInfo;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class ContactInfoDAOImpl extends BaseAdminOrderedDAOImpl implements
		ContactInfoDAO {

	public void create(ContactInfo dObj) {
		super.create(dObj);
	}
	
	public void update(ContactInfo dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public ContactInfo getById(int id) {
		return (ContactInfo) super.getById(id);
	}
	
	@Override
	public ContactInfo getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (ContactInfo) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public ContactInfo getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (ContactInfo) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public ContactInfo getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (ContactInfo) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ContactInfo> getListBySystemDomainId(int systemDomainId) {
		return (List<ContactInfo>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ContactInfo> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<ContactInfo>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ContactInfo> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<ContactInfo>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ContactInfo> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<ContactInfo>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<ContactInfo> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<ContactInfo>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}
	
	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return ContactInfo.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "ContactInfo.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "ContactInfo.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM ContactInfo dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
