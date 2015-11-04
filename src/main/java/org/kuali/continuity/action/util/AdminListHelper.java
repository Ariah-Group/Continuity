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

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.admin.service.GenericAdminService.GenericSortBy;
import org.kuali.continuity.domain.SortByType;

public class AdminListHelper {

	private GenericAdminService genericAdminService;
	private List<Class<? extends BaseAdminDomainObject>> adminClasses;
	private DomainObject2DTOConverter do2dtoConverter;
	private int systemDomainId;

	public AdminListHelper() {

	}
	
	public GenericAdminService getGenericAdminService() {
		return this.genericAdminService;
	}

	public void setGenericAdminService(GenericAdminService genericAdminService) {
		this.genericAdminService = genericAdminService;
	}

	public List<Class<? extends BaseAdminDomainObject>> getAdminClasses() {
		return this.adminClasses;
	}

	public void setAdminClasses(
			List<Class<? extends BaseAdminDomainObject>> adminClasses) {
		this.adminClasses = adminClasses;
	}

	public DomainObject2DTOConverter getDo2dtoConverter() {
		return this.do2dtoConverter;
	}

	public void setDo2dtoConverter(DomainObject2DTOConverter do2dtoConverter) {
		this.do2dtoConverter = do2dtoConverter;
	}

	public int getSystemDomainId() {
		return this.systemDomainId;
	}
	
	public void setSystemDomainId(int systemDomainId) {
		this.systemDomainId = systemDomainId;
	}

	private List<? extends BaseAdminDomainObject> getAdminDomainObjects(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId) {
		SortByType sortBy = GenericSortBy.name;
		if (Building.class.isAssignableFrom(adminClass)) sortBy = Building.SortBy.commonName;
		else if (BaseAdminOrderedDomainObject.class.isAssignableFrom(adminClass)) sortBy = GenericSortBy.orderNo;		
		return this.genericAdminService.getSortedListBySystemDomainId(adminClass, systemDomainId, sortBy, true);
	}
	
	private List<? extends DomainObjectDTO> getAdminDomainObjectDTOs(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId) {
		return this.do2dtoConverter.getDomainObjectDTOList(this.getAdminDomainObjects(adminClass, systemDomainId));
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, List<DomainObjectDTO>> getAdminListMap() {
		Map<String, List<DomainObjectDTO>> adminListMap = new HashMap<String, List<DomainObjectDTO>>();
		if (this.adminClasses != null) {
			for (Class<? extends BaseAdminDomainObject> adminClass : this.adminClasses) {
				adminListMap.put(adminClass.getSimpleName(), (List<DomainObjectDTO>) this.getAdminDomainObjectDTOs(adminClass, this.getSystemDomainId()));
			}
		}
		return adminListMap;
	}
	
	public BaseAdminDomainObject getAdminDomainObjectById(
			Class<? extends BaseAdminDomainObject> adminClass, int id){
		return genericAdminService.getById(adminClass, id);
	}

}
