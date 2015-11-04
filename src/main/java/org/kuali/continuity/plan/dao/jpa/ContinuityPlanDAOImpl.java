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
package org.kuali.continuity.plan.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.dao.jpa.BaseSortableDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.dao.ContinuityPlanDAO;
import org.kuali.continuity.plan.domain.BaseContinuityPlan;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.DepartmentInfo;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;

public class ContinuityPlanDAOImpl extends BaseSortableDomainObjectDAOImpl implements
		ContinuityPlanDAO {
	
	// plan	
	// TODO: cascade on contacts and user access?
	public void create(ContinuityPlan plan) {
		// create plan
		super.create(plan);
	}
	
	public void update(ContinuityPlan plan) {
		super.update(plan);
	}
	
	public void delete(int planId) {
		super.delete(planId);		
	}
	
	@Override
	public ContinuityPlan getById(int planId) {
		String queryString = "SELECT dObj FROM ContinuityPlan dObj " + 
			"JOIN FETCH dObj.systemDomain WHERE dObj.id = :planId";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("planId", planId);
		ContinuityPlan plan = null;
		try {
			plan = (ContinuityPlan) query.getSingleResult();
		} catch (NoResultException e) {
			// do nothing; 
		}
//		ContinuityPlan plan = (ContinuityPlan) super.getById(planId); 
		if (plan != null) {
			// force load system domain, contacts, and users
			plan.getSystemDomain().getId();
			Map<User, Boolean> contacts = plan.getContacts();
			if (contacts == null || contacts.isEmpty()) ; // do nothing
			Map<User, PlanAccessType> userAccessMap = plan.getUserAccessMap();
			if (userAccessMap == null || userAccessMap.isEmpty()) ; // do nothing
		}
		return plan;
	}
	
	public SimpleContinuityPlan getSimpleById(int planId) {
		String queryString = "SELECT dObj FROM SimpleContinuityPlan dObj " + 
			"JOIN FETCH dObj.systemDomain WHERE dObj.id = :planId";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("planId", planId);
		try {
			return (SimpleContinuityPlan) query.getSingleResult();
		} catch (NoResultException e) {
			return null; 
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getSimpleListByOwnerId(int systemDomainId) {
		String queryString = "select dObj.id, dObj.name from ContinuityPlan dObj where dObj.systemDomain.id = :ownerId";
		Query query = super.buildListQuery(queryString, systemDomainId, ContinuityPlan.SortBy.id, true);
		query.setParameter("ownerId", systemDomainId);
		return (List<Object[]>) query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ContinuityPlan> getListByOwnerId(int systemDomainId) {
		return (List<ContinuityPlan>) super.getListByOwnerId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<ContinuityPlan> getSubListByOwnerId(int systemDomainId, int start, int limit) {
		return (List<ContinuityPlan>) super.getSubListByOwnerId(systemDomainId, start, limit);
	}
	
	@SuppressWarnings("unchecked")
	public List<ContinuityPlan> getSortedListByOwnerId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<ContinuityPlan>) super.getSortedListByOwnerId(systemDomainId, sortBy, isAscending);
	}
	
	@SuppressWarnings("unchecked")
	public List<ContinuityPlan> getSortedSubListByOwnerId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<ContinuityPlan>) super.getSortedSubListByOwnerId(systemDomainId, start, limit, sortBy, isAscending);
	}
	
	@SuppressWarnings("unchecked")
	public List<SimpleContinuityPlan> getSimpleSortedListByOwnerId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		String queryString = "select dObj from SimpleContinuityPlan dObj where dObj.systemDomain.id = :ownerId";
		Query query = super.buildListQuery(queryString, systemDomainId, sortBy, isAscending);
		query.setParameter("ownerId", systemDomainId);
		return (List<SimpleContinuityPlan>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<BaseContinuityPlan> getBaseSortedListByOwnerId(int systemDomainId, PlanStatus planStatus, SortByType sortBy, boolean isAscending) {
		String queryString = "select dObj from LiteContinuityPlan dObj where dObj.systemDomain.id = :ownerId";
		if (planStatus != null)
			queryString += " and dObj.status.id = :planStatusId";
		Query query = super.buildListQuery(queryString, systemDomainId, sortBy, isAscending);
		query.setParameter("ownerId", systemDomainId);
		if (planStatus != null)
			query.setParameter("planStatusId", planStatus.getId());
		return (List<BaseContinuityPlan>) query.getResultList();
	}

	public long getListSize(int systemDomainId, Acronym acronym, String name, int planId) {
		String queryString = 
			"select count(dObj) from ContinuityPlan dObj " +
			 "where dObj.systemDomain.id = :ownerId " +
			   "and dObj.name = :name ";
		if (acronym != null && acronym.getId() != 0)
			queryString += "and dObj.acronym.id = :acronymId ";
		if (planId != 0)
			queryString += "and dObj.id != :planId ";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("ownerId", systemDomainId);
		query.setParameter("name", name);
		if (acronym != null && acronym.getId() != 0)
			query.setParameter("acronymId", acronym.getId());
		if (planId != 0)
			query.setParameter("planId", planId);
		return (Long) query.getSingleResult();
	}
	
	public long getListBySystemDomainIdSize(int systemDomainId) {
		String queryString = 
			"select count(dObj) from ContinuityPlan dObj " +
			 "where dObj.systemDomain.id = :ownerId ";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("ownerId", systemDomainId);
		return (Long) query.getSingleResult();
	}

	
	// status
	public void updateStatus(int planId, PlanStatus status) {
		ContinuityPlan plan = this.getById(planId);
		plan.setStatus(status);
		this.update(plan);
	}
	
	// organization data
	public void updateOrganizationData(int planId, 
			String planName, 
			MajorDivision majorDivision, 
			Acronym acronym, 
			User departmentHead,
			Map<User, Boolean> contacts) {
		ContinuityPlan plan = this.getById(planId);
		plan.setName(planName);
		plan.setMajorDivision(majorDivision);
		plan.setAcronym(acronym);
		plan.setDepartmentHead(departmentHead);
		plan.setContacts(contacts);
		this.update(plan);	
	}

	// contacts
	public void createContact(int planId, User user, boolean isPrimary) {
		ContinuityPlan plan = this.getById(planId);
		plan.addContact(user, isPrimary);
		this.update(plan);
	}
	
	public void updateContact(int planId, User user, boolean isPrimary) {
		// same as create
		this.createContact(planId, user, isPrimary);
	}
	
	public void deleteContact(int planId, User user) {
		ContinuityPlan plan = this.getById(planId);
		plan.removeContact(user);
		this.update(plan);
	}
	
	public Map<User, Boolean> getContacts(int planId) {
		return this.getById(planId).getContacts();
	}

	// authorized users
	public void createUserAccess(int planId, User user, PlanAccessType accessType) {
		ContinuityPlan plan = this.getById(planId);
		plan.addUserAccess(user, accessType);
		this.update(plan);
	}
	
	public void updateUserAccess(int planId, User user, PlanAccessType accessType) {
		// same as create
		this.createUserAccess(planId, user, accessType);
	}
	
	public void deleteUserAccess(int planId, User user) {
		ContinuityPlan plan = this.getById(planId);
		plan.removeUserAccess(user);
		this.update(plan);
	}
	
	public PlanAccessType getUserAccess(int planId, User user) {
		return this.getById(planId).getUserAccess(user);
	}
	
	public Map<User, PlanAccessType> getUserAccessMap(int planId) {
		ContinuityPlan plan = this.getById(planId);
		if (plan != null) return plan.getUserAccessMap();
		return null;		
	}
	
	// department info
	public DepartmentInfo getDepartmentInfoById(int planId) {
		ContinuityPlan plan = this.getById(planId);
		if (plan == null || plan.getDepartmentInfo() == null) return null;
		// eager load now
		plan.getDepartmentInfo().getBuildings().isEmpty();
		plan.getDepartmentInfo().getDepartmentTypes().isEmpty();
		return plan.getDepartmentInfo();
	}
	
	public void updateDepartmentInfo(int planId, DepartmentInfo departmentInfo) {
		ContinuityPlan plan = this.getById(planId);
		plan.setDepartmentInfo(departmentInfo);
		this.update(plan);
	}

	@Override
	protected String getBaseQueryString() {
		return "select dObj from ContinuityPlan dObj JOIN FETCH dObj.systemDomain where dObj.systemDomain.id = :ownerId";
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return ContinuityPlan.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "ContinuityPlan.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		// not used
		return "";
	}
	
}
