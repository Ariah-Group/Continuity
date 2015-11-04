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

import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.service.BaseService;

public class BaseUpdateAction extends BaseSaveAction implements UpdateAction, ServiceAction {

	private BaseService service;

	public BaseUpdateAction() {

	}

	public BaseService getService() {
		return this.service;
	}

	public void setService(BaseService service) {
		this.service = service;
	}

	@Override
	protected void doSave(BaseDomainObject obj) throws Exception {
		this.service.update(obj);
	}

}
