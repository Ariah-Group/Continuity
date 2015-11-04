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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.MapKeyManyToMany;
import org.hibernate.annotations.Where;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.plan.domain.ext.OfficeEquipmentMinimums;

@Embeddable
@SuppressWarnings("serial")
public class KeyResources implements Serializable {
	
	// staff basics (plans)
	private String hasEmergencyContactList;
	private String emergencyContactListHolders;
	private String emergencyContactListUpdaters;
	private String voiceMailMessagesCheckers;
	private String voiceMailGreeters;
	private String websiteMessagePosters;
	private String sharedPasswordKeepers;
	private String staffBasicsComment;
	
	// key staff person list (key_staff_unit)
	private List<KeyStaffMember> keyStaffMembers;
	
	// work from home (n/a, explanation) (plans)
	private boolean isWorkFromHomeNA;
	private String workFromHomeNAExplanation;
	
	// key staff person list working from home (key_work_home)
	private List<WorkFromHomeStaffMember> workFromHomeStaffMembers;
	
	// key team list (key_teams)
	//     team member list (key_team_members)
	private List<Team> teams;
	
	// skill list (key_skills)
	private Map<Skill, String> skillMap;
	
	// staffing requirement list (key_staffing_req)
	private List<StaffingRequirement> staffingRequirements;
	
	// key staff person of other units (key_staff_other units)
	private List<OtherUnitStaffMember> otherUnitStaffMembers;
	
	// stake holder list (key_stakeholders)
	private List<Stakeholder> stakeholders;
	
	// key document list (key_plan_documents)
	private List<KeyDocument> documents;
	
	// equipment & supplies
	//     a.  office equipemnt (plans)
	//     b.  other equipment (plans)
	//     c.  supplies (plans)
	private String otherEquipmentNeeds;
	private String suppliesNeeds;
	private String supplyCrisisActions;
	
	// utility list
	private Map<Utility, String> utilities;
	
	// facilities & transportation
	//     utility list (key_utility)
	//     facilities/transportation/other resources
	private String facilitiesNeeds;
	private String transporationNeeds;
	private String otherResourcesNeeds;
	
	// for mapping only
	private OfficeEquipmentMinimums officeEquipmentMinimumsExt;
	
	public KeyResources() {	
	}

	@Column(name="key_basic_emergency_contact_copy", insertable=false)
	public String getHasEmergencyContactList() {
		return this.hasEmergencyContactList;
	}

	public void setHasEmergencyContactList(String hasEmergencyContactList) {
		this.hasEmergencyContactList = hasEmergencyContactList;
	}

	@Column(name="key_basic_who_hold", insertable=false)
	public String getEmergencyContactListHolders() {
		return this.emergencyContactListHolders;
	}

	public void setEmergencyContactListHolders(String emergencyContactListHolders) {
		this.emergencyContactListHolders = emergencyContactListHolders;
	}

	@Column(name="key_basic_who_update", insertable=false)
	public String getEmergencyContactListUpdaters() {
		return this.emergencyContactListUpdaters;
	}

	public void setEmergencyContactListUpdaters(String emergencyContactListUpdaters) {
		this.emergencyContactListUpdaters = emergencyContactListUpdaters;
	}

	@Column(name="key_basic_who_check_msg", insertable=false)
	public String getVoiceMailMessagesCheckers() {
		return this.voiceMailMessagesCheckers;
	}

	public void setVoiceMailMessagesCheckers(String voiceMailMessagesCheckers) {
		this.voiceMailMessagesCheckers = voiceMailMessagesCheckers;
	}

	@Column(name="key_basic_who_record_greeting", insertable=false)
	public String getVoiceMailGreeters() {
		return this.voiceMailGreeters;
	}

	public void setVoiceMailGreeters(String voiceMailGreeters) {
		this.voiceMailGreeters = voiceMailGreeters;
	}

