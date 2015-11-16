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
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- begin.cfm -->

<html>

<head>
    <title>Continuity Planning Tool</title>
    <meta name="keywords"
        content="Kuali Ready, Continuity,  Planning, Disaster Recovery">
    <tiles:insertAttribute name="stylesAndScripts" />
	<LINK REL="stylesheet" TYPE="text/css" HREF="/continuity/css/skin.css">
</head>

<body>

    <div id="KualiReadyLogo">
    </div>
    
    <div id="KualiReadyText">
    </div>
    
    <div id="KualiReadyMission">
    </div>
    
    <div class="beginbutton">
        <a href="./welcome"><img src="/continuity/images/begin_button1.gif" alt="begin button" border="0"></a>
    </div>
    
    <s:include value="/pages/custom/%{#session.systemDomain.customUrl}/begin.jsp"/>

</body>

<tiles:insertAttribute name="footer" />

</html>