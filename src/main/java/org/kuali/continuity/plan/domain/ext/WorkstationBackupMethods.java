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
package org.kuali.continuity.plan.domain.ext;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import org.kuali.continuity.plan.domain.WorkstationBackupMethod;

@Embeddable
@SuppressWarnings("serial")
public class WorkstationBackupMethods implements Serializable {
	
	private String fileBackup;
	private String fileBackupComment;
	private String centralBackup;
	private String centralBackupComment;
	private String localAutoBackup;
	private String localAutoBackupComment;
	private String localManualBackup;
	private String localManualBackupComment;
	private String otherBackup;
	private String otherBackupComment;
	private String noBackup;
	private String noBackupComment;
	private String unknownBackup;
	private String unknownBackupComment;
	
	public WorkstationBackupMethods() {
		
	}

	@Column(name="it_ws_file", insertable=false)
	public String getFileBackup() {
		return this.fileBackup;
	}

	public void setFileBackup(String fileBackup) {
		this.fileBackup = fileBackup;
	}

	@Column(name="it_ws_file_comment", insertable=false)
	public String getFileBackupComment() {
		return this.fileBackupComment;
	}

	public void setFileBackupComment(String fileBackupComment) {
		this.fileBackupComment = fileBackupComment;
	}

	@Column(name="it_ws_ucb", insertable=false)
	public String getCentralBackup() {
		return this.centralBackup;
	}

	public void setCentralBackup(String centralBackup) {
		this.centralBackup = centralBackup;
	}

	@Column(name="it_ws_ucb_comment", insertable=false)
	public String getCentralBackupComment() {
		return this.centralBackupComment;
	}

	public void setCentralBackupComment(String centralBackupComment) {
		this.centralBackupComment = centralBackupComment;
	}

	@Column(name="it_ws_local_auto", insertable=false)
	public String getLocalAutoBackup() {
		return this.localAutoBackup;
	}

	public void setLocalAutoBackup(String localAutoBackup) {
		this.localAutoBackup = localAutoBackup;
	}

	@Column(name="it_ws_local_auto_comment", insertable=false)
	public String getLocalAutoBackupComment() {
		return this.localAutoBackupComment;
	}

	public void setLocalAutoBackupComment(String localAutoBackupComment) {
		this.localAutoBackupComment = localAutoBackupComment;
	}

	@Column(name="it_ws_local_manu", insertable=false)
	public String getLocalManualBackup() {
		return this.localManualBackup;
	}

	public void setLocalManualBackup(String localManualBackup) {
		this.localManualBackup = localManualBackup;
	}

	@Column(name="it_ws_local_manu_comment", insertable=false)
	public String getLocalManualBackupComment() {
		return this.localManualBackupComment;
	}

	public void setLocalManualBackupComment(String localManualBackupComment) {
		this.localManualBackupComment = localManualBackupComment;
	}

	@Column(name="it_ws_other", insertable=false)
	public String getOtherBackup() {
		return this.otherBackup;
	}

	public void setOtherBackup(String otherBackup) {
		this.otherBackup = otherBackup;
	}

	@Column(name="it_ws_other_comment", insertable=false)
	public String getOtherBackupComment() {
		return this.otherBackupComment;
	}

	public void setOtherBackupComment(String otherBackupComment) {
		this.otherBackupComment = otherBackupComment;
	}

	@Column(name="it_ws_no_backup", insertable=false)
	public String getNoBackup() {
		return this.noBackup;
	}

	public void setNoBackup(String noBackup) {
		this.noBackup = noBackup;
	}

	@Column(name="it_ws_no_backup_comment", insertable=false)
	public String getNoBackupComment() {
		return this.noBackupComment;
	}

	public void setNoBackupComment(String noBackupComment) {
		this.noBackupComment = noBackupComment;
	}

	@Column(name="it_ws_not_know", insertable=false)
	public String getUnknownBackup() {
		return this.unknownBackup;
	}

	public void setUnknownBackup(String unknownBackup) {
		this.unknownBackup = unknownBackup;
	}

