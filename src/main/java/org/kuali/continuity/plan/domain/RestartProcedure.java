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
public class RestartProcedure implements Serializable {
	
	private String whereToPurchase;
	private String whenToRebuild;
	private String environmentalRequirements;
	private String techSupportStaff;
	private String otherObstacles;
	private String workFromHome;
	private String workAround;
	
	@Column(name="it_howto_where", insertable=false)
	public String getWhereToPurchase() {
		return this.whereToPurchase;
	}
	
	public void setWhereToPurchase(String whereToPurchase) {
		this.whereToPurchase = whereToPurchase;
	}
	
	@Column(name="it_howto_when", insertable=false)
	public String getWhenToRebuild() {
		return this.whenToRebuild;
	}
	
	public void setWhenToRebuild(String whenToRebuild) {
		this.whenToRebuild = whenToRebuild;
	}
	
	@Column(name="it_howto_requirement", insertable=false)
	public String getEnvironmentalRequirements() {
		return this.environmentalRequirements;
	}
	
	public void setEnvironmentalRequirements(String environmentalRequirements) {
		this.environmentalRequirements = environmentalRequirements;
	}
	
	@Column(name="it_howto_staff", insertable=false)
	public String getTechSupportStaff() {
		return this.techSupportStaff;
	}
	
	public void setTechSupportStaff(String techSupportStaff) {
		this.techSupportStaff = techSupportStaff;
	}
	
	@Column(name="it_howto_other", insertable=false)
	public String getOtherObstacles() {
		return this.otherObstacles;
	}
	
	public void setOtherObstacles(String otherObstacles) {
		this.otherObstacles = otherObstacles;
	}
	
	@Column(name="it_howto_work_home", insertable=false)
	public String getWorkFromHome() {
		return this.workFromHome;
	}
	
	public void setWorkFromHome(String workFromHome) {
		this.workFromHome = workFromHome;
	}
	
	@Column(name="it_howto_cannot_work_around", insertable=false)
	public String getWorkAround() {
		return this.workAround;
	}
	
	public void setWorkAround(String workAround) {
		this.workAround = workAround;
	}
}
