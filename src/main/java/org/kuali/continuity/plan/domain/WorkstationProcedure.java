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
package org.kuali.continuity.plan.domain;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

import org.kuali.continuity.plan.domain.ext.WorkstationBackupMethods;
import org.kuali.continuity.plan.domain.ext.WorkstationTechSupports;

@Embeddable
@SuppressWarnings("serial")
public class WorkstationProcedure implements Serializable {
	
	// for mapping only
	private WorkstationBackupMethods backupMethodsExt;
	private WorkstationTechSupports techSupportsExt;
	
	public WorkstationProcedure() {

	}
	
	@Transient
	public Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> getBackupMethods() {
		if (this.getBackupMethodsExt() == null) return null;
		return this.getBackupMethodsExt().getBackupMethods();
	}

	public void setBackupMethods(Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> backupMethods) {
		if (this.getBackupMethodsExt() == null) 
			this.setBackupMethodsExt(new WorkstationBackupMethods());
		this.getBackupMethodsExt().setBackupMethods(backupMethods);
	}

	@Transient
	public Map<WorkstationTechSupport.Type, WorkstationTechSupport> getTechSupports() {
		if (this.getTechSupportsExt() == null) return null;
		return this.getTechSupportsExt().getTechSupports();
	}

	public void setTechSupports(Map<WorkstationTechSupport.Type, WorkstationTechSupport> techSupports) {
		if (this.getTechSupportsExt() == null) 
			this.setTechSupportsExt(new WorkstationTechSupports());
		this.getTechSupportsExt().setTechSupports(techSupports);
	}
	
	@Embedded
	private WorkstationBackupMethods getBackupMethodsExt() {
		return this.backupMethodsExt;
	}

	private void setBackupMethodsExt(WorkstationBackupMethods backupMethodsExt) {
		this.backupMethodsExt = backupMethodsExt;
	}

	@Embedded
	private WorkstationTechSupports getTechSupportsExt() {
		return this.techSupportsExt;
	}

	private void setTechSupportsExt(WorkstationTechSupports techSupportsExt) {
		this.techSupportsExt = techSupportsExt;
	}

}
