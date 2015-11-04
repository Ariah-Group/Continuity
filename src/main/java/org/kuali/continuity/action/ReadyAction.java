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

import java.util.List;

import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionMessage;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.service.InCommonMetadataService;
import org.kuali.continuity.util.DataUtil;

@SuppressWarnings("serial")
public class ReadyAction extends BaseActionSupport {
	
	private SystemDomainService systemDomainService;
	private InCommonMetadataService inCommonMetadataService;
	private String sdname;	
	private String systemDomainName;
	private DomainObject2DTOConverter do2dtoConverter;
	private String shibbolethUrl;	
	
	public ReadyAction(SystemDomainService systemDomainService, InCommonMetadataService inCommonMetadataService) {
		this.systemDomainService = systemDomainService;
		this.inCommonMetadataService = inCommonMetadataService;
	}

	@Override
	public void prepare() throws Exception {
	}

	public void setSdname(String sdName) {
		this.sdname = sdName;
	}
	
	public String getSdname() {
		return sdname;
	}
	
	public String getShibbolethUrl() {
		return shibbolethUrl;
	}

	public void setShibbolethUrl(String shibbolethUrl) {
		this.shibbolethUrl = shibbolethUrl;
	}
	
	public String execute() throws Exception {
		
		List<SystemDomain> systemDomainList = null; 
		if(sdname != null && !"".equals(sdname.trim())){
			systemDomainList = systemDomainService.getListByCustomUrl(DataUtil.nonulls(this.sdname));			
		}

		// exceptions
		if (systemDomainList == null || systemDomainList.isEmpty()) {
			this.removeFromSession(SessionKey.loginSystemDomain);
			throw new Exception("Page not found!");
		}
		if (systemDomainList.size() > 1) {
			this.removeFromSession(SessionKey.loginSystemDomain);
			throw new Exception("Custom Url: " + this.getSdname() + " exists in more than one institution. Please contact your administrator to fix it.");
		}

		// valid url
		SystemDomain domain = systemDomainList.get(0);
			
		//Direct login
		if(!domain.isShibMode()) {												
			this.systemDomainName = domain.getName();
			this.putInSession(SessionKey.loginSystemDomain, new SessionSystemDomainDTO(domain.getId(), this.systemDomainName, this.sdname));			

		//Shibboleth login 
		} else {
			if(domain.getShibIDP() == null || "".equals(domain.getShibIDP())){
				throw new Exception("Institution: " + domain.getName() + " does not have shibboleth IDP. Please contact your administrator to fix it.");
			}	
			
			if(domain.getCustomUrl() == null || "".equals(domain.getCustomUrl())){
				throw new Exception("Institution: " + domain.getName() + " does not have custom url. Please contact your administrator to fix it.");
			}
							 
			this.setShibbolethUrl(inCommonMetadataService.getLoginUrl(domain.getShibIDP(), domain.getCustomUrl()));
			return INPUT;
		}
						
		return SUCCESS;
	}
	
	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

	public String failed() throws Exception {
		SessionSystemDomainDTO dto = (SessionSystemDomainDTO) this.getSessionValue(SessionKey.loginSystemDomain);
		if (dto != null) {
			this.systemDomainName = dto.name;
		}
		SessionMessage msg = (SessionMessage) this.getSessionValue(SessionKey.tmpActionMessage);
		if (msg != null && msg.getMessage() != null && msg.getMessage().trim().length() != 0) {
			this.addActionError(msg.getMessage());
			this.removeFromSession(SessionKey.tmpActionMessage);
		}
		return SUCCESS;
	}

	public String getSystemDomainName() {
		return this.systemDomainName;
	}

	public void setSystemDomainName(String systemDomainName) {
		this.systemDomainName = systemDomainName;
	}

}
