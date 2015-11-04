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
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.security.SecurityUtil;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class AdminCsrfTokenInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// generate token
		String token = this.generateCsrfToken();
		
		// set in session
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		session.put(SessionKey.adminCsrfToken.name(), token);
		
		// set cookie
		SecurityUtil.setCookie(
			new String[] {token}, 
			7200,	// 2 seconds 
			SessionKey.adminCsrfToken.name(), 
			ServletActionContext.getRequest(), 
			ServletActionContext.getResponse());
		
		// return
		return actionInvocation.invoke();
	}
	
    private String generateCsrfToken() {
        long seed = System.currentTimeMillis();
        Random r = new Random();
        r.setSeed(seed);
        return Long.toString(seed) + Long.toString(Math.abs(r.nextLong()));
    }

}
