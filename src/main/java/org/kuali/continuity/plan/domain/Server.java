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
@Table(name="it_servers")
@TypeDef(
	name="stringValueEnum", 
	typeClass=StringValuedEnumType.class)
@NamedQuery(name="Server.list",
	query="select dObj from Server dObj where plan.id = :ownerId and disabled != 'Y'")
@SuppressWarnings("serial")
public class Server extends BaseDomainObject {
	
	private ContinuityPlan plan;
	private Type type;
	private String explanation;
	private String applicationsImpacted;
	private String serverSoftware;
	private BackupMedia backupMedia;
	private RecoveryProcedure recoveryProcedure;
	
	public Server() {
	}

	@Id
	@Column(name="it_server_id")
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

	@Column(name="type_server")
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.Server$Type"
			)}
	)
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getExplanation() {
		return this.explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	@Column(name="apps_impacted", insertable=false)
	public String getApplicationsImpacted() {
		return this.applicationsImpacted;
	}

	public void setApplicationsImpacted(String applicationsImpacted) {
		this.applicationsImpacted = applicationsImpacted;
	}

	@Column(name="server_software", insertable=false)
	public String getServerSoftware() {
		return this.serverSoftware;
	}

	public void setServerSoftware(String serverSoftware) {
		this.serverSoftware = serverSoftware;
	}

	@Column(name="backup_media", insertable=false)
	@org.hibernate.annotations.Type(
		type="stringValueEnum",
		parameters={
			@Parameter(
				name="enum",
				value="org.kuali.continuity.plan.domain.Server$BackupMedia"
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
		
		FILE("File server"), 
		APPLICATION("Application server"), 
		DATABASE("Database server"), 
		WEB("Web server"), 
		BACKUP("Backup server"), 
		MAINFRAME("Mainframe"), 
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
		
		LOCAL_TAPE("Local Tape"),
		LOCAL_SERVER("Local Backup Server"),
		REMOTE_TAPE("Remote Tape"),
		REMOTE_SERVER("Remote Backup Server"),
		OTHER("Other (describe)");
		
		private final String refValue;
		
		BackupMedia(final String refValue) {
			this.refValue = refValue;
		}
		
		public String getValue() {
			return this.refValue;
		}
		
	}
	
}
