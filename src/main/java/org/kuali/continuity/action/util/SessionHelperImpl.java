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
package org.kuali.continuity.action.util;

import java.util.Map;

import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionValue;

public class SessionHelperImpl implements SessionHelper {

	private Map<String, Object> session;

	public SessionHelperImpl(Map<String, Object> session) {
		this.session = session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
		return this.session;
	}
	
	public Object getSessionValue(SessionKey key) {
		return this.getSession().get(key.name());
	}
	
	public void putInSession(SessionKey key, SessionValue value) {
		this.getSession().put(key.name(), value);
	}
	
	public void removeFromSession(SessionKey key) {
		this.getSession().remove(key.name());
	}

}
