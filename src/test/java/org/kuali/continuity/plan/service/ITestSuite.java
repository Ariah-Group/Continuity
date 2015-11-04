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
package org.kuali.continuity.plan.service;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ITestSuite {
   public static Test suite() {
      TestSuite suite = new TestSuite(ITestSuite.class.getName());
      suite.addTestSuite(ActionItemServiceTest.class);
      suite.addTestSuite(ContinuityPlanServiceTest.class);
      suite.addTestSuite(CriticalCentralApplicationServiceTest.class);
      suite.addTestSuite(CriticalFunctionServiceTest.class);
      suite.addTestSuite(CriticalFunctionDocumentServiceTest.class);
      suite.addTestSuite(DepartmentOwnedApplicationServiceTest.class);
      suite.addTestSuite(DocumentServiceTest.class);
      suite.addTestSuite(FacultyPreparednessServiceTest.class);
      suite.addTestSuite(HighPriorityCourseServiceTest.class);      
      suite.addTestSuite(InformationTechnologyServiceTest.class);
      suite.addTestSuite(InstructionServiceTest.class);
      suite.addTestSuite(KeyDocumentServiceTest.class);
      suite.addTestSuite(KeyResourcesServiceTest.class);
      suite.addTestSuite(KeyStaffMemberServiceTest.class);
      suite.addTestSuite(OtherUnitStaffMemberServiceTest.class);
      suite.addTestSuite(ServerServiceTest.class);
      suite.addTestSuite(StaffingRequirementServiceTest.class);
      suite.addTestSuite(StakeholderServiceTest.class);
      suite.addTestSuite(TeachingIssueServiceTest.class);
      suite.addTestSuite(TeamServiceTest.class);
      suite.addTestSuite(TeamMemberServiceTest.class);
      suite.addTestSuite(WorkFromHomeStaffMemberServiceTest.class);
      return suite;
   }
   
}
