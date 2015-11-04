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

import org.kuali.continuity.plan.domain.RestartProcedure;

public class RestartProcedureDTO {
	
	public String whereToPurchase;
	public String whenToRebuild;
	public String environmentalRequirements;
	public String techSupportStaff;
	public String otherObstacles;
	public String workFromHome;
	public String workAround;

	public RestartProcedureDTO() {
		
	}

	public RestartProcedureDTO(RestartProcedure rp) {
		if (rp == null) return;
		this.whereToPurchase = rp.getWhereToPurchase();
		this.whenToRebuild = rp.getWhenToRebuild();
		this.environmentalRequirements = rp.getEnvironmentalRequirements();
		this.techSupportStaff = rp.getTechSupportStaff();
		this.otherObstacles = rp.getOtherObstacles();
		this.workFromHome = rp.getWorkFromHome();
		this.workAround = rp.getWorkAround();
		
	}
	
	public RestartProcedure getRestartProcedure() {
		RestartProcedure rp = new RestartProcedure();
		rp.setWhereToPurchase(this.whereToPurchase);
		rp.setWhenToRebuild(this.whenToRebuild);
		rp.setEnvironmentalRequirements(this.environmentalRequirements);
		rp.setTechSupportStaff(this.techSupportStaff);
		rp.setOtherObstacles(this.otherObstacles);
		rp.setWorkFromHome(this.workFromHome);
		rp.setWorkAround(this.workAround);
		return rp;
	}

}
