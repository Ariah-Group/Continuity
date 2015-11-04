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

import org.kuali.continuity.admin.dao.GenericAdminDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.domain.UserDefinable;

@SuppressWarnings("unchecked")
// TODO: refactor to use strong type checking
public class GenericAdminDAOImpl<T extends BaseAdminDomainObject> extends BaseAdminDAOImpl implements GenericAdminDAO {
	
	private Class<T> adminClass;
	private boolean isAdminFiltered;
	
	public GenericAdminDAOImpl(Class<T> adminClass) {
		this.adminClass = adminClass;
	}

	@Override
	protected String getBaseQueryString() {
		return  
			"SELECT dObj FROM " + this.getClassSimpleName() + " dObj WHERE dObj.systemDomainId = :systemDomainId "
			+ this.getAdminDefinedFilter();
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return this.adminClass;
	}

	@Override
	protected String getNamedListQuery() {
		return this.getClassSimpleName() + this.getAppendString() + ".list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return this.getClassSimpleName() + this.getAppendString() + ".size";
	}
	
	private String getClassSimpleName() {
		String name = this.adminClass.getSimpleName();
		if (name.equals("SystemDomain")) return "Domain";
		return name;
	}
	
	private String getAppendString() {
		String name = this.adminClass.getSimpleName();
		if (name.equals("SystemDomain")) 
			return ".members";
		if (this.isAdminFiltered())
			return ".admin";
		return "";
	}
	
	private String getAdminDefinedFilter() {
		if (!this.isAdminFiltered()) return "";
		return " AND dObj.recordType = org.kuali.continuity.domain.RecordType.S";
	}

	public T getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		this.checkAdminOrderedType();
		String queryString = this.getBaseQueryString() + 
			" AND dObj.orderNo = :orderNo";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter(this.getOwnerIdParamName(), systemDomainId);
		query.setParameter("orderNo", orderNo);
		return (T) this.getSingleResult(query);
	}

	public T getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		this.checkAdminOrderedType();
		String queryString = this.getBaseQueryString() + 
			" AND dObj.orderNo = " +
			" (SELECT MAX(dObj2.orderNo) FROM " +
			this.getClassSimpleName() + " dObj2 " +
			" WHERE dObj.systemDomainId = dObj2.systemDomainId)";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter(this.getOwnerIdParamName(), systemDomainId);
		this.setQueryStartLimit(query, 0, 1);
		return (T) this.getSingleResult(query);
	}
	
	public List<T> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		this.checkAdminOrderedType();
		String queryString = this.getBaseQueryString() + 
			" AND dObj.orderNo >= :orderNo ORDER by dObj.orderNo";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter(this.getOwnerIdParamName(), systemDomainId);
		query.setParameter("orderNo", startOrderNo);
		return (List<T>) query.getResultList();
	}
	
	public boolean isAdminFiltered() {
		if (!UserDefinable.class.isAssignableFrom(this.adminClass))
			return false;
		else
			return this.isAdminFiltered;
	}

	public void setAdminFiltered(boolean isUserFiltered) {
		if (!UserDefinable.class.isAssignableFrom(this.adminClass))
			this.isAdminFiltered = false;
		else
			this.isAdminFiltered = isUserFiltered;
	}

	private void checkAdminOrderedType() {
		if (!BaseAdminOrderedDomainObject.class.isAssignableFrom(this.adminClass))
			throw new java.lang.IllegalArgumentException("Invalid Admin Ordered Class: " + this.adminClass.getName());
	}

}
