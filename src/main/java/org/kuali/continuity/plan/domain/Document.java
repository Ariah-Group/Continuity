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
package org.kuali.continuity.plan.domain;

import java.sql.Blob;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.domain.DocumentType;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@SuppressWarnings("serial")
public abstract class Document extends BaseDomainObject implements BinaryDocument {

	private String description;
	private String ownerDepartment;
	private String fileName;
	private String locationKept;
	private String comment;
	private String backupMeasures;
	private String principalContact;
	private DocumentType documentType;
	private Blob blobDocument;
	
	public Document() {
	}
	
	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="owner_department")
	public String getOwnerDepartment() {
		return this.ownerDepartment;
	}

	public void setOwnerDepartment(String ownerDepartment) {
		this.ownerDepartment = ownerDepartment;
	}

	@Column(name="original_file_name")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name="location_kept")
	public String getLocationKept() {
		return this.locationKept;
	}

	public void setLocationKept(String locationKept) {
		this.locationKept = locationKept;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name="backup_measures")
	public String getBackupMeasures() {
		return this.backupMeasures;
	}

	public void setBackupMeasures(String backupMeasures) {
		this.backupMeasures = backupMeasures;
	}

	@Column(name="contacts")
	public String getPrincipalContact() {
		return this.principalContact;
	}

	public void setPrincipalContact(String principalContact) {
		this.principalContact = principalContact;
	}

	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(name="uploaded_file")	
	public Blob getBlobDocument() {
		return this.blobDocument;
	}

	public void setBlobDocument(Blob blobDocument) {
		this.blobDocument = blobDocument;
	}

	@ManyToOne
	@JoinColumn(name="mediumID")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public DocumentType getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
}
