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


public interface PlanSection {
	
	public enum MainSection {
		DEPARTMENT_INFO, 
		CRITICAL_FUNCTIONS, 
		INFORMATION_TECHNOLOGY, 
		FACULTY_PREPAREDNESS, 
		KEY_RESOURCES, 
		ACTION_ITEMS};
		
	public enum CriticalFunctionSection {
		DESCRIPTION,
		PEAK_PERIODS,
		DOCUMENTS,
		DEPENDENCIES,
		CONSEQUENCES,
		HOW_TO_COPE,
		ACTION_ITEMS
	}
	
	public enum InformationTechnologySection {
		CENTRAL_APPLICATIONS,
		DEPARTMENT_APPLICATIONS,
		SERVERS,
		WORKSTATIONS,
		RECOVERY,
		ACTION_ITEMS
	}
	
	public enum KeyResourcesSection {
		STAFF_BASICS,
		WORK_FROM_HOME,
		TEAMS,
		SKILLS,
		STAFFING_REQUIREMENTS,
		STAFF_OF_OTHER_UNITS,
		STAKEHOLDERS,
		DOCUMENTS,
		EQUIPMENTS_SUPPLIES,
		FACILITIES_TRANSPORTATION,
	}
	
	PlanSection getParentSection();
	void setParentSection();
	boolean isOmitted();
	void setOmitted(boolean isOmitted);

}
