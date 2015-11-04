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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.MapKeyManyToMany;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.domain.EvacuationPlan;

@Embeddable
@SuppressWarnings("serial")
public class DepartmentInfo implements Serializable {
	
	private List<DepartmentType> departmentTypes;
	private Map<Building, String> buildings;
//	private Boolean isEmployingFaculty;
	private EvacuationPlan evacuationPlan;
	private String employFaculty;
	private String costCenter;
	private String comment;
	
	// head counts
	private int academicStaffCount;
	private int residentsAndFellowsCount;
	private int fulltimeStaffCount;
	private int parttimeStaffCount;
	private int studentStaffCount;
	private int volunteersCount;
	private int guestsCount;
	private int otherStaffCount;
	
	public DepartmentInfo() {
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinTable(name="plan_department_types", 
		joinColumns=@JoinColumn(name="pid"),
		inverseJoinColumns=@JoinColumn(name="DepartmentTypeID"))
	public List<DepartmentType> getDepartmentTypes() {
		if (this.departmentTypes == null)
			this.setDepartmentTypes(new ArrayList<DepartmentType>());
		return this.departmentTypes;
	}

	public void setDepartmentTypes(List<DepartmentType> departmentTypes) {
		this.departmentTypes = departmentTypes;
	}
	
	public void addDepartmentType(DepartmentType departmentType) {
		this.getDepartmentTypes().add(departmentType);
	}

	public void removeDepartmentType(DepartmentType departmentType) {
		this.getDepartmentTypes().remove(departmentType);
		
	}

	@CollectionOfElements(targetElement=String.class, 
		fetch=FetchType.EAGER)
	@Column(name="BuildingComment")
	@JoinTable(name="plan_buildings", 
		joinColumns={@JoinColumn(name="pid")})
	@MapKeyManyToMany(targetEntity=Building.class,
		joinColumns={@JoinColumn(name="BuildingID")})
	public Map<Building, String> getBuildings() {
		if (this.buildings == null)
			this.setBuildings(new HashMap<Building, String>());
		return this.buildings;
	}

	public void setBuildings(Map<Building, String> buildings) {
		this.buildings = buildings;
	}
	
	public void addBuilding(Building bldg, String comment) {
		this.getBuildings().put(bldg, comment);
	}
	
	public void removeBuilding(Building bldg) {
		this.getBuildings().remove(bldg);
	}

	@Column(name="employ_faculty", insertable=false)
	public String getEmployFaculty() {
		return this.employFaculty;
	}

	public void setEmployFaculty(String employFaculty) {
		this.employFaculty = employFaculty;
	}

	@ManyToOne
	@JoinColumn(name="evacuation_plan", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)	// NOTE: case when '0'
	public EvacuationPlan getEvacuationPlan() {
		return this.evacuationPlan;
	}

	public void setEvacuationPlan(EvacuationPlan evacuationPlan) {
		this.evacuationPlan = evacuationPlan;
	}

	@Column(name="cost_center", insertable=false)
	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	@Column(name="comment", insertable=false)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name="acad_staff", insertable=false)
	public int getAcademicStaffCount() {
		return this.academicStaffCount;
	}

	public void setAcademicStaffCount(int academicStaffCount) {
		this.academicStaffCount = academicStaffCount;
	}

	@Column(name="res_fellows", insertable=false)
	public int getResidentsAndFellowsCount() {
		return this.residentsAndFellowsCount;
	}

	public void setResidentsAndFellowsCount(int residentsAndFellowsCount) {
		this.residentsAndFellowsCount = residentsAndFellowsCount;
	}

	@Column(name="fulltime_staff", insertable=false)
	public int getFulltimeStaffCount() {
		return this.fulltimeStaffCount;
	}

	public void setFulltimeStaffCount(int fulltimeStaffCount) {
		this.fulltimeStaffCount = fulltimeStaffCount;
	}

	@Column(name="parttime_staff", insertable=false)
	public int getParttimeStaffCount() {
		return this.parttimeStaffCount;
	}

	public void setParttimeStaffCount(int parttimeStaffCount) {
		this.parttimeStaffCount = parttimeStaffCount;
	}

	@Column(name="student_staff", insertable=false)
	public int getStudentStaffCount() {
		return this.studentStaffCount;
	}

	public void setStudentStaffCount(int studentStaffCount) {
		this.studentStaffCount = studentStaffCount;
	}

	@Column(name="volunteers", insertable=false)
	public int getVolunteersCount() {
		return this.volunteersCount;
	}

	public void setVolunteersCount(int volunteersCount) {
		this.volunteersCount = volunteersCount;
	}

	@Column(name="guests", insertable=false)
	public int getGuestsCount() {
		return this.guestsCount;
	}

	public void setGuestsCount(int guestsCount) {
		this.guestsCount = guestsCount;
	}

	@Column(name="other_staff", insertable=false)
	public int getOtherStaffCount() {
		return this.otherStaffCount;
	}

	public void setOtherStaffCount(int otherStaffCount) {
		this.otherStaffCount = otherStaffCount;
	}

}
