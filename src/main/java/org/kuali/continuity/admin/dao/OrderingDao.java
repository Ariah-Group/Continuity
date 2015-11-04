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

import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.domain.SortByType;

public interface OrderingDao extends OrderingDef {
	
	List getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo);
	List getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	BaseAdminOrderedDomainObject getBySystemDomainIdAndName(int institutionId, String name);
	BaseAdminOrderedDomainObject getBySystemDomainIdAndOrderNo(int institutionId, int orderNo );
	BaseAdminOrderedDomainObject getById(int id);
	BaseAdminOrderedDomainObject getHighestOrderedObjectBySystemDomainId(int institutionId);
	void update(BaseAdminOrderedDomainObject namedOrderedType);
	void create(BaseAdminOrderedDomainObject namedOrderedType);
	void delete(int id);

}
