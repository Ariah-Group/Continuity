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
package org.kuali.continuity.admin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.domain.AccessStatus;
import org.kuali.continuity.domain.AccessStatusEnum;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.domain.UserAccessValue;

@Entity(name="SystemDomainUser")
@Table(name="UserSecurity")
@NamedQueries({
	@NamedQuery(name="User.list",
		query="SELECT dObj FROM SystemDomainUser dObj WHERE dObj.systemDomainId = :systemDomainId"),
	@NamedQuery(name="User.size",
		query="SELECT COUNT(dObj) FROM SystemDomainUser dObj WHERE dObj.systemDomainId = :systemDomainId")
})
@NamedNativeQuery(name="User.unapproved.list", 
	query="SELECT usr.* FROM UserSecurity usr, SystemDomain domn " +
		"WHERE usr.institutionId = domn.institutionId " +
		"AND usr.institutionId = :systemDomainId " +
		"AND domn.authType = 0 " +
		"AND (usr.authId is not null AND usr.authId != '') " +
		"AND usr.modApprovedFlag is null",
	resultClass=User.class)
@SuppressWarnings("serial")
public class User extends BaseAdminDomainObject implements UserAccessValue {

	private String authId;					// login id
	private SecurityType securityType;
	private String firstName;
	private String lastName;
	private String workPhone;
	private String homePhone;
	private String cellPhone;
	private String emailRegular;
	private String emailBackup;
	private String workFax;
	private String title;
	private String departmentName;
	private String departmentOrg;
	private String departmentOrgHierarchy;
	private String workAddress;
	private String homeAddress;
	private AccessStatus accessStatus;
	private AccessStatus lockStatus;
	private Date dateCreated;
	private String affiliations;
	private Boolean isModApproved;
	private boolean isPasswordCaseInsensitive = true;
	private Boolean isInTestMode = false;
	
	public enum SortBy implements SortByType {
		id, name, emailRegular, workPhone, securityType, accessStatus, lastAndFirstName;
		public String getSortByValue() {
			String value = "";
			if (this == name)
				value = "firstName + ' ' + lastName";
			else if (this == securityType || this == accessStatus)
				value = this.name() + ".description";
			else if (this == lastAndFirstName)
				value = "lastName + ' ' + firstName";
			else
				value = this.name();
			return value;
		}
	};
	
	public User() {
		super();
	}
	
	public User(Integer id) {
		super(id);
	}
	
	@Id
	@Column(name="UserID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}

	@Transient
	public String getName() {
		return this.getFirstName() + " " + this.getLastName();
	}
	
	@Transient
	public String getFullName() {
		return this.getName();
	}
	
	@Column(name="InstitutionID")
	public Integer getSystemDomainId() {
		return super.getSystemDomainId();
	}
	
	public void setSystemDomainId(Integer systemDomainId) {
		super.setSystemDomainId(systemDomainId);
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

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getHomePhone() {
		return this.homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return this.cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getEmailRegular() {
		return this.emailRegular;
	}

	public void setEmailRegular(String emailRegular) {
		this.emailRegular = emailRegular;
	}

	public String getEmailBackup() {
		return this.emailBackup;
	}

	public void setEmailBackup(String emailBackup) {
		this.emailBackup = emailBackup;
	}

	public String getWorkFax() {
		return this.workFax;
	}

	public void setWorkFax(String workFax) {
		this.workFax = workFax;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	@ManyToOne
	@JoinColumn(name="AccessStatus", nullable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public AccessStatus getAccessStatus() {
		return this.accessStatus;
	}

	public void setAccessStatus(AccessStatus accessStatus) {
		this.accessStatus = accessStatus;
	}

	// this is now used to flag users with case insensitive passwords.
	// ucready users are flagged because their passwords are
	// case insensitive, while kualiready's passwords are case
	// sensitive.
	@ManyToOne
	@JoinColumn(name="LockStatus", nullable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public AccessStatus getLockStatus() {
		return this.lockStatus;
	}

	public void setLockStatus(AccessStatus lockStatus) {
		this.lockStatus = lockStatus;
	}

	@Column(name="createdDate", insertable=false, updatable=false)
	@Temporal(TemporalType.DATE)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getAffiliations() {
		return this.affiliations;
	}

	public void setAffiliations(String affiliations) {
		this.affiliations = affiliations;
	}

	@ManyToOne
	@JoinColumn(name="SecurityType", nullable=false)
	@Fetch(FetchMode.SELECT)
	public SecurityType getSecurityType() {
		return this.securityType;
	}

	public void setSecurityType(SecurityType securityType) {
		this.securityType = securityType;
	}

	@Override
	@Transient
	public Integer getUserId() {
		return this.getId();
	}

	@Column(name="AuthId")
	public String getAuthId() {
		return this.authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	@Column(name="ModApprovedFlag", insertable=false, updatable=false)
	public Boolean isModApproved() {
		return this.isModApproved;
	}

	public void setModApproved(Boolean isModApproved) {
		this.isModApproved = isModApproved;
	}

	@Column(name="SecurityAttribute")
	public boolean isPasswordCaseInsensitive() {
		return this.isPasswordCaseInsensitive;
	}
	
	public void setPasswordCaseInsensitive(boolean isPasswordCaseInsensitive) {
		this.isPasswordCaseInsensitive = isPasswordCaseInsensitive;
	}

	@Transient
	public Boolean isInTestMode() {
		return this.isInTestMode;
	}

	public void setInTestMode(Boolean isInTestMode) {
		this.isInTestMode = isInTestMode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((emailRegular == null) ? 0 : emailRegular.toLowerCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailRegular == null) {
			if (other.emailRegular != null)
				return false;
		} else if (!emailRegular.equalsIgnoreCase(other.emailRegular))
			return false;
		return true;
	}

	@PrePersist
	@PreUpdate
	public void checkNullInserts() {
		if (this.getAffiliations() == null)
			this.setAffiliations("");
		if (this.getCellPhone() == null)
			this.setCellPhone("");
		if (this.getDepartmentName() == null)
			this.setDepartmentName("");
		if (this.getDepartmentOrg() == null)
			this.setDepartmentOrg("");
		if (this.getDepartmentOrgHierarchy() == null)
			this.setDepartmentOrgHierarchy("");
		if (this.getEmailBackup() == null)
			this.setEmailBackup("");
		if (this.getHomeAddress() == null)
			this.setHomeAddress("");
		if (this.getHomePhone() == null)
			this.setHomePhone("");
		if (this.getTitle() == null)
			this.setTitle("");
		if (this.getWorkAddress() == null)
			this.setWorkAddress("");
		if (this.getWorkFax() == null)
			this.setWorkFax("");
		if (this.getWorkPhone() == null)
			this.setWorkPhone("");
		if (this.getAccessStatus() == null)
			this.setAccessStatus(AccessStatusEnum.ON.getRefDomainObject());
		if (this.getLockStatus() == null)
			this.setLockStatus(AccessStatusEnum.OFF.getRefDomainObject());
		if (this.getSecurityType() == null)
			this.setSecurityType(SecurityTypeEnum.LOCAL_USER.getRefDomainObject());
	}

}
