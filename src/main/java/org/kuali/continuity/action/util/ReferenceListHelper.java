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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.BaseRefDomainObject;
import org.kuali.continuity.service.ReferenceDomainObjectService;

public class ReferenceListHelper {

	private ReferenceDomainObjectService refService;
	private List<Class<? extends BaseRefDomainObject>> refClasses;

	public ReferenceListHelper() {

	}
	
	public ReferenceDomainObjectService getRefService() {
		return this.refService;
	}

	public void setRefService(ReferenceDomainObjectService refService) {
		this.refService = refService;
	}

	public List<Class<? extends BaseRefDomainObject>> getRefClasses() {
		return this.refClasses;
	}

	public void setRefClasses(List<Class<? extends BaseRefDomainObject>> refClasses) {
		this.refClasses = refClasses;
	}

	private List<RefDTO> getRefDTOs(Class<? extends BaseRefDomainObject> refClass) {
		return ActionHelper.getInstance().getRefDTOList(this.getReferenceDomainObjects(refClass));
	}
	
	private List<? extends BaseRefDomainObject> getReferenceDomainObjects(Class<? extends BaseRefDomainObject> refClass) {
		return refService.getReferenceDomainObjects(refClass);
	}
	
	public Map<String, List<RefDTO>> getReferenceListMap() {
		Map<String, List<RefDTO>> refListMap = new HashMap<String, List<RefDTO>>();
		if (this.refClasses != null) {
			for (Class<? extends BaseRefDomainObject> refClass : this.refClasses) {
				refListMap.put(refClass.getSimpleName(), this.getRefDTOs(refClass));
			}
		}
		return refListMap;
	}
	
}
