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

public class Consequence {

	private boolean isMayOccur;
	private String explanation;
	
	public Consequence() {
	}
	
	public Consequence(boolean isMayOccur, String explanation) {
		this.setMayOccur(isMayOccur);
		this.setExplanation(explanation);
	}
	
	public void setMayOccur(boolean isMayOccur) {
		this.isMayOccur = isMayOccur;
	}

	public boolean isMayOccur() {
		return this.isMayOccur;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public enum Type {
		DISRUPT_TEACHING,
		DISRUPT_RESEARCH,
		DISRUPT_PATIENT_CARE,
		DEPARTURE_FACULTY,
		DEPARTURE_STAFF,
		DEPARTURE_STUDENTS,
		WELLBEING_FACULTY_STAFF,
		WELLBEING_STUDENTS,
		PAYMENT_DEADLINES_UNMET,
		LOSS_REVENUE,
		LEGAL_OBLIGATIONS_UNMET,
		LEGAL_HARM_UNIVERSITY,
		IMPACT_OTHER_UNITS,
		IMPACT_BUSINESS_PARTNERS,
		OTHER
	}

}
