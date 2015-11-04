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

import org.kuali.continuity.domain.InstructionSelect1;
import org.kuali.continuity.domain.InstructionSelect2;

public class AllCoursesPractice extends Practice {
	
	private InstructionSelect2 departmentExpansion;
	
	public AllCoursesPractice() {
		
	}
	
	public AllCoursesPractice(InstructionSelect1 currentUsage, 
			InstructionSelect2 departmentExpansion, String comment) {
		this.setCurrentUsage(currentUsage);
		this.setDepartmentExpansion(departmentExpansion);
		this.setComment(comment);
	}

	public InstructionSelect2 getDepartmentExpansion() {
		return this.departmentExpansion;
	}

	public void setDepartmentExpansion(InstructionSelect2 departmentExpansion) {
		this.departmentExpansion = departmentExpansion;
	}

	public enum Type implements Practice.Type {
		BSPACE,
		BSPACE_GRADE,
		GSI_COMMUNICATION,
		COMMON_MATERIALS
	}

}
