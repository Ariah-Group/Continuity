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
package org.kuali.continuity.plan.action;

import java.util.List;

import org.kuali.continuity.action.dto.SaveTypeEnum;
import org.kuali.continuity.plan.action.dto.DocumentDTO;
import org.kuali.continuity.plan.action.dto.KeyResourcesNavigation;
import org.kuali.continuity.plan.action.dto.PlanNavigation;
import org.kuali.continuity.plan.domain.Document;
import org.kuali.continuity.plan.service.DocumentSearchService;
import org.kuali.continuity.plan.service.DocumentServiceFactory;

@SuppressWarnings("serial")
public class KeyResourcesDocumentsAction extends DocumentsAction 
	implements PlanNavigationSession {
	
	private DocumentSearchService documentSearchService;
	
	public KeyResourcesDocumentsAction(DocumentServiceFactory documentServiceFactory,
			DocumentSearchService documentSearchService) {
		super(documentServiceFactory);
		this.documentSearchService = documentSearchService;
		this.setSubNav(KeyResourcesNavigation.DOCUMENTS);
	}

	@Override
	public String list() throws Exception {
		if (this.getSaveTypeEnum() == SaveTypeEnum.SAVE)
			return super.list();
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	@Override
	public String get() throws Exception {
		if (this.getRowId() == 0) {
			this.setDocument(new DocumentDTO());
			this.getDocument().type = DocumentDTO.Type.cp;
			return SUCCESS;
		}
		return super.get();
	}
	
	@Override
	public String update() throws Exception {
		this.getDocument().type = DocumentDTO.Type.valueOf(this.getDocType());
		if (this.getDocument().id == 0) {
			return super.add();
		}
		return super.update();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected List<Document> getServiceDocuments() {
		return (List<Document>) this.documentSearchService
			.getDocumentListByPlanId(this.getSessionPlan().id);
	}

	public PlanNavigation getPlanNavigation() {
		return PlanNavigation.STEP5; 
	}
	
}
