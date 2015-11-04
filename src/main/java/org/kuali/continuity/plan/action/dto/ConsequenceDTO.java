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

import org.kuali.continuity.plan.domain.Consequence;

public class ConsequenceDTO {
	
	public boolean isMayOccur;
	public String explanation = "";
	
	public ConsequenceDTO() {
		
	}
	
	public ConsequenceDTO(Consequence consequence) {
		if (consequence == null) return;
		this.isMayOccur = consequence.isMayOccur();
		this.explanation = consequence.getExplanation();
	}

	public Consequence getConsequence() {
		Consequence consequence = new Consequence();
		consequence.setMayOccur(this.isMayOccur);
		consequence.setExplanation(this.explanation);
		return consequence;
	}
}
