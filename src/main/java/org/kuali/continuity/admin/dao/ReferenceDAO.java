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

import org.kuali.continuity.admin.domain.Reference;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface ReferenceDAO extends BaseAdminOrderedDAO {
	
	void create(Reference reference);
	void update(Reference reference);
	void delete(int id);
	Reference getById(int id);
	Reference getBySystemDomainIdAndName(int systemDomainId, String name);
	Reference getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	Reference getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<Reference> getListBySystemDomainId(int systemDomainId);
	List<Reference> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<Reference> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<Reference> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
