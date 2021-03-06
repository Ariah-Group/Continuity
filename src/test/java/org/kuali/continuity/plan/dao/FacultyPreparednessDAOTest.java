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
package org.kuali.continuity.plan.dao;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.plan.domain.FacultyPreparedness;

public class FacultyPreparednessDAOTest extends DomainObjectTest {

	private FacultyPreparednessDAO dao;
	
	public void setFacultyPreparednessDAO(FacultyPreparednessDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testRead() throws Exception {
		this.getTestFacultyPreparedness();
	}

	private FacultyPreparedness getTestFacultyPreparedness() {
		FacultyPreparedness dObj = this.dao.get(PlanTestData.known_plan);
		assertNotNull(dObj);
		return dObj;
	}

}
