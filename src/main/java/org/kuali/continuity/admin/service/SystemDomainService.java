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
package org.kuali.continuity.admin.service;

import java.util.List;
import java.util.Set;

import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.SystemDomainSettings;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.service.SystemNameService;

public interface SystemDomainService extends SystemNameService {

	void create(SystemDomain systemDomain);
	void update(SystemDomain systemDomain);
	void update(int id, SystemDomainSettings settings);
	void update(int id, Set<String> domains);
	void delete(int id);
	SystemDomain getById(int id);
	SystemDomain getByGroupAndName(String systemDomainGroup, String name);

	long getListByGroupSize(String systemDomainGroup);
	List<SystemDomain> getListByGroup(String systemDomainGroup);
	List<SystemDomain> getListByShibIDP(String shibIDP);
	List<SystemDomain> getShibListByIDPAuthType(String shibIDP);
	List<SystemDomain> getSubListByGroup(String systemDomainGroup, int start, int limit);
	List<SystemDomain> getSortedListByGroup(String systemDomainGroup, SortByType sortBy,
			boolean isAscending);
	List<SystemDomain> getSortedSubListByGroup(String systemDomainGroup, int start, int limit,
			SortByType sortBy, boolean isAscending);
	List<SystemDomain> getListByCustomUrl(String url);
	long getAllSize();
	List<SystemDomain> getAll();
	List<SystemDomain> getAll(SortByType sortBy, boolean isAscending);
	List<SystemDomain> getAll(int start, int limit);
	List<SystemDomain> getAll(int start, int limit, SortByType sortBy, boolean isAscending);

	List<SystemDomain> getAllByLogin(boolean isShib);
}
