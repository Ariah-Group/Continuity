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

import org.kuali.continuity.action.BaseValidateAction;
import org.kuali.continuity.action.dto.DomainObjectDTO;
import org.kuali.continuity.plan.action.dto.ServerDTO;
import org.kuali.continuity.plan.domain.RecoveryProcedure;
import org.kuali.continuity.plan.domain.Server;

@SuppressWarnings("serial")
public class InformationTechnologyServersAction extends InformationTechnologyAction {
	
	// lists
	private Server.Type[] types = Server.Type.values();
	private Server.BackupMedia[] backupMedia = Server.BackupMedia.values();
	private RecoveryProcedure.BackupType[] backupTypes = RecoveryProcedure.BackupType.values();
	private RecoveryProcedure.OffsiteStorageFrequency[] offsiteStorageFrequencies = RecoveryProcedure.OffsiteStorageFrequency.values();
	private RecoveryProcedure.RecoveryResult[] recoveryResults = RecoveryProcedure.RecoveryResult.values();
	
	public InformationTechnologyServersAction() {
		super();
		this.setValidateAction(new ValidateAction());
	}

	public Server.Type[] getTypes() {
		return this.types;
	}

	public void setTypes(Server.Type[] types) {
		this.types = types;
	}

	public Server.BackupMedia[] getBackupMedia() {
		return this.backupMedia;
	}

	public void setBackupMedia(Server.BackupMedia[] backupMedia) {
		this.backupMedia = backupMedia;
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

	public class ValidateAction extends BaseValidateAction {
		@Override
		public Boolean validate(DomainObjectDTO dObjDTO) throws Exception {
			ServerDTO dto = (ServerDTO) dObjDTO;
	        if ((dto.name == null || dto.name.trim().length() == 0) &&
                (dto.explanation == null || dto.explanation.trim().length() == 0) &&
        		(dto.type == null || dto.type.id == null || dto.type.id.trim().length() == 0 || dto.type.id.equals("0")))
	        		return null;
	        if (dto.name == null || dto.name.trim().length() == 0) {
				this.addFieldError("dto.name", "Name is a required field!");
				return false;
	        }
	        return true;
		}
	}
	
}
