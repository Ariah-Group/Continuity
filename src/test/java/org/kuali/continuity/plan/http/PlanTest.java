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

import org.kuali.continuity.PlanTestData;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HTMLElement;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.httpunit.WebTable;

public class PlanTest extends BaseHTTPTest {
	
	final static String TEST_PLAN_NAME = "HTTP Unit Test Plan";
	final static String TEST_PLAN_NAME_MODIFIED = TEST_PLAN_NAME + " - Modified";
	
	public void testCreate() throws Exception {
		// web conversation
		WebConversation wc = this.getNewWebConversation();
		WebRequest req = new GetMethodWebRequest(this.getAppUrl() + "/plan/editPlan");
		WebResponse resp = wc.getResponse(req);
		
		// get form
		WebForm form = resp.getFormWithID("PlanGeneral");
		assertNotNull(form);
		
		// set parameters
		form.setParameter("plan.name", TEST_PLAN_NAME);
		form.setParameter("systemDomainId", "" + PlanTestData.uc_institution);
		form.setParameter("majorDivisionId", "37");
		form.setParameter("acronymId", "0");
		form.setParameter("plan.departmentHead.fullName", "test");
		form.setParameter("plan.departmentHead.title", "test");
		
		// submit page
		resp = form.submit();
		
		// check
		this.doTestGetPlans(wc, TEST_PLAN_NAME, false);
	}
	
	public void testGetPlan() throws Exception {
		WebConversation wc = this.getNewWebConversation();
		String planId = this.doTestGetPlans(wc, TEST_PLAN_NAME, false);
		this.doTestGetPlan(wc, planId, TEST_PLAN_NAME);
	}
	
	public void testUpdate() throws Exception {
		// web conversation
		WebConversation wc = this.getNewWebConversation();
		String planId = this.doTestGetPlans(wc, TEST_PLAN_NAME, false);
		this.doTestGetPlan(wc, planId, TEST_PLAN_NAME);

		// edit
		WebRequest req = new GetMethodWebRequest(this.getAppUrl() + "/plan/getPlanDepartment");
		WebResponse resp = wc.getResponse(req);
		
		// get form
		WebForm form = resp.getFormWithID("PlanGeneral");
		assertNotNull(form);
		
		// set parameters
		form.setParameter("plan.name", TEST_PLAN_NAME_MODIFIED);
		form.setParameter("plan.departmentHead.fullName", "test");
		form.setParameter("plan.departmentHead.title", "test");
		
		// submit page
		resp = form.submit();
		
		// check
		this.doTestGetPlan(wc, "", TEST_PLAN_NAME_MODIFIED);
	}
	
	public void testDelete() throws Exception {
		// web conversation
		WebConversation wc = this.getNewWebConversation();
		String planId = this.doTestGetPlans(wc, TEST_PLAN_NAME_MODIFIED, false);
		
		// delete
		WebRequest req = new GetMethodWebRequest(this.getAppUrl() + "/plan/deletePlan?planId="+planId);
		wc.getResponse(req);
		
		// check
		doTestGetPlans(wc, TEST_PLAN_NAME_MODIFIED, true);
	}
	
	protected String doTestGetPlans(WebConversation wc, String planName, boolean isDelete) throws Exception {
		// plan list page
		WebRequest req = new GetMethodWebRequest(this.getAppUrl() + "/plan/getPlans");
		WebResponse resp = wc.getResponse(req);
		
		// table
		WebTable table = resp.getTableWithID("planTable");
		assertNotNull(table);
		int row = -1;
		for (int i = 0; i < table.getRowCount(); i++) {
			if (planName.equals(table.getCellAsText(i, 0))) {
				row = i;
				break;
			}
		}
		
		// check
		if (!isDelete) {
			assertFalse(row < 0);
			return table.getCellAsText(row, 1);
		}
		
		assertTrue(row < 0);
		return "";
	}
	
	protected void doTestGetPlan(WebConversation wc, String planId, String planName) throws Exception {
		// plan id
		String url = this.getAppUrl() + "/plan/planHome";
		if (planId != null && planId.trim().length() != 0)
			url += "?planId="+planId;
		
		// plan home
		WebRequest req = new GetMethodWebRequest(url);
		WebResponse resp = wc.getResponse(req);
		
		// get span element
		HTMLElement el = resp.getElementWithID("planname");
		assertNotNull(el);
		
		// test read
		assertTrue(planName.equals(el.getText()));
	}
}
