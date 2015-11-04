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
package org.kuali.continuity.admin.dao;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ITestSuite {
   public static Test suite() {
      TestSuite suite = new TestSuite(ITestSuite.class.getName());
      suite.addTestSuite(AcronymDAOTest.class);
      suite.addTestSuite(AnnualReviewDAOTest.class);
      suite.addTestSuite(BuildingDAOTest.class);
      suite.addTestSuite(CentralApplicationDAOTest.class);
      suite.addTestSuite(ContactInfoDAOTest.class);
      suite.addTestSuite(CriticalFunctionExampleDAOTest.class);
      suite.addTestSuite(DepartmentTypeDAOTest.class);
      suite.addTestSuite(DependencyDAOTest.class);
      suite.addTestSuite(FAQDAOTest.class);
      suite.addTestSuite(InstructionalDepartmentDAOTest.class);
      suite.addTestSuite(MajorDivisionDAOTest.class);
      suite.addTestSuite(PlannerLogCategoryDAOTest.class);
      suite.addTestSuite(ReferenceDAOTest.class);
      suite.addTestSuite(ShiftDAOTest.class);
      suite.addTestSuite(SkillDAOTest.class);
      suite.addTestSuite(StaffCategoryDAOTest.class);
      suite.addTestSuite(SystemDomainDAOTest.class);
      suite.addTestSuite(ToKnowItemDAOTest.class);
      suite.addTestSuite(UserDAOTest.class);
      suite.addTestSuite(UtilityDAOTest.class);
      return suite;
   }
}
