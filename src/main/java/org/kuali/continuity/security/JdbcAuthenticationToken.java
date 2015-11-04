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

import org.springframework.security.GrantedAuthority;
import org.springframework.security.providers.UsernamePasswordAuthenticationToken;

public class JdbcAuthenticationToken extends UsernamePasswordAuthenticationToken{
	
	/**
	 * Customized token extened from UserPasswordAuthenticationToken
	 */
	private static final long serialVersionUID = 3175781883530015092L;
	private String locationId;
	
	public void setLocationId(String locationId){
		this.locationId = locationId;
	}
	
	public Object getDetails(){
		return locationId;
	}
	
	public JdbcAuthenticationToken(Object principal, Object credentials,
			GrantedAuthority[] authorities, String locationId) {
		super(principal, credentials, authorities);
		// TODO Auto-generated constructor stub
		setLocationId(locationId);
	}
}
