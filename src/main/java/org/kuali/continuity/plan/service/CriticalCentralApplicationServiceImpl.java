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
package org.kuali.continuity.plan.service;

import java.util.List;

import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.dao.CriticalCentralApplicationDAO;
import org.kuali.continuity.plan.domain.CriticalCentralApplication;

public class CriticalCentralApplicationServiceImpl implements
		CriticalCentralApplicationService {

	private CriticalCentralApplicationDAO criticalCentralApplicationDAO;
	private GenericAdminService genericAdminService;

	public void create(CriticalCentralApplication obj) {
		this.createUserDefined(obj.getCentralApplication());
		this.criticalCentralApplicationDAO.create(obj);
	}

	public void create(BaseDomainObject obj) {
		this.create((CriticalCentralApplication)obj);
	}

	public void update(CriticalCentralApplication obj) {
		this.criticalCentralApplicationDAO.update(obj);
	}

	public void update(BaseDomainObject obj) {
		this.update((CriticalCentralApplication)obj);
	}

	public void updateList(List<CriticalCentralApplication> dObjs) {
		for (CriticalCentralApplication criticalCentralApplication : dObjs) {
			this.update(criticalCentralApplication);
		}
	}
	
	public void delete(int id) {
		this.criticalCentralApplicationDAO.delete(id);
	}

	public CriticalCentralApplication getById(int id) {
		return this.criticalCentralApplicationDAO.getById(id);
	}

	public List<CriticalCentralApplication> getListByOwnerId(int ownerId) {
		return this.criticalCentralApplicationDAO.getListByOwnerId(ownerId);
	}

	public CriticalCentralApplicationDAO getCriticalCentralApplicationDAO() {
		return this.criticalCentralApplicationDAO;
	}

	public void setCriticalCentralApplicationDAO(CriticalCentralApplicationDAO criticalCentralApplicationDAO) {
		this.criticalCentralApplicationDAO = criticalCentralApplicationDAO;
	}

	public GenericAdminService getGenericAdminService() {
		return this.genericAdminService;
	}

	public void setGenericAdminService(GenericAdminService genericAdminService) {
		this.genericAdminService = genericAdminService;
	}

	private void createUserDefined(CentralApplication centralApplication) {
		if (centralApplication == null || (centralApplication.getId() != null && centralApplication.getId() != 0)) return;
		centralApplication.setUserDefined(true);
		this.genericAdminService.create(centralApplication);
	}

}
