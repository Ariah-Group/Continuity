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
package org.kuali.continuity.plan.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionUserDTO;

@SuppressWarnings("serial")
public class UserProfileAction extends BaseActionSupport implements ServletRequestAware {
	
	private SessionUserDTO user;
	private int saveActionType;
	
	// referer for back
	private String referer = "";
	
	// request
	private HttpServletRequest request;
	
	public SessionUserDTO getUser() {
		return this.user;
	}

	public void setUser(SessionUserDTO user) {
		this.user = user;
	}

	public int getSaveActionType() {
		return this.saveActionType;
	}
	
	public void setSaveActionType(int saveActionType) {
		this.saveActionType = saveActionType;
	}

	public String getReferer() {
		return this.referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String execute() throws Exception {
		if (this.saveActionType == 0)
			this.referer = this.request.getHeader("Referer");
		return SUCCESS;
	}
	
	public void prepare() throws Exception {
		this.user = (SessionUserDTO) this.getSessionValue(SessionKey.systemAdminUser);
		if (this.user == null) this.user = this.getSessionUser();
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
