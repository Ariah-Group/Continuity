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
package org.kuali.continuity.plan.domain.ext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.domain.InstructionSelect1;
import org.kuali.continuity.domain.InstructionSelect2;
import org.kuali.continuity.plan.domain.AllCoursesPractice;

@Embeddable
@SuppressWarnings("serial")
public class AllCoursesPractices implements Serializable {
	
	private InstructionSelect1 bspaceCurrentUsage;
	private InstructionSelect2 bspaceDepartmentExpansion;
	private String bspaceComment;
	private InstructionSelect1 bspaceGradeCurrentUsage;
	private InstructionSelect2 bspaceGradeDepartmentExpansion;
	private String bspaceGradeComment;
	private InstructionSelect1 gsiCommunicationCurrentUsage;
	private InstructionSelect2 gsiCommunicationDepartmentExpansion;
	private String gsiCommunicationComment;
	private InstructionSelect1 commonMaterialsCurrentUsage;
	private InstructionSelect2 commonMaterialsDepartmentExpansion;
	private String commonMaterialsComment;

	public AllCoursesPractices() {
		
	}

	@ManyToOne
	@JoinColumn(name="b_bSpace_usage", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect1 getBspaceCurrentUsage() {
		return this.bspaceCurrentUsage;
	}

	public void setBspaceCurrentUsage(InstructionSelect1 bspaceCurrentUsage) {
		this.bspaceCurrentUsage = bspaceCurrentUsage;
	}

	@ManyToOne
	@JoinColumn(name="b_bSpace_expand", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect2 getBspaceDepartmentExpansion() {
		return this.bspaceDepartmentExpansion;
	}

	public void setBspaceDepartmentExpansion(
			InstructionSelect2 bspaceDepartmentExpansion) {
		this.bspaceDepartmentExpansion = bspaceDepartmentExpansion;
	}

	@Column(name="b_bSpace_comment", insertable=false)
	public String getBspaceComment() {
		return this.bspaceComment;
	}

	public void setBspaceComment(String bspaceComment) {
		this.bspaceComment = bspaceComment;
	}

	@ManyToOne
	@JoinColumn(name="b_bSpace_grade_usage", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect1 getBspaceGradeCurrentUsage() {
		return this.bspaceGradeCurrentUsage;
	}

	public void setBspaceGradeCurrentUsage(
			InstructionSelect1 bspaceGradeCurrentUsage) {
		this.bspaceGradeCurrentUsage = bspaceGradeCurrentUsage;
	}

	@ManyToOne
	@JoinColumn(name="b_bSpace_grade_expand", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect2 getBspaceGradeDepartmentExpansion() {
		return this.bspaceGradeDepartmentExpansion;
	}

	public void setBspaceGradeDepartmentExpansion(
			InstructionSelect2 bspaceGradeDepartmentExpansion) {
		this.bspaceGradeDepartmentExpansion = bspaceGradeDepartmentExpansion;
	}

	@Column(name="b_bSpace_grade_comment", insertable=false)
	public String getBspaceGradeComment() {
		return this.bspaceGradeComment;
	}

	public void setBspaceGradeComment(String bspaceGradeComment) {
		this.bspaceGradeComment = bspaceGradeComment;
	}

	@ManyToOne
	@JoinColumn(name="b_gsi_communication_usage", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect1 getGsiCommunicationCurrentUsage() {
		return this.gsiCommunicationCurrentUsage;
	}

	public void setGsiCommunicationCurrentUsage(
			InstructionSelect1 gsiCommunicationCurrentUsage) {
		this.gsiCommunicationCurrentUsage = gsiCommunicationCurrentUsage;
	}

	@ManyToOne
	@JoinColumn(name="b_gsi_communication_expand", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect2 getGsiCommunicationDepartmentExpansion() {
		return this.gsiCommunicationDepartmentExpansion;
	}

	public void setGsiCommunicationDepartmentExpansion(
			InstructionSelect2 gsiCommunicationDepartmentExpansion) {
		this.gsiCommunicationDepartmentExpansion = gsiCommunicationDepartmentExpansion;
	}

	@Column(name="b_gsi_communication_comment", insertable=false)
	public String getGsiCommunicationComment() {
		return this.gsiCommunicationComment;
	}

	public void setGsiCommunicationComment(String gsiCommunicationComment) {
		this.gsiCommunicationComment = gsiCommunicationComment;
	}

	@ManyToOne
	@JoinColumn(name="b_common_materials_usage", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect1 getCommonMaterialsCurrentUsage() {
		return this.commonMaterialsCurrentUsage;
	}

	public void setCommonMaterialsCurrentUsage(
			InstructionSelect1 commonMaterialsCurrentUsage) {
		this.commonMaterialsCurrentUsage = commonMaterialsCurrentUsage;
	}

	@ManyToOne
	@JoinColumn(name="b_common_materials_expand", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect2 getCommonMaterialsDepartmentExpansion() {
		return this.commonMaterialsDepartmentExpansion;
	}

	public void setCommonMaterialsDepartmentExpansion(
			InstructionSelect2 commonMaterialsDepartmentExpansion) {
		this.commonMaterialsDepartmentExpansion = commonMaterialsDepartmentExpansion;
	}
	
	@Column(name="b_common_materials_comment", insertable=false)
	public String getCommonMaterialsComment() {
		return this.commonMaterialsComment;
	}

	public void setCommonMaterialsComment(String commonMaterialsComment) {
		this.commonMaterialsComment = commonMaterialsComment;
	}

	@Transient
	public Map<AllCoursesPractice.Type, AllCoursesPractice> getAllCoursesPractices() {
		Map<AllCoursesPractice.Type, AllCoursesPractice> practices =
			new HashMap<AllCoursesPractice.Type, AllCoursesPractice>();
		practices.put(AllCoursesPractice.Type.BSPACE,
			new AllCoursesPractice(this.bspaceCurrentUsage, this.bspaceDepartmentExpansion, this.bspaceComment));
		practices.put(AllCoursesPractice.Type.BSPACE_GRADE,
			new AllCoursesPractice(this.bspaceGradeCurrentUsage, this.bspaceGradeDepartmentExpansion, this.bspaceGradeComment));
		practices.put(AllCoursesPractice.Type.GSI_COMMUNICATION,
			new AllCoursesPractice(this.gsiCommunicationCurrentUsage, this.gsiCommunicationDepartmentExpansion, this.gsiCommunicationComment));
		practices.put(AllCoursesPractice.Type.COMMON_MATERIALS,
			new AllCoursesPractice(this.commonMaterialsCurrentUsage, this.commonMaterialsDepartmentExpansion, this.commonMaterialsComment));
		return practices;
	}
	
	public void setAllCoursesPractices(Map<AllCoursesPractice.Type, AllCoursesPractice> practices) {
		if (practices == null) return;
		Set<AllCoursesPractice.Type> types = practices.keySet();
		for (AllCoursesPractice.Type type : types) {
			AllCoursesPractice practice = practices.get(type);
			if (practice == null) continue;
			InstructionSelect1 currentUsage = (InstructionSelect1) practice.getCurrentUsage();
			InstructionSelect2 departmentExpansion = practice.getDepartmentExpansion();
			String comment = practice.getComment();
			if (type == AllCoursesPractice.Type.BSPACE) {
				this.setBspaceCurrentUsage(currentUsage);
				this.setBspaceDepartmentExpansion(departmentExpansion);
				this.setBspaceComment(comment);
			} else if (type == AllCoursesPractice.Type.BSPACE_GRADE) {
				this.setBspaceGradeCurrentUsage(currentUsage);
				this.setBspaceGradeDepartmentExpansion(departmentExpansion);
				this.setBspaceGradeComment(comment);
			} else if (type == AllCoursesPractice.Type.GSI_COMMUNICATION) {
				this.setGsiCommunicationCurrentUsage(currentUsage);
				this.setGsiCommunicationDepartmentExpansion(departmentExpansion);
				this.setGsiCommunicationComment(comment);
			} else if (type == AllCoursesPractice.Type.COMMON_MATERIALS) {
				this.setCommonMaterialsCurrentUsage(currentUsage);
				this.setCommonMaterialsDepartmentExpansion(departmentExpansion);
				this.setCommonMaterialsComment(comment);
			}
		}
	}

}
