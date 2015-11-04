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
import java.util.HashMap;
import java.util.List;

import org.kuali.continuity.action.BaseFormAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.SessionSystemDomainDTO;
import org.kuali.continuity.action.dto.SessionUserDTO;
import org.kuali.continuity.action.util.SessionUserRoleUtil;
import org.kuali.continuity.admin.action.dto.AdminActionExecutionConstants;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.service.SystemDomainService;
import org.kuali.continuity.domain.BaseRefDomainObject;
import org.kuali.continuity.domain.SecurityType;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.plan.action.dto.SessionPlanResetValue;

@SuppressWarnings("serial")
public class SessionRoleAction extends BaseFormAction {

	// services
	private SessionUserRoleUtil sessionUserRoleUtil;
	private SystemDomainService systemDomainService;

	// properties
	private int systemDomainId;
	private String securityTypeId;

	public SessionRoleAction(SessionUserRoleUtil sessionUserRoleUtil,
			SystemDomainService systemDomainService) {
		super();
		this.sessionUserRoleUtil = sessionUserRoleUtil;
		this.systemDomainService = systemDomainService;
	}

	public int getSystemDomainId() {
		return this.systemDomainId;
	}

	public void setSystemDomainId(int systemDomainId) {
		this.systemDomainId = systemDomainId;
	}

	public String getSecurityTypeId() {
		return this.securityTypeId;
	}

	public void setSecurityTypeId(String securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	public String execute() throws Exception {
		if (this.getSessionSystemAdminUser() == null) return AdminActionExecutionConstants.ADMIN_ACCESS_DENIED;
		this.systemDomainId = this.getSessionUser().systemDomain.id;
		this.securityTypeId = this.getSessionUser().securityType.id;
		return SUCCESS;
	}

	public String setNew() throws Exception {
		// check security type
		if (this.getSessionSystemAdminUser() == null) return AdminActionExecutionConstants.ADMIN_ACCESS_DENIED;

		// get session user
		SessionUserDTO userDTO = this.getSessionUser();

		// set system domain role
		this.sessionUserRoleUtil.setSessionUserRole(userDTO,
				this.systemDomainId);

		// get security type
		RefDTO securityTypeDTO = null;
		int index = this.getRefListMap()
				.get(SecurityType.class.getSimpleName()).indexOf(
						new RefDTO(this.securityTypeId));
		if (index >= 0)
			securityTypeDTO = this.getRefListMap().get(
					SecurityType.class.getSimpleName()).get(index);

		// set security type
		userDTO.securityType = securityTypeDTO;

		// put in session
		this.putInSession(SessionKey.user, userDTO);
		this.putInSession(SessionKey.systemDomain,
				(SessionSystemDomainDTO) userDTO.systemDomain);

		// reset session plan
		this.resetSessionPlan();

		// return
		return SUCCESS;
	}

	public String restore() throws Exception {
		if (this.getSessionSystemAdminUser() == null) return AdminActionExecutionConstants.ADMIN_ACCESS_DENIED;
		SessionUserDTO userDTO = this.getSessionUser();
		SessionUserDTO sysAdminUserDTO = this.getSessionSystemAdminUser();
		userDTO.id = sysAdminUserDTO.id;
		userDTO.systemDomain = sysAdminUserDTO.systemDomain;
		userDTO.securityType = sysAdminUserDTO.securityType;
		userDTO.systemDomainAccess = sysAdminUserDTO.systemDomainAccess;
		userDTO.isDirAccessible = sysAdminUserDTO.isDirAccessible;
		userDTO.isShibMode = sysAdminUserDTO.isShibMode;
		userDTO.isLBNLUser = sysAdminUserDTO.isLBNLUser;
		this.putInSession(SessionKey.systemDomain,
				(SessionSystemDomainDTO) userDTO.systemDomain);
		this.resetSessionPlan();
		return SUCCESS;
	}

	private void resetSessionPlan() {
		this.putInSession(SessionKey.plan, new SessionPlanResetValue());
	}

	@SuppressWarnings("unchecked")
	public void prepare() throws Exception {
		// get security type
		RefDTO securityType = this.getSessionSystemAdminUserSecurityType();
		if (securityType == null
				|| (!(securityType.id.equals(SecurityTypeEnum.SYSTEM_ADMIN
						.getRefDomainObject().getId()) || securityType.id
						.equals(SecurityTypeEnum.INSTITUTION_ADMIN
								.getRefDomainObject().getId())))) {
			this.getRefListMap().put(SecurityType.class.getSimpleName(),
					new ArrayList<RefDTO>());
			this.getAdminListMap().put(SystemDomain.class.getSimpleName(),
					new ArrayList<DomainObjectDTO>());
			return;
		}

		// call parent
		super.prepare();

		// reset security type list
		if (!securityType.id.equals(SecurityTypeEnum.SYSTEM_ADMIN
				.getRefDomainObject().getId())) {
			List<RefDTO> dtos = this.getRefListMap().get(
					SecurityType.class.getSimpleName());
			dtos.remove(new RefDTO(SecurityTypeEnum.SYSTEM_ADMIN
					.getRefDomainObject()));
		}

		// set system domain list
		this.setAdminListMap(new HashMap<String, List<DomainObjectDTO>>());
		if (!securityType.id.equals(SecurityTypeEnum.SYSTEM_ADMIN
				.getRefDomainObject().getId())) {
			String systemDomainGroup = this.getSessionSystemDomain().systemDomainGroup;
			if (systemDomainGroup != null
					&& systemDomainGroup.trim().length() != 0) {
				this
						.getAdminListMap()
						.put(
								SystemDomain.class.getSimpleName(),
								(List<DomainObjectDTO>) this
										.getDo2dtoConverter()
										.getDomainObjectDTOList(
												this.systemDomainService
														.getSortedListByGroup(
																systemDomainGroup,
																SystemDomain.SortBy.name,
																true)));
			} else {
				List<DomainObjectDTO> sdDTOs = new ArrayList<DomainObjectDTO>();
				sdDTOs.add(this.getSessionSystemDomain());
				this.getAdminListMap().put(SystemDomain.class.getSimpleName(),
						sdDTOs);
			}
		} else {
			this.getAdminListMap().put(
					SystemDomain.class.getSimpleName(),
					(List<DomainObjectDTO>) this.getDo2dtoConverter()
							.getDomainObjectDTOList(
									this.systemDomainService.getAll(
											SystemDomain.SortBy.name, true)));
		}
	}

	private RefDTO getSessionSystemAdminUserSecurityType() {
		SessionUserDTO sysAdminUserDTO = this.getSessionSystemAdminUser();
		if (sysAdminUserDTO == null)
			return null;
		return sysAdminUserDTO.securityType;
	}

	public List<Class<? extends BaseRefDomainObject>> getRefClasses() {
		List<Class<? extends BaseRefDomainObject>> refClasses = new ArrayList<Class<? extends BaseRefDomainObject>>();
		refClasses.add(SecurityType.class);
		return refClasses;
	}

	protected SessionUserDTO getSessionSystemAdminUser() {
		return (SessionUserDTO) this
				.getSessionValue(SessionKey.systemAdminUser);
	}

	protected int getOwnerId() {
		return 0; // not used
	}

}
