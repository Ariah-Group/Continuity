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
package org.kuali.continuity.plan.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.admin.service.UserService;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.PlanStatusEnum;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.UserAccessValue;
import org.kuali.continuity.plan.dao.ContinuityPlanDAO;
import org.kuali.continuity.plan.dao.SimpleContinuityPlanDAO;
import org.kuali.continuity.plan.domain.BaseContinuityPlan;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.DepartmentInfo;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;
import org.kuali.continuity.service.EmailMessageEnum;
import org.kuali.continuity.service.EmailSenderService;

public class ContinuityPlanServiceImpl implements ContinuityPlanService {
	
	private ContinuityPlanDAO continuityPlanDAO;
	private SimpleContinuityPlanDAO simpleContinuityPlanDAO;
	private UserService userService;
	private EmailSenderService emailSenderService;
	private CriticalFunctionService criticalFunctionService;
	private InformationTechnologyService informationTechnologyService;
	private KeyResourcesService keyResourcesService;
	private SystemDomainService systemDomainService;
	
	public void createContinuityPlan(ContinuityPlan plan, UserAccessValue userAccessValue) {
		// create users
		List<User> departmentHead = new ArrayList<User>();
		departmentHead.add(plan.getDepartmentHead());
		this.createUsers(plan, departmentHead, userAccessValue);
		
		// set status
		plan.setStatus(PlanStatusEnum.IN_PROGRESS.getRefDomainObject());
		
		// create plan
		this.continuityPlanDAO.create(plan);
	}

	// cascade delete mapping doesn't seem to work!
	// TODO: revisit db cascade delete
	public void deleteContinuityPlan(ContinuityPlan plan, UserAccessValue userAccessValue) {
		int planId = plan.getId();
		this.deleteContinuityPlan(planId, userAccessValue);
	}

	protected void deleteContinuityPlan(int planId, UserAccessValue userAccessValue) {
		// delete critical function first
		List<CriticalFunction> cfList = this.criticalFunctionService.getCriticalFunctionList(planId);
		for (CriticalFunction criticalFunction : cfList) {
			this.criticalFunctionService.deleteCriticalFunction(criticalFunction.getId());
		}
		
		// delete information technology
		this.informationTechnologyService.deleteInformationTechnology(planId);
		
		// delete key resources
		this.keyResourcesService.deleteKeyResources(planId);

		// delete plan
		this.continuityPlanDAO.delete(planId);
	}

	public ContinuityPlan getContinuityPlan(int planId) {
		return this.continuityPlanDAO.getById(planId);
	}

	// used in aop
	public ContinuityPlan getContinuityPlan(int planId, UserAccessValue userAccessValue) {
		return this.getContinuityPlan(planId);
	}

	public List<Object[]> getSimpleContinuityPlanList(int systemDomainId) {
		return this.continuityPlanDAO.getSimpleListByOwnerId(systemDomainId);
	}

	public List<ContinuityPlan> getContinuityPlanList(int systemDomainId) {
		return this.continuityPlanDAO.getListByOwnerId(systemDomainId);
	}

	public List<ContinuityPlan> getContinuityPlanList(int systemDomainId,
			int start, int limit) {
		return this.continuityPlanDAO.getSubListByOwnerId(systemDomainId, start, limit);
	}

	public List<ContinuityPlan> getContinuityPlanList(int systemDomainId,
			SortByType sortBy, boolean isAscending) {
		return this.continuityPlanDAO.getSortedListByOwnerId(systemDomainId, sortBy, isAscending);
	}

	public List<ContinuityPlan> getContinuityPlanList(int systemDomainId,
			int start, int limit, SortByType sortBy, boolean isAscending) {
		return this.continuityPlanDAO.getSortedSubListByOwnerId(systemDomainId, start, limit, sortBy, isAscending);
	}
	
	public List<SimpleContinuityPlan> getSimpleContinuityPlanList(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return this.continuityPlanDAO.getSimpleSortedListByOwnerId(systemDomainId, sortBy, isAscending);
	}
	
	public List<SimpleContinuityPlan> getSimpleContinuityPlanList(int systemDomainId, int userId, SortByType sortBy, boolean isAscending) {
		return this.simpleContinuityPlanDAO.getSortedList(systemDomainId, userId, sortBy, isAscending);
	}
	
