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
import java.util.Set;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.dao.jpa.BaseSortableDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.dao.CriticalFunctionDAO;
import org.kuali.continuity.plan.domain.Consequence;
import org.kuali.continuity.plan.domain.CopingMethod;
import org.kuali.continuity.plan.domain.CriticalFunction;

public class CriticalFunctionDAOImpl extends BaseSortableDomainObjectDAOImpl implements
	CriticalFunctionDAO {

	// critical function
	public void create(CriticalFunction criticalFunction) {
		super.create(criticalFunction);
	}
	
	public void update(CriticalFunction criticalFunction) {
		super.update(criticalFunction);
	}
	
	@Override
	public void delete(int criticalFunctionId) {
		super.delete(criticalFunctionId);
	}

	@Override
	public CriticalFunction getById(int criticalFunctionId) {
		return (CriticalFunction) super.getById(criticalFunctionId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CriticalFunction> getListByOwnerId(int planId) {
		return (List<CriticalFunction>) super.getListByOwnerId(planId);		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CriticalFunction> getSubListByOwnerId(int planId, int start, int limit) {
		return (List<CriticalFunction>) super.getSubListByOwnerId(planId, start, limit);		
	}

	@SuppressWarnings("unchecked")
	public List<CriticalFunction> getSortedListByOwnerId(int planId, SortByType sortBy, boolean isAscending) {
		return (List<CriticalFunction>) super.getSortedListByOwnerId(planId, sortBy, isAscending);		
	}

	@SuppressWarnings("unchecked")
	public List<CriticalFunction> getSortedSubListByOwnerId(int planId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<CriticalFunction>) super.getSortedSubListByOwnerId(planId, start, limit, sortBy, isAscending);		
	}

	@SuppressWarnings("unchecked")
	public List<CriticalFunction> getNonDeferrableSubListByOwnerId(int planId,
			int id) {
		String queryString = this.getBaseQueryString() + " and dObj.id != :id and dObj.criticalityLevelEnum != :criticalityLevelEnum";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("ownerId", planId);
		query.setParameter("id", id);
		query.setParameter("criticalityLevelEnum", CriticalityLevelEnum.LEVEL4);
		return (List<CriticalFunction>) query.getResultList();
	}

	// description
	public void updateDescriptions(int criticalFunctionId,
			String criticalFunctionName,
			String description,
			String performingUnits,
			String responsiblePersons) {
		CriticalFunction cf = this.getById(criticalFunctionId);
		cf.setName(criticalFunctionName);
		cf.setDescription(description);
		cf.setPerformingUnits(performingUnits);
		cf.setResponsiblePersons(responsiblePersons);
		this.update(cf);
	}
	
	// peak periods
	public void updatePeakPeriods(int criticalFunctionId,
			Set<Integer> peakPeriods,
			String peakExplanation) {
		CriticalFunction cf = this.getById(criticalFunctionId);
		cf.setPeakMonths(peakPeriods);
		cf.setPeaksExplanation(peakExplanation);
		this.update(cf);
	}
	
	// dependencies
	public void createDependency(int criticalFunctionId, Dependency dependency) {
		CriticalFunction cf = this.getById(criticalFunctionId);
		cf.addDependency(dependency);
		this.update(cf);
	}

	public void deleteDependency(int criticalFunctionId, Dependency dependency) {
		CriticalFunction cf = this.getById(criticalFunctionId);
		cf.removeDependency(dependency);
		this.update(cf);
	}

	public void updateDependencies(int criticalFunctionId,  Set<Dependency> dependencies) {
		CriticalFunction cf = this.getById(criticalFunctionId);
		cf.setDependencies(dependencies);
		this.update(cf);
	}
	
	public Set<Dependency> getDependencies(int criticalFunctionId) {
		Set<Dependency> dependencies = this.getById(criticalFunctionId).getDependencies();
		dependencies.isEmpty();	// force loading
		return dependencies;
	}
	
	// consequences
	public void updateConsequences(int criticalFunctionId, Map<Consequence.Type, Consequence> consequences) {
		CriticalFunction cf = this.getById(criticalFunctionId);
		cf.setConsequences(consequences);
		this.update(cf);
	}

	public Map<Consequence.Type, Consequence> getConsequences(int criticalFunctionId) {
		return this.getById(criticalFunctionId).getConsequences();
	}

	// how to cope
	public void updateCopingMethod(int criticalFunctionId, CopingMethod copingMethod) {
		CriticalFunction cf = this.getById(criticalFunctionId);
		cf.setCopingMethod(copingMethod);
		this.update(cf);
	}

	public CopingMethod getCopingMethod(int criticalFunctionId) {
		return this.getById(criticalFunctionId).getCopingMethod();
	}

	public CriticalFunction getInstructionCriticalFunctionByOwnerId(int planId) {
		String queryString = this.getBaseQueryString() + " and dObj.name = :name";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("ownerId", planId);
		query.setParameter("name", CriticalFunction.CF_INSTRUCTION);
		try {
			return (CriticalFunction) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Override
	protected String getBaseQueryString() {
		return "select dObj from CriticalFunction dObj where plan.id = :ownerId";
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return CriticalFunction.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "CriticalFunction.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		// not used
		return "";
	}

}
