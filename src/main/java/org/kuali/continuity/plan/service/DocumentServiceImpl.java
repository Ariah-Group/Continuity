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

import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.plan.dao.DocumentDAO;
import org.kuali.continuity.plan.dao.DocumentDAOFactory;
import org.kuali.continuity.plan.domain.Document;

public class DocumentServiceImpl implements DocumentService {
	
	private DocumentDAOFactory documentDAOFactory;
	private Class<? extends Document> documentClass;
	
	public DocumentServiceImpl(DocumentDAOFactory documentDAOFactory, Class<? extends Document> documentClass) {
		this.documentDAOFactory = documentDAOFactory;
		this.documentClass = documentClass;
	}

	public void createDocument(Document obj) {
		if (this.documentClass == null || this.documentClass == Document.class) 
			throw new UnsupportedOperationException();
		this.getDocumentDAO().create(obj);
	}

	public void deleteDocument(int id) {
		if (this.documentClass == null || this.documentClass == Document.class) 
			throw new UnsupportedOperationException();
		this.getDocumentDAO().delete(id);
	}

	public Document getDocument(int id) {
		if (this.documentClass == null || this.documentClass == Document.class) 
			throw new UnsupportedOperationException();
		return this.getDocumentDAO().getById(id);
	}

	public List<? extends Document> getDocumentListByOwnerId(int ownerId) {
		return this.getDocumentDAO().getListByOwnerId(ownerId);
	}

	public void updateDocument(Document obj) {
		if (this.documentClass == null || this.documentClass == Document.class) 
			throw new UnsupportedOperationException();
		
		String fileName = this.getDocument(obj.getId()).getFileName();
		if (fileName != null && !"".equals(fileName) && (obj.getFileName() == null || "".equals(obj.getFileName()))){
			obj.setFileName(fileName);
			obj.setBlobDocument( this.getDocument(obj.getId()).getBlobDocument());
		}
		
		this.deleteDocument(obj.getId());
		obj.setId(null);
		this.createDocument(obj);
// 		cannot update blob
//		this.getDocumentDAO().update(obj);
	}
	
	public void updateDocument(BinaryDocument obj) {
		this.updateDocument((Document)obj);
	}
	
	private DocumentDAO getDocumentDAO() {
		return this.documentDAOFactory.getDocumentDAO(this.documentClass);
	}
	
}
