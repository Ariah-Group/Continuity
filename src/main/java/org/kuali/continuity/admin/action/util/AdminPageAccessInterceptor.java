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
package org.kuali.continuity.admin.action.util;

import java.util.Map;

import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.dto.SessionValue;
import org.kuali.continuity.admin.action.dto.AdminActionExecutionConstants;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class AdminPageAccessInterceptor  implements Interceptor {
	
	public void destroy() {

	}

	public void init() {

	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		SessionValue value = (SessionValue) session.get(SessionKey.user);
		if (value != null) {
			SessionUserDTO user = (SessionUserDTO) value;
			
			// system admin only
			if ("institutions".equals(actionInvocation.getProxy().getActionName()) && 
				!SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject().equals(new SecurityType(user.securityType.id))) {
				return AdminActionExecutionConstants.ADMIN_ACCESS_DENIED;
			}
			
			// admin only
			if (!SecurityTypeEnum.isAdmin(new SecurityType(user.securityType.id))) {
				return AdminActionExecutionConstants.ADMIN_ACCESS_DENIED;
			}
		}
	    return actionInvocation.invoke();
	}
}