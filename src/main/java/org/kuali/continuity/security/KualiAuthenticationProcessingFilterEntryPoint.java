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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kuali.continuity.service.InCommonMetadataService;
import org.springframework.security.AuthenticationException;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilterEntryPoint;
import org.springframework.security.util.PortMapper;
import org.springframework.security.util.PortMapperImpl;
import org.springframework.security.util.PortResolver;
import org.springframework.security.util.PortResolverImpl;
import org.springframework.security.util.RedirectUrlBuilder;
import org.springframework.util.Assert;

public class KualiAuthenticationProcessingFilterEntryPoint extends AuthenticationProcessingFilterEntryPoint{
	private static final Log logger = LogFactory.getLog(KualiAuthenticationProcessingFilterEntryPoint.class);
	private PortResolver portResolver = new PortResolverImpl();
	private PortMapper portMapper = new PortMapperImpl();
	private boolean forceHttps = false;
	
	//private String loginFormUrl;
	private String defaultLoginFormUrl;
	private String logoutUrl;
	private InCommonMetadataService inCommonMetadataService;
	
	public InCommonMetadataService getInCommonMetadataService() {
		return inCommonMetadataService;
	}

	public void setInCommonMetadataService(
			InCommonMetadataService inCommonMetadataService) {
		this.inCommonMetadataService = inCommonMetadataService;
	}

	public String getLogoutUrl() {
		return logoutUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	public String getDefaultLoginFormUrl() {
		return defaultLoginFormUrl;
	}

	public void setDefaultLoginFormUrl(String defaultLoginFormUrl) {
		this.defaultLoginFormUrl = defaultLoginFormUrl;
	}

	public String getLoginFormUrl() {
		return super.getLoginFormUrl();
	}

	public void setLoginFormUrl(String loginFormUrl) {
		super.setLoginFormUrl(loginFormUrl);
	}

	public void afterPropertiesSet() throws Exception {
	        Assert.hasLength(super.getLoginFormUrl(), "loginFormUrl must be specified");
	        Assert.notNull(portMapper, "portMapper must be specified");
	        Assert.notNull(portResolver, "portResolver must be specified");
	        Assert.hasLength(getDefaultLoginFormUrl(), "defaultLoginFormUrl must be specified");
	        Assert.hasLength(getLogoutUrl(), "logoutUrl must be specified");
	}
    
	protected String buildRedirectUrlToLoginPage(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) {
		
		String loginForm;
		HttpSession session = request.getSession(false);	
    	
    	if(session.getAttribute(SecurityEnum.DIRECT_LOGIN_CUSTOM_URL.toString()) != null){
    		loginForm =  this.getLoginFormUrl() + session.getAttribute(SecurityEnum.DIRECT_LOGIN_CUSTOM_URL.toString());
 		} else if((session.getAttribute(SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString()) != null && session.getAttribute(SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString()) != null) && 
 				(!"".equals(session.getAttribute(SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString())) && !"".equals(session.getAttribute(SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString())))  ) {
 			return this.inCommonMetadataService.getLoginUrl((String)session.getAttribute(SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString()), (String)session.getAttribute(SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString()));
 		}
 			else{
 			//Direct login
 			String customUrl = SecurityUtil.getCookieValue(request.getCookies(), SecurityEnum.KUALI_DIRECTLOGIN_COOKIE_KEY.toString());
 			String shibbolethIdp = SecurityUtil.getCookieValue(request.getCookies(), SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString());
 			String shibbolethCustomUrl = SecurityUtil.getCookieValue(request.getCookies(), SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString());
 			//System.out.println("	Session timed out. customUrl is: " + customUrl + "  shibbolethIdp is: " + shibbolethIdp);
 			
 			if(customUrl == null && (shibbolethIdp == null || shibbolethCustomUrl==null)){
 				//Client cleared all cookies
 				loginForm = this.getLogoutUrl() + "?error=" + "3";
 			} else if (customUrl != null && (shibbolethIdp == null || shibbolethCustomUrl == null)){
 				//Direct Login
 				loginForm = this.getLoginFormUrl() + customUrl;
 			} else if (customUrl == null && (shibbolethIdp != null && shibbolethCustomUrl != null)){
 				//Shibboleth Login
 			    //Invalidate the session
 				//TODO: Session problem. Have to test this..!!!!!
 	            if (session != null) {
 	                session.invalidate();
 	            }
 				return this.inCommonMetadataService.getLoginUrl(shibbolethIdp, shibbolethCustomUrl);
 			} else{
 				loginForm = this.getLoginFormUrl();
 			}
 					
 		}   	          
        
        int serverPort = portResolver.getServerPort(request);
        String scheme = request.getScheme();

        RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();
        urlBuilder.setScheme(scheme);
        urlBuilder.setServerName(request.getServerName());
        urlBuilder.setPort(serverPort);
        urlBuilder.setContextPath(request.getContextPath());      
        urlBuilder.setPathInfo(loginForm);

        if (forceHttps && "http".equals(scheme)) {
            Integer httpsPort = portMapper.lookupHttpsPort(new Integer(serverPort));

            if (httpsPort != null) {
                // Overwrite scheme and port in the redirect URL
                urlBuilder.setScheme("https");
                urlBuilder.setPort(httpsPort.intValue());
            } else {
                logger.warn("Unable to redirect to HTTPS as no port mapping found for HTTP port " + serverPort);
            }
        }

        return urlBuilder.getUrl();
    }

}
