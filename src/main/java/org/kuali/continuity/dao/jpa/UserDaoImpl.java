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
package org.kuali.continuity.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.kuali.continuity.dao.UserDao;

import org.kuali.continuity.domain.User;
import org.kuali.continuity.domain.valueobject.UserListValue;
import org.springframework.dao.DataAccessException;

@Deprecated
public class UserDaoImpl extends BaseDAOImpl implements UserDao {
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	public void create(User user) {
		this.getEntityManager().persist(user);
		
		//new org.kuali.continuity.dao.hibernate.UserDaoImpl().create(user);
	}

	public void update(User user) {
		this.getEntityManager().merge(user);
	}

	public void delete(int id) {
		if (id > 0) {
			User user = (User) get(id);
			logger.info("Retrieved user:" + user.getUserId());
			if (user != null) {

				delete(user);
			}
		}
	}
    public void delete(User user) {
    	this.getEntityManager().remove(user);
    	logger.info("Deleted user.");
    }
    
	public User get(int id) {
		return (User) this.getEntityManager().find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> list(int institutionId) {
		Query query = this
				.getEntityManager()
				.createQuery(
						""
								+ "SELECT OBJECT(u) FROM User u WHERE u.institutionId = :institutionId");
		query.setParameter("institutionId", institutionId);
		return (List<User>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> list(int institutionId, int limit) {
		// To do: Optimize query for SQL Server, add limit.

		Query query = this
				.getEntityManager()
				.createQuery(
						""
								+ "SELECT OBJECT(u) FROM User u WHERE u.institutionId = :institutionId");
		query.setParameter("institutionId", institutionId);
		return (List<User>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<User> listBy(int institutionId, String seq, int limit, String dir) {
		// To do: Optimize query for SQL Server, add limit.

		Query query = this
				.getEntityManager()
				.createQuery(
						""
								+ "SELECT OBJECT(u) FROM User u WHERE u.institutionId = :institutionId ORDER BY "
								+ seq+ " "+dir);
		query.setParameter("institutionId", institutionId);
		return (List<User>) query.getResultList();
	}

	public List<UserListValue> valueList(int institutionId) {
		List<User> userlist = this.list(institutionId);
		ArrayList<UserListValue> userValueList = new ArrayList<UserListValue>();
		for (User u : userlist) {
			UserListValue uv = new UserListValue();
			uv.setUserListValue(u);
			userValueList.add(uv);
		}
		return userValueList;
	}

	public List<UserListValue> valueList(int institutionId, int limit)
			throws DataAccessException {
		List<User> userlist = this.list(institutionId, limit);
		ArrayList userValueList = new ArrayList();
		int i = 0;
		for (User u : userlist) {

			UserListValue uv = new UserListValue();
			uv.setUserListValue(u);

			userValueList.add(uv);
			i++;
			if (i >= limit) {
				break;
			}

		}
		return userValueList;
	}

	public List<UserListValue> valueListBy(int institutionId, String seq,
			int limit, String dir) throws DataAccessException {
		List<User> userlist = this.listBy(institutionId, seq, limit,  dir);
		ArrayList userValueList = new ArrayList();
		int i = 0;
		for (User u : userlist) {

			UserListValue uv = new UserListValue();
			uv.setUserListValue(u);

			userValueList.add(uv);
			i++;
			if (i >= limit) {
				break;
			}

		}
		return userValueList;
	}
}
