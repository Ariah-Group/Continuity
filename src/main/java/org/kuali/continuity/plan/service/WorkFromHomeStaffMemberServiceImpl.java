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
import org.kuali.continuity.plan.dao.WorkFromHomeStaffMemberDAO;
import org.kuali.continuity.plan.domain.WorkFromHomeStaffMember;

public class WorkFromHomeStaffMemberServiceImpl implements
		WorkFromHomeStaffMemberService {

	private WorkFromHomeStaffMemberDAO workFromHomeStaffMemberDAO;

	public void create(WorkFromHomeStaffMember obj) {
		this.workFromHomeStaffMemberDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((WorkFromHomeStaffMember)obj);
	}

	public void update(WorkFromHomeStaffMember obj) {
		this.workFromHomeStaffMemberDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((WorkFromHomeStaffMember)obj);
	}

	public void delete(int id) {
		this.workFromHomeStaffMemberDAO.delete(id);
	}

	public WorkFromHomeStaffMember getById(int id) {
		return this.workFromHomeStaffMemberDAO.getById(id);
	}

	public List<WorkFromHomeStaffMember> getListByOwnerId(int ownerId) {
		return this.workFromHomeStaffMemberDAO.getListByOwnerId(ownerId);
	}

	public WorkFromHomeStaffMemberDAO getWorkFromHomeStaffMemberDAO() {
		return this.workFromHomeStaffMemberDAO;
	}

	public void setWorkFromHomeStaffMemberDAO(WorkFromHomeStaffMemberDAO workFromHomeStaffMemberDAO) {
		this.workFromHomeStaffMemberDAO = workFromHomeStaffMemberDAO;
	}

}
