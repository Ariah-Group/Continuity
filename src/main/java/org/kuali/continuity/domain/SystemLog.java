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
package org.kuali.continuity.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;

@Entity
@Table(name="SystemLog")
@SuppressWarnings("serial")
public class SystemLog extends BaseAdminDomainObject implements Serializable {
	
	private Integer id;
	private SystemLogObjectType objectType;
	private SystemLogEventType eventType;
	private Integer objectId;
	private SystemLogInfo systemLogInfo;
	private Date eventDate;
	private String comment;
	
	public SystemLog() {
		
	}
	
	@Id
	@Column(name="SystemLogID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="ObjectType", nullable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public SystemLogObjectType getObjectType() {
		return this.objectType;
	}

	public void setObjectType(SystemLogObjectType objectType) {
		this.objectType = objectType;
	}

	@ManyToOne
	@JoinColumn(name="EventType", nullable=false)
	@Fetch(FetchMode.SELECT)
	@NotFound(action=NotFoundAction.IGNORE)
	public SystemLogEventType getEventType() {
		return this.eventType;
	}

	public void setEventType(SystemLogEventType eventType) {
		this.eventType = eventType;
	}

	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	public SystemLogInfo getSystemLogInfo() {
		return this.systemLogInfo;
	}

	public void setSystemLogInfo(SystemLogInfo systemLogInfo) {
		this.systemLogInfo = systemLogInfo;
	}

	@Column(name="EventDate", insertable=false)
	@Temporal(TemporalType.DATE)
	public Date getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getComment() {
		return this.comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Transient
	public Integer getUserId() {
		return this.getSystemLogInfo().getUserId();
	}
	
	@Transient
	public Integer getSystemDomainId() {
		return this.getSystemLogInfo().getSystemDomainId();
	}
	
	@Transient
	public String getHostIP() {
		return this.getSystemLogInfo().getHostIP();
	}

	@Transient
	public String getModule() {
		return this.getSystemLogInfo().getModule();
	}
}