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
package org.kuali.continuity.dao;

import java.util.List;

import org.kuali.continuity.domain.User;
import org.kuali.continuity.domain.valueobject.UserListValue;

@Deprecated
public interface UserDao {
	void create(User user);
	void update(User user);
	void delete(int id);
	User get(int id);
	List<User> list(int institutionId);
	List<UserListValue> valueList(int institutionId);
	List<UserListValue> valueList(int institutionId, int limit);
	List<UserListValue> valueListBy(int institutionId, String seq, int limit, String dir);
}
