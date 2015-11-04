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

<s:if test="newPlan == false">
    <p class="plan">Continuity Plan for <span id="planname"><s:property value="#session.plan.acronymPlusName"/></span></p>
</s:if>

<div id="innertube">

<s:if test="newPlan == true">
	<h1>Create a New Plan</h1>
	<br>
	
	<p class="StandardWidth">What is the name of the unit for which you
	are creating a continuity plan? Enter the name of the specific unit
	whose plan this will be. For example:</p>
	
	<ul class="bulletlist">
		<li>Department of Mathematics</li>
		<li>Orthopaedic Surgery</li>
	</ul>
	<s:set name="execAction" value="'savePlan'"/>
</s:if>
<s:else>
    <h1>Information About Your Department</h1><br>
    <p class="StandardWidth">You can use this screen to update any of the information below.</p>
    <s:set name="execAction" value="'savePlanDepartment'"/>
</s:else>

<s:set var="addClass" value=""/>
<s:set var="isSelectDisabled" value=""/>
<s:set var="isInputReadOnly" value=""/>
<s:set var="noDisplayClass" value=""/>
<s:if test="newPlan == null || newPlan == false">
    <s:set var="addClass" value="#session.planAccessControl.addClass"/>
    <s:set var="isSelectDisabled" value="#session.planAccessControl.isSelectDisabled"/>
    <s:set var="isInputReadOnly" value="#session.planAccessControl.isInputReadOnly"/>
    <s:set var="noDisplayClass" value="#session.planAccessControl.noDisplayClass"/>
</s:if>

<div>
    <p><span class="required">*</span>indicates a required answer</p>
</div>

<s:form id="PlanGeneral" name="PlanGeneral" action="%{#execAction}">

    <div class="FormDivClass">
    
        <ol class="layout">
	    <li>
	       <label for="dto.name"><span class="required">*</span>Name of unit:</label>
	       <s:textfield cssClass="unit_nameClass %{#addClass}" readonly="%{#isInputReadOnly}" name="dto.name" maxlength="256"/>
	       <s:hidden name="dto.id"/>
	    </li>
        <li>
            <label for="dto.majorDivision.id"><span class="required">*</span>On the org chart, this unit reports upward to:</label>
            <s:select 
                name="dto.majorDivision.id" 
                cssClass="divisionSelectClass"
                disabled="%{#isSelectDisabled}" 
                list="adminListMap['MajorDivision']"
                listKey="id"
                listValue="name"
                headerKey="0" 
                headerValue="Please select ..."/>   
        </li>
        <li>
            <label for="dto.acronym.id"><span class="required">
                </span>Acronym: Is this unit within any of the following? (Select "None" if not.) 

            </label>
            <s:select 
                name="dto.acronym.id" 
                cssClass="acronymSelectClass" 
                disabled="%{#isSelectDisabled}" 
                list="adminListMap['Acronym']"
                listKey="id"
                listValue="name"
                headerKey="0" 
                headerValue="None"/>   
        </li>
        <li>
            <label for="dto.departmentHead.firstName"><span class="required">*</span>Head of unit:</label>
	        <table>
		        <thead>
		            <tr>
		                <th scope="col">First Name</th>
		                <th scope="col">Last Name</th>
		                <th scope="col">EMail <span class="AttentionClassNotBold">(official email from campus directory)</span></th>
                        <th scope="col">Title</th>
		                <th scope="col" bgcolor="white" nowrap="nowrap">
		                    <img src="/kcpt/images/spacer.gif" width="134px" height="20px">		                </th>
		            </tr>
		        </thead>
		        <tbody>
		            <tr>
		               <td><s:textfield name="dto.departmentHead.firstName" cssClass="UserFirstNameClass %{#addClass}" readonly="%{#isInputReadOnly}"  maxlength="50"/></td>
	                   <td><s:textfield name="dto.departmentHead.lastName" cssClass="UserLastNameClass %{#addClass}" readonly="%{#isInputReadOnly}"  maxlength="50"/></td>
	                   <td><s:textfield name="dto.departmentHead.emailRegular" cssClass="UserEMailClass %{#addClass}" readonly="%{#isInputReadOnly}" maxlength="75"/></td>
                       <td><s:textfield name="dto.departmentHead.title" cssClass="UserPhoneClass %{#addClass}" readonly="%{#isInputReadOnly}" maxlength="50"/></td>
                       <td></td>
		            </tr>
		        </tbody>
	        </table>
        </li>
        </ol>
        
    </div>

    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <s:if test="newPlan == true">
        <s:set name="onclickHref" value="'/kcpt/plan/getPlans'"/>
        <s:set name="saveBtnName" value="'Create a New Plan'"/>
    </s:if>
    <s:else>
        <s:set name="onclickHref" value="'/kcpt/plan/planHome'"/>
        <s:set name="saveBtnName" value="'Update Plan Org Data'"/>
    </s:else>

    <div class="MyButtonsDivClass">
        <div class="FloatLeft">
            <input id="back"
               class="ButtonClass" 
               type="button" 
               name="back" 
               value="   Back    " 
               onclick="location.href='<s:property value='onclickHref'/>';" 
               alt="Return back"
               title="Return back"/>
        </div>
        <div class="FloatRight">
            <input id="SavePlan"
               class="ButtonClass <s:property value='#noDisplayClass'/>" 
               type="button" 
               name="SavePlan" 
               value=" <s:property value='saveBtnName'/> "
               onclick="SubmitPlan(<s:property value='newPlan'/>, 'unit_nameClass', 'PlanGeneral');" 
               alt="<s:property value='saveBtnName'/>"
               title="<s:property value='saveBtnName'/>"/>
        </div>
    </div>
    <!--closes div-->
    
    <s:hidden name="newPlan"/>
    <s:token />

</s:form>
 
</div>