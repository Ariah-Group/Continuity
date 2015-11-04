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
package org.kuali.continuity.plan.dao;

import java.util.List;
import java.util.Map;

import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.domain.AllCoursesPractice;
import org.kuali.continuity.plan.domain.DepartmentalPractice;
import org.kuali.continuity.plan.domain.Instruction;

public interface InstructionDAO {

	// instruction
	void create(Instruction dObj);
	void update(Instruction dObj);
	void delete(int id);
	Instruction getById(int id);
	List<Instruction> getListByOwnerId(int ownerId);
	List<Instruction> getSubListByOwnerId(int ownerId, int start, int limit);
	List<Instruction> getSortedListByOwnerId(int ownerId, SortByType sortBy, boolean isAscending);
	List<Instruction> getSortedSubListByOwnerId(int ownerId, int start, int limit, SortByType sortBy, boolean isAscending);

	// all courses
	void updateAllCoursesPractices(int id, Map<AllCoursesPractice.Type, AllCoursesPractice> practices);
	Map<AllCoursesPractice.Type, AllCoursesPractice> getAllCoursesPractices(int id);
	
	// departmental
	void updateDepartmentalPractices(int id, Map<DepartmentalPractice.Type, DepartmentalPractice> practices);
	Map<DepartmentalPractice.Type, DepartmentalPractice> getDepartmentalPractices(int id);
	
}
