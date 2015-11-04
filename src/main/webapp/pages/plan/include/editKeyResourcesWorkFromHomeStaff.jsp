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

<table id="procedures" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    <tr>
        <th class="workhome"><label for="dto.name">Name:</label></th>
        <td class="workpadding"><s:textfield name="dto.name" id="dto.name" size="40" maxlength="50"/></td>
   </tr>

   <tr>
       <th class="workhome"><label for="dto.staffPosition.id">Position:</label></th>
       <td class="workpadding">
           <s:select 
               name="dto.staffPosition.id" 
               list="refListMap['StaffPosition']"
               listKey="id"
               listValue="description"
               headerKey="0"
               headerValue="Please select ..."/>
       </td>
   </tr>

   <tr>
       <th class="workhome"><label for="dto.hasBroadbandConnection.id">Broadband connection?</label></th>
       <td class="workpadding">
           <s:select 
               name="dto.hasBroadbandConnection.id" 
               list="refListMap['BroadbandConnection']"
               listKey="id"
               listValue="description"
               headerKey="0"
               headerValue="Please select ..."/>
           (currently has broadband connection at home - cable, DSL, wireless)?
       </td>
   </tr>

   <tr>
       <th class="workhome"><label for="dto.doesConnectFromHome.id">Currently <u>does</u> connect from home?</label></th>
       <td class="workpadding">
           <s:select 
               name="dto.doesConnectFromHome.id" 
               list="refListMap['ConnectFromHome']"
               listKey="id"
               listValue="description"
               headerKey="0"
               headerValue="Please select ..."/>
       </td>
   </tr>

   <tr>
       <th class="workhome"><label for="dto.mustOfficeComputerRunning.id">Must his/her office computer be running?</label></th>
       <td class="workpadding">
           <s:select 
               name="dto.mustOfficeComputerRunning.id" 
               list="refListMap['ComputerRunning']"
               listKey="id"
               listValue="description"
               headerKey="0"
               headerValue="Please select ..."/>
           (e.g. the Windows Remote Desktop connection requires this)</td>
   </tr>

   <tr>
       <th class="workhome"><label for="dto.comment">Comment?</label></th>
       <td><s:textarea name="dto.comment" cols="50" rows="2"/></td>
    </tr>

</table>

<s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>

