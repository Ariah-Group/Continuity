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
<!--code specific to these lists
#listcontainer {
	width: 680px;
	margin: 0;
	padding:0;
}
.tag {
	font-size: 9pt;
	font-family:Arial, Helvetica, sans-serif;
    margin: 0 0 0 9px;
}
#listcontainer label {
	font-weight:bold;
	width: 240px;
	margin: 12px 0 0 0;
}
#listcontainer input {
	width: 250px;
	margin:0;
	padding:0;
}
#listcontainer select {
	width: 250px;
	margin:0;
	padding:0;
}
#listcontainer textarea {
	margin:0;
	padding:0;
}
#col1 {
	width: 310px;
	float:left;
	border-right:solid 1px #333;
	clear:both;
	text-align:left;
	padding: 8px 0 0 0;
}
#col2 {
	width: 330px;
	float:right;
	text-align:left;
	vertical-align:top;
	margin:0;
	padding:0;
}
-->
</style>


<h1>Details for This Server</h1>

<s:form action="saveInformationTechnologyServer">

    <s:hidden name="dto.id"/>
    <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>

    <div id="listcontainer">

        <div id="col1">     
            <label for="dto.name">RECOVERY DETAILS FOR:</label>
            <s:textfield name="dto.name" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" maxlength="256"/>
	        <div class="tag">(you may edit the name in this box)</div>
	
	        <label for="dto.type">Server Type:</label>
	        <s:select
	            name="dto.type.id"
	            disabled="%{#session.planAccessControl.isSelectDisabled}"
	            list="types"
	            listValue="value"
	            headerKey=""
	            headerValue="Please select ..."/>
	                     
	        <label for="dto.explanation">Explanation:</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.explanation" rows="3"/>
	
			<label for="dto.backupFrequency.id">Backup Frequency:</label>
			<s:select
			    name="dto.backupFrequency.id"
			    disabled="%{#session.planAccessControl.isSelectDisabled}"
			    list="refListMap['BackupFrequency']"
			    listKey="id"
			    listValue="description"/>
			    	    
	        <label for="dto.backupMedia">Backup Media:</label>
	        <s:select
	            name="dto.backupMedia.id"
	            disabled="%{#session.planAccessControl.isSelectDisabled}"
	            list="backupMedia"
	            listValue="value"
	            headerKey=""
	            headerValue="Please select ..."/>
	            
	        <label for="dto.backupType">Is backup auto or manual?</label>
	        <s:select
	            name="dto.backupType.id"
	            disabled="%{#session.planAccessControl.isSelectDisabled}"
	            list="backupTypes"
	            listValue="value"
	            headerKey=""
	            headerValue="Please select ..."/>
	
	        <label for="dto.applicationsImpacted">Applications impacted by failure of this server:</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.applicationsImpacted" rows="3"/>
	         
	        <label for="dto.departmentsImpacted">Departments impacted by failure of this server:</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.departmentsImpacted" rows="3"/>
	         
	        <label for="dto.serverSoftware">Server software (be specific):</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.serverSoftware" rows="3"/>
	         
	    </div> 
	 
	      
	    <div id="col2">                
	
	        <label for="dto.technicalExperts">Technical expert(s) for this server:</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.technicalExperts" rows="3"/>
	
	        <label for="dto.responsiblePersons">Person(s) responsible for recovery:</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.responsiblePersons" rows="3"/>
	
	        <label for="dto.onsiteLocation">Location of onsite storage (if any):</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.onsiteLocation" rows="3"/>
	
	        <label for="dto.offsiteLocation">Location of offsite storage (if any):</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.offsiteLocation" rows="3"/>
	            
	        <label for="dto.offsiteStorageFrequency">Frequency of offsite storage:</label>
	        <div class="alignmentfix">
	            <s:select
			        name="dto.offsiteStorageFrequency.id"
			        disabled="%{#session.planAccessControl.isSelectDisabled}"
			        list="offsiteStorageFrequencies"
			        listValue="value"
			        headerKey=""
			        headerValue="Please select ..."/>
	        </div>
	             
	        <label for="dto.diskAndDocsLocations">Location of installation disks &amp; documentation:</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.diskAndDocsLocations" rows="3"/>
	            
	        <label for="dto.recoveryResult">Has a successful recovery been done?</label>
	        <s:select
	            name="dto.recoveryResult.id"
	            disabled="%{#session.planAccessControl.isSelectDisabled}"
	            list="recoveryResults"
	            listValue="value"
	            headerKey=""
	            headerValue="Please select ..."/>
	        
	        <label for="dto.recoveryResultExplanation">Explanation or comment for any of the above:</label>
	        <s:textarea readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="%{#session.planAccessControl.addClass}" name="dto.recoveryResultExplanation" rows="3"/>
	
	    </div>
	    
	</div>
	
	<br class="clearfloat" />
	
	<!-- error line -->
	<s:include value="/pages/widget/ActionErrors.jsp" />
	
	<!-- save buttons -->
	<s:include value="/pages/widget/SaveContinueButtons.jsp" />
	
	<s:token />                    
	
</s:form>