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

import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.domain.SortByType;

public interface GenericAdminService {

	void create(BaseAdminDomainObject dObj);
	void update(BaseAdminDomainObject dObj);
	BaseAdminDomainObject getById(Class<? extends BaseAdminDomainObject> adminClass, int id);
	public void delete(Class<? extends BaseAdminDomainObject> adminClass, int id);
	BaseAdminDomainObject getBySystemDomainIdAndName(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId, String name);
	long getListBySystemDomainIdSize(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId);
	List<? extends BaseAdminDomainObject> getListBySystemDomainId(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId);
	List<? extends BaseAdminDomainObject> getSubListBySystemDomainId(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId, int start, int limit);
	List<? extends BaseAdminDomainObject> getSortedListBySystemDomainId(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId, SortByType sortBy, boolean isAscending);
	List<? extends BaseAdminDomainObject> getSortedSubListBySystemDomainId(Class<? extends BaseAdminDomainObject> adminClass, int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);

	public enum GenericSortBy implements SortByType {
		id, name, orderNo;
		public String getSortByValue() {return this.name();}
	}
	
}
