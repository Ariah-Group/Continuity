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

import java.util.ArrayList;
import java.util.List;

public class UserLDAPReturnAttributes {
	
	private String dirUserId;
	private String firstName;
	private String lastName;
	private String title;
	private String emailRegular;
	private String workPhone;
	private String workFax;
	private String departmentName;
	private String departmentOrg;
	private String departmentOrgHierarchy;
	private String authId;
	
	public UserLDAPReturnAttributes() {
	}

	public String getDirUserId() {
		return this.dirUserId;
	}

	public void setDirUserId(String dirUserId) {
		this.dirUserId = dirUserId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getEmailRegular() {
		return this.emailRegular;
	}
	
	public void setEmailRegular(String emailRegular) {
		this.emailRegular = emailRegular;
	}
	
	public String getWorkPhone() {
		return this.workPhone;
	}
	
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	public String getWorkFax() {
		return this.workFax;
	}
	
	public void setWorkFax(String workFax) {
		this.workFax = workFax;
	}
	
	public String getDepartmentName() {
		return this.departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentOrg() {
		return this.departmentOrg;
	}
	
	public void setDepartmentOrg(String departmentOrg) {
		this.departmentOrg = departmentOrg;
	}
	
	public String getDepartmentOrgHierarchy() {
		return this.departmentOrgHierarchy;
	}
	
	public void setDepartmentOrgHierarchy(String departmentOrgHierarchy) {
		this.departmentOrgHierarchy = departmentOrgHierarchy;
	}

	public String getAuthId() {
		return this.authId;
	}
	
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	
	public String[] getReturnAttributesArray() {
		List<String> list = new ArrayList<String>();
		if (this.getDirUserId() != null && this.getDirUserId().trim().length() != 0)
			list.add(this.getDirUserId());
		if (this.getFirstName() != null && this.getFirstName().trim().length() != 0)
			list.add(this.getFirstName());
		if (this.getLastName() != null && this.getLastName().trim().length() != 0)
			list.add(this.getLastName());
		if (this.getTitle() != null && this.getTitle().trim().length() != 0)
			list.add(this.getTitle());
		if (this.getEmailRegular() != null && this.getEmailRegular().trim().length() != 0)
			list.add(this.getEmailRegular());
		if (this.getWorkPhone() != null && this.getWorkPhone().trim().length() != 0)
			list.add(this.getWorkPhone());
		if (this.getWorkFax() != null && this.getWorkFax().trim().length() != 0)
			list.add(this.getWorkFax());
		if (this.getDepartmentName() != null && this.getDepartmentName().trim().length() != 0)
			list.add(this.getDepartmentName());
		if (this.getDepartmentOrg() != null && this.getDepartmentOrg().trim().length() != 0)
			list.add(this.getDepartmentOrg());
		if (this.getDepartmentOrgHierarchy() != null && this.getDepartmentOrgHierarchy().trim().length() != 0)
			list.add(this.getDepartmentOrgHierarchy());
		if (this.getAuthId() != null && this.getAuthId().trim().length() != 0)
			list.add(this.getAuthId());
		String[] attrs = null;
		if (list != null && !list.isEmpty()) {
			attrs = new String[list.size()];
			list.toArray(attrs);
		}
		return attrs;
	}

}