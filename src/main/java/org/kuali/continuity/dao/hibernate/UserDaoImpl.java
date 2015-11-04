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
package org.kuali.continuity.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.kuali.continuity.domain.User;
import org.kuali.continuity.domain.valueobject.UserListValue;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

@Deprecated
public  class UserDaoImpl extends HibernateDaoSupport  {

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	public void create(User user) {
		logger.info("Performing create:" + user.getUserId());
		if (user != null) {
			getHibernateTemplate().saveOrUpdate(user);
			getHibernateTemplate().flush();
		}
	}

	public void delete(int id) {
		logger.info("Performing delete:" + id);
		if (id > 0) {
			User user = (User) getHibernateTemplate().get(User.class, id);
			logger.info("Retrieved user:" + user.getUserId());
			if (user != null) {

				getHibernateTemplate().delete(user);
				getHibernateTemplate().flush();
				logger.info("Deleted user.");
			}
		}

	}

	public User get(int id) {
		User user = null;

		user = (User) getHibernateTemplate().get(User.class, id);
		return user;

	}

	public List<User> list(int institutionId)

	throws DataAccessException {
		return getHibernateTemplate().findByNamedParam(
				"from User u where u.institutionId  = :institutionId",
				"institutionId", institutionId);

	}

	public void update(User updates) {
		logger.info("Performing update:" + updates.getUserId());
	
		if (updates != null) {
			logger.info("doing save");
			try {
				getHibernateTemplate().update(updates);
				getHibernateTemplate().flush();
			} catch (Exception e) {
				System.out.println("Unable to do save. " + e);
				logger.warn("Exception while doing save: ", e);
				e.printStackTrace();
			}
		}
		logger.info("Update done:" + updates.getUserId());

	}

	public List<UserListValue> valueList(int institutionId)
			throws DataAccessException {

		List<User> userlist = getHibernateTemplate().findByNamedParam(
				"from User u where u.institutionId  = :institutionId",
				"institutionId", institutionId);
		ArrayList userValueList = new ArrayList();
		for (User u : userlist) {

			UserListValue uv = new UserListValue();
			uv.setUserListValue(u);

			userValueList.add(uv);

		}
		return userValueList;
	}
	public List<UserListValue> valueList(int institutionId, int limit)
	throws DataAccessException {
		List<User> userlist = getHibernateTemplate().findByNamedParam(
				"from User u where u.institutionID  = :institutionId",
				"institutionId", institutionId);
		ArrayList userValueList = new ArrayList();
		int i=0;
		for (User u : userlist ) {

			UserListValue uv = new UserListValue();
			uv.setUserListValue(u);

			userValueList.add(uv);
			i++;
			if (i>=limit) {
				break;
			}

		}
		return userValueList;
		
	}
	
	public List<UserListValue> valueListBy(int institutionId, String seq, int limit)
	throws DataAccessException {
		List<User> userlist = getHibernateTemplate().findByNamedParam(
				"from User u where u.institutionID  = :institutionId",
				"institutionId ORDER BY "+seq, institutionId);
		ArrayList userValueList = new ArrayList();
		int i=0;
		for (User u : userlist ) {

			UserListValue uv = new UserListValue();
			uv.setUserListValue(u);

			userValueList.add(uv);
			i++;
			if (i>=limit) {
				break;
			}

		}
		return userValueList;
		
	}

}
