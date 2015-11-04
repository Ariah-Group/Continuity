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

import org.kuali.continuity.admin.service.UserLoginService;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.Authentication;
import org.springframework.security.AuthenticationException;
import org.springframework.security.BadCredentialsException;
import org.springframework.security.event.authentication.AuthenticationSuccessEvent;
import org.springframework.security.providers.ProviderManager;

public class JdbcAuthenticationManager extends ProviderManager{
	private ApplicationEventPublisher applicationEventPublisher;
	
	private UserLoginService userLoginService;
	
	
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}
	
	public Authentication doAuthentication(Authentication authentication) throws AuthenticationException {
		this.getSessionController().checkAuthenticationAllowed(authentication);
		
		if (authentication != null) {
			
			if(!this.userLoginService.authenticate(Integer.parseInt(authentication.getDetails().toString()), authentication.getName().toString(), authentication.getCredentials().toString())){
				throw new BadCredentialsException("Invalid user/password");
			}
			
			this.getSessionController().registerSuccessfulAuthentication(authentication);			
			publishEvent(new AuthenticationSuccessEvent(authentication));			
		}				
		return authentication;
	}
	
	private void publishEvent(ApplicationEvent event) {
	    if (applicationEventPublisher != null) {
	        applicationEventPublisher.publishEvent(event);
	    }
	}
}
