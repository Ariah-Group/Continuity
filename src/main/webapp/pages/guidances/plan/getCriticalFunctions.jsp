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
<!--- Guidance for critical_functions screen --->


<strong>FUNCTIONS</strong>.  We are asking here for the functions you normally perform.  Here are some typical examples:

<ul>
	<li>instruction</li>
	<li>research</li>
	<li>non-elective surgery</li>
	<li >purchasing</li>
	<li>paying employees</li>
	<li>inpatient care</li>
	<li>facilities repair</li>
	<li>providing meals for residents of university housing</li>
	<li>pharmacy services</li>
	<li>grant accounting</li>
  
  </ul>
 
<a href="./getCritialFunctionGuidanceStepTwo">Should we include functions that we do only in times of crisis?</a>
<br/>
<s:if test="#session.systemDomain.settings.isCriticalFunctionsScreenVisible == true">
<br/>
<a href="./getCriticalFunctionExamples">See real examples from other departments</a>
<br/>
</s:if>

<s:if test="criticalityLevels != null">
	<br/>
	<div align="center">
	    <img src="/continuity/images/blue_line_G.gif" alt="" width="220" height="10"> 
	</div> 
	<br/>
	<strong>LEVELS OF CRITICALITY FOLLOWING DISASTER</strong>
	<ul>
		<li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[0].name" />:&nbsp;</strong><s:property value="criticalityLevels[0].longDescription" /></li>
		<li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[1].name" />:&nbsp;</strong><s:property value="criticalityLevels[1].longDescription" /></li>
		<li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[2].name" />:&nbsp;</strong><s:property value="criticalityLevels[2].longDescription" /></li>
		<li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[3].name" />:&nbsp;</strong><s:property value="criticalityLevels[3].longDescription" /></li>
	</ul>
</s:if>