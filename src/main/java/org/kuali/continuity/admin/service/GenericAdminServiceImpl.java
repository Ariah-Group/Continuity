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
package org.kuali.continuity.admin.service;

import java.util.List;

import org.kuali.continuity.admin.dao.GenericAdminDAO;
import org.kuali.continuity.admin.dao.GenericAdminDAOFactory;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.domain.SortByType;

public class GenericAdminServiceImpl implements GenericAdminService {

	private GenericAdminDAOFactory factory;
	
	public GenericAdminDAOFactory getFactory() {
		return this.factory;
	}

	public void setFactory(GenericAdminDAOFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	public void create(BaseAdminDomainObject obj) {
		this.getGenericAdminDAO(obj.getClass()).create(obj);
	}

	public void delete(Class<? extends BaseAdminDomainObject> adminClass, int id) {
		this.getGenericAdminDAO(adminClass).delete(id);
	}

	public BaseAdminDomainObject getById(
			Class<? extends BaseAdminDomainObject> adminClass, int id) {
		return this.getGenericAdminDAO(adminClass).getById(id);
	}

	public BaseAdminDomainObject getBySystemDomainIdAndName(
			Class<? extends BaseAdminDomainObject> adminClass,
			int systemDomainId, String name) {
		return this.getGenericAdminDAO(adminClass).getBySystemDomainIdAndName(systemDomainId, name);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getListBySystemDomainId(
			Class<? extends BaseAdminDomainObject> adminClass,
			int systemDomainId) {
		return this.getGenericAdminDAO(adminClass).getListBySystemDomainId(systemDomainId);
	}

	public long getListBySystemDomainIdSize(
			Class<? extends BaseAdminDomainObject> adminClass,
			int systemDomainId) {
		return this.getGenericAdminDAO(adminClass).getListBySystemDomainIdSize(systemDomainId);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getSortedListBySystemDomainId(
			Class<? extends BaseAdminDomainObject> adminClass,
			int systemDomainId, SortByType sortBy, boolean isAscending) {
		return this.getGenericAdminDAO(adminClass).getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getSortedSubListBySystemDomainId(
			Class<? extends BaseAdminDomainObject> adminClass,
			int systemDomainId, int start, int limit, SortByType sortBy,
			boolean isAscending) {
		return this.getGenericAdminDAO(adminClass).getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getSubListBySystemDomainId(
			Class<? extends BaseAdminDomainObject> adminClass,
			int systemDomainId, int start, int limit) {
		return this.getGenericAdminDAO(adminClass).getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@SuppressWarnings("unchecked")
	public void update(BaseAdminDomainObject obj) {
		this.getGenericAdminDAO(obj.getClass()).update(obj);
	}

	@SuppressWarnings("unchecked")
	private GenericAdminDAO getGenericAdminDAO(Class<? extends BaseAdminDomainObject> adminClass) {
		return this.factory.getGenericAdminDAO(adminClass);
	}

}
