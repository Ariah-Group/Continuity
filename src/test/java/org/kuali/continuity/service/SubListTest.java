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
package org.kuali.continuity.service;

import java.util.List;

import org.kuali.continuity.admin.dao.AdminDAOTest;
import org.kuali.continuity.admin.dao.CentralApplicationDAO;
import org.kuali.continuity.admin.domain.BaseAdminOrderedDomainObject;
import org.kuali.continuity.admin.domain.CentralApplication;

public class SubListTest extends AdminDAOTest {
	private CentralApplicationDAO dao;

	public void setCentralApplicationDAO(CentralApplicationDAO dao) {
		this.dao = dao;
	}

	public void checkList(List<BaseAdminOrderedDomainObject> list, int testorder) {
		System.out.println("***SUBLIST*** Test for:" + testorder);
		for (BaseAdminOrderedDomainObject i : list) {
			System.out.println("" + i.getOrderNo() + " " + i.getName() + " "
					);
			if (i.getOrderNo() < testorder) {
				System.out.println("Error - order not correct");
				this.fail();
			}
		}
		System.out.println("***SUBLIST End***");

	}

	public void testSubList() {
		int testOrder = 3;
		int location = 1;
		List<BaseAdminOrderedDomainObject> aboveList = (List<BaseAdminOrderedDomainObject>) this.dao
				.getSubListBySystemDomainIdAndStartOrderNo(location, testOrder);

		checkList(aboveList, testOrder);

	}
}
