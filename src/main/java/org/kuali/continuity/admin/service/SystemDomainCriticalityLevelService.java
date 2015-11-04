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
package org.kuali.continuity.admin.service;

import java.util.List;
import java.util.SortedMap;

import org.kuali.continuity.admin.domain.SystemDomainCriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.SystemCriticalityLevel;

public interface SystemDomainCriticalityLevelService {

	void create(SystemDomainCriticalityLevel dObj);
	void update(SystemDomainCriticalityLevel dObj);
	void updateAllDescriptions(List<SystemDomainCriticalityLevel> dObjList);
	void delete(Class<? extends SystemDomainCriticalityLevel> levelClass, int id);
	SystemDomainCriticalityLevel getById(Class<? extends SystemDomainCriticalityLevel> levelClass, int id);
	SystemCriticalityLevel getDefaultByLevelEnum(Class<? extends SystemDomainCriticalityLevel> levelClass, CriticalityLevelEnum levelEnum);
	SortedMap<CriticalityLevelEnum, ? extends CriticalityLevel> getListByOwnerId(
		Class<? extends SystemDomainCriticalityLevel> levelClass, int ownerId);

}
