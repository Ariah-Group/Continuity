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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.dao.UserDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SortByType;

public class UserDAOImpl extends BaseAdminDAOImpl implements UserDAO, SimpleAdminDao {

	public void create(User dObj) {
		super.create(dObj);
	}
	
	public void update(User dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public User getById(int id) {
		return (User) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User getBySystemDomainIdAndEmail(int systemDomainId, String email) {
		String baseQuery = this.getBaseQueryString();
		baseQuery += " AND dObj.emailRegular = :email ORDER BY dObj.id";
		Query query = this.getEntityManager().createQuery(baseQuery);
		query.setParameter("systemDomainId", systemDomainId);
		query.setParameter("email", email);

		// todo: refactor/redesign - db should not allow email dups for a system domain 
		List<User> userList = (List<User>) query.getResultList();
		if (userList == null || userList.isEmpty()) return null;
		return userList.get(0);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User getBySystemDomainIdAndAuthId(int systemDomainId, String authId) {
		String baseQuery = this.getBaseQueryString();
		baseQuery += " AND dObj.authId = :authId ORDER BY dObj.id";
		Query query = this.getEntityManager().createQuery(baseQuery);
		query.setParameter("systemDomainId", systemDomainId);
		query.setParameter("authId", authId);
		
		// todo: refactor/redesign - db should not allow authid dups for a system domain 
		List<User> userList = (List<User>) query.getResultList();
		if (userList == null || userList.isEmpty()) return null;
		return userList.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getListBySystemDomainIdAndSecurityType(
			int systemDomainId, SecurityType securityType) {
		String baseQuery = this.getBaseQueryString();
		baseQuery += " AND dObj.securityType.id = :securityTypeId";
		Query query = this.getEntityManager().createQuery(baseQuery);
		query.setParameter("systemDomainId", systemDomainId);
		query.setParameter("securityTypeId", securityType.getId());
		return (List<User>) query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getSortedListBySystemDomainIdAndSecurityType(
			int systemDomainId, SecurityType securityType, SortByType sortBy,
			boolean isAscending) {
		if (securityType == null) return null;
		
		// if sys admin
		if (SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject().equals(securityType))
			return this.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
		
		// get list
		List<SecurityType> securityTypeList = SecurityTypeEnum.getSecurityTypeFilteredList(securityType);
		if (securityTypeList == null || securityTypeList.size() == 0) return null;
		List<String> securityTypeIds = new ArrayList<String>();
		for (SecurityType type : securityTypeList) {
			securityTypeIds.add(type.getId());
		}
		
		// create query
		String baseQuery = this.getBaseQueryString(sortBy);
		baseQuery += " AND dObj.securityType.id IN (:securityTypeList)";
		Query query = this.getEntityManager().createQuery(baseQuery);
		query.setParameter("systemDomainId", systemDomainId);
		query.setParameter("securityTypeList", securityTypeIds);
		return (List<User>) query.getResultList();
	}
	
	@Override
	public User getBySystemDomainIdAndName(int id, String name) {
		// not used
		return null;
	}
	
	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getListBySystemDomainId(int systemDomainId) {
		return (List<User>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<User>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	public List<User> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return this.getSortedSubListBySystemDomainId(systemDomainId, 0, 0, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		String baseQueryString = this.getBaseQueryString(sortBy);
		Query query = this.buildListQuery(baseQueryString, sortBy, isAscending);
		query.setParameter("systemDomainId", systemDomainId);
		if (limit != 0) {
			query.setFirstResult(start);
			query.setMaxResults(limit);
		}
		return (List<User>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> getListBySystemDomainIdAndNames(int systemDomainId, String firstName,
			String lastName) {
		String baseQuery = this.getBaseQueryString();
		baseQuery += " AND dObj.firstName like :firstName AND dObj.lastName like :lastName and dObj.accessStatus.id = '1'";
		if (firstName == null) firstName = ""; if (lastName == null) lastName = "";
		String firstNameLike = firstName.replace('*', '%') + "%";
		String lastNameLike = lastName.replace('*', '%') + "%";
		Query query = this.getEntityManager().createQuery(baseQuery);
		query.setParameter("systemDomainId", systemDomainId);
		query.setParameter("firstName", firstNameLike);
		query.setParameter("lastName", lastNameLike);
		return (List<User>) query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<User> getUnapprovedListBySystemDomainId(int systemDomainId) {
		Query query = this.buildListQuery("User.unapproved.list", systemDomainId);
		return (List<User>) query.getResultList();
	}
	
	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return User.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "User.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "User.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	// TODO: refactor - SystemDomainUser?
	protected String getBaseQueryString() {
		return 
            "SELECT dObj FROM SystemDomainUser dObj WHERE dObj.systemDomainId = :systemDomainId ";
	}
	
	protected String getBaseQueryString(SortByType sortBy) {
		String baseQueryString = this.getBaseQueryString();
		if (sortBy != null && sortBy.getSortByValue().equals(User.SortBy.securityType.getSortByValue()))
			baseQueryString += " AND dObj.securityType.lookupName = 'SysAdminRoleSet'";
		else if (sortBy != null && sortBy.getSortByValue().equals(User.SortBy.accessStatus.getSortByValue()))
			baseQueryString += " AND dObj.accessStatus.lookupName = 'AccessStatus'";
		return baseQueryString;
	}

}
