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

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.kuali.continuity.action.AddAction;
import org.kuali.continuity.action.DeleteAction;
import org.kuali.continuity.action.ReadListAction;
import org.kuali.continuity.action.ReadRowAction;
import org.kuali.continuity.action.SaveAction;
import org.kuali.continuity.action.UpdateAction;
import org.kuali.continuity.domain.BaseRefDomainObject;
import org.kuali.continuity.domain.DocumentType;
import org.kuali.continuity.plan.action.dto.DocumentDTO;
import org.kuali.continuity.plan.domain.Document;
import org.kuali.continuity.plan.service.DocumentService;
import org.kuali.continuity.plan.service.DocumentServiceFactory;

@SuppressWarnings("serial")
public abstract class DocumentsAction extends BasePlanFormAction {
	
	// services
	private DocumentServiceFactory documentServiceFactory;
	
	// beans
	private List<DocumentDTO> documents = new ArrayList<DocumentDTO>();
	private DocumentDTO document = new DocumentDTO();

	// file related fields
	private File uploadedDoc;
	private String uploadedDocFileName;
	private String uploadedDocContentType;
	
	// document type
	private String docType;

	public DocumentsAction(DocumentServiceFactory documentServiceFactory) {
		super();
		this.documentServiceFactory = documentServiceFactory;
	}

	protected DocumentServiceFactory getDocumentServiceFactory() {
		return this.documentServiceFactory;
	}

	protected void setDocumentServiceFactory(
			DocumentServiceFactory documentServiceFactory) {
		this.documentServiceFactory = documentServiceFactory;
	}

	public List<DocumentDTO> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<DocumentDTO> documents) {
		this.documents = documents;
	}
	
	public DocumentDTO getDocument() {
		return this.document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public File getUploadedDoc() {
		return this.uploadedDoc;
	}

	public void setUploadedDoc(File uploadedDoc) {
		this.uploadedDoc = uploadedDoc;
	}

	public String getUploadedDocFileName() {
		return this.uploadedDocFileName;
	}

	public void setUploadedDocFileName(String uploadedDocFileName) {
		this.uploadedDocFileName = uploadedDocFileName;
	}

	public String getUploadedDocContentType() {
		return this.uploadedDocContentType;
	}

	public void setUploadedDocContentType(String uploadedDocContentType) {
		this.uploadedDocContentType = uploadedDocContentType;
	}

	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	private void setDocumentFile(Document document) throws Exception {
		if (this.getUploadedDoc() != null) {
			File upFile = this.getUploadedDoc();
			document.setBlobDocument(Hibernate.createBlob(new FileInputStream(upFile), (int)upFile.length()));
			document.setFileName(this.getUploadedDocFileName());
		} else {
			document.setFileName("");
		}
	}

    protected abstract List<Document> getServiceDocuments();
	
	protected Class<? extends Document> getDocumentClass() {
		if (this.getDocType() == null) return null;
		DocumentDTO.Type type = DocumentDTO.Type.valueOf(this.getDocType());
		if (type != null) return type.getDocumentClass();
		return null;
	}
	
	protected DocumentService getDocumentService() {
		return this.getDocumentService(this.getDocumentClass());
	}
	
	protected DocumentService getDocumentService(Class<? extends Document> docClass) {
		return this.documentServiceFactory.getDocumentService(docClass);
	}

	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setAddAction(new DocumentAddAction());
		this.setUpdateAction(new DocumentUpdateAction());
		this.setDeleteAction(new DocumentDeleteAction());
		this.setReadRowAction(new DocumentReadRowAction());
		this.setReadListAction(new DocumentReadListAction());
	}

	public List<Class<? extends BaseRefDomainObject>> getRefClasses() {
		List<Class<? extends BaseRefDomainObject>> refClasses = new ArrayList<Class<? extends BaseRefDomainObject>>();
		refClasses.add(DocumentType.class);
		return refClasses;
	}
	
	// ----- actions ----- //
	
	public abstract class DocumentSaveAction implements SaveAction {
		public String execute() throws Exception {
			Boolean isValid = this.validate();
			if (isValid == null) return SUCCESS;
			if (!isValid) return INPUT;
			DocumentDTO dto = DocumentsAction.this.document;
			Document svcDocument = dto.getDomainObject();
			DocumentsAction.this.setDocumentFile(svcDocument);
			this.doExecute(svcDocument);
			return SUCCESS;
		}
		
		protected abstract void doExecute(Document document) throws Exception;

		private Boolean validate() {
			DocumentDTO dto = DocumentsAction.this.document;
	        if ((dto.name == null || dto.name.trim().length() == 0) &&
                (dto.description == null || dto.description.trim().length() == 0) &&
        		(dto.ownerDepartment == null || dto.ownerDepartment.trim().length() == 0) &&
				(dto.locationKept == null || dto.locationKept.trim().length() == 0) &&
				(dto.principalContact == null || dto.principalContact.trim().length() == 0) &&
				(dto.backupMeasures == null || dto.backupMeasures.trim().length() == 0) &&
				(dto.comment == null || dto.comment.trim().length() == 0) &&
				(dto.medium == null || dto.medium.id.trim().length() == 0 || dto.medium.id.equals("0")) &&
				 uploadedDoc == null)
	        		return null;
			
			if (dto.name == null || dto.name.trim().length() == 0)
				DocumentsAction.this.addFieldError("document.name", "Name is a required field!");
			
			return (!this.isWithErrors());
		}
		
		private boolean isWithErrors() {
			return (DocumentsAction.this.getFieldErrors().size() > 0 || 
					DocumentsAction.this.getActionErrors().size() > 0);
		}
	}
	
	public class DocumentAddAction extends DocumentSaveAction implements AddAction {
		protected void doExecute(Document document) throws Exception {
			DocumentsAction.this.getDocumentService().createDocument(document);
		}
	}

	public class DocumentUpdateAction extends DocumentSaveAction implements UpdateAction {
		protected void doExecute(Document document) throws Exception {
			DocumentsAction.this.getDocumentService().updateDocument(document);
		}
	}
	
	public class DocumentDeleteAction implements DeleteAction {
		public String execute() throws Exception {
			DocumentService service = DocumentsAction.this.getDocumentService();
			int id = DocumentsAction.this.getRowId();
			if (id != 0) service.deleteDocument(id);
			return SUCCESS;
		}
	}
	
	public class DocumentReadRowAction implements ReadRowAction {
		public String execute() throws Exception {
			DocumentService service = DocumentsAction.this.getDocumentService();
			int id = DocumentsAction.this.getRowId();
			Document svcDocument = service.getDocument(id);
			DocumentsAction.this.document = new DocumentDTO(svcDocument);
			return SUCCESS;
		}
	}
	
	public class DocumentReadListAction implements ReadListAction {
		public String execute() throws Exception {
			DocumentsAction.this.documents = new ArrayList<DocumentDTO>();
			List<Document> svcDocuments = DocumentsAction.this.getServiceDocuments();
			if (svcDocuments != null) {
				for (Document document : svcDocuments) {
					DocumentsAction.this.documents.add(new DocumentDTO(document));
				}
			}
			return SUCCESS;
		}
	}

}
