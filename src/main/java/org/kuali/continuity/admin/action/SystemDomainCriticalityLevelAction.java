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
package org.kuali.continuity.admin.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionValue;
import org.kuali.continuity.admin.domain.SystemDomainCentralApplicationCriticalityLevel;
import org.kuali.continuity.admin.domain.SystemDomainCriticalFunctionCriticalityLevel;
import org.kuali.continuity.admin.domain.SystemDomainCriticalityLevel;
import org.kuali.continuity.admin.service.SystemDomainCriticalityLevelService;
import org.kuali.continuity.domain.CentralApplicationCriticalityLevel;
import org.kuali.continuity.domain.CriticalFunctionCriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.SystemCriticalityLevel;
import org.kuali.continuity.plan.action.dto.SystemDomainCriticalityLevelDTO;

@SuppressWarnings("serial")
public class SystemDomainCriticalityLevelAction extends BaseActionSupport {

	private SystemDomainCriticalityLevelService systemDomainCriticalityLevelService;
	private Map<String, SystemDomainCriticalityLevelDTO> clFuncMap;
	private Map<String, SystemDomainCriticalityLevelDTO> clApplMap;

	private String clType;
	private String clEnum;
	
	public class TmpSessionValue implements SessionValue {
		private Map<SystemDomainCriticalityLevelDTO.LevelType, Map<String, SystemDomainCriticalityLevelDTO>> sessionValue
			= new HashMap<SystemDomainCriticalityLevelDTO.LevelType, Map<String, SystemDomainCriticalityLevelDTO>>();
		
		public Map<SystemDomainCriticalityLevelDTO.LevelType, Map<String, SystemDomainCriticalityLevelDTO>> getSessionValue() {
			return this.sessionValue;
		}
		
		public void setSessionValue(Map<SystemDomainCriticalityLevelDTO.LevelType, Map<String, SystemDomainCriticalityLevelDTO>> sessionValue) {
			this.sessionValue = sessionValue; 
		}
		
		public Map<String, SystemDomainCriticalityLevelDTO> getFromSessionCLMap(SystemDomainCriticalityLevelDTO.LevelType levelType) {
			return this.sessionValue.get(levelType);
		}
		
		public void putInSessionCLMap(SystemDomainCriticalityLevelDTO.LevelType levelType, Map<String, SystemDomainCriticalityLevelDTO> clMap) {
			this.sessionValue.put(levelType, clMap);
		}
	}
	
	public SystemDomainCriticalityLevelAction(
			SystemDomainCriticalityLevelService systemDomainCriticalityLevelService) {
		this.systemDomainCriticalityLevelService = systemDomainCriticalityLevelService;
	}
	
	@SuppressWarnings("unchecked")
	public String execute() {
		TmpSessionValue tmpSessionValue = (TmpSessionValue) this.getSessionValue(SessionKey.tmpKey);
		if (tmpSessionValue != null) {
			this.clFuncMap = tmpSessionValue.getFromSessionCLMap(SystemDomainCriticalityLevelDTO.LevelType.FUNC);
			this.clApplMap = tmpSessionValue.getFromSessionCLMap(SystemDomainCriticalityLevelDTO.LevelType.APPL);
			this.removeFromSession(SessionKey.tmpKey);
			return SUCCESS;
		}
		
		// get func map
		this.clFuncMap = new HashMap<String, SystemDomainCriticalityLevelDTO>();
		Map<CriticalityLevelEnum, CriticalFunctionCriticalityLevel> fmap = 
			(Map<CriticalityLevelEnum, CriticalFunctionCriticalityLevel>) 
			this.systemDomainCriticalityLevelService.getListByOwnerId(SystemDomainCriticalFunctionCriticalityLevel.class, this.getSessionSystemDomain().id);
		
		// iterate
		if (fmap != null && !fmap.isEmpty()) {
			Set<CriticalityLevelEnum> keySet = fmap.keySet();
			for (CriticalityLevelEnum key : keySet) {
				CriticalityLevel cLevel = (CriticalityLevel) fmap.get(key);
				if (cLevel instanceof SystemCriticalityLevel) cLevel.setId(0);
				this.clFuncMap.put(key.name(), new SystemDomainCriticalityLevelDTO(cLevel));
			}
		}

		// get appl map
		this.clApplMap = new HashMap<String, SystemDomainCriticalityLevelDTO>();
		Map<CriticalityLevelEnum, CentralApplicationCriticalityLevel> amap = 
			(Map<CriticalityLevelEnum, CentralApplicationCriticalityLevel>) 
			this.systemDomainCriticalityLevelService.getListByOwnerId(SystemDomainCentralApplicationCriticalityLevel.class, this.getSessionSystemDomain().id);
		
		// iterate
		if (amap != null && !amap.isEmpty()) {
			Set<CriticalityLevelEnum> keySet = amap.keySet();
			for (CriticalityLevelEnum key : keySet) {
				CriticalityLevel cLevel = (CriticalityLevel) amap.get(key);
				if (cLevel instanceof SystemCriticalityLevel) cLevel.setId(0);
				this.clApplMap.put(key.name(), new SystemDomainCriticalityLevelDTO(cLevel));
			}
		}

		// put in session?

		// return
		return SUCCESS;
	}
	
