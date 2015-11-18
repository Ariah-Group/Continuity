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
package org.kuali.continuity.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.Authentication;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.ui.logout.LogoutHandler;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class KualiLogoutHandler implements LogoutHandler {
	/**
	 * Requires the request to be passed in.
	 * 
	 * @param request
	 *            from which to obtain a HTTP session (cannot be null)
	 * @param response
	 *            not used (can be <code>null</code>)
	 * @param authentication
	 *            not used (can be <code>null</code>)
	 */
	public void logout(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
		Assert.notNull(request, "HttpServletRequest required");
	    
		//Take this away since session needs to be valid for logout page. 
		//SecurityContextHolder aleady cleared the SecurityContext for the thread.
		
//		HttpSession session = request.getSession(false);
//		
//		if (session != null) {
//			session.invalidate();
//		}	
		
		SecurityContextHolder.clearContext();
		deleteCookie(request, response, SecurityEnum.KUALI_DIRECTLOGIN_COOKIE_KEY.toString(), "/continuity");
		deleteCookie(request, response, SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString(), "/continuity");		
	}
	
	/**
     * Sets a "cancel cookie" (with maxAge = 0) on the response to disable persistent logins.
     *
     * @param request
     * @param response
     */
    private void deleteCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String path) {     
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        cookie.setPath(StringUtils.hasLength(request.getContextPath()) ? request.getContextPath() : path);
        response.addCookie(cookie);  
        //System.out.println("		Cookie: " +  cookie.getName() +  " 	for  path: " + cookie.getPath() + "  value: " + cookie.getValue());
    }
    
}
