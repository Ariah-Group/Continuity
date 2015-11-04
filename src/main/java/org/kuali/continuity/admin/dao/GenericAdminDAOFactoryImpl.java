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

import java.util.Map;

import org.kuali.continuity.admin.domain.BaseAdminDomainObject;

public class GenericAdminDAOFactoryImpl implements GenericAdminDAOFactory {

	private Map<Class<? extends BaseAdminDomainObject>, GenericAdminDAO<? extends BaseAdminDomainObject>> daoMap;
	private final static boolean DEFAULT_ADMIN_FILTER = true;

	public GenericAdminDAO<? extends BaseAdminDomainObject> getGenericAdminDAO(Class<? extends BaseAdminDomainObject> refClass) {
		GenericAdminDAO<? extends BaseAdminDomainObject> dao = this.daoMap.get(refClass);
		dao.setAdminFiltered(DEFAULT_ADMIN_FILTER);
		return dao;
	}

	public GenericAdminDAO<? extends BaseAdminDomainObject> getGenericAdminDAO(Class<? extends BaseAdminDomainObject> refClass, boolean isAdminFiltered) {
		GenericAdminDAO<? extends BaseAdminDomainObject> dao = this.daoMap.get(refClass);
		dao.setAdminFiltered(isAdminFiltered);
		return dao;
	}
	
	public Map<Class<? extends BaseAdminDomainObject>, GenericAdminDAO<? extends BaseAdminDomainObject>> getDaoMap() {
		return this.daoMap;
	}

	public void setDaoMap(Map<Class<? extends BaseAdminDomainObject>, GenericAdminDAO<? extends BaseAdminDomainObject>> daoMap) {
		this.daoMap = daoMap;
	}

}
