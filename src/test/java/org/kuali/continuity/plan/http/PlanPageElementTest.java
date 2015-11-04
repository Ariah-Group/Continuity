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

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HTMLElement;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public abstract class PlanPageElementTest extends PageElementTest {
	
	public final static String PLAN_HOME_URL = "/plan/planHome?planId=";
	
	// default
	private String planId = BaseHTTPTest.DEFAULT_PLAN_ID;

	@Override
	protected WebConversation getNewWebConversation() throws Exception {
		// get web conversation with user session
		WebConversation wc = super.getNewWebConversation();
		WebRequest req = new GetMethodWebRequest(this.getAppUrl() + PLAN_HOME_URL + this.planId);
		WebResponse resp = wc.getResponse(req);
		
		// get div tag mission
		HTMLElement[] els = resp.getElementsByTagName("h1");
		HTMLElement elH1 = els[0];
		assertNotNull(elH1);
		assertFalse(elH1.getText().indexOf("This is the home page for your plan.") < 0);

		// return
		return wc;
	}

}
