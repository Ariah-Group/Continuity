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

<div id="innertube">

<h1>List of All Plans</h1>

<p>These are the departments that are currently engaged in continuity planning:</p>

<table width="100%"  border="0" cellspacing="2" cellpadding="0">
    <tr>
        <th width="48%" align="left" nowrap><h2>CONTINUITY PLAN COMPLETED</h2></th>
        <th width="2%" align="center">&nbsp;</th>
        <th width="48%" align="left" nowrap><h2>CONTINUITY PLAN IN-PROGRESS</h2></th>
    </tr>
    <tr>
        <td align="left" valign="top" width="48%">
            <s:iterator value="cPlans">
                <s:property value="acronymPlusName"/><br/>
            </s:iterator>
        </td>
        <td width="2%" align="center" rowspan=<s:property value="nPlans.size"/>>&nbsp;</td>
        <td align="left" valign="top" width="48%">
            <s:iterator value="nPlans">
                <s:property value="acronymPlusName"/><br/>
            </s:iterator>
        </td>
    </tr>
</table>

<br />

<s:include value="/pages/widget/BackButton.jsp"/>

</div>