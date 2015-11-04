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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.action.dto.UserDTO;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.GenericAdminService;
import org.kuali.continuity.admin.service.UserService;
import org.kuali.continuity.domain.PlanAccessType;

public class GetSystemDomainUsersAction extends GetUsersAction {
	
	private GenericAdminService genericAdminService;
	private UserService userService;
	private PlanActionServiceHelper serviceHelper;
	private String firstName;
	private String lastName;
	private DomainObjectDTO systemDomain = new DomainObjectDTO();
	private List<RefDTO> planAccessTypes;
	private boolean isContactTable;
	
	public GetSystemDomainUsersAction(GenericAdminService genericAdminService, UserService userService, PlanActionServiceHelper serviceHelper) {
		this.genericAdminService = genericAdminService;
		this.userService = userService;
		this.serviceHelper = serviceHelper;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public DomainObjectDTO getSystemDomain() {
		return this.systemDomain;
	}

	public void setSystemDomain(DomainObjectDTO systemDomain) {
		this.systemDomain = systemDomain;
	}

	public int getUsersCount() {
		return (this.getUsers() == null ? 0 : this.getUsers().size());
	}

	public void setUsersCount(int usersCount) {
		// do nothing;
	}
	
	public boolean isContactTable() {
		return this.isContactTable;
	}

	public void setContactTable(boolean isContactTable) {
		this.isContactTable = isContactTable;
	}

	public List<RefDTO> getPlanAccessTypes() {
		return this.planAccessTypes;
	}

	public void setPlanAccessTypes(List<RefDTO> planAccessTypes) {
		this.planAccessTypes = planAccessTypes;
	}

	public String execute() throws Exception {
		super.execute();
		if (this.systemDomain.id == 0) return ERROR;
		this.systemDomain = new DomainObjectDTO((SystemDomain) this.genericAdminService.getById(SystemDomain.class, this.systemDomain.id));
		this.planAccessTypes = this.serviceHelper.getRefDTOs(PlanAccessType.class);
		return SUCCESS;
	}
	
	public void buildUsers() {
		if (this.systemDomain.id == 0) return;

		// get users
		Collection<User> svcUsers = this.userService.getListBySystemDomainIdAndNames(this.systemDomain.id, firstName, lastName);
		
		// set users
		List<UserDTO> dtos = new ArrayList<UserDTO>(); 
		if (svcUsers != null) {
			for (User user : svcUsers) {
				dtos.add(new UserDTO(user));
			}
		}
		this.setUsers(dtos);		
	}

}