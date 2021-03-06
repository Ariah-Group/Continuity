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

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.kuali.continuity.BasePlanTest;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public class AbstractHibernateDaoItests 
    extends AbstractTransactionalDataSourceSpringContextTests {
	
	private static final Logger log = Logger
	.getLogger(AbstractHibernateDaoItests.class);
		
	protected String[] getConfigLocations() {
			return new String[] {
				"/applicationContext.xml",
				"/spring-db-local.xml",
				"/spring-hibernate.xml",
				"/spring-dao.xml",
				"/spring-dao-hibernate.xml",
				"/spring-service.xml",						
				"/spring-struts-action.xml"
			};
		}
		
   protected HibernateTemplate hibernateTemplate;

   public void setSessionFactory(SessionFactory sessionFactory) {
       hibernateTemplate = new HibernateTemplate(sessionFactory);
   }

   // ---
   // HELPER METHODS
   // ---

   protected void flush() {
       log.debug("flush:");
       hibernateTemplate.flush();
   }

   protected void clear() {
       hibernateTemplate.clear();
   }

   protected void flushAndClear() {
       flush();
       clear();
   }
	public void testDao(String xxx) {
		GregorianCalendar now = new GregorianCalendar();
		System.out.println("Start test: "+now.getTimeInMillis());
		
		System.out.println("End test"+now.getTimeInMillis());;
	}
}
