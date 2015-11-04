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
package org.kuali.continuity.plan.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.AddAction;
import org.kuali.continuity.action.DeleteAction;
import org.kuali.continuity.action.ReadRowAction;
import org.kuali.continuity.action.UpdateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.admin.domain.Utility;
import org.kuali.continuity.plan.domain.KeyResources;
import org.kuali.continuity.plan.service.KeyResourcesService;

@SuppressWarnings("serial")
public class KeyResourcesFacilitiesReqsAction extends KeyResourcesAction {
	
	// services
	private KeyResourcesService keyResourcesService;
	
	// bean - facilities, etc.
	private String facilitiesNeeds = "";
	private String transporationNeeds = "";
	private String otherResourcesNeeds = "";
	
	// utilities
	private int utilId;
	private String utilComment = "";
	
	// utility map
	private List<UtilityDTO> utilities = new ArrayList<UtilityDTO>();

	public KeyResourcesFacilitiesReqsAction(KeyResourcesService keyResourcesService) {
		super();
		this.keyResourcesService = keyResourcesService;
	}
	
	public String getFacilitiesNeeds() {
		return this.facilitiesNeeds;
	}

	public void setFacilitiesNeeds(String facilitiesNeeds) {
		this.facilitiesNeeds = facilitiesNeeds;
	}

	public String getTransporationNeeds() {
		return this.transporationNeeds;
	}

	public void setTransporationNeeds(String transporationNeeds) {
		this.transporationNeeds = transporationNeeds;
	}

	public String getOtherResourcesNeeds() {
		return this.otherResourcesNeeds;
	}

	public void setOtherResourcesNeeds(String otherResourcesNeeds) {
		this.otherResourcesNeeds = otherResourcesNeeds;
	}

	public int getUtilId() {
		return this.utilId;
	}

	public void setUtilId(int utilId) {
		this.utilId = utilId;
	}

	public String getUtilComment() {
		return this.utilComment;
	}

	public void setUtilComment(String utilComment) {
		this.utilComment = utilComment;
	}

	public List<UtilityDTO> getUtilities() {
		return this.utilities;
	}

	public void setUtilities(List<UtilityDTO> utilities) {
		this.utilities = utilities;
	}
	
	public void prepare() throws Exception {
		super.prepare();
		this.getSaveActions().put(new Integer(1), new UtilityAddAction());
		this.getSaveActions().put(new Integer(2), new FacilitiesUpdateAction());
		this.setDeleteAction(new UtilityDeleteAction());
		this.setReadRowAction(new FacilitiesReadRowAction());
	}

	//--- actions ---//
	
	public class UtilityAddAction implements AddAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesFacilitiesReqsAction.this.keyResourcesService;
			int planId = KeyResourcesFacilitiesReqsAction.this.getOwnerId();
			int id = KeyResourcesFacilitiesReqsAction.this.utilId;
			if (id != 0)
				service.createUtility(planId, new Utility(id), KeyResourcesFacilitiesReqsAction.this.utilComment);
			return SUCCESS;
		}
	}
	
	public class UtilityDeleteAction implements DeleteAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesFacilitiesReqsAction.this.keyResourcesService;
			int planId = KeyResourcesFacilitiesReqsAction.this.getOwnerId();
			int id = KeyResourcesFacilitiesReqsAction.this.utilId;
			if (id != 0)
				service.deleteUtility(planId, new Utility(id));
			return SUCCESS;
		}
	}
	
	public class FacilitiesReadRowAction implements ReadRowAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesFacilitiesReqsAction.this.keyResourcesService;
			int planId = KeyResourcesFacilitiesReqsAction.this.getOwnerId();
			
			// facilities, etc.
			KeyResources kr = service.getKeyResources(planId);
			KeyResourcesFacilitiesReqsAction.this.facilitiesNeeds = kr.getFacilitiesNeeds();
			KeyResourcesFacilitiesReqsAction.this.transporationNeeds = kr.getTransporationNeeds();
			KeyResourcesFacilitiesReqsAction.this.otherResourcesNeeds = kr.getOtherResourcesNeeds();

			// utility list
			Map<Utility, String> utils = service.getUtilities(planId);
			if (utils != null) {
				Set<Utility> utilKeys = utils.keySet();
				for (Utility util : utilKeys) {
					KeyResourcesFacilitiesReqsAction.this.utilities.add(new UtilityDTO(util, utils.get(util)));
				}
			}
			//Sort utility list
			Collections.sort(KeyResourcesFacilitiesReqsAction.this.utilities);
			return SUCCESS;
		}
	}
	
	public class FacilitiesUpdateAction implements UpdateAction {
		public String execute() throws Exception {
			KeyResourcesService service = KeyResourcesFacilitiesReqsAction.this.keyResourcesService;
			int planId = KeyResourcesFacilitiesReqsAction.this.getOwnerId();
			service.updateFacilitiesAndTransportations(planId, 
				KeyResourcesFacilitiesReqsAction.this.facilitiesNeeds, 
				KeyResourcesFacilitiesReqsAction.this.transporationNeeds, 
				KeyResourcesFacilitiesReqsAction.this.otherResourcesNeeds);
			return SUCCESS;
		}
	}
	
	public class UtilityDTO implements Comparable<UtilityDTO>{
		public DomainObjectDTO utility;
		public String comment;
		public UtilityDTO(Utility utility, String comment) {
			this.utility = new DomainObjectDTO(utility);
			this.comment = comment;
		}
		
		public int compareTo(UtilityDTO o) {
	        return this.utility.name.toLowerCase().compareTo(o.utility.name.toLowerCase());
	    }
	}
		
}
