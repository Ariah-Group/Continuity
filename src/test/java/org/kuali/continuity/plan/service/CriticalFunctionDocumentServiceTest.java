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

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.domain.DocumentType;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.CriticalFunctionDocument;

public class CriticalFunctionDocumentServiceTest extends DomainObjectTest {

	private DocumentServiceFactory documentServiceFactory;
	private DocumentService service;
	
	protected void onSetUp() {
		try {
			super.onSetUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (this.documentServiceFactory == null) return;
		this.service = this.documentServiceFactory.getDocumentService(CriticalFunctionDocument.class);
	}
	
	public void setDocumentServiceFactory(DocumentServiceFactory documentServiceFactory) {
		this.documentServiceFactory = documentServiceFactory;
	}

	public void testInjection() throws Exception {
		String message = "Service is: " + this.documentServiceFactory.toString();
		System.out.println(message);
		assertNotNull(this.documentServiceFactory);
	}

	public void testCRUD() throws Exception {
		doTestCreateDocument();
		doTestReadDocument();
		doTestUpdateDocument();
		doTestDeleteDocument(); 
	}

	@SuppressWarnings("unchecked")
	private void doTestCreateDocument() throws Exception {
		// get list
		List<CriticalFunctionDocument> dObjs = (List<CriticalFunctionDocument>)
			this.service.getDocumentListByOwnerId(PlanTestData.known_critical_function);
		int size = (dObjs == null ? 0 : dObjs.size());
		
		// construct
		String test = this.getRandomTestString();
		CriticalFunction cf = new CriticalFunction(PlanTestData.known_critical_function);
		CriticalFunctionDocument dObj = new CriticalFunctionDocument();
		dObj.setCriticalFunction(cf);
		dObj.setName(test);
		dObj.setDescription(test);
		dObj.setOwnerDepartment(test);
		dObj.setFileName(test);
		dObj.setLocationKept(test);
		dObj.setComment(test);
		dObj.setBackupMeasures(test);
		dObj.setPrincipalContact(test);
		dObj.setDocumentType(new DocumentType("1"));
		
		// create
		this.service.createDocument(dObj);
		
		// assert
		dObjs = (List<CriticalFunctionDocument>)
			this.service.getDocumentListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	@SuppressWarnings("unchecked")
	private void doTestReadDocument() throws Exception {
		// get list
		List<CriticalFunctionDocument> dObjs = (List<CriticalFunctionDocument>)
			this.service.getDocumentListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// test
		CriticalFunctionDocument dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// get
		dObj = (CriticalFunctionDocument) this.service.getDocument(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	@SuppressWarnings("unchecked")
	private void doTestUpdateDocument() throws Exception {
		// get list
		List<CriticalFunctionDocument> dObjs = (List<CriticalFunctionDocument>)
			this.service.getDocumentListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// set attributes
		CriticalFunctionDocument dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setName(test);
		
		// update
		this.service.updateDocument(dObj);
		
		// assert
		dObj = (CriticalFunctionDocument) this.service.getDocument(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());
	}

	@SuppressWarnings("unchecked")
	private void doTestDeleteDocument() throws Exception {
		// get test plan
		List<CriticalFunctionDocument> dObjs = (List<CriticalFunctionDocument>)
			this.service.getDocumentListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// delete
		CriticalFunctionDocument dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.service.deleteDocument(dObj.getId());
		
		// assert
		dObj = (CriticalFunctionDocument) this.service.getDocument(id);
		assertNull(dObj);
	}

}
