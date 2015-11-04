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

import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.DepartmentOwnedApplicationDTO;
import org.kuali.continuity.plan.domain.DepartmentOwnedApplication;
import org.kuali.continuity.plan.domain.RecoveryProcedure;
import org.kuali.continuity.plan.service.CriticalFunctionService;

@SuppressWarnings("serial")
public class InformationTechnologyDepartmentApplicationsAction extends 
	InformationTechnologyAction {
	
	// services
	private CriticalFunctionService criticalFunctionService;
	
	// lists
	private List<DomainObjectDTO> criticalFunctions = new ArrayList<DomainObjectDTO>();
	private DepartmentOwnedApplication.Type[] types = DepartmentOwnedApplication.Type.values();
	private DepartmentOwnedApplication.BackupMedia[] backupMedia = DepartmentOwnedApplication.BackupMedia.values();
	private DepartmentOwnedApplication.Response[] responses = DepartmentOwnedApplication.Response.values();
	private RecoveryProcedure.BackupType[] backupTypes = RecoveryProcedure.BackupType.values();
	private RecoveryProcedure.OffsiteStorageFrequency[] offsiteStorageFrequencies = RecoveryProcedure.OffsiteStorageFrequency.values();
	private RecoveryProcedure.RecoveryResult[] recoveryResults = RecoveryProcedure.RecoveryResult.values();
	
	public InformationTechnologyDepartmentApplicationsAction(CriticalFunctionService criticalFunctionService) {
		super();
		this.criticalFunctionService = criticalFunctionService;
	}

	public List<DomainObjectDTO> getCriticalFunctions() {
		return this.criticalFunctions;
	}
	
	public void setCriticalFunctions(List<DomainObjectDTO> criticalFunctions) {
		this.criticalFunctions = criticalFunctions;
	}

	public DepartmentOwnedApplication.Type[] getTypes() {
		return this.types;
	}

	public void setTypes(DepartmentOwnedApplication.Type[] types) {
		this.types = types;
	}

	public DepartmentOwnedApplication.BackupMedia[] getBackupMedia() {
		return this.backupMedia;
	}

	public void setBackupMedia(DepartmentOwnedApplication.BackupMedia[] backupMedia) {
		this.backupMedia = backupMedia;
	}

	public DepartmentOwnedApplication.Response[] getResponses() {
		return this.responses;
	}

	public void setResponses(DepartmentOwnedApplication.Response[] responses) {
		this.responses = responses;
	}

	public RecoveryProcedure.BackupType[] getBackupTypes() {
		return this.backupTypes;
	}

	public void setBackupTypes(RecoveryProcedure.BackupType[] backupTypes) {
		this.backupTypes = backupTypes;
	}

	public RecoveryProcedure.OffsiteStorageFrequency[] getOffsiteStorageFrequencies() {
		return this.offsiteStorageFrequencies;
	}

	public void setOffsiteStorageFrequencies(
			RecoveryProcedure.OffsiteStorageFrequency[] offsiteStorageFrequencies) {
		this.offsiteStorageFrequencies = offsiteStorageFrequencies;
	}

	public RecoveryProcedure.RecoveryResult[] getRecoveryResults() {
		return this.recoveryResults;
	}

	public void setRecoveryResults(
			RecoveryProcedure.RecoveryResult[] recoveryResults) {
		this.recoveryResults = recoveryResults;
	}
	
	@Override
	public String add() throws Exception {
		this.setValidateAction(new ValidateAction());
		return super.add();
	}

	@Override
	public String update() throws Exception {
		this.setValidateAction(null);
		return super.update();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void prepare() throws Exception {
		super.prepare();
		this.criticalFunctions = (List<DomainObjectDTO>) this.getDo2dtoConverter().getDomainObjectDTOList(
			this.criticalFunctionService.getCriticalFunctionList(this.getSessionPlan().getId()));
	}
	
	public class ValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			DepartmentOwnedApplicationDTO dto = (DepartmentOwnedApplicationDTO) dObjDTO;
	        if ((dto.name == null || dto.name.trim().length() == 0) &&
                (dto.functionalOwner == null || dto.functionalOwner.trim().length() == 0) &&
        		(dto.technicalOwner == null || dto.technicalOwner.trim().length() == 0))
	        		return null;
	        if (dto.name == null || dto.name.trim().length() == 0) {
				this.addFieldError("dto.name", "Name is a required field!");
				return false;
	        }
	        return true;
		}
	}
	
}
