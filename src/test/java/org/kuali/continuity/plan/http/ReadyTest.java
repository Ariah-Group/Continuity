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

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class ReadyTest extends TestCase {

	public enum TestEnv {PROD, STAGING, QA, DEV, LOCAL};
	protected TestEnv testEnv = TestEnv.STAGING;

	public void testReady() throws Exception {
		// script disabled
		HttpUnitOptions.setScriptingEnabled(false);
		
		// ssl trust provider
		XTrustProvider.install();

		boolean isFormNull = false;
		int testCount = 50000;
		do {
			// new web conversation
			WebConversation wc = new WebConversation();
			WebRequest req = new GetMethodWebRequest(this.getTestUrl(this.testEnv) + "/login/ready");
			WebResponse resp = wc.getResponse(req);
			testCount--;
			if (testCount % 100 == 0 || testCount <= 10)
				System.out.println("Test " + testCount);
			else
				System.out.print("-");

			// get institution select form
			WebForm form = resp.getForms()[0];
			isFormNull = form == null;
			assertNotNull(form);
//			Thread.sleep(3000);
		} while (!isFormNull && testCount != 0);
		
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
		return envUrl + "/continuity";
	}
	
}
