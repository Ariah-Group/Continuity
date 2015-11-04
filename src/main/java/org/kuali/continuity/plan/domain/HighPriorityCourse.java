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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CourseCast;
import org.kuali.continuity.domain.SortByType;

@Entity
@Table(name="instruction_high_priority")
@NamedQuery(name="HighPriorityCourse.list", 
	query="select dObj from HighPriorityCourse dObj where instruction.id = :ownerId")
@SuppressWarnings("serial")
public class HighPriorityCourse extends BaseDomainObject {

	private Instruction instruction;
	private Course course;
	private CourseCast courseCast;
	private boolean isBspace;
	private boolean isOtherTeach;
	private String comment;
	
	public enum SortBy implements SortByType {
		id, name, courseNum;
		public String getSortByValue() {
			if (this.name().equals(courseNum.name()))
				return "course.num";
			return this.name();
		}
	}
	
	public HighPriorityCourse() {
		
	}
	
	@Id
	@Column(name="ihp_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	@Transient
	public String getName() {
		return super.getName();
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pis_id", nullable=false, updatable=false)
	public Instruction getInstruction() {
		return this.instruction;
	}
	
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}
	
	@Embedded
	public Course getCourse() {
		return this.course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	@ManyToOne
	@JoinColumn(name="course_cast")
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public CourseCast getCourseCast() {
		return this.courseCast;
	}
	
	public void setCourseCast(CourseCast courseCast) {
		this.courseCast = courseCast;
	}
	
	@Column(name="bspace", insertable=false)
	public boolean isBspace() {
		return this.isBspace;
	}
	
	public void setBspace(boolean isBspace) {
		this.isBspace = isBspace;
	}
	
	@Column(name="other_can_teach", insertable=false)
	public boolean isOtherTeach() {
		return this.isOtherTeach;
	}
	
	public void setOtherTeach(boolean isOtherTeach) {
		this.isOtherTeach = isOtherTeach;
	}

	@Column(name="comment", insertable=false)
	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}

	@PrePersist
	@PreUpdate
	public void checkNulls() {
		if (this.getCourseCast() == null || this.getCourseCast().getId().trim().length() == 0)
			this.setCourseCast(new CourseCast("0"));
	}
	
}
