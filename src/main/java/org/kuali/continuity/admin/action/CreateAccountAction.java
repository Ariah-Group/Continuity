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

import org.kuali.continuity.action.BaseFormAction;
import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionMessage;
import org.kuali.continuity.action.dto.SystemDomainDTO;
import org.kuali.continuity.action.dto.UserDTO;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.admin.service.UserService;

@SuppressWarnings("serial")
public class CreateAccountAction extends BaseFormAction {
	
	public CreateAccountAction() {
		super();
	}
	
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setValidateAction(new CreateAccountValidateAction());
	}

	@Override
	protected int getOwnerId() {
		// not used
		return 0;
	}
	
	public String newAccount() throws Exception {
		SystemDomainDTO systemDomainDTO = (SystemDomainDTO) this.getSessionValue(SessionKey.loginSystemDomain);
		if (systemDomainDTO == null)
			throw new Exception("Invalid page navigation!");
		UserDTO dto = new UserDTO();
		dto.systemDomain = systemDomainDTO;
		this.setDto(dto);
		return SUCCESS;
	}
	
	@Override
	public String add() throws Exception {
		UserService userService = (UserService) this.getService();
		UserDTO userDTO = (UserDTO) this.getDto();
		User testUser = userService.getBySystemDomainIdAndEmail(userDTO.systemDomain.id, userDTO.emailRegular);
		String retVal = "";
		if (testUser != null) {
			UserDTO testUserDTO = new UserDTO(testUser);
			testUserDTO.firstName = userDTO.firstName;
			testUserDTO.lastName = userDTO.lastName;
			testUserDTO.authId = userDTO.authId;
			this.setDto(testUserDTO);
			retVal = super.update();
		} else {
			retVal = super.add();
		}
		if (SUCCESS.equals(retVal))
			this.putInSession(SessionKey.tmpActionMessage, new SessionMessage("Request submitted. Thank you!"));
		return retVal;
	}

	public class CreateAccountValidateAction extends BaseValidateAction {

		// true - success
		// false - with error
		// null - ignore and do not save
		@Override
		public Boolean validate(DomainObjectDTO dto) throws Exception {
			UserDTO userDTO = (UserDTO) dto;
			UserService userService = (UserService) CreateAccountAction.this.getService();

			// first test
			User testUser = null;
			testUser = userService.getBySystemDomainIdAndAuthId(userDTO.systemDomain.id, userDTO.authId);
			if (testUser != null && testUser.isModApproved() != null) {
				this.addActionError("User with login name '" + userDTO.authId + "' already exists.");
				return false;
			}
			
			// second test
			testUser = null;
			testUser = userService.getBySystemDomainIdAndEmail(userDTO.systemDomain.id, userDTO.emailRegular);
			if (testUser != null && testUser.isModApproved() != null) {
				this.addActionError("User with Email '" + userDTO.emailRegular + "' already exists.");
				return false;
			}
			
			return true;
		}

	}

}
