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

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.CourseCast;
import org.kuali.continuity.plan.domain.Course;
import org.kuali.continuity.plan.domain.HighPriorityCourse;
import org.kuali.continuity.plan.domain.Instruction;

@SuppressWarnings("serial")
public class HighPriorityCourseDTO extends DomainObjectDTO implements
		DomainObjectValue, DTOValue {
	
	public DomainObjectDTO instruction = new DomainObjectDTO();
	public String courseNum;
	public String courseTitle;
	public RefDTO courseCast = new RefDTO();
	public boolean isBspace;
	public boolean isOtherTeach;
	public String comment;

	public HighPriorityCourseDTO() {
		super();
	}

	public HighPriorityCourseDTO(BaseDomainObject obj) {
		super(obj);
	}

	public HighPriorityCourseDTO(int id, String name) {
		super(id, name);
	}

	public HighPriorityCourseDTO(int id) {
		super(id);
	}

	public HighPriorityCourseDTO(HighPriorityCourse obj) {
		this.copyFromDomainObject(obj);
	}

	@Override
	public HighPriorityCourse getDomainObject() {
		HighPriorityCourse dObj = new HighPriorityCourse();
		dObj.setId(this.id == 0 ? null : this.id);
		if (this.instruction != null && this.instruction.id != 0)
			dObj.setInstruction(new Instruction(this.instruction.id));
		dObj.setCourse(new Course(this.courseNum, this.courseTitle));
		dObj.setCourseCast(new CourseCast(this.courseCast.id));
		dObj.setBspace(this.isBspace);
		dObj.setOtherTeach(this.isOtherTeach);
		dObj.setComment(this.comment);
		return dObj;
	}

	@Override
	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof HighPriorityCourse)) return;
		HighPriorityCourse obj = (HighPriorityCourse) copyObj;
		
		// set other fields
		if (obj.getCourse() != null) {
			this.courseNum = obj.getCourse().getNum();
			this.courseTitle = obj.getCourse().getTitle();
		}
		this.courseCast = new RefDTO(obj.getCourseCast());
		this.isBspace = obj.isBspace();
		this.isOtherTeach = obj.isOtherTeach();
		this.comment = obj.getComment();
	}

}
