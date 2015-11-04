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

import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.BaseRefDomainObject;
import org.kuali.continuity.domain.PlanAccessType;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;

public class ActionHelper {

	private static ActionHelper instance = new ActionHelper();
	
	private ActionHelper() {

	}
	
	public static ActionHelper getInstance() {
		return instance;
	}
	
	public PlanAccessType getPlanAccess(SecurityType securityType, 
			PlanAccessType planAccessType) {
		
		if (securityType.equals(SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject()) ||
			securityType.equals(SecurityTypeEnum.INSTITUTION_ADMIN.getRefDomainObject()) ||
			securityType.equals(SecurityTypeEnum.LOCAL_ADMIN.getRefDomainObject()))
			return PlanAccessTypeEnum.FULL.getRefDomainObject();
			
		if (
			securityType.equals(SecurityTypeEnum.UNIVERSAL_VIEWER.getRefDomainObject()))
			return planAccessType == null ? PlanAccessTypeEnum.VIEW_ONLY.getRefDomainObject() : planAccessType;
			
		return planAccessType;	

	}

	public List<RefDTO> getRefDTOList(List<? extends BaseRefDomainObject> refs) {
		List<RefDTO> refDTOs = new ArrayList<RefDTO>();
		if (refs != null) {
			for (BaseRefDomainObject baseRefDomainObject : refs) {
				refDTOs.add(new RefDTO(baseRefDomainObject));
			}
		}
		return refDTOs;
	}

}
