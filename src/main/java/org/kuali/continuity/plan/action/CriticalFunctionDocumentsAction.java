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

import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.CriticalFunctionNavigation;
import org.kuali.continuity.plan.action.dto.DocumentDTO;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.Document;
import org.kuali.continuity.plan.service.CriticalFunctionService;
import org.kuali.continuity.plan.service.DocumentServiceFactory;

@SuppressWarnings("serial")
public class CriticalFunctionDocumentsAction extends DocumentsAction {

	// service
	private CriticalFunctionService criticalFunctionService;
	
	// bean
	private CriticalFunctionDTO criticalFunction = new CriticalFunctionDTO();
	
	// TODO: remove later
	private String cfNav = CriticalFunctionNavigation.DOCUMENTS.name();

	public CriticalFunctionDocumentsAction(DocumentServiceFactory documentServiceFactory) { 
		super(documentServiceFactory);
		this.setSubNav(CriticalFunctionNavigation.DOCUMENTS);
	}

	public CriticalFunctionDocumentsAction(CriticalFunctionService criticalFunctionService, 
			DocumentServiceFactory documentServiceFactory) {
		super(documentServiceFactory);
		this.criticalFunctionService = criticalFunctionService;
		this.setSubNav(CriticalFunctionNavigation.DOCUMENTS);
	}

	public CriticalFunctionDTO getCriticalFunction() {
		return this.criticalFunction;
	}

	public void setCriticalFunction(CriticalFunctionDTO criticalFunction) {
		this.criticalFunction = criticalFunction;
	}

	public String getCfNav() {
		return this.cfNav;
	}

	public void setCfNav(String cfNav) {
		this.cfNav = cfNav;
	}
	
	@Override
	public String list() throws Exception {
		this.setCriticalFunction();
		return super.list();
	}
	
	@Override
	public String get() throws Exception {
		this.setCriticalFunction();
		return super.get();
	}
	
	private void setCriticalFunction() {
		if (this.criticalFunction.name == null || this.criticalFunction.name.trim().length() == 0) {
			CriticalFunction svcCriticalFunction = this.criticalFunctionService.getCriticalFunction(this.criticalFunction.id);
			this.criticalFunction = new CriticalFunctionDTO(svcCriticalFunction);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected List<Document> getServiceDocuments() {
		return (List<Document>) this.getDocumentService().getDocumentListByOwnerId(this.criticalFunction.id);
	}
	
	public void prepare() throws Exception {
		super.prepare();
		DocumentDTO dto = new DocumentDTO();
		dto.type = DocumentDTO.Type.cf;
		this.setDocument(dto);
		this.setDocType(DocumentDTO.Type.cf.name());
	}
	
}
