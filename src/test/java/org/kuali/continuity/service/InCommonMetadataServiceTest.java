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

import org.kuali.continuity.BasePlanTest;

public class InCommonMetadataServiceTest extends BasePlanTest{
	
	private InCommonMetadataService service;
	
	public void setService(InCommonMetadataService service) {
		this.service = service;
	}

	public void testInjection() throws Exception {
		String message = "Service is: " + this.service.toString();
		System.out.println(message);
		assertNotNull(this.service);
	}
	
	public void testGetSingleSignOnLocationUCB() throws Exception {
		long startTime = System.currentTimeMillis();
		String entityId = "urn:mace:incommon:berkeley.edu";
		String location = this.service.getSingleSignOnLocation(entityId);
		assertNotNull(location);
		assertEquals(location, "https://shib.berkeley.edu/idp/profile/Shibboleth/SSO");
		long elapse = System.currentTimeMillis() - startTime;
		System.out.println("Time for UCB is: " + elapse);
	}
	
	public void testGetSingleSignOnLocationUCBCache() throws Exception {
		long startTime = System.currentTimeMillis();
		String entityId = "urn:mace:incommon:berkeley.edu";
		String location = this.service.getSingleSignOnLocation(entityId);
		assertNotNull(location);
		assertEquals(location, "https://shib.berkeley.edu/idp/profile/Shibboleth/SSO");
		long elapse = System.currentTimeMillis() - startTime;
		System.out.println("Time for UCB is: " + elapse);
	}
	
	
	public void testGetSingleSignOnLocationUCD() throws Exception {
		long startTime = System.currentTimeMillis();
		String entityId = "urn:mace:incommon:ucdavis.edu";
		String location = this.service.getSingleSignOnLocation(entityId);
		assertNotNull(location);
		assertEquals(location, "https://shibboleth.ucdavis.edu/shibboleth-idp/SSO");
		long elapse = System.currentTimeMillis() - startTime;
		System.out.println("Time for UCD is: " + elapse);
	}
	
	public void testGetSingleSignOnLocationUCDCache() throws Exception {
		long startTime = System.currentTimeMillis();
		String entityId = "urn:mace:incommon:ucdavis.edu";
		String location = this.service.getSingleSignOnLocation(entityId);
		assertNotNull(location);
		assertEquals(location, "https://shibboleth.ucdavis.edu/shibboleth-idp/SSO");
		long elapse = System.currentTimeMillis() - startTime;
		System.out.println("Time for UCD is: " + elapse);
	}
	
	public void testGetSingleSignOnLocationUIUC() throws Exception {
		long startTime = System.currentTimeMillis();
		String entityId = "urn:mace:incommon:uiuc.edu";
		String location = this.service.getSingleSignOnLocation(entityId);
		assertNotNull(location);
		assertEquals(location, "https://shibboleth.cites.uiuc.edu/shibboleth-idp/SSO");
		long elapse = System.currentTimeMillis() - startTime;
		System.out.println("Time for UIUC is: " + elapse);
	}
	
	public void testGetSingleSignOnLocationUIUCCache() throws Exception {
		long startTime = System.currentTimeMillis();
		String entityId = "urn:mace:incommon:uiuc.edu";
		String location = this.service.getSingleSignOnLocation(entityId);
		assertNotNull(location);
		assertEquals(location, "https://shibboleth.cites.uiuc.edu/shibboleth-idp/SSO");
		long elapse = System.currentTimeMillis() - startTime;
		System.out.println("Time for UIUC is: " + elapse);
	}
	
	public void testGetSingleSignOnLocationBlank() throws Exception {
		long startTime = System.currentTimeMillis();
		String entityId = "xxxxxxxxxxxxxxxxxxxxxxxxxxx";
		String location = this.service.getSingleSignOnLocation(entityId);
		assertNull(location);
		//assertEquals(location, "https://shibboleth.cites.uiuc.edu/shibboleth-idp/SSO");
		long elapse = System.currentTimeMillis() - startTime;
		System.out.println("Time for blank is: " + elapse);
	}
	
	
	
}
