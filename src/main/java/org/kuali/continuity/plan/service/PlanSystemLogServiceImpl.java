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

import java.util.Calendar;

import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SystemLogEventTypeEnum;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.domain.SystemLogObjectTypeEnum;
import org.kuali.continuity.plan.dao.ContinuityPlanLastModifiedDAO;
import org.kuali.continuity.plan.domain.ContinuityPlan;

public class PlanSystemLogServiceImpl extends SystemLogServiceImpl implements PlanSystemLogService {
	
	private ContinuityPlanLastModifiedDAO continuityPlanLastModifiedDAO;
	
	public void logAddEvent(ContinuityPlan plan, SystemLogInfo logInfo) {
		this.logAddEvent(plan.getId(), SystemLogObjectTypeEnum.pl.getRefDomainObject(), plan.getAcronymPlusName(), logInfo);
	}
	
	public void logUpdateEvent(int planId, SystemLogInfo logInfo) {
		this.logUpdateEvent(planId, SystemLogObjectTypeEnum.pl.getRefDomainObject(), " ", logInfo);
	}
	
	public void logUpdateStatusEvent(int planId, SystemLogInfo logInfo) {
		this.log(planId, SystemLogObjectTypeEnum.pl.getRefDomainObject(), SystemLogEventTypeEnum.st.getRefDomainObject(), " ", logInfo);
	}
	
	public void logDeleteEvent(ContinuityPlan plan, SystemLogInfo logInfo) {
		this.logDeleteEvent(plan.getId(), SystemLogObjectTypeEnum.pl.getRefDomainObject(), plan.getAcronymPlusName(), logInfo);
	}
	
	public void logReadEvent(int planId, SystemLogInfo logInfo) {
		if (logInfo != null && logInfo.getSecurityType() != null && !SecurityTypeEnum.isAdmin(logInfo.getSecurityType())) {
			this.logReadEvent(planId, SystemLogObjectTypeEnum.pl.getRefDomainObject(), " ", logInfo);
		}
	}
	
	public void logLastModifiedEvent(int planId, SystemLogInfo logInfo) {
		if (logInfo != null && logInfo.getSecurityType() != null && !SecurityTypeEnum.isAdmin(logInfo.getSecurityType())) {
			this.continuityPlanLastModifiedDAO.updateLastModifiedDate(planId, Calendar.getInstance().getTime());
		}
	}

	public ContinuityPlanLastModifiedDAO getContinuityPlanLastModifiedDAO() {
		return this.continuityPlanLastModifiedDAO;
	}

	public void setContinuityPlanLastModifiedDAO(ContinuityPlanLastModifiedDAO continuityPlanLastModifiedDAO) {
		this.continuityPlanLastModifiedDAO = continuityPlanLastModifiedDAO;
	}

}
