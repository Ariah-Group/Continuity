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

import java.io.IOException;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.admin.action.ShowParameterAction;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.admin.service.UserLoginService;
import org.kuali.continuity.admin.service.UserService;
import org.kuali.continuity.domain.AccessStatus;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.util.DataUtil;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.context.SecurityContext;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.context.SecurityContextImpl;
import org.springframework.security.event.authentication.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.ui.webapp.AuthenticationProcessingFilter;
import org.springframework.security.util.PortResolver;
import org.springframework.security.util.PortResolverImpl;
import org.springframework.security.util.RedirectUrlBuilder;
import org.springframework.security.util.TextUtils;
import org.springframework.util.Assert;

public class KualiAuthenticationProcessingFilter extends AuthenticationProcessingFilter{
	private final Logger logger = Logger.getLogger(ShowParameterAction.class);
	
	//If this request is shibleth, set it as true. Otherwise, false. False as default.
	boolean isShibleth = false;
	private String shibUniqueId = null;
	private PortResolver portResolver = new PortResolverImpl();
	private ShiblethAuthenticationManager shiblethAuthenticationManager;
	private JdbcAuthenticationManager jdbcAuthenticationManager;
	private static String UC_LOCATION = "systemDomainId";
	
	// direct login token
	private static String CSRF_TOKEN_NAME = "struts.token.name";
	private static String CSRF_TOKEN_VALUE = "struts.token";
	
	@SuppressWarnings("unchecked")
	private Class contextClass = SecurityContextImpl.class;
	private UserLoginService userLoginService;
	private SystemDomainService systemDomainService;
	private UserService userService;	
	private String logoutUrl;
	private String entryUrl;
	private String entryShibUrl;
	private Integer cookieLife;
	private String defaultShibbolethUniqueId;
	
	public String getDefaultShibbolethUniqueId() {
		return defaultShibbolethUniqueId;
	}


	public void setDefaultShibbolethUniqueId(String defaultShibbolethUniqueId) {
		this.defaultShibbolethUniqueId = defaultShibbolethUniqueId;
	}


	public void setCookieLife(Integer cookieLife) {
		this.cookieLife = cookieLife;
	}

	
	public void setEntryUrl(String entryUrl) {
		this.entryUrl = entryUrl;
	}

