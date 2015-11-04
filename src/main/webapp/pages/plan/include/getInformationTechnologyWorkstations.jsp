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
<s:form action="saveInformationTechnologyWorkstations">       
        
    <h1>Workstations</h1> 
    <p class="alert">Please ask your department's IT manager (or other tech support person) to fill out this page and the subsequent pages in Step 3. If you are not that IT/tech support person, please go now to Step 4.</p>
    <hr class="leftline">
    <p>Please  describe the current state of <strong>WORKSTATION BACKUP PROCEDURES</strong> in your department or other unit. Estimate the percentages - do not do a survey.</p>
    
    <s:set name="percentList" value='{"0%","5%","10%","15%","20%","25%","30%","35%","40%","45%","50%","55%","60%","65%","70%","75%","80%","85%","90%","95%","100%"}'/> 
    
    <table id="details">
        <tr>
            <th>Backup Method for Workstations </th>
            <th  width="120px">% of Users in Your Unit Who Back Up Their Files in This Way </th>
            <th>Comment, if needed</th>
        </tr>
          
        <tr>
            <td><label for="workstation.backupMethodss['FILE'].percentUsers">Files are stored on dept. server, which gets backed up.</label></td>
            <td>
                <s:select 
                    name="workstation.backupMethods['FILE'].percentUsers"
                    list='%{#percentList}'
                    disabled='#session.planAccessControl.isSelectDisabled'
                    headerKey=""
                    headerValue="Please select ..."/>
            </td>
            <td colspan="2">
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.backupMethods['FILE'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
          
        <tr>
            <td><label for="workstation.backupMethods['CENTRAL'].percentUsers">Automated backup by central IT (via network)</label></td>
            <td>
                <s:select 
                    name="workstation.backupMethods['CENTRAL'].percentUsers"
                    list='%{#percentList}'
                    disabled='#session.planAccessControl.isSelectDisabled'
                    headerKey=""
                    headerValue="Please select ..."/>
            </td>
            <td colspan="2">
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.backupMethods['CENTRAL'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
          
        <tr>
            <td><label for="workstation.backupMethods['LOCAL_AUTO'].percentUsers">Local backup of workstation by user (automatic) </label></td>
            <td>
                <s:select 
                    name="workstation.backupMethods['LOCAL_AUTO'].percentUsers"
                    list='%{#percentList}'
                    disabled='#session.planAccessControl.isSelectDisabled'
                    headerKey=""
                    headerValue="Please select ..."/>
            </td>
            <td colspan="2">
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.backupMethods['LOCAL_AUTO'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
          
        <tr>
            <td><label for="workstation.backupMethods['LOCAL_MANUAL'].percentUsers">Local backup of workstation by user (manual) </label></td>
            <td>
                <s:select 
                    name="workstation.backupMethods['LOCAL_MANUAL'].percentUsers"
                    list='%{#percentList}'
                    disabled='#session.planAccessControl.isSelectDisabled'
                    headerKey=""
                    headerValue="Please select ..."/>
            </td>
            <td colspan="2">
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.backupMethods['LOCAL_MANUAL'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
          
        <tr>
            <td><label for="workstation.backupMethods['OTHER'].percentUsers">Other (describe)</label></td>
            <td>
                <s:select 
                    name="workstation.backupMethods['OTHER'].percentUsers"
                    list='%{#percentList}'
                    disabled='#session.planAccessControl.isSelectDisabled'
                    headerKey=""
                    headerValue="Please select ..."/>
            </td>
            <td colspan="2">
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.backupMethods['OTHER'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
          
        <tr>
            <td><label for="workstation.backupMethods['NONE'].percentUsers">No backup</label></td>
            <td>
                <s:select 
                    name="workstation.backupMethods['NONE'].percentUsers"
                    list='%{#percentList}'
                    disabled='#session.planAccessControl.isSelectDisabled'
                    headerKey=""
                    headerValue="Please select ..."/>
            </td>
            <td colspan="2">
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.backupMethods['NONE'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
          
        <tr>
            <td><label for="workstation.backupMethods['UNKNOWN'].percentUsers">Don't know </label></td>
            <td>
                <s:select 
                    name="workstation.backupMethods['UNKNOWN'].percentUsers"
                    list='%{#percentList}'
                    disabled='#session.planAccessControl.isSelectDisabled'
                    headerKey=""
                    headerValue="Please select ..."/>
            </td>
            <td colspan="2">
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.backupMethods['UNKNOWN'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
          
    </table> 

    <hr>
    
    <p><strong>Who Provides Your Workstation Support?</strong> &nbsp;&nbsp;<strong>Give name of group or organization. &nbsp;&nbsp;Comment if needed.</strong></p>
    
    <table id="details">
    
        <tr>
            <td>
	            <s:checkbox
	                name="workstation.techSupports['DEPT'].isSupported"
	                disabled='%{#session.planAccessControl.isSelectDisabled}'/>
	        </td>
	        <td>Technicians employed by department</td>
            <td>
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.techSupports['DEPT'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
                       
        <tr>
            <td>
                <s:checkbox
                    name="workstation.techSupports['OTHER_DEPT'].isSupported"
                    disabled='%{#session.planAccessControl.isSelectDisabled}'/>
            </td>
            <td>Technicians from another department</td>
            <td>
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.techSupports['OTHER_DEPT'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
                       
        <tr>
            <td>
                <s:checkbox
                    name="workstation.techSupports['VENDOR'].isSupported"
                    disabled='%{#session.planAccessControl.isSelectDisabled}'/>
            </td>
            <td>    External vendor</td>
            <td>
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.techSupports['VENDOR'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
                       
        <tr>
            <td>
                <s:checkbox
                    name="workstation.techSupports['OTHER'].isSupported"
                    disabled='%{#session.planAccessControl.isSelectDisabled}'/>
            </td>
            <td>Other (describe)</td>
            <td>
                <s:textarea 
                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                    cssClass="%{#session.planAccessControl.addClass}" 
                    name="workstation.techSupports['OTHER'].comment" 
                    cols="40" 
                    rows="2"/>
            </td>
        </tr>
        
    </table>
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />                    
                                    
</s:form>