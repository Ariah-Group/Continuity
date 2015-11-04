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

import junit.framework.Test;
import junit.framework.TestSuite;

public class ITestSuite {
   public static Test suite() {
      TestSuite suite = new TestSuite(ITestSuite.class.getName());
      suite.addTestSuite(ActionItemDAOTest.class);
      suite.addTestSuite(ContinuityPlanDAOTest.class);
      suite.addTestSuite(CriticalCentralApplicationDAOTest.class);
      suite.addTestSuite(CriticalFunctionDAOTest.class);
      suite.addTestSuite(CriticalFunctionDocumentDAOTest.class);
      suite.addTestSuite(DepartmentOwnedApplicationDAOTest.class);
      suite.addTestSuite(DocumentDAOTest.class);
      suite.addTestSuite(FacultyPreparednessDAOTest.class);
      suite.addTestSuite(HighPriorityCourseDAOTest.class);
      suite.addTestSuite(InformationTechnologyDAOTest.class);
      suite.addTestSuite(InstructionDAOTest.class);
      suite.addTestSuite(KeyDocumentDAOTest.class);
      suite.addTestSuite(KeyResourcesDAOTest.class);
      suite.addTestSuite(KeyStaffMemberDAOTest.class);
      suite.addTestSuite(OtherUnitStaffMemberDAOTest.class);
      suite.addTestSuite(ServerDAOTest.class);
      suite.addTestSuite(StaffingRequirementDAOTest.class);
      suite.addTestSuite(StakeholderDAOTest.class);
      suite.addTestSuite(SystemDomainSamplePlanDocumentDAOTest.class);
      suite.addTestSuite(TeachingIssueDAOTest.class);
      suite.addTestSuite(TeamDAOTest.class);
      suite.addTestSuite(TeamMemberDAOTest.class);
      suite.addTestSuite(WorkFromHomeStaffMemberDAOTest.class);
      return suite;
   }
   
}
