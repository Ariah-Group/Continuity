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
import java.util.Map;

import org.kuali.continuity.dao.jpa.BaseSortableDomainObjectDAOImpl;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.dao.InstructionDAO;
import org.kuali.continuity.plan.domain.AllCoursesPractice;
import org.kuali.continuity.plan.domain.DepartmentalPractice;
import org.kuali.continuity.plan.domain.Instruction;

public class InstructionDAOImpl extends BaseSortableDomainObjectDAOImpl implements
		InstructionDAO {

	public void create(Instruction dObj) {
		super.create(dObj);
	}
	
	public void update(Instruction dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public Instruction getById(int id) {
		return (Instruction) super.getById(id);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Instruction> getListByOwnerId(int ownerId) {
		return (List<Instruction>) super.getListByOwnerId(ownerId);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Instruction> getSubListByOwnerId(int ownerId, int start, int limit) {
		return (List<Instruction>) super.getSubListByOwnerId(ownerId, start, limit);		
	}

	@SuppressWarnings("unchecked")
	public List<Instruction> getSortedListByOwnerId(int ownerId, SortByType sortBy, boolean isAscending) {
		return (List<Instruction>) super.getSortedListByOwnerId(ownerId, sortBy, isAscending);		
	}

	@SuppressWarnings("unchecked")
	public List<Instruction> getSortedSubListByOwnerId(int ownerId, int start, int limit, SortByType sortBy, boolean isAscending) {
		return (List<Instruction>) super.getSortedSubListByOwnerId(ownerId, start, limit, sortBy, isAscending);		
	}

	@Override
	public Map<AllCoursesPractice.Type, AllCoursesPractice> getAllCoursesPractices(int id) {
		return this.getById(id).getAllCoursesPractices();
	}

	@Override
	public Map<DepartmentalPractice.Type, DepartmentalPractice> getDepartmentalPractices(int id) {
		return this.getById(id).getDepartmentalPractices();
	}

	@Override
	public void updateAllCoursesPractices(int id,
			Map<AllCoursesPractice.Type, AllCoursesPractice> practices) {
		Instruction instruction = this.getById(id);
		instruction.setAllCoursesPractices(practices);
		this.update(instruction);
	}

	@Override
	public void updateDepartmentalPractices(
			int id, Map<DepartmentalPractice.Type, DepartmentalPractice> practices) {
		Instruction instruction = this.getById(id);
		instruction.setDepartmentalPractices(practices);
		this.update(instruction);
	}

	@Override
	protected Class<? extends BaseDomainObject> getDomainObjectClass() {
		return Instruction.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "Instruction.list";
	}

	@Override
	protected String getBaseQueryString() {
		return "select dObj from Instruction dObj where plan.id = :ownerId";
	}

	@Override
	protected String getNamedSizeQuery() {
		// not used
		return "";
	}

}
