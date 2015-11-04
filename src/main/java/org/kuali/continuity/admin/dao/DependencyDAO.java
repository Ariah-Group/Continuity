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

import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface DependencyDAO extends BaseAdminOrderedDAO {
	
	void create(Dependency dependency);
	void update(Dependency dependency);
	void delete(int id);
	Dependency getById(int id);
	Dependency getBySystemDomainIdAndName(int systemDomainId, String name);
	Dependency getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	Dependency getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<Dependency> getListBySystemDomainId(int systemDomainId);
	List<Dependency> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<Dependency> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<Dependency> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
