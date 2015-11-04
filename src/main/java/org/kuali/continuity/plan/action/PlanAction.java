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

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.kuali.continuity.action.AddAction;
import org.kuali.continuity.action.BaseFormAction;
import org.kuali.continuity.action.ReadRowAction;
import org.kuali.continuity.action.UpdateAction;
import org.kuali.continuity.action.ValidateAction;
import org.kuali.continuity.action.dto.SessionKey;
import org.kuali.continuity.action.dto.UserDTO;
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.User;
import org.kuali.continuity.domain.PlanAccessTypeEnum;
import org.kuali.continuity.domain.PlanStatusEnum;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.plan.action.dto.PageAccessControlDTO;
import org.kuali.continuity.plan.action.dto.PlanDTO;
import org.kuali.continuity.plan.action.dto.SessionPlanDTO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.service.ContinuityPlanService;

@SuppressWarnings("serial")
public class PlanAction extends BaseFormAction implements ServletRequestAware {

	// service
	private ContinuityPlanService planService;

	// flags
	private boolean isNewPlan = true;
	private boolean isContactTable = false;
	
	// request
	private HttpServletRequest request;
	
	public PlanAction(ContinuityPlanService planService) {
		this.planService = planService;
	}

	public boolean isNewPlan() {
		return this.isNewPlan;
	}

	public void setNewPlan(boolean isNewPlan) {
		this.isNewPlan = isNewPlan;
	}

	public boolean isContactTable() {
		return this.isContactTable;
	}

