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
package org.kuali.continuity.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.dto.SessionValue;
import org.kuali.continuity.action.util.SessionHelper;
import org.kuali.continuity.action.util.SessionHelperImpl;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction implements Action, SessionAware, Preparable, SessionHelper {
	
	private SessionHelperImpl sessionHelper;

	public void setSession(Map<String, Object> session) {
		this.sessionHelper = new SessionHelperImpl(session);
	}

	public Object getSessionValue(SessionKey key) {
		return this.sessionHelper.getSessionValue(key);
	}

	public void putInSession(SessionKey key, SessionValue value) {
		this.sessionHelper.putInSession(key, value);
		
	}

	public void removeFromSession(SessionKey key) {
		this.sessionHelper.removeFromSession(key);
	}
	
	public SessionSystemDomainDTO getSessionSystemDomain() {
		return (SessionSystemDomainDTO) this.getSessionValue(SessionKey.systemDomain);
	}

	public SessionUserDTO getSessionUser() {
		return (SessionUserDTO) this.getSessionValue(SessionKey.user);
	}
	
}
