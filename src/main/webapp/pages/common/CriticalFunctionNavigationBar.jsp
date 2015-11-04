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

<s:set name="nav0" value="'subnav_descrip'" />
<s:set name="nav1" value="'subnav_peak'" />
<s:set name="nav2" value="'subnav_documents'" />
<s:set name="nav3" value="'subnav_dependencies'" />
<s:set name="nav4" value="'subnav_conseq'" />
<s:set name="nav5" value="'subnav_howtocope'" />
<s:set name="nav6" value="'subnav_actionCF'" />

<s:if     test='cfNav == "DESCRIPTIONS"'>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:if>
<s:elseif test='cfNav == "PEAK_PERIODS"'>
    <s:set name="nav1" value="%{#nav1+'_down'}"/>
</s:elseif>
<s:elseif test='cfNav == "DOCUMENTS"'>
    <s:set name="nav2" value="%{#nav2+'_down'}"/>
</s:elseif>
<s:elseif test='cfNav == "DEPENDENCIES"'>
    <s:set name="nav3" value="%{#nav3+'_down'}"/>
</s:elseif>
<s:elseif test='cfNav == "CONSEQUENCES"'>
    <s:set name="nav4" value="%{#nav4+'_down'}"/>
</s:elseif>
<s:elseif test='cfNav == "HOW_TO_COPE"'>
    <s:set name="nav5" value="%{#nav5+'_down'}"/>
</s:elseif>
<s:elseif test='cfNav == "ACTION_ITEMS"'>
    <s:set name="nav6" value="%{#nav6+'_down'}"/>
</s:elseif>
<s:else>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:else>

<s:form id="cfBarForm" name="cfBarForm" method="post">
<s:hidden id="criticalFunction.id" name="criticalFunction.id"/>
<div id="subnav">
	<ul>
		<li><a href="#" onclick="cfBarForm.action='getCriticalFunctionDescription';cfBarForm.submit();"><img src="/kcpt/images/<s:property value='#nav0'/>.gif" alt="a: description"  	border="0"></a></li>
	    <li><a href="#" onclick="cfBarForm.action='getCriticalFunctionPeakPeriods';cfBarForm.submit();"><img src="/kcpt/images/<s:property value='#nav1'/>.gif" alt="b: peak periods"  border="0"></a></li>
	    <li><a href="#" onclick="cfBarForm.action='getCriticalFunctionDocuments';cfBarForm.submit();"><img src="/kcpt/images/<s:property value='#nav2'/>.gif" alt="c: documents"     border="0"></a></li>
	    <li><a href="#" onclick="cfBarForm.action='getCriticalFunctionDependencies';cfBarForm.submit();"><img src="/kcpt/images/<s:property value='#nav3'/>.gif" alt="d: dependencies"  border="0"></a></li>
	    <li><a href="#" onclick="cfBarForm.action='getCriticalFunctionConsequences';cfBarForm.submit();"><img src="/kcpt/images/<s:property value='#nav4'/>.gif" alt="e: consequences"  border="0"></a></li>
	    <li><a href="#" onclick="cfBarForm.action='getCriticalFunctionCopingMethod';cfBarForm.submit();"><img src="/kcpt/images/<s:property value='#nav5'/>.gif" alt="f: how to cope"   border="0"></a></li>
	    <li><a href="#" onclick="cfBarForm.action='getCriticalFunctionActionItems';cfBarForm.submit();"><img src="/kcpt/images/<s:property value='#nav6'/>.gif" alt="g: action items"  border="0"></a></li>
	</ul>
</div>
</s:form>
