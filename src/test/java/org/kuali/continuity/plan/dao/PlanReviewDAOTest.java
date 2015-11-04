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
package org.kuali.continuity.plan.dao;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.plan.domain.AnnualPlanReview;
import org.kuali.continuity.plan.domain.CompletedPlanReview;

public class PlanReviewDAOTest extends BasePlanTest {
	
	private PlanReviewDAOFactory daoFactory;

	public void setDaoFactory(PlanReviewDAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public void testInjection() throws Exception {
		String message = "DAO Factory is: " + this.daoFactory.toString();
		System.out.println(message);
		assertNotNull(this.daoFactory);
	}

	@SuppressWarnings("unchecked")
	public void testGetPlanReviews() {
		// completed plan review
		PlanReviewDAO completedDAO = this.daoFactory.getPlanReviewDAO(CompletedPlanReview.class);
		completedDAO.getListByOwnerId(PlanTestData.known_plan);
		
		// annual plan review
		PlanReviewDAO annualDAO = this.daoFactory.getPlanReviewDAO(AnnualPlanReview.class);
		annualDAO.getListByOwnerId(PlanTestData.known_plan);
	}

}
