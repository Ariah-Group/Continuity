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
import java.util.List;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.plan.action.dto.BuildingDTO;
import org.kuali.continuity.plan.action.dto.DepartmentInfoDTO;
import org.kuali.continuity.plan.domain.DepartmentInfo;
import org.kuali.continuity.plan.service.ContinuityPlanService;

@SuppressWarnings("serial")
public class SaveDepartmentInfoAction extends BasePlanActionSupport implements SessionPlanRequired  {

	private ContinuityPlanService continuityPlanService;

	// department info
	private DepartmentInfoDTO departmentInfo;
	
	// lists
	private List<RefDTO> evacuationPlans = new ArrayList<RefDTO>();
	private List<DomainObjectDTO> departmentTypes = new ArrayList<DomainObjectDTO>();
	private List<BuildingDTO> buildings = new ArrayList<BuildingDTO>();

	// ids
	private int addDepartmentTypeId;
	private int addBuildingId;
	private int deleteDepartmentTypeId;
	private int deleteBuildingId;
	
	public SaveDepartmentInfoAction(ContinuityPlanService continuityPlanService) {
		this.continuityPlanService = continuityPlanService;
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

	public int getAddDepartmentTypeId() {
		return this.addDepartmentTypeId;
	}

	public void setAddDepartmentTypeId(int addDepartmentTypeId) {
		this.addDepartmentTypeId = addDepartmentTypeId;
	}

	public int getAddBuildingId() {
		return this.addBuildingId;
	}

	public void setAddBuildingId(int addBuildingId) {
		this.addBuildingId = addBuildingId;
	}

	public int getDeleteDepartmentTypeId() {
		return this.deleteDepartmentTypeId;
	}

	public void setDeleteDepartmentTypeId(int deleteDepartmentTypeId) {
		this.deleteDepartmentTypeId = deleteDepartmentTypeId;
	}

	public int getDeleteBuildingId() {
		return this.deleteBuildingId;
	}

	public void setDeleteBuildingId(int deleteBuildingId) {
		this.deleteBuildingId = deleteBuildingId;
	}

	public String execute() {
		// add department type
		if (this.addDepartmentTypeId != 0) {
			int index = this.departmentTypes.indexOf(new DomainObjectDTO(this.addDepartmentTypeId));
			if (index >= 0) {
				this.departmentInfo.departmentTypes.add(this.departmentTypes.get(index));
				this.departmentTypes.remove(index);
			}
			this.addDepartmentTypeId = 0;
		}
		
		// add building
		if (this.addBuildingId != 0) {
			int index = this.buildings.indexOf(new BuildingDTO(this.addBuildingId));
			if (index >= 0) {
				this.departmentInfo.buildings.add(this.buildings.get(index));
				this.buildings.remove(index);
			}
			this.addBuildingId = 0;
		}
		
		// delete department type
		if (this.deleteDepartmentTypeId != 0) {
			int index = this.departmentInfo.departmentTypes.indexOf(new DomainObjectDTO(this.deleteDepartmentTypeId));
			if (index >= 0) {
				DomainObjectDTO delDeptType = this.departmentInfo.departmentTypes.get(index);
				this.departmentInfo.departmentTypes.remove(index);
				this.departmentTypes.add(delDeptType);
			}
			this.deleteDepartmentTypeId = 0;
		}
		
		// delete building
		if (this.deleteBuildingId != 0) {
			int index = this.departmentInfo.buildings.indexOf(new BuildingDTO(this.deleteBuildingId));
			if (index >= 0) {
				BuildingDTO delBldg = this.departmentInfo.buildings.get(index);
				this.departmentInfo.buildings.remove(index);
				this.buildings.add(delBldg);
			}
			this.deleteBuildingId = 0;
		}
		
		// validate department types
		if (this.departmentInfo.departmentTypes.isEmpty()) {
			this.addFieldError("addDepartmentTypeId", "Department type is required!");
			return INPUT;
		}
		
		DepartmentInfo deptInfo = this.departmentInfo.getDepartmentInfo();
		this.continuityPlanService.updateDepartmentInfo(this.getSessionPlan().id, deptInfo);

		return this.getSaveTypeEnum().getActionReturnValue();
	}
	
}
