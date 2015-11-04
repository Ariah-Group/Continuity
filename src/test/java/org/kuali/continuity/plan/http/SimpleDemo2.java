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
import com.meterware.httpunit.HTMLElement;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class SimpleDemo2 extends TestCase {
	
	public void testBegin() throws Exception {
		// new web conversation
		WebConversation wc = new WebConversation();
		WebRequest req = new GetMethodWebRequest("http://localhost:8080/kcpt/login/start?userId=183");
		WebResponse resp = wc.getResponse(req);
		System.out.println(resp.getText());

		// get div tag mission
		HTMLElement[] els = resp.getElementsByTagName("div");
		HTMLElement elMission = null;
		for (HTMLElement el : els) {
			if (el.getClassName().equals("mission")) {
				elMission = el;
				break;
			}
		}
		
		// check
		assertNotNull(elMission);
	}
	
}
