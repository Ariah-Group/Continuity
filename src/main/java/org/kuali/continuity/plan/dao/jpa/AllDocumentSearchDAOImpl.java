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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.plan.dao.DocumentSearchDAO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.CriticalFunctionDocument;
import org.kuali.continuity.plan.domain.Document;
import org.kuali.continuity.plan.domain.KeyDocument;

public class AllDocumentSearchDAOImpl extends BaseDAOImpl implements DocumentSearchDAO {
	
	public List<Document> getListBySystemDomainId(int systemDomainId) {
		List<Document> docs = new ArrayList<Document>();
		List<? extends Document> cpDocs = (List<? extends Document>) this.getKeyResourcesListBySystemDomainId(systemDomainId);
		List<? extends Document> cfDocs = (List<? extends Document>) this.getCriticalFunctionListBySystemDomainId(systemDomainId);
		if (cpDocs != null) docs.addAll(cpDocs);
		if (cfDocs != null) docs.addAll(cfDocs);
		return docs;
	}
	
	public List<Document> getListByPlanId(int planId) {
		List<Document> docs = new ArrayList<Document>();
		List<? extends Document> cpDocs = (List<? extends Document>) this.getKeyResourcesListByPlanId(planId);
		List<? extends Document> cfDocs = (List<? extends Document>) this.getCriticalFunctionListByPlanId(planId);
		if (cpDocs != null) docs.addAll(cpDocs);
		if (cfDocs != null) docs.addAll(cfDocs);
		return docs;
	}
	
	// key resources
	@SuppressWarnings("unchecked")
	public List<KeyDocument> getKeyResourcesListByPlanId(int planId) {
		String queryString = "select dObj from KeyResourceDocument dObj where dObj.plan.id = :planId ";	
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("planId", new Integer(planId));
		return (List<KeyDocument>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<KeyDocument> getKeyResourcesListBySystemDomainId(int systemDomainId) {
		String queryString = "select dObj, dObj.plan.id, dObj.plan.name " +
			"from KeyResourceDocument dObj where dObj.plan.systemDomain.id = :systemDomainId ";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("systemDomainId", new Integer(systemDomainId));
		List<Object[]> results = query.getResultList();
		List<KeyDocument> documents = new ArrayList<KeyDocument>();
		for (Object[] objects : results) {
			KeyDocument keyDocument = (KeyDocument) objects[0];
			ContinuityPlan plan = new ContinuityPlan((Integer) objects[1]);
			plan.setName((String) objects[2]);
			keyDocument.setPlan(plan);
			documents.add(keyDocument);
		}
		return documents;
	}

	// critical function
	@SuppressWarnings("unchecked")
	public List<CriticalFunctionDocument> getCriticalFunctionListByPlanId(int planId) {
		String queryString = "select dObj from CriticalFunctionDocument dObj where dObj.criticalFunction.plan.id = :planId ";	
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("planId", new Integer(planId));
		return (List<CriticalFunctionDocument>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<CriticalFunctionDocument> getCriticalFunctionListBySystemDomainId(int systemDomainId) {
		String queryString = "select dObj, dObj.criticalFunction.id, dObj.criticalFunction.plan.id, dObj.criticalFunction.plan.name " +
			"from CriticalFunctionDocument dObj where dObj.criticalFunction.plan.systemDomain.id = :systemDomainId ";	
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("systemDomainId", new Integer(systemDomainId));
		List<Object[]> results = query.getResultList();
		List<CriticalFunctionDocument> documents = new ArrayList<CriticalFunctionDocument>();
		for (Object[] objects : results) {
			CriticalFunctionDocument cfDocument = (CriticalFunctionDocument) objects[0];
			CriticalFunction cf = new CriticalFunction((Integer) objects[1]);
			ContinuityPlan plan = new ContinuityPlan((Integer) objects[2]);
			plan.setName((String) objects[3]);
			cf.setPlan(plan);
			cfDocument.setCriticalFunction(cf);
			documents.add(cfDocument);
		}
		return documents;
	}

}
