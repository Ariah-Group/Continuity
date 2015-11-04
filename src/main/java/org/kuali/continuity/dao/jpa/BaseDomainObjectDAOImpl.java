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
package org.kuali.continuity.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.kuali.continuity.dao.BaseDomainObjectDAO;
import org.kuali.continuity.domain.BaseDomainObject;

public abstract class BaseDomainObjectDAOImpl extends BaseDAOImpl  
	implements BaseDomainObjectDAO {
	
	public void create(BaseDomainObject dObj) {
		this.getEntityManager().persist(dObj);
	}

	public void update(BaseDomainObject dObj) {
		this.getEntityManager().merge(dObj);
	}
	
	public void delete(int id) {
		BaseDomainObject dObj = this.getById(id);
		if (dObj != null) this.getEntityManager().remove(dObj);
	}

	public BaseDomainObject getById(int id) {
		return (BaseDomainObject) this.getEntityManager().find(this.getDomainObjectClass(), id);
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends BaseDomainObject> getListByOwnerId(int ownerId) {
		Query query = this.buildListQuery(this.getNamedListQuery(), ownerId);
		return (List<? extends BaseDomainObject>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseDomainObject> getSubListByOwnerId(int ownerId, int start, int limit) {
		Query query = this.buildListQuery(this.getNamedListQuery(), ownerId, start, limit);
		return (List<? extends BaseDomainObject>) query.getResultList();
	}

	protected Query buildListQuery(String queryName, int ownerId) {
		Query query = super.buildQuery(queryName);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}
	
	protected Query buildListQuery(String queryName, int ownerId, int start, int limit) {
		Query query = super.buildListQuery(queryName, start, limit);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}
	
	protected String getOwnerIdParamName() {
		return "ownerId";
	}
	
	protected abstract Class<? extends BaseDomainObject> getDomainObjectClass();
	protected abstract String getNamedListQuery();
}
