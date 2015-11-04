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

<s:form name="saveCriticalFunctionCopingMethod"
    action="saveCriticalFunctionCopingMethod">
       
	<h1>How to Cope</h1>

	<p>The following questions ask you to visualize the conditions that
	might prevail in the weeks or months following a disaster. You may be
	missing certain key resources, such as</p>
	
	<table>
		<tr>
			<td width="220px">
				<ul class="bulletlist">
					<li>Your usual space</li>
					<li>Some of your staff</li>
					<li>Certain equipment</li>
					<li>A key vendor</li>
				</ul>
			</td>
			<td>
				<ul class="bulletlist">
					<li>Power</li>
					<li>Phone service</li>
					<li>Network access</li>
					<li>Certain data</li>
					<li>etc.</li>
				</ul>
			</td>
		</tr>
	</table>
	
	<p>Please answer the questions below using only <strong>one-to-several
	bullets or sentences each</strong>. Give ideas, not detailed procedures.</p>

	<ol class="layout">
	
		<li>
		    <label for="criticalFunction.copingMethod.space">
			    <strong>Space</strong>:
			    How would you carry out this <s:property value='#session.systemDomain.displayConstants.criticalLower'/>
			    function if your usual space is not available?
		    </label>
			<s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.space"
			    cssClass="wide %{#session.planAccessControl.addClass}"
			    rows="3"/>
		</li>
		
		<li>
		    <label for="criticalFunction.copingMethod.staff" class="wide">
		        <strong>Staff</strong>:
				How would you carry out this <s:property value='#session.systemDomain.displayConstants.criticalLower'/>
				function if, for couple of months, your average absence rate of faculty &amp; 
				staff were 50%? This could easily be the case in a flu pandemic.
			</label> 
			<s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.staff"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>
		
		<li>
		    <label for="criticalFunction.copingMethod.uniqueSkills" class="wide">
		        <strong>Unique Skills</strong>: 
		        Does the successful performance of this <s:property value='#session.systemDomain.displayConstants.criticalLower'/> 
		        function require the skills or knowledge of any one particular staff member (or her files)? If so, how will you 
		        deal with her absence? Cross-train a co-worker in advance? Outsource? Some other strategy? 
		    </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.uniqueSkills"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>

		<li>
		    <label for="criticalFunction.copingMethod.workAtHome" class="wide">
		        <strong>Working at Home</strong>: 
		        Visualize an environment of contagious illness. Suppose the campus requested that as many faculty &amp; 
		        staff as possible work from home for a month or two (stay away from campus to minimize contagion). Can you
		        perform this <s:property value='#session.systemDomain.displayConstants.criticalLower'/> function with some 
		        (or all) staff working from home? What equipment, supplies, and arrangements would be needed?
		    </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.workAtHome"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>
		
		<li>
		    <label for="criticalFunction.copingMethod.networkAccess" class="wide">
		        <strong>Network Access</strong>: 
		        How would you carry out this <s:property value='#session.systemDomain.displayConstants.criticalLower'/> 
		        function if the data network is not available? 
		    </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.networkAccess"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>

		<li>
		    <label for="criticalFunction.copingMethod.showStoppers" class="wide">
		        <strong>Show Stoppers</strong>: 
		        Is there any resource that is so important or irreplaceable that you CANNOT perform this function without it?
		    </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.showStoppers"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>

		<li>
		    <label for="criticalFunction.copingMethod.campusClosure" class="wide">
		        <strong>Campus Closure</strong>: 
		        Visualize that, during a flu pandemic, the campus officially closes, with all operations (except non-stoppable
		        activities) to cease for at least a month. Is it possible for your unit to simply cease doing this 
		        <s:property value='#session.systemDomain.displayConstants.criticalLower'/> function? 
		    </label> 
		    <s:select
			    disabled='%{#session.planAccessControl.isSelectDisabled}'
			    name='criticalFunction.copingMethod.campusClosure'
			    list='{"Yes", "No", "Not sure"}'
			    headerKey=""
			    headerValue="Please select ..."/>
		</li>

		<li>
		    <label for="criticalFunction.copingMethod.comment" class="wide">
		        <strong>Comment?</strong>
		    </label>
		    <s:textarea
		        readonly='%{#session.planAccessControl.isReadOnly}' 
		        name="criticalFunction.copingMethod.comment"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>

		<li>
		    <label for="criticalFunction.copingMethod.risk" class="wide">
		        <strong>Risk</strong>:
		        Will any of your above suggestions expose the institution to risk? If so, can you suggest how to mitigate/control 
		        this risk?
		    </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.risk"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>
			
		<li>
		    <label for="criticalFunction.copingMethod.policyExceptions" class="wide">
		        <strong>Policy Exceptions:</strong> 
		        What policy exceptions might be needed to carry out your above suggestions? Who would have the authority 
		        to grant them? 
		    </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.policyExceptions"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
		</li>

		<li>
		    <label for="criticalFunction.copingMethod.vulnerabilities" class="wide">
			    <strong>Additional Vulnerabilities</strong>: 
			    Is there anything ELSE that could prevent you from continuing or restarting this function?
		    </label> 
		    <s:textarea
			    readonly='%{#session.planAccessControl.isReadOnly}' 
			    name="criticalFunction.copingMethod.vulnerabilities"
			    cssClass="wide %{#session.planAccessControl.addClass}" 
			    rows="3"/>
	    </li>

	</ol>
	
	<s:hidden name='cfNav' />
	<s:hidden name='criticalFunction.id' />
	<s:hidden name='criticalFunction.name' />
       <s:hidden name='criticalFunction.copingMethod.equipment' value='""' />
       <s:hidden name='criticalFunction.copingMethod.timing' value='""' />
	<s:include value="/pages/widget/ActionErrors.jsp" />
	<s:include value="/pages/widget/SaveContinueButtons.jsp" />
	<s:token />
	
</s:form>