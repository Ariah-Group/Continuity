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

import java.util.List;
import java.util.Set;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.domain.CriticalityLevel;
import org.kuali.continuity.domain.SystemCriticalityLevel;

public class SystemCriticalityLevelDAOTest extends
		BasePlanTest {

	private SystemCriticalityLevelDAOFactory factory;
	
	public void setFactory(SystemCriticalityLevelDAOFactory factory) {
		this.factory = factory;
	}
	
	public void testInjection() throws Exception {
		System.out.println("Factory" + this.factory.getClass().getName());
		assertNotNull(this.factory);
	}

	public void testGetSystemCriticalityLevelList() throws Exception {
		Set<Class<? extends CriticalityLevel>> refClasses = ((SystemCriticalityLevelDAOFactoryImpl)this.factory).getDaoMap().keySet();
		for (Class<? extends CriticalityLevel> refClass : refClasses) {
			System.out.println("----- " + refClass.getName() + " -----");
			System.out.println();
			List<? extends SystemCriticalityLevel> cLevels = this.factory.getSystemCriticalityLevelDAO(refClass).getSystemCriticalityLevels();
			assertNotNull(cLevels);
			assertFalse(cLevels.isEmpty());
			for (SystemCriticalityLevel cLevel : cLevels) {
				System.out.println(cLevel.getId() + " " + cLevel.getCriticalityLevelEnum() + " " + cLevel.getName());
				System.out.println(cLevel.getDescription());
				System.out.println(cLevel.getLongDescription());
			}
		}
	}

}
