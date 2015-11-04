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
package org.kuali.continuity.security;

import java.util.HashMap;
import java.util.Map;

public enum SecurityErrorCode {

	DOMAIN_WITH_IDP_NOT_FOUND("0", "The institution with Shibboleth IDP is not found."), 
	INVALID_IDP_EPPN("1", "The Shibboleth unique user identifier is not valid or value is null in the shibboleth header."), 
	INVALID_IDP_MAIL("2", "The Shibboleth email is not valid."),
	SESSION_EXPIRED("3", "Your connection has timed out, or has ended for another reason.  To continue, please login again in your normal fashion."),
	DUPLICATE_INSTITUTION_BY_IDP("4", "More than one institution use the same IDP."),
	IDP_PROVIDER_NOT_VALID_OR_NULL("5", "The Shibboleth IDP is not found or null."),
	SHIBBOLETH_LOGIN_WITHOUT_CUSTOM_URL("6", "You login from the url without specifying institution custom url. Please login with your institution's url with custom url.");

	private String id;
	private String description;	

	SecurityErrorCode(final String id, final String description) {
		this.id = id;
		this.description = description;
	}
	
	public String  getId()   { return  id; }
	public String  getDescription()   { return  description; }
	
	private static Map<String, String> table = new HashMap<String, String>();
	static {
	    for (SecurityErrorCode securityErrorCode : SecurityErrorCode.values()) {	       
	        table.put(securityErrorCode.getId(), securityErrorCode.getDescription());
	    }
	}

	public static String valueOfId(String id) {
	    return table.get(id);
	}
}
