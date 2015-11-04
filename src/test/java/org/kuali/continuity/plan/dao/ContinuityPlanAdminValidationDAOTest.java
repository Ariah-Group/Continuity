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
package org.kuali.continuity.plan.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kuali.continuity.BasePlanTest;
import org.kuali.continuity.admin.domain.Acronym;
import org.kuali.continuity.admin.domain.BaseAdminDomainObject;
import org.kuali.continuity.admin.domain.Building;
import org.kuali.continuity.admin.domain.CentralApplication;
import org.kuali.continuity.admin.domain.DepartmentType;
import org.kuali.continuity.admin.domain.Dependency;
import org.kuali.continuity.admin.domain.InstructionalDepartment;
import org.kuali.continuity.admin.domain.MajorDivision;
import org.kuali.continuity.admin.domain.Shift;
import org.kuali.continuity.admin.domain.Skill;
import org.kuali.continuity.admin.domain.StaffCategory;
import org.kuali.continuity.admin.domain.SystemDomain;
import org.kuali.continuity.admin.domain.Utility;

public class ContinuityPlanAdminValidationDAOTest extends BasePlanTest {
	
	private ContinuityPlanAdminValidationDAOFactory daoFactory;
	private static Map<Class<? extends BaseAdminDomainObject>, Integer> adminClasses = 
		new HashMap<Class<? extends BaseAdminDomainObject>, Integer>();
	static {
		// hardcoded dev test ids
		adminClasses.put(Utility.class, 138);
		adminClasses.put(Shift.class, 112);
		adminClasses.put(StaffCategory.class, 152);
		adminClasses.put(Skill.class, 163);
		adminClasses.put(CentralApplication.class, 278);
		adminClasses.put(Dependency.class, 277);
		adminClasses.put(Acronym.class, 102);
		adminClasses.put(MajorDivision.class, 513);
		adminClasses.put(Building.class, 1770);
		adminClasses.put(DepartmentType.class, 183);
		adminClasses.put(InstructionalDepartment.class, 154);
		adminClasses.put(SystemDomain.class, 512);
	}

	public void setDaoFactory(ContinuityPlanAdminValidationDAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	public void testInjection() throws Exception {
		String message = "DAO Factory is: " + this.daoFactory.toString();
		System.out.println(message);
		assertNotNull(this.daoFactory);
	}

	@SuppressWarnings("unchecked")
	public void testGetPlans() {
		Set<Class<? extends BaseAdminDomainObject>> adminSet = adminClasses.keySet();
		for (Class<? extends BaseAdminDomainObject> adminClass : adminSet) {
			int testId = adminClasses.get(adminClass);
			System.out.println("Admin Class - " + adminClass.getSimpleName() + " (" + testId + ")");
			ContinuityPlanAdminValidationDAO dao = this.daoFactory.getContinuityPlanAdminValidationDAO(adminClass);
			List<Object[]> objList = dao.getPlans(testId);
			for (Object[] obj : objList) {
				System.out.println(obj[0] + " - " + obj[1]);
			}
			System.out.println();
			assertNotNull(objList);
		}
	}

}
