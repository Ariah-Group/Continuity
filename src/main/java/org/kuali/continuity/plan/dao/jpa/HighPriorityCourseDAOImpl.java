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
package org.kuali.continuity.plan.dao.jpa;

import java.util.List;

import org.kuali.continuity.dao.jpa.BaseSortableDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.HighPriorityCourseDAO;
import org.kuali.continuity.plan.domain.HighPriorityCourse;

public class HighPriorityCourseDAOImpl extends BaseSortableDomainObjectDAOImpl implements
		HighPriorityCourseDAO {

	public void create(HighPriorityCourse dObj) {
		super.create(dObj);
	}
	
	public void update(HighPriorityCourse dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public HighPriorityCourse getById(int id) {
		return (HighPriorityCourse) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<HighPriorityCourse> getListByOwnerId(int ownerId) {
		return (List<HighPriorityCourse>) super.getSortedListByOwnerId(ownerId, HighPriorityCourse.SortBy.courseNum, true);
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return HighPriorityCourse.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "HighPriorityCourse.list";
	}

	@Override
	protected String getBaseQueryString() {
		return "select dObj from HighPriorityCourse dObj where instruction.id = :ownerId";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "";
	}

}
