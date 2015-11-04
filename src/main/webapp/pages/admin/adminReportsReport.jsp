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

<s:include value="/pages/common/KCPTHeaderR.jsp"/>


<div id="maincontainer">
  <div id="contentwrapper">
    <div id="contentcolumn">
      <div id="innertube">
  <s:bean name="org.kuali.continuity.admin.action.dto.AdminReportParameterDTO" >
<form name="myform" method="post" action="report_detail" method="post" >
<br />

			<input type="hidden" name="report_name" value='<s:property value="adminReportParameterDTO.reportId" />' />
			<input type="hidden" name="reportName" value='<s:property value="adminReportParameterDTO.numberedReportName" />' />
			<input type="hidden" name="rplan" value="all plans" />
			<input type="hidden" name="plannames" value='<s:property value="adminReportParameterDTO.plannames"/>' />
			<input type="hidden" name="s_sortby" value='<s:property value="adminReportParameterDTO.sortby"/>' />
			<input type="hidden" name="exclude" value='<s:property value="adminReportParameterDTO.exclude" />' />
			<input type="hidden" name="type" value="msword" />

<a href="javascript:document.myform.submit();">You can also download this report to Microsoft Word&reg;</a>

</form>
</s:bean>
<br />

<div id="reportdetail"> 
  <s:bean name="org.kuali.continuity.admin.action.dto.AdminReportParameterDTO" >
  <h1>This is a report from the Continuity Planning Tool database.</h1>
  <h2>Location: <s:property value="AdminReportParameterDTO.location" /></h2>
  <h3><s:property value="adminReportParameterDTO.numberedReportName" /></h3>

<p><s:property value="AdminReportParameterDTO.description" /></p>
</s:bean>
<!--  Table goes here trying -->
<% out.println(request.getAttribute("table")); %>

</div>
<br />

<s:include value="/pages/widget/BackButton.jsp"/>



      </div>
      <!--closes innertube div-->
    </div>
    <!--closes contentcolumn div-->
  </div>
  <!--closes content wrapper div-->

<s:include value="/pages/common/KCPTRightDiv.jsp"/>
</div><!--closes maincontainer div-->

<s:include value="/pages/common/KCPTFooter.jsp"/>

</html>