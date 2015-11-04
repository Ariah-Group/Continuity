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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.domain.InstructionSelect3;
import org.kuali.continuity.plan.domain.DepartmentalPractice;

@Embeddable
@SuppressWarnings("serial")
public class DepartmentalPractices implements Serializable {
	
	private InstructionSelect3 communicationCurrentUsage;
	private String communicationComment;
	private InstructionSelect3 backupPersonnelCurrentUsage;
	private String backupPersonnelComment;
	private InstructionSelect3 facultyRecallCurrentUsage;
	private String facultyRecallComment;
	private InstructionSelect3 pedagogyCurrentUsage;
	private String pedagogyComment;
	
	public DepartmentalPractices() {
		
	}

	@ManyToOne
	@JoinColumn(name="c_communication", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect3 getCommunicationCurrentUsage() {
		return this.communicationCurrentUsage;
	}

	public void setCommunicationCurrentUsage(
			InstructionSelect3 communicationCurrentUsage) {
		this.communicationCurrentUsage = communicationCurrentUsage;
	}

	@Column(name="c_communication_comment", insertable=false)
	public String getCommunicationComment() {
		return this.communicationComment;
	}

	public void setCommunicationComment(String communicationComment) {
		this.communicationComment = communicationComment;
	}

	@ManyToOne
	@JoinColumn(name="c_backup_personnel", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect3 getBackupPersonnelCurrentUsage() {
		return this.backupPersonnelCurrentUsage;
	}

	public void setBackupPersonnelCurrentUsage(
			InstructionSelect3 backupPersonnelCurrentUsage) {
		this.backupPersonnelCurrentUsage = backupPersonnelCurrentUsage;
	}

	@Column(name="c_backup_personnel_comment", insertable=false)
	public String getBackupPersonnelComment() {
		return this.backupPersonnelComment;
	}

	public void setBackupPersonnelComment(String backupPersonnelComment) {
		this.backupPersonnelComment = backupPersonnelComment;
	}

	@ManyToOne
	@JoinColumn(name="c_faculty_recall", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect3 getFacultyRecallCurrentUsage() {
		return this.facultyRecallCurrentUsage;
	}

	public void setFacultyRecallCurrentUsage(
			InstructionSelect3 facultyRecallCurrentUsage) {
		this.facultyRecallCurrentUsage = facultyRecallCurrentUsage;
	}

	@Column(name="c_faculty_recall_comment", insertable=false)
	public String getFacultyRecallComment() {
		return this.facultyRecallComment;
	}

	public void setFacultyRecallComment(String facultyRecallComment) {
		this.facultyRecallComment = facultyRecallComment;
	}

	@ManyToOne
	@JoinColumn(name="c_pedagogy", insertable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public InstructionSelect3 getPedagogyCurrentUsage() {
		return this.pedagogyCurrentUsage;
	}

	public void setPedagogyCurrentUsage(InstructionSelect3 pedagogyCurrentUsage) {
		this.pedagogyCurrentUsage = pedagogyCurrentUsage;
	}

	@Column(name="c_pedagogy_comment", insertable=false)
	public String getPedagogyComment() {
		return this.pedagogyComment;
	}

	public void setPedagogyComment(String pedagogyComment) {
		this.pedagogyComment = pedagogyComment;
	}

	@Transient
	public Map<DepartmentalPractice.Type, DepartmentalPractice> getDepartmentalPractices() {
		Map<DepartmentalPractice.Type, DepartmentalPractice> practices =
			new HashMap<DepartmentalPractice.Type, DepartmentalPractice>();
		practices.put(DepartmentalPractice.Type.COMMUNICATION,
			new DepartmentalPractice(this.communicationCurrentUsage, this.communicationComment));
		practices.put(DepartmentalPractice.Type.BACKUP_PERSONNEL,
			new DepartmentalPractice(this.backupPersonnelCurrentUsage, this.backupPersonnelComment));
		practices.put(DepartmentalPractice.Type.FACULTY_RECALL,
			new DepartmentalPractice(this.facultyRecallCurrentUsage, this.facultyRecallComment));
		practices.put(DepartmentalPractice.Type.PEDAGOGY,
			new DepartmentalPractice(this.pedagogyCurrentUsage, this.pedagogyComment));
		return practices;
	}
	
	public void setDepartmentalPractices(Map<DepartmentalPractice.Type, DepartmentalPractice> practices) {
		if (practices == null) return;
		Set<DepartmentalPractice.Type> types = practices.keySet();
		for (DepartmentalPractice.Type type : types) {
			DepartmentalPractice practice = practices.get(type);
			if (practice == null) continue;
			InstructionSelect3 currentUsage = (InstructionSelect3) practice.getCurrentUsage();
			String comment = practice.getComment();
			if (type == DepartmentalPractice.Type.COMMUNICATION) {
				this.setCommunicationCurrentUsage(currentUsage);
				this.setCommunicationComment(comment);
			} else if (type == DepartmentalPractice.Type.BACKUP_PERSONNEL) {
				this.setBackupPersonnelCurrentUsage(currentUsage);
				this.setBackupPersonnelComment(comment);
			} else if (type == DepartmentalPractice.Type.FACULTY_RECALL) {
				this.setFacultyRecallCurrentUsage(currentUsage);
				this.setFacultyRecallComment(comment);
			} else if (type == DepartmentalPractice.Type.PEDAGOGY) {
				this.setPedagogyCurrentUsage(currentUsage);
				this.setPedagogyComment(comment);
			}
		}
	}
}
