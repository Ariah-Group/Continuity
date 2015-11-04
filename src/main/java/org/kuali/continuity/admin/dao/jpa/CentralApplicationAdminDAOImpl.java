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

import org.kuali.continuity.admin.dao.OrderingDao;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.domain.CentralApplication;


@Deprecated
public class CentralApplicationAdminDAOImpl extends CentralApplicationDAOImpl implements OrderingDao {

	@Override
	protected String getNamedListQuery() {
		return "CentralApplication.admin.list";
	}

	@Override
	protected String getNamedSizeQuery() {
		return "CentralApplication.admin.size";
	}

	@Override
	// TODO: refactor - consider getting string query from namedquery
	protected String getBaseQueryString() {
		return 
			"SELECT dObj FROM CentralApplication dObj WHERE dObj.systemDomainId = :systemDomainId" +
			  " AND dObj.recordType = org.kuali.continuity.domain.RecordType.S";
	}
    





	public void update(BaseAdminOrderedDomainObject orderedType) {
		super.update((CentralApplication) orderedType);
		
	}

	public void create(BaseAdminOrderedDomainObject orderedType) {
		super.create((CentralApplication) orderedType);
		
	}



}
