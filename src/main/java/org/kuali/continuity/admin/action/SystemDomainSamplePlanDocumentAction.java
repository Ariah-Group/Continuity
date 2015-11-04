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
package org.kuali.continuity.admin.action;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Hibernate;
import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.domain.SamplePlanDocument;
import org.kuali.continuity.domain.SystemSetupSamplePlanDocument;
import org.kuali.continuity.plan.domain.SystemDomainSamplePlanDocument;
import org.kuali.continuity.plan.service.BinaryDocumentService;
import org.kuali.continuity.plan.service.BinaryDocumentServiceFactory;

@SuppressWarnings("serial")
public class SystemDomainSamplePlanDocumentAction extends BaseActionSupport {
	
	private BinaryDocumentServiceFactory binaryDocumentServiceFactory;
	
	private boolean isDefault;
	private boolean isMySamplePlan;
	
	// file related fields
	private File uploadedDoc;
	private String uploadedDocFileName;
	private String uploadedDocContentType;
	
	// document type
	private String docType;

	public SystemDomainSamplePlanDocumentAction(
			BinaryDocumentServiceFactory binaryDocumentServiceFactory) {
		this.binaryDocumentServiceFactory = binaryDocumentServiceFactory;
	}
	
	public String get() throws Exception {
		BinaryDocumentService binaryDocumentService =
			this.getBinaryDocumentService();
		BinaryDocument document = binaryDocumentService.getDocument(this.getSessionSystemDomain().id);
		this.isMySamplePlan = (document != null && document.getBlobDocument() != null);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		BinaryDocumentService binaryDocumentService =
			this.getBinaryDocumentService();
		SamplePlanDocument document = this.isDefault ? new SystemSetupSamplePlanDocument() : new SystemDomainSamplePlanDocument();
		if (document instanceof SystemDomainSamplePlanDocument)
			document.setId(this.getSessionSystemDomain().id);
		if (!this.isDefault && !this.isMySamplePlan) {
			; // do nothing
		} else {
			if (this.getUploadedDoc() == null) return SUCCESS;
			File upFile = this.getUploadedDoc();
			document.setBlobDocument(Hibernate.createBlob(new FileInputStream(upFile), (int)upFile.length()));
		}
		binaryDocumentService.updateDocument(document);
		return SUCCESS;
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

	public boolean isDefault() {
		return this.isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

	public boolean isMySamplePlan() {
		return this.isMySamplePlan;
	}

	public void setMySamplePlan(boolean isMySamplePlan) {
		this.isMySamplePlan = isMySamplePlan;
	}

	@Override
	public void prepare() throws Exception {
		// do nothing?
	}
	
	private BinaryDocumentService getBinaryDocumentService() {
		return
			this.binaryDocumentServiceFactory.getBinaryDocumentService(SamplePlanDocument.class);
	}

}
