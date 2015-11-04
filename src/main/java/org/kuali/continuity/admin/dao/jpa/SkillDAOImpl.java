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
package org.kuali.continuity.admin.dao.jpa;

import java.util.List;

import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.dao.SkillDAO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public class SkillDAOImpl extends BaseAdminOrderedDAOImpl implements SkillDAO, SimpleAdminDao {

	public void create(Skill dObj) {
		super.create(dObj);
	}
	
	public void update(Skill dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Skill getById(int id) {
		return (Skill) super.getById(id);
	}
	
	@Override
	public Skill getBySystemDomainIdAndName(int systemDomainId, String name) {
		return (Skill) super.getBySystemDomainIdAndName(systemDomainId, name);
	}
	
	@Override
	public Skill getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo) {
		return (Skill) super.getBySystemDomainIdAndOrderNo(systemDomainId, orderNo);
	}

	@Override
	public Skill getHighestOrderedObjectBySystemDomainId(int systemDomainId) {
		return (Skill) super.getHighestOrderedObjectBySystemDomainId(systemDomainId);
	}

	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Skill> getListBySystemDomainId(int systemDomainId) {
		return (List<Skill>) super.getListBySystemDomainId(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Skill> getSubListBySystemDomainId(int systemDomainId, int start, int limit) {
		return (List<Skill>) super.getSubListBySystemDomainId(systemDomainId, start, limit);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Skill> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending) {
		return (List<Skill>) super.getSortedListBySystemDomainId(systemDomainId, sortBy, isAscending);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Skill> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Skill>) super.getSortedSubListBySystemDomainId(systemDomainId, start, limit, sortBy, isAscending);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Skill> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo) {
		return (List<Skill>) super.getSubListBySystemDomainIdAndStartOrderNo(systemDomainId, startOrderNo);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return Skill.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Skill.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "Skill.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM Skill dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
