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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.plan.action.dto.DocumentDTO;
import org.kuali.continuity.plan.action.dto.SessionPlanDTO;
import org.kuali.continuity.plan.action.dto.SystemDomainDocumentDTO;
import org.kuali.continuity.plan.action.util.DocumentDTOUtil;
import org.kuali.continuity.plan.domain.Document;
import org.kuali.continuity.plan.service.DocumentSearchService;
import org.kuali.continuity.plan.service.DocumentServiceFactory;

@SuppressWarnings("serial")
public class SystemDomainDocumentsAction extends DocumentsAction {
	
	private DocumentSearchService documentSearchService;
	
	public SystemDomainDocumentsAction(DocumentServiceFactory documentServiceFactory,
			DocumentSearchService documentSearchService) {
		super(documentServiceFactory);
		this.documentSearchService = documentSearchService;
	}

	@Override
	public String list() throws Exception {
		// init
		this.setDocuments(new ArrayList<DocumentDTO>());
		List<Document> svcDocuments = this.getServiceDocuments();
		if (svcDocuments != null) {
			for (Document document : svcDocuments) {
				this.getDocuments().add(new SystemDomainDocumentDTO(document));
			}
		}
		Collections.sort(this.getDocuments(), new DocumentDTOUtil());
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Document> getServiceDocuments() {
		return (List<Document>) this.documentSearchService.getDocumentListBySystemDomainId(this.getSessionSystemDomain().id);
	}

	public void prepare() throws Exception {
		super.prepare();
		this.removeFromSession(SessionKey.plan);
	}
	
	@Override
	public SessionPlanDTO getSessionPlan() {
		// this action does not require a session plan
		// but this will just trick the interceptor to let this pass 
		return new SessionPlanDTO();
		
	}

}
