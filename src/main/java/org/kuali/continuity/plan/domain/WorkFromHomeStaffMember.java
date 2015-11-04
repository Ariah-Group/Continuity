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
import org.kuali.continuity.domain.BroadbandConnection;
import org.kuali.continuity.domain.ComputerRunning;
import org.kuali.continuity.domain.ConnectFromHome;
import org.kuali.continuity.domain.StaffPosition;

@Entity
@Table(name="key_work_home")
@NamedQuery(name="WorkFromHomeStaffMember.list",
		query="select dObj from WorkFromHomeStaffMember dObj where plan.id = :ownerId and disabled != 'Y'")
@SuppressWarnings("serial")
public class WorkFromHomeStaffMember extends PlanPerson {
	
	private ContinuityPlan plan;
	private StaffPosition staffPosition;
	private BroadbandConnection hasBroadbandConnection;
	private ConnectFromHome doesConnectFromHome;
	private ComputerRunning mustOfficeComputerRunning;
	private String comment;
	
	public WorkFromHomeStaffMember() {
	}

	@Id
	@Column(name="wh_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	public String getName() {
		return super.getName();
	}
	
	public void setName(String name) {
		super.setName(name);
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}
	
	@ManyToOne
	@JoinColumn(name="institution_position")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public StaffPosition getStaffPosition() {
		return this.staffPosition;
	}

	public void setStaffPosition(StaffPosition staffPosition) {
		this.staffPosition = staffPosition;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@ManyToOne
	@JoinColumn(name="broadband_connection")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public BroadbandConnection getHasBroadbandConnection() {
		return this.hasBroadbandConnection;
	}

	public void setHasBroadbandConnection(BroadbandConnection hasBroadbandConnection) {
		this.hasBroadbandConnection = hasBroadbandConnection;
	}

	@ManyToOne
	@JoinColumn(name="currently_does")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public ConnectFromHome getDoesConnectFromHome() {
		return this.doesConnectFromHome;
	}

	public void setDoesConnectFromHome(ConnectFromHome doesConnectFromHome) {
		this.doesConnectFromHome = doesConnectFromHome;
	}

	@ManyToOne
	@JoinColumn(name="office_pc_must_on")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public ComputerRunning getMustOfficeComputerRunning() {
		return this.mustOfficeComputerRunning;
	}

	public void setMustOfficeComputerRunning(ComputerRunning mustOfficeComputerRunning) {
		this.mustOfficeComputerRunning = mustOfficeComputerRunning;
	}
	
	
}
