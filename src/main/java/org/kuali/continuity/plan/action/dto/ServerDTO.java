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
import org.kuali.continuity.plan.domain.RecoveryProcedure;
import org.kuali.continuity.plan.domain.Server;

@SuppressWarnings("serial")
public class ServerDTO extends DomainObjectDTO implements
		DomainObjectValue, DTOValue {

	public PlanDTO plan = new PlanDTO();
	public RefDTO type = new RefDTO();
	public String explanation;
	public String applicationsImpacted;
	public String serverSoftware;
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

	public ServerDTO() {
		super();
	}

	public ServerDTO(BaseDomainObject obj) {
		super(obj);
	}

	public ServerDTO(int id, String name) {
		super(id, name);
	}

	public ServerDTO(int id) {
		super(id);
	}
	
	public ServerDTO(Server obj) {
		this.copyFromDomainObject(obj);
	}

	public Server getDomainObject() {
		Server obj = new Server();
		obj.setId(this.id == 0 ? null : this.id);
		obj.setName(this.name);
		obj.setExplanation(this.explanation);
		obj.setApplicationsImpacted(this.applicationsImpacted);
		obj.setServerSoftware(this.serverSoftware);

		if (this.plan != null && this.plan.id != 0)
			obj.setPlan(plan.getDomainObject());
		if (this.type != null && this.type.id.trim().length() != 0)
			obj.setType(Server.Type.valueOf(this.type.id));
		if (this.backupMedia != null && this.backupMedia.id.trim().length() != 0)
			obj.setBackupMedia(Server.BackupMedia.valueOf(this.backupMedia.id));

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
		if (!(copyObj instanceof Server)) return;
		Server obj = (Server) copyObj;
		
		// set other fields
		this.plan = new PlanDTO(obj.getPlan().getId());
		this.explanation = obj.getExplanation();
		this.applicationsImpacted = obj.getApplicationsImpacted();
		this.serverSoftware = obj.getServerSoftware();
		if (obj.getType() != null)
			this.type = new RefDTO(obj.getType().name(), obj.getType().getValue());
		if (obj.getBackupMedia() != null)
			this.backupMedia = new RefDTO(obj.getBackupMedia().name(), obj.getType().getValue());
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
