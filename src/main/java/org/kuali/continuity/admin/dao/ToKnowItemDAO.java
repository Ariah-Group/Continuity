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

import org.kuali.continuity.admin.domain.ToKnowItem;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface ToKnowItemDAO extends BaseAdminOrderedDAO {
	
	void create(ToKnowItem toKnowItem);
	void update(ToKnowItem toKnowItem);
	void delete(int id);
	ToKnowItem getById(int id);
	ToKnowItem getBySystemDomainIdAndName(int systemDomainId, String name);
	ToKnowItem getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	ToKnowItem getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<ToKnowItem> getListBySystemDomainId(int systemDomainId);
	List<ToKnowItem> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<ToKnowItem> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<ToKnowItem> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
