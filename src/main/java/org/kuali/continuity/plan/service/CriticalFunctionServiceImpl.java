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
package org.kuali.continuity.plan.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.dao.CriticalFunctionDAO;
import org.kuali.continuity.plan.domain.Consequence;
import org.kuali.continuity.plan.domain.CopingMethod;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.CriticalFunctionActionItem;
import org.kuali.continuity.plan.domain.CriticalFunctionDocument;
import org.kuali.continuity.plan.domain.Consequence.Type;

public class CriticalFunctionServiceImpl implements CriticalFunctionService {
	
	private CriticalFunctionDAO criticalFunctionDAO;
	private GenericAdminService genericAdminService;
	private ActionItemServiceFactory actionItemServiceFactory;
	private DocumentServiceFactory documentServiceFactory;

	public void createCriticalFunction(CriticalFunction criticalFunction) {
		this.criticalFunctionDAO.create(criticalFunction);
	}

	public void createDependency(int criticalFunctionId, Dependency dependency) {
		this.createUserDefinedDependency(dependency);
		this.criticalFunctionDAO.createDependency(criticalFunctionId, dependency);
	}

	// cascade delete mapping doesn't seem to work!
	@SuppressWarnings("unchecked")
	public void deleteCriticalFunction(int criticalFunctionId) {

		// delete action items
		ActionItemService aiService = this.actionItemServiceFactory.getActionItemService(CriticalFunctionActionItem.class);
		List<CriticalFunctionActionItem> ais = (List<CriticalFunctionActionItem>)
			aiService.getListByOwnerId(criticalFunctionId);
		if (ais != null) {
			for (CriticalFunctionActionItem ai : ais) {
				aiService.delete(ai.getId());
			}
		}
		
		// delete documents
		DocumentService docService = this.documentServiceFactory.getDocumentService(CriticalFunctionDocument.class);
		List<CriticalFunctionDocument> docs = (List<CriticalFunctionDocument>)
			docService.getDocumentListByOwnerId(criticalFunctionId);
		if (docs != null) {
			for (CriticalFunctionDocument doc : docs) {
				docService.deleteDocument(doc.getId());
			}
		}
		
		// delete critical function
		this.criticalFunctionDAO.delete(criticalFunctionId);
	}

	public void deleteDependency(int criticalFunctionId, Dependency dependency) {
		this.criticalFunctionDAO.deleteDependency(criticalFunctionId, dependency);
	}

	public Map<Type, Consequence> getConsequences(int criticalFunctionId) {
		return this.criticalFunctionDAO.getConsequences(criticalFunctionId);
	}

	public CopingMethod getCopingMethod(int criticalFunctionId) {
		return this.criticalFunctionDAO.getCopingMethod(criticalFunctionId);
	}

	public CriticalFunction getCriticalFunction(int criticalFunctionId) {
		return this.criticalFunctionDAO.getById(criticalFunctionId);
	}

	public List<CriticalFunction> getCriticalFunctionList(int planId) {
		return this.criticalFunctionDAO.getListByOwnerId(planId);
	}

	public List<CriticalFunction> getCriticalFunctionList(int planId,
			int start, int limit) {
		return this.criticalFunctionDAO.getSubListByOwnerId(planId, start, limit);
	}

	public List<CriticalFunction> getCriticalFunctionList(int planId,
			SortByType sortBy, boolean isAscending) {
		return this.criticalFunctionDAO.getSortedListByOwnerId(planId, sortBy, isAscending);
	}

	public List<CriticalFunction> getCriticalFunctionList(int planId,
			int start, int limit, SortByType sortBy, boolean isAscending) {
		return this.criticalFunctionDAO.getSortedSubListByOwnerId(planId, start, limit, sortBy, isAscending);
	}

	public Set<Dependency> getDependencies(int criticalFunctionId) {
		return this.criticalFunctionDAO.getDependencies(criticalFunctionId);
	}

	public List<CriticalFunction> getNonDeferrableCriticalFunctionSubList(int planId, int id) {
		return this.criticalFunctionDAO.getNonDeferrableSubListByOwnerId(planId, id);
	}

	public void updateConsequences(int criticalFunctionId,
			Map<Type, Consequence> consequences) {
		this.criticalFunctionDAO.updateConsequences(criticalFunctionId, consequences);
	}

	public void updateCopingMethod(int criticalFunctionId,
			CopingMethod copingMethod) {
		this.criticalFunctionDAO.updateCopingMethod(criticalFunctionId, copingMethod);
	}

	public void updateCriticalFunction(CriticalFunction criticalFunction) {
		this.criticalFunctionDAO.update(criticalFunction);
	}
	
	public void updateCriticalFunctions(List<CriticalFunction> criticalFunctions) {
		for (CriticalFunction criticalFunction : criticalFunctions) {
			this.updateCriticalFunction(criticalFunction);
		}
	}

	public void updateDependencies(int criticalFunctionId, Set<Dependency> dependencies) {
		this.criticalFunctionDAO.updateDependencies(criticalFunctionId, dependencies);
	}

	public void updateDescriptions(int criticalFunctionId,
			String criticalFunctionName, String description,
			String performingUnits, String responsiblePersons) {
		this.criticalFunctionDAO.updateDescriptions(criticalFunctionId, criticalFunctionName, description, performingUnits, responsiblePersons);
	}

	public void updatePeakPeriods(int criticalFunctionId,
			Set<Integer> peakPeriods, String peakExplanation) {
		this.criticalFunctionDAO.updatePeakPeriods(criticalFunctionId, peakPeriods, peakExplanation);
	}

	public CriticalFunctionDAO getCriticalFunctionDAO() {
		return this.criticalFunctionDAO;
	}

	public void setCriticalFunctionDAO(CriticalFunctionDAO criticalFunctionDAO) {
		this.criticalFunctionDAO = criticalFunctionDAO;
	}

	private void createUserDefinedDependency(Dependency dependency) {
		if (dependency == null || !dependency.isUserDefined()) return;
		this.genericAdminService.create(dependency);
	}

	@Override
	public CriticalFunction getInstructionCriticalFunction(int planId) {
		return this.criticalFunctionDAO.getInstructionCriticalFunctionByOwnerId(planId);
	}

	public GenericAdminService getGenericAdminService() {
		return this.genericAdminService;
	}

	public void setGenericAdminService(GenericAdminService genericAdminService) {
		this.genericAdminService = genericAdminService;
	}

	public ActionItemServiceFactory getActionItemServiceFactory() {
		return this.actionItemServiceFactory;
	}

	public void setActionItemServiceFactory(
			ActionItemServiceFactory actionItemServiceFactory) {
		this.actionItemServiceFactory = actionItemServiceFactory;
	}

	public DocumentServiceFactory getDocumentServiceFactory() {
		return this.documentServiceFactory;
	}

	public void setDocumentServiceFactory(
			DocumentServiceFactory documentServiceFactory) {
		this.documentServiceFactory = documentServiceFactory;
	}

}
