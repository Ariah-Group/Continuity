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
<%@ page contentType="application/msword"  %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Continuity Planning Tool</title>

<!---
<META HTTP-EQUIV="Expires" CONTENT="Mon, 06 Jan 1990 00:00:01 GMT"> 
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
--->

<meta name="keywords" content="Ariah Continuity, Continuity,  Planning, Disaster Recovery">
<style type="text/css">

<jsp:include page="/css/ucreadyMainElements.css" />
<jsp:include page="/css/ucreadyAdminElements.css" />
<jsp:include page="/css/ucreadyAdmin_reports.css" />
</style>




</head>


<div id="maincontainer">
  <div id="contentwrapper">
    <div id="contentcolumn">
      <div id="innertube">
  <s:bean name="org.kuali.continuity.admin.action.dto.AdminReportParameterDTO" >

</s:bean>
<br />

<div id="reportdetail"> 
  <s:bean name="org.kuali.continuity.admin.action.dto.AdminReportParameterDTO" >
  <h1>This is a report from the Continuity Planning Tool database.</h1>
  <h2>Location: <s:property value="adminReportParameterDTO.location" /></h2>
  <h3><s:property value="adminReportParameterDTO.numberedReportName" /></h3>

<p><s:property value="adminReportParameterDTO.description" /></p>
</s:bean>
<!--  Table goes here trying -->
<% out.println(request.getAttribute("table")); %>

</div>




      </div>
      <!--closes innertube div-->
    </div>
    <!--closes contentcolumn div-->
  </div>
  <!--closes content wrapper div-->


</html>