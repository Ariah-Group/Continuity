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
package org.kuali.continuity.service;

import java.util.List;

import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.valueobject.UserListValue;

public interface RoleService extends ListService {

	List<SystemDomain> getInstitutions();
	List<String[]> getInstitutionValueList();
	List<User> getAllUsersbyInst(Integer institutionId);
	List<UserListValue> getUserValuesbyInst(Integer institutionId);
	List getUserValuesbyInst(Integer institutionId, int limit);
	List<User> getSortedUserValuesbyInst(Integer institutionId,  String osort, int limit, String dir);
	List<User> scrollForward(Integer institutionId, int nusers, Integer startafterId);
	List<User> scrollBackward(Integer institutionId, int nusers, Integer endingBeforeId);
    User getUser(int id);
	void updateUser(User user);
    void deleteUser(User user);
    void deleteUser(int id);
    void addUser(User user);

 }
