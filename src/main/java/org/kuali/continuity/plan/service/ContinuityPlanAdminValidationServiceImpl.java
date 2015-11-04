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

import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.plan.dao.ContinuityPlanAdminValidationDAO;
import org.kuali.continuity.plan.dao.ContinuityPlanAdminValidationDAOFactory;

public class ContinuityPlanAdminValidationServiceImpl implements
		ContinuityPlanAdminValidationService {
	
	private ContinuityPlanAdminValidationDAOFactory factory;

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getPlans(
			Class<? extends BaseAdminDomainObject> adminClass, int id) {
		ContinuityPlanAdminValidationDAO dao =
			this.factory.getContinuityPlanAdminValidationDAO(adminClass);
		return dao.getPlans(id);
	}

	public ContinuityPlanAdminValidationDAOFactory getFactory() {
		return this.factory;
	}

	public void setFactory(ContinuityPlanAdminValidationDAOFactory factory) {
		this.factory = factory;
	}

}
