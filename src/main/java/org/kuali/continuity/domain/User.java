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
package org.kuali.continuity.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserSecurity")
@SuppressWarnings("serial")
// Used by UI.
public class User implements Serializable {
	
	private Integer userId;
	private String authId;
	private Integer institutionId;
	private String securityType;
	private String firstName;
	private String lastName;
	private String workPhone;
	private String homePhone;
	private String cellPhone;
	private String emailregular;
	private String emailbackup;
	private String workFax;
	private String title;
	private String departmentName;
	private String departmentOrg;
	private String departmentOrgHierarchy;
	private String workAddress;
	private String homeAddress;
	private String accessStatus;
	private String lockStatus;
	private String directoryId;
	private String password;
	


	public User() {};
	

	@Id
	@Column(name="UserID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getAuthId() {
		return authId;
	}
	
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	
	public Integer getInstitutionId() {
		return institutionId;
	}
	
	public void setInstitutionId(Integer institutionId) {
		this.institutionId = institutionId;
	}
	
	public String getSecurityType() {
		return securityType;
	}
	
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getWorkPhone() {
		return workPhone;
	}
	
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	
	public String getHomePhone() {
		return homePhone;
	}
	
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	
	public String getCellPhone() {
		return cellPhone;
	}
	
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	public String getEmailregular() {
		return emailregular;
	}
	
	public void setEmailregular(String emailregular) {
		this.emailregular = emailregular;
	}
	
	public String getEmailbackup() {
		return emailbackup;
	}
	
	public void setEmailbackup(String emailbackup) {
		this.emailbackup = emailbackup;
	}
	
	@Column(name="WorkFAX")
	public String getWorkFax() {
		return workFax;
	}
	
	public void setWorkFax(String workFax) {
		this.workFax = workFax;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public String getDepartmentOrg() {
		return departmentOrg;
	}
	
	public void setDepartmentOrg(String departmentOrg) {
		this.departmentOrg = departmentOrg;
	}
	
	public String getDepartmentOrgHierarchy() {
		return departmentOrgHierarchy;
	}
	
	public void setDepartmentOrgHierarchy(String departmentOrgHierarchy) {
		this.departmentOrgHierarchy = departmentOrgHierarchy;
	}
	
	public String getWorkAddress() {
		return workAddress;
	}
	
	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}
	
	public String getHomeAddress() {
		return homeAddress;
	}
	
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	
	public String getAccessStatus() {
		return accessStatus;
	}
	
	public void setAccessStatus(String accessStatus) {
		this.accessStatus = accessStatus;
	}
	
	public String getLockStatus() {
		return lockStatus;
	}
	
	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public String getDirectoryId() {
		return directoryId;
	}
	
	public void setDirectoryId(String directoryId) {
		this.directoryId = directoryId;
	}	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
