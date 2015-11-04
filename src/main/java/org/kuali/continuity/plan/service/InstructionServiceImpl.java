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

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.dao.InstructionDAO;
import org.kuali.continuity.plan.domain.Instruction;
import org.kuali.continuity.plan.domain.InstructionActionItem;

public class InstructionServiceImpl implements InstructionService {

	private InstructionDAO instructionDAO;
	private HighPriorityCourseService highPriorityCourseService;
	private TeachingIssueService teachingIssueService;
	private ActionItemServiceFactory actionItemServiceFactory;

	public void create(Instruction obj) {
		this.instructionDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((Instruction)obj);
	}

	public void update(Instruction obj) {
		this.instructionDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((Instruction)obj);
	}

	@SuppressWarnings("unchecked")
	public void delete(int id) {
		// delete action items first
		ActionItemService aiService = this.actionItemServiceFactory.getActionItemService(InstructionActionItem.class); 
		List<InstructionActionItem> ais = (List<InstructionActionItem>) aiService.getListByOwnerId(id);
		for (InstructionActionItem ai : ais) {
			aiService.delete(ai.getId());
		}
		
		// delete instruction
		this.instructionDAO.delete(id);
	}

	public Instruction getById(int id) {
		return this.instructionDAO.getById(id);
	}

	public List<Instruction> getListByOwnerId(int ownerId) {
		return this.instructionDAO.getListByOwnerId(ownerId);
	}

	public List<Instruction> getSortedListByOwnerId(int ownerId,
			SortByType sortBy, boolean isAscending) {
		return this.instructionDAO.getSortedListByOwnerId(ownerId, sortBy, isAscending);
	}

	public List<Instruction> getSortedSubListByOwnerId(int ownerId, int start,
			int limit, SortByType sortBy, boolean isAscending) {
		return this.instructionDAO.getSortedSubListByOwnerId(ownerId, start, limit, sortBy, isAscending);
	}

	public List<Instruction> getSubListByOwnerId(int ownerId, int start,
			int limit) {
		return this.instructionDAO.getSubListByOwnerId(ownerId, start, limit);
	}

	public InstructionDAO getInstructionDAO() {
		return this.instructionDAO;
	}

	public void setInstructionDAO(InstructionDAO serverDAO) {
		this.instructionDAO = serverDAO;
	}

	public HighPriorityCourseService getHighPriorityCourseService() {
		return this.highPriorityCourseService;
	}

	public void setHighPriorityCourseService(
			HighPriorityCourseService highPriorityCourseService) {
		this.highPriorityCourseService = highPriorityCourseService;
	}

	public TeachingIssueService getTeachingIssueService() {
		return this.teachingIssueService;
	}

	public void setTeachingIssueService(TeachingIssueService teachingIssueService) {
		this.teachingIssueService = teachingIssueService;
	}

	public ActionItemServiceFactory getActionItemServiceFactory() {
		return this.actionItemServiceFactory;
	}

	public void setActionItemServiceFactory(
			ActionItemServiceFactory actionItemServiceFactory) {
		this.actionItemServiceFactory = actionItemServiceFactory;
	}

}
