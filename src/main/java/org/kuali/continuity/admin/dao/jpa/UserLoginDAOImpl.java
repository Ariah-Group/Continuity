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
package org.kuali.continuity.admin.dao.jpa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.apache.commons.codec.binary.Hex;
import org.kuali.continuity.admin.dao.UserLoginDAO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.util.PasswordGenerator;

public class UserLoginDAOImpl extends BaseDAOImpl implements UserLoginDAO {
	
	// Note: SecurityAttribute is used to flag passwords as case insensitive
	// Users migrated from UCReady have passwords that are case insensitive.
	// Current KualiReady users have their passwords validated with case
	// sensitivity on.  Because of KCP 300, Future KualiReady users and future
	// change in passwords by any user will result in case insensitive
	// password validation.
	private final static String AUTH_QUERY = 
		"SELECT UserID, Password, SecurityAttribute FROM UserSecurity " + 
		 "WHERE InstitutionID = :systemDomainId " +
		   "AND AuthID = :authId ";
	private final static String APPROVE_USER_QUERY = 
		"UPDATE UserSecurity " +
		   "SET ModApprovedFlag = :isApproved, " +
		       "SecurityAttribute = 1, " +
		       "Password = :password " +
		 "WHERE UserID = :userId";
	private final static String APPROVE_USER_QUERY_NO_APPROVED = 
		"UPDATE UserSecurity " +
		   "SET SecurityAttribute = 1, " +
		       "Password = :password " +
		 "WHERE UserID = :userId";
	
	@Override
	public boolean authenticate(final int systemDomainId, final String authId,
			final String password) {
		// return if null
		if (systemDomainId == 0 || 
			authId == null || authId.trim().length() == 0 ||
			password == null || password.trim().length() == 0)
			return false;
		
		// query
		Query query = this.getEntityManager().createNativeQuery(AUTH_QUERY);
		query.setParameter("systemDomainId", systemDomainId);
		query.setParameter("authId", authId);
		
		// return
		try {
			String pw = password;
			Object[] obj = (Object[]) query.getSingleResult();
			final String storedPasswordHash = (String) obj[1];
			final Integer passwordCaseSensitive = (Integer) obj[2];
			final String passwordHash = 
				((new Integer(1)).equals(passwordCaseSensitive)) ?
				this.getCaseInsensitivePasswordHash(pw) :
				this.getPasswordHash(pw);
			return passwordHash.equals(storedPasswordHash);
		} catch (NoResultException e) {
			return false;
		} catch (NonUniqueResultException e) {
			return false;
		}
	}

	@Override
	public void changePassword(final int userId, final String password) {
		// get hash
		final String passwordHash = this.getCaseInsensitivePasswordHash(password);
		
		// query
		Query query = this.getEntityManager().createNativeQuery(APPROVE_USER_QUERY);
		query.setParameter("password", passwordHash);
		query.setParameter("userId", userId);
		query.setParameter("isApproved", '1');
		
		// update
		query.executeUpdate();
	}
	
	@Override
	public void changePassword(final int userId, final String password, boolean setModApprovedFlag) {
		// get hash
		final String passwordHash = this.getCaseInsensitivePasswordHash(password);
		
		// query
		Query query = null;
		if(setModApprovedFlag){
			query = this.getEntityManager().createNativeQuery(APPROVE_USER_QUERY);
		} else{
			query = this.getEntityManager().createNativeQuery(APPROVE_USER_QUERY_NO_APPROVED);
		}
		
		query.setParameter("password", passwordHash);
		query.setParameter("userId", userId);
		
		if(setModApprovedFlag){
			query.setParameter("isApproved", '1');
		}
		
		// update
		query.executeUpdate();
	}
	
	@Override
	public String approveUserLogin(final User user, boolean isApproved) {
		Query query = this.getEntityManager().createNativeQuery(APPROVE_USER_QUERY) ;
		return this.approveUserLogin(user, isApproved, query);
	}

	@Override
	public Map<User, String> approveUserLogins(final List<User> users, final boolean isApproved) {
		if (users == null || users.isEmpty()) return null;

		Query query = this.getEntityManager().createNativeQuery(APPROVE_USER_QUERY) ;
		Map<User, String> userPasswordMap = new HashMap<User, String>();

		// iterate
		for (User user : users) {
			String password = this.approveUserLogin(user, isApproved, query);
			userPasswordMap.put(user, password);
		}
		
		// return
		return userPasswordMap;
	}
	
	private String approveUserLogin(final User user, final boolean isApproved, Query approveUserQuery) {
		// generate password
		String password = null;
		String passwordHash = "";
		if (isApproved) {
			password = PasswordGenerator.generate(user.getFullName());
			passwordHash = this.getCaseInsensitivePasswordHash(password);
		}
		
		// update
		approveUserQuery.setParameter("userId", user.getId());
		approveUserQuery.setParameter("password", passwordHash);
		approveUserQuery.setParameter("isApproved", isApproved ? '1' : '0');
		approveUserQuery.executeUpdate();
		
		// return
		return password;
	}
	
	@Override
	public String requestLoginPassword(final User user) {
		String password  = PasswordGenerator.generate(user.getFullName());
		this.changePassword(user.getId(), password);
		return password;
	}
	
	private String getCaseInsensitivePasswordHash(String password) {
		if (password == null || password.trim().length() == 0) return password;
		return this.getPasswordHash(password.toLowerCase());
	}

	private String getPasswordHash(String password) {
		if (password == null || password.trim().length() == 0) return password;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA");
			digest.reset();
			byte[] input = digest.digest(password.getBytes());
			return Hex.encodeHexString(input).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO: refactor
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
