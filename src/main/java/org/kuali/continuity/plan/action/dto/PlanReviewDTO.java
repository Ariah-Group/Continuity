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
package org.kuali.continuity.plan.action.dto;

import java.util.Date;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.AnnualPlanReview;
import org.kuali.continuity.plan.domain.CompletedPlanReview;
import org.kuali.continuity.plan.domain.PlanReview;

@SuppressWarnings("serial")
public class PlanReviewDTO  extends DomainObjectDTO implements
	DomainObjectValue, DTOValue {

	public String reviewerFirstName;
	public String reviewerLastName;
	public String reviewerType;
	public Date reviewDate;
	public Integer createdByUserId;
	public Date createdDate;
	public PlanDTO plan = new PlanDTO();
	public String reviewType;
	public long deltaReviewDays;
	
	public PlanReviewDTO() {
		super();
	}

	public PlanReviewDTO(BaseDomainObject obj) {
		super(obj);
	}

	public PlanReviewDTO(int id, String name) {
		super(id, name);
	}

	public PlanReviewDTO(int id) {
		super(id);
	}
	
	public PlanReviewDTO(PlanReview obj) {
		this.copyFromDomainObject(obj);
	}

	@Override
	public PlanReview getDomainObject() {
		PlanReview planReview = null;
		if ("A".equals(this.reviewType)) 
			planReview = new AnnualPlanReview();
		else 
			planReview = new CompletedPlanReview();

		planReview.setId(this.id == 0 ? null : this.id);
		planReview.setReviewerFirstName(this.reviewerFirstName);
		planReview.setReviewerLastName(this.reviewerLastName);
		planReview.setReviewDate(this.reviewDate);
		planReview.setCreatedByUserId(this.createdByUserId);
		planReview.setCreatedDate(this.createdDate);
		
		if ("H".equals(this.reviewerType))
			planReview.setReviewerType(PlanReview.ReviewerType.HEADOFUNIT);
		else
			planReview.setReviewerType(PlanReview.ReviewerType.DESIGNEE);
			
		if (this.plan != null && this.plan.id != 0)
			planReview.setPlan(plan.getDomainObject());
		
		return planReview;
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof PlanReview)) return;
		PlanReview obj = (PlanReview) copyObj;
		
		// set other fields
		this.reviewerFirstName = obj.getReviewerFirstName();
		this.reviewerLastName = obj.getReviewerLastName();
		this.reviewerType = 
			obj.getReviewerType() != null && obj.getReviewerType().equals(PlanReview.ReviewerType.HEADOFUNIT) ? "H" : "D";
		this.reviewDate = obj.getReviewDate();
		this.createdByUserId = obj.getCreatedByUserId();
		this.createdDate = obj.getCreatedDate() == null ? new Date() : obj.getCreatedDate();
		this.plan = new PlanDTO(obj.getPlan().getId());
		this.reviewType = obj instanceof CompletedPlanReview ? "C" : "A";
		this.deltaReviewDays = ((new Date()).getTime() - this.createdDate.getTime()) / 86400000;
	}

}
