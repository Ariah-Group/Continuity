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

import org.kuali.continuity.admin.dao.SystemDomainGroupDAO;
import org.kuali.continuity.admin.domain.SystemDomainGroup;
import org.kuali.continuity.dao.jpa.BaseSortableDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.SortByType;

public class SystemDomainGroupDAOImpl extends BaseSortableDomainObjectDAOImpl
	implements SystemDomainGroupDAO {

	@Override
	public void create(SystemDomainGroup obj) {
		super.create(obj);
	}

	@Override
	public void delete(int id) {
		super.delete(id);
	}

	@Override
	public void update(SystemDomainGroup obj) {
		super.update(obj);
	}

	@Override
	public SystemDomainGroup getById(int id) {
		return (SystemDomainGroup) super.getById(id);
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomainGroup> getAll() {
		Query query = super.buildQuery(this.getNamedListQuery());
		return (List<SystemDomainGroup>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomainGroup> getAll(int start, int limit) {
		Query query = super.buildListQuery(this.getNamedListQuery(), start, limit);
		return (List<SystemDomainGroup>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomainGroup> getAll(SortByType sortBy, boolean isAscending) {
		Query query = super.buildListQuery(this.getBaseQueryString(), sortBy, isAscending);
		return (List<SystemDomainGroup>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomainGroup> getAll(int start, int limit, SortByType sortBy,
			boolean isAscending) {
		Query query = super.buildListQuery(this.getBaseQueryString(), start, limit, sortBy, isAscending);
		return (List<SystemDomainGroup>) query.getResultList();
	}

	public long getAllSize() {
		Query query = this.buildQuery(this.getNamedSizeQuery());
		return (Long) query.getSingleResult();
	}
	
	@Override
	public List<? extends BaseDomainObject> getListByOwnerId(int ownerId) {
		return null;   // not supported;
	}

	@Override
	public List<? extends BaseDomainObject> getSubListByOwnerId(int ownerId,
			int start, int limit) {
		return null;   // not supported;
	}

	@Override
	protected String getBaseQueryString() {
		return "SELECT dObj FROM SystemDomainGroup dObj";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "SystemDomainGroup.size";
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return SystemDomainGroup.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "SystemDomainGroup.list";
	}

}
