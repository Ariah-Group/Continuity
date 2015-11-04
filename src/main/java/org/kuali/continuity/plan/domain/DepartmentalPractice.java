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

import org.kuali.continuity.domain.InstructionSelect3;

public class DepartmentalPractice extends Practice {
	
	public DepartmentalPractice() {
		
	}
	
	public DepartmentalPractice(InstructionSelect3 currentUsage, String comment) {
		super.setCurrentUsage(currentUsage);
		super.setComment(comment);
	}
	
	public enum Type implements Practice.Type {
		PRIORITIZE_COURSE,
		COMMUNICATION,
		BACKUP_PERSONNEL,
		FACULTY_RECALL,
		PEDAGOGY
	}

}
