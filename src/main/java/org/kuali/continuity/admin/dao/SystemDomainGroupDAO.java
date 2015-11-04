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

import org.kuali.continuity.admin.domain.SystemDomainGroup;
import org.kuali.continuity.dao.BaseSortableDomainObjectDAO;
import org.kuali.continuity.domain.SortByType;

public interface SystemDomainGroupDAO extends BaseSortableDomainObjectDAO {
	
	void create(SystemDomainGroup dObj);
	void update(SystemDomainGroup dObj);
	void delete(int id);
	SystemDomainGroup getById(int id);
	long getAllSize();
	List<SystemDomainGroup> getAll();
	List<SystemDomainGroup> getAll(SortByType sortBy, boolean isAscending);
	List<SystemDomainGroup> getAll(int start, int limit);
	List<SystemDomainGroup> getAll(int start, int limit, SortByType sortBy, boolean isAscending);	

}
