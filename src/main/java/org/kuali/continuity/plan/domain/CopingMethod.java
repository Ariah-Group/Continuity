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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class CopingMethod implements Serializable {
	
	private String space;
	private String equipment;
	private String staff;
	private String uniqueSkills;
	private String workAtHome;
	private String networkAccess;
	private String showStoppers;
	private String risk;
	private String policyExceptions;
	private String timing;
	private String vulnerabilities;
	private String comment;
	private String campusClosure;
	
	public CopingMethod() {
		this.init();
	}
	
	@Column(name="how_space")
	public String getSpace() {
		return this.space;
	}

	public void setSpace(String space) {
		this.space = space;
	}

	@Column(name="how_equipment")
	public String getEquipment() {
		return this.equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	@Column(name="how_staff")
	public String getStaff() {
		return this.staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	@Column(name="how_unique_skills")
	public String getUniqueSkills() {
		return this.uniqueSkills;
	}

	public void setUniqueSkills(String uniqueSkills) {
		this.uniqueSkills = uniqueSkills;
	}

	@Column(name="how_work_at_home")
	public String getWorkAtHome() {
		return this.workAtHome;
	}

	public void setWorkAtHome(String workAtHome) {
		this.workAtHome = workAtHome;
	}

	@Column(name="how_network_access")
	public String getNetworkAccess() {
		return this.networkAccess;
	}

	public void setNetworkAccess(String networkAccess) {
		this.networkAccess = networkAccess;
	}

	@Column(name="how_show_stoppers")
	public String getShowStoppers() {
		return this.showStoppers;
	}

	public void setShowStoppers(String showStoppers) {
		this.showStoppers = showStoppers;
	}

	@Column(name="how_risk")
	public String getRisk() {
		return this.risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	@Column(name="how_policy_exceptions")
	public String getPolicyExceptions() {
		return this.policyExceptions;
	}

	public void setPolicyExceptions(String policyExceptions) {
		this.policyExceptions = policyExceptions;
	}

	@Column(name="how_timing")
	public String getTiming() {
		return this.timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}

	@Column(name="how_additional_vulnerabilities")
	public String getVulnerabilities() {
		return this.vulnerabilities;
	}

	public void setVulnerabilities(String vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}

	@Column(name="comment")
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name="how_campus_closure")
	public String getCampusClosure() {
		return this.campusClosure;
	}

	public void setCampusClosure(String campusClosure) {
		this.campusClosure = campusClosure;
	}
	
	private void init() {
		this.setCampusClosure("");
		this.setComment("");
		this.setEquipment("");
		this.setNetworkAccess("");
		this.setPolicyExceptions("");
		this.setRisk("");
		this.setShowStoppers("");
		this.setSpace("");
		this.setStaff("");
		this.setTiming("");
		this.setUniqueSkills("");
		this.setVulnerabilities("");
		this.setWorkAtHome("");
	}
}