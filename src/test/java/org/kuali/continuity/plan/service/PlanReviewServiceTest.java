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

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.plan.domain.AnnualPlanReview;
import org.kuali.continuity.plan.domain.CompletedPlanReview;
import org.kuali.continuity.plan.domain.PlanReview;

public class PlanReviewServiceTest extends DomainObjectTest {

	private PlanReviewServiceFactory planReviewServiceFactory;
	
	public void setPlanReviewService(PlanReviewServiceFactory planReviewServiceFactory) {
		this.planReviewServiceFactory = planReviewServiceFactory;
	}

	public void testInjection() {
		String message = "Factory is: " + this.planReviewServiceFactory.toString();
		System.out.println(message);
		assertNotNull(this.planReviewServiceFactory);
	}
	
	@SuppressWarnings("unchecked")
	public void testGetPlanReviews() throws Exception {
		// completed reviews
		List<PlanReview> completedReviews = 
			(List<PlanReview>)this.planReviewServiceFactory.getPlanReviewService(CompletedPlanReview.class).getListByOwnerId(PlanTestData.known_plan);
		completedReviews.isEmpty();
		
		// annual reviews
		List<PlanReview> annualReviews = 
			(List<PlanReview>)this.planReviewServiceFactory.getPlanReviewService(AnnualPlanReview.class).getListByOwnerId(PlanTestData.known_plan);
		annualReviews.isEmpty();
	}

}
