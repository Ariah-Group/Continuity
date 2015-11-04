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
package org.kuali.continuity.plan.action.dto;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.DocumentType;
import org.kuali.continuity.plan.domain.CriticalFunctionDocument;
import org.kuali.continuity.plan.domain.Document;
import org.kuali.continuity.plan.domain.KeyDocument;

@SuppressWarnings("serial")
public class DocumentDTO extends DomainObjectDTO implements DomainObjectValue, DTOValue {

	public enum Type {
		
		cp(KeyDocument.class), 
		cf(CriticalFunctionDocument.class),
		all(Document.class);
		
		private Class<? extends Document> documentClass;
		
		Type(final Class<? extends Document> documentClass) {
			this.documentClass = documentClass;
		}
		
		public Class<? extends Document> getDocumentClass() {
			return this.documentClass;
		}
	};
	
	public String description;
	public String fileName;
	public RefDTO medium = new RefDTO();
	public Type type;
	public String ownerDepartment;
	public String locationKept;
	public String comment;
	public String backupMeasures;
	public String principalContact;
	public PlanDTO plan = new PlanDTO();
	public CriticalFunctionDTO criticalFunction = new CriticalFunctionDTO();
	
	public DocumentDTO() {
		super();
	}

	public DocumentDTO(BaseDomainObject obj) {
		super(obj);
	}

	public DocumentDTO(int id, String name) {
		super(id, name);
	}

	public DocumentDTO(int id) {
		super(id);
	}

	public DocumentDTO(Document document) {
		this.copyFromDomainObject(document);
	}
	
	public Document getDomainObject() {
		Document document = (this.type == DocumentDTO.Type.cp ? new KeyDocument() : new CriticalFunctionDocument());
		document.setId(this.id == 0 ? null : this.id);
		document.setName(this.name);
		document.setDescription(this.description);
		document.setFileName(this.fileName);
		document.setDocumentType(new DocumentType(this.medium.id));
		document.setOwnerDepartment(this.ownerDepartment);
		document.setLocationKept(this.locationKept);
		document.setComment(this.comment);
		document.setBackupMeasures(this.backupMeasures);
		document.setPrincipalContact(this.principalContact);
		if (this.plan != null && document instanceof KeyDocument)
			((KeyDocument)document).setPlan(this.plan.getDomainObject());
		if (this.criticalFunction != null && document instanceof CriticalFunctionDocument)
			((CriticalFunctionDocument)document).setCriticalFunction(this.criticalFunction.getDomainObject());
		return document;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof Document)) return;
		Document document = (Document) copyObj;
		
		// set other fields
		this.description = document.getDescription();
		this.fileName = document.getFileName();
		this.type = (document instanceof KeyDocument ? DocumentDTO.Type.cp : DocumentDTO.Type.cf);
		this.medium = new RefDTO(document.getDocumentType());
		this.ownerDepartment = document.getOwnerDepartment();
		this.locationKept = document.getLocationKept();
		this.comment = document.getComment();
		this.backupMeasures = document.getBackupMeasures();
		this.principalContact = document.getPrincipalContact();
		if (document instanceof CriticalFunctionDocument) {
			this.criticalFunction = new CriticalFunctionDTO(((CriticalFunctionDocument)document).getCriticalFunction());
		}
	}

}
