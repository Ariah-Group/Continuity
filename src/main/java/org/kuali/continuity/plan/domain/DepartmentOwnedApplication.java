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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.TypeDef;
import org.kuali.continuity.domain.BaseDomainObject;
import org.kuali.continuity.domain.ext.StringValuedEnum;
import org.kuali.continuity.domain.ext.StringValuedEnumType;

@Entity
@Table(name="it_applications")
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@NamedQuery(name="DepartmentOwnedApplication.list", 
	query="select dObj from DepartmentOwnedApplication dObj where plan.id = :ownerId and disabled != 'Y'")
@SuppressWarnings("serial")
public class DepartmentOwnedApplication extends BaseDomainObject {
	
	private ContinuityPlan plan;
	private String functionalOwner;
	private String technicalOwner;
	private Type type;
	private Response isDatabaseApplication;
	private Response isDataToAndFromCoreSystem;
	private String campusSystems;
	private BackupMedia backupMedia;
	private RecoveryProcedure recoveryProcedure;
	
	public DepartmentOwnedApplication() {
	}
	
	@Id
	@Column(name="it_application_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return super.getId();
	}
	
	public String getName() {
		return super.getName();
	}

	public void setName(String name) {
		super.setName(name);
	}
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="pid", nullable=false)
	public ContinuityPlan getPlan() {
		return this.plan;
	}

	public void setPlan(ContinuityPlan plan) {
		this.plan = plan;
	}

	@Column(name="functional_owner")
	public String getFunctionalOwner() {
		return this.functionalOwner;
	}

	public void setFunctionalOwner(String functionalOwner) {
		this.functionalOwner = functionalOwner;
	}

	@Column(name="technical_owner")
	public String getTechnicalOwner() {
		return this.technicalOwner;
	}

	public void setTechnicalOwner(String technicalOwner) {
		this.technicalOwner = technicalOwner;
	}
	
	@Column(name="application_type", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.DepartmentOwnedApplication$Type"
			)}
	)
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Column(name="transaction_processing", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.DepartmentOwnedApplication$Response"
			)}
	)
	public Response getIsDatabaseApplication() {
		return this.isDatabaseApplication;
	}

	public void setIsDatabaseApplication(Response isDatabaseApplication) {
		this.isDatabaseApplication = isDatabaseApplication;
	}

	@Column(name="data_from_core", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.DepartmentOwnedApplication$Response"
			)}
	)
	
	public Response getIsDataToAndFromCoreSystem() {
		return this.isDataToAndFromCoreSystem;
	}

	public void setIsDataToAndFromCoreSystem(Response isDataToAndFromCoreSystem) {
		this.isDataToAndFromCoreSystem = isDataToAndFromCoreSystem;
	}

	@Column(name="campus_systems", insertable=false)
	public String getCampusSystems() {
		return this.campusSystems;
	}

	public void setCampusSystems(String campusSystems) {
		this.campusSystems = campusSystems;
	}

	@Column(name="backup_media", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.DepartmentOwnedApplication$BackupMedia"
			)}
	)
	public BackupMedia getBackupMedia() {
		return this.backupMedia;
	}

	public void setBackupMedia(BackupMedia backupMedia) {
		this.backupMedia = backupMedia;
	}

	@Embedded
	public RecoveryProcedure getRecoveryProcedure() {
		return this.recoveryProcedure;
	}

	public void setRecoveryProcedure(RecoveryProcedure recoveryProcedure) {
		this.recoveryProcedure = recoveryProcedure;
	}

	public enum Type implements StringValuedEnum {
		
		WEB("Web Application"), 
		MAINFRAME("Mainframe Application"), 
		CLIENTSERVER("Client-Server Application"), 
		DESKTOP("Desktop"), 
		OTHER("Other (please explain)");

		private final String refValue;
			
		Type(final String refValue) {
			this.refValue = refValue;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
	}
	
	public enum BackupMedia implements StringValuedEnum {
		
		TAPE("Tape"),
		DISK("Disk"),
		OTHER("Other");
		
		private final String refValue;
		
		BackupMedia(final String refValue) {
			this.refValue = refValue;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
	}
	
	public enum Response implements StringValuedEnum {
		
		YES("Yes"), 
		NO("No"), 
		NOT_SURE("Not Sure");

		private final String refValue;
		
		Response(final String refValue) {
			this.refValue = refValue;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
	}
	
}
