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

@Entity
@Table(name="key_team_members")
@NamedQuery(name="TeamMember.list",
		query="select dObj from TeamMember dObj where team.id = :ownerId")
@SuppressWarnings("serial")
public class TeamMember extends PlanPerson {
	
	private Team team;
	
	public TeamMember() {
	}

	@Id
	@Column(name="ktm_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		return super.getFirstName();
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return super.getLastName();
	}

	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="kt_id", nullable=false)
	public Team getTeam() {
		return this.team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}

}
