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

import java.util.List;
import java.util.Map;

import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.UserAccessValue;
import org.kuali.continuity.plan.domain.BaseContinuityPlan;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.DepartmentInfo;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;

public interface ContinuityPlanService {

	// plan
	void createContinuityPlan(ContinuityPlan plan, UserAccessValue userAccessValue);
	void updateContinuityPlan(ContinuityPlan plan, UserAccessValue userAccessValue);
	void deleteContinuityPlan(ContinuityPlan plan, UserAccessValue userAccessValue);
	
	// status
	void updateStatus(int planId, PlanStatus status);
	void updateStatus(int planId, PlanStatus status, UserAccessValue userAccessValue);
	
	// get
	ContinuityPlan getContinuityPlan(int planId);
	ContinuityPlan getContinuityPlan(int planId, UserAccessValue userAccessValue);

	// list
	List<Object[]> getSimpleContinuityPlanList(int systemDomainId);
	List<ContinuityPlan> getContinuityPlanList(int systemDomainId);
	List<ContinuityPlan> getContinuityPlanList(int systemDomainId, int start, int limit);
	List<ContinuityPlan> getContinuityPlanList(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<ContinuityPlan> getContinuityPlanList(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	List<SimpleContinuityPlan> getSimpleContinuityPlanList(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<SimpleContinuityPlan> getSimpleContinuityPlanList(int systemDomainId, int userId, SortByType sortBy, boolean isAscending);
	List<BaseContinuityPlan> getBaseContinuityPlanList(int systemDomainId, PlanStatus planStatus, SortByType sortBy, boolean isAscending);
	
	// list size
	long getContinuityPlanListSize(int systemDomainId, Acronym acronym, String name, int planId);
	long getContinuityPlanListBySystemDomainIdSize(int systemDomainId);

	// authorized users
	Map<User, PlanAccessTypeEnum> getUserAccessMap(int planId);
	void updateUserAccessMap(int planId, Map<User, PlanAccessTypeEnum> userAccessMap, UserAccessValue userAccessValue);
	
	// department info
	DepartmentInfo getDepartmentInfo(int planId);
	void updateDepartmentInfo(int planId, DepartmentInfo departmentInfo);
	
}
