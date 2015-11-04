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
package org.kuali.continuity.plan.dao.jpa;

import org.kuali.continuity.dao.jpa.BaseDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.PlanReviewDAO;
import org.kuali.continuity.plan.domain.PlanReview;

@SuppressWarnings("unchecked")
public class PlanReviewDAOImpl<T extends PlanReview> extends BaseDomainObjectDAOImpl implements PlanReviewDAO {

	private Class<T> planReviewClass;
	
	public PlanReviewDAOImpl(Class<T> planReviewClass) {
		this.planReviewClass = planReviewClass;
	}

	@Override
	public void create(PlanReview obj) {
		super.create(obj);
	}
	
	@Override
	public PlanReview getById(int id) {
		return (PlanReview) super.getById(id);
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return this.planReviewClass;
	}

	@Override
	protected String getNamedListQuery() {
		return this.planReviewClass.getSimpleName() + ".list";
	}

}
