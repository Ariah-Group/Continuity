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
import java.util.Map;

import org.kuali.continuity.admin.domain.User;

public interface UserLoginDAO {

	boolean authenticate(final int systemDomainId, final String authId, final String password);
	void changePassword(final int userId, final String password);
	void changePassword(int userId, String password, boolean setModApprovedFlag);
	String approveUserLogin(final User user, boolean isApproved);
	Map<User, String> approveUserLogins(final List<User> users, final boolean isApproved);
	String requestLoginPassword(final User user);

}
