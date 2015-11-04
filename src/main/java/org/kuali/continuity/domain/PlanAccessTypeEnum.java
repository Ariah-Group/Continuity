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
package org.kuali.continuity.domain;

public enum PlanAccessTypeEnum implements RefEnum {

	FULL("2", "Full"), VIEW_ONLY("3", "View-Only"),
	GATEKEEPER("2", "Full");	// in application only, not in db
	
	private String id;
	private String description;

	PlanAccessTypeEnum(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public PlanAccessType getRefDomainObject() {
		PlanAccessType access = new PlanAccessType();
		access.setId(this.id);
		access.setDescription(this.description);
		return access;
	}
	
	public static PlanAccessTypeEnum getEnum(final PlanAccessType planAccessType) {
		if (FULL.getRefDomainObject().equals(planAccessType))
			return FULL;
		if (VIEW_ONLY.getRefDomainObject().equals(planAccessType))
			return VIEW_ONLY;
		if (GATEKEEPER.getRefDomainObject().equals(planAccessType))
			return GATEKEEPER;
		return null;
	}
	

}
