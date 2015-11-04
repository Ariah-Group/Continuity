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
package org.kuali.continuity;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

public abstract class BasePlanTest 
	extends AbstractTransactionalDataSourceSpringContextTests {
	
	protected String[] getConfigLocations() {
		return new String[] {
			"classpath:applicationContext.xml",
			"classpath:spring-db-local.xml",
			"classpath:spring-hibernate.xml",
			"classpath:spring-jpa.xml",
			"classpath:spring-dao-hibernate.xml",
			"classpath:spring-dao.xml",
			"classpath:spring-admin-dao.xml",
			"classpath:spring-plan-dao.xml",
			"classpath:spring-plan-service.xml",
			"classpath:spring-service.xml",						
			"classpath:spring-struts-action.xml",
			"classpath:spring-mail.xml",
			"classpath:spring-aop.xml",
			"classpath:spring-cache.xml"
		};
	}
	
}
