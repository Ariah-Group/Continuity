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

import javax.persistence.Query;

import org.kuali.continuity.admin.dao.BaseAdminOrderedDAO;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.domain.SortByType;

public abstract class BaseAdminOrderedDAOImpl extends BaseAdminDAOImpl implements
		BaseAdminOrderedDAO {

	public void create(BaseAdminOrderedDomainObject dObj) {
		super.create(dObj);		
	}

	public void update(BaseAdminOrderedDomainObject dObj) {
		super.update(dObj);		
	}
	
	
	@Override
	public BaseAdminOrderedDomainObject getById(int id) {
		return (BaseAdminOrderedDomainObject) super.getById(id);
	}
	
	@Override
	public BaseAdminOrderedDomainObject getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (BaseAdminOrderedDomainObject) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminOrderedDomainObject> getListBySystemDomainId(int systemDomainId) {
		return (List<? extends BaseAdminOrderedDomainObject>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminOrderedDomainObject> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<? extends BaseAdminOrderedDomainObject>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminOrderedDomainObject> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<? extends BaseAdminOrderedDomainObject>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminOrderedDomainObject> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<? extends BaseAdminOrderedDomainObject>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	public BaseAdminOrderedDomainObject getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		String queryString = this.getBaseQueryString() + 
			" AND dObj.orderNo = :orderNo";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter(this.getOwnerIdParamName(), systemDomainId);
		query.setParameter("orderNo", orderNo);
		return (BaseAdminOrderedDomainObject) this.getSingleResult(query);
	}

	public BaseAdminOrderedDomainObject getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		String queryString = this.getBaseQueryString() + 
			" AND dObj.orderNo = " +
			" (SELECT MAX(dObj2.orderNo) FROM " +
			this.getDomainObjectClass().getSimpleName() + " dObj2 " +
			" WHERE dObj.systemDomainId = dObj2.systemDomainId)";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter(this.getOwnerIdParamName(), systemDomainId);
		this.setQueryStartLimit(query, 0, 1);
		return (BaseAdminOrderedDomainObject) this.getSingleResult(query);
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends BaseAdminOrderedDomainObject> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		String queryString = this.getBaseQueryString() + 
			" AND dObj.orderNo >= :orderNo ORDER by dObj.orderNo";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter(this.getOwnerIdParamName(), systemDomainId);
		query.setParameter("orderNo", startOrderNo);
		return (List<? extends BaseAdminOrderedDomainObject>) query.getResultList();
	}

}
