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
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class SimpleDemo3 extends TestCase {
	
	public void testUCReady() throws Exception {
		// ssl trust provider
		XTrustProvider.install();

		// new web conversation
		WebConversation wc = new WebConversation();
		WebRequest req = new GetMethodWebRequest("https://us1.ready.kuali.org/continuity/login/ready?systemDomainId=29");
//		WebRequest req = new GetMethodWebRequest("https://shib.berkeley.edu/ds/ucready.wayf?shire=https%3A%2F%2Fucready-dev.berkeley.edu%2FShibboleth.sso%2FSAML%2FPOST&time=1258395112&target=cookie%3A29002348&providerId=https%3A%2F%2Fucready-dev.berkeley.edu%2Fshibboleth-sp");
		WebResponse resp = wc.getResponse(req);
		System.out.println(resp.getText());
		
		// get institution select form
		WebForm form = resp.getForms()[0];
//		form.setParameter("origin", "urn:mace:incommon:berkeley.edu");
//		form.submit();
		
		// print response
		this.printWebResponse(wc);
		
		// get login form
		form = resp.getForms()[0];
		form.setParameter("j_username", "UCSFAdmin");
		form.setParameter("j_password", "test");
		
		// add to list
//		Button btnAdd = form.getButtonWithName("Login");
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
		
		// print response
		this.printWebResponse(wc);
	}
	
	private void printWebResponse(WebConversation wc) throws Exception {
		WebResponse resp = wc.getCurrentPage();
		System.out.println(resp.getText());
	}
	
}
