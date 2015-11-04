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

import java.util.Map;

@Deprecated
public class UserSearchDAOFactoryImpl implements UserSearchDAOFactory {
	
	private Map<Integer, UserSearchDAO> userSearchDAOMap;
	private UserSearchDAO defaultUserSearchDAO;
	
	public UserSearchDAOFactoryImpl() {
		
	}

	public Map<Integer, UserSearchDAO> getUserSearchDAOMap() {
		return this.userSearchDAOMap;
	}

	public void setUserSearchDAOMap(Map<Integer, UserSearchDAO> userSearchDAOMap) {
		this.userSearchDAOMap = userSearchDAOMap;
	}

	public UserSearchDAO getDefaultUserSearchDAO() {
		return this.defaultUserSearchDAO;
	}

	public void setDefaultUserSearchDAO(UserSearchDAO defaultUserSearchDAO) {
		this.defaultUserSearchDAO = defaultUserSearchDAO;
	}

	public UserSearchDAO getUserSearchDAO(int systemDomainId) {
		UserSearchDAO userSearchDAO = this.getUserSearchDAOMap().get(systemDomainId);
		if (userSearchDAO == null) userSearchDAO = this.getDefaultUserSearchDAO();
		return userSearchDAO;
	}

}
