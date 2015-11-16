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

<s:set name="nav0" value="'subnav_apps_central'" />
<s:set name="nav1" value="'subnav_apps_depart'" />
<s:set name="nav2" value="'subnav_servers'" />
<s:set name="nav3" value="'subnav_work'" />
<s:set name="nav4" value="'subnav_restart'" />
<s:set name="nav5" value="'subnav_actionitems'" />

<s:if     test='subNav.name() == "APPS_CENTRAL"'>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:if>
<s:elseif test='subNav.name() == "APPS_DEPARTMENT"'>
    <s:set name="nav1" value="%{#nav1+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "SERVERS"'>
    <s:set name="nav2" value="%{#nav2+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "WORKSTATIONS"'>
    <s:set name="nav3" value="%{#nav3+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "RESTART"'>
    <s:set name="nav4" value="%{#nav4+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "ACTION_ITEMS"'>
    <s:set name="nav5" value="%{#nav5+'_down'}"/>
</s:elseif>
<s:else>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:else>

<div id="subnav">
    <ul>
        <li><a href="./getInformationTechnologyCentralApplications">   <img src="/continuity/images/<s:property value='#nav0'/>.gif" alt="a: central applications"     border="0"></a></li>
        <li><a href="./getInformationTechnologyDepartmentApplications"><img src="/continuity/images/<s:property value='#nav1'/>.gif" alt="b: department applications"  border="0"></a></li>
        <li><a href="./getInformationTechnologyServers">               <img src="/continuity/images/<s:property value='#nav2'/>.gif" alt="c: servers"                  border="0"></a></li>
        <li><a href="./getInformationTechnologyWorkstations">          <img src="/continuity/images/<s:property value='#nav3'/>.gif" alt="d: workstations"             border="0"></a></li>
        <li><a href="./getInformationTechnologyRestart">               <img src="/continuity/images/<s:property value='#nav4'/>.gif" alt="e: how to restart"           border="0"></a></li>
        <li><a href="./getInformationTechnologyActionItems">           <img src="/continuity/images/<s:property value='#nav5'/>.gif" alt="g: action items"             border="0"></a></li>
    </ul>
</div>