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

import org.kuali.continuity.domain.SortByType;

@Entity
@Table(name="InstructionalDepartment")
@NamedQueries({
	@NamedQuery(name="InstructionalDepartment.list",
		query="SELECT dObj FROM InstructionalDepartment dObj WHERE dObj.systemDomainId = :systemDomainId"),
	@NamedQuery(name="InstructionalDepartment.size",
		query="SELECT COUNT(dObj) FROM InstructionalDepartment dObj WHERE dObj.systemDomainId = :systemDomainId")
})
@SuppressWarnings("serial")
public class InstructionalDepartment extends BaseAdminDomainObject {
	
	public enum SortBy implements SortByType {
		id, name;
		public String getSortByValue() {return this.name();}
	};
	
	public InstructionalDepartment() {
		super();
	}
	
	public InstructionalDepartment(Integer id) {
		super(id);
	}

	@Id
	@Column(name="InstructionalDepartmentID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="DepartmentName")
	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}
	
	@Column(name="InstitutionID")
	public Integer getSystemDomainId() {
		return super.getSystemDomainId();
	}
	
	public void setSystemDomainId(Integer systemDomainId) {
		super.setSystemDomainId(systemDomainId);
	}
	
}
