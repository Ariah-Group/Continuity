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

import junit.framework.TestCase;

import com.meterware.httpunit.Button;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HTMLElement;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public abstract class BaseHTTPTest extends TestCase {
	
	public enum TestEnv {PROD, STAGING, QA, DEV, LOCAL};
	public final static String START_URL = "/login/ready?systemDomainId=";
	public final static String DEFAULT_USERNAME = "UCSFAdmin";
	public final static String DEFAULT_PASSWORD = "test";
	public final static String DEFAULT_SYSTEMDOMAINID = "29";
	public final static String DEFAULT_PLAN_ID = "1035";
	private TestEnv testEnv = TestEnv.LOCAL;
	
	protected WebConversation getNewWebConversation() throws Exception {
		// script disabled
		HttpUnitOptions.setScriptingEnabled(false);
		
		// ssl trust provider
		XTrustProvider.install();

		// new web conversation
		WebConversation wc = new WebConversation();
		WebRequest req = new GetMethodWebRequest(this.getTestUrl(this.testEnv) + START_URL + DEFAULT_SYSTEMDOMAINID);
		WebResponse resp = wc.getResponse(req);
//		System.out.println(resp.getText());
		
		// get institution select form
		WebForm form = resp.getForms()[0];

		// get login form
		form = resp.getForms()[0];
		form.setParameter("j_username", DEFAULT_USERNAME);
		form.setParameter("j_password", DEFAULT_PASSWORD);
		
		// login
		Button[] btns = form.getButtons();
		Button btnLogin = null;
		for (Button button : btns) {
			String btnName = button.getName();
			if (btnName.equals("Login")) {
				btnLogin = button;
				break;
			}
		}
		btnLogin.click();
		
		// response
		resp = wc.getCurrentPage();
//		System.out.println(resp.getText());
		
		// get div tag mission
		HTMLElement elMission = resp.getElementWithID("KualiReadyMission");
		assertNotNull(elMission);

		// return
		return wc;
	}

	public String getTestUrl(TestEnv env) {
		String envUrl = "";
		if (env == TestEnv.PROD)
			envUrl = "https://us.ready.kuali.org";
		else if (env == TestEnv.STAGING)
			envUrl = "https://us.ready-staging.kuali.org";
		else if (env == TestEnv.QA)
			envUrl = "https://us.ready-qa.kuali.org";
		else if (env == TestEnv.DEV)
			envUrl = "https://us.ready-dev.kuali.org";
		else
			envUrl = "http://localhost:8080";
		return envUrl + "/kcpt";
	}
	
	public String getAppUrl() {
		return this.getTestUrl(this.testEnv);
	}

}
