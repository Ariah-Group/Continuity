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
import org.kuali.continuity.plan.dao.KeyStaffMemberDAO;
import org.kuali.continuity.plan.domain.KeyStaffMember;

public class KeyStaffMemberServiceImpl implements KeyStaffMemberService {

	private KeyStaffMemberDAO keyStaffMemberDAO;

	public void create(KeyStaffMember obj) {
		this.keyStaffMemberDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((KeyStaffMember)obj);
	}

	public void update(KeyStaffMember obj) {
		this.keyStaffMemberDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((KeyStaffMember)obj);
	}

	public void delete(int id) {
		this.keyStaffMemberDAO.delete(id);
	}

	public KeyStaffMember getById(int id) {
		return this.keyStaffMemberDAO.getById(id);
	}

	public List<KeyStaffMember> getListByOwnerId(int ownerId) {
		return this.keyStaffMemberDAO.getListByOwnerId(ownerId);
	}

	public KeyStaffMemberDAO getKeyStaffMemberDAO() {
		return this.keyStaffMemberDAO;
	}

	public void setKeyStaffMemberDAO(KeyStaffMemberDAO keyStaffMemberDAO) {
		this.keyStaffMemberDAO = keyStaffMemberDAO;
	}

}
