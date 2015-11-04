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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.ext.StringValuedEnum;
import org.kuali.continuity.domain.ext.StringValuedEnumType;

@Entity
@Table(name="plan_reviewers")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="review_type", discriminatorType=DiscriminatorType.STRING, length=1)
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@SuppressWarnings("serial")
public class PlanReview extends BaseDomainObject {
	
	private String reviewerFirstName;
	private String reviewerLastName;
	private ReviewerType reviewerType;
	private Date reviewDate;
	private Integer createdByUserId;
	private Date createdDate;
	private ContinuityPlan plan;
	
	public PlanReview() {
		
	}

	@Id
	@Column(name="pr_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}

	@Transient
	public String getName() {
		return super.getName();
	}

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	@Column(name="first_name")
	public String getReviewerFirstName() {
		return this.reviewerFirstName;
	}

	public void setReviewerFirstName(String reviewerFirstName) {
		this.reviewerFirstName = reviewerFirstName;
	}

	@Column(name="last_name")
	public String getReviewerLastName() {
		return this.reviewerLastName;
	}

	public void setReviewerLastName(String reviewerLastName) {
		this.reviewerLastName = reviewerLastName;
	}

	@Column(name="head_or_designee")
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.PlanReview$ReviewerType"
			)}
	)
	public ReviewerType getReviewerType() {
		return this.reviewerType;
	}

	public void setReviewerType(ReviewerType reviewerType) {
		this.reviewerType = reviewerType;
	}

	@Column(name="review_date")
	@Temporal(TemporalType.DATE)
	public Date getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Column(name="enter_by")
	public Integer getCreatedByUserId() {
		return this.createdByUserId;
	}

	public void setCreatedByUserId(Integer createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	@Column(name="enter_date_time")
	@Temporal(TemporalType.DATE)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public enum ReviewerType implements StringValuedEnum {
		
		HEADOFUNIT ("H", "Head of Unit"), DESIGNEE ("D", "Designee");
		
		private final String refValue;
		private final String description;
		
		ReviewerType(final String refValue, final String description) {
			this.refValue = refValue;
			this.description = description;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public static ReviewerType getTypeEnum(String refValue) {
			for (ReviewerType type : ReviewerType.values()) {
				if (type.getValue().equals(refValue)) return type;
			}
			return null;
		}
	}

}
