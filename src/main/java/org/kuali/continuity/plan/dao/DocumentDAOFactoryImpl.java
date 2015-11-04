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
package org.kuali.continuity.plan.dao;

import java.util.Map;

import org.kuali.continuity.plan.domain.Document;

public class DocumentDAOFactoryImpl implements DocumentDAOFactory {

	private Map<String, DocumentDAO> documentDAOMap;
	
	public DocumentDAOFactoryImpl() {
		
	}
	
	public Map<String, DocumentDAO> getDocumentDAOMap() {
		return this.documentDAOMap;
	}

	public void setDocumentDAOMap(Map<String, DocumentDAO> documentDAOMap) {
		this.documentDAOMap = documentDAOMap;
	}

	public DocumentDAO getDocumentDAO(Class<? extends Document> docClass) {
		if (docClass == null) return null;
		return this.documentDAOMap.get(docClass.getName());
	}

}
