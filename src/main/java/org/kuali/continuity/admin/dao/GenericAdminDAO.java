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
package org.kuali.continuity.admin.dao;

import java.util.List;

import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.domain.SortByType;

public interface GenericAdminDAO<T extends BaseAdminDomainObject> {

	void create(T dObj);
	void update(T dObj);
	T getById(int id);
	public void delete(int id);
	T getBySystemDomainIdAndName(int systemDomainId, String name);
	long getListBySystemDomainIdSize(int systemDomainId);
	List<T> getListBySystemDomainId(int systemDomainId);
	List<T> getSubListBySystemDomainId(int systemDomainId, int start, int limit);
	List<T> getSortedListBySystemDomainId(int systemDomainId, SortByType sortBy, boolean isAscending);
	List<T> getSortedSubListBySystemDomainId(int systemDomainId, int start, int limit, SortByType sortBy, boolean isAscending);
	T getBySystemDomainIdAndOrderNo(int systemDomainId, int orderNo);
	T getHighestOrderedObjectBySystemDomainId(int systemDomainId);
	List<T> getSubListBySystemDomainIdAndStartOrderNo(int systemDomainId, int startOrderNo);
	boolean isAdminFiltered();
	void setAdminFiltered(boolean isAdminFiltered);

}
