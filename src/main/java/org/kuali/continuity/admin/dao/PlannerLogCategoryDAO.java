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
package org.kuali.continuity.admin.dao;

import java.util.List;

import org.kuali.continuity.admin.domain.PlannerLogCategory;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface PlannerLogCategoryDAO extends BaseAdminOrderedDAO {
	
	void create(PlannerLogCategory plannerLogCategory);
	void update(PlannerLogCategory plannerLogCategory);
	void delete(int id);
	PlannerLogCategory getById(int id);
	PlannerLogCategory getBySystemDomainIdAndName(int systemDomainId, String name);
	PlannerLogCategory getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	PlannerLogCategory getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<PlannerLogCategory> getListBySystemDomainId(int systemDomainId);
	List<PlannerLogCategory> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<PlannerLogCategory> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<PlannerLogCategory> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
