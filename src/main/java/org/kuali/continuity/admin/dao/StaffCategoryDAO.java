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

import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface StaffCategoryDAO extends BaseAdminOrderedDAO {
	
	void create(StaffCategory staffCategory);
	void update(StaffCategory staffCategory);
	void delete(int id);
	StaffCategory getById(int id);
	StaffCategory getBySystemDomainIdAndName(int systemDomainId, String name);
	StaffCategory getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	StaffCategory getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<StaffCategory> getListBySystemDomainId(int systemDomainId);
	List<StaffCategory> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<StaffCategory> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<StaffCategory> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
