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
package org.kuali.continuity.action.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.domain.BaseDomainObject;

public class DomainObject2DTOConverterImpl implements DomainObject2DTOConverter {
	
	private Map<Class<? extends BaseDomainObject>, Class<? extends DomainObjectDTO>> dtoClassMap;

	public DomainObject2DTOConverterImpl() {
		
	}

	public Map<Class<? extends BaseDomainObject>, Class<? extends DomainObjectDTO>> getDtoClassMap() {
		return this.dtoClassMap;
	}

	public void setDtoClassMap(Map<Class<? extends BaseDomainObject>, Class<? extends DomainObjectDTO>> dtoClassMap) {
		this.dtoClassMap = dtoClassMap;
	}

	public List<? extends DomainObjectDTO> getDomainObjectDTOList(
			List<? extends BaseDomainObject> objs) {
		List<DomainObjectDTO> dtos = new ArrayList<DomainObjectDTO>();
		if (objs != null) {
			for (BaseDomainObject obj : objs) {
				DomainObjectDTO dto = this.getDomainObjectDTO(obj);
				if (dto != null) dtos.add(dto);
			}
		}
		return dtos;
	}

	public DomainObjectDTO getDomainObjectDTO(BaseDomainObject obj) {
		Class<? extends DomainObjectDTO> dtoClass = 
			this.dtoClassMap.get(obj.getClass());
		if (dtoClass == null) dtoClass = DomainObjectDTO.class;
		try {
			DomainObjectDTO dto = dtoClass.newInstance();
			if (dto instanceof DTOValue) {
				((DTOValue)dto).copyFromDomainObject(obj);
			}
			else {
				dto.id = obj.getId() == null ? 0 : obj.getId();
				dto.name = obj.getName();
			}
			return dto;
				
		} catch (Exception e) {
			;
		}
		return null;
	}
	
}
