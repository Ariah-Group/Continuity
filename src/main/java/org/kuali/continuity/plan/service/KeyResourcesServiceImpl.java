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

import java.util.List;
import java.util.Map;

import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.plan.dao.KeyResourcesDAO;
import org.kuali.continuity.plan.domain.KeyDocument;
import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.domain.KeyStaffMember;
import org.kuali.continuity.plan.domain.OfficeEquipmentMinimum;
import org.kuali.continuity.plan.domain.OtherUnitStaffMember;
import org.kuali.continuity.plan.domain.StaffingRequirement;
import org.kuali.continuity.plan.domain.Stakeholder;
import org.kuali.continuity.plan.domain.Team;
import org.kuali.continuity.plan.domain.WorkFromHomeStaffMember;
import org.kuali.continuity.plan.domain.OfficeEquipmentMinimum.Type;

public class KeyResourcesServiceImpl implements KeyResourcesService {
	
	private KeyResourcesDAO keyResourcesDAO;
	private GenericAdminService genericAdminService;
	private DocumentServiceFactory documentServiceFactory;
	private KeyStaffMemberService keyStaffMemberService;
	private WorkFromHomeStaffMemberService workFromHomeStaffMemberService;
	private TeamService teamService;
	private StaffingRequirementService staffingRequirementService;
	private OtherUnitStaffMemberService otherUnitStaffMemberService;
	private StakeholderService stakeholderService;

	public void createSkill(int planId, Skill skill, String comment) {
		this.createUserDefinedSkill(skill);
		this.keyResourcesDAO.createSkill(planId, skill, comment);
	}

	public void createUtility(int planId, Utility utility, String comment) {
		this.keyResourcesDAO.createUtility(planId, utility, comment);
	}

	public void deleteSkill(int planId, Skill skill) {
		this.keyResourcesDAO.deleteSkill(planId, skill);
	}

	public void deleteUtility(int planId, Utility utility) {
		this.keyResourcesDAO.deleteUtility(planId, utility);
	}

	public KeyResources getKeyResources(int planId) {
		return this.keyResourcesDAO.get(planId);
	}

	public Map<Skill, String> getSkillMap(int planId) {
		return this.keyResourcesDAO.getSkillMap(planId);
	}

	public Map<Utility, String> getUtilities(int planId) {
		return this.keyResourcesDAO.getUtilities(planId);
	}

	public void updateEquipmentAndSupplies(int planId,
			Map<Type, OfficeEquipmentMinimum> officeEquipmentMinimums,
			String otherEquipmentNeeds, String suppliesNeeds,
			String supplyCrisisActions) {
		this.keyResourcesDAO.updateEquipmentAndSupplies(planId, officeEquipmentMinimums, otherEquipmentNeeds, suppliesNeeds, supplyCrisisActions);
	}

	public void updateFacilitiesAndTransportations(int planId,
			String facilitiesNeeds, String transporationNeeds,
			String otherResourcesNeeds) {
		this.keyResourcesDAO.updateFacilitiesAndTransportations(planId, facilitiesNeeds, transporationNeeds, otherResourcesNeeds);
	}

	public void updateStaffBasics(int planId, String hasEmergencyContactList,
			String emergencyContactListHolders,
			String emergencyContactListUpdaters,
			String voiceMailMessagesCheckers, String voiceMailGreeters,
			String websiteMessagePosters, String sharedPasswordKeepers,
			String comment) {
		this.keyResourcesDAO.updateStaffBasics(planId, hasEmergencyContactList, emergencyContactListHolders, emergencyContactListUpdaters, voiceMailMessagesCheckers, voiceMailGreeters, websiteMessagePosters, sharedPasswordKeepers, comment);
	}

	public void updateWorkFromHome(int planId, boolean isWorkFromHomeNA,
			String workFromHomeNAExplanation) {
		this.keyResourcesDAO.updateWorkFromHome(planId, isWorkFromHomeNA, workFromHomeNAExplanation);
	}

