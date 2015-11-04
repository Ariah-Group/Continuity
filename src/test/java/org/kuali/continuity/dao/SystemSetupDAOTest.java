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
package org.kuali.continuity.dao;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.domain.SystemSetup;
import org.kuali.continuity.domain.SystemSetupSamplePlanDocument;

public class SystemSetupDAOTest extends BasePlanTest {

	private SystemSetupDAO dao;
	
	public void setSystemSetupDAO(SystemSetupDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testGetSystemSetup() throws Exception {
		SystemSetup systemSetup = this.dao.getSystemSetup();
		SystemSetupSamplePlanDocument samplePlanDocument = this.dao.getDefaultSamplePlanDocument();
		assertNotNull(systemSetup);
		assertNotNull(samplePlanDocument);
		System.out.println("System Name: " + systemSetup.getName());
		System.out.println("Sample Plan: " + samplePlanDocument.getFileName());
	}

}
