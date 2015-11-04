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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<!--- Admin Main Page--->
<!--- accessible by System Admin and Local Admins --->
<s:include value="/pages/common/KCPTHeaderR.jsp"/>

<div id="maincontainer">
	<div id="contentwrapper">
    	<div id="contentcolumn">
        	<div id="innertube">
			<div id="admin">
				
				<h1>Administrator's Main Control Screen</h1>
				<p><strong>Local Administrators may do the following</strong>:</p>

				<ul class="access">
					<li><a href="../admin/activityLog"><img src="../images/AdminMain_A.gif" alt="View Activity Log" /></a></li>
					<li><a href="adminReports"><img src="../images/AdminMain_B.gif" alt="View and Print Reports" /></a></li>
				</ul>

				<br class="clearfloat" />

				<hr >
				<p><strong>Local Administrators may also control the content of this planning tool:</strong></p>
				
				<table>
					<tr>
						<td class="adminbuttons">
							<ul>
								<li><a href="../admin/accounts"><img src="../images/AdminMain_1.gif" alt="Manage User Accounts" /></a></li>
								<li><a href="../admin/setting"><img src="../images/AdminMain_4.gif" alt="Setup System Parameters" /></a></li>
								<li><a href="../admin/departmentTypes"><img src="../images/AdminMain_5.gif" alt="Setup Types of Departments" /></a></li>
								<li><a href="../admin/buildings"><img src="../images/AdminMain_6.gif" alt="Setup Buildings" /></a></li>
								<li><a href="../admin/majorDivisions"><img src="../images/AdminMain_7.gif" alt="Setup Major Divisions" /></a></li>
								<li><a href="../admin/acronyms"><img src="../images/AdminMain_8.gif" alt="Setup Acronyms" /></a></li>
								<li><a href="../admin/criticalityLevels"><img src="../images/AdminMain_Levels.gif" alt="Setup Levels of Criticality" /></a></li>
                                <li><a href="../admin/criticalFunctions"><img src="../images/AdminMain_9.gif" alt="Setup Examples of Critical Functions" /></a></li>
							</ul>
						</td>


						<td class="adminbuttons">
							<ul>
								<li><a href="../admin/dependencies"><img src="../images/AdminMain_10.gif" alt="Setup Dependencies" /></a></li>
								<li><a href="../admin/apps"><img src="../images/AdminMain_11.gif" alt="Setup Centrally-Owned Applications" /></a></li>
                                <li><a href="../admin/instructionScreens"><img src="../images/AdminMain_11b.gif" alt="Setup Custom Text for Step 4" /></a></li>
                                <li><a href="../admin/instructionalDepartments"><img src="../images/AdminMain_11c.gif" alt="Setup List of Instructional Depts" /></a></li>
								<li><a href="../admin/skills"><img src="../images/AdminMain_12.gif" alt="Setup Skills" /></a></li>
								<li><a href="../admin/staffCategories"><img src="../images/AdminMain_13.gif" alt="Setup Staff Categories" /></a></li>
								<li><a href="../admin/shifts"><img src="../images/AdminMain_14.gif" alt="Setup Shifts" /></a></li>
							</ul>
						</td>

						<td class="adminbuttons">
							<ul>
                                <li><a href="../admin/utilities"><img src="../images/AdminMain_15.gif" alt="Setup Utilities" /></a></li>
								<li><a href="../admin/knowledge"><img src="../images/AdminMain_16.gif" alt="Setup Things to Know as You Plan" /></a></li>
								<li><a href="../admin/faq_admin"><img src="../images/AdminMain_17.gif" alt="Setup Frequently-Asked Questions" /></a></li>
								<li><a href="../admin/references"><img src="../images/AdminMain_18.gif" alt="Setup References" /></a></li>
								<li><a href="../admin/contacts_admin"><img src="../images/AdminMain_19.gif" alt="Setup Contacts" /></a></li>
								<li><a href="../admin/annualReview"><img src="../images/AdminMain_20.gif" alt="Setup Annual Review of Your Plan" /></a></li>
								<li><a href="../admin/samplePlan"><img src="../images/AdminMain_21a.gif" alt="Setup Sample Plan" /></a></li>
								<s:if test="#session.user.securityType.id== 0">
									<li><a href="../admin/institutions"><img src="../images/AdminMain_22.gif" alt="Setup Locations" /></a></a></li>
								</s:if>
							 </ul>
						</td>
					</tr>
				</table>
				
			</div><!--closes admin div-->
        	</div><!--closes innertube div-->
		</div><!--closes contentcolumn div-->
    </div><!--closes content wrapper div-->

<s:include value="/pages/common/KCPTRightDivA.jsp"/>


 </div><!--closes mainncontainer div-->

<s:include value="/pages/common/KCPTFooter.jsp"/>

</html>
