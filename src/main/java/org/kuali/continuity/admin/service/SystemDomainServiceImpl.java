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
import java.util.Set;

import org.kuali.continuity.admin.dao.SystemDomainDAO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.SystemDomainSettings;
import org.kuali.continuity.domain.SortByType;
import org.kuali.continuity.service.SystemSetupService;

public class SystemDomainServiceImpl implements SystemDomainService {
	
	private GenericAdminService genericAdminService;
	private SystemSetupService systemSetupService;
	private SystemDomainDAO systemDomainDAO;

	public void create(SystemDomain systemDomain) {
		this.getGenericAdminService().create(systemDomain);
	}

	public void delete(int id) {
		this.getGenericAdminService().delete(SystemDomain.class, id);
	}

	public List<SystemDomain> getAll() {
		return this.getSystemDomainDAO().getAll();
	}

	public List<SystemDomain> getAll(SortByType sortBy, boolean isAscending) {
		return this.getSystemDomainDAO().getAll(sortBy, isAscending);
	}

	public List<SystemDomain> getAll(int start, int limit) {
		return this.getSystemDomainDAO().getAll(start, limit);
	}

	public List<SystemDomain> getAll(int start, int limit, SortByType sortBy,
			boolean isAscending) {
		return this.getSystemDomainDAO().getAll(start, limit, sortBy, isAscending);
	}
	
	public 	List<SystemDomain> getAllByLogin(boolean isShib) {
		return this.getSystemDomainDAO().getAllByLogin(isShib);
	}

	public long getAllSize() {
		return this.getSystemDomainDAO().getAllSize();
	}

	public SystemDomain getById(int id) {
		return (SystemDomain) this.getGenericAdminService().getById(SystemDomain.class, id);
	}

	@Override
	public SystemDomain getByGroupAndName(String systemDomainGroup, String name) {
		return this.getSystemDomainDAO().getByGroupAndName(systemDomainGroup, name);
	}

	public long getListByGroupSize(String systemDomainGroup) {
		return this.getSystemDomainDAO().getListByGroupSize(systemDomainGroup);
	}
	
	public List<SystemDomain> getListByGroup(String systemDomainGroup) {
		return this.getSystemDomainDAO().getListByGroup(systemDomainGroup);
	}
	
	public List<SystemDomain> getListByShibIDP(String shibIDP) {
		return this.getSystemDomainDAO().getListByShibIDP(shibIDP);
	}
	
	public List<SystemDomain> getShibListByIDPAuthType(String shibIDP) {
		return this.getSystemDomainDAO().getShibListByIDPAuthType(shibIDP);
	}
	
	public List<SystemDomain> getSubListByGroup(String systemDomainGroup, int start, int limit) {
		return this.getSystemDomainDAO().getSubListByGroup(systemDomainGroup, start, limit);
	}
	
	public List<SystemDomain> getSortedListByGroup(String systemDomainGroup, SortByType sortBy,
			boolean isAscending) {
		return this.getSystemDomainDAO().getSortedListByGroup(systemDomainGroup, sortBy, isAscending);
	}
	
	public List<SystemDomain> getSortedSubListByGroup(String systemDomainGroup, int start, int limit,
			SortByType sortBy, boolean isAscending) {
		return this.getSystemDomainDAO().getSortedSubListByGroup(systemDomainGroup, start, limit, sortBy, isAscending);
	}
	
	public List<SystemDomain> getListByCustomUrl(String url){
		return this.getSystemDomainDAO().getListByCustomUrl(url);
	}
	
	public void update(SystemDomain systemDomain) {
		this.getGenericAdminService().update(systemDomain);
	}

	public void update(int id, SystemDomainSettings settings) {
		this.getSystemDomainDAO().update(id, settings);
	}

	public void update(int id, Set<String> domains) {
		this.getSystemDomainDAO().update(id, domains);
	}

	public GenericAdminService getGenericAdminService() {
		return this.genericAdminService;
	}

	public void setGenericAdminService(GenericAdminService genericAdminService) {
		this.genericAdminService = genericAdminService;
	}

	public SystemSetupService getSystemSetupService() {
		return this.systemSetupService;
	}

	public void setSystemSetupService(SystemSetupService systemSetupService) {
		this.systemSetupService = systemSetupService;
	}

	public SystemDomainDAO getSystemDomainDAO() {
		return this.systemDomainDAO;
	}

	public void setSystemDomainDAO(SystemDomainDAO systemDomainDAO) {
		this.systemDomainDAO = systemDomainDAO;
	}

	@Override
	public String getSystemName(int id) {
		SystemDomain systemDomain = this.getById(id);
		String systemName = null;
		if (systemDomain != null) systemName = systemDomain.getSystemName();
		if (systemName == null || systemName.trim().length() == 0)
			systemName = this.getDefaultSystemName();
		return systemName;
	}

	@Override
	public String getDefaultSystemName() {
		return this.getSystemSetupService().getSystemSetup().getName();
	}

}
