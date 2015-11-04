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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.kuali.continuity.domain.BuildingOwnership;
import org.kuali.continuity.domain.SortByType;

@Entity
@Table(name="Building")
@NamedQueries({
	@NamedQuery(name="Building.list",
		query="SELECT dObj FROM Building dObj WHERE dObj.systemDomainId = :systemDomainId"),
	@NamedQuery(name="Building.size",
		query="SELECT COUNT(dObj) FROM Building dObj WHERE dObj.systemDomainId = :systemDomainId")
})
@SuppressWarnings("serial")
public class Building extends BaseAdminDomainObject {
	
	private String caan;
	private String commonName;
	private String address;
	private BuildingOwnership ownership;
	
	public enum SortBy implements SortByType {
		id, commonName, caan, name, ownership;
		public String getSortByValue() {return this.name();}
	};
	
	public Building() {
		super();
	}
	
	public Building(Integer id) {
		super(id);
	}

	@Id
	@Column(name="BuildingID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="BuildingName")
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
	
	public String getCaan() {
		return this.caan;
	}

	public void setCaan(String caan) {
		this.caan = caan;
	}

	@Column(name="BuildingCommonName")
	public String getCommonName() {
		return this.commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	@Column(name="BuildingAddress")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@ManyToOne
	@JoinColumn(name="Ownership", nullable=false)
	@Fetch(FetchMode.SELECT)
	public BuildingOwnership getOwnership() {
		return this.ownership;
	}

	public void setOwnership(BuildingOwnership ownership) {
		this.ownership = ownership;
	}

}
