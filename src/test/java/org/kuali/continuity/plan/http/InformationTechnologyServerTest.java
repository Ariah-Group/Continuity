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
package org.kuali.continuity.plan.http;

import com.meterware.httpunit.Button;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.TableCell;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebLink;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

public class InformationTechnologyServerTest extends PlanPageElementTest {
	
	final static String TEST_SERVER_NAME = "HTTP Unit Server";
	
	public void testCreate() throws Exception {
		System.out.println("----- Create Server");
		
		// web conversation
		WebConversation wc = this.getNewWebConversation();
		WebResponse resp = this.getInformationTechnologyServerPage(wc);
		
		// get row count
		WebTable table = resp.getTableWithID("editplan_table");
		int rowCount = (table == null) ? 1 : table.getRowCount(); // init count is not 0 because of table header
		
		// get & set form
		WebForm form = resp.getFormWithID("addInformationTechnologyServer");
		form.setParameter("dto.name", TEST_SERVER_NAME);
		form.setParameter("dto.type.id", "BACKUP");
		form.setParameter("dto.explanation", "Some Explanation");

		// add to list
		Button btnAdd = form.getButtonWithID("btnAdd");
		btnAdd.click();
		
		// check row count
		resp = wc.getCurrentPage();
		int newRowCount = resp.getTableWithID("editplan_table").getRowCount();
		assertEquals(rowCount+1, newRowCount);
	}
	
	public void testCreateWithError() throws Exception {
		System.out.println("----- Create Server With Error");

		// web conversation
		WebConversation wc = this.getNewWebConversation();
		WebResponse resp = this.getInformationTechnologyServerPage(wc);
		
		// get & set form
		WebForm form = resp.getFormWithID("addInformationTechnologyServer");
//		form.setParameter("dto.name", TEST_SERVER_NAME);
		form.setParameter("dto.type.id", "BACKUP");
		form.setParameter("dto.explanation", "Some Explanation");

		// add to list
		Button btnAdd = form.getButtonWithID("btnAdd");
		btnAdd.click();
		
		// get errors
		resp = wc.getCurrentPage();
		form = resp.getFormWithID("addInformationTechnologyServer");
		String errors[] = form.getParameterValues("kcptErrors");
		for (String error : errors) {
			System.out.println("Error! - " + error);
		}
		assertTrue(errors.length > 0);
	}
	
	public void testUpdate() throws Exception {
		System.out.println("----- Update Server");

		// web conversation
		WebConversation wc = this.getNewWebConversation();
		WebResponse resp = this.getInformationTechnologyServerPage(wc);
		
		// get table
		WebTable table = resp.getTableWithID("editplan_table");
		assertNotNull(table);
		int rowCount = table.getRowCount();
		int row = 0;
		for (int i = 1; i < rowCount; i++) {
			if (TEST_SERVER_NAME.equals(table.getCellAsText(i, 0))) {
				row = i;
				break;
			}
		}
		assertTrue(row > 0);
		
		// get link
		TableCell cell = table.getTableCell(row, 3);
		WebLink[] links = cell.getLinks();
		WebLink link = links[0];
		
		// click link
		link.click();
		resp = wc.getCurrentPage();
		
		// check page
		this.doTestPageElement(resp, new H1TagSettings("Details for This Server"));
		
		// get & set form
		WebForm form = resp.getFormWithID("saveInformationTechnologyServer");
		form.setParameter("dto.type.id", "FILE");
		form.setParameter("dto.explanation", "Modified Explanation");
		form.setParameter("dto.backupFrequency.id", "Daily");
		form.setParameter("dto.backupMedia.id", "REMOTE_SERVER");
		form.setParameter("dto.backupType.id", "AUTO");
		form.setParameter("dto.applicationsImpacted", "Applications Impacted");
		form.setParameter("dto.departmentsImpacted", "Departments Impacted");
		form.setParameter("dto.serverSoftware", "Server Software");
		form.setParameter("dto.technicalExperts", "Technical Experts");
		form.setParameter("dto.responsiblePersons", "Responsible Persons");
		form.setParameter("dto.onsiteLocation", "Onsite Location");
		form.setParameter("dto.offsiteLocation", "Offsite Location");
		form.setParameter("dto.offsiteStorageFrequency.id", "VARIES");
		form.setParameter("dto.diskAndDocsLocations", "Disks and Docs Locations");
		form.setParameter("dto.recoveryResult.id", "NA");
		form.setParameter("dto.recoveryResultExplanation", "Recovery Result Explanation");
		
		// submit
		form.submit();

		// check
		resp = wc.getCurrentPage();
		assertTrue("Modified Explanation".equals(form.getParameterValue("dto.explanation")));
	}
	
	public void testDelete() throws Exception {
		System.out.println("----- Delete Server");

		// web conversation
		WebConversation wc = this.getNewWebConversation();
		WebResponse resp = this.getInformationTechnologyServerPage(wc);
		
		// get table
		WebTable table = resp.getTableWithID("editplan_table");
		assertNotNull(table);
		int rowCount = table.getRowCount();
		int row = 0;
		for (int i = 1; i < rowCount; i++) {
			if (TEST_SERVER_NAME.equals(table.getCellAsText(i, 0))) {
				row = i;
				break;
			}
		}
		assertTrue(row > 0);
		
		// get link
		TableCell cell = table.getTableCell(row, 4);
		WebLink[] links = cell.getLinks();
		WebLink link = links[0];
		
		// click link
		link.click();
		resp = wc.getCurrentPage();
		
		// get new row count
		resp = wc.getCurrentPage();
		table = resp.getTableWithID("editplan_table");
		int newRowCount = (table == null) ? 1 : table.getRowCount(); // init count is not 0 because of table header
		
		// check
		assertEquals(rowCount-1, newRowCount);
	}
	
	private WebResponse getInformationTechnologyServerPage(WebConversation wc) throws Exception {
		WebRequest req = new GetMethodWebRequest(this.getAppUrl() + "/plan/getInformationTechnologyServers");
		WebResponse resp = wc.getResponse(req);
		this.doTestPageElement(resp, new H1TagSettings("Servers"));
		return resp;
	}

}
