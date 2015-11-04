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
package org.kuali.continuity.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Iterator;


import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.domain.SecurityTypeEnum;
import org.kuali.continuity.domain.SystemLog;
import org.kuali.continuity.domain.SystemLogEventTypeEnum;
import org.kuali.continuity.domain.SystemLogInfo;
import org.kuali.continuity.domain.SystemLogObjectTypeEnum;

public class SystemLogDAOTest extends BasePlanTest {

	private SystemLogDAO dao;
	
	public void setSystemLogDAO(SystemLogDAO dao) {
		this.dao = dao;
	}
	
	public void testInjection() throws Exception {
		String message = "DAO is: " + this.dao.toString();
		System.out.println(message);
		assertNotNull(this.dao);
	}

	public void testCreate() throws Exception {
		// construct
		String test = "Test";
		SystemLog log = new SystemLog();
		SystemLogInfo logInfo = new SystemLogInfo();
		logInfo.setHostIP(test);
		logInfo.setModule(test);
		logInfo.setSystemDomainId(1);
		logInfo.setUserId(1);
		logInfo.setSecurityType(SecurityTypeEnum.SYSTEM_ADMIN.getRefDomainObject());
		log.setObjectId(1);
		log.setEventType(SystemLogEventTypeEnum.cr.getRefDomainObject());
		log.setObjectType(SystemLogObjectTypeEnum.pl.getRefDomainObject());
		log.setSystemLogInfo(logInfo);
		log.setComment(test);

		// create
		this.dao.create(log);
		
		// test
		assertNotNull(log.getId());
	}
	
	public void testGetById() throws Exception {
		int id = 12205;
		SystemLog log = this.dao.getById(id);
		assertNotNull(log);
		assertEquals(new Integer(id), log.getId());
	}

	public void testGetListByPlanIdAndDates() throws Exception {
		int planId = 1045;
		Date startDate = Calendar.getInstance().getTime();
		Date endDate = Calendar.getInstance().getTime();
		List<SystemLog> logs = this.dao.getListByPlanIdAndDates(planId, startDate, endDate);
		assertNotNull(logs);
		assertTrue(logs.isEmpty());
		System.out.println(logs.size());
		System.out.println("get data");

	
		logs = this.dao.getListByPlanIdAndDates(planId, null, endDate);
		for (Iterator i = logs.iterator(); i.hasNext();) { 
			Object o = i.next();
			SystemLog slog = (SystemLog) o;
			System.out.println(slog.getEventDate().toString());
			
		}
		System.out.println("Done");
		assertNotNull(logs);
		assertFalse(logs.isEmpty());
		System.out.println(logs.size());
	}


}
