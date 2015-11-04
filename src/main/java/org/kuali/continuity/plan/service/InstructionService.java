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
package org.kuali.continuity.plan.service;

import java.util.List;

import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.service.BaseService;

public interface InstructionService extends BaseService {

	void create(Instruction obj);
	void update(Instruction obj);
	void delete(int id);
	Instruction getById(int id);
	List<Instruction> getListByOwnerId(int ownerId);
	List<Instruction> getSubListByOwnerId(int ownerId, int start, int limit);
	List<Instruction> getSortedListByOwnerId(int ownerId, SortByType sortBy, boolean isAscending);
	List<Instruction> getSortedSubListByOwnerId(int ownerId, int start, int limit, SortByType sortBy, boolean isAscending);

}