	@Column(name="key_basic_who_post_msg", insertable=false)
	public String getWebsiteMessagePosters() {
		return this.websiteMessagePosters;
	}

	public void setWebsiteMessagePosters(String websiteMessagePosters) {
		this.websiteMessagePosters = websiteMessagePosters;
	}

	@Column(name="key_basic_shared_password", insertable=false)
	public String getSharedPasswordKeepers() {
		return this.sharedPasswordKeepers;
	}

	public void setSharedPasswordKeepers(String sharedPasswordKeepers) {
		this.sharedPasswordKeepers = sharedPasswordKeepers;
	}

	@Column(name="key_basic_comment", insertable=false)
	public String getStaffBasicsComment() {
		return this.staffBasicsComment;
	}

	public void setStaffBasicsComment(String staffBasicsComment) {
		this.staffBasicsComment = staffBasicsComment;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	@Where(clause="disabled != 'Y'")
	public List<KeyStaffMember> getKeyStaffMembers() {
		return this.keyStaffMembers;
	}

	public void setKeyStaffMembers(List<KeyStaffMember> keyStaffMembers) {
		this.keyStaffMembers = keyStaffMembers;
	}

	@Column(name="not_applicable", insertable=false)
	public boolean isWorkFromHomeNA() {
		return this.isWorkFromHomeNA;
	}

	public void setWorkFromHomeNA(boolean isWorkFromHomeNA) {
		this.isWorkFromHomeNA = isWorkFromHomeNA;
	}

	@Column(name="na_explain", insertable=false)
	public String getWorkFromHomeNAExplanation() {
		return this.workFromHomeNAExplanation;
	}

	public void setWorkFromHomeNAExplanation(String workFromHomeNAExplanation) {
		this.workFromHomeNAExplanation = workFromHomeNAExplanation;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	@Where(clause="disabled != 'Y'")
	public List<WorkFromHomeStaffMember> getWorkFromHomeStaffMembers() {
		return this.workFromHomeStaffMembers;
	}

	public void setWorkFromHomeStaffMembers(
			List<WorkFromHomeStaffMember> workFromHomeStaffMembers) {
		this.workFromHomeStaffMembers = workFromHomeStaffMembers;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@CollectionOfElements(targetElement=String.class, 
		fetch=FetchType.LAZY)
	@Column(name="comment")
	@JoinTable(name="key_skills", 
		joinColumns={@JoinColumn(name="pid")})
	@MapKeyManyToMany(targetEntity=Skill.class,
		joinColumns={@JoinColumn(name="SkillID")})
	public Map<Skill, String> getSkillMap() {
		return this.skillMap;
	}

	public void setSkillMap(Map<Skill, String> skillMap) {
		this.skillMap = skillMap;
	}
	
	public void addSkill(Skill skill, String comment) {
		if (skill == null) return;
		Map<Skill, String> skillMap = this.getSkillMap();
		if (skillMap == null) {
			skillMap = new HashMap<Skill, String>();
			this.setSkillMap(skillMap);
		}
		skillMap.put(skill, comment);
	}
	
	public void removeSkill(Skill skill) {
		if (skill == null) return;
		Map<Skill, String> skillMap = this.getSkillMap();
		if (skillMap != null) skillMap.remove(skill);
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	public List<StaffingRequirement> getStaffingRequirements() {
		return this.staffingRequirements;
	}

	public void setStaffingRequirements(
			List<StaffingRequirement> staffingRequirements) {
		this.staffingRequirements = staffingRequirements;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	@Where(clause="disabled != 'Y'")
	public List<OtherUnitStaffMember> getOtherUnitStaffMembers() {
		return this.otherUnitStaffMembers;
	}

	public void setOtherUnitStaffMembers(
			List<OtherUnitStaffMember> otherUnitStaffMembers) {
		this.otherUnitStaffMembers = otherUnitStaffMembers;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	@Where(clause="disabled != 'Y'")
	public List<Stakeholder> getStakeholders() {
		return this.stakeholders;
	}

	public void setStakeholders(List<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", insertable=false, updatable=false)
	public List<KeyDocument> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<KeyDocument> documents) {
		this.documents = documents;
	}

	@Transient
	public Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum>
		getOfficeEquipmentMinimums() {
		if (this.getOfficeEquipmentMinimumsExt() == null) return null;
		return this.getOfficeEquipmentMinimumsExt().getOfficeEquipmentMinimums();
	}

	public void setOfficeEquipmentMinimums(
			Map<OfficeEquipmentMinimum.Type, OfficeEquipmentMinimum> officeEquipmentMinimums) {
		if (this.getOfficeEquipmentMinimumsExt() == null)
			this.setOfficeEquipmentMinimumsExt(new OfficeEquipmentMinimums());
		this.getOfficeEquipmentMinimumsExt().setOfficeEquipmentMinimums(officeEquipmentMinimums);
	}

	@Column(name="key_other_equipment", insertable=false)
	public String getOtherEquipmentNeeds() {
		return this.otherEquipmentNeeds;
	}

	public void setOtherEquipmentNeeds(String otherEquipmentNeeds) {
		this.otherEquipmentNeeds = otherEquipmentNeeds;
	}

	@Column(name="key_supplies", insertable=false)
	public String getSuppliesNeeds() {
		return this.suppliesNeeds;
	}

	public void setSuppliesNeeds(String suppliesNeeds) {
		this.suppliesNeeds = suppliesNeeds;
	}

	@Column(name="key_supply_crisis", insertable=false)
	public String getSupplyCrisisActions() {
		return this.supplyCrisisActions;
	}

	public void setSupplyCrisisActions(String supplyCrisisActions) {
		this.supplyCrisisActions = supplyCrisisActions;
	}

	@CollectionOfElements(targetElement=String.class, 
		fetch=FetchType.LAZY)
	@Column(name="comment")
	@JoinTable(name="key_utility", 
		joinColumns={@JoinColumn(name="pid")})
	@MapKeyManyToMany(targetEntity=Utility.class,
		joinColumns={@JoinColumn(name="UtilityID")})
	public Map<Utility, String>  getUtilities() {
		return this.utilities;
	}

	public void setUtilities(Map<Utility, String>  utilities) {
		this.utilities = utilities;
	}
	
	public void addUtility(Utility utility, String comment) {
		Map<Utility, String> utils = this.getUtilities();
		if (utils == null) {
			utils = new HashMap<Utility, String>();
			this.setUtilities(utils);
		}
		utils.put(utility, comment);
	}
	
	public void removeUtility(Utility utility) {
		Map<Utility, String> utils = this.getUtilities();
		utils.remove(utility);
	}

	@Column(name="key_facilities", insertable=false)
	public String getFacilitiesNeeds() {
		return this.facilitiesNeeds;
	}

	public void setFacilitiesNeeds(String facilitiesNeeds) {
		this.facilitiesNeeds = facilitiesNeeds;
	}

	@Column(name="key_transportation", insertable=false)
	public String getTransporationNeeds() {
		return this.transporationNeeds;
	}

	public void setTransporationNeeds(String transporationNeeds) {
		this.transporationNeeds = transporationNeeds;
	}

	@Column(name="key_other_resources", insertable=false)
	public String getOtherResourcesNeeds() {
		return this.otherResourcesNeeds;
	}

	public void setOtherResourcesNeeds(String otherResourcesNeeds) {
		this.otherResourcesNeeds = otherResourcesNeeds;
	}

	@Embedded
	private OfficeEquipmentMinimums getOfficeEquipmentMinimumsExt() {
		return this.officeEquipmentMinimumsExt;
	}
	
	private void setOfficeEquipmentMinimumsExt(OfficeEquipmentMinimums officeEquipmentMinimumsExt) {
		this.officeEquipmentMinimumsExt = officeEquipmentMinimumsExt;
	}

}