	public List<BaseContinuityPlan> getBaseContinuityPlanList(int systemDomainId, PlanStatus planStatus, SortByType sortBy, boolean isAscending) {
		return this.continuityPlanDAO.getBaseSortedListByOwnerId(systemDomainId, planStatus, sortBy, isAscending);
	}
	
	public long getContinuityPlanListSize(int systemDomainId, Acronym acronym, String name, int planId) {
		return this.continuityPlanDAO.getListSize(systemDomainId, acronym, name, planId);
	}
	
	@Override
	public long getContinuityPlanListBySystemDomainIdSize(int systemDomainId) {
		return this.continuityPlanDAO.getListBySystemDomainIdSize(systemDomainId);
	}

	public DepartmentInfo getDepartmentInfo(int planId) {
		return this.continuityPlanDAO.getDepartmentInfoById(planId);
	}

	public Map<User, PlanAccessTypeEnum> getUserAccessMap(int planId) {
		// init
		Map<User, PlanAccessTypeEnum> retMap = new HashMap<User, PlanAccessTypeEnum>();
		
		// get gatekeepers
		Map<User, Boolean> contactMap = this.continuityPlanDAO.getContacts(planId);
		if (contactMap != null && !contactMap.isEmpty()) {
			for (User contact : contactMap.keySet()) {
				retMap.put(contact, PlanAccessTypeEnum.GATEKEEPER);
			}
		}
		
		// get users
		Map<User, PlanAccessType> userAccessMap = this.continuityPlanDAO.getUserAccessMap(planId);
		if (userAccessMap != null && !userAccessMap.isEmpty()) {
			for (User user : userAccessMap.keySet()) {
				if (!retMap.containsKey(user)) {
					retMap.put(user, PlanAccessTypeEnum.getEnum(userAccessMap.get(user)));
				}
			}
		}
		
		// return
		return retMap;
	}

	public void updateContinuityPlan(ContinuityPlan plan, UserAccessValue userAccessValue) {
		List<User> departmentHead = new ArrayList<User>();
		departmentHead.add(plan.getDepartmentHead());	
		this.createUsers(plan, departmentHead, userAccessValue);			
		
		// update plan
		this.continuityPlanDAO.update(plan);
	}

	public void updateDepartmentInfo(int planId, DepartmentInfo departmentInfo) {
		this.continuityPlanDAO.updateDepartmentInfo(planId, departmentInfo);
	}

	public void updateStatus(int planId, PlanStatus status) {
		this.continuityPlanDAO.updateStatus(planId, status);
	}

	public void updateStatus(int planId, PlanStatus status, UserAccessValue userAccessValue) {
		this.updateStatus(planId, status);
	}

	@SuppressWarnings("unchecked")
	public void updateUserAccessMap(int planId, Map<User, PlanAccessTypeEnum> userAccessMap, UserAccessValue userAccessValue) {
		if (userAccessMap == null) return;
		// get plan
		ContinuityPlan plan = this.getContinuityPlan(planId);

		// get original users
		Set<User> oUsers = new HashSet<User>();
		Set<User> tempUsers = plan.getPlanUsers();
		if (tempUsers == null) tempUsers = new HashSet<User>();
		oUsers.addAll(tempUsers);
		
		// create users
		Set<User> newUsers = this.createUsers(plan, userAccessMap.keySet(), userAccessValue);
		
		// set plan users and gatekeepers
		plan.getUserAccessMap().clear();
		plan.getContacts().clear();
		Iterator userIter = userAccessMap.entrySet().iterator();
		while (userIter.hasNext()) {
			Map.Entry pairs = (Map.Entry) userIter.next();
			User userKey = (User) pairs.getKey();
			PlanAccessTypeEnum en = (PlanAccessTypeEnum) pairs.getValue();
			plan.addUserAccess(userKey, en.getRefDomainObject());
			if (PlanAccessTypeEnum.GATEKEEPER == en)
				plan.addContact(userKey, false);
		}
		
		// update plan
		this.continuityPlanDAO.update(plan);
		
		// new plan users
		Set<User> newPlanUsers = new HashSet<User>();
		newPlanUsers.addAll(plan.getPlanUsers());
		newPlanUsers.removeAll(oUsers);
		
		// send email
		this.sendEmailInvites(newPlanUsers, newUsers, plan, userAccessValue);
	}


	public ContinuityPlanDAO getContinuityPlanDAO() {
		return this.continuityPlanDAO;
	}

	public void setContinuityPlanDAO(ContinuityPlanDAO continuityPlanDAO) {
		this.continuityPlanDAO = continuityPlanDAO;
	}