	public void setEntryShibUrl(String entryShibUrl) {
		this.entryShibUrl = entryShibUrl;
	}

	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
	}

	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setSystemDomainService(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	
	public void setShiblethAuthenticationManager(ShiblethAuthenticationManager shiblethAuthenticationManager){
		this.shiblethAuthenticationManager = shiblethAuthenticationManager;
	}
	
	
	public void setJdbcAuthenticationManager(JdbcAuthenticationManager jdbcAuthenticationManager){
		this.jdbcAuthenticationManager = jdbcAuthenticationManager;
	}
	
	private void setIsShibleth(boolean isShibleth){
		this.isShibleth = isShibleth;
	}
	
	//Custom afterPropertiesSet method to include redirect url for shibleth login and direct login
	public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        Assert.notNull(shiblethAuthenticationManager, "shiblethAuthenticationManager must be specified");
        Assert.notNull(userLoginService, "userLoginService must be specified");
        Assert.notNull(userService, "userService must be specified");
        Assert.notNull(systemDomainService, "systemDomainService must be specified");
        Assert.notNull(cookieLife, "shibCookieLife must be specified");
        Assert.hasLength(defaultShibbolethUniqueId, "Default value of shibboleth unique identifier can not be empty or null.");   
    }
	
	@SuppressWarnings("unchecked")
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            Authentication authResult) throws IOException, ServletException {
        if (logger.isDebugEnabled()) {
            logger.debug("Authentication success: " + authResult.toString());
        }

        SecurityContextHolder.getContext().setAuthentication(authResult);

        if (logger.isDebugEnabled()) {
            logger.debug("Updated SecurityContextHolder to contain the following Authentication: '" + authResult + "'");
        }              
        
        String targetUrl = determineTargetUrl(request);
        
        if (logger.isDebugEnabled()) {
            logger.debug("Redirecting to target URL from HTTP Session (or default): " + targetUrl);
        }

        onSuccessfulAuthentication(request, response, authResult);
        
        this.getRememberMeServices().loginSuccess(request, response, authResult);

        // Fire event
        if (this.eventPublisher != null) {
            eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(authResult, this.getClass()));
        }
       

        if(!this.isShibleth){        
        	String locationId = obtainLocationId(request);
         	
         	SystemDomain domain = systemDomainService.getById(Integer.parseInt(locationId));       	         	         	
        	logger.warn("###### " + " Direct Login Successful, redirect !!" + "	######");
        	//Have to clear the shibleth cookie if the client has any
        	SecurityUtil.setCookie(new String[]{"Shibboleth"}, 0, SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString(), request, response);
        	SecurityUtil.setCookie(new String[]{"Shibboleth"}, 0, SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString(), request, response); 	
        	//Set Direct Login cookie              	      	      	       	
        	SecurityUtil.setCookie(new String[]{DataUtil.nonulls(domain.getCustomUrl(), " ")}, cookieLife, SecurityEnum.KUALI_DIRECTLOGIN_COOKIE_KEY.toString(), request, response);       	
        	request.getSession(false).setAttribute(SecurityEnum.DIRECT_LOGIN_CUSTOM_URL.toString(), domain.getCustomUrl());
        	request.getSession(false).removeAttribute(SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString());
        	request.getSession(false).removeAttribute(SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString());
        	 
        	sendRedirect(request, response,  buildRedirectUrlToLoginPage(entryUrl, authResult.getPrincipal().toString(), locationId, request));
        } else{
        	// Hard coded - must be changed to get User 
        	
        	/*
        	 * Read the Header variables and determine who the userlso get the Institution from headers
        	 * Then look up Institution + (AuthId) in UserSecurity table.
        	 * Then mark this in SystemDomainDTO and SystemUserDTO
        	 */              	
        		             	
        	//Transform shibleth headers to a header map
        	Map<String, String> headers = transformRequestHeaders2Map(request);
        	//Feed in stub data
        	//pushStubData(headers);   	
        	
        	List<SystemDomain> systemDomainList = systemDomainService.getShibListByIDPAuthType(headers.get(ShiblethHeader.ShibIdentityProvider.attribute()));     	     	             	   		
    		
        	//Multiple institutions share same IDP
        	String customUrl = null;
        	if (systemDomainList.size() > 1){       		    		
        		String[] values = request.getParameterValues(SecurityEnum.sdname.toString());       		
        		      	 		
        		if(values != null){
        			String value = DataUtil.safeTrimmingString(DataUtil.nonulls(values[0]));
        			if(value != null && !"".equals(value)){
        				customUrl = SecurityUtil.decode(value);
        			}       			        			
        		}
        		
        		if(customUrl != null && !"".equals(customUrl)){       	
        			systemDomainList = systemDomainService.getListByCustomUrl(DataUtil.nonulls(customUrl));      			
        		}      		    
        		       		
        	} else if (systemDomainList.size() == 1){
        		customUrl = systemDomainList.get(0).getCustomUrl();
        	}
        	       	
        	SecurityErrorCode validation = validateShibbolethRequest(systemDomainList, headers, customUrl);
        	if(validation != null){
        		logger.warn(validation); 
        		//Redirect to logout page. This needs to be fixed.
        		String url = "";
        		if (validation.equals(SecurityErrorCode.SHIBBOLETH_LOGIN_WITHOUT_CUSTOM_URL)){
        			url =  buildShiblethUrlToLogoutWithIdp(logoutUrl, validation.getId(), SecurityUtil.encode(headers.get(ShiblethHeader.ShibIdentityProvider.attribute())),  request);
        		} else{
        			url = buildShiblethUrlToLogoutPage(logoutUrl, validation.getId(), request);
        		}    		
        		sendRedirect(request, response, url);
        	}else{
        		//Passed validation handle shibboleth session key and cookies
        		SystemDomain domain = systemDomainList.get(0);
        		SecurityUtil.setCookie(new String[]{domain.getShibIDP()}, cookieLife, SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString(),request, response);
        		SecurityUtil.setCookie(new String[]{DataUtil.nonulls(domain.getCustomUrl(), " ")}, cookieLife, SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString(),request, response);        		      		
            	SecurityUtil.setCookie(new String[]{DataUtil.nonulls(domain.getCustomUrl(), " ")}, 0, SecurityEnum.KUALI_DIRECTLOGIN_COOKIE_KEY.toString(), request, response);        
            	request.getSession(false).setAttribute(SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString(), domain.getShibIDP());
            	request.getSession(false).setAttribute(SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString(), domain.getCustomUrl());
            	request.getSession(false).removeAttribute(SecurityEnum.DIRECT_LOGIN_CUSTOM_URL.toString().toString());
            	//Setup session
            	request.getSession().setAttribute(SessionKey.loginSystemDomain.toString(), new SessionSystemDomainDTO(domain));          	
            	
        		final String authId = headers.get(shibUniqueId);        	
        		final Integer systemDomainId = domain.getSystemDomainId();
        	       		
        		//Check if the user exists or not. If it doesn't exist, create one.       	
        		User user;
        		if((user = userLoginService.getBySystemDomainIdAndAuthId(domain.getId(), headers.get(shibUniqueId))) != null){      		
        			//TODO: Have to implement here for multiple domains 
        			//Update user info based on shibboleth attributes
        			user = compareReplace(headers, user, shibUniqueId, false);
        		    userService.update(user, null);
        		} else if((user = userService.getBySystemDomainIdAndEmail(systemDomainId, headers.get(ShiblethHeader.mail.attribute()))) != null){       			   
        			user = compareReplace(headers, user, shibUniqueId, true);
        		    userService.update(user, null);      			
        		}  else{
        			//Email and AuthId lookup failed, so create brand new user.
        			User newUser = new User();
        			newUser.setAuthId(authId);
        			newUser.setSystemDomainId(systemDomainId);
        			SecurityType securityType = new SecurityType();
        			securityType.setId("9");
        			newUser.setSecurityType(securityType);
        			newUser.setFirstName(headers.get(ShiblethHeader.givenName.attribute()));
        			newUser.setLastName(headers.get(ShiblethHeader.sn.attribute()));
        			newUser.setEmailRegular(headers.get(ShiblethHeader.mail.attribute()));
        			newUser.setWorkPhone(headers.get(ShiblethHeader.telephoneNumber.attribute()));
        			newUser.setModApproved(true);
        			newUser.setTitle(headers.get(ShiblethHeader.title.attribute()));
        			AccessStatus accessStatus = new AccessStatus("1");     		
        			newUser.setAccessStatus(accessStatus);
        			newUser.setDateCreated(new GregorianCalendar().getTime());
        			userService.create(newUser, null);
        		}
        		sendRedirect(request, response,  buildRedirectUrlToLoginPage(entryShibUrl, authId, systemDomainId.toString(), request));
        	}
        }   
    }
	
	private User compareReplace(Map<String, String> headers, User user, String shibUniqueId, boolean updateAuthId) {
		if (updateAuthId){
			if (headers.get(shibUniqueId) != null && !user.getAuthId().equals(headers.get(shibUniqueId))){		
				user.setAuthId(headers.get(shibUniqueId));
			}
		}
		
		if (headers.get(ShiblethHeader.mail.attribute()) != null &&
				!user.getEmailRegular().equals(headers.get( ShiblethHeader.mail.attribute()))){
			user.setEmailRegular(headers.get(ShiblethHeader.mail.attribute()));
		}
		if (headers.get(ShiblethHeader.givenName.attribute()) != null && 
				!user.getFirstName().equals(headers.get( ShiblethHeader.givenName.attribute()))){			
			user.setFirstName(headers.get(ShiblethHeader.givenName.attribute()));
		}
		if (headers.get(ShiblethHeader.sn.attribute()) != null && 
				!user.getLastName().equals(headers.get( ShiblethHeader.sn.attribute()))){
			user.setLastName(headers.get(ShiblethHeader.sn.attribute()));
		}
		if (headers.get(ShiblethHeader.title.attribute()) != null && 
				!user.getTitle().equals(headers.get( ShiblethHeader.title.attribute()))){
			user.setTitle(headers.get(ShiblethHeader.title.attribute()));
		}		
		if (headers.get(ShiblethHeader.telephoneNumber.attribute()) != null && 
				!user.getWorkPhone().equals(headers.get( ShiblethHeader.telephoneNumber.attribute()))){
			user.setWorkPhone(headers.get(ShiblethHeader.telephoneNumber.attribute()));
		}
		return user;
	}


	/*
	 * Truncate string by the size
	 * @param data
	 * @param size 
	 * 
	 */
	private String safeTruncate(String data, int size){
		if(data != null && !"".equals(data) && data.length() > size){
			return data.substring(0, size).trim();
		}
		return data;
	}
	
	
	/*
	 * Fetch data before any ; or ,
	 * @param data 
	 * 
	 */
	private String safeFetch(String data){
		if(data != null && !"".equals(data)){
			int index = (data.indexOf(",") == -1)? ((data.indexOf(";") == -1) ? -1 : data.indexOf(";")): data.indexOf(",");
			if(index != -1){
				return data.substring(0, index).trim();
			} else{
				return data.trim();
			}			
		}
		return data;
	}
	
	/**
     * For test purpose. Feed in data for test.
     *
     * @param Headers map
     */ 
	@SuppressWarnings("unused")
	private void pushStubData(Map<String, String> map){
		map.put(ShiblethHeader.ShibIdentityProvider.attribute(), "https://shib-test.berkeley.edu/idp/shibboleth");		
		map.put(ShiblethHeader.displayName.attribute(), "Eric Liao test2");
		map.put(ShiblethHeader.givenName.attribute(), "Eric test2");
		map.put(ShiblethHeader.mail.attribute(), "hcliao-test-2@berkeley.edu");
		map.put(ShiblethHeader.sn.attribute(), "Liao test2");
		map.put(ShiblethHeader.title.attribute(), "Developer test2");	
		//IDP unique identifier
		map.put("eppn", "hcliao@berkeley.edu");	
		map.put("uid", "xxxxxx");	
	}
	
	/**
     * Validate HttpRequest headers. Truncate the fields according to column length.
     *
     * @param systemDomainList systemDomain list
     * @param headers from Http request
     */ 
	private SecurityErrorCode validateShibbolethRequest(List<SystemDomain> systemDomainList, Map<String, String> headers, String customUrl){						
		if(systemDomainList == null || systemDomainList.isEmpty()) return SecurityErrorCode.DOMAIN_WITH_IDP_NOT_FOUND;		
		//There could only be one match by looking up IDP and authType
		
		if (customUrl == null) return SecurityErrorCode.SHIBBOLETH_LOGIN_WITHOUT_CUSTOM_URL;
		
		if(systemDomainList.size() > 1) return SecurityErrorCode.DUPLICATE_INSTITUTION_BY_IDP;								
		
		if(systemDomainList.get(0).getShibIDP() == null || "".equals(systemDomainList.get(0).getShibIDP())) return SecurityErrorCode.IDP_PROVIDER_NOT_VALID_OR_NULL;
						
		shibUniqueId = DataUtil.safeTrimmingString(systemDomainList.get(0).getShibUniqueId());
		if (shibUniqueId == null || "".equals(shibUniqueId)){
			shibUniqueId = this.getDefaultShibbolethUniqueId(); //default is eppn
		}
		
		if(headers.get(shibUniqueId) == null || "".equals(headers.get(shibUniqueId))) return SecurityErrorCode.INVALID_IDP_EPPN;
		
		if(headers.get(ShiblethHeader.mail.attribute()) == null || "".equals(headers.get(ShiblethHeader.mail.attribute()))) return SecurityErrorCode.INVALID_IDP_MAIL;
		
		//truncate the data if it exceeds the column length
		headers.put(shibUniqueId, safeFetch(safeTruncate(headers.get(shibUniqueId), 256)));
		headers.put(ShiblethHeader.givenName.attribute(), safeFetch(safeTruncate(headers.get(ShiblethHeader.givenName.attribute()), 20)));
		headers.put(ShiblethHeader.sn.attribute(), safeFetch(safeTruncate(headers.get(ShiblethHeader.sn.attribute()), 30)));
		headers.put(ShiblethHeader.mail.attribute(), safeFetch(safeTruncate(headers.get(ShiblethHeader.mail.attribute()), 50)));
		headers.put(ShiblethHeader.title.attribute(), safeFetch(safeTruncate(headers.get(ShiblethHeader.title.attribute()), 200)));
		headers.put(ShiblethHeader.telephoneNumber.attribute(), safeFetch(safeTruncate(headers.get(ShiblethHeader.telephoneNumber.attribute()), 50)));
	
		return null;
	}
	
	/**
     * Transform http request headers to map
     *
     * @param request the submitted request
     */  
	@SuppressWarnings("unchecked")
	private Map transformRequestHeaders2Map(HttpServletRequest request){		
		Map<String, String> result = new HashMap<String, String>();
		Enumeration<String> hnames = request.getHeaderNames();
        
		while (hnames.hasMoreElements()) {
            String p = hnames.nextElement().toString();            
            result.put(p.trim(), request.getHeader(p));                     
        }         		
		return result;
	}
	
	
	protected String buildRedirectUrlToLoginPage(String loginUrl, String authId, String domainId, HttpServletRequest request) {
			
		    String parm = "systemDomainId=" + domainId + "&" + "authId=" + SecurityUtil.encode(authId);
		    // add struts token for direct login
		    if (!this.isShibleth) {
		    	parm += "&" + CSRF_TOKEN_NAME + "=" + this.obtainTokenName(request) + "&" + CSRF_TOKEN_VALUE + "=" + this.obtainTokenValue(request);
		    }
	        int serverPort = portResolver.getServerPort(request);
	        String scheme = request.getScheme();
	        RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();
	        urlBuilder.setScheme(scheme);
	        urlBuilder.setServerName(request.getServerName());
	        urlBuilder.setPort(serverPort);
	        urlBuilder.setContextPath(request.getContextPath());
	        urlBuilder.setPathInfo(loginUrl + parm);      
	        return urlBuilder.getUrl();
	 }
	 
	 
	 protected String buildShiblethUrlToLogoutPage(String logoutUrl, String error, HttpServletRequest request) {	  
		    String parm =logoutUrl + "?" + "error=" + error;
	        int serverPort = portResolver.getServerPort(request);
	        String scheme = request.getScheme();
	        RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();
	        urlBuilder.setScheme(scheme);
	        urlBuilder.setServerName(request.getServerName());
	        urlBuilder.setPort(serverPort);
	        urlBuilder.setContextPath(request.getContextPath());
	        urlBuilder.setPathInfo(parm);	      
	        return urlBuilder.getUrl();
	}
	 
	protected String buildShiblethUrlToLogoutWithIdp(String logoutUrl, String error, String idp, HttpServletRequest request) {	  
		    String parm =logoutUrl + "?" + "error=" + error + "&" + "idp=" + idp;
	        int serverPort = portResolver.getServerPort(request);
	        String scheme = request.getScheme();
	        RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();
	        urlBuilder.setScheme(scheme);
	        urlBuilder.setServerName(request.getServerName());
	        urlBuilder.setPort(serverPort);
	        urlBuilder.setContextPath(request.getContextPath());
	        urlBuilder.setPathInfo(parm);	      
	        return urlBuilder.getUrl();
	}
	 
	
	public Authentication attemptAuthentication(HttpServletRequest request) throws AuthenticationException {       
		
		//This is Shibleth authentication. Have to skip the other authenticator
		if(this.isShibleth){			
			Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
			grantedAuthoritySet.add(new GrantedAuthorityImpl("ROLE_ADMIN")); 
			GrantedAuthority[] authorities = grantedAuthoritySet.toArray(new GrantedAuthority[0]);
			
			//Authentication shiblethAuth = new UsernamePasswordAuthenticationToken("Shibleth", "Shibleth", authorities);
			JdbcAuthenticationToken authRequest = new JdbcAuthenticationToken("shibboleth", "shibboleth", authorities, "0");

			 // Place the last username attempted into HttpSession for views
	        HttpSession session = request.getSession(false);

	        if (session != null || getAllowSessionCreation()) {
	            request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextUtils.escapeEntities("Shibboleth"));	            
	        }        	        
	        setDetails(request, authRequest);
	        return this.shiblethAuthenticationManager.authenticate(authRequest);     
		} else{					
			String username = obtainUsername(request);
	        String password = obtainPassword(request);
	        String locationId = obtainLocationId(request);
	        
	        if (username == null) {
	            username = "";
	        }

	        if (password == null) {
	            password = "";
	        }
	        
	        if (locationId == null) {
	            locationId = "";
	        }

	        username = username.trim();
	                
	        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<GrantedAuthority>();
			grantedAuthoritySet.add(new GrantedAuthorityImpl("ROLE_ADMIN")); 
			GrantedAuthority[] authorities = grantedAuthoritySet.toArray(new GrantedAuthority[0]); 
			JdbcAuthenticationToken authRequest = new JdbcAuthenticationToken(username, password, authorities, locationId);
			
	        // Place the last username attempted into HttpSession for views
	        HttpSession session = request.getSession(false);

	        if (session != null || getAllowSessionCreation()) {
	            request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextUtils.escapeEntities(username));
	        }

	        // Allow subclasses to set the "details" property
	        setDetails(request, authRequest);        
	        Authentication result = this.jdbcAuthenticationManager.authenticate(authRequest);	        	               
	        return result;
		}

    }
	
	/**
	 * Customized requiresAuthentication method
     * <p>
     * Indicates whether this filter should attempt to process a login request
     * for the current invocation.
     * </p>
     * <p>
     * It strips any parameters from the "path" section of the request URL (such
     * as the jsessionid parameter in
     * <em>http://host/myapp/index.html;jsessionid=blah</em>) before matching
     * against the <code>filterProcessesUrl</code> property.
     * </p>
     * <p>
     * Subclasses may override for special requirements, such as Tapestry
     * integration.
     * </p>
     *
     * @param request as received from the filter chain
     * @param response as received from the filter chain
     *
     * @return <code>true</code> if the filter should attempt authentication,
     * <code>false</code> otherwise
     */
    protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response){  	  	
    	//figured out if the request is from Shibleth
    	this.setIsShibleth(false);
    	
    	//logger.warn("		######  The request object is: " + request.getAttributeNames() + "	######");   	
    	//System.out.println("		######  The request object is: " + request.getAttributeNames() + "	######");
    	if(request.getAttribute("isShibleth") != null && ((String)request.getAttribute("isShibleth")).equals("1")){
    		
    		//System.out.println("		###### This is Shibleth login!! " + "	######");
    		
    		logger.warn("		###### This is Shibleth login!! " + "	######");	
    		
    		this.setIsShibleth(true);	
    		//Create userdtails DTO and put it into session.
    		return true;
    	}   	
    	//System.out.println("		###### This is Direct login!! " + "	######");
    	//logger.warn("		###### This is Direct login!! " + "	######");
    	
    	String uri = request.getRequestURI();    	
    	
    	//Replace the double forward slash with single slash. 
    	//It seems apache proxy adds double forward slash
    	if(uri.indexOf("//") > 0){
    		uri = uri.substring(0, uri.indexOf("//")) + "/" + uri.subSequence(uri.indexOf("//") + 2, uri.length());
    	}    	   	  	
    	
        int pathParamIndex = uri.indexOf(';');
        if (pathParamIndex > 0) {
            // strip everything after the first semi-colon
            uri = uri.substring(0, pathParamIndex);
        }          

        if ("".equals(request.getContextPath())) {
            return uri.endsWith(getFilterProcessesUrl());
        }
                     
        return uri.endsWith(request.getContextPath() + getFilterProcessesUrl());
    }  
    
    /**
     * Create the authenticated spring security context.
     *
     * @param request the submitted request
     */ 
    public SecurityContext generateNewContext() throws ServletException {
        try {
            return (SecurityContext) this.contextClass.newInstance();
        }
        catch (InstantiationException ie) {
            throw new ServletException(ie);
        }
        catch (IllegalAccessException iae) {
            throw new ServletException(iae);
        }
    }
    
    /**
     * Enables subclasses to override the composition of the username, such as by including additional values
     * and a separator.
     *
     * @param request so that request attributes can be retrieved
     *
     * @return the username that will be presented in the <code>Authentication</code> request token to the
     *         <code>AuthenticationManager</code>
     */
    protected String obtainLocationId(HttpServletRequest request) {
        return request.getParameter(UC_LOCATION);
    }
   
    protected String obtainTokenName(HttpServletRequest request) {
        return request.getParameter(CSRF_TOKEN_NAME);
    }
   
    protected String obtainTokenValue(HttpServletRequest request) {
        return request.getParameter(CSRF_TOKEN_VALUE);
    }

}
