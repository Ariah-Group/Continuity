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

import java.util.List;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.domain.EvacuationPlan;
import org.kuali.continuity.plan.action.dto.BuildingDTO;
import org.kuali.continuity.plan.action.dto.DepartmentInfoDTO;
import org.kuali.continuity.plan.action.dto.PlanNavigation;
import org.kuali.continuity.plan.service.ContinuityPlanService;

public class GetDepartmentInfoAction extends BasePlanAction implements PlanNavigationSession, SessionPlanRequired {
	
	private ContinuityPlanService continuityPlanService;
	private PlanActionServiceHelper serviceHelper;
	
	// department info
	private DepartmentInfoDTO departmentInfo;
	
	// lists
	private List<RefDTO> evacuationPlans;
	private List<DomainObjectDTO> departmentTypes;
	private List<BuildingDTO> buildings;
	
	public GetDepartmentInfoAction(ContinuityPlanService continuityPlanService, PlanActionServiceHelper serviceHelper) {
		this.continuityPlanService = continuityPlanService;
		this.serviceHelper = serviceHelper;
	}

	public DepartmentInfoDTO getDepartmentInfo() {
		return this.departmentInfo;
	}

	public void setDepartmentInfo(DepartmentInfoDTO departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	public List<RefDTO> getEvacuationPlans() {
		return this.evacuationPlans;
	}

	public void setEvacuationPlans(List<RefDTO> evacuationPlans) {
		this.evacuationPlans = evacuationPlans;
	}

	public List<DomainObjectDTO> getDepartmentTypes() {
		return this.departmentTypes;
	}

	public void setDepartmentTypes(List<DomainObjectDTO> departmentTypes) {
		this.departmentTypes = departmentTypes;
	}

	public List<BuildingDTO> getBuildings() {
		return this.buildings;
	}

	public void setBuildings(List<BuildingDTO> buildings) {
		this.buildings = buildings;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// get plan
		this.departmentInfo = new DepartmentInfoDTO(this.continuityPlanService.getDepartmentInfo(this.getSessionPlan().id));
		
		// get department types
		int systemDomainId = this.getSessionSystemDomain().id;
		this.departmentTypes = (List<DomainObjectDTO>) this.serviceHelper.getAdminDomainObjectDTOs(DepartmentType.class, systemDomainId);
		
		// get buildings
		this.buildings = (List<BuildingDTO>) this.serviceHelper.getAdminDomainObjectDTOs(Building.class, systemDomainId);
		
		// get evacuation plans
		this.evacuationPlans = this.serviceHelper.getRefDTOs(EvacuationPlan.class);
		
		// filter lists
		this.departmentTypes.removeAll(this.departmentInfo.departmentTypes);
		this.buildings.removeAll(this.departmentInfo.buildings);

		// return
		return SUCCESS;
	}

	public PlanNavigation getPlanNavigation() {
		return PlanNavigation.STEP1;
	}

}