	@Column(name="it_ws_not_know_comment", insertable=false)
	public String getUnknownBackupComment() {
		return this.unknownBackupComment;
	}

	public void setUnknownBackupComment(String unknownBackupComment) {
		this.unknownBackupComment = unknownBackupComment;
	}
	
	@Transient
	public Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> getBackupMethods() {
		Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> backups = 
			new HashMap<WorkstationBackupMethod.Type, WorkstationBackupMethod>();
		backups.put(WorkstationBackupMethod.Type.FILE, 
			new WorkstationBackupMethod(this.getFileBackup(), this.getFileBackupComment()));
		backups.put(WorkstationBackupMethod.Type.CENTRAL, 
				new WorkstationBackupMethod(this.getCentralBackup(), this.getCentralBackupComment()));
		backups.put(WorkstationBackupMethod.Type.LOCAL_AUTO, 
				new WorkstationBackupMethod(this.getLocalAutoBackup(), this.getLocalAutoBackupComment()));
		backups.put(WorkstationBackupMethod.Type.LOCAL_MANUAL, 
				new WorkstationBackupMethod(this.getLocalManualBackup(), this.getLocalManualBackupComment()));
		backups.put(WorkstationBackupMethod.Type.OTHER, 
				new WorkstationBackupMethod(this.getOtherBackup(), this.getOtherBackupComment()));
		backups.put(WorkstationBackupMethod.Type.NONE, 
				new WorkstationBackupMethod(this.getNoBackup(), this.getNoBackupComment()));
		backups.put(WorkstationBackupMethod.Type.UNKNOWN, 
				new WorkstationBackupMethod(this.getUnknownBackup(), this.getUnknownBackupComment()));
		return backups;
	}

	public void setBackupMethods(Map<WorkstationBackupMethod.Type, WorkstationBackupMethod> backups) {
		this.init();
		if (backups == null) return;
		Set<WorkstationBackupMethod.Type> keys = backups.keySet();
		for (WorkstationBackupMethod.Type type : keys) {
			WorkstationBackupMethod backup = backups.get(type);
			if (backup == null) continue;
			String percentUsers = backup.getPercentUsers();
			String comment = backup.getComment();
			if (type == WorkstationBackupMethod.Type.FILE) {
				this.setFileBackup(percentUsers);
				this.setFileBackupComment(comment);
			} else if (type == WorkstationBackupMethod.Type.CENTRAL) {
				this.setCentralBackup(percentUsers);
				this.setCentralBackupComment(comment);
			} else if (type == WorkstationBackupMethod.Type.LOCAL_AUTO) {
				this.setLocalAutoBackup(percentUsers);
				this.setLocalAutoBackupComment(comment);
			} else if (type == WorkstationBackupMethod.Type.LOCAL_MANUAL) {
				this.setLocalManualBackup(percentUsers);
				this.setLocalManualBackupComment(comment);
			} else if (type == WorkstationBackupMethod.Type.OTHER) {
				this.setOtherBackup(percentUsers);
				this.setOtherBackupComment(comment);
			} else if (type == WorkstationBackupMethod.Type.NONE) {
				this.setNoBackup(percentUsers);
				this.setNoBackupComment(comment);
			} else if (type == WorkstationBackupMethod.Type.UNKNOWN) {
				this.setUnknownBackup(percentUsers);
				this.setUnknownBackupComment(comment);
			}
		}
	}
	
	private void init() {
		this.setFileBackup("");
		this.setFileBackupComment("");
		this.setCentralBackup("");
		this.setCentralBackupComment("");
		this.setLocalAutoBackup("");
		this.setLocalAutoBackupComment("");
		this.setLocalManualBackup("");
		this.setLocalManualBackupComment("");
		this.setOtherBackup("");
		this.setOtherBackupComment("");
		this.setNoBackup("");
		this.setNoBackupComment("");
		this.setUnknownBackup("");
		this.setUnknownBackupComment("");
	}
}
