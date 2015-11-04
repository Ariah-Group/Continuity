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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.domain.BaseDomainObject;

@Entity
@Table(name="key_staffing_req")
@NamedQuery(name="StaffingRequirement.list",
		query="select dObj from StaffingRequirement dObj where plan.id = :ownerId")
@SuppressWarnings("serial")
public class StaffingRequirement extends BaseDomainObject {
	
	private ContinuityPlan plan;
	private CriticalFunction criticalFunction;
	private StaffCategory staffCategory;
	private Shift shift;
	private float fteNormal;
	private float fteCrisis;
	
	public StaffingRequirement() {
	}

	@Id
	@Column(name="ksr_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="cid", nullable=false)
	public CriticalFunction getCriticalFunction() {
		return this.criticalFunction;
	}

	public void setCriticalFunction(CriticalFunction criticalFunction) {
		this.criticalFunction = criticalFunction;
	}

	@ManyToOne
	@JoinColumn(name="StaffCategoryID")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public StaffCategory getStaffCategory() {
		return this.staffCategory;
	}

	public void setStaffCategory(StaffCategory staffCategory) {
		this.staffCategory = staffCategory;
	}

	@ManyToOne
	@JoinColumn(name="ShiftID")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public Shift getShift() {
		return this.shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	@Column(name="FTE_normal")
	public float getFteNormal() {
		return this.fteNormal;
	}

	public void setFteNormal(float fteNormal) {
		this.fteNormal = fteNormal;
	}

	@Column(name="FTE_crisis")
	public float getFteCrisis() {
		return this.fteCrisis;
	}

	public void setFteCrisis(float fteCrisis) {
		this.fteCrisis = fteCrisis;
	}

}
