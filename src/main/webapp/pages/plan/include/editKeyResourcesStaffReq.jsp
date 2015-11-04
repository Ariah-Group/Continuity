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

<h1>Staffing Requirements</h1>

<a name="bookmark" id="bookmark"></a>

<p>The extreme demands that we may face during time of crisis -
including the need to ramp up certain services - may require temporary
realignments of staff. The questions below are a (very preliminary)
attempt to address that need by asking you <strong>how many</strong>
and <strong> what types</strong> of staff in your department might be
available to assist elsewhere.</p>

<p>You have identified your <s:property value="#session.systemDomain.displayConstants.criticalLower"/> functions as shown below.</p>

   <table id="staffing_select" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
       <tr>
           <th  scope="col">Function (parentheses show criticality level)</th>
           <th scope="col">Category of staff</th>
           <th scope="col">Shift</th>
           <th scope="col">FTE required under normal conditions (use partial FTEs - eg 3.5)</th>
           <th scope="col">FTE required during crisis (see Guidance on right)</th>
       </tr>
       <tr>
           <td>
               <s:select
                name="dto.criticalFunction.id"
                list="criticalFunctions"
                listKey="id"
                listValue="name"
                headerKey="0"
                headerValue="Select..."
                size="1"
                cssClass="cfSelectClass"/>
        </td>
        <td>
            <s:select
                name="dto.staffCategory.id"
                size="1"
                list="adminListMap['StaffCategory']"
                listKey="id"
                listValue="name"
                headerKey="0"
                headerValue="Select..."/>
        </td>
        <td>
            <s:select
                name="dto.shift.id"
                size="1"
                list="adminListMap['Shift']"
                listKey="id"
                listValue="name"
                headerKey="0"
                headerValue="Select..."/>
        </td>
        <td>
            <s:textfield name="dto.fteNormal" size="5" maxlength="5"/>
        </td>
        <td>
            <s:textfield name="dto.fteCrisis" size="5" maxlength="5"/>
        </td>
    </tr>
</table>
<s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
