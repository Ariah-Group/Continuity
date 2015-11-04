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
package org.kuali.continuity.plan.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.plan.domain.Consequence;
import org.kuali.continuity.plan.domain.CopingMethod;
import org.kuali.continuity.plan.domain.CriticalFunction;

public interface CriticalFunctionDAO {
	
	public enum SortBy implements SortByType {
		id, name;
		public String getSortByValue() {return this.name();}
	}
	
	// critical function
	void create(CriticalFunction criticalFunction);
	void update(CriticalFunction criticalFunction);
	void delete(int criticalFunctionId);
	CriticalFunction getById(int criticalFunctionId);
	List<CriticalFunction> getListByOwnerId(int planId);
	List<CriticalFunction> getSubListByOwnerId(int planId, int start, int limit);
	List<CriticalFunction> getSortedListByOwnerId(int planId, SortByType sortBy, boolean isAscending);
	List<CriticalFunction> getSortedSubListByOwnerId(int planId, int start, int limit, SortByType sortBy, boolean isAscending);
	List<CriticalFunction> getNonDeferrableSubListByOwnerId(int planId, int id);
	
	// description
	void updateDescriptions(int criticalFunctionId,
		String criticalFunctionName,
		String description,
		String performingUnits,
		String responsiblePersons);
	
	// peak periods
	void updatePeakPeriods(int criticalFunctionId,
		Set<Integer> peakPeriods,
		String peakExplanation);
	
	// dependencies
	void createDependency(int criticalFunctionId, Dependency dependency);
	void deleteDependency(int criticalFunctionId, Dependency dependency);
	void updateDependencies(int criticalFunctionId, Set<Dependency> dependencies);
	Set<Dependency> getDependencies(int criticalFunctionId);
	
	// consequences
	void updateConsequences(int criticalFunctionId, Map<Consequence.Type, Consequence> consequences);
	Map<Consequence.Type, Consequence> getConsequences(int criticalFunctionId);
	
	// how to cope
	void updateCopingMethod(int criticalFunctionId, CopingMethod copingMethod);
	CopingMethod getCopingMethod(int criticalFunctionId);

	// instruction
	CriticalFunction getInstructionCriticalFunctionByOwnerId(int planId);
	
}
