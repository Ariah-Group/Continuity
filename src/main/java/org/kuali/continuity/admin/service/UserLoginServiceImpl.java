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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.admin.dao.UserLoginDAO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.UserAccessValue;
import org.kuali.continuity.service.EmailMessageEnum;
import org.kuali.continuity.service.EmailSenderService;

public class UserLoginServiceImpl implements UserLoginService {
	
	private UserLoginDAO userLoginDAO;
	private UserService userService;
	private EmailSenderService emailSenderService;
	private SystemDomainService systemDomainService;
	private final static String MODERATORS = "moderators"; 
	private final static String AUTH_ID = "authId" ; 
	private final static String PASSWORD = "password";

	@Override
	public boolean autoApproveUserLogin(User user, UserAccessValue userAccessValue) {
		if (user == null || 
			user.getEmailRegular() == null || 
			user.getEmailRegular().trim().length() == 0)
				return false;

		SystemDomain systemDomain = this.systemDomainService.getById(user.getSystemDomainId());
		
		// is demo
		if (systemDomain.isDemo()) {
			this.approveUser(user, userAccessValue); 
			return true;
		}
		
		// is shib
		if (systemDomain.isShibMode()) return true;

		// is partial moderated access
		if (systemDomain.isPartialModeratedAccess()) ; else return false;

		// get domain
		String userEmail = user.getEmailRegular();
		int atIndex = userEmail.indexOf('@');
		if (atIndex < 0) return false;

		// auto approve
		String userNetDomain = userEmail.substring(atIndex+1).trim().toLowerCase();
		Set<String> netDomains = systemDomain.getNetDomains();
	
		// iterate
		for (String netDomain : netDomains) {
			if (!netDomain.trim().toLowerCase().equals(userNetDomain)) continue;
			this.approveUser(user, userAccessValue);
			return true;
		}
		
		// return
		return false;
	}
	
	private void approveUser(User user, UserAccessValue userAccessValue) {
		// approve user login
		String password = this.userLoginDAO.approveUserLogin(user, true);
		
		// send email
		Map<String, Object> loginMap = new HashMap<String, Object>();
		loginMap.put(AUTH_ID, user.getAuthId());
		loginMap.put(PASSWORD, password);
		this.getEmailSenderService().sendEmailMessage(user.getSystemDomainId(), user.getEmailRegular(), EmailMessageEnum.MODERATOR_APPROVE_USER, loginMap, userAccessValue);
	}
	
	@Override
	public void approveUserLogin(User user, boolean isApproved, UserAccessValue userAccessValue) {
		// approve users
		if (user == null ) return;
		String password = this.userLoginDAO.approveUserLogin(user, isApproved);
		
		// send approve email
		if (isApproved) {
			Map<String, Object> passwordMap = new HashMap<String, Object>();
			passwordMap.put(AUTH_ID, user.getAuthId());
			passwordMap.put(PASSWORD, password);
			this.getEmailSenderService().sendEmailMessage(user.getSystemDomainId(), user.getEmailRegular(), EmailMessageEnum.MODERATOR_APPROVE_USER, passwordMap, userAccessValue);
		} else {
			//delete user from user account list
			userService.delete(user.getId());
			
			int systemDomainId = user.getSystemDomainId();			
			Map<String, Object> modMap = new HashMap<String, Object>();
			modMap.put(MODERATORS, this.userService.getModeratorListBySystemDomainId(systemDomainId));
			this.getEmailSenderService().sendEmailMessage(systemDomainId, user.getEmailRegular(), EmailMessageEnum.MODERATOR_DENY_USER, modMap, userAccessValue);
		}
	}
	
	@Override
	public void approveUserLogins(List<User> users, boolean isApproved, UserAccessValue userAccessValue) {
		// approve users
		if (users == null || users.isEmpty()) return;
		Map<User, String> userPasswordMap = this.userLoginDAO.approveUserLogins(users, isApproved);
		if (userPasswordMap == null || userPasswordMap.isEmpty()) return;
		
		// send email
		Set<User> userSet = userPasswordMap.keySet();
		
		if (isApproved) {
			// send approve email
			for (User user : userSet) {
				Map<String, Object> passwordMap = new HashMap<String, Object>();
				passwordMap.put(AUTH_ID, user.getAuthId());
				passwordMap.put(PASSWORD, userPasswordMap.get(user));
				this.getEmailSenderService().sendEmailMessage(user.getSystemDomainId(), user.getEmailRegular(), EmailMessageEnum.MODERATOR_APPROVE_USER, passwordMap, userAccessValue);
			}
		} else {
			// send deny email
			int i = 0;
			int systemDomainId = users.get(0).getSystemDomainId();
			String[] userArray = new String[userSet.size()];
			for (User user : userSet){
				userArray[i++] = user.getEmailRegular();
				//delete user from user account list
				userService.delete(user.getId());
			}
			Map<String, Object> modMap = new HashMap<String, Object>();
			modMap.put(MODERATORS, this.userService.getModeratorListBySystemDomainId(systemDomainId));
			this.getEmailSenderService().sendEmailMessage(systemDomainId, userArray, EmailMessageEnum.MODERATOR_DENY_USER, modMap, userAccessValue);
		}
	}

	@Override
	public boolean authenticate(int systemDomainId, String authId,
			String password) {
		return this.userLoginDAO.authenticate(systemDomainId, authId, password);
	}

	@Override
	public void changePassword(int userId, String password) {
		this.userLoginDAO.changePassword(userId, password);
	}

	@Override
	public void changePassword(int userId, String password, boolean setModApprovedFlag) {
		this.userLoginDAO.changePassword(userId, password, setModApprovedFlag);		
	}
	
	@Override
	public void requestLoginPassword(int userId) {
		User user = this.userService.getById(userId);
		String password = this.userLoginDAO.requestLoginPassword(user);
		Map<String, Object> loginMap = new HashMap<String, Object>();
		loginMap.put(AUTH_ID, user.getAuthId());
		loginMap.put(PASSWORD, password);
		loginMap.put(MODERATORS, this.userService.getModeratorListBySystemDomainId(user.getSystemDomainId()));
		this.emailSenderService.sendEmailMessage(user.getSystemDomainId(), user.getEmailRegular(), EmailMessageEnum.REQUEST_LOGIN_PASSWORD, (Map<String,Object>)loginMap, null);
	}

	@Override
	public User getBySystemDomainIdAndAuthId(int systemDomainId, String authId){
		return userService.getBySystemDomainIdAndAuthId(systemDomainId, authId);
	}
	
	public UserLoginDAO getUserLoginDAO() {
		return this.userLoginDAO;
	}

	public void setUserLoginDAO(UserLoginDAO userLoginDAO) {
		this.userLoginDAO = userLoginDAO;
	}

	public EmailSenderService getEmailSenderService() {
		return this.emailSenderService;
	}

	public void setEmailSenderService(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	public SystemDomainService getSystemDomainService() {
		return this.systemDomainService;
	}

	public void setSystemDomainService(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}

	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
