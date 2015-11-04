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
import org.kuali.continuity.plan.dao.TeachingIssueDAO;
import org.kuali.continuity.plan.domain.TeachingIssue;

public class TeachingIssueServiceImpl implements TeachingIssueService {

	private TeachingIssueDAO serverDAO;

	public void create(TeachingIssue obj) {
		this.serverDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((TeachingIssue)obj);
	}

	public void update(TeachingIssue obj) {
		this.serverDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((TeachingIssue)obj);
	}

	public void delete(int id) {
		this.serverDAO.delete(id);
	}

	public TeachingIssue getById(int id) {
		return this.serverDAO.getById(id);
	}

	public List<TeachingIssue> getListByOwnerId(int ownerId) {
		return this.serverDAO.getListByOwnerId(ownerId);
	}

	public TeachingIssueDAO getTeachingIssueDAO() {
		return this.serverDAO;
	}

	public void setTeachingIssueDAO(TeachingIssueDAO serverDAO) {
		this.serverDAO = serverDAO;
	}

}
