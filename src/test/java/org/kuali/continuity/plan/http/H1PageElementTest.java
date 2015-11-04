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


public class H1PageElementTest extends PageElementTest {
	
	public void testWelcome() throws Exception {
		this.doTestPageElement("/plan/welcome", new H1TagSettings("Welcome"));
	}
	
	public void testContactUs() throws Exception {
		this.doTestPageElement("/plan/contactUs", new H1TagSettings("Contact Us"));
	}
	
	public void testGetPlans() throws Exception {
		this.doTestPageElement("/plan/getPlans", new H1TagSettings("Choose a Plan"));
	}
	
	public void testAnnualReviews() throws Exception {
		this.doTestPageElement("/plan/annualReviews", new H1TagSettings("Annual Review of Your Plan"));
	}
	
	public void testToKnowItems() throws Exception {
		this.doTestPageElement("/plan/toKnowItems", new H1TagSettings("Things to Know As You Do Your Plan"));
	}
	
	public void testFAQs() throws Exception {
		this.doTestPageElement("/plan/faqs", new H1TagSettings("Frequently Asked Questions"));
	}
	
	public void testReferences() throws Exception {
		this.doTestPageElement("/plan/references", new H1TagSettings("References"));
	}
	
	public void testSessionRole() throws Exception {
		this.doTestPageElement("/plan/sessionRole", new H1TagSettings("Emulation Screen"));
	}
	
	public void testMyProfile() throws Exception {
		this.doTestPageElement("/plan/myProfile", new H1TagSettings("My Profile"));
	}
	
	public void testGetBasePlans() throws Exception {
		this.doTestPageElement("/plan/getBasePlans", new H1TagSettings("List of All Plans"));
	}
	
}
