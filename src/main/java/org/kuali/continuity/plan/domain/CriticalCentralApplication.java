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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.ext.StringValuedEnumType;

@Entity
@Table(name="it_central_applications")
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@NamedQuery(name="CriticalCentralApplication.list", 
		query="select dObj from CriticalCentralApplication dObj where plan.id = :ownerId")
@SuppressWarnings("serial")
public class CriticalCentralApplication extends BaseDomainObject 
	implements Serializable {
	
	private ContinuityPlan plan;
	private CentralApplication centralApplication;
	private CriticalityLevelEnum criticalityLevelEnum;
	private String comment;

	public CriticalCentralApplication() {
	}
	
	@Id
	@Column(name="RecordId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	@ManyToOne
	@JoinColumn(name="CentralApplicationID")
	@NotFound(action=NotFoundAction.IGNORE)
	public CentralApplication getCentralApplication() {
		return this.centralApplication;
	}

	public void setCentralApplication(CentralApplication centralApplication) {
		this.centralApplication = centralApplication;
	}

	@Column(name="CriticalityLevel")
	@Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.domain.CriticalityLevelEnum"
			)})
	@NotFound(action=NotFoundAction.IGNORE)
	public CriticalityLevelEnum getCriticalityLevelEnum() {
		return this.criticalityLevelEnum;
	}

	public void setCriticalityLevelEnum(CriticalityLevelEnum criticalityLevelEnum) {
		this.criticalityLevelEnum = criticalityLevelEnum;
	}

	@Column(name="Comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@PrePersist
	@PreUpdate
	protected void preUpdate() {
		if (this.criticalityLevelEnum == null)
			this.criticalityLevelEnum = CriticalityLevelEnum.LEVELN;
	}
	
}
