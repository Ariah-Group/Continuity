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
package org.kuali.continuity.plan.service;

import java.util.Map;

import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.domain.OfficeEquipmentMinimum;

public interface KeyResourcesService {

	// key resources
	KeyResources getKeyResources(int planId);
	
	// staff basics
	void updateStaffBasics(int planId,
		String hasEmergencyContactList,
		String emergencyContactListHolders,
		String emergencyContactListUpdaters,
		String voiceMailMessagesCheckers,
		String voiceMailGreeters,
		String websiteMessagePosters,
		String sharedPasswordKeepers,
		String comment);
	
	// work from home
	void updateWorkFromHome(int planId,
		boolean isWorkFromHomeNA,
		String workFromHomeNAExplanation);

	// skills
	void createSkill(int planId, Skill skill, String comment);
	void deleteSkill(int planId, Skill skill);
	Map<Skill, String> getSkillMap(int planId);
	
	// equipments and supplies
	void updateEquipmentAndSupplies(int planId,
		Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> officeEquipmentMinimums,
		String otherEquipmentNeeds,
		String suppliesNeeds,
		String supplyCrisisActions);
	
	// utilities
	void createUtility(int planId, Utility utility, String comment);
	void deleteUtility(int planId, Utility utility);
	Map<Utility, String> getUtilities(int planId);
	
	// facilities and transportations
	void updateFacilitiesAndTransportations(int planId,
		String facilitiesNeeds,
		String transporationNeeds,
		String otherResourcesNeeds);
	
	// delete key resources
	void deleteKeyResources(int planId);
	
}
