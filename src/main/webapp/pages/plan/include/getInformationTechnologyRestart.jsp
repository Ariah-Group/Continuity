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


<s:form action="saveInformationTechnologyRestart">

    <h1>Recovery Strategies</h1>  
    <p class="alert">Please ask your department's IT manager (or other tech support person) to fill out this page and the subsequent pages in Step 3. If you are not that IT/tech support person, please go now to Step 4.</p>
    <hr class="leftlinelong">                   
    <p ><strong>What will you need to restart your IT? Consider this scenario: the department's normal 
    workplace is destroyed or inaccessible. New space, furniture and internet access have been 
    provided by others. How would you handle the following:</strong></p>
          
	<label for="restart.whereToPurchase" class="wide">Where will you quickly purchase new workstations, servers, or other hardware? </label>
	<s:textarea 
	    readonly="%{#session.planAccessControl.isInputReadOnly}" 
	    cssClass="wide %{#session.planAccessControl.addClass}" 
	    name="restart.whereToPurchase" 
	    rows="3"/>
	
	<label for="restart.whenToRebuild" class="wide">When  your support technicians rebuild your workstations or servers in the new location (on the new hardware), where will they find the systems software, applications software, and related documentation that they will need?</label>
	<s:textarea 
	    readonly="%{#session.planAccessControl.isInputReadOnly}" 
	    cssClass="wide %{#session.planAccessControl.addClass}" 
	    name="restart.whenToRebuild" 
	    rows="3"/>
	
	<label for="restart.environmentalRequirements" class="wide">Does your IT equipment have any environmental requirements (air conditioning, high power consumption, unusual physical security, etc.?) </label>
	<s:textarea 
	    readonly="%{#session.planAccessControl.isInputReadOnly}" 
	    cssClass="wide %{#session.planAccessControl.addClass}" 
	    name="restart.environmentalRequirements" 
	    rows="3"/>
	
	<label for="restart.techSupportStaff" class="wide">Will your technical support staff be adequate in numbers &amp; skills to rebuild your systems quickly? Will they be available? Do they have other clients to serve?</label>
	<s:textarea 
	    readonly="%{#session.planAccessControl.isInputReadOnly}" 
	    cssClass="wide %{#session.planAccessControl.addClass}" 
	    name="restart.techSupportStaff" 
	    rows="3"/>
	
	<label for="restart.otherObstacles" class="wide">Are there any other obstacles that could hinder the quick re-establishment of your critical IT services?</label> 
	<s:textarea 
	    readonly="%{#session.planAccessControl.isInputReadOnly}" 
	    cssClass="wide %{#session.planAccessControl.addClass}" 
	    name="restart.otherObstacles" 
	    rows="3"/>
	
	<label for="restart.workFromHome" class="wide">Visualize now a flu pandemic. If all staff were requested to work from home (where possible) for a couple of months to minimize contagion, what would you have to do to enable &amp; support their IT? (Presume the users all have adequate computers at home, plus broadband connections.)&nbsp; Be specific, and estimate how long it would take to get them set up &amp; running.</label>            
	<s:textarea 
	    readonly="%{#session.planAccessControl.isInputReadOnly}" 
	    cssClass="wide %{#session.planAccessControl.addClass}" 
	    name="restart.workFromHome" 
	    rows="3"/>
	
	<label for="restart.workAround" class="wide">When IT systems become unavailable for an extended time, people use workarounds &ndash; paper forms to gather data, snail-mail, chalkboard instead of PowerPoint.&nbsp; In the collection of IT applications &amp; systems that you support, are there any that could not somehow be &ldquo;worked around&rdquo; for a few weeks or months?&nbsp;&nbsp; Explain.</label>            
	<s:textarea 
	    readonly="%{#session.planAccessControl.isInputReadOnly}" 
	    cssClass="wide %{#session.planAccessControl.addClass}" 
	    name="restart.workAround" 
	    rows="3"/>

    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />                    

</s:form>