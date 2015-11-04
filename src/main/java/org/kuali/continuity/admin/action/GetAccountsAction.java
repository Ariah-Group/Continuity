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
package org.kuali.continuity.admin.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kuali.continuity.domain.valueobject.UserListValue;
import org.kuali.continuity.service.RoleService;

import com.opensymphony.xwork2.Action;

public class GetAccountsAction implements Action {
	
	private int institutionId;
	private int start;
	private int limit;
	private Map<String, Object> jsonModel;
	private RoleService roleService;
	private final static String ACCOUNTS = "accounts";
	private final static String SIZE = ACCOUNTS+"-size";
	
	public GetAccountsAction(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public int getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Map<String, Object> getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Map<String, Object> jsonModel) {
		this.jsonModel = jsonModel;
	}

	public String execute() {
		List<UserListValue> userList = this.roleService.getUserValuesbyInst(this.getInstitutionId());
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(ACCOUNTS, userList);
		model.put(SIZE, "" + (userList == null ? 0 : userList.size()));
		this.setJsonModel(model);
		return SUCCESS;
	}

}