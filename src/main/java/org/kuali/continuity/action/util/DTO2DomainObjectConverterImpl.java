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

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.domain.BaseDomainObject;

public class DTO2DomainObjectConverterImpl implements DTO2DomainObjectConverter {

	public DTO2DomainObjectConverterImpl() {

	}
	
	public List<? extends BaseDomainObject> getDomainObjectList(List<? extends DomainObjectDTO> dtos) {
		List<BaseDomainObject> dObjs = new ArrayList<BaseDomainObject>();
		if (dtos != null) {
			for (DomainObjectDTO dto : dtos) {
				BaseDomainObject dObj = this.getDomainObject(dto);
				if (dObj == null) continue;
				dObjs.add(dObj);
			}
		}
		return dObjs;
	}
	
	public BaseDomainObject getDomainObject(DomainObjectDTO dto) {
		if (dto instanceof DomainObjectValue)
			return ((DomainObjectValue)dto).getDomainObject();
		return null;
	}

}
