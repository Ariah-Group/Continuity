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

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.plan.domain.FacultyPreparedness;

public class FacultyPreparednessServiceTest extends DomainObjectTest {

	private FacultyPreparednessService service;
	
	public void setService(FacultyPreparednessService service) {
		this.service = service;
	}
	
	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}

	public void testReadFacultyPreparedness() throws Exception {
		this.getTestFacultyPreparedness();
	}

	private FacultyPreparedness getTestFacultyPreparedness() {
		FacultyPreparedness dObj = this.service.getFacultyPreparedness(PlanTestData.known_plan);
		assertNotNull(dObj);
		return dObj;
	}

}
