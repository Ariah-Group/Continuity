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
package org.kuali.continuity.plan.action;

import java.util.List;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.action.util.ActionHelper;
import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.admin.service.GenericAdminService.GenericSortBy;
import org.kuali.continuity.domain.BaseRefDomainObject;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.service.ReferenceDomainObjectService;

public class PlanActionServiceHelper {
	
	private ReferenceDomainObjectService refService;
	private GenericAdminService genericAdminService;
	private DomainObject2DTOConverter do2dtoConverter;

	public PlanActionServiceHelper(ReferenceDomainObjectService refService, GenericAdminService genericAdminService) {
		this.refService = refService;
		this.genericAdminService = genericAdminService;
	}
	
	public List<? extends BaseRefDomainObject> getReferenceDomainObjects(Class<? extends BaseRefDomainObject> refClass) {
		return refService.getReferenceDomainObjects(refClass);
	}
	
	public List<RefDTO> getRefDTOs(Class<? extends BaseRefDomainObject> refClass) {
		return ActionHelper.getInstance().getRefDTOList(this.getReferenceDomainObjects(refClass));
	}
	
	public List<? extends BaseAdminDomainObject> getAdminDomainObjects(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId) {
		SortByType sortBy = GenericSortBy.name;
		if (Building.class.isAssignableFrom(adminClass)) sortBy = Building.SortBy.commonName;
		return this.genericAdminService.getSortedListBySystemDomainId(adminClass, systemDomainId, sortBy, true);
	}
	
	public List<? extends DomainObjectDTO> getAdminDomainObjectDTOs(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId) {
		return this.do2dtoConverter.getDomainObjectDTOList(this.getAdminDomainObjects(adminClass, systemDomainId));
	}
	
	public BaseAdminDomainObject getAdminDomainObjectById(Class<? extends BaseAdminDomainObject> adminClass, int id) {
		return this.genericAdminService.getById(adminClass, id);
	}
	
	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

}
