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
package org.kuali.continuity.plan.domain;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanStatus;
import org.kuali.continuity.domain.SortByType;

@Entity
@Table(name="plans")
@MappedSuperclass
@SuppressWarnings("serial")
public abstract class BaseContinuityPlan extends BaseDomainObject {

	private SystemDomain systemDomain;
	private MajorDivision majorDivision;
	private Acronym acronym;
	private PlanStatus status;
	
	// dates
	private Date lastModifiedDate;
	private Date createdDate;
	
	// users
	private Map<User, PlanAccessType> userAccessMap;
	
	// derived acronym + name
	private String acronymPlusName;

	public enum SortBy implements SortByType {
		id, name, acronymPlusName, access;
		public String getSortByValue() {
			return this.name();
		}
	}
	
	public BaseContinuityPlan() {
		super();
	}
	
	public BaseContinuityPlan(Integer id) {
		super(id);
	}

	@Id
	@Column(name="pid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="plan_name")
	public String getName() {
		return super.getName();
	}

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="InstitutionId", nullable=false)
	public SystemDomain getSystemDomain() {
		return this.systemDomain;
	}

	public void setSystemDomain(SystemDomain systemDomain) {
		this.systemDomain = systemDomain;
	}

	@Transient
	public MajorDivision getMajorDivision() {
		return this.majorDivision;
	}

	public void setMajorDivision(MajorDivision majorDivision) {
		this.majorDivision = majorDivision;
	}

	@Transient
	public Acronym getAcronym() {
		return this.acronym;
	}

	public void setAcronym(Acronym acronym) {
		this.acronym = acronym;
	}
	
	@ManyToOne
	@JoinColumn(name="status")
	@Fetch(FetchMode.SELECT)
	public PlanStatus getStatus() {
		return this.status;
	}

	public void setStatus(PlanStatus status) {
		this.status = status;
	}

	@Column(name="last_modified", insertable=false)
	@Temporal(TemporalType.DATE)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@Column(name="create_date", insertable=false, updatable=false)
	@Temporal(TemporalType.DATE)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Formula(
		"case when acronymid = 0 or acronymid is null then plan_name else " +
		"(select a.acronym from acronym a where a.acronymid = acronymid) + ' - ' + plan_name end")
	public String getAcronymPlusName() {
		if (acronymPlusName == null) {
			return (this.getAcronym() == null ? "" : 
				   (this.getAcronym().getName() == null ? "" : 
					this.getAcronym().getName() + " - ")) + this.getName();
		}
		return this.acronymPlusName;
	}

	public void setAcronymPlusName(String acronymPlusName) {
		this.acronymPlusName = acronymPlusName;
	}

	@Transient
	public Map<User, PlanAccessType> getUserAccessMap() {
		if (this.userAccessMap == null)
			this.setUserAccessMap(new HashMap<User, PlanAccessType>());
		return this.userAccessMap;
	}

	public void setUserAccessMap(Map<User, PlanAccessType> userAccessMap) {
		this.userAccessMap = userAccessMap;
	}
	
	public void addUserAccess(User user, PlanAccessType accessType) {
		this.getUserAccessMap().put(user, accessType);
	}
	
	public PlanAccessType getUserAccess(User user) {
		return this.getUserAccessMap().get(user);
	}
	
	public void removeUserAccess(User user) {
		this.getUserAccessMap().remove(user);
	}
	
	@Transient
	public Set<User> getPlanUsers() {
		return this.getUserAccessMap().keySet();
	}

}
