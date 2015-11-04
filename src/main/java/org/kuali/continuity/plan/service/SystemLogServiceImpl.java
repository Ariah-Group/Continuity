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
package org.kuali.continuity.plan.service;

import org.kuali.continuity.dao.SystemLogDAO;
import org.kuali.continuity.domain.SystemLog;
import org.kuali.continuity.domain.SystemLogEventType;
import org.kuali.continuity.domain.SystemLogEventTypeEnum;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.domain.SystemLogObjectType;

public class SystemLogServiceImpl implements SystemLogService {
	
	private SystemLogDAO systemLogDAO;
	
	public SystemLogServiceImpl() {

	}
	
	public void logAddEvent(Integer logObjectId, SystemLogObjectType logObjectType, String comment, SystemLogInfo logInfo) {
		this.log(logObjectId, logObjectType, SystemLogEventTypeEnum.cr.getRefDomainObject(), comment, logInfo);
	}
	
	public void logUpdateEvent(Integer logObjectId, SystemLogObjectType logObjectType, String comment, SystemLogInfo logInfo) {
		this.log(logObjectId, logObjectType, SystemLogEventTypeEnum.rw.getRefDomainObject(), comment, logInfo);
	}
	
	public void logDeleteEvent(Integer logObjectId, SystemLogObjectType logObjectType, String comment, SystemLogInfo logInfo) {
		this.log(logObjectId, logObjectType, SystemLogEventTypeEnum.dl.getRefDomainObject(), comment, logInfo);
	}
	
	public void logReadEvent(Integer logObjectId, SystemLogObjectType logObjectType, String comment, SystemLogInfo logInfo) {
		this.log(logObjectId, logObjectType, SystemLogEventTypeEnum.ac.getRefDomainObject(), comment, logInfo);
	}
	
	protected void log(
			int logObjectId, 
			SystemLogObjectType logObjectType, 
			SystemLogEventType logEventType, 
			String comment,
			SystemLogInfo logInfo) {
		
		// system log
		SystemLog systemLog = new SystemLog();
		systemLog.setEventType(logEventType);
		systemLog.setObjectId(logObjectId);
		systemLog.setObjectType(logObjectType);
		systemLog.setSystemLogInfo(logInfo);
		systemLog.setComment(comment);
		
		// create log
		this.systemLogDAO.create(systemLog);
	}

	public SystemLogDAO getSystemLogDAO() {
		return this.systemLogDAO;
	}
	
	public void setSystemLogDAO(SystemLogDAO systemLogDAO) {
		this.systemLogDAO = systemLogDAO;
	}
	
}
