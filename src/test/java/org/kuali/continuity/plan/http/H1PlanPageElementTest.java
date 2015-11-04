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
package org.kuali.continuity.plan.http;

import org.kuali.continuity.PlanTestData;


public class H1PlanPageElementTest extends PlanPageElementTest {
	
	// -- TABS -- //

	public void testDepartmentInfoTab() throws Exception {
		String[] weblinks = {"Step 1 Departmental Identification"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Department Identification"));
	}
	
	public void testCriticalFunctionsTab() throws Exception {
		String[] weblinks = {"Step 2 Critical Functions"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Identify Your Critical Functions"));
	}
	
	public void testInformationTechnologyTab() throws Exception {
		String[] weblinks = {"Step 3 Information Technology"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Centrally-Owned Applications"));
	}
	
//	public void testFacultyPreparednessTab() throws Exception {
//		String[] weblinks = {"Step 4 Faculty Preparedness"};
//		this.doTestPageElement(
//			weblinks, 
//			new H1TagSettings("Faculty Preparedness"));
//	}
	
	public void testInstructionTab() throws Exception {
		String[] weblinks = {"Step 4 Instruction"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Identify Your Department"));
	}	
	
	public void testKeyResourcesTab() throws Exception {
		String[] weblinks = {"Step 5 Key Resources"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Staff Basics"));
	}
	
	public void testActionItemSummary() throws Exception {
		String[] weblinks = {"Action Item Summary"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Action Item Summary"));
	}
	
	// -- PLAN HOME -- //
	
	public void testGetPlanDepartment() throws Exception {
		String[] weblinks = {"Edit Name & Org. Data"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Information About Your Department"));
	}
	
	public void testGetPlanUsers() throws Exception {
		String[] weblinks = {"Add/Remove User"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Add or Remove Authorized Users of This Plan"));
	}
	
	public void testPrintMenu() throws Exception {
		String[] weblinks = {"Printing Menu"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Printing Menu"));
	}
	
	public void testPlanReviewComplete() throws Exception {
		String[] weblinks = {"Mark Plan Complete"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Mark Your Plan Complete"));
	}
	
	public void testPlanReviewAnnual() throws Exception {
		String[] weblinks = {"Mark Annual Review Complete"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Mark Your Annual Review Complete"));
	}
	
	// -- CRITICAL FUNCTIONS --//

	public void testCFDescription() throws Exception {
		this.doTestPageElement(
			"/plan/getCriticalFunctionDescription?criticalFunction.id=" + 
			PlanTestData.uc_critical_function, 
			new H1TagSettings("Description"));
	}
	
	public void testCFPeakPeriods() throws Exception {
		this.doTestPageElement(
			"/plan/getCriticalFunctionPeakPeriods?criticalFunction.id=" + 
			PlanTestData.uc_critical_function, 
			new H1TagSettings("Periods of High Activity"));
	}
	
	public void testCFDocuments() throws Exception {
		this.doTestPageElement(
			"/plan/getCriticalFunctionDocuments?criticalFunction.id=" + 
			PlanTestData.uc_critical_function, 
			new H1TagSettings("Documents"));
	}
	
	public void testCFDependencies() throws Exception {
		this.doTestPageElement(
			"/plan/getCriticalFunctionDependencies?criticalFunction.id=" + 
			PlanTestData.uc_critical_function, 
			new H1TagSettings("Dependencies"));
	}
	
	public void testCFConsequences() throws Exception {
		this.doTestPageElement(
			"/plan/getCriticalFunctionConsequences?criticalFunction.id=" + 
			PlanTestData.uc_critical_function, 
			new H1TagSettings("Consequences of Slow Recovery"));
	}
	
	public void testCFHowToCope() throws Exception {
		this.doTestPageElement(
			"/plan/getCriticalFunctionCopingMethod?criticalFunction.id=" + 
			PlanTestData.uc_critical_function, 
			new H1TagSettings("How to Cope"));
	}
	
	public void testCFActionItems() throws Exception {
		this.doTestPageElement(
			"/plan/getCriticalFunctionActionItems?criticalFunction.id=" + 
			PlanTestData.uc_critical_function, 
			new H1TagSettings("Action Items"));
	}
	
	// -- INFORMATION TECHNOLOGY -- //

	public void testITCentralApplications() throws Exception {
		String[] weblinks = {"Step 3 Information Technology", "a: central applications"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Centrally-Owned Applications"));
	}
	
	public void testITDepartmentApplications() throws Exception {
		String[] weblinks = {"Step 3 Information Technology", "b: department applications"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Departmentally-Owned Applications"));
	}
	
	public void testITServers() throws Exception {
		String[] weblinks = {"Step 3 Information Technology", "c: servers"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Servers"));
	}
	
	public void testITWorkstations() throws Exception {
		String[] weblinks = {"Step 3 Information Technology", "d: workstations"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Workstations"));
	}
	
	public void testITRestart() throws Exception {
		String[] weblinks = {"Step 3 Information Technology", "e: how to restart"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("Recovery Strategies"));
	}
	
	public void testITActionItems() throws Exception {
		String[] weblinks = {"Step 3 Information Technology", "g: action items"};
		this.doTestPageElement(
			weblinks, 
			new H1TagSettings("IT Action Items"));
	}
	
	// -- INSTRUCTION -- //

	public void testINHighPriorityCourses() throws Exception {
		this.doTestPageInTableElement(
			"Step 4 Instruction", "editplan_table", 1, "a: high priority classes",
			new H1TagSettings("High Priority Courses"));
	}

	public void testINAllCourses() throws Exception {
		this.doTestPageInTableElement(
			"Step 4 Instruction", "editplan_table", 1, "b: all courses",
			new H1TagSettings("All Courses"));
	}

	public void testINDepartmentalPractices() throws Exception {
		this.doTestPageInTableElement(
			"Step 4 Instruction", "editplan_table", 1, "c: departmental practices",
			new H1TagSettings("Departmental Practices"));
	}

	public void testINTeachingIssues() throws Exception {
		this.doTestPageInTableElement(
			"Step 4 Instruction", "editplan_table", 1, "d: special teaching issues",
			new H1TagSettings("Special Teaching Issues"));
	}

	public void testINActionItems() throws Exception {
		this.doTestPageInTableElement(
			"Step 4 Instruction", "editplan_table", 1, "e: action items",
			new H1TagSettings("Action Items"));
	}

	// -- KEY RESOURCES -- //

	public void testKRStaffBasics() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "a: staff basics"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Staff Basics"));
	}
	
	public void testKRWorkFromHome() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "b: work from home"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Work from Home"));
	}
	
	public void testKRTeams() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "c: teams"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Teams"));
	}
	
	public void testKRSkills() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "d: skills"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Skills"));
	}
	
	public void testKRStaffingRequirements() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "e: staffing requirements"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Staffing Requirements"));
	}
	
	public void testKRStaffOtherUnits() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "f: staff of other units"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Staff of Other Units"));
	}
	
	public void testKRStakeholders() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "g: stakeholders"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Other Stakeholders"));
	}
	
	public void testKRDocumentSummary() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "h: document summary"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Documents Summary"));
	}
	
	public void testKREquipmentSupplies() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "i: equipments & supplies"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Equipment & Supplies"));
	}
	
	public void testKRFacilitiesTransportation() throws Exception {
		String[] weblinks = {"Step 5 Key Resources", "j: facilities & transporations"};
		this.doTestPageElement(
				weblinks, 
				new H1TagSettings("Facilities & Transportation"));
	}
	
}
