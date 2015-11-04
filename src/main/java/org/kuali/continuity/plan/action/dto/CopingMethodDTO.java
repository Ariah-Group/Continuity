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
package org.kuali.continuity.plan.action.dto;

import org.kuali.continuity.plan.domain.CopingMethod;

public class CopingMethodDTO {

	public String space;
	public String equipment;
	public String staff;
	public String uniqueSkills;
	public String workAtHome;
	public String networkAccess;
	public String showStoppers;
	public String risk;
	public String policyExceptions;
	public String timing;
	public String vulnerabilities;
	public String comment;
	public String campusClosure;
	
	public CopingMethodDTO() {
		
	}
	
	public CopingMethodDTO(CopingMethod copingMethod) {
		if (copingMethod == null) return;
		this.space = copingMethod.getSpace();
		this.equipment = copingMethod.getEquipment();
		this.staff = copingMethod.getStaff();
		this.uniqueSkills = copingMethod.getUniqueSkills();
		this.workAtHome = copingMethod.getWorkAtHome();
		this.networkAccess = copingMethod.getNetworkAccess();
		this.showStoppers = copingMethod.getShowStoppers();
		this.risk = copingMethod.getRisk();
		this.policyExceptions = copingMethod.getPolicyExceptions();
		this.timing = copingMethod.getTiming();
		this.vulnerabilities = copingMethod.getVulnerabilities();
		this.comment = copingMethod.getComment();
		this.campusClosure = copingMethod.getCampusClosure();
	}
	
	public CopingMethod getCopingMethod() {
		CopingMethod copingMethod = new CopingMethod();
		copingMethod.setSpace(this.space);
		copingMethod.setEquipment(this.equipment);
		copingMethod.setStaff(this.staff);
		copingMethod.setUniqueSkills(this.uniqueSkills);
		copingMethod.setWorkAtHome(this.workAtHome);
		copingMethod.setNetworkAccess(this.networkAccess);
		copingMethod.setShowStoppers(this.showStoppers);
		copingMethod.setRisk(this.risk);
		copingMethod.setPolicyExceptions(this.policyExceptions);
		copingMethod.setTiming(this.timing);
		copingMethod.setVulnerabilities(this.vulnerabilities);
		copingMethod.setComment(this.comment);
		copingMethod.setCampusClosure(this.campusClosure);
		return copingMethod;
	}

}
