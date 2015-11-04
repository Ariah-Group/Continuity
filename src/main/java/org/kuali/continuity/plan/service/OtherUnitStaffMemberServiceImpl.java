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
import org.kuali.continuity.plan.dao.OtherUnitStaffMemberDAO;
import org.kuali.continuity.plan.domain.OtherUnitStaffMember;

public class OtherUnitStaffMemberServiceImpl implements
		OtherUnitStaffMemberService {
	
	private OtherUnitStaffMemberDAO otherUnitStaffMemberDAO;

	public void create(OtherUnitStaffMember obj) {
		this.otherUnitStaffMemberDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((OtherUnitStaffMember)obj);
	}

	public void update(OtherUnitStaffMember obj) {
		this.otherUnitStaffMemberDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((OtherUnitStaffMember)obj);
	}

	public void delete(int id) {
		this.otherUnitStaffMemberDAO.delete(id);
	}

	public OtherUnitStaffMember getById(int id) {
		return this.otherUnitStaffMemberDAO.getById(id);
	}

	public List<OtherUnitStaffMember> getListByOwnerId(int ownerId) {
		return this.otherUnitStaffMemberDAO.getListByOwnerId(ownerId);
	}

	public OtherUnitStaffMemberDAO getOtherUnitStaffMemberDAO() {
		return this.otherUnitStaffMemberDAO;
	}

	public void setOtherUnitStaffMemberDAO(OtherUnitStaffMemberDAO otherUnitStaffMemberDAO) {
		this.otherUnitStaffMemberDAO = otherUnitStaffMemberDAO;
	}

}
