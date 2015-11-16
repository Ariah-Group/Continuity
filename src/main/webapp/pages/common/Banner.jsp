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
<s:set var="domain" value="#parameters['systemDomainId']"/>
<s:if test="#domain == null || #domain == ''">
    <s:set var="domain" value="#session.loginSystemDomain.id"/>
</s:if>
<LINK REL="stylesheet" TYPE="text/css" HREF="/continuity/css/skin.css">


<!-- Begin Banner Table -->

<s:set var="ns" value="#request['javax.servlet.forward.servlet_path'].substring(1,6)"/>
<s:set var="beginPage" value="%{#request['javax.servlet.forward.context_path'] + '/plan/begin'}"/>
<s:if test="#ns == 'login'">
    <s:set var="beginPage" value="'#'"/>
</s:if>
<div id="UCReadyhead">
	<a href="<s:property value="#beginPage"/>">Kuali Ready Securing our mission: teaching, research, and public service</a>
</div>
<!-- End Banner Table -->