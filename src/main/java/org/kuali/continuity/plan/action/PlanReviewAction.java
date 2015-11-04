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
package org.kuali.continuity.plan.action;

import java.util.Date;
import java.util.List;

import org.kuali.continuity.action.BaseDeleteAction;
import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.PlanReviewDTO;
import org.kuali.continuity.plan.domain.AnnualPlanReview;
import org.kuali.continuity.plan.domain.CompletedPlanReview;
import org.kuali.continuity.plan.domain.PlanReview;
import org.kuali.continuity.plan.service.PlanReviewService;
import org.kuali.continuity.plan.service.PlanReviewServiceFactory;

@SuppressWarnings("serial")
public class PlanReviewAction extends BasePlanFormAction {
	
	private PlanReviewServiceFactory planReviewServiceFactory;
	
	public PlanReviewAction(
			PlanReviewServiceFactory planReviewServiceFactory,
			Class<? extends PlanReview> planReviewClass) {
		this.planReviewServiceFactory = planReviewServiceFactory;
		PlanReviewService planReviewService = this.planReviewServiceFactory.getPlanReviewService(planReviewClass);
		this.setService(planReviewService);
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setDeleteAction(new PlanReviewDeleteAction());
		this.setValidateAction(new PlanReviewValidateAction());
		this.list();
	}

	@Override
	public String add() throws Exception {
		PlanReviewDTO dto = (PlanReviewDTO) this.getDto();
		dto.createdByUserId = this.getSessionUser().id;
		dto.createdDate = new Date();
		return super.add();
	}
	
	public class PlanReviewDeleteAction extends BaseDeleteAction {
		
		@SuppressWarnings("unchecked")
		protected String delete(int rowId) throws Exception {
			// get plan review
			PlanReview planReview = (PlanReview) this.getService().getById(rowId);
			int planId = planReview.getPlan().getId();
			
			// for completed review
			if (planReview instanceof CompletedPlanReview) {
				if (this.getService().getListByOwnerId(planId).size() == 1) {
					PlanReviewService annualPlanReviewService = 
						PlanReviewAction.this.planReviewServiceFactory.getPlanReviewService(AnnualPlanReview.class);
					List<AnnualPlanReview> annualPlanReviews = (List<AnnualPlanReview>) annualPlanReviewService.getListByOwnerId(planId);
					if (annualPlanReviews != null && !annualPlanReviews.isEmpty()) {
						String errorMessage = 
							"This name cannot be deleted.  " +
							"Deletion of this name would change this plan's status from \"complete\" to \"in-progress\", " +
							"which is not allowable since this plan has already had an annual review.  " +
							"Once a plan has had an annual review, the plan remains permanently in the \"annual review queue\" " +
							"which triggers reminder emails to the head of unit to review & update the plan.  " +
							"Once in that queue, the plan's status is permanently listed as \"complete\".";
						PlanReviewAction.this.addActionError(errorMessage);
						return INPUT;
					}
				}
			}

			// call delete
			return super.delete(rowId);
		}
		
	}
	
	public class PlanReviewValidateAction extends BaseValidateAction {

		@Override
		@SuppressWarnings("unchecked")
		public Boolean validate(DomainObjectDTO dto) throws Exception {
			PlanReviewDTO planReviewDTO = (PlanReviewDTO) dto;
			if ("A".equals(planReviewDTO.reviewType)) {
				PlanReviewService planReviewService =
					PlanReviewAction.this.planReviewServiceFactory.getPlanReviewService(CompletedPlanReview.class);
				List<CompletedPlanReview> cReviews = 
					(List<CompletedPlanReview>) planReviewService.getListByOwnerId(planReviewDTO.plan.id);
				if (cReviews == null || cReviews.isEmpty()) {
					this.addActionError(
						"This Annual Review cannot be marked complete because the plan itself has not been marked complete. " +
						"Plans must be completed before they enter the Annual Review cycle. If your plan is complete, " +
						"please signify that on the <a href='planReviewComplete'>Mark Your Plan Complete</a> screen.  " +
						"After doing that, you will be able to mark your Annual Review complete.");
					return false;
				}
			}
			return true;
		}
		
	}

}
