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

import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface ShiftDAO extends BaseAdminOrderedDAO {
	
	void create(Shift shift);
	void update(Shift shift);
	void delete(int id);
	Shift getById(int id);
	Shift getBySystemDomainIdAndName(int systemDomainId, String name);
	Shift getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	Shift getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<Shift> getListBySystemDomainId(int systemDomainId);
	List<Shift> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<Shift> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<Shift> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
