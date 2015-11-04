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

import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface CentralApplicationDAO extends OrderingDef, BaseAdminOrderedDAO {
	
	void create(CentralApplication centralApplication);
	void update(CentralApplication centralApplication);
	void delete(int id);
	CentralApplication getById(int id);
	CentralApplication getBySystemDomainIdAndName(int systemDomainId, String name);
	CentralApplication getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	CentralApplication getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<CentralApplication> getListBySystemDomainId(int systemDomainId);
	List<CentralApplication> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<CentralApplication> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<CentralApplication> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
