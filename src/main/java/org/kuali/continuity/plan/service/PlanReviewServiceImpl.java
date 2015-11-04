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
package org.kuali.continuity.plan.service;

import java.util.List;

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.PlanStatusEnum;
import org.kuali.continuity.plan.dao.PlanReviewDAO;
import org.kuali.continuity.plan.dao.PlanReviewDAOFactory;
import org.kuali.continuity.plan.domain.AnnualPlanReview;
import org.kuali.continuity.plan.domain.CompletedPlanReview;
import org.kuali.continuity.plan.domain.PlanReview;

public class PlanReviewServiceImpl implements PlanReviewService {
	
	private PlanReviewDAOFactory planReviewDAOFactory;
	private Class<? extends PlanReview> planReviewClass;
	private ContinuityPlanService continuityPlanService;
	
	public PlanReviewServiceImpl(
			PlanReviewDAOFactory planReviewDAOFactory,
			ContinuityPlanService continuityPlanService,
			Class<? extends PlanReview> planReviewClass) {
		this.planReviewDAOFactory = planReviewDAOFactory;
		this.continuityPlanService = continuityPlanService;
		this.planReviewClass = planReviewClass;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public void create(PlanReview obj) {
		// create plan review
		this.getPlanReviewDAO().create(obj);
		
		// update status
		this.continuityPlanService.updateStatus(
			obj.getPlan().getId(), PlanStatusEnum.COMPLETE.getRefDomainObject());
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<? extends PlanReview> getListByOwnerId(int ownerId) {
		return this.getPlanReviewDAO().getListByOwnerId(ownerId);
	}
	
	@SuppressWarnings("unchecked")
	private PlanReviewDAO getPlanReviewDAO() {
		return this.planReviewDAOFactory.getPlanReviewDAO(this.planReviewClass);
	}

	@Override
	public void create(BaseDomainObject obj) {
		this.create((PlanReview)obj);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void delete(int id) {
		// get plan review
		PlanReview planReview = this.getById(id);
		int planId = planReview.getPlan().getId();
		
		// delete plan review
		this.getPlanReviewDAO().delete(id);

		// get current list
		PlanReviewDAO<CompletedPlanReview> cDAO = (PlanReviewDAO<CompletedPlanReview>)
		this.planReviewDAOFactory.getPlanReviewDAO(CompletedPlanReview.class);
		PlanReviewDAO<AnnualPlanReview> aDAO = (PlanReviewDAO<AnnualPlanReview>)
			this.planReviewDAOFactory.getPlanReviewDAO(AnnualPlanReview.class);
		List<CompletedPlanReview> cList = cDAO.getListByOwnerId(planId);
		List<AnnualPlanReview> aList = aDAO.getListByOwnerId(planId);

		// update status
		if ((cList == null || cList.isEmpty()) && (aList == null || aList.isEmpty())) {
			this.continuityPlanService.updateStatus(
				planId, PlanStatusEnum.IN_PROGRESS.getRefDomainObject());
		}
	}

	@Override
	public PlanReview getById(int id) {
		return this.getPlanReviewDAO().getById(id);
	}

	@Override
	public void update(BaseDomainObject obj) {
		; // not used
	}

}
