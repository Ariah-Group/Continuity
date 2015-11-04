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

import org.kuali.continuity.dao.BaseSortableDomainObjectDAO;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.SortByType;

public abstract class BaseSortableDomainObjectDAOImpl extends BaseDomainObjectDAOImpl
	implements BaseSortableDomainObjectDAO {
	
	public long getListByOwnerIdSize(int ownerId) {
		Query query = this.buildQuery(this.getNamedSizeQuery());
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return (Long) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseDomainObject> getSortedListByOwnerId(int ownerId, SortByType sortBy,
			boolean isAscending) {
		Query query = this.buildListQuery(this.getBaseQueryString(), ownerId, sortBy, isAscending);
		return (List<? extends BaseDomainObject>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<? extends BaseDomainObject> getSortedSubListByOwnerId(int ownerId, int start, int limit,
			SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(this.getBaseQueryString(), ownerId, start, limit, sortBy, isAscending);
		return (List<? extends BaseDomainObject>) query.getResultList();
	}

	protected Query buildListQuery(String baseQueryString, int ownerId, SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(baseQueryString, sortBy, isAscending);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}

	protected Query buildListQuery(String baseQueryString, int ownerId, int start, int limit, SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(baseQueryString, start, limit, sortBy, isAscending);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}
	
	protected Query buildListQuery(String baseQueryString, SortByType sortBy, boolean isAscending) {
		return this.getEntityManager().createQuery(baseQueryString + " " + this.buildQueryOrderByClause(sortBy, isAscending));
	}
	
	protected Query buildListQuery(String baseQueryString, int start, int limit, SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(baseQueryString, sortBy, isAscending);
		super.setQueryStartLimit(query, start, limit);
		return query;
	}

	protected String buildQueryOrderByClause(SortByType sortBy, boolean isAscending) {
		return "ORDER BY dObj." + sortBy.getSortByValue() + " " + (isAscending ? "asc" : " desc");
	}
	
	protected abstract String getBaseQueryString();
	protected abstract String getNamedSizeQuery();
	
}
