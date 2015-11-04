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

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.springframework.security.ui.logout.LogoutFilter;
import org.springframework.security.ui.logout.LogoutHandler;
import org.springframework.util.StringUtils;

public class KualiLogoutProcessingFilter extends LogoutFilter {
	 //~ Constructors ===================================================================================================
	public KualiLogoutProcessingFilter(String logoutSuccessUrl, LogoutHandler[] handlers) {
       super(logoutSuccessUrl,  handlers);
    }
    
    /**
     * Returns the target URL to redirect to after logout.
     * <p>
     * By default it will check for a <tt>logoutSuccessUrl</tt> parameter in
     * the request and use this. If that isn't present it will use the configured <tt>logoutSuccessUrl</tt>. If this
     * hasn't been set it will check the Referer header and use the URL from there.
     *
     */
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
        String targetUrl = request.getParameter("logoutSuccessUrl");       
        
        if(!StringUtils.hasLength(targetUrl)) {
            targetUrl = getLogoutSuccessUrl();
        }

        if (!StringUtils.hasLength(targetUrl)) {
            targetUrl = request.getHeader("Referer");
        }        

        if (!StringUtils.hasLength(targetUrl)) {
            targetUrl = "/";
        }                          
        
        return targetUrl;
    }
    
}
