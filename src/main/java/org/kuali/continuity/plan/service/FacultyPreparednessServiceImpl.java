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

import org.kuali.continuity.plan.dao.ActionItemDAO;
import org.kuali.continuity.plan.dao.FacultyPreparednessDAO;
import org.kuali.continuity.plan.domain.FacultyPreparedness;
import org.kuali.continuity.plan.domain.FacultyPreparednessActionItem;

public class FacultyPreparednessServiceImpl implements
		FacultyPreparednessService {
	
	private FacultyPreparednessDAO facultyPreparednessDAO;
	private ActionItemDAO actionItemDAO;

	public void createActionItem(FacultyPreparednessActionItem obj) {
		this.actionItemDAO.create(obj);
	}

	public void deleteActionItem(int id) {
		this.actionItemDAO.delete(id);
	}

	public FacultyPreparednessActionItem getActionItem(int id) {
		return (FacultyPreparednessActionItem) this.actionItemDAO.getById(id);
	}

	public FacultyPreparedness getFacultyPreparedness(int planId) {
		return this.facultyPreparednessDAO.get(planId);
	}

	@SuppressWarnings("unchecked")
	public List<FacultyPreparednessActionItem> getActionItemList(int ownerId) {
		return (List<FacultyPreparednessActionItem>) this.actionItemDAO.getListByOwnerId(ownerId);
	}

	public void updateActionItem(FacultyPreparednessActionItem obj) {
		this.actionItemDAO.update(obj);
	}

	public FacultyPreparednessDAO getFacultyPreparednessDAO() {
		return this.facultyPreparednessDAO;
	}

	public void setFacultyPreparednessDAO(
			FacultyPreparednessDAO facultyPreparednessDAO) {
		this.facultyPreparednessDAO = facultyPreparednessDAO;
	}

	public ActionItemDAO getActionItemDAO() {
		return this.actionItemDAO;
	}

	public void setActionItemDAO(ActionItemDAO actionItemDAO) {
		this.actionItemDAO = actionItemDAO;
	}

}
