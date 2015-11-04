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

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.kuali.continuity.admin.dao.BaseAdminDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.dao.jpa.BaseSortableDomainObjectDAOImpl;
import org.kuali.continuity.domain.SortByType;

public abstract class BaseAdminDAOImpl extends BaseSortableDomainObjectDAOImpl
	implements BaseAdminDAO {
	
	public final static String SYSTEM_DOMAIN_ID = "systemDomainId";

	public void create(BaseAdminDomainObject dObj) {
		super.create(dObj);
	}

	public void update(BaseAdminDomainObject dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}

	@Override
	public BaseAdminDomainObject getById(int id) {
		return (BaseAdminDomainObject) super.getById(id);
	}
	
	public BaseAdminDomainObject getBySystemDomainIdAndName(int systemDomainId, String name) {
		String queryString = this.getBaseQueryString() + " AND dObj.name = :name";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter(this.getOwnerIdParamName(), systemDomainId);
		query.setParameter("name", name);
		return this.getSingleResult(query);
	}
	
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListByOwnerIdSize(systemDomainId);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getListBySystemDomainId(int systemDomainId) {
		return (List<? extends BaseAdminDomainObject>) super.getListByOwnerId(systemDomainId);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<? extends BaseAdminDomainObject>) super.getSubListByOwnerId(systemDomainId, start, limit);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy,
			boolean isAscending) {
		return (List<? extends BaseAdminDomainObject>) super.getSortedListByOwnerId(systemDomainId, sortBy, isAscending);
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminDomainObject> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit,
			SortByType sortBy, boolean isAscending) {
		return (List<? extends BaseAdminDomainObject>) super.getSortedSubListByOwnerId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	protected String getOwnerIdParamName() {
		return SYSTEM_DOMAIN_ID;
	}
	protected String getParamName() {
		return SYSTEM_DOMAIN_ID;
	}
	protected BaseAdminDomainObject getSingleResult(Query query) {
		try {
			return (BaseAdminDomainObject) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	protected abstract Class<? extends BaseAdminDomainObject> getDomainObjectClass();
	protected abstract String getBaseQueryString();
	protected abstract String getNamedSizeQuery();
	protected abstract String getNamedListQuery();
}
