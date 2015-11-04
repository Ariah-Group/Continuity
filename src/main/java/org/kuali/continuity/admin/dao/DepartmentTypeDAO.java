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

import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface DepartmentTypeDAO extends BaseAdminOrderedDAO {
	
	void create(DepartmentType departmentType);
	void update(DepartmentType departmentType);
	void delete(int id);
	DepartmentType getById(int id);
	DepartmentType getBySystemDomainIdAndName(int systemDomainId, String name);
	DepartmentType getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	DepartmentType getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<DepartmentType> getListBySystemDomainId(int systemDomainId);
	List<DepartmentType> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<DepartmentType> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<DepartmentType> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
