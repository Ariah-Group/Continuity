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
import java.util.TreeMap;

import org.kuali.continuity.admin.dao.GenericAdminDAO;
import org.kuali.continuity.admin.dao.GenericAdminDAOFactory;
import org.kuali.continuity.admin.domain.SystemDomainCriticalityLevel;
import org.kuali.continuity.dao.SystemCriticalityLevelDAO;
import org.kuali.continuity.dao.SystemCriticalityLevelDAOFactory;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.SystemCriticalityLevel;

@SuppressWarnings("unchecked")
public class SystemDomainCriticalityLevelServiceImpl implements
		SystemDomainCriticalityLevelService {
	
	private GenericAdminDAOFactory genericAdminDAOFactory;
	private SystemCriticalityLevelDAOFactory systemCriticalityLevelDAOFactory;
	
	@Override
	public void create(SystemDomainCriticalityLevel dObj) {
		this.getGenericAdminDAO(dObj.getClass()).create(dObj);
	}


	@Override
	public void delete(Class<? extends SystemDomainCriticalityLevel> levelClass, int id) {
		this.getGenericAdminDAO(levelClass).delete(id);
	}


	@Override
	public SystemDomainCriticalityLevel getById(Class<? extends SystemDomainCriticalityLevel> levelClass, int id) {
		return (SystemDomainCriticalityLevel) this.getGenericAdminDAO(levelClass).getById(id);
	}

	@Override
	public SystemCriticalityLevel getDefaultByLevelEnum(
			Class<? extends SystemDomainCriticalityLevel> levelClass,
			CriticalityLevelEnum levelEnum) {
		return this.getSystemCriticalityLevelDAO(levelClass).getSystemCriticalityLevel(levelEnum);
	}

	@Override
	public SortedMap<CriticalityLevelEnum, ? extends CriticalityLevel> getListByOwnerId(
			Class<? extends SystemDomainCriticalityLevel> levelClass, int ownerId) {
		// create map
		SortedMap<CriticalityLevelEnum, CriticalityLevel> levelMap = new TreeMap<CriticalityLevelEnum, CriticalityLevel>();
		
		// system levels
		List<SystemCriticalityLevel> sLevels = this.getSystemCriticalityLevelDAO(levelClass).getSystemCriticalityLevels();
		for (SystemCriticalityLevel sLevel : sLevels) {
			levelMap.put(sLevel.getCriticalityLevelEnum(), (CriticalityLevel) sLevel);
		}
		
		// system domain levels
		List<SystemDomainCriticalityLevel> sdLevels = this.getGenericAdminDAO(levelClass).getListBySystemDomainId(ownerId);
		if (sdLevels != null && !sdLevels.isEmpty()) {
			for (SystemDomainCriticalityLevel sdLevel : sdLevels) {
				levelMap.put(sdLevel.getCriticalityLevelEnum(), (CriticalityLevel)sdLevel);
			}
		}
			
		// return
		return levelMap;
	}

	@Override
	public void update(SystemDomainCriticalityLevel dObj) {
		this.getGenericAdminDAO(dObj.getClass()).update(dObj);	
	}
	
	@Override
	public void updateAllDescriptions(List<SystemDomainCriticalityLevel> dObjList) {
		if (dObjList == null || dObjList.isEmpty()) return;
		int systemDomainId = dObjList.get(0).getSystemDomainId();
		Class<? extends SystemDomainCriticalityLevel> clClass = dObjList.get(0).getClass();
		SortedMap<CriticalityLevelEnum, ? extends CriticalityLevel> map = 
			this.getListByOwnerId(clClass, systemDomainId);
		for (SystemDomainCriticalityLevel dObj : dObjList) {
			CriticalityLevel dObjOrig =
				map.get(dObj.getCriticalityLevelEnum());
			dObj.setLongDescription(dObjOrig.getLongDescription());
			dObj.setName(dObjOrig.getName());
			this.update(dObj);
		}
	}

	public GenericAdminDAO getGenericAdminDAO(Class<? extends SystemDomainCriticalityLevel> levelClass) {
		return (GenericAdminDAO<? extends SystemDomainCriticalityLevel>)
			this.genericAdminDAOFactory.getGenericAdminDAO(levelClass);
	}
	
	public SystemCriticalityLevelDAO getSystemCriticalityLevelDAO(Class<? extends SystemDomainCriticalityLevel> levelClass) {
		return this.systemCriticalityLevelDAOFactory.getSystemCriticalityLevelDAO(levelClass);
	}

	public GenericAdminDAOFactory getGenericAdminDAOFactory() {
		return this.genericAdminDAOFactory;
	}

	public void setGenericAdminDAOFactory(
			GenericAdminDAOFactory genericAdminDAOFactory) {
		this.genericAdminDAOFactory = genericAdminDAOFactory;
	}

	public SystemCriticalityLevelDAOFactory getSystemCriticalityLevelDAOFactory() {
		return this.systemCriticalityLevelDAOFactory;
	}

	public void setSystemCriticalityLevelDAOFactory(
			SystemCriticalityLevelDAOFactory systemCriticalityLevelDAOFactory) {
		this.systemCriticalityLevelDAOFactory = systemCriticalityLevelDAOFactory;
	}

}
