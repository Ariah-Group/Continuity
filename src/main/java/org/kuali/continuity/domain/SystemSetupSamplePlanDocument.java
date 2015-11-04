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
package org.kuali.continuity.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="SystemSetupSamplePlanDocument")
@Table(name="SystemSetup")
@NamedQuery(name="SystemSetupSamplePlanDocument.all", query="select dObj from SystemSetupSamplePlanDocument dObj")
@AttributeOverrides({
	@AttributeOverride(name="id", column=@Column(name="SystemID")),
	@AttributeOverride(name="blobDocument", column=@Column(name="DefaultSamplePlan"))
})
public class SystemSetupSamplePlanDocument extends SamplePlanDocument {
	
}
