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

<h2>Key People in Your Unit:</h2>

<a name="bookmark" id="bookmark"></a>
    
<p>Now envision your unit 1-3 days after a major disaster.  You are calling together a group to PLAN how to resume operations.   Who are the key people (staff or faculty) whose positions or knowledge might place them in that group?</p>

<table class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    <tr>
        <td>
            <label for= "dto.firstName"><strong>First Name:</strong></label>
            <s:textfield name="dto.firstName" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" maxlength="20" />
            
            <label for= "dto.lastName"><strong>Last Name:</strong></label>
            <s:textfield name="dto.lastName" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" maxlength="20" />
            
            <label for= "dto.titleOrFunction"><strong>Title or Function:</strong></label>
            <s:textfield name="dto.titleOrFunction" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" maxlength="20" />
            
            <label for= "dto.specialSkill"><strong>Special Skill:</strong></label>
            <s:textfield name="dto.specialSkill" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" maxlength="20" />
            
            <label for= "dto.comment"><strong>Additional Comment:</strong></label>
            <s:textarea name="dto.comment" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>
        </td>
        <td>
            <fieldset>
                <legend>If any of these apply, please check:</legend>
                <label for="dto.isFirstSuccessor">
                    <s:checkbox
                        disabled='%{#session.planAccessControl.isSelectDisabled}'
                        name="dto.isFirstSuccessor"/>
                    First leadership successor (see Guidance)
                </label>
                <label for="dto.isSecondSuccessor">
                    <s:checkbox
                        disabled='%{#session.planAccessControl.isSelectDisabled}'
                        name="dto.isSecondSuccessor"/>
                    Second leadership successor
                </label>
                <label for="dto.isThirdSuccessor">
                    <s:checkbox
                        disabled='%{#session.planAccessControl.isSelectDisabled}'
                        name="dto.isThirdSuccessor"/>
                    Third leadership successor
                </label>
                <label for="dto.isHoldingDelegation">
                    <s:checkbox
                        disabled='%{#session.planAccessControl.isSelectDisabled}'
                        name="dto.isHoldingDelegation"/>
                    Holds formal delegation(s) of authority (describe in "Additional Comment")
                </label>
            </fieldset>
        </td>
    </tr>
</table>
<s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