	public UserService getUserService() {
		return this.userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private Set<User> createUsers(ContinuityPlan plan, Collection<User> users, UserAccessValue userAccessValue) {
		if (users == null) return null;
		Set<User> newUsers = new HashSet<User>();
		for (User user : users) {
			if (user == null) continue;
			Integer userId = user.getId();
			if (userId == null || userId == 0) {
				User testUser = this.userService.getBySystemDomainIdAndEmail(
					plan.getSystemDomain().getId(), user.getEmailRegular());
				if (testUser == null) {
					user.setSystemDomainId(plan.getSystemDomain().getId());
					this.userService.create(user, userAccessValue);
					newUsers.add(user);
				} else {
					user.setId(testUser.getId());
				}
			}
			if (plan.getUserAccess(user) == null)
				plan.addUserAccess(user, PlanAccessTypeEnum.FULL.getRefDomainObject());
		}
		return newUsers;
	}

	public EmailSenderService getEmailSenderService() {
		return this.emailSenderService;
	}
	
	public void setEmailSenderService(EmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}
	
	private void sendEmailInvites(Set<User> users, Set<User> newUsers, ContinuityPlan plan, UserAccessValue userAccessValue) {
		// get planner
		User planner = this.userService.getById(userAccessValue.getUserId());
		
		// is shib mode
		SystemDomain systemDomain = this.systemDomainService.getById(plan.getSystemDomain().getId());
		EmailMessageEnum emailMessageEnum = null;
		if (systemDomain.isShibMode())
			emailMessageEnum = EmailMessageEnum.ACCESS_PLAN_INVITE_SHIB;
		
		// new users
		if (newUsers != null && !newUsers.isEmpty()) {
			if (emailMessageEnum == null) emailMessageEnum = EmailMessageEnum.CREATE_USER_ACCOUNT_INVITE;
			this.sendEmailInvites(newUsers, plan, planner, emailMessageEnum, userAccessValue);
			// remove new users from existing set
			users.removeAll(newUsers);
		}
		
		// existing users
		if (users != null && !users.isEmpty()) {
			if (emailMessageEnum == null) emailMessageEnum = EmailMessageEnum.ACCESS_PLAN_INVITE;
			this.sendEmailInvites(users, plan, planner, emailMessageEnum, userAccessValue);
		}
	}
	
	private void sendEmailInvites(Set<User> users, ContinuityPlan plan, User planner, EmailMessageEnum emailMessageEnum, UserAccessValue userAccessValue) {
		// get emails
		int i = 0;
		String[] emails = new String[users.size()];
		for (User user : users)
			emails[i++] = user.getEmailRegular();
		
		// get moderators
		List<User> moderators = this.userService.getModeratorListBySystemDomainId(plan.getSystemDomain().getId());
		
		// set model
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("plan", plan);
		model.put("planner", planner);
		model.put("moderators", moderators);
		
		// send email
		this.emailSenderService.sendEmailMessage(plan.getSystemDomain().getId(), emails, emailMessageEnum, model, userAccessValue);
	}

	public SimpleContinuityPlanDAO getSimpleContinuityPlanDAO() {
		return this.simpleContinuityPlanDAO;
	}

	public void setSimpleContinuityPlanDAO(SimpleContinuityPlanDAO simpleContinuityPlanDAO) {
		this.simpleContinuityPlanDAO = simpleContinuityPlanDAO;
	}

	public CriticalFunctionService getCriticalFunctionService() {
		return this.criticalFunctionService;
	}

	public void setCriticalFunctionService(CriticalFunctionService criticalFunctionService) {
		this.criticalFunctionService = criticalFunctionService;
	}

	public InformationTechnologyService getInformationTechnologyService() {
		return this.informationTechnologyService;
	}

	public void setInformationTechnologyService(
			InformationTechnologyService informationTechnologyService) {
		this.informationTechnologyService = informationTechnologyService;
	}

	public KeyResourcesService getKeyResourcesService() {
		return this.keyResourcesService;
	}

	public void setKeyResourcesService(KeyResourcesService keyResourcesService) {
		this.keyResourcesService = keyResourcesService;
	}

	public SystemDomainService getSystemDomainService() {
		return this.systemDomainService;
	}

	public void setSystemDomainService(SystemDomainService systemDomainService) {
		this.systemDomainService = systemDomainService;
	}

}
