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

<s:include value="/pages/common/KCPTHeader.jsp"/>

<div id="maincontainer">
<div id="contentwrapper">
<div id="contentcolumn">

<br/>
<br/>
<div id="innertube">
<div id="admin">
<h1>Administrator's Main Control Screen</h1>
<p><strong>Local Administrators may do the following</strong>:</p>


<ul class="access">

	<li><a href="underDevelopment.html"><img
		src="/kcpt/images/AdminMain_A.gif" alt="View Activity Log" /></a></li>
	<li><a href="adminReports"><img
		src="/kcpt/images/AdminMain_B.gif" alt="View and Print Reports" /></a></li>
	<li><a href="underDevelopment.html"><img
		src="/kcpt/images/AdminMain_C.gif" alt="Track Action Items" /></a></li>

	<li><a href="underDevelopment.html"><img
		src="/kcpt/images/AdminMain_D.gif" alt="View Planner's Log" /></a></li>
</ul>

<br class="clearfloat" />



<br>
<table>
	<tr>
		<td class="adminbuttons">
		<ul>
			<li><a href="accounts"><img
				src="/kcpt/images/AdminMain_1.gif" alt="User and Role Management" /></a></li>
			<li><a href="setting"><img
				src="/kcpt/images/AdminMain_4.gif" alt="System Settings" /></a></li>
			<li><a href="departmentTypes"><img
				src="/kcpt/images/AdminMain_5.gif" alt="Types of Departments" /></a></li>
	
			<li><a href="buildings"><img
				src="/kcpt/images/AdminMain_6.gif" alt="Buildings" /></a></li>
			<li><a href="majorDivisions"><img
				src="/kcpt/images/AdminMain_7.gif" alt="Major Divisions" /></a></li>
			<li><a href="acronyms"><img
				src="/kcpt/images/AdminMain_8.gif" alt="Acronyms" /></a></li>
			<li><a href="criticalFunctions"><img
				src="/kcpt/images/AdminMain_9.gif" alt="Examples of Critical Functions" /></a></li>
			<li><a href="dependencies"><img
				src="/kcpt/images/AdminMain_10.gif" alt="Dependencies" /></a></li>
			<li><a href="apps"><img
				src="/kcpt/images/AdminMain_11.gif" alt="Centrally-Owned Applications" /></a></li>
			<li><a href="skills"><img
				src="/kcpt/images/AdminMain_12.gif" alt="Skills" /></a></li>
		</ul>
		</td>

		<td class="adminbuttons">
		<ul>
			<li><a href="staffCategories"><img
				src="/kcpt/images/AdminMain_13.gif" alt="Staff Categories" /></a></li>
			<li><a href="shifts"><img
				src="/kcpt/images/AdminMain_14.gif" alt="Shifts" /></a></li>
			<li><a href="utilities"><img
				src="/kcpt/images/AdminMain_15.gif" alt="Utilities" /></a></li>
			<li><a href="knowledge"><img
				src="/kcpt/images/AdminMain_16.gif" alt="Things to Know as You Plan" /></a></li>
			<li><a href="faq_admin"><img
				src="/kcpt/images/AdminMain_17.gif" alt="FAQ" /></a></li>
			<li><a href="references"><img
				src="/kcpt/images/AdminMain_18.gif" alt="References" /></a></li>

			<li><a href="contacts_admin"><img
				src="/kcpt/images/AdminMain_19.gif" alt="Contacts" /></a></li>
			<li><a href="annualReview"><img
				src="/kcpt/images/AdminMain_20.gif" alt="Annual Review of Your Plan" /></a></li>
			<li><a href="plannerCategories"><img
				src="/kcpt/images/AdminMain_21.gif" alt="Planner's Log Categories" /></a></li>

			<li><a href="institutions"><img
				src="/kcpt/images/AdminMain_22.gif" alt="System Admin Locations" /></a></li>

		</ul>
		</td>

	</tr>
</table>
</div>
</div>
</div><!--closes contentcolumn div-->                  
</div><!--closes content wrapper div--> 

<s:include value="/pages/common/KCPTRightDiv.jsp"/>
</div><!--closes maincontainer div-->

<s:include value="/pages/common/KCPTFooter.jsp"/>

</html>