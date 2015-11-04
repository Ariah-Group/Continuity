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
package org.kuali.continuity.plan.dao.jpa;

import java.util.Map;

import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.dao.jpa.BaseDAOImpl;
import org.kuali.continuity.plan.dao.KeyResourcesDAO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.domain.OfficeEquipmentMinimum;

public class KeyResourcesDAOImpl extends BaseDAOImpl implements KeyResourcesDAO {

	// key resources
	public KeyResources get(int planId) {
		ContinuityPlan plan = this.getPlan(planId);
		return plan.getKeyResources();
	}

	// staff basics
	public void updateStaffBasics(int planId, 
			String hasEmergencyContactList,
			String emergencyContactListHolders,
			String emergencyContactListUpdaters,
			String voiceMailMessagesCheckers, 
			String voiceMailGreeters,
			String websiteMessagePosters, 
			String sharedPasswordKeepers,
			String comment) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.setHasEmergencyContactList(hasEmergencyContactList);
		kr.setEmergencyContactListHolders(emergencyContactListHolders);
		kr.setEmergencyContactListUpdaters(emergencyContactListUpdaters);
		kr.setVoiceMailMessagesCheckers(voiceMailMessagesCheckers);
		kr.setVoiceMailGreeters(voiceMailGreeters);
		kr.setWebsiteMessagePosters(websiteMessagePosters);
		kr.setSharedPasswordKeepers(sharedPasswordKeepers);
		kr.setStaffBasicsComment(comment);
		this.updatePlan(plan);
	}

	// work from home
	public void updateWorkFromHome(int planId, 
			boolean isWorkFromHomeNA,
			String workFromHomeNAExplanation) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.setWorkFromHomeNA(isWorkFromHomeNA);
		kr.setWorkFromHomeNAExplanation(workFromHomeNAExplanation);
		this.updatePlan(plan);
	}

	// skills
	public void createSkill(int planId, Skill skill, String comment) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.addSkill(skill, comment);
		this.updatePlan(plan);
	}

	public void deleteSkill(int planId, Skill skill) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.removeSkill(skill);
		this.updatePlan(plan);
	}

	public Map<Skill, String> getSkillMap(int planId) {
		Map<Skill, String> skillMap = this.get(planId).getSkillMap();
		skillMap.isEmpty();		// force load skills map
		return skillMap;
	}

	// equipment and supplies
	public void updateEquipmentAndSupplies(int planId,
			Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> officeEquipmentMinimums,
			String otherEquipmentNeeds,
			String suppliesNeeds,
			String supplyCrisisActions) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.setOfficeEquipmentMinimums(officeEquipmentMinimums);
		kr.setOtherEquipmentNeeds(otherEquipmentNeeds);
		kr.setSuppliesNeeds(suppliesNeeds);
		kr.setSupplyCrisisActions(supplyCrisisActions);
		this.updatePlan(plan);
	}

	// utilities
	public void createUtility(int planId, Utility utility, String comment) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.addUtility(utility, comment);
		this.updatePlan(plan);
	}

	public void deleteUtility(int planId, Utility utility) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.removeUtility(utility);
		this.updatePlan(plan);
	}

	public Map<Utility, String> getUtilities(int planId) {
		Map<Utility, String> utils = this.get(planId).getUtilities();
		utils.isEmpty();	// unlazy load
		return utils;
	}

	// facilities and transportation
	public void updateFacilitiesAndTransportations(int planId,
			String facilitiesNeeds, 
			String transporationNeeds,
			String otherResourcesNeeds) {
		ContinuityPlan plan = this.getPlan(planId);
		KeyResources kr = plan.getKeyResources();
		kr.setFacilitiesNeeds(facilitiesNeeds);
		kr.setTransporationNeeds(transporationNeeds);
		kr.setOtherResourcesNeeds(otherResourcesNeeds);
		this.updatePlan(plan);
	}

	private ContinuityPlan getPlan(int planId) {
		return
			(ContinuityPlan) this.getEntityManager().find(ContinuityPlan.class, planId);
	}
	
	private void updatePlan(ContinuityPlan plan) {
		this.getEntityManager().merge(plan);
	}
}
