<%-- 
 % Copyright 2011 Kuali Foundation, Inc. Licensed under the
 % Educational Community License, Version 2.0 (the "License"); you may
 % not use this file except in compliance with the License. You may
 % obtain a copy of the License at
 % 
 % http://www.opensource.org/licenses/ecl2.php
 % 
 % Unless required by applicable law or agreed to in writing,
 % software distributed under the License is distributed on an "AS IS"
 % BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 % or implied. See the License for the specific language governing
 % permissions and limitations under the License.
 --%> 

<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="ns" value="#request['javax.servlet.forward.servlet_path'].substring(1,6)"/>
<s:if test="#ns == 'admin'">
   	<select class="QuickLinksClass" name="quicklinks" onChange="ShowLink(this.options[this.selectedIndex].value);" >
	<option value="#" selected>GO TO..</option>
	<option value="../plan/welcome">Return to Welcome Screen</option>
    <option value="/continuity/plan/getPlans">Choose a Plan</option>
    <option value="adminHome">Administrator's Main Control Screen</option>
	<option value="activityLog">Activity Log</option>
	<option value="reports">Reports</option>
	<option value="accounts">Manage User Accounts</option>
	<option value="setting">Setup System Parameters</option>
	<option value="departmentTypes">Setup Types of Department</option>
	<option value="buildings">Setup Buildings</option>
	<option value="majorDivisions">Setup Major Divisions</option>
	<option value="acronyms">Setup Acronyms</option>
    <option value="criticalityLevels">Define Levels of Criticality</option>
	<option value="criticalFunctions">Setup Examples of Critical Functions</option>
	<option value="dependencies">Setup Dependencies</option>
	<option value="apps">Setup Centrally-Owned Applications</option>
    <option value="instructionScreens">Setup Custom Text for Step 4</option>
    <option value="instructionalDepartments">Setup List of Instructional Depts</option>
	<option value="skills">Setup Skills</option>
	<option value="staffCategories">Setup Staff Categories</option>
	<option value="shifts">Setup Shifts</option>
	<option value="utilities">Setup Utilities</option>
	<option value="knowledge">Setup Things to Know as You Plan</option>
	<option value="faq_admin">Setup Frequently-Asked Questions</option>
	<option value="references">Setup References</option>
	<option value="contacts_admin">Setup Contacts</option>
	<option value="annualReview">Setup Annual Review of Your Plan</option>
	<option value="samplePlan">Setup Sample Plan</option>
	<s:if test= "#session.user.securityType.id == 0">
		<option value="institutions">Setup Institutions &amp; Locations</option>
	</s:if>	
	</select>
</s:if>
<s:else>
	<select class="QuickLinksClass" name="quicklinks" onChange="ShowLink(this.options[this.selectedIndex].value);" >
		<option value="#" selected>GO TO..</option>
		<s:if test="#session.plan neq null">
			<option value="planHome?doRefresh=true">Plan Home</option>
		</s:if>
		<option value="editPlan">Create New Plan</option>
		<option value="getPlans">Choose Different Plan</option>
		<s:if test="#session.plan neq null">
			<option value="printMenu">Printing Menu </option>
			<option value="getPlanDepartment">Department Information</option>
	    </s:if>
	    <s:if test="#session.planGatekeeper neq null">
			<option value="getPlanUsers">Add/Remove Users</option>
	    </s:if>
        <s:if test="#session.plan neq null">
			<option value="getPlanActionItems">Action Item Summary</option>
			<option value="getKeyResourcesDocuments">Documents Summary</option>
            <option value="planReviewComplete">Instructions for Plan Sign-off</option>       
            <option value="planReviewAnnual">Instructions for Annual Review Sign-off</option>        
		</s:if>
		<option value="getBasePlans">List of All Plans</option>
		<option value="getDocumentFile?type=sp">Sample Plan</option>
		<s:if test="#session.plan neq null">
		   	<option value="printMenu#interviewforms">Interview Forms</option>
		</s:if>	   
	    <option value="annualReviews">Annual Review</option>
		<option value="toKnowItems">Things to Know</option>
		<option value="faqs">FAQs</option>
		<option value="references">References</option>
	 	<option value="contactUs">Contact Us</option>
		<s:if test="#session.user.securityType.id != 9" >
			<option value="getSystemDomainDocuments">Download Documents</option>
		</s:if>
		<s:if test= "#session.user.isShibMode == false">
			<option value="myProfile">My Profile</option>
		</s:if> 	
        <s:if test= "#session.systemAdminUser != null">
			<option value="sessionRole">Administrator's Emulation Screen</option>
		</s:if> 	 		 	
		<s:if test= "#session.user.securityType.id == 0 || #session.user.securityType.id == 1 || #session.user.securityType.id == 3">
			<option value="/continuity/admin/adminHome">Administrator's Main Control Screen</option>
		</s:if>		
	</select>
	<!-- End Select Statement -->
</s:else>
