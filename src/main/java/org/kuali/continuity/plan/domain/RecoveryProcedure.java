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

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Parameter;
import org.kuali.continuity.domain.ext.StringValuedEnum;

// TODO: refactor
@Embeddable
public class RecoveryProcedure {

	private BackupFrequency backupFrequency;
	private BackupType backupType;
	private String departmentsImpacted;
	private String technicalExperts;
	private String responsiblePersons;
	private String onsiteLocation;
	private String offsiteLocation;
	private OffsiteStorageFrequency offsiteStorageFrequency;
	private String diskAndDocsLocations;
	private RecoveryResult recoveryResult;
	private String recoveryResultExplanation;
	
	@ManyToOne
	@JoinColumn(name="backup_frequency", insertable=false)
	@Fetch(FetchMode.SELECT)
	public BackupFrequency getBackupFrequency() {
		return this.backupFrequency;
	}

	public void setBackupFrequency(BackupFrequency backupFrequency) {
		this.backupFrequency = backupFrequency;
	}

	@Column(name="auto_manual", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.RecoveryProcedure$BackupType"
			)}
	)
	public BackupType getBackupType() {
		return this.backupType;
	}

	public void setBackupType(BackupType backupType) {
		this.backupType = backupType;
	}

	@Column(name="depts_impacted", insertable=false)
	public String getDepartmentsImpacted() {
		return this.departmentsImpacted;
	}

	public void setDepartmentsImpacted(String departmentsImpacted) {
		this.departmentsImpacted = departmentsImpacted;
	}

	@Column(name="tech", insertable=false)
	public String getTechnicalExperts() {
		return this.technicalExperts;
	}

	public void setTechnicalExperts(String technicalExperts) {
		this.technicalExperts = technicalExperts;
	}

	@Column(name="responsible_person", insertable=false)
	public String getResponsiblePersons() {
		return this.responsiblePersons;
	}

	public void setResponsiblePersons(String responsiblePersons) {
		this.responsiblePersons = responsiblePersons;
	}

	@Column(name="location_onsite", insertable=false)
	public String getOnsiteLocation() {
		return this.onsiteLocation;
	}

	public void setOnsiteLocation(String onsiteLocation) {
		this.onsiteLocation = onsiteLocation;
	}
	
	@Column(name="location_offsite", insertable=false)
	public String getOffsiteLocation() {
		return this.offsiteLocation;
	}

	public void setOffsiteLocation(String offsiteLocation) {
		this.offsiteLocation = offsiteLocation;
	}

	@Column(name="frequency_offsite", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.RecoveryProcedure$OffsiteStorageFrequency"
			)}
	)
	public OffsiteStorageFrequency getOffsiteStorageFrequency() {
		return this.offsiteStorageFrequency;
	}

	public void setOffsiteStorageFrequency(
			OffsiteStorageFrequency offsiteStorageFrequency) {
		this.offsiteStorageFrequency = offsiteStorageFrequency;
	}

	@Column(name="location_disks_docs", insertable=false)
	public String getDiskAndDocsLocations() {
		return this.diskAndDocsLocations;
	}

	public void setDiskAndDocsLocations(String diskAndDocsLocations) {
		this.diskAndDocsLocations = diskAndDocsLocations;
	}

	@Column(name="successful_recovery", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.RecoveryProcedure$RecoveryResult"
			)}
	)
	public RecoveryResult getRecoveryResult() {
		return this.recoveryResult;
	}

	public void setRecoveryResult(RecoveryResult recoveryResult) {
		this.recoveryResult = recoveryResult;
	}

	@Column(name="successful_recovery_explain", insertable=false)
	public String getRecoveryResultExplanation() {
		return this.recoveryResultExplanation;
	}

	public void setRecoveryResultExplanation(String recoveryResultExplanation) {
		this.recoveryResultExplanation = recoveryResultExplanation;
	}

	public enum BackupType implements StringValuedEnum {
		
		AUTO("Automatic"),
		MANUAL("Manual"),
		OTHER("Other");
		
		private final String refValue;
		
		BackupType(final String refValue) {
			this.refValue = refValue;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
	}
	
	public enum OffsiteStorageFrequency implements StringValuedEnum {
		
		DAILY("Daily"),
		WEEKLY("Weekly"), 
		EVERY_2WEEKS("Every 2 Weeks"),
		MONTHLY("Monthly"),
		VARIES("Varies (please explain)"),
		OTHER("Other (please explain)"),
		NA("No Offsite Storage");
		
		private final String refValue;
		
		OffsiteStorageFrequency(final String refValue) {
			this.refValue = refValue;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
	}
	
	public enum RecoveryResult implements StringValuedEnum {
		
		YES("Yes"), 
		NO("No"), 
		PARTIAL("Partial (please explain)"),
		NOTSURE("Not sure"),
		NA("N/A");
		
		private final String refValue;
		
		RecoveryResult(final String refValue) {
			this.refValue = refValue;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
	}
		
}
