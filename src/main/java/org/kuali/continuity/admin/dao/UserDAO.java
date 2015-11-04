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

import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SortByType;

public interface UserDAO extends BaseAdminDAO, UserSearchDAO {
	
	void create(User user);
	void update(User user);
	void delete(int id);
	User getById(int id);
	User getBySystemDomainIdAndEmail(int systemDomainId, String email);
	User getBySystemDomainIdAndAuthId(int systemDomainId, String authId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<User> getListBySystemDomainId(int systemDomainId);
	List<User> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<User> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<User> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	List<User> getListBySystemDomainIdAndNames(int systemDomainId, String firstName, String lastName);
	List<User> getUnapprovedListBySystemDomainId(int systemDomainId);
	List<User> getListBySystemDomainIdAndSecurityType(int systemDomainId, SecurityType securityType);
	List<User> getSortedListBySystemDomainIdAndSecurityType(int systemDomainId, SecurityType securityType, SortByType sortBy, boolean isAscending);
	
}
