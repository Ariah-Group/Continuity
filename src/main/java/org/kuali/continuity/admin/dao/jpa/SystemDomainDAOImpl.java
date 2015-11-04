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
import java.util.Set;

import javax.persistence.Query;

import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.dao.SystemDomainDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.SystemDomainSettings;
import org.kuali.continuity.dao.jpa.BaseSortableDomainObjectDAOImpl;
import org.kuali.continuity.domain.SortByType;

public class SystemDomainDAOImpl extends BaseSortableDomainObjectDAOImpl implements
	SystemDomainDAO, SimpleAdminDao {
	
	private final static String DOMAIN_ALL_LIST = "SELECT dObj FROM Domain dObj";

	public void create(SystemDomain dObj) {
		this.clearDomains(dObj);
		super.create(dObj);
	}
	
	@Override
	public void create(BaseAdminDomainObject domainObject) {
		this.create((SystemDomain) domainObject);
	}

	public void update(SystemDomain dObj) {
		this.clearDomains(dObj);
		super.update(dObj);
	}
	
	@Override
	public void update(BaseAdminDomainObject domainObject) {
		this.update((SystemDomain) domainObject);
	}
	
	public void update(int id, SystemDomainSettings settings) {
		SystemDomain dObj = this.getById(id);
		dObj.setSettings(settings);
		this.update(dObj);
	}
	
	public void update(int id, Set<String> domains) {
		SystemDomain dObj = this.getById(id);
		dObj.setNetDomains(domains);
		this.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public SystemDomain getById(int id) {
		return (SystemDomain) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public SystemDomain getByGroupAndName(String systemDomainGroup, String name) {
		String queryString = "SELECT dObj FROM Domain dObj where dObj.name = :name";
 		if (systemDomainGroup != null && !systemDomainGroup.trim().isEmpty())
			queryString += " and dObj.systemDomainGroup = :systemDomainGroup";
 		else
 			queryString += " and (dObj.systemDomainGroup = null or dObj.systemDomainGroup = '')";
		Query query =  this.getEntityManager().createQuery(queryString);
		query.setParameter("name", name);
		if (systemDomainGroup != null && !systemDomainGroup.trim().isEmpty())
			query.setParameter(this.getOwnerIdParamName(), systemDomainGroup);
		List<SystemDomain> list = (List<SystemDomain>) query.getResultList();
		if (list == null || list.isEmpty()) return null;
		return list.get(0);
	}
	
	public SystemDomain getBySystemDomainIdAndName(int id, String name) {
		SystemDomain systemDomain = this.getById(id);
		if (systemDomain.getName().equals(name))
			return systemDomain;
		return null;
	}
	
	@Override
	public long getListByGroupSize(String systemGroup) {
		Query query = this.buildQuery(this.getNamedSizeQuery());
		query.setParameter(this.getOwnerIdParamName(), systemGroup);
		return (Long) query.getSingleResult();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getListByGroup(String systemGroup) {
		Query query = this.buildListQuery(this.getNamedListQuery(), systemGroup);
		return (List<SystemDomain>) query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getListByShibIDP(String shibIDP) {
		if (shibIDP == null || shibIDP.trim().length() == 0) return null;
		String queryString = "SELECT dObj FROM Domain dObj where dObj.shibIDP = :systemDomainGroup";
		Query query = this.buildListQuery(queryString, shibIDP, SystemDomain.SortBy.name, true);
		return (List<SystemDomain>) query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getShibListByIDPAuthType(String shibIDP){
		if (shibIDP == null || shibIDP.trim().length() == 0) return null;
		String queryString = "SELECT dObj FROM Domain dObj where dObj.shibMode = 1 AND dObj.shibIDP = :systemDomainGroup";
		Query query = this.buildListQuery(queryString, shibIDP, SystemDomain.SortBy.name, true);
		return (List<SystemDomain>) query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getSubListByGroup(String systemGroup, int start, int limit) {
		Query query = this.buildListQuery(this.getNamedListQuery(), systemGroup, start, limit);
		return (List<SystemDomain>) query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getSortedListByGroup(String systemGroup, SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(this.getBaseQueryString(), systemGroup, sortBy, isAscending);
		return (List<SystemDomain>) query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getSortedSubListByGroup(String systemGroup, int start, int limit, SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(this.getBaseQueryString(), systemGroup, start, limit, sortBy, isAscending);
		return (List<SystemDomain>) query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getListByCustomUrl(String url){
		String queryString = "SELECT dObj FROM Domain dObj where dObj.customUrl = :systemDomainGroup";
		Query query = this.buildListQuery(queryString, url, SystemDomain.SortBy.name, true);
		return (List<SystemDomain>) query.getResultList();
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return SystemDomain.class;
	}

	protected String getOwnerIdParamName() {
		return "systemDomainGroup";
	}
	
	@Override
	protected String getNamedListQuery() {
		return "Domain.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Domain.size";
	}

	@Override
	protected String getBaseQueryString() {
		return "SELECT dObj FROM Domain dObj where dObj.systemDomainGroup = :systemDomainGroup ";
	}

	@Override
	public List<? extends BaseAdminDomainObject> getSortedListBySystemDomainId(
			int systemDomainId, SortByType sortBy, boolean isAscending) {
		return null;	// not supported
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomain> getAll() {
		Query query = super.buildQuery("Domain.all.list");
		return (List<SystemDomain>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomain> getAll(int start, int limit) {
		Query query = super.buildListQuery(DOMAIN_ALL_LIST, start, limit);
		return (List<SystemDomain>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomain> getAll(SortByType sortBy, boolean isAscending) {
		Query query = super.buildListQuery(DOMAIN_ALL_LIST, sortBy, isAscending);
		return (List<SystemDomain>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<SystemDomain> getAll(int start, int limit, SortByType sortBy,
			boolean isAscending) {
		Query query = super.buildListQuery(DOMAIN_ALL_LIST, start, limit, sortBy, isAscending);
		return (List<SystemDomain>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<SystemDomain> getAllByLogin(boolean isShib) {
		Query query = super.buildListQuery(DOMAIN_ALL_LIST + " WHERE dObj.shibMode = :shibMode", SystemDomain.SortBy.name, true);
		query.setParameter("shibMode", isShib);
		return (List<SystemDomain>) query.getResultList();
	}


	public long getAllSize() {
		Query query = this.buildQuery("Domain.all.size");
		return (Long) query.getSingleResult();
	}
	
	private void clearDomains(SystemDomain obj) {
		if (obj.isShibMode()) {
			obj.getNetDomains().clear();
		}
	}
	
	protected Query buildListQuery(String queryName, String ownerId) {
		Query query = super.buildQuery(queryName);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}
	
	protected Query buildListQuery(String queryName, String ownerId, int start, int limit) {
		Query query = super.buildListQuery(queryName, start, limit);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}
	
	protected Query buildListQuery(String baseQueryString, String ownerId, SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(baseQueryString, sortBy, isAscending);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}

	protected Query buildListQuery(String baseQueryString, String ownerId, int start, int limit, SortByType sortBy, boolean isAscending) {
		Query query = this.buildListQuery(baseQueryString, start, limit, sortBy, isAscending);
		query.setParameter(this.getOwnerIdParamName(), ownerId);
		return query;
	}

	@Override
	public boolean isCustomUrlTaken(int id, String customUrl) {
		if (customUrl == null || customUrl.trim().length() == 0) return false;
		String queryString;
		if (id == 0){
			queryString = "SELECT dObj FROM Domain dObj where dObj.customUrl = :customUrl";
		} else{
			queryString = "SELECT dObj FROM Domain dObj where dobj.id != :id AND dObj.customUrl = :customUrl";
		}			
		Query query =  this.getEntityManager().createQuery(queryString);		
		if (id != 0){
			query.setParameter("id", id);
		}		
		query.setParameter("customUrl", customUrl);
		return (query.getResultList() != null && !query.getResultList().isEmpty());
	}

}
