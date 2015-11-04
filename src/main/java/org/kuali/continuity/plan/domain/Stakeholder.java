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

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.domain.StakeholderType;

@Entity
@Table(name="key_stakeholders")
@NamedQuery(name="Stakeholder.list",
		query="select dObj from Stakeholder dObj where plan.id = :ownerId and disabled != 'Y'")
@SuppressWarnings("serial")
public class Stakeholder extends PlanPerson {
	
	private ContinuityPlan plan;
	private String department;
	private ContactInfo contactInfo = new ContactInfo();
	private String suppliedProductsOrServices;
	private String alternateVendors;
	private StakeholderType stakeholderType;
	private String comment;
	
	public Stakeholder() {
	}

	@Id
	@Column(name="ks_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		return super.getFirstName();
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return super.getLastName();
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	@Column(name="dept")
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Embedded
	public ContactInfo getContactInfo() {
		return this.contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	@Column(name="product_service")
	public String getSuppliedProductsOrServices() {
		return this.suppliedProductsOrServices;
	}

	public void setSuppliedProductsOrServices(String suppliedProductsOrServices) {
		this.suppliedProductsOrServices = suppliedProductsOrServices;
	}

	@Column(name="alternate_vendors")
	public String getAlternateVendors() {
		return this.alternateVendors;
	}

	public void setAlternateVendors(String alternateVendors) {
		this.alternateVendors = alternateVendors;
	}

	@ManyToOne
	@JoinColumn(name="stakeholder_type")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public StakeholderType getStakeholderType() {
		return this.stakeholderType;
	}

	public void setStakeholderType(StakeholderType stakeholderType) {
		this.stakeholderType = stakeholderType;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
