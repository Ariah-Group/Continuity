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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.domain.EvacuationPlan;
import org.kuali.continuity.plan.domain.DepartmentInfo;

public class DepartmentInfoDTO {

	public List<DomainObjectDTO> departmentTypes = new ArrayList<DomainObjectDTO>();
	public List<BuildingDTO> buildings = new ArrayList<BuildingDTO>();
	public String employFaculty = "";
	public RefDTO evacuationPlan = new RefDTO();
	public String costCenter;
	public String comment;
	
	// head counts
	public int academicStaffCount;
	public int residentsAndFellowsCount;
	public int fulltimeStaffCount;
	public int parttimeStaffCount;
	public int studentStaffCount;
	public int volunteersCount;
	public int guestsCount;
	public int otherStaffCount;
	
	public DepartmentInfoDTO() {
		
	}
	
	public DepartmentInfoDTO(DepartmentInfo dObj) {
		if (dObj == null) return;
		this.departmentTypes =  this.getDepartmentTypeDTOs(dObj.getDepartmentTypes());
		this.buildings = this.getBuildingDTOs(dObj.getBuildings());
		this.employFaculty = dObj.getEmployFaculty();
		this.evacuationPlan = new RefDTO(dObj.getEvacuationPlan());
		this.costCenter = dObj.getCostCenter();
		this.comment = dObj.getComment();
		this.academicStaffCount = dObj.getAcademicStaffCount();
		this.residentsAndFellowsCount = dObj.getResidentsAndFellowsCount();
		this.fulltimeStaffCount = dObj.getFulltimeStaffCount();
		this.parttimeStaffCount = dObj.getParttimeStaffCount();
		this.studentStaffCount = dObj.getStudentStaffCount();
		this.volunteersCount = dObj.getVolunteersCount();
		this.guestsCount = dObj.getGuestsCount();
		this.otherStaffCount = dObj.getOtherStaffCount();	
	}
	
	public DepartmentInfo getDepartmentInfo() {
		DepartmentInfo deptInfo = new DepartmentInfo();
		deptInfo.setDepartmentTypes(this.getDepartmentTypes(departmentTypes));
		deptInfo.setBuildings(this.getBuildings(this.buildings));
		deptInfo.setEmployFaculty(this.employFaculty);
		deptInfo.setEvacuationPlan(new EvacuationPlan(this.evacuationPlan.id));
		deptInfo.setCostCenter(this.costCenter);
		deptInfo.setComment(this.comment);
		deptInfo.setAcademicStaffCount(this.academicStaffCount);
		deptInfo.setResidentsAndFellowsCount(this.residentsAndFellowsCount);
		deptInfo.setFulltimeStaffCount(this.fulltimeStaffCount);
		deptInfo.setParttimeStaffCount(this.parttimeStaffCount);
		deptInfo.setStudentStaffCount(this.studentStaffCount);
		deptInfo.setVolunteersCount(this.volunteersCount);
		deptInfo.setGuestsCount(this.guestsCount);
		deptInfo.setOtherStaffCount(this.otherStaffCount);
		return deptInfo;
	}
	
	// TODO: refactor
	private List<DepartmentType> getDepartmentTypes(List<DomainObjectDTO> dtos) {
		if (dtos == null) return null;
		List<DepartmentType> list = new ArrayList<DepartmentType>();
		for (DomainObjectDTO domainObjectDTO : dtos) {
			list.add(new DepartmentType(domainObjectDTO.id));
		}
		return list;
	}
	
	// TODO: refactor
	private Map<Building, String> getBuildings(List<BuildingDTO> dtos) {
		if (dtos == null) return null;
		Map<Building, String> map = new HashMap<Building, String>();
		for (BuildingDTO buildingDTO : dtos) {
			map.put(new Building(buildingDTO.id), buildingDTO.comment);
		}
		return map;
	}
	
	// TODO: refactor
	private List<BuildingDTO> getBuildingDTOs(Map<Building, String> dObjs) {
		List<BuildingDTO> dObjDTOs = new ArrayList<BuildingDTO>();
		if (dObjs != null) {
			Set<Building> bldgs = dObjs.keySet();
			for (Building building : bldgs) {
				BuildingDTO bldgDTO = new BuildingDTO(building);
				bldgDTO.comment = dObjs.get(building);
				dObjDTOs.add(bldgDTO);
			}
		}
		return dObjDTOs;
	}
		
	// TODO: refactor
	private List<DomainObjectDTO> getDepartmentTypeDTOs(List<DepartmentType> dObjs) {
		List<DomainObjectDTO> dObjDTOs = new ArrayList<DomainObjectDTO>();
		if (dObjs != null) {
			for (DepartmentType dObj : dObjs) {
				dObjDTOs.add(new DomainObjectDTO(dObj));
			}
		}
		return dObjDTOs;
	}
		
}
