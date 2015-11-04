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

import org.kuali.continuity.plan.dao.PlanReviewDAOFactory;
import org.kuali.continuity.plan.domain.PlanReview;

public class PlanReviewServiceFactoryImpl implements PlanReviewServiceFactory {
	
	private PlanReviewDAOFactory planReviewDAOFactory;
	private ContinuityPlanService continuityPlanService;
	
	public PlanReviewService getPlanReviewService(
			Class<? extends PlanReview> planReviewClass) {
		return new PlanReviewServiceImpl(
			this.planReviewDAOFactory, this.continuityPlanService, planReviewClass);
	}

	public PlanReviewDAOFactory getPlanReviewDAOFactory() {
		return this.planReviewDAOFactory;
	}

	public void setPlanReviewDAOFactory(PlanReviewDAOFactory planReviewDAOFactory) {
		this.planReviewDAOFactory = planReviewDAOFactory;
	}

	public ContinuityPlanService getContinuityPlanService() {
		return this.continuityPlanService;
	}

	public void setContinuityPlanService(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
	}

}
