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
<s:form name="saveCriticalFunctionDescription"
	action="saveCriticalFunctionDescription">

	<h1>Description of this <s:property value='#session.systemDomain.displayConstants.criticalLower' />
	function</h1>

	<ol class="layout">
		<li>
		    <label for="criticalFunction.name" class="wide"><strong><s:property value='#session.systemDomain.displayConstants.criticalUpper' /> Function Name:</strong> </label>
		    <s:textfield
			    name='criticalFunction.name'
			    cssClass='wide %{#session.planAccessControl.addClass}'
			    readonly='%{#session.planAccessControl.isInputReadOnly}' />
		    <div class="description">(you may edit the name in this box)</div>
		</li>
		<li>
		    <label for="criticalFunction.description"><strong>Brief description of this function:</strong></label>
		    <s:textarea
			    readonly='%{#session.planAccessControl.isInputReadOnly}'
			    name="criticalFunction.description"
			    cssClass="wide %{#session.planAccessControl.addClass}"
			    rows="4" />
        </li>
		<li>
		    <label for="criticalFunction.performingUnits"><strong>Name of section or unit that performs this function (if applicable):</strong> </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isInputReadOnly}'
			    name="criticalFunction.performingUnits"
			    cssClass="wide %{#session.planAccessControl.addClass}"
			    rows="4" />
        </li>
		<li>
		    <label for="criticalFunction.responsiblePersons" class="wide"><strong>Responsible person(s) (give names unless this is a generic group):</strong></label>
		    <s:textarea
			    readonly='%{#session.planAccessControl.isInputReadOnly}'
			    name="criticalFunction.responsiblePersons"
			    cssClass="wide %{#session.planAccessControl.addClass}"
			    rows="4" />
	   </li>
	</ol>

	<s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
	<s:include value="/pages/widget/ActionErrors.jsp" />
	<s:include value="/pages/widget/SaveContinueButtons.jsp" />
	<s:token />
</s:form>