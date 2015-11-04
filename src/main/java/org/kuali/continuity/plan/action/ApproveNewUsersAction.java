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
import java.util.List;

import org.kuali.continuity.action.BaseActionSupport;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.dto.UserDTO;
import org.kuali.continuity.action.util.DomainObject2DTOConverter;
import org.kuali.continuity.admin.action.dto.AdminActionExecutionConstants;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.UserLoginService;
import org.kuali.continuity.admin.service.UserService;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;

@SuppressWarnings("serial")
public class ApproveNewUsersAction extends BaseActionSupport {

	private UserService userService;
	private UserLoginService userLoginService;
	private DomainObject2DTOConverter do2dtoConverter;
	private List<UserDTO> users;
	private int thisApprove;

	public ApproveNewUsersAction(UserService userService, 
			UserLoginService userLoginService,
			DomainObject2DTOConverter do2dtoConverter) {
		this.userService = userService;
		this.userLoginService = userLoginService;
		this.do2dtoConverter = do2dtoConverter;
	}
	
	@Override
	public void prepare() throws Exception {
		
	}

	public List<UserDTO> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

	public int getThisApprove() {
		return this.thisApprove;
	}

	public void setThisApprove(int thisApprove) {
		this.thisApprove = thisApprove;
	}

	@SuppressWarnings("unchecked")
	public String getNewUsers() {
		if (!isUserModeratorOrAdmin())
			return AdminActionExecutionConstants.ADMIN_ACCESS_DENIED;
		int systemDomainId = this.getSessionSystemDomain().id;
		List<User> dObjs = this.userService.getUnapprovedListBySystemDomainId(systemDomainId);
		this.users = (List<UserDTO>) this.do2dtoConverter.getDomainObjectDTOList(dObjs);
		return SUCCESS;
	}
	
	public String approveNewUsers() {
		if (!isUserModeratorOrAdmin())
			return AdminActionExecutionConstants.ADMIN_ACCESS_DENIED;
		List<User> dObjs = new ArrayList<User>();
		if (this.thisApprove == 1 || this.thisApprove == 2) {
			for (UserDTO dto : this.users) {
				if (dto.isSelected) dObjs.add(dto.getDomainObject());
			}
			if (!dObjs.isEmpty()) {
				SessionUserDTO thisUser = (SessionUserDTO) this.getSessionValue(SessionKey.systemAdminUser);
				if (thisUser == null) thisUser = this.getSessionUser();
				this.userLoginService.approveUserLogins(dObjs, thisApprove == 1 ? true : false, thisUser.getDomainObject());
			}
		}
		return SUCCESS;
	}
	
	protected boolean isUserModeratorOrAdmin() {
		SecurityType securityType = new SecurityType(this.getSessionUser().securityType.id);
		if (SecurityTypeEnum.isAdmin(securityType) || SecurityTypeEnum.MODERATOR.getRefDomainObject().equals(securityType))
			return true;
		return false;
	}

}
