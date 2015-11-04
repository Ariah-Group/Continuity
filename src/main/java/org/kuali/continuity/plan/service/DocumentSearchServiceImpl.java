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

import org.kuali.continuity.plan.dao.DocumentSearchDAO;
import org.kuali.continuity.plan.domain.Document;

public class DocumentSearchServiceImpl implements DocumentSearchService {
	
	private DocumentSearchDAO documentSearchDAO;
	
	public DocumentSearchServiceImpl() {
		
	}
	
	public DocumentSearchServiceImpl(DocumentSearchDAO documentSearchDAO) {
		this.setDocumentSearchDAO(documentSearchDAO);
	}

	public List<? extends Document> getDocumentListByPlanId(int planId) {
		return this.getDocumentSearchDAO().getListByPlanId(planId);
	}

	public List<? extends Document> getDocumentListBySystemDomainId(int systemDomainId) {
		return this.getDocumentSearchDAO().getListBySystemDomainId(systemDomainId);
	}

	public DocumentSearchDAO getDocumentSearchDAO() {
		return this.documentSearchDAO;
	}

	public void setDocumentSearchDAO(DocumentSearchDAO documentSearchDAO) {
		this.documentSearchDAO = documentSearchDAO;
	}

}
