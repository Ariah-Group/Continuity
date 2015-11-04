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
<h1>Main Admin Page:Test Page</h1>
<li>
<ul><a href="adminHome">Reload This Page</a><br/>
<ul><a href="adminRole">Roles</a><br/>
<ul><a href="adminApplication">Central Applications</a><br/>

</li>



<br/>
 
<br/>

</div><!--closes contentcolumn div-->                  
</div><!--closes content wrapper div--> 

<s:include value="/pages/common/KCPTRightDiv.jsp"/>
</div><!--closes maincontainer div-->

<s:include value="/pages/common/KCPTFooter.jsp"/>

</html>