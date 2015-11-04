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
import java.util.Map;

import org.kuali.continuity.action.AddAction;
import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.UpdateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.util.DTO2DomainObjectConverter;
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.admin.domain.SystemDomainCentralApplicationCriticalityLevel;
import org.kuali.continuity.admin.service.SystemDomainCriticalityLevelService;
import org.kuali.continuity.domain.CentralApplicationCriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.plan.action.dto.CriticalCentralApplicationDTO;
import org.kuali.continuity.plan.action.dto.SystemDomainCriticalityLevelDTO;
import org.kuali.continuity.plan.domain.ContinuityPlan;
import org.kuali.continuity.plan.domain.CriticalCentralApplication;
import org.kuali.continuity.plan.service.CriticalCentralApplicationService;

import edu.emory.mathcs.backport.java.util.Collections;

@SuppressWarnings("serial")
public class InformationTechnologyCentralApplicationsAction extends InformationTechnologyAction {
	
	private SystemDomainCriticalityLevelService systemDomainCriticalityLevelService;

	private CriticalCentralApplicationDTO newDTO = new CriticalCentralApplicationDTO();
	private List<SystemDomainCriticalityLevelDTO> criticalityLevels = new ArrayList<SystemDomainCriticalityLevelDTO>();
	private List<CriticalCentralApplicationDTO> applicationRows = new ArrayList<CriticalCentralApplicationDTO>();
	
	
	public InformationTechnologyCentralApplicationsAction(
			SystemDomainCriticalityLevelService systemDomainCriticalityLevelService) {
		super();
		this.systemDomainCriticalityLevelService = systemDomainCriticalityLevelService;
	}

	public CriticalCentralApplicationDTO getNewDTO() {
		return this.newDTO;
	}

	public void setNewDTO(CriticalCentralApplicationDTO newDTO) {
		this.newDTO = newDTO;
	}
	
	@SuppressWarnings("unchecked")
	public List<CriticalCentralApplicationDTO> getApplicationRows() {
		applicationRows = (List<CriticalCentralApplicationDTO>)this.getDtos();
		Collections.sort(applicationRows);
		return this.applicationRows;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void prepare() throws Exception {
		super.prepare();
		
		// actions
		this.getSaveActions().put(1, this.getAddAction());
		this.getSaveActions().put(2, new CentralAppAddNewAction());
		this.getSaveActions().put(3, new CentralAppUpdateListAction());
		this.setValidateAction(new CentralAppValidateAction());
		
		// criticality levels
		Map<CriticalityLevelEnum, ? extends CriticalityLevel> levelMap = this.systemDomainCriticalityLevelService.getListByOwnerId(
				SystemDomainCentralApplicationCriticalityLevel.class, 
				this.getSessionSystemDomain().id);
		Collection<? extends CentralApplicationCriticalityLevel> levels = (Collection<CentralApplicationCriticalityLevel>) levelMap.values();
		for (CentralApplicationCriticalityLevel level : levels) {
			this.criticalityLevels.add(new SystemDomainCriticalityLevelDTO(level));
		}

	}

	public List<SystemDomainCriticalityLevelDTO> getCriticalityLevels() {
		return this.criticalityLevels;
	}

	public void setCriticalityLevels(List<SystemDomainCriticalityLevelDTO> criticalityLevels) {
		this.criticalityLevels = criticalityLevels;
	}

	// ----- action classes ----- //
	
	public class CentralAppAddNewAction implements AddAction {
		public String execute() throws Exception {
			CriticalCentralApplicationService service = (CriticalCentralApplicationService)InformationTechnologyCentralApplicationsAction.this.getService();
			CriticalCentralApplicationDTO newDTO = InformationTechnologyCentralApplicationsAction.this.newDTO;
			ContinuityPlan plan = InformationTechnologyCentralApplicationsAction.this.getSessionPlan().getDomainObject();

			// check
			if (newDTO.centralApplication.name.trim().length() == 0) {
				if (newDTO.comment == null || newDTO.comment.trim().length() == 0) return SUCCESS;
				InformationTechnologyCentralApplicationsAction.this.addFieldError("newDTO.centralApplication.id",
					"Name of Application or System is a required field!");
				return INPUT;
			}
			
			// new critical app
			CriticalCentralApplication svcCriticalApp = new CriticalCentralApplication();
			CentralApplication svcApp = new CentralApplication(null, newDTO.centralApplication.name, 0);
			svcApp.setSystemDomainId(InformationTechnologyCentralApplicationsAction.this.getSessionSystemDomain().id);
			svcCriticalApp.setCentralApplication(svcApp);
			svcCriticalApp.setComment(newDTO.comment);
			svcCriticalApp.setPlan(plan);
			
			// service create
			service.create(svcCriticalApp);
			
			// return
			return SUCCESS;
		}
	}
	
	public class CentralAppValidateAction extends BaseValidateAction {

		@SuppressWarnings("unchecked")
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			CriticalCentralApplicationDTO dto = (CriticalCentralApplicationDTO)dObjDTO;
			
			// check if no central app selected
			if (dto.centralApplication.id == 0) {
				if (dto.comment == null || dto.comment.trim().length() == 0) return null;
				this.addFieldError("dto.centralApplication.id",
					"Centrally Owned Application is a required field!");
				return false;
			}

			// get list
			List<CriticalCentralApplicationDTO> dtos = (List<CriticalCentralApplicationDTO>)
				InformationTechnologyCentralApplicationsAction.this.getDtos();
			
			// validate
			boolean retVal = true;
			if (dtos != null && !dtos.isEmpty()) {
				for (CriticalCentralApplicationDTO testDTO : dtos) {
					if (testDTO.centralApplication.id == dto.centralApplication.id) {
						retVal = false;
						this.addFieldError("dto.id",
							"You have already added this Centrally-owned Application.");
						break;
					}
				}
			}
			
			// return
			return retVal;
		}
		
	}
	
	public class CentralAppUpdateListAction implements UpdateAction {
		@SuppressWarnings("unchecked")
		public String execute() throws Exception {
			// get it action fields
			CriticalCentralApplicationService service = (CriticalCentralApplicationService)InformationTechnologyCentralApplicationsAction.this.getService();
			List<CriticalCentralApplicationDTO> dtos = (List<CriticalCentralApplicationDTO>)InformationTechnologyCentralApplicationsAction.this.getDtos();
			DTO2DomainObjectConverter dto2doConverter = InformationTechnologyCentralApplicationsAction.this.getDto2doConverter();
			
			// update list
			if (dtos != null && !dtos.isEmpty()) {
				List<CriticalCentralApplication> svcCriticalApps = (List<CriticalCentralApplication>)
					dto2doConverter.getDomainObjectList(dtos);
				service.updateList(svcCriticalApps);
			}
			
			// return
			return SUCCESS;
		}
	}
	
}