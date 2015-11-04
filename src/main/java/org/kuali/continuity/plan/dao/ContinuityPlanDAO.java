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
package org.kuali.continuity.plan.dao;

import java.util.List;
import java.util.Map;

import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.domain.BaseContinuityPlan;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.DepartmentInfo;
import org.kuali.continuity.plan.domain.SimpleContinuityPlan;

public interface ContinuityPlanDAO {
	
	// plan
	void create(ContinuityPlan plan);
	void update(ContinuityPlan plan);
	void delete(int planId);
	ContinuityPlan getById(int planId);
	SimpleContinuityPlan getSimpleById(int planId);
	List<Object[]> getSimpleListByOwnerId(int systemDomainId);
	List<ContinuityPlan> getListByOwnerId(int systemDomainId);
	List<ContinuityPlan> getSubListByOwnerId(int systemDomainId, int start, int limit);
	List<ContinuityPlan> getSortedListByOwnerId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<ContinuityPlan> getSortedSubListByOwnerId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	List<SimpleContinuityPlan> getSimpleSortedListByOwnerId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<BaseContinuityPlan> getBaseSortedListByOwnerId(int systemDomainId, PlanStatus planStatus, SortByType sortBy, boolean isAscending);
	
	// plan
	long getListSize(int systemDomainId, Acronym acronym, String name, int planId);
	long getListBySystemDomainIdSize(int systemDomainId);
	
	// status
	void updateStatus(int planId, PlanStatus status);
	
	// organization data
	void updateOrganizationData(int planId, 
		String planName, 
		MajorDivision majorDivision, 
		Acronym acronym, 
		User departmentHead,
		Map<User, Boolean> contacts);
	
	// contacts
	void createContact(int planId, User user, boolean isPrimary);
	void updateContact(int planId, User user, boolean isPrimary);
	void deleteContact(int planId, User user);
	Map<User, Boolean> getContacts(int planId);
	
	// authorized users
	void createUserAccess(int planId, User user, PlanAccessType accessType);
	void updateUserAccess(int planId, User user, PlanAccessType accessType);
	void deleteUserAccess(int planId, User user);
	PlanAccessType getUserAccess(int planId, User user);
	Map<User, PlanAccessType> getUserAccessMap(int planId);
	
	// department info
	DepartmentInfo getDepartmentInfoById(int planId);	// TODO: remove when transaction is moved to service
	void updateDepartmentInfo(int planId, DepartmentInfo departmentInfo);

}