	private void createUserDefinedSkill(Skill skill) {
		if (skill == null || !skill.isUserDefined()) return;
		this.genericAdminService.create(skill);
	}

	public KeyResourcesDAO getKeyResourcesDAO() {
		return this.keyResourcesDAO;
	}

	public void setKeyResourcesDAO(KeyResourcesDAO keyResourcesDAO) {
		this.keyResourcesDAO = keyResourcesDAO;
	}

	public GenericAdminService getGenericAdminService() {
		return this.genericAdminService;
	}

	public void setGenericAdminService(GenericAdminService genericAdminService) {
		this.genericAdminService = genericAdminService;
	}

	// used in delete plan
	@Override
	@SuppressWarnings("unchecked")
	public void deleteKeyResources(int planId) {
		KeyResources kr = this.getKeyResources(planId);
		
		// delete documents
		DocumentService docService = this.documentServiceFactory.getDocumentService(KeyDocument.class);
		List<KeyDocument> docs = (List<KeyDocument>)
			docService.getDocumentListByOwnerId(planId);
		if (docs != null) {
			for (KeyDocument doc : docs) {
				docService.deleteDocument(doc.getId());
			}
		}
		
		// delete staff members
		for (KeyStaffMember member : kr.getKeyStaffMembers()) {
			this.keyStaffMemberService.delete(member.getId());
		}
		
		// delete work from home members
		for (WorkFromHomeStaffMember member : kr.getWorkFromHomeStaffMembers()) {
			this.workFromHomeStaffMemberService.delete(member.getId());
		}
		
		// delete teams
		for (Team team : kr.getTeams()) {
			this.teamService.delete(team.getId());
		}
		
		// delete staffing requirement
//		for (StaffingRequirement req : kr.getStaffingRequirements()) {
//			this.staffingRequirementService.delete(req.getId());
//		}
		
		// delete other units
		for (OtherUnitStaffMember member : kr.getOtherUnitStaffMembers()) {
			this.otherUnitStaffMemberService.delete(member.getId());
		}
		
		// delete stakeholders
		for (Stakeholder stakeholder : kr.getStakeholders()) {
			this.stakeholderService.delete(stakeholder.getId());
		}
		
	}

	public DocumentServiceFactory getDocumentServiceFactory() {
		return this.documentServiceFactory;
	}

	public void setDocumentServiceFactory(
			DocumentServiceFactory documentServiceFactory) {
		this.documentServiceFactory = documentServiceFactory;
	}

	public KeyStaffMemberService getKeyStaffMemberService() {
		return this.keyStaffMemberService;
	}

	public void setKeyStaffMemberService(KeyStaffMemberService keyStaffMemberService) {
		this.keyStaffMemberService = keyStaffMemberService;
	}

	public WorkFromHomeStaffMemberService getWorkFromHomeStaffMemberService() {
		return this.workFromHomeStaffMemberService;
	}

	public void setWorkFromHomeStaffMemberService(
			WorkFromHomeStaffMemberService workFromHomeStaffMemberService) {
		this.workFromHomeStaffMemberService = workFromHomeStaffMemberService;
	}

	public TeamService getTeamService() {
		return this.teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public StaffingRequirementService getStaffingRequirementService() {
		return this.staffingRequirementService;
	}

	public void setStaffingRequirementService(
			StaffingRequirementService staffingRequirementService) {
		this.staffingRequirementService = staffingRequirementService;
	}

	public OtherUnitStaffMemberService getOtherUnitStaffMemberService() {
		return this.otherUnitStaffMemberService;
	}

	public void setOtherUnitStaffMemberService(
			OtherUnitStaffMemberService otherUnitStaffMemberService) {
		this.otherUnitStaffMemberService = otherUnitStaffMemberService;
	}

	public StakeholderService getStakeholderService() {
		return this.stakeholderService;
	}

	public void setStakeholderService(StakeholderService stakeholderService) {
		this.stakeholderService = stakeholderService;
	}

}
