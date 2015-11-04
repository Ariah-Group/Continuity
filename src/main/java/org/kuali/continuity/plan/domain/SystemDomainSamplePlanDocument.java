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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.kuali.continuity.domain.SamplePlanDocument;
import org.kuali.continuity.domain.SystemSetupSamplePlanDocument;

@Entity(name="SystemDomainSamplePlanDocument")
@Table(name="SystemDomain")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="InstitutionID")),
	@AttributeOverride(name="blobDocument", column=@Column(name="SamplePlan"))
})
public class SystemDomainSamplePlanDocument extends SamplePlanDocument {
	
	private SystemSetupSamplePlanDocument defaultDocument;

	@Transient
	public SystemSetupSamplePlanDocument getDefaultDocument() {
		return this.defaultDocument;
	}
	
	public void setDefaultDocument(SystemSetupSamplePlanDocument defaultDocument) {
		this.defaultDocument = defaultDocument;
	}

}
