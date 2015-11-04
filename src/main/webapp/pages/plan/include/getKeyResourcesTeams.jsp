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

<style type="text/css">
<!--
#team_table {   
    margin: 8px 0 8px 0;
    padding-top: 2px;
    padding-right: 2px;
    padding-bottom: 4px;
    padding-left: 2px;
    border: thin solid #CCCCCC;
    width:500px;    
}
#team_table th {
    background-color:#FFF;
    padding: 3px;
    font-weight:bold;
    text-align:left;            
}
#team_table td  {
    background-color:#ECEFF4;
    padding: 3px 4px 3px 0;/*was .5em*/
    vertical-align:top;
}
#team_table th.link {
    background: #D7D7D7;
    width: 12px;        
}
-->
</style>

<s:form action="updateKeyResourcesTeams">

    <h1>Teams</h1>    
    
    <p>Are there teams that will be important to help your department cope with adverse events?</p>
    
    <s:bean name="org.apache.struts2.util.Counter" var="counter">
        <s:param name="last" value="10"/>
    </s:bean>
    
    <s:iterator value="#counter" var="teamIndex" status="rowstatus">
    
        <fieldset>
            <legend>Team <s:property /></legend>
            
            <s:hidden name="teams[%{#rowstatus.index}].id"/>
            <s:hidden name="teams[%{#rowstatus.index}].plan.id" value="%{#session.plan.id}"/>
            
            <label for="teams[<s:property value="#rowstatus.index"/>].name">Team <s:property /> Name</label>
            <s:textfield name="teams[%{#rowstatus.index}].name" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="wide %{#session.planAccessControl.addClass}" maxlength="60"/>
            
            <label for="teams[<s:property value="#rowstatus.index"/>].purpose">Team <s:property /> Purpose</label>
            <s:textarea name="teams[%{#rowstatus.index}].purpose" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="wide %{#session.planAccessControl.addClass}" rows="3"/>
            
            <label for="teams[<s:property value="#rowstatus.index"/>].comment">Team <s:property /> Comment</label>
            <s:textarea name="teams[%{#rowstatus.index}].comment" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="wide %{#session.planAccessControl.addClass}" rows="3"/>

            <br>
            
            <s:if test="teams[#rowstatus.index].teamMembers.size > 0">
            
            <table id="team_table">
              <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
              </tr>
              
              <s:iterator value="teams[#rowstatus.index].teamMembers" status="arowStatus">
                  <tr>
                      <td><s:property value="firstName"/></td>
                      <td><s:property value="lastName"/></td>
                      <td class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                          <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Delete team member: are you sure?');">Delete</a>
                      </td>
                  </tr>
                  <s:hidden name="teams[%{#rowstatus.index}].teamMembers[%{#arowStatus.index}].id"/>
                  <s:hidden name="teams[%{#rowstatus.index}].teamMembers[%{#arowStatus.index}].firstName"/>
                  <s:hidden name="teams[%{#rowstatus.index}].teamMembers[%{#arowStatus.index}].lastName"/>
                  <s:hidden name="teams[%{#rowstatus.index}].teamMembers[%{#arowStatus.index}].teamId"/>
              </s:iterator>
            </table>
            
            </s:if>
                
            <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                <s:submit
                    name="Add_Member_%{#teamIndex}" 
                    value=" Add member to Team %{#teamIndex} " 
                    onclick="this.form.action='saveKeyResourcesTeams?rowNo=%{#teamIndex}'" />
            </span>

        </fieldset>

    </s:iterator>
    
    <br class="clearfloat">

    <s:include value="/pages/widget/ActionErrorsAnchored.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesTeamMember">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
