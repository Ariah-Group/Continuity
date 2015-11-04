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

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.domain.BinaryDocument;
import org.kuali.continuity.domain.SamplePlanDocument;

public class SystemDomainSamplePlanDocumentDAOTest extends BasePlanTest {

	private BinaryDocumentDAOFactory factory;
	private BinaryDocumentDAO dao;
	
	public void setBinaryDocumentDAOFactory(BinaryDocumentDAOFactory factory) {
		this.factory = factory;
		this.dao = this.factory.getBinaryDocumentDAO(SamplePlanDocument.class);
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testReadBinaryDocument() throws Exception {
		BinaryDocument document = 
			this.dao.getById(PlanTestData.wellknown_institution);
		assertNotNull(document);
		assertNotNull(document.getBlobDocument());
		System.out.println("Document Class: " + document.getClass().getSimpleName());
	}
	
	public void testUpdateBinaryDocument() throws Exception {
		BinaryDocument document = 
			this.dao.getById(PlanTestData.wellknown_institution);
		assertNotNull(document);
		assertNotNull(document.getBlobDocument());
		this.dao.update(document);
	}

}
