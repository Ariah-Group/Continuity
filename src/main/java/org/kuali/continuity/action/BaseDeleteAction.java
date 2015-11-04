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

import org.kuali.continuity.service.BaseService;

public class BaseDeleteAction implements DeleteAction, ServiceAction {
	
	private BaseService service;
	private int rowId;
	
	public BaseDeleteAction() {

	}

	public BaseService getService() {
		return this.service;
	}

	public void setService(BaseService service) {
		this.service = service;
	}

	public int getRowId() {
		return this.rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}
	
	public String execute() throws Exception {
		return this.delete(this.rowId);
	}

	protected String delete(int rowId) throws Exception {
		if (rowId != 0) 
			this.service.delete(rowId);
		return SUCCESS;
	}

}
