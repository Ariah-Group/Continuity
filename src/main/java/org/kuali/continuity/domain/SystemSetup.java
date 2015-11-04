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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="SystemSetup")
@NamedQuery(name="SystemSetup.all", query="select dObj from SystemSetup dObj")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="query.all.org.kuali.continuity.domain.SystemSetup")
@SuppressWarnings("serial")
public class SystemSetup extends BaseDomainObject {
	
	private String description;
	private String logo;
	private String phone;
	private String fax;
	private String email;
	private String status;
	private String version;
	private Date releaseDate;
	
	public SystemSetup() {
		super();
	}
	
	@Id
	@Column(name="SystemID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Override
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="SystemName")
	@Override
	public String getName() {
		return super.getName();
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLogo() {
		return this.logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFax() {
		return this.fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="SystemStatus")
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Date getReleaseDate() {
		return this.releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
}
