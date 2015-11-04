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

import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface InstructionalDepartmentDAO  extends BaseAdminDAO {
	
	void create(InstructionalDepartment instructionalDepartment);
	void update(InstructionalDepartment instructionalDepartment);
	void delete(int id);
	InstructionalDepartment getById(int id);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<InstructionalDepartment> getListBySystemDomainId(int systemDomainId);
	List<InstructionalDepartment> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<InstructionalDepartment> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<InstructionalDepartment> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}