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

import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.InstructionSelect1;
import org.kuali.continuity.domain.InstructionSelect2;
import org.kuali.continuity.domain.InstructionSelect3;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.domain.ext.AllCoursesPractices;
import org.kuali.continuity.plan.domain.ext.DepartmentalPractices;

@Entity
@Table(name="plans_instructions")
@NamedQuery(name="Instruction.list", 
	query="SELECT dObj FROM Instruction dObj WHERE dObj.plan.id = :ownerId")
@SuppressWarnings("serial")
public class Instruction extends BaseDomainObject {

	private ContinuityPlan plan;
	private InstructionalDepartment department;
	private List<HighPriorityCourse> highPriorityCourses;
	private AllCoursesPractices allCoursesPracticesExt;
	private DepartmentalPractices departmentalPracticesExt;
	private List<TeachingIssue> specialTeachingIssues;
	private List<InstructionActionItem> actionItems;

	public enum SortBy implements SortByType {
		id, name;
		public String getSortByValue() {return this.name();}
	}
	
	public Instruction() {
		super();
	}
	
	public Instruction(Integer id) {
		super(id);
	}
	
	@Id
	@Column(name="pis_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false, updatable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	@JoinColumn(name="InstructionalDepartmentID", nullable=false)
	public InstructionalDepartment getDepartment() {
		return this.department;
	}

	public void setDepartment(InstructionalDepartment department) {
		this.department = department;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pis_id", insertable=false, updatable=false) 
	public List<HighPriorityCourse> getHighPriorityCourses() {
		return this.highPriorityCourses;
	}

	public void setHighPriorityCourses(List<HighPriorityCourse> highPriorityCourses) {
		this.highPriorityCourses = highPriorityCourses;
	}

	@Embedded
	private AllCoursesPractices getAllCoursesPracticesExt() {
		return this.allCoursesPracticesExt;
	}

	private void setAllCoursesPracticesExt(AllCoursesPractices allCoursesPracticesExt) {
		this.allCoursesPracticesExt = allCoursesPracticesExt;
	}

	@Embedded
	private DepartmentalPractices getDepartmentalPracticesExt() {
		return this.departmentalPracticesExt;
	}

	private void setDepartmentalPracticesExt(
			DepartmentalPractices departmentalPracticesExt) {
		this.departmentalPracticesExt = departmentalPracticesExt;
	}

	@Transient
	public Map<AllCoursesPractice.Type, AllCoursesPractice> getAllCoursesPractices() {
		if (this.getAllCoursesPracticesExt() == null) return null;
		return this.getAllCoursesPracticesExt().getAllCoursesPractices();
	}

	public void setAllCoursesPractices(Map<AllCoursesPractice.Type, AllCoursesPractice> allCoursesPractices) {
		if (this.getAllCoursesPracticesExt() == null)
			this.setAllCoursesPracticesExt(new AllCoursesPractices());
		this.getAllCoursesPracticesExt().setAllCoursesPractices(allCoursesPractices);
	}

	@Transient
	public Map<DepartmentalPractice.Type, DepartmentalPractice> getDepartmentalPractices() {
		if (this.getDepartmentalPracticesExt() == null) return null;
		return this.getDepartmentalPracticesExt().getDepartmentalPractices();
	}

	public void setDepartmentalPractices(Map<DepartmentalPractice.Type, DepartmentalPractice> departmentalPractices) {
		if (this.getDepartmentalPracticesExt() == null)
			this.setDepartmentalPracticesExt(new DepartmentalPractices());
		this.getDepartmentalPracticesExt().setDepartmentalPractices(departmentalPractices);
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pis_id", insertable=false, updatable=false) 
	public List<TeachingIssue> getSpecialTeachingIssues() {
		return this.specialTeachingIssues;
	}

	public void setSpecialTeachingIssues(
			List<TeachingIssue> specialTeachingIssues) {
		this.specialTeachingIssues = specialTeachingIssues;
	}

	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="pis_id", insertable=false, updatable=false) 
	public List<InstructionActionItem> getActionItems() {
		return this.actionItems;
	}

	public void setActionItems(List<InstructionActionItem> actionItems) {
		this.actionItems = actionItems;
	}

	@PreUpdate
	public void checkNullUpdates() {
		if (this.getAllCoursesPracticesExt().getBspaceCurrentUsage() == null)
			this.getAllCoursesPracticesExt().setBspaceCurrentUsage(new InstructionSelect1(""));
		if (this.getAllCoursesPracticesExt().getBspaceGradeCurrentUsage() == null)
			this.getAllCoursesPracticesExt().setBspaceGradeCurrentUsage(new InstructionSelect1(""));
		if (this.getAllCoursesPracticesExt().getCommonMaterialsCurrentUsage() == null)
			this.getAllCoursesPracticesExt().setCommonMaterialsCurrentUsage(new InstructionSelect1(""));
		if (this.getAllCoursesPracticesExt().getGsiCommunicationCurrentUsage() == null)
			this.getAllCoursesPracticesExt().setGsiCommunicationCurrentUsage(new InstructionSelect1(""));
		if (this.getAllCoursesPracticesExt().getBspaceDepartmentExpansion() == null)
			this.getAllCoursesPracticesExt().setBspaceDepartmentExpansion(new InstructionSelect2(""));
		if (this.getAllCoursesPracticesExt().getBspaceGradeDepartmentExpansion() == null)
			this.getAllCoursesPracticesExt().setBspaceGradeDepartmentExpansion(new InstructionSelect2(""));
		if (this.getAllCoursesPracticesExt().getCommonMaterialsDepartmentExpansion() == null)
			this.getAllCoursesPracticesExt().setCommonMaterialsDepartmentExpansion(new InstructionSelect2(""));
		if (this.getAllCoursesPracticesExt().getGsiCommunicationDepartmentExpansion() == null)
			this.getAllCoursesPracticesExt().setGsiCommunicationDepartmentExpansion(new InstructionSelect2(""));
		if (this.getDepartmentalPracticesExt().getBackupPersonnelCurrentUsage() == null)
			this.getDepartmentalPracticesExt().setBackupPersonnelCurrentUsage(new InstructionSelect3(""));
		if (this.getDepartmentalPracticesExt().getCommunicationCurrentUsage() == null)
			this.getDepartmentalPracticesExt().setCommunicationCurrentUsage(new InstructionSelect3(""));
		if (this.getDepartmentalPracticesExt().getFacultyRecallCurrentUsage() == null)
			this.getDepartmentalPracticesExt().setFacultyRecallCurrentUsage(new InstructionSelect3(""));
		if (this.getDepartmentalPracticesExt().getPedagogyCurrentUsage() == null)
			this.getDepartmentalPracticesExt().setPedagogyCurrentUsage(new InstructionSelect3(""));
	}

}
