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

import org.kuali.continuity.plan.action.dto.CriticalFunctionDTO;
import org.kuali.continuity.plan.action.dto.CriticalFunctionNavigation;
import org.kuali.continuity.plan.domain.CriticalFunction;
import org.kuali.continuity.plan.service.ActionItemServiceFactory;
import org.kuali.continuity.plan.service.CriticalFunctionService;

@SuppressWarnings("serial")
public class CriticalFunctionActionItemsAction extends ActionItemsAction {
	
	// service
	private CriticalFunctionService criticalFunctionService;
	
	// bean
	private CriticalFunctionDTO criticalFunction = new CriticalFunctionDTO();
	
	// TODO: needs to be removed
	private String cfNav = CriticalFunctionNavigation.ACTION_ITEMS.name();

	public CriticalFunctionActionItemsAction(ActionItemServiceFactory actionItemServiceFactory) {
		super(actionItemServiceFactory);
		this.setSubNav(CriticalFunctionNavigation.ACTION_ITEMS);
	}

	public CriticalFunctionActionItemsAction(ActionItemServiceFactory actionItemServiceFactory, 
			CriticalFunctionService criticalFunctionService) {
		this(actionItemServiceFactory);
		this.criticalFunctionService = criticalFunctionService;
	}

	public CriticalFunctionDTO getCriticalFunction() {
		return this.criticalFunction;
	}

	public void setCriticalFunction(CriticalFunctionDTO criticalFunction) {
		this.criticalFunction = criticalFunction;
	}

	public String getCfNav() {
		return this.cfNav;
	}

	public void setCfNav(String cfNav) {
		this.cfNav = cfNav;
	}

	@Override
	public String list() throws Exception {
		this.setCriticalFunction();
		return super.list();
	}
	
	@Override
	public String get() throws Exception {
		this.setCriticalFunction();
		return super.get();
	}
	
	private void setCriticalFunction() {
		if (this.criticalFunction.name == null || this.criticalFunction.name.trim().length() == 0) {
			CriticalFunction svcCriticalFunction = this.criticalFunctionService.getCriticalFunction(this.criticalFunction.id);
			this.criticalFunction = new CriticalFunctionDTO(svcCriticalFunction);
		}
	}
	
	@Override
	protected int getOwnerId() {
		return this.criticalFunction.id;
	}

}
