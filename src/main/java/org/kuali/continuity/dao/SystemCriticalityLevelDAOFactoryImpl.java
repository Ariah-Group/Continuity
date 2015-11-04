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
package org.kuali.continuity.dao;

import java.util.Map;

import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.SystemCriticalityLevel;

public class SystemCriticalityLevelDAOFactoryImpl implements
		SystemCriticalityLevelDAOFactory {

	private Map<Class<? extends CriticalityLevel>, SystemCriticalityLevelDAO<? extends SystemCriticalityLevel>> daoMap;

	@Override
	public SystemCriticalityLevelDAO<? extends SystemCriticalityLevel> getSystemCriticalityLevelDAO(
			Class<? extends CriticalityLevel> criticalityLevelClass) {
		return this.daoMap.get(criticalityLevelClass);
	}

	public Map<Class<? extends CriticalityLevel>, SystemCriticalityLevelDAO<? extends SystemCriticalityLevel>> getDaoMap() {
		return this.daoMap;
	}

	public void setDaoMap(
			Map<Class<? extends CriticalityLevel>, SystemCriticalityLevelDAO<? extends SystemCriticalityLevel>> daoMap) {
		this.daoMap = daoMap;
	}

}
