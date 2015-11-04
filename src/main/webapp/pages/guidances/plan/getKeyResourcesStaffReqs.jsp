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
<!--- Guidance for staffingreqs.cfm --->

<s:if test="criticalityLevels != null">

	<strong>IMPORTANT:</strong><br />
	When estimating FTEs needed during crisis, please consider the function's criticality level -

    <ul>
        <li><strong style="text-transform: uppercase"></strong><s:property value="criticalityLevels[0].description" /></li>
        <li><strong style="text-transform: uppercase"></strong><s:property value="criticalityLevels[1].description" /></li>
        <li><strong style="text-transform: uppercase"></strong><s:property value="criticalityLevels[2].description" /></li>
        <li><strong style="text-transform: uppercase"></strong><s:property value="criticalityLevels[3].description" /></li>
    </ul>
    
</s:if>

<p><a href="./getCriticalFunctions">See expanded definitions</a></p>
