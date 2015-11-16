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

<s:set name="currNav" value="#session.mainNav.name()" />
<s:set name="nav0" value="'nav_home'" />
<s:if test="#session.systemDomain.isLBNL == true">
    <s:set name="nav1" value="'nav_DIV'" />
    <s:set name="nav2" value="'nav_EF'" />
</s:if>
<s:else>
	<s:set name="nav1" value="'nav_ID'" />
	<s:set name="nav2" value="'nav_CF'" />
</s:else>
<s:set name="nav1title" value="%{'Step 1 ' + #session.systemDomain.displayConstants.deptHeader}"/>
<s:set name="nav2title" value="%{'Step 2 ' + #session.systemDomain.displayConstants.deptHeader + ' Functions'}"/>
<s:set name="nav1over" value="%{#nav1 + '_over'}"/>
<s:set name="nav2over" value="%{#nav2 + '_over'}"/>
<s:set name="nav3" value="'nav_IT'" />
<s:if test="#session.systemDomain.settings.isInstructionVisible == true">
    <s:set name="nav4link" value="'./getInstructions'"/>
    <s:set name="nav4" value="'nav_instruct'" />
    <s:set name="nav4over" value="'nav_instruct_over'"/>
    <s:set name="nav4title" value="'Step 4 Instruction'"/>
</s:if>
<s:else>
    <s:set name="nav4link" value="'./getFacultyPreparednessActionItems'"/>
    <s:if test="#session.systemDomain.isLBNL == true">
    </s:if>
        <s:set name="nav4" value="'nav_PI'" />
        <s:set name="nav4over" value="'nav_PI_over'" />
    <s:else>
        <s:set name="nav4" value="'nav_FE'" />
        <s:set name="nav4over" value="'nav_FE_over'" />
    </s:else>
    <s:set name="nav4title" value="'Step 4 ' + #session.systemDomain.displayConstants.facultyPrepare + ' Preparedness'"/>
</s:else>
<s:set name="nav5" value="'nav_KR'" />
<s:set name="nav6" value="'nav_AIS'" />

<s:if     test='#currNav == "HOME"'>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:if>
<s:elseif test='#currNav == "STEP1"'>
	<s:set name="nav1" value="%{#nav1+'_down'}"/>
</s:elseif>
<s:elseif test='#currNav == "STEP2"'>
	<s:set name="nav2" value="%{#nav2+'_down'}"/>
</s:elseif>
<s:elseif test='#currNav == "STEP3"'>
	<s:set name="nav3" value="%{#nav3+'_down'}"/>
</s:elseif>
<s:elseif test='#currNav == "STEP4"'>
	<s:set name="nav4" value="%{#nav4+'_down'}"/>
</s:elseif>
<s:elseif test='#currNav == "STEP5"'>
    <s:set name="nav5" value="%{#nav5+'_down'}"/>
</s:elseif>
<s:elseif test='#currNav == "SUMMARY"'>
	<s:set name="nav6" value="%{#nav6+'_down'}"/>
</s:elseif>
<s:else>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:else>

<!-- todo: bug in the if/else -->

<!--begin nav bar-->
<div id="navigation">
<ul>
<li><a href="./planHome" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image32','','/continuity/images/nav_home_over.gif',1)"><img src=<s:property value="%{'/continuity/images/'+#nav0+'.gif'}"/> alt="Plan Home" name="Image32" width="100" height="43" border="0"></a></li>
<li><a href="./getDepartmentInfo" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image33','','/continuity/images/<s:property value='nav1over'/>.gif',1)"><img src=<s:property value="%{'/continuity/images/'+#nav1+'.gif'}"/> alt="<s:property value='nav1title'/>" name="Image33" width="93" height="43" border="0"></a></li>
<li><a href="./getCriticalFunctions" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image37','','/continuity/images/<s:property value='nav2over'/>.gif',1)"><img src=<s:property value="%{'/continuity/images/'+#nav2+'.gif'}"/> alt="<s:property value='nav2title'/>" name="Image37" width="93" height="43" border="0"></a></li>
<li><a href="./getInformationTechnologyCentralApplications" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image38','','/continuity/images/nav_IT_over.gif',1)"><img src=<s:property value="%{'/continuity/images/'+#nav3+'.gif'}"/> alt="Step 3 Information Technology" name="Image38" width="93" height="43" border="0"></a></li>
<li><a href="<s:property value='nav4link'/>" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image39','','/continuity/images/<s:property value='nav4over'/>.gif',1)"><img src=<s:property value="%{'/continuity/images/'+#nav4+'.gif'}"/> alt="<s:property value='nav4title'/>" name="Image39" width="93" height="43" border="0"></a></li>
<li><a href="./getKeyResourcesStaffMembers" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image25','','/continuity/images/nav_KR_over.gif',1)"><img src=<s:property value="%{'/continuity/images/'+#nav5+'.gif'}"/> alt="Step 5 Key Resources" name="Image25" width="93" height="43" border="0"></a></li>
<li><a href="./getPlanActionItems" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image43','','/continuity/images/nav_AIS_over.gif',1)"><img src=<s:property value="%{'/continuity/images/'+#nav6+'.gif'}"/> alt="Action Item Summary" name="Image43" width="93" height="43" border="0"></a></li>						   
</ul>
</div>
<!--closes nav bar-->