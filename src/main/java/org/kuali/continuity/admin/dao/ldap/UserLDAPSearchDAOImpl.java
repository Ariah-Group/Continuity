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
package org.kuali.continuity.admin.dao.ldap;

import java.util.List;
import java.util.StringTokenizer;

import javax.naming.directory.SearchControls;

import org.kuali.continuity.admin.dao.UserSearchDAO;
import org.kuali.continuity.admin.domain.User;
import org.springframework.ldap.LimitExceededException;
import org.springframework.ldap.core.CollectingNameClassPairCallbackHandler;
import org.springframework.ldap.core.ContextMapper;
import org.springframework.ldap.core.ContextMapperCallbackHandler;
import org.springframework.ldap.core.DirContextAdapter;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.LikeFilter;

public class UserLDAPSearchDAOImpl implements UserSearchDAO {
	
	private LdapTemplate ldapTemplate;
	private SearchControls searchControls;
	private UserLDAPReturnAttributes returnAttributes;
	
	public UserLDAPSearchDAOImpl() {
		
	}

	public LdapTemplate getLdapTemplate() {
		return this.ldapTemplate;
	}

	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public UserLDAPReturnAttributes getReturnAttributes() {
		return this.returnAttributes;
	}

	public void setReturnAttributes(UserLDAPReturnAttributes returnAttributes) {
		this.returnAttributes = returnAttributes;
	}

	public SearchControls getSearchControls() {
		return this.searchControls;
	}

	public void setSearchControls(SearchControls searchControls) {
		this.searchControls = searchControls;
	}

	@SuppressWarnings("unchecked")
	public List<User> getListBySystemDomainIdAndNames(int systemDomainId,
			String firstNamePattern, String lastNamePattern) {
		
		// returning attributes
		this.getSearchControls().setReturningAttributes(this.getReturnAttributes().getReturnAttributesArray());
		this.getSearchControls().setReturningObjFlag(true);
		
		// filter
		AndFilter filter = new AndFilter();
		if (firstNamePattern != null && firstNamePattern.trim().length() != 0)
			filter.and(new LikeFilter(this.getReturnAttributes().getFirstName(), firstNamePattern+"*"));
		if (lastNamePattern != null && lastNamePattern.trim().length() != 0)
			filter.and(new LikeFilter(this.getReturnAttributes().getLastName(), lastNamePattern+"*"));

		// handler
		CollectingNameClassPairCallbackHandler handler = 
			new ContextMapperCallbackHandler(new UserContextMapper(this.getReturnAttributes(), systemDomainId, firstNamePattern, lastNamePattern));
		
		// sort keys
		String[] sortKeys = new String[2];
		sortKeys[0] = this.getReturnAttributes().getLastName();
		sortKeys[1] = this.getReturnAttributes().getFirstName();
		
		
		// search
		try {
			ldapTemplate.search(
				"",
				filter.encode(),
				this.getSearchControls(),
				handler,
				new MultiKeySortControlDirContextProcessor(sortKeys));
		} catch (LimitExceededException e) {
			// safely ignore. Spring LDAP handles this exception different to SUNs implementation.
		}

		// return list
		return (List<User>) handler.getList();
	}
	
	private static class UserContextMapper implements ContextMapper {
		
		private UserLDAPReturnAttributes attrs;
		private int systemDomainId;
		private String firstNamePattern;
		private String lastNamePattern;
		
		public UserContextMapper(UserLDAPReturnAttributes attrs, int systemDomainId, String firstNamePattern, String lastNamePattern) {
			this.attrs = attrs;
			this.firstNamePattern = firstNamePattern;
			this.lastNamePattern = lastNamePattern;
		}
		
		public Object mapFromContext(Object ctx) {
			
			DirContextAdapter context = (DirContextAdapter) ctx;
			
			// check directory user id
			String dirUserId = context.getStringAttribute(this.attrs.getDirUserId());
			if (dirUserId == null || dirUserId.trim().length() == 0) return null;
			
			// init user
			User user = new User();
//			user.setDirectoryId(dirUserId);
			user.setFirstName(context.getStringAttribute(this.attrs.getFirstName()));
			user.setLastName(context.getStringAttribute(this.attrs.getLastName()));
			user.setTitle(context.getStringAttribute(this.attrs.getTitle()));
			user.setEmailRegular(context.getStringAttribute(this.attrs.getEmailRegular()));
			user.setWorkPhone(context.getStringAttribute(this.attrs.getWorkPhone()));
			user.setWorkFax(context.getStringAttribute(this.attrs.getWorkFax()));
			user.setDepartmentName(context.getStringAttribute(this.attrs.getDepartmentName()));
			user.setDepartmentOrg(context.getStringAttribute(this.attrs.getDepartmentOrg()));
			user.setDepartmentOrgHierarchy(context.getStringAttribute(this.attrs.getDepartmentOrgHierarchy()));
//			user.setAuthId(context.getStringAttribute(this.attrs.getAuthId()));
			
			// fix
			user.setFirstName(fixName(user.getFirstName(), this.firstNamePattern));
			user.setLastName(fixName(user.getLastName(), this.lastNamePattern));
			user.setName(user.getFirstName() + " " + user.getLastName());
			user.setSystemDomainId(this.systemDomainId);
			if (user.getEmailRegular() != null) user.setEmailRegular(user.getEmailRegular().toLowerCase());
			return user;
		}

		private String fixName(String name, String startPattern) {
			
			String fixedName = "";
			
			// tokenize with delimiter
			if (startPattern == null || startPattern.trim().length() == 0) {
				StringTokenizer tzer = new StringTokenizer(name.trim(), ",");
				fixedName = tzer.nextToken().trim();
			} else {
				StringTokenizer tzer = new StringTokenizer(name.trim(), ",;");
				while (tzer.hasMoreTokens()) {
					String tempName = tzer.nextToken();
					if (tempName.trim().toLowerCase().startsWith(name.trim().toLowerCase())) {
						fixedName = tempName.trim(); 
						break;
					}
				}
			}
			
			// convert case
			if (fixedName != null && fixedName.trim().length() != 0) {
				StringBuffer buff = new StringBuffer();
				StringTokenizer tzer = new StringTokenizer(fixedName, " ");
				while (tzer.hasMoreTokens()) {
					String tempName = tzer.nextToken();
					buff.append(tempName.substring(0, 1) + tempName.substring(1).toLowerCase());
					buff.append(" ");
				}
				fixedName = buff.toString().trim();
			}
			
			return fixedName;
		}
	}
}
