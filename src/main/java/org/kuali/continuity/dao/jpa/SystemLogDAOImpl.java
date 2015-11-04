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
package org.kuali.continuity.dao.jpa;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.kuali.continuity.dao.SystemLogDAO;
import org.kuali.continuity.domain.SystemLog;
import org.kuali.continuity.domain.SystemLogObjectTypeEnum;

public class SystemLogDAOImpl extends BaseDAOImpl implements SystemLogDAO {

	@Override
	public void create(SystemLog obj) {
		this.getEntityManager().persist(obj);
	}

	@Override
	public SystemLog getById(int id) {
		return this.getEntityManager().find(SystemLog.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SystemLog> getListByPlanIdAndDates(int planId, Date startDate,
			Date endDate) {
		String queryString = 
			"select dObj from SystemLog dObj " +
			" where dObj.objectType.id = :objectType" +
			  " and dObj.objectId = :objectId" +
			(startDate == null ? "" : " and dObj.eventDate >= :startDate")  +
			(endDate == null ? "" : " and dOBj.eventDate < :endDate");
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("objectType", SystemLogObjectTypeEnum.pl.name());
		query.setParameter("objectId", planId);
		if (startDate != null) {
			Calendar calStart = Calendar.getInstance();
			calStart.setTime(startDate);
			calStart.set(Calendar.HOUR_OF_DAY, 0);
			calStart.set(Calendar.MINUTE, 0);
			calStart.set(Calendar.SECOND, 0);
			calStart.set(Calendar.MILLISECOND, 0);
			startDate = calStart.getTime();
			query.setParameter("startDate", startDate);
		}
		if (endDate != null) {
			Calendar calEnd = Calendar.getInstance();
			calEnd.setTime(endDate);
			calEnd.add(Calendar.DAY_OF_MONTH, 1);
			calEnd.set(Calendar.HOUR_OF_DAY, 0);
			calEnd.set(Calendar.MINUTE, 0);
			calEnd.set(Calendar.SECOND, 0);
			calEnd.set(Calendar.MILLISECOND, 0);
			endDate = calEnd.getTime();
			query.setParameter("endDate", endDate);
		}
		return (List<SystemLog>)query.getResultList();
	}

}
