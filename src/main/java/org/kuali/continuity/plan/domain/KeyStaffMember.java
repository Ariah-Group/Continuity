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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="key_staff_unit")
@NamedQuery(name="KeyStaffMember.list", 
		query="select dObj from KeyStaffMember dObj where plan.id = :ownerId and disabled != 'Y'")
@SuppressWarnings("serial")
public class KeyStaffMember extends PlanPerson {
	
	private ContinuityPlan plan;
	private String titleOrFunction;
	private String specialSkill;
	private String comment;
	private boolean isFirstSuccessor;
	private boolean isSecondSuccessor;
	private boolean isThirdSuccessor;
	private boolean isHoldingDelegation;
	
	public KeyStaffMember() {
	}
	
	@Id
	@Column(name="ksu_id")
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

	@Column(name="title_or_function")
	public String getTitleOrFunction() {
		return this.titleOrFunction;
	}

	public void setTitleOrFunction(String titleOrFunction) {
		this.titleOrFunction = titleOrFunction;
	}

	@Column(name="special_skill")
	public String getSpecialSkill() {
		return this.specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}

	@Column(name="comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name="first_successor")
	public boolean isFirstSuccessor() {
		return this.isFirstSuccessor;
	}

	public void setFirstSuccessor(boolean isFirstSuccessor) {
		this.isFirstSuccessor = isFirstSuccessor;
	}

	@Column(name="second_successor")
	public boolean isSecondSuccessor() {
		return this.isSecondSuccessor;
	}

	public void setSecondSuccessor(boolean isSecondSuccessor) {
		this.isSecondSuccessor = isSecondSuccessor;
	}

	@Column(name="third_successor")
	public boolean isThirdSuccessor() {
		return this.isThirdSuccessor;
	}

	public void setThirdSuccessor(boolean isThirdSuccessor) {
		this.isThirdSuccessor = isThirdSuccessor;
	}

	@Column(name="holds_formal_delegation")
	public boolean isHoldingDelegation() {
		return this.isHoldingDelegation;
	}

	public void setHoldingDelegation(boolean isHoldingDelegation) {
		this.isHoldingDelegation = isHoldingDelegation;
	}

}