	public void setContactTable(boolean isContactTable) {
		this.isContactTable = isContactTable;
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public String execute() throws Exception {
		this.removeFromSession(SessionKey.plan);
		return SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.setAddAction(new PlanSaveAction());
		this.setUpdateAction(new PlanSaveAction());
		this.setReadRowAction(new PlanReadRowAction());
	}
	
	public class PlanReadRowAction implements ReadRowAction {
		@Override
		public String execute() throws Exception {
			
			// isOld
			PlanAction.this.setNewPlan(false);
			
			// get plan service
			ContinuityPlanService planService = PlanAction.this.planService;
			
			// get id
			int planId = PlanAction.this.getSessionPlan() != null ? 
				PlanAction.this.getSessionPlan().id : PlanAction.this.getRowId();
				
			// get plan domain object
			ContinuityPlan plan = planService.getContinuityPlan(planId);
			
			// convert dto to domain object and set dto
			PlanDTO planDTO = (PlanDTO) 
				PlanAction.this.getDo2dtoConverter().getDomainObjectDTO(plan);
			PlanAction.this.setDto(planDTO);
			
			// return
			return SUCCESS;
		}
	}
	
	public class PlanSaveAction implements AddAction, UpdateAction {
		@Override
		public String execute() throws Exception {
			// validate
			ValidateAction vAction = new PlanValidateAction();
			if (vAction.validate() != null && vAction.validate() == false) return INPUT;
			
			// service, new plan, etc.
			ContinuityPlanService planService = PlanAction.this.planService;
			boolean isNewPlan = PlanAction.this.isNewPlan();
			PlanDTO planDTO = (PlanDTO)PlanAction.this.getDto();
			
			// init plan
			ContinuityPlan savePlan = new ContinuityPlan();
			int systemDomainId = PlanAction.this.getSessionSystemDomain().id;
			if (!isNewPlan) {
				savePlan = planService.getContinuityPlan(PlanAction.this.getSessionPlan().id);
				systemDomainId = savePlan.getSystemDomain().getId();
			}
			savePlan.setName(planDTO.name);
			savePlan.setSystemDomain(new SystemDomain(systemDomainId));
			savePlan.setMajorDivision(new MajorDivision(planDTO.majorDivision.id));
			
			//Only new plan got instantiate Acronym		
			savePlan.setAcronym(new Acronym(planDTO.acronym.id));						
			Acronym acronym = (Acronym)PlanAction.this.getAdminListHelper().getAdminDomainObjectById(Acronym.class, planDTO.acronym.id);				
			//savePlan.setAcronym(acronym);
			//Update the AcronymPlusName
			savePlan.setAcronymPlusName((savePlan.getAcronym() == null ? "" : 
				   (acronym == null ? "" : (acronym.getName() == null ? "" : 
						acronym.getName() + " - "))) + savePlan.getName());	
			
			// department head
			User headUser = planDTO.departmentHead.getDomainObject();
			headUser.setSystemDomainId(systemDomainId);
			savePlan.setDepartmentHead(headUser);
			
			// user
			UserDTO userDTO = PlanAction.this.getSessionUser();
			User saveUser = userDTO.getDomainObject();

			if (isNewPlan()) {
				// set user access and status
				savePlan.addUserAccess(saveUser, PlanAccessTypeEnum.FULL.getRefDomainObject());
				savePlan.setStatus(PlanStatusEnum.IN_PROGRESS.getRefDomainObject());
				// set current user as gatekeeper
				savePlan.addContact(saveUser, false);
			}

			SystemLogInfo systemLogInfo = new SystemLogInfo();
			systemLogInfo.setUserId(userDTO.id);
			systemLogInfo.setSystemDomainId(userDTO.systemDomain.id);
			systemLogInfo.setHostIP(PlanAction.this.request.getRemoteAddr());
			systemLogInfo.setModule(PlanAction.this.request.getRequestURI());
	 		
			// save
	 		if (isNewPlan()) {
	 			planService.createContinuityPlan(savePlan, systemLogInfo);
	 			PlanAction.this.putInSession(SessionKey.plan, new SessionPlanDTO(savePlan.getId()));
	 		} else {
	 			planService.updateContinuityPlan(savePlan, systemLogInfo);
	 			//refresh acronynPlanName session value
		 		setSessionPlanAcronumPlanName(savePlan.getAcronymPlusName());
	 		}
	 			 		
			// return
			return SUCCESS;
		}
	}
	
	public class PlanValidateAction implements ValidateAction {

		@Override
		public List<String> getActionErrors() {
			return null;
		}

		@Override
		public Map<String, List<String>> getFieldErrors() {
			return null;
		}

		@Override
		public Boolean validate() throws Exception {
			// if not new
			int planId = 0;
			if (!PlanAction.this.isNewPlan()) {
				planId = PlanAction.this.getSessionPlan().id;
				String oldPlanName = PlanAction.this.getSessionPlan().name;
				int oldAcronymId = 0;
				if (PlanAction.this.getSessionPlan().acronym != null)
					oldAcronymId = PlanAction.this.getSessionPlan().acronym.id;
				if (oldPlanName.equals(PlanAction.this.getDto().name) && 
					oldAcronymId == ((PlanDTO)PlanAction.this.getDto()).acronym.id)
					return null;
			}

			// 2nd level check
			Acronym acronym = new Acronym();
			acronym.setId(((PlanDTO)PlanAction.this.getDto()).acronym.id);
			if (PlanAction.this.planService.getContinuityPlanListSize(
					PlanAction.this.getSessionSystemDomain().id, 
					acronym, 
					PlanAction.this.getDto().name, 
					planId) != 0) {
				PlanAction.this.addActionError("Plan for that unit already exists");
				return false;
			}

			// success
			return true;
		}
		
	}

	public SessionPlanDTO getSessionPlan() {
		return (SessionPlanDTO) this.getSessionValue(SessionKey.plan);
	}
	
	public void setSessionPlanAcronumPlanName(String acronumPlanName){
		((SessionPlanDTO) this.getSessionValue(SessionKey.plan)).acronymPlusName = acronumPlanName;
	}
	
	public PageAccessControlDTO getSessionPageAccessControl() {
		return (PageAccessControlDTO) this.getSessionValue(SessionKey.planAccessControl);
	}

	// default
	protected int getOwnerId() {
		return this.getSessionPlan().id;
	}
	
}
