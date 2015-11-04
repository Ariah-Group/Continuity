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
package org.kuali.continuity.service;

import java.util.HashMap;
import java.util.Map;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.admin.domain.User;

public class EmailSenderServiceTest extends BasePlanTest {
	
	private EmailSenderService service;
	
	public void setService(EmailSenderService service) {
		this.service = service;
	}

	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}
	
	public void testSendEmailMessageFromTemplate() throws Exception {
		String[] tos = {"kualiready-test@lists.berkeley.edu", "lito.tejada@berkeley.edu"};
		this.service.sendEmailMessage(29, tos, EmailMessageEnum.MODERATOR_DENY_USER, new User());
	}
	
	public void testSendEmailMessageFromModeledTemplate() throws Exception {
		String to = "kualiready-test@lists.berkeley.edu";
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("authId", "test");
		model.put("password", "Y0u7N3w4a55w07d");
		this.service.sendEmailMessage(29, to, EmailMessageEnum.MODERATOR_APPROVE_USER, model, new User());
	}

	public void testSendEmailMessage() throws Exception {
		String[] tos = {"kualiready-test@lists.berkeley.edu", "lito.tejada@berkeley.edu"};
		String to = "kualiready-test@lists.berkeley.edu";
		this.service.sendEmailMessage(tos, to, null, "Test", "This is a test.", new User());
	}

}
