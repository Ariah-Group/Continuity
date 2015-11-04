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

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.CriticalFunctionDocument;
import org.kuali.continuity.plan.domain.Document;
import org.kuali.continuity.plan.domain.KeyDocument;

@SuppressWarnings("serial")
public class SystemDomainDocumentDTO extends DocumentDTO {

	public SystemDomainDocumentDTO() {
		super();
	}

	public SystemDomainDocumentDTO(BaseDomainObject obj) {
		super(obj);
	}

	public SystemDomainDocumentDTO(Document document) {
		this.copyFromDomainObject(document);
	}

	public SystemDomainDocumentDTO(int id, String name) {
		super(id, name);
	}

	public SystemDomainDocumentDTO(int id) {
		super(id);
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		if (copyObj == null) return;
		super.copyFromDomainObject(copyObj);
		if (!(copyObj instanceof Document)) return;
		Document document = (Document) copyObj;
		this.plan = new PlanDTO((document instanceof KeyDocument ? 
				((KeyDocument) document).getPlan() : 
				((CriticalFunctionDocument) document).getCriticalFunction().getPlan())); 
	}
}
