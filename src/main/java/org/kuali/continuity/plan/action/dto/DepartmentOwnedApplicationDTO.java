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
package org.kuali.continuity.plan.action.dto;

import org.kuali.continuity.action.dto.DTOValue;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.action.dto.DomainObjectValue;
import org.kuali.continuity.action.dto.RefDTO;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.plan.domain.BackupFrequency;
import org.kuali.continuity.plan.domain.DepartmentOwnedApplication;
import org.kuali.continuity.plan.domain.RecoveryProcedure;

@SuppressWarnings("serial")
public class DepartmentOwnedApplicationDTO extends DomainObjectDTO implements
		DomainObjectValue, DTOValue {
	
	public PlanDTO plan = new PlanDTO();
	public String functionalOwner;
	public String technicalOwner;
	public RefDTO type = new RefDTO();
	public RefDTO isDatabaseApplication = new RefDTO();
	public RefDTO isDataToAndFromCoreSystem = new RefDTO();
	public String campusSystems;
	public RefDTO backupMedia = new RefDTO();
	public RefDTO backupFrequency = new RefDTO();
	public RefDTO backupType = new RefDTO();
	public String departmentsImpacted;
	public String technicalExperts;
	public String responsiblePersons;
	public String onsiteLocation;
	public String offsiteLocation;
	public RefDTO offsiteStorageFrequency = new RefDTO();
	public String diskAndDocsLocations;
	public RefDTO recoveryResult = new RefDTO();
	public String recoveryResultExplanation;

	public DepartmentOwnedApplicationDTO() {
		super();
	}

	public DepartmentOwnedApplicationDTO(BaseDomainObject obj) {
		super(obj);
	}

	public DepartmentOwnedApplicationDTO(int id, String name) {
		super(id, name);
	}

	public DepartmentOwnedApplicationDTO(int id) {
		super(id);
	}
	
	public DepartmentOwnedApplicationDTO(DepartmentOwnedApplication obj) {
		this.copyFromDomainObject(obj);
	}

	public DepartmentOwnedApplication getDomainObject() {
		DepartmentOwnedApplication obj = new DepartmentOwnedApplication();
		obj.setId(this.id);
		obj.setName(this.name);
		obj.setFunctionalOwner(this.functionalOwner);
		obj.setTechnicalOwner(this.technicalOwner);
		obj.setCampusSystems(this.campusSystems);

		if (this.plan != null && this.plan.id != 0)
			obj.setPlan(plan.getDomainObject());
		if (this.type != null && this.type.id.trim().length() != 0)
			obj.setType(DepartmentOwnedApplication.Type.valueOf(this.type.id));
		if (this.isDatabaseApplication != null && this.isDatabaseApplication.id.trim().length() != 0)
			obj.setIsDatabaseApplication(DepartmentOwnedApplication.Response.valueOf(this.isDatabaseApplication.id));
		if (this.isDataToAndFromCoreSystem != null && this.isDataToAndFromCoreSystem.id.trim().length() != 0)
			obj.setIsDataToAndFromCoreSystem(DepartmentOwnedApplication.Response.valueOf(this.isDataToAndFromCoreSystem.id));
		if (this.backupMedia != null && this.backupMedia.id.trim().length() != 0)
			obj.setBackupMedia(DepartmentOwnedApplication.BackupMedia.valueOf(this.backupMedia.id));

		RecoveryProcedure rp = new RecoveryProcedure();
		rp.setDepartmentsImpacted(this.departmentsImpacted);
		rp.setTechnicalExperts(this.technicalExperts);
		rp.setResponsiblePersons(this.responsiblePersons);
		rp.setOnsiteLocation(this.onsiteLocation);
		rp.setOffsiteLocation(this.offsiteLocation);
		rp.setDiskAndDocsLocations(this.diskAndDocsLocations);
		rp.setRecoveryResultExplanation(this.recoveryResultExplanation);
		if (this.backupType != null && this.backupType.id.trim().length() != 0)
			rp.setBackupType(RecoveryProcedure.BackupType.valueOf(this.backupType.id));
		if (this.offsiteStorageFrequency != null && this.offsiteStorageFrequency.id.trim().length() != 0)
			rp.setOffsiteStorageFrequency(RecoveryProcedure.OffsiteStorageFrequency.valueOf(this.offsiteStorageFrequency.id));
		if (this.recoveryResult != null && this.recoveryResult.id.trim().length() != 0)
			rp.setRecoveryResult(RecoveryProcedure.RecoveryResult.valueOf(this.recoveryResult.id));
		if (this.backupFrequency != null && this.backupFrequency.id != null & this.backupFrequency.id.trim().length() != 0)
			rp.setBackupFrequency(new BackupFrequency(this.backupFrequency.id));
		else
			rp.setBackupFrequency(new BackupFrequency(""));
			
		obj.setRecoveryProcedure(rp);
		
		return obj;
	}

	public void copyFromDomainObject(BaseDomainObject copyObj) {
		// check for null
		if (copyObj == null) return;
		
		// set id and name
		this.id = (copyObj.getId() == null ? 0 : copyObj.getId());
		this.name = copyObj.getName();
		
		// cast
		if (!(copyObj instanceof DepartmentOwnedApplication)) return;
		DepartmentOwnedApplication obj = (DepartmentOwnedApplication) copyObj;
		
		// set other fields
		this.functionalOwner = obj.getFunctionalOwner();
		this.technicalOwner = obj.getTechnicalOwner();
		this.campusSystems = obj.getCampusSystems();
		this.plan = new PlanDTO(obj.getPlan().getId());
		if (obj.getType() != null)
			this.type = new RefDTO(obj.getType().name(), obj.getType().getValue());
		if (obj.getIsDatabaseApplication() != null)
			this.isDatabaseApplication = new RefDTO(obj.getIsDatabaseApplication().name(), obj.getIsDatabaseApplication().getValue());
		if (obj.getIsDataToAndFromCoreSystem() != null)
			this.isDataToAndFromCoreSystem = new RefDTO(obj.getIsDataToAndFromCoreSystem().name(), obj.getIsDataToAndFromCoreSystem().getValue());
		if (obj.getBackupMedia() != null)
			this.backupMedia = new RefDTO(obj.getBackupMedia().name(), obj.getBackupMedia().getValue());
		if (obj.getRecoveryProcedure() != null) {
			this.backupFrequency = new RefDTO(obj.getRecoveryProcedure().getBackupFrequency());
			this.departmentsImpacted = obj.getRecoveryProcedure().getDepartmentsImpacted();
			this.technicalExperts = obj.getRecoveryProcedure().getTechnicalExperts();
			this.responsiblePersons = obj.getRecoveryProcedure().getResponsiblePersons();
			this.onsiteLocation = obj.getRecoveryProcedure().getOnsiteLocation();
			this.offsiteLocation = obj.getRecoveryProcedure().getOffsiteLocation();
			this.diskAndDocsLocations = obj.getRecoveryProcedure().getDiskAndDocsLocations();
			this.recoveryResultExplanation = obj.getRecoveryProcedure().getRecoveryResultExplanation();
			if (obj.getRecoveryProcedure().getBackupType() != null)
				this.backupType = new RefDTO(obj.getRecoveryProcedure().getBackupType().name(), obj.getRecoveryProcedure().getBackupType().getValue());
			if (obj.getRecoveryProcedure().getOffsiteStorageFrequency() != null)
				this.offsiteStorageFrequency = new RefDTO(obj.getRecoveryProcedure().getOffsiteStorageFrequency().name(), obj.getRecoveryProcedure().getOffsiteStorageFrequency().getValue());
			if (obj.getRecoveryProcedure().getRecoveryResult() != null)
				this.recoveryResult = new RefDTO(obj.getRecoveryProcedure().getRecoveryResult().name(), obj.getRecoveryProcedure().getRecoveryResult().getValue());
		}
		
	}

}
