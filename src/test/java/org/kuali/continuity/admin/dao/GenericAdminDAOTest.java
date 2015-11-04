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
import java.util.Set;

import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.service.GenericAdminService.GenericSortBy;
import org.kuali.continuity.domain.SortByType;

public class GenericAdminDAOTest extends AdminDAOTest {

	private GenericAdminDAOFactory factory;
	
	public void setFactory(GenericAdminDAOFactory factory) {
		this.factory = factory;
	}
	
	public void testInjection() throws Exception {
		System.out.println("DAO is " + this.factory.getClass().getName());
	}

	@SuppressWarnings("unchecked")
	public void testGetGenericAdminList() throws Exception {
		Set<Class<? extends BaseAdminDomainObject>> refClasses = ((GenericAdminDAOFactoryImpl)this.factory).getDaoMap().keySet();
		for (Class<? extends BaseAdminDomainObject> refClass : refClasses) {
//			this.doTestList(this.factory.getGenericAdminDAO(refClass).getListBySystemDomainId(PlanTestData.wellknown_institution));
			System.out.println("----- " + refClass.getName() + " -----");
			System.out.println();
			try {
//				this.doTestList(this.factory.getGenericAdminDAO(refClass).getSubListBySystemDomainIdAndStartOrderNo(PlanTestData.wellknown_institution, 1));
				SortByType sortBy = GenericSortBy.name;
				if (BaseAdminOrderedDomainObject.class.isAssignableFrom(refClass)) sortBy = GenericSortBy.orderNo;
				List list = this.factory.getGenericAdminDAO(refClass).getSortedListBySystemDomainId(29, sortBy, true);
				if (list != null && !list.isEmpty())
					this.doTestList(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
