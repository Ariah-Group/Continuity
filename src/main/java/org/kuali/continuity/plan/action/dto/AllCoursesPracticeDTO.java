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

import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.InstructionSelect1;
import org.kuali.continuity.domain.InstructionSelect2;
import org.kuali.continuity.plan.domain.AllCoursesPractice;

public class AllCoursesPracticeDTO extends PracticeDTO {
	
	public RefDTO departmentExpansion = new RefDTO();
	
	public AllCoursesPracticeDTO() {
		super();
	}
	
	public AllCoursesPracticeDTO(AllCoursesPractice dObj) {
		super(dObj);
		this.departmentExpansion = new RefDTO(dObj.getDepartmentExpansion());
	}
	
	public AllCoursesPractice getPractice() {
		AllCoursesPractice dObj = new AllCoursesPractice();
		dObj.setDepartmentExpansion(new InstructionSelect2(this.departmentExpansion.id.equals("0") ? "" : this.departmentExpansion.id));
		dObj.setCurrentUsage(new InstructionSelect1(this.currentUsage.id.equals("0") ? "" : this.currentUsage.id));
		dObj.setComment(this.comment);
		return dObj;
	}

}
