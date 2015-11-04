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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@SuppressWarnings("serial")
public class SystemDomainSettings implements Serializable {

	private boolean isTeamsScreenVisible;
	private boolean isSkillsScreenVisible;
	private boolean isStaffRequirementsScreenVisible;
	private boolean isCriticalFunctionsScreenVisible;
	private boolean isInstructionVisible;
	private boolean isCriticalLevelDetailsVisible;
	
	public SystemDomainSettings() {
	}

	@Column(name="TeamsScreenFlag")
	public boolean isTeamsScreenVisible() {
		return this.isTeamsScreenVisible;
	}

	public void setTeamsScreenVisible(boolean isTeamsScreenVisible) {
		this.isTeamsScreenVisible = isTeamsScreenVisible;
	}

	@Column(name="SkillsScreenFlag")
	public boolean isSkillsScreenVisible() {
		return this.isSkillsScreenVisible;
	}

	public void setSkillsScreenVisible(boolean isSkillsScreenVisible) {
		this.isSkillsScreenVisible = isSkillsScreenVisible;
	}

	@Column(name="StaffingScreenFlag")
	public boolean isStaffRequirementsScreenVisible() {
		return this.isStaffRequirementsScreenVisible;
	}

	public void setStaffRequirementsScreenVisible(
			boolean isStaffRequirementsScreenVisible) {
		this.isStaffRequirementsScreenVisible = isStaffRequirementsScreenVisible;
	}

	@Column(name="ExamplesScreenFlag")
	public boolean isCriticalFunctionsScreenVisible() {
		return this.isCriticalFunctionsScreenVisible;
	}

	public void setCriticalFunctionsScreenVisible(
			boolean isCriticalFunctionsScreenVisible) {
		this.isCriticalFunctionsScreenVisible = isCriticalFunctionsScreenVisible;
	}

	@Column(name="ReplaceStep4Flag")
	public boolean isInstructionVisible() {
		return this.isInstructionVisible;
	}

	public void setInstructionVisible(boolean isInstructionVisible) {
		this.isInstructionVisible = isInstructionVisible;
	}

	@Column(name="CriticalLvlDtlsFlag")
	public boolean isCriticalLevelDetailsVisible() {
		return this.isCriticalLevelDetailsVisible;
	}

	public void setCriticalLevelDetailsVisible(boolean isCriticalLevelDetailsVisible) {
		this.isCriticalLevelDetailsVisible = isCriticalLevelDetailsVisible;
	}

}
