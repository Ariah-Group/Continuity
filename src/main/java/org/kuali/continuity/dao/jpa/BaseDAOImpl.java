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

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public abstract class BaseDAOImpl {
	private EntityManager em;
	
	protected EntityManager getEntityManager() {
		return em;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	protected Query buildQuery(String queryName) {
		return this.em.createNamedQuery(queryName);
	}
	
	protected Query buildListQuery(String queryName, int start, int limit) {
		Query query = this.buildQuery(queryName);
		this.setQueryStartLimit(query, start, limit);
		return query;
	}
	
	protected void setQueryParameters(Query query, Map<String, Object> map) {
		if (map == null || map.isEmpty()) return;
		for (String key : map.keySet())
			query.setParameter(key, map.get(key));
	}
		
	protected void setQueryStartLimit(Query query, int start, int limit) {
		query.setFirstResult(start);
		query.setMaxResults(limit);
	}

}