	public String installText() {
		// put in session
		this.putInSessionTmp();
		
		// get level
		CriticalityLevelEnum levelEnum = CriticalityLevelEnum.valueOf(clEnum);
		SystemDomainCriticalityLevelDTO.LevelType levelType = SystemDomainCriticalityLevelDTO.LevelType.valueOf(clType);
		if (levelEnum == CriticalityLevelEnum.LEVEL0) return this.updateCFDesc(false);
		
		// get type
		SystemDomainCriticalityLevelDTO dto = 
			(levelType == SystemDomainCriticalityLevelDTO.LevelType.FUNC ?
			this.clFuncMap.get(this.clEnum) :
			this.clApplMap.get(this.clEnum));
		
		// get default level
		SystemCriticalityLevel defLevel = this.systemDomainCriticalityLevelService
			.getDefaultByLevelEnum(levelType == SystemDomainCriticalityLevelDTO.LevelType.FUNC ?
			SystemDomainCriticalFunctionCriticalityLevel.class : SystemDomainCentralApplicationCriticalityLevel.class,
			levelEnum);
		
		// set to default if null
		if (dto == null) {
			dto = new SystemDomainCriticalityLevelDTO((CriticalityLevel) defLevel);
			dto.id = 0;
		} else if (dto.name == null || dto.name.trim().length() == 0) {
			dto.name = defLevel.getName();
		} else if (dto.longDescription == null || dto.longDescription.trim().length() == 0) {
			dto.longDescription = defLevel.getLongDescription();
		}
		dto.levelType = levelType;
		dto.systemDomainId = this.getSessionSystemDomain().id;
		
		// set original description
		SystemDomainCriticalityLevel cl = dto.getDomainObject();
		cl.setDescription(dto.origDescription);

		// install text
		this.systemDomainCriticalityLevelService.update(cl);
		return SUCCESS;
	}
	
	public String restoreText() {
		// put in session
		this.putInSessionTmp();
		
		// get level
		CriticalityLevelEnum levelEnum = CriticalityLevelEnum.valueOf(clEnum);
		SystemDomainCriticalityLevelDTO.LevelType levelType = SystemDomainCriticalityLevelDTO.LevelType.valueOf(clType);
		if (levelEnum == CriticalityLevelEnum.LEVEL0) return this.updateCFDesc(true);
		
		// get type
		SystemDomainCriticalityLevelDTO dto = 
			(levelType == SystemDomainCriticalityLevelDTO.LevelType.FUNC ?
			this.clFuncMap.get(this.clEnum) :
			this.clApplMap.get(this.clEnum));
		
		// get default level
		SystemCriticalityLevel defLevel = this.systemDomainCriticalityLevelService
			.getDefaultByLevelEnum(levelType == SystemDomainCriticalityLevelDTO.LevelType.FUNC ?
			SystemDomainCriticalFunctionCriticalityLevel.class : SystemDomainCentralApplicationCriticalityLevel.class,
			levelEnum);
		
		// set to default
		if (dto == null) {
			dto = new SystemDomainCriticalityLevelDTO((CriticalityLevel) defLevel);
			dto.id = 0;
		} else {
			dto.name = defLevel.getName();
			dto.longDescription = defLevel.getLongDescription();
		}
		dto.levelType = levelType;
		dto.systemDomainId = this.getSessionSystemDomain().id;
		
		// set original description
		SystemDomainCriticalityLevel cl = dto.getDomainObject();
		cl.setDescription(dto.origDescription);

		// restore text
		this.systemDomainCriticalityLevelService.update(cl);
		return SUCCESS;
	}
	
	private void putInSessionTmp() {
		TmpSessionValue tmpSessionValue = new TmpSessionValue(); 
		tmpSessionValue.putInSessionCLMap(SystemDomainCriticalityLevelDTO.LevelType.FUNC, this.clFuncMap);
		tmpSessionValue.putInSessionCLMap(SystemDomainCriticalityLevelDTO.LevelType.APPL, this.clApplMap);
		this.putInSession(SessionKey.tmpKey, tmpSessionValue);
	}
	
	private String updateCFDesc(boolean isRestore) {
		List<SystemDomainCriticalityLevel> dObjList = new ArrayList<SystemDomainCriticalityLevel>();
		Set<String> keys = this.clFuncMap.keySet();
		for (String key : keys) {
			SystemDomainCriticalityLevelDTO dto = this.clFuncMap.get(key);
			if (isRestore || dto.description == null || dto.description.trim().length() == 0) {
				SystemCriticalityLevel defLevel = this.systemDomainCriticalityLevelService
				.getDefaultByLevelEnum(SystemDomainCriticalFunctionCriticalityLevel.class, CriticalityLevelEnum.valueOf(key));
				dto.description = defLevel.getDescription();
			}
			dto.levelType = SystemDomainCriticalityLevelDTO.LevelType.FUNC;
			dto.systemDomainId = this.getSessionSystemDomain().id;
			dto.origDescription = dto.description;
			dObjList.add(dto.getDomainObject());
		}
		this.systemDomainCriticalityLevelService.updateAllDescriptions(dObjList);
		return SUCCESS;
	}
	
	public Map<String, SystemDomainCriticalityLevelDTO> getClFuncMap() {
		return this.clFuncMap;
	}

	public void setClFuncMap(Map<String, SystemDomainCriticalityLevelDTO> clFuncMap) {
		this.clFuncMap = clFuncMap;
	}

	public Map<String, SystemDomainCriticalityLevelDTO> getClApplMap() {
		return this.clApplMap;
	}

	public void setClApplMap(Map<String, SystemDomainCriticalityLevelDTO> clApplMap) {
		this.clApplMap = clApplMap;
	}

	public String getClType() {
		return this.clType;
	}

	public void setClType(String clType) {
		this.clType = clType;
	}

	public String getClEnum() {
		return this.clEnum;
	}

	public void setClEnum(String clEnum) {
		this.clEnum = clEnum;
	}

	@Override
	public void prepare() throws Exception {

	}

}
