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
package org.kuali.continuity.admin.service;

import java.util.ArrayList;
import java.util.List;

import org.kuali.continuity.admin.dao.UserDAO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.UserAccessValue;
import org.kuali.continuity.service.EmailMessageEnum;
import org.kuali.continuity.service.EmailSenderService;

public class UserServiceImpl implements UserService {
	
	private GenericAdminService genericAdminService;
	private UserLoginService userLoginService;
	private EmailSenderService emailSenderService;
	private UserDAO userDAO;

	public void create(User obj, UserAccessValue userAccessValue) {
		String authId = obj.getAuthId();
		this.getGenericAdminService().create(obj);
		if (authId != null && authId.trim().length() != 0) {
			// auto approve
			if (!this.userLoginService.autoApproveUserLogin(obj, userAccessValue)) {
				// send email to moderator
				int i = 0;
				List<User> mods = this.getModeratorListBySystemDomainId(obj.getSystemDomainId());
				String[] emails = new String[mods.size()];
				for (User user : mods) emails[i++] = user.getEmailRegular();
				this.getEmailSenderService().sendEmailMessage(obj.getSystemDomainId(), emails, EmailMessageEnum.USER_AWAITING_APPROVAL, userAccessValue);
			}
		}
	}

	public void delete(int id) {
		this.getGenericAdminService().delete(User.class, id);
	}

	public User getById(int id) {
		return (User) this.getGenericAdminService().getById(User.class, id);
	}

	public User getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (User) this.getGenericAdminService().getBySystemDomainIdAndName(User.class, systemDomainId, name);
	}

	public User getBySystemDomainIdAndEmail(int systemDomainId, String email) {
		return (User) this.userDAO.getBySystemDomainIdAndEmail(systemDomainId, email);
	}

	@SuppressWarnings("unchecked")
	public List<User> getListBySystemDomainId(int systemDomainId) {
		return (List<User>) this.getGenericAdminService().getListBySystemDomainId(User.class, systemDomainId);
	}

	public long getListBySystemDomainIdSize(int systemDomainId) {
		return this.getGenericAdminService().getListBySystemDomainIdSize(User.class, systemDomainId);
	}

	@SuppressWarnings("unchecked")
	public List<User> getSortedListBySystemDomainId(int systemDomainId,
			SortByType sortBy, boolean isAscending) {
		return (List<User>) this.getGenericAdminService().getSortedListBySystemDomainId(User.class, systemDomainId, sortBy, isAscending);
	}

	@SuppressWarnings("unchecked")
	public List<User> getSortedSubListBySystemDomainId(int systemDomainId,
			int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<User>) this.getGenericAdminService().getSortedSubListBySystemDomainId(User.class, systemDomainId, start, limit, sortBy, isAscending);
	}

	@SuppressWarnings("unchecked")
	public List<User> getSubListBySystemDomainId(int systemDomainId, int start,
			int limit) {
		return (List<User>) this.getGenericAdminService().getSubListBySystemDomainId(User.class, systemDomainId, start, limit);
	}

	@Override
	public void update(User obj, UserAccessValue userAccessValue) {
		User testUser = this.getById(obj.getId());
		String authId = testUser.getAuthId();
		this.getGenericAdminService().update(obj);
		if (authId == null || authId.trim().length() == 0) {
			if (!this.userLoginService.autoApproveUserLogin(obj, userAccessValue)) {
				// send email to moderator
				int i = 0;
				List<User> mods = this.getModeratorListBySystemDomainId(obj.getSystemDomainId());
				String[] emails = new String[mods.size()];
				for (User user : mods) emails[i++] = user.getEmailRegular();
				this.getEmailSenderService().sendEmailMessage(obj.getSystemDomainId(), emails, EmailMessageEnum.USER_AWAITING_APPROVAL, userAccessValue);
			}
		}
	}

	@Override
	public List<User> getListBySystemDomainIdAndNames(int systemDomainId, String firstName, String lastName) {
		return this.userDAO.getListBySystemDomainIdAndNames(systemDomainId, firstName, lastName);
	}
	
	@Override
	public List<User> getUnapprovedListBySystemDomainId(int systemDomainId) {
		return this.userDAO.getUnapprovedListBySystemDomainId(systemDomainId);
	}

	@Override
	public User getBySystemDomainIdAndAuthId(int systemDomainId, String authId) {
		return this.userDAO.getBySystemDomainIdAndAuthId(systemDomainId, authId);
	}
	
	private GenericAdminService getGenericAdminService() {
		return this.genericAdminService;
	}

	public void setGenericAdminService(GenericAdminService genericAdminService) {
		this.genericAdminService = genericAdminService;
	}

	public UserLoginService getUserLoginService() {
		return this.userLoginService;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public EmailSenderService getEmailSenderService() {
		return this.emailSenderService;
	}

	public void setEmailSenderService(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@Override
	public void create(BaseDomainObject obj) {
		this.create((User)obj, null);
	}

	@Override
	public List<? extends BaseDomainObject> getListByOwnerId(int ownerId) {
		return this.getListBySystemDomainId(ownerId);
	}

	@Override
	public void update(BaseDomainObject obj) {
		this.update((User)obj, null);
	}

	@Override
	public List<User> getListBySystemDomainIdAndSecurityType(
			int systemDomainId, SecurityType securityType) {
		return this.userDAO.getListBySystemDomainIdAndSecurityType(systemDomainId, securityType);
	}

	@Override
	public List<User> getModeratorListBySystemDomainId(int systemDomainId) {
		List<User> mods = new ArrayList<User>();
		SecurityTypeEnum[] securityTypeEnums = {
				SecurityTypeEnum.MODERATOR, 
				SecurityTypeEnum.LOCAL_ADMIN, 
				SecurityTypeEnum.INSTITUTION_ADMIN, 
				SecurityTypeEnum.SYSTEM_ADMIN};
		for (SecurityTypeEnum securityTypeEnum : securityTypeEnums) {
			mods = 
				this.getListBySystemDomainIdAndSecurityType(systemDomainId, securityTypeEnum.getRefDomainObject());
			if (mods != null && !mods.isEmpty()) break;
		}
		return mods;
	}

	@Override
	public List<User> getSortedListBySystemDomainIdAndSecurityType(
			int systemDomainId, SecurityType securityType, SortByType sortBy,
			boolean isAscending) {
		return this.userDAO.getSortedListBySystemDomainIdAndSecurityType(systemDomainId, securityType, sortBy, isAscending);
	}

}
