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

import java.util.List;

import org.kuali.continuity.DomainObjectTest;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.domain.DocumentType;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.domain.CriticalFunctionDocument;

public class CriticalFunctionDocumentDAOTest extends DomainObjectTest {

	private CriticalFunctionDocumentDAO dao;
	
	public void setDocumentDAO(CriticalFunctionDocumentDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testCRUD() throws Exception {
		this.doTestCreate();
		this.doTestRead();
		this.doTestUpdate();
		this.doTestDelete();
	}

	private void doTestCreate() throws Exception {
		// get list
		List<CriticalFunctionDocument> dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
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
		this.dao.create(dObj);
		
		// assert
		dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		assertEquals(++size, dObjs.size());
	}

	private void doTestRead() throws Exception {
		// get list
		List<CriticalFunctionDocument> dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// test
		CriticalFunctionDocument dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String name = dObj.getName();
		
		// get
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(name, dObj.getName());
	}

	private void doTestUpdate() throws Exception {
		// get list
		List<CriticalFunctionDocument> dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// set attributes
		CriticalFunctionDocument dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		String test = this.getRandomTestString(); 
		dObj.setName(test);
		
		// update
		this.dao.update(dObj);
		
		// assert
		dObj = this.dao.getById(id);
		assertNotNull(dObj);
		assertEquals((Integer)id, dObj.getId());
		assertEquals(test, dObj.getName());
	}

	private void doTestDelete() throws Exception {
		// get test plan
		List<CriticalFunctionDocument> dObjs = this.dao.getListByOwnerId(PlanTestData.known_critical_function);
		this.doTestList(dObjs);
		
		// delete
		CriticalFunctionDocument dObj = dObjs.get(dObjs.size()-1);
		int id = dObj.getId();
		this.dao.delete(dObj.getId());
		
		// assert
		dObj = this.dao.getById(id);
		assertNull(dObj);
	}

}
