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
package org.kuali.continuity.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.kuali.continuity.PlanTestData;
import org.kuali.continuity.dao.SystemDomainDao;
import org.kuali.continuity.domain.SystemDomain;

public class SystemDomainDaoTest extends AbstractHibernateDaoItests {
	private static final Logger log = Logger
	.getLogger(SystemDomainDaoTest.class);
	SystemDomainDao systemDomainDao;
	
	// Spring injected.
	public void setSystemDomainDao(SystemDomainDao systemDomainDao) {
		this.systemDomainDao = systemDomainDao;
		
	}
	public void testInjection() {
		  System.out.println("SystemDomainDao is:"+systemDomainDao.toString());
		  logger.debug("SystemDomainDao is:"+systemDomainDao.toString());
	}
	public void testInstitution() {
		SystemDomain s ;
		s =  systemDomainDao.get(PlanTestData.wellknown_institution);
		System.out.println(s.getAuthLocation());
		List<SystemDomain> institutions =systemDomainDao.list();
		for (SystemDomain sd: institutions) {
			System.out.println(sd.getInstitution());
		}
	}
	

}
