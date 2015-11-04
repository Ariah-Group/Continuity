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

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.kuali.continuity.domain.BaseDomainObject;

@Entity
@Table(name="key_teams")
@NamedQuery(name="Team.list",
		query="select dObj from Team dObj where plan.id = :ownerId")
@SuppressWarnings("serial")
public class Team extends BaseDomainObject {
	
	private ContinuityPlan plan;
	private String purpose;
	private String comment;
	private List<TeamMember> teamMembers;
	
	public Team() {
		super();
	}
	
	public Team(Integer id) {
		super(id);
	}

	@Id
	@Column(name="kt_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Column(name="team_name")
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

	@Column(name="team_purpose")
	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name="team_comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="kt_id", insertable=false, updatable=false)
	public List<TeamMember> getTeamMembers() {
		return this.teamMembers;
	}

	public void setTeamMembers(List<TeamMember> teamMembers) {
		this.teamMembers = teamMembers;
	}

}
