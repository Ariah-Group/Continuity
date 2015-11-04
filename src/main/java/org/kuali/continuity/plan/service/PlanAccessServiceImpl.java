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

import java.util.Map;

import org.kuali.continuity.admin.dao.SystemDomainDAO;
import org.kuali.continuity.admin.dao.UserDAO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.UserAccessValue;
import org.kuali.continuity.plan.dao.ContinuityPlanDAO;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;

public class PlanAccessServiceImpl implements PlanAccessService {
	
	private UserDAO userDAO;
	private ContinuityPlanDAO continuityPlanDAO;
	private SystemDomainDAO systemDomainDAO;
	private final static int createPlanId = -999;
	private int order = 1;
	
	public PlanAccessServiceImpl() {

	}
	
	public void checkReadAccess(int planId, UserAccessValue userAccessValue) throws PlanAccessException {
		if (!this.checkAccess(planId, userAccessValue.getUserId(), true))
			throw new PlanAccessException("You do not have read access to this plan.");
	}
	
	public void checkCreateAccess(UserAccessValue userAccessValue) throws PlanAccessException {
		if (!this.checkAccess(createPlanId, userAccessValue.getUserId(), false))
			throw new PlanAccessException("You do not have create access.");
	}
	
	public void checkUpdateAccess(int planId, UserAccessValue userAccessValue) throws PlanAccessException {
		if (!this.checkAccess(planId, userAccessValue.getUserId(), false))
			throw new PlanAccessException("You do not have update access to this plan.");
	}
	
	public void checkDeleteAccess(int planId, UserAccessValue userAccessValue) throws PlanAccessException {
		if (!this.checkAccess(planId, userAccessValue.getUserId(), false))
			throw new PlanAccessException("You do not have delete access to this plan.");
	}
	
	private boolean checkAccess(int planId, int userId, boolean isRead) {
		// get user
		User user = this.userDAO.getById(userId);
		if (user == null) return false;
		
		// test security type
		SecurityType securityType = user.getSecurityType();
		if (securityType == null) return false;
		
		// test create access
		if (planId == createPlanId) return true;
		
		// test system admin
		if (securityType.equals(SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject()))
			return true;
		
		// get plan
		SimpleContinuityPlan plan = this.continuityPlanDAO.getSimpleById(planId);
		if (plan == null) return false;
		
		// test institution admin
		if (securityType.equals(SecurityTypeEnum.INSTITUTION_ADMIN.getRefDomainObject())) {
			// compare system domain groups
			SystemDomain userSystemDomain = this.systemDomainDAO.getById(user.getSystemDomainId());
			String userSystemDomainGroup = userSystemDomain.getSystemDomainGroup();
			String planSystemDomainGroup = plan.getSystemDomain().getSystemDomainGroup();
			if (userSystemDomainGroup != null && planSystemDomainGroup != null &&
				!userSystemDomainGroup.trim().isEmpty() && !planSystemDomainGroup.trim().isEmpty() &&
				userSystemDomainGroup.equals(planSystemDomainGroup))
					return true;
		}
		
		// get system domain id
		int userSystemDomainId = user.getSystemDomainId();
		int planSystemDomainId = plan.getSystemDomain().getId();

		// test local admin
		if (securityType.equals(SecurityTypeEnum.LOCAL_ADMIN.getRefDomainObject()) &&
			userSystemDomainId == planSystemDomainId)
				return true;
		
		// get user access map
		Map<User, PlanAccessType> planAccessMap = plan.getUserAccessMap();
		if (planAccessMap == null || planAccessMap.isEmpty()) return false;
		
		// test plan access
		PlanAccessType planAccessType = planAccessMap.get(user);
		if (planAccessType != null && planAccessType.equals(PlanAccessTypeEnum.FULL.getRefDomainObject()))
			return true;
		
		// test readAccess
		// TODO: remove MODERATOR
		if (isRead) {
			if (planAccessType != null) return true;
			if ((securityType.equals(SecurityTypeEnum.UNIVERSAL_VIEWER.getRefDomainObject()) ||
				 securityType.equals(SecurityTypeEnum.MODERATOR.getRefDomainObject()))	&&
				userSystemDomainId == planSystemDomainId) return true;
		}
		
		// fail
		return false;
	}
	
	public UserDAO getUserDAO() {
		return this.userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public ContinuityPlanDAO getContinuityPlanDAO() {
		return this.continuityPlanDAO;
	}
	
	public void setContinuityPlanDAO(ContinuityPlanDAO continuityPlanDAO) {
		this.continuityPlanDAO = continuityPlanDAO;
	}

	@Override
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public void setSystemDomainDAO(SystemDomainDAO systemDomainDAO) {
		this.systemDomainDAO = systemDomainDAO;
	}

	public SystemDomainDAO getSystemDomainDAO() {
		return this.systemDomainDAO;
	}

}
