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
package org.kuali.continuity.admin.dao;

import java.util.List;

import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.domain.SortByType;

@Deprecated
public interface SkillDAO extends BaseAdminOrderedDAO {
	
	void create(Skill skill);
	void update(Skill skill);
	void delete(int id);
	Skill getById(int id);
	Skill getBySystemDomainIdAndName(int systemDomainId, String name);
	Skill getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	Skill getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<Skill> getListBySystemDomainId(int systemDomainId);
	List<Skill> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<Skill> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<Skill> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	
}
