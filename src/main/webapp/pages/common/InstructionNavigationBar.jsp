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

<s:set name="nav0" value="'subnav_priorityclasses'" />
<s:set name="nav1" value="'subnav_allcourses'" />
<s:set name="nav2" value="'subnav_deptpractices'" />
<s:set name="nav3" value="'subnav_teachingissues'" />
<s:set name="nav4" value="'subnav_e_actionitems'" />

<s:if     test='subNav.name() == "HIGH_PRIORITY_COURSES"'>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:if>
<s:elseif test='subNav.name() == "ALL_COURSES"'>
    <s:set name="nav1" value="%{#nav1+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "DEPARTMENTAL_PRACTICES"'>
    <s:set name="nav2" value="%{#nav2+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "SPECIAL_TEACHING_ISSUES"'>
    <s:set name="nav3" value="%{#nav3+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "ACTION_ITEMS"'>
    <s:set name="nav4" value="%{#nav4+'_down'}"/>
</s:elseif>
<s:else>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:else>

<s:form id="insBarForm" name="insBarForm" method="post">
<s:hidden id="insId" name="insId"/>
<div id="deptname">Department Name:&nbsp;&nbsp;<s:property value="deptName"/></div>
<div id="subnav">
    <ul>
        <li><a href="#" onclick="insBarForm.action='getInstructionHighPriorityCourses';insBarForm.submit();">  <img src="/continuity/images/<s:property value='#nav0'/>.gif" alt="a: high priority classes"   border="0"></a></li>
        <li><a href="#" onclick="insBarForm.action='getInstructionAllCourses';insBarForm.submit();">           <img src="/continuity/images/<s:property value='#nav1'/>.gif" alt="b: all courses"             border="0"></a></li>
        <li><a href="#" onclick="insBarForm.action='getInstructionDepartmentalPractices';insBarForm.submit();"><img src="/continuity/images/<s:property value='#nav2'/>.gif" alt="c: departmental practices"  border="0"></a></li>
        <li><a href="#" onclick="insBarForm.action='getInstructionTeachingIssues';insBarForm.submit();">       <img src="/continuity/images/<s:property value='#nav3'/>.gif" alt="d: special teaching issues" border="0"></a></li>
        <li><a href="#" onclick="insBarForm.action='getInstructionActionItems';insBarForm.submit();">          <img src="/continuity/images/<s:property value='#nav4'/>.gif" alt="e: action items"            border="0"></a></li>
    </ul>
</div>
</s:form>