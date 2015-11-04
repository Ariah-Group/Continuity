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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.kuali.continuity.domain.SystemLogInfo;

@SuppressWarnings("serial")
public class SavePlanReviewAction extends BasePlanActionSupport  implements ServletRequestAware {

	private HttpServletRequest request;

	public String execute() {
		// system log info
		SystemLogInfo systemLogInfo = new SystemLogInfo();
		systemLogInfo.setUserId(this.getSessionUser().id);
		systemLogInfo.setSystemDomainId(this.getSessionUser().systemDomain.id);
		systemLogInfo.setHostIP(this.request.getRemoteAddr());
		systemLogInfo.setModule(this.request.getRequestURI());
		
		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
