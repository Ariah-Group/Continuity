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
package org.kuali.continuity.action.util;

import java.util.Map;

import org.kuali.continuity.action.dto.SessionKey;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class AuthenticationInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
	}

	public String intercept( ActionInvocation actionInvocation ) throws Exception {

		/* Get the session map from the invocation context ( the ActionContext actually )
		 * and check for the user object.  Note, we are not going directly to the Servlet
		 * API's session object, even though this is most likely the map being returned 
		 * by this code; we need to keep our Struts 2 components cleanly separated from the 
		 * Servlet API so that our testing can be as simple as faking a map, rather than
		 * faking Servlet API objects.
		 */
		Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
		
		/* 
		 * If user doesn't exist return the LOGIN control string.  This will cause the 
		 * execution of this action to stop and the request will return the globally defined
		 * login result.
		 */
		if (session.get(SessionKey.user) == null) {
		    return Action.LOGIN;
		} 
		
		
	    /*
	     * We just return the control string from the invoke method.  If we wanted, we could hold the string for
	     * a few lines and do some post processing.  When we do return the string, execution climbs back out of the 
	     * recursive hole, through the higher up interceptors, and finally arrives back at the actionInvocation itself,
	     * who then fires the result based upon the result string returned.
	     */
	    return actionInvocation.invoke();

	}
	
}