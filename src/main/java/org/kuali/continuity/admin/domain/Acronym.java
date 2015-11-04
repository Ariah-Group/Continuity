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
import javax.persistence.Transient;

import org.kuali.continuity.domain.SortByType;


@Entity
@Table(name="Acronym")
@NamedQueries({
	@NamedQuery(name="Acronym.list",
		query="SELECT dObj FROM Acronym dObj WHERE dObj.systemDomainId = :systemDomainId"),
	@NamedQuery(name="Acronym.size",
		query="SELECT COUNT(dObj) FROM Acronym dObj WHERE dObj.systemDomainId = :systemDomainId")
})
@SuppressWarnings("serial")
public class Acronym extends BaseAdminDomainObject {
	
	private String fullName;
		
	public enum SortBy implements SortByType {
		id, name, fullName;
		public String getSortByValue() {return this.name();}
	};
	
	public Acronym() {
		super();
	}
	
	public Acronym(Integer id) {
		super(id);
	}
	
	public Acronym(Integer id, String name) {
		super(id);
		this.setAcronym(name);
	}
	
	@Id
	@Column(name="AcronymID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="Acronym")
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
	
	@Transient
	public String getAcronym() {
		return this.getName();
	}

	public void setAcronym(String acronym) {
		this.setName(acronym);
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
