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
import org.kuali.continuity.plan.dao.HighPriorityCourseDAO;
import org.kuali.continuity.plan.domain.HighPriorityCourse;

public class HighPriorityCourseServiceImpl implements HighPriorityCourseService {

	private HighPriorityCourseDAO highPriorityCourseDAO;

	public void create(HighPriorityCourse obj) {
		this.highPriorityCourseDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((HighPriorityCourse)obj);
	}

	public void update(HighPriorityCourse obj) {
		this.highPriorityCourseDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((HighPriorityCourse)obj);
	}

	public void update(List<HighPriorityCourse> objs) {
		if (objs == null || objs.isEmpty()) return;
		for (HighPriorityCourse highPriorityCourse : objs) {
			this.highPriorityCourseDAO.update(highPriorityCourse);
		}
	}

	public void delete(int id) {
		this.highPriorityCourseDAO.delete(id);
	}

	public HighPriorityCourse getById(int id) {
		return this.highPriorityCourseDAO.getById(id);
	}

	public List<HighPriorityCourse> getListByOwnerId(int ownerId) {
		return this.highPriorityCourseDAO.getListByOwnerId(ownerId);
	}

	public HighPriorityCourseDAO getHighPriorityCourseDAO() {
		return this.highPriorityCourseDAO;
	}

	public void setHighPriorityCourseDAO(HighPriorityCourseDAO highPriorityCourseDAO) {
		this.highPriorityCourseDAO = highPriorityCourseDAO;
	}

}
