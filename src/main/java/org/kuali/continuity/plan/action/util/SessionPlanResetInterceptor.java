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
package org.kuali.continuity.plan.action.util;

import java.util.Map;

import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionValue;
import org.kuali.continuity.plan.action.SessionPlanRequired;
import org.kuali.continuity.plan.action.SessionRoleAction;
import org.kuali.continuity.plan.action.dto.PlanActionExecutionConstants;
import org.kuali.continuity.plan.action.dto.SessionPlanResetValue;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class SessionPlanResetInterceptor implements Interceptor {
	
	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		SessionValue value = (SessionValue) session.get(SessionKey.plan);
		if (!(actionInvocation.getAction() instanceof SessionRoleAction)) {
			if (value != null && value instanceof SessionPlanResetValue) {
				session.put(SessionKey.plan.name(), null);
			    return PlanActionExecutionConstants.LIST_PLAN;
			}
		} 
		if (actionInvocation.getAction() instanceof SessionPlanRequired) {
			if (value == null) {
				SessionPlanRequired req = (SessionPlanRequired) actionInvocation.getAction();
				Object nullObj = null;
				try {		// workaround for system domain document action
					nullObj = req.getSessionPlan(); 
				} catch (NullPointerException e) {
				} finally {
					if (nullObj == null) return PlanActionExecutionConstants.LIST_PLAN;
				}
			}
		}
	    return actionInvocation.invoke();
	}
}