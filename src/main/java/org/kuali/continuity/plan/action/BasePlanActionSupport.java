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

import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.plan.action.dto.PageAccessControlDTO;
import org.kuali.continuity.plan.action.dto.SessionPlanDTO;

@SuppressWarnings("serial")
public abstract class BasePlanActionSupport extends BaseActionSupport {

	public SessionPlanDTO getSessionPlan() {
		return (SessionPlanDTO) this.getSessionValue(SessionKey.plan);
	}

	public PageAccessControlDTO getSessionPageAccessControl() {
		return (PageAccessControlDTO) this.getSessionValue(SessionKey.planAccessControl);
	}

	public void prepare() throws Exception {
		if (this instanceof PlanNavigationSession)
			this.putInSession(SessionKey.mainNav, ((PlanNavigationSession)this).getPlanNavigation());
	}
	
}
