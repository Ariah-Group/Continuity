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

import java.util.List;

import javax.persistence.Query;

import org.kuali.continuity.dao.SystemCriticalityLevelDAO;
import org.kuali.continuity.domain.CriticalityLevelEnum;
import org.kuali.continuity.domain.SystemCriticalityLevel;

@SuppressWarnings("unchecked")
public class SystemCriticalityLevelDAOImpl<T extends SystemCriticalityLevel> extends BaseDAOImpl
		implements SystemCriticalityLevelDAO {

	private Class<T> criticalityLevelClass;
	
	public SystemCriticalityLevelDAOImpl(Class<T> criticalityLevelClass) {
		this.criticalityLevelClass = criticalityLevelClass;
	}

	@Override
	public List<? extends SystemCriticalityLevel> getSystemCriticalityLevels() {
		String queryString = this.getBaseQueryString();
		Query query = this.getEntityManager().createQuery(queryString);
		return (List<? extends SystemCriticalityLevel>) query.getResultList();
	}

	@Override
	public SystemCriticalityLevel getSystemCriticalityLevel(
			CriticalityLevelEnum levelEnum) {
		String queryString = this.getBaseQueryString() + " WHERE dObj.criticalityLevelEnum = :levelEnum";
		Query query = this.getEntityManager().createQuery(queryString);
		query.setParameter("levelEnum", levelEnum);
		return (SystemCriticalityLevel) query.getSingleResult();
	}
	
	private String getBaseQueryString() {
		return "SELECT dObj FROM " + this.criticalityLevelClass.getSimpleName() + " dObj";
	}

}
