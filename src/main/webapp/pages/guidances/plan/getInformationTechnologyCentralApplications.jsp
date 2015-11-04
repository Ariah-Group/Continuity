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

<!--- Guidance for infotechnology screen --->

<s:if test="criticalityLevels != null">
    <strong>LEVELS OF CRITICALITY of IT systems </strong> 
    <ul>
        <li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[0].name" />&nbsp;-&nbsp;</strong><s:property value="criticalityLevels[0].longDescription" /></li>
        <li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[1].name" />&nbsp;-&nbsp;</strong><s:property value="criticalityLevels[1].longDescription" /></li>
        <li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[2].name" />&nbsp;-&nbsp;</strong><s:property value="criticalityLevels[2].longDescription" /></li>
        <li><strong style="text-transform: uppercase"><s:property value="criticalityLevels[3].name" />&nbsp;-&nbsp;</strong><s:property value="criticalityLevels[3].longDescription" /></li>
    </ul>
    <div align="center">
        <img src="../images/blue_line_G.gif" alt="" width="220" height="10"> 
    </div>
</s:if> 
<ul>
    <li><strong>Functional Owner:</strong>  the unit that <b>authorizes</b> any modifications. </li> 
    <li><strong>Technical Owner:</strong>  the unit that has system administrator or programming access and <b>implements</b> any modifications. </li>
</ul>