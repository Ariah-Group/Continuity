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
package org.kuali.continuity.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.security.SecurityEnum;
import org.kuali.continuity.security.SecurityErrorCode;
import org.kuali.continuity.security.SecurityUtil;
import org.kuali.continuity.service.InCommonMetadataService;
import org.springframework.security.util.PortResolver;
import org.springframework.security.util.PortResolverImpl;
import org.springframework.security.util.RedirectUrlBuilder;

@SuppressWarnings("serial")
public class LogoutAction extends BaseActionSupport implements ServletRequestAware{
	
	private SystemDomainService systemDomainService;
	private InCommonMetadataService iCommonMetadataService;
	private String backUrl;
	private String error;
	private String exception;
	//private String defaultDirectLoginUrl;
	//private String shibbolethLoginWayfUrl;
	private HttpServletRequest servletRequest;
	private String idp;
	private List<SystemDomainDTO> domainDTOList;
	private PortResolver portResolver = new PortResolverImpl();

	
	public List<SystemDomainDTO> getDomainDTOList() {
		return domainDTOList;
	}

	public void setDomainList(List<SystemDomainDTO> domainDTOList) {
		this.domainDTOList = domainDTOList;
	}

	public String getIdp() {
		return idp;
	}

	public void setIdp(String idp) {
		this.idp = idp;
	}

//	public String getDefaultDirectLoginUrl() {
//		return defaultDirectLoginUrl;
//	}
//
//	public void setDefaultDirectLoginUrl(String defaultDirectLoginUrl) {
//		this.defaultDirectLoginUrl = defaultDirectLoginUrl;
//	}
//	
//	public String getShibbolethLoginWayfUrl() {
//		return shibbolethLoginWayfUrl;
//	}
//
//	public void setShibbolethLoginWayfUrl(String shibbolethLoginWayfUrl) {
//		this.shibbolethLoginWayfUrl = shibbolethLoginWayfUrl;
//	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setSystemDomainService(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}
	
	public void setInCommonMetadataService(InCommonMetadataService inCommonMetadataService){
		this.iCommonMetadataService = inCommonMetadataService;
	}
	
	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	public LogoutAction(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}

	@Override
	public void prepare() throws Exception {	
	}

	
	public String execute() throws Exception {	
		
		//If there is any error, throws it to error page.
		
		if(error != null && !"".equals(error) && error.equals(SecurityErrorCode.SHIBBOLETH_LOGIN_WITHOUT_CUSTOM_URL.getId())){
			exception = SecurityErrorCode.SHIBBOLETH_LOGIN_WITHOUT_CUSTOM_URL.getDescription();
			return SUCCESS;
		} else if(error != null && !"".equals(error) && error.equals(SecurityErrorCode.SESSION_EXPIRED.getId())){
			exception = SecurityErrorCode.SESSION_EXPIRED.getDescription();
			return SUCCESS;
		} else if (error != null && !"".equals(error)){
			//throw new Exception(SecurityErrorCode.valueOfId(error));
			exception = SecurityErrorCode.valueOfId(error).toString();
			return SUCCESS;
		}
		
		if (exception != null && error.equals(SecurityErrorCode.SHIBBOLETH_LOGIN_WITHOUT_CUSTOM_URL.getId()) && (idp != null && !"".equals(idp))){
			String idp = SecurityUtil.decode(this.idp);
			List<SystemDomain> domainList = systemDomainService.getShibListByIDPAuthType(idp);
			domainDTOList = new ArrayList<SystemDomainDTO>();
			for(SystemDomain domain : domainList){				
				SystemDomainDTO domainDTO = new SystemDomainDTO(domain);
				domainDTO.url = buildLoginUrl(domain.getCustomUrl(), servletRequest);
				domainDTOList.add(domainDTO);
			}
			return SUCCESS;
		}
		
		SessionSystemDomainDTO dto = (SessionSystemDomainDTO) this.getSessionValue(SessionKey.loginSystemDomain);
					
		if(dto == null){
			//This means session already expired or 
			String customUrl = SecurityUtil.getCookieValue(servletRequest.getCookies(), SecurityEnum.KUALI_DIRECTLOGIN_COOKIE_KEY.toString());
 			String shibbolethIdp = SecurityUtil.getCookieValue(servletRequest.getCookies(), SecurityEnum.SHIBBOLETH_LOGIN_IDP_ID.toString());
 			String shibbolethCustomUrl = SecurityUtil.getCookieValue(servletRequest.getCookies(), SecurityEnum.SHIBBOLETH_LOGIN_CUSTOM_URL.toString());

 			if(customUrl == null && (shibbolethIdp == null || shibbolethCustomUrl == null)){
 				//Client cleared all cookies
 				exception = SecurityErrorCode.SESSION_EXPIRED.getDescription();
 				//defaultDirectLoginUrl = this.iCommonMetadataService.getAppUrl() + "/kcpt" + "/login/ready";
 				//shibbolethLoginWayfUrl= this.iCommonMetadataService.getAppUrl() + "/secure";			
 			} else if (customUrl != null && (shibbolethIdp == null || shibbolethCustomUrl == null)){
 				//Direct Login
 				backUrl = this.iCommonMetadataService.getAppUrl() + "/kcpt/login/ready?" + "sdname=" + customUrl;
 			} else {
 				//Shibboleth Login
 				backUrl = this.iCommonMetadataService.getLoginUrl(shibbolethIdp, shibbolethCustomUrl);
 			}
			return SUCCESS;
		}
		
		SystemDomain systemDomain = this.systemDomainService.getById(dto.id);
		
		if(systemDomain == null){
			backUrl = this.iCommonMetadataService.getAppUrl() + "/kcpt";
			return SUCCESS;
		}
		
		if(systemDomain.isShibMode()){		
			backUrl = this.iCommonMetadataService.getLoginUrl(systemDomain.getShibIDP(), systemDomain.getCustomUrl());
		} else{
			backUrl = this.iCommonMetadataService.getAppUrl() + "/kcpt" + "/login/ready?sdname=" + systemDomain.getCustomUrl();
		}
		
		return SUCCESS;
	}	
	
	protected String buildLoginUrl(String customUrl, HttpServletRequest request) {		 					  
        int serverPort = portResolver.getServerPort(request);
        String scheme = request.getScheme();
        RedirectUrlBuilder urlBuilder = new RedirectUrlBuilder();
        urlBuilder.setScheme(scheme);
        urlBuilder.setServerName(request.getServerName());
        urlBuilder.setPort(serverPort);
        urlBuilder.setPathInfo("/" + customUrl);      
        return urlBuilder.getUrl();
	}
	
	public String failed() throws Exception {
		return SUCCESS;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

}
