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
package org.kuali.continuity.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="FunctionExample")
@NamedQueries({
	@NamedQuery(name="CriticalFunctionExample.list",
		query="SELECT dObj FROM CriticalFunctionExample dObj WHERE dObj.systemDomainId = :systemDomainId"),
	@NamedQuery(name="CriticalFunctionExample.size",
		query="SELECT COUNT(dObj) FROM CriticalFunctionExample dObj WHERE dObj.systemDomainId = :systemDomainId")
})
@SuppressWarnings("serial")
public class CriticalFunctionExample extends BaseAdminDomainObject {
	
	private String plans;
	
	public CriticalFunctionExample() {
		super();
	}
	
	public CriticalFunctionExample(int id) {
		super(id);
	}
	
	@Id
	@Column(name="FunctionExampleID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="InstitutionID")
	public Integer getSystemDomainId() {
		return super.getSystemDomainId();
	}
	
	public void setSystemDomainId(Integer systemDomainId) {
		super.setSystemDomainId(systemDomainId);
	}

	@Column(name="PlanList")
	public String getPlans() {
		return this.plans;
	}

	public void setPlans(String plans) {
		this.plans = plans;
	}

}
