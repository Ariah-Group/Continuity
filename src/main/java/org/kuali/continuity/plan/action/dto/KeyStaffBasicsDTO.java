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

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.domain.KeyResources;

@SuppressWarnings("serial")
public class KeyStaffBasicsDTO extends DomainObjectDTO {

	// staff basics (plans)
	public String hasEmergencyContactList;
	public String emergencyContactListHolders;
	public String emergencyContactListUpdaters;
	public String voiceMailMessagesCheckers;
	public String voiceMailGreeters;
	public String websiteMessagePosters;
	public String sharedPasswordKeepers;
	public String staffBasicsComment;
	
	public KeyStaffBasicsDTO() {
		
	}
	
	public KeyStaffBasicsDTO(KeyResources keyResources) {
		if (keyResources == null) return;
		this.hasEmergencyContactList = keyResources.getHasEmergencyContactList();
		this.emergencyContactListHolders = keyResources.getEmergencyContactListHolders();
		this.emergencyContactListUpdaters = keyResources.getEmergencyContactListUpdaters();
		this.voiceMailMessagesCheckers = keyResources.getVoiceMailMessagesCheckers();
		this.voiceMailGreeters = keyResources.getVoiceMailGreeters();
		this.websiteMessagePosters = keyResources.getWebsiteMessagePosters();
		this.sharedPasswordKeepers = keyResources.getSharedPasswordKeepers();
		this.staffBasicsComment = keyResources.getStaffBasicsComment();
	}
	
}
