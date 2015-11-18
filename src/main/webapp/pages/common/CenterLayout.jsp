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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Continuity Planning Tool</title>
    <meta name="keywords"
        content="Ariah Continuity, Continuity,  Planning, Disaster Recovery">
    <!-- Enforce browser not to cache  -->
    <META Http-Equiv="Cache-Control" Content="no-cache">
    <META Http-Equiv="Pragma" Content="no-cache">
    <META Http-Equiv="Expires" Content="0"> 
    <tiles:insertAttribute name="banner"/>
    <tiles:insertAttribute name="stylesAndScripts" />
    <s:if test="#tiles_includeStyles != null && #tiles_includeStyles.size() > 0">
        <s:iterator value="#tiles_includeStyles">
            <link rel="stylesheet" type="text/css" href="<s:property/>">
        </s:iterator>
    </s:if>
    <s:if test="#tiles_includeScripts != null && #tiles_includeScripts.size() > 0">
        <s:iterator value="#tiles_includeScripts">
            <script  type="text/javascript" src="<s:property/>"></script>
        </s:iterator>
    </s:if>
</head>

<body>
    <tiles:insertAttribute name="content" />
    <tiles:insertAttribute name="footer" />
</body>
</html>