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
package org.kuali.continuity.admin.dao.jpa;

import java.util.List;

import org.kuali.continuity.admin.dao.CriticalFunctionExampleDAO;
import org.kuali.continuity.admin.dao.SimpleAdminDao;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.CriticalFunctionExample;

@Deprecated
public class CriticalFunctionExampleDAOImpl extends BaseAdminDAOImpl implements
		CriticalFunctionExampleDAO, SimpleAdminDao {


	public void create(CriticalFunctionExample dObj) {
		super.create(dObj);
	}
	
	public void update(CriticalFunctionExample dObj) {
		super.update(dObj);
	}
	
	@Override
	public void delete(int id) {
		super.delete(id);
	}
	
	@Override
	public CriticalFunctionExample getById(int id) {
		return (CriticalFunctionExample) super.getById(id);
	}
	
	public CriticalFunctionExample getBySystemDomainIdAndName(int systemDomainId, String name) {
		// not used
		return null;
	}
	
	@Override
	public long getListBySystemDomainIdSize(int systemDomainId) {
		return super.getListBySystemDomainIdSize(systemDomainId);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<CriticalFunctionExample> getListBySystemDomainId(int systemDomainId) {
		return (List<CriticalFunctionExample>) super.getListBySystemDomainId(systemDomainId);
	}

	@Override
	protected Class<? extends BaseAdminDomainObject> getDomainObjectClass() {
		return CriticalFunctionExample.class;
	}

	@Override
	protected String getNamedListQuery() {
		return "CriticalFunctionExample.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "CriticalFunctionExample.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM CriticalFunctionExample dObj WHERE dObj.systemDomainId = :systemDomainId";
	}
	
}
