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

import java.util.Map;

import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionMessage;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.dto.UITextDTO;
import org.kuali.continuity.action.util.SessionUserRoleUtil;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.AdminTestModeService;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.admin.service.SystemDomainUITextService;
import org.kuali.continuity.admin.service.UserService;
import org.kuali.continuity.domain.AccessStatusEnum;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SystemDomainAccess;
import org.kuali.continuity.domain.SystemDomainAccessEnum;
import org.kuali.continuity.domain.UITextEnum;
import org.kuali.continuity.security.SecurityUtil;

@SuppressWarnings("serial")
public class LoginAction extends BaseActionSupport {
	
	private UserService userService;
	private SystemDomainService systemDomainService;
	private SystemDomainUITextService systemDomainUITextService;
	private AdminTestModeService adminEmailTestModeService;
	private SessionUserRoleUtil sessionUserRoleUtil;
	private int systemDomainId;
	private String authId;
	
	public LoginAction(UserService userService,
			SystemDomainService systemDomainService,
			SystemDomainUITextService systemDomainUITextService,
			AdminTestModeService adminEmailTestModeService,
			SessionUserRoleUtil sessionUserRoleUtil) {
		this.userService = userService;
		this.systemDomainService = systemDomainService;
		this.systemDomainUITextService = systemDomainUITextService;
		this.adminEmailTestModeService = adminEmailTestModeService;
		this.sessionUserRoleUtil = sessionUserRoleUtil;
	}

	public int getSystemDomainId() {
		return this.systemDomainId;
	}

	public void setSystemDomainId(int systemDomainId) {
		this.systemDomainId = systemDomainId;
	}

	public String getAuthId() {
		return this.authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String execute() throws Exception {
		// get user
		if (this.systemDomainId == 0 || this.authId == null || this.authId.trim().length() == 0)
			return INPUT;
		User user = this.userService.getBySystemDomainIdAndAuthId(this.systemDomainId, SecurityUtil.decode(this.authId));
			
		// check user
		if (user == null) return INPUT;
		
		// check user access
		if (!user.getAccessStatus().equals(AccessStatusEnum.ON.getRefDomainObject())) {
			this.putInSession(SessionKey.tmpActionMessage, new SessionMessage("Access disabled, please contact administrator."));
			return "accessDisabled";
		}
		
		// set user dto
		SessionUserDTO userDTO = new SessionUserDTO(user);

		// set system domain role 
		this.sessionUserRoleUtil.setSessionUserRole(userDTO, user.getSystemDomainId());
		
		// check system domain access
		SessionSystemDomainDTO sessionSystemDomain = (SessionSystemDomainDTO) userDTO.systemDomain;
		if (!(this.hasAccess(user.getSecurityType(), new SystemDomainAccess(sessionSystemDomain.systemDomainAccess.id)))) {
			this.putInSession(SessionKey.tmpActionMessage, new SessionMessage("Access disabled, please contact administrator."));
			return "accessDisabled";
		}
		
		// get ui texts
		UITextDTO uiTextDTO = new UITextDTO();
		Map<UITextEnum, String> uiTexts = this.systemDomainUITextService.getByOwnerId(this.systemDomainId);
		if (uiTexts != null) uiTextDTO = new UITextDTO(uiTexts);

		// put into session
		this.putInSession(SessionKey.user, userDTO);
		this.putInSession(SessionKey.systemDomain, sessionSystemDomain);
		this.putInSession(SessionKey.loginSystemDomain, sessionSystemDomain);
		this.putInSession(SessionKey.uiText, uiTextDTO);
		
		// sys admin
		if (user.getSecurityType().equals(SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject()) ||
			user.getSecurityType().equals(SecurityTypeEnum.INSTITUTION_ADMIN.getRefDomainObject())) {
			SessionUserDTO sysAdminUserDTO = new SessionUserDTO();
			sysAdminUserDTO.id = userDTO.id;
			sysAdminUserDTO.firstName = userDTO.firstName;
			sysAdminUserDTO.lastName = userDTO.lastName;
			sysAdminUserDTO.fullName = userDTO.fullName;
			sysAdminUserDTO.title = userDTO.title;
			sysAdminUserDTO.emailRegular = userDTO.emailRegular;
			sysAdminUserDTO.workPhone = userDTO.workPhone;
			sysAdminUserDTO.workFax = userDTO.workFax;
			sysAdminUserDTO.departmentName = userDTO.departmentName;
			sysAdminUserDTO.departmentOrg = userDTO.departmentOrg;
			sysAdminUserDTO.departmentOrgHierarchy = userDTO.departmentOrgHierarchy;
			sysAdminUserDTO.systemDomain = userDTO.systemDomain;
			sysAdminUserDTO.securityType = userDTO.securityType;
			sysAdminUserDTO.systemDomainAccess = userDTO.systemDomainAccess;		
			sysAdminUserDTO.isDirAccessible = userDTO.isDirAccessible;
			sysAdminUserDTO.isShibMode = userDTO.isShibMode;
			sysAdminUserDTO.isLBNLUser = userDTO.isLBNLUser;
			sysAdminUserDTO.authId = userDTO.authId;
			this.putInSession(SessionKey.systemAdminUser, sysAdminUserDTO);
		} else {
			this.removeFromSession(SessionKey.systemAdminUser);
		}
		
		// set system name
		SessionSystemDomainDTO systemDomainDTO = this.getSessionSystemDomain();
		String systemName = systemDomainDTO.systemName;
		if (systemName == null || systemName.trim().length() == 0) {
			systemDomainDTO.systemName = this.systemDomainService.getDefaultSystemName();
		}
		
		// is admin email disabled
		if (SecurityTypeEnum.isAdmin(user.getSecurityType())) {
			sessionSystemDomain.settings.isInTestMode =
				this.adminEmailTestModeService.isInTestMode(user.getId());
		}
		
		// return
		return SUCCESS;
	}
	
	public void prepare() throws Exception {
		this.removeFromSession(SessionKey.plan);
	}
	
	private boolean hasAccess(SecurityType securityType, SystemDomainAccess systemDomainAccess) {
		if (SystemDomainAccessEnum.ALL_USERS.getRefDomainObject().equals(systemDomainAccess)) {
			return true;
		} else if (SystemDomainAccessEnum.ALL_ADMINS.getRefDomainObject().equals(systemDomainAccess)) {
			if (SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject().equals(securityType) ||
				SecurityTypeEnum.INSTITUTION_ADMIN.getRefDomainObject().equals(securityType) ||
				SecurityTypeEnum.LOCAL_ADMIN.getRefDomainObject().equals(securityType))
					return true;
		} else if (SystemDomainAccessEnum.SA_IA_ONLY.getRefDomainObject().equals(systemDomainAccess)) {
			if (SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject().equals(securityType) ||
				SecurityTypeEnum.INSTITUTION_ADMIN.getRefDomainObject().equals(securityType))
					return true;
		} else if (SystemDomainAccessEnum.SA_ONLY.getRefDomainObject().equals(systemDomainAccess)) {
			if (SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject().equals(securityType))
					return true;
		}
		return false;
	}

}
