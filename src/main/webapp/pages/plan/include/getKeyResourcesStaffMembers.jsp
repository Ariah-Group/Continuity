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

<s:form action="saveKeyResourcesStaffMember">

    <h1>Staff Basics</h1>

    <table>
      <tr>
        <td>
            <label for="keyStaffBasics.hasEmergencyContactList" class="small">
                <strong>Does your unit have a (printed) emergency contact list for </strong>
                <strong style="text-transform: lowercase"><s:property value='#session.systemDomain.displayConstants.facultyPreparePrint'/> &amp; staff?</strong>
            </label>
			<s:select
			    name="keyStaffBasics.hasEmergencyContactList" 
			    disabled="#session.planAccessControl.isSelectDisabled"
			    list="#{'Y':'yes','N':'no','O':'other (please comment)'}"
			    headerKey=""
			    headerValue="Please select ..."/>
    
            <label for="keyStaffBasics.emergencyContactListHolders" class="small"><strong>Who holds copies of the emergency contact list?</strong> (be specific)</label>
            <s:textarea name="keyStaffBasics.emergencyContactListHolders" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>
            
            <label for="keyStaffBasics.emergencyContactListUpdaters"><strong>Who updates the emergency contact list?</strong></label>
            <s:textarea name="keyStaffBasics.emergencyContactListUpdaters" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>
            
            <label for="keyStaffBasics.voiceMailMessagesCheckers" class="small"><strong>Who knows how to check messages on your department's main phone line?</strong></label>
            <s:textarea name="keyStaffBasics.voiceMailMessagesCheckers" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>
        </td>
        <td>
            <label for="keyStaffBasics.voiceMailGreeters" class="small"><strong>Who knows how to record a greeting on your department's main phone line</strong>?</label>
            <s:textarea name="keyStaffBasics.voiceMailGreeters" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>

            <label for="keyStaffBasics.websiteMessagePosters" class="small"><strong>Who can post messages on your department's web site</strong> (i.e., do the actual mechanics)?</label>
            <s:textarea name="keyStaffBasics.websiteMessagePosters" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>

            <label for="keyStaffBasics.sharedPasswordKeepers" class="small"><strong>Do your staff use any shared passwords that should be kept available?</strong></label>
            <s:textarea name="keyStaffBasics.sharedPasswordKeepers" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>

            <label for="keyStaffBasics.staffBasicsComment" class="small"><strong>Comment?</strong></label>
            <s:textarea name="keyStaffBasics.staffBasicsComment" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" rows="2"/>
        </td>
      </tr>
    </table>

    <s:if test="saveActionType == 1">
        <s:include value="/pages/widget/ActionErrors.jsp" />
    </s:if>
    <div class="button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <s:submit
            name="Save_Section" 
            value="Save This Section"
            onclick="this.form.saveActionType.value=1;"/>
    </div>

    <hr class="divider">

    <s:include value="/pages/plan/include/editKeyResourcesStaffMember.jsp" />

    <div class="add_to_list_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <s:submit
            name="Add_List" 
            value="Add to List"
            onclick="this.form.saveActionType.value=2;"/>
    </div>

    <s:if test="saveActionType != 1">
        <s:include value="/pages/widget/ActionErrors.jsp" />
    </s:if>
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:if test="dtos.size > 0">

	    <strong>Current List:</strong>
	    
	    <table id="stacked_table">
	        <s:iterator value="dtos" status="rowstatus">
	            <tr>
		            <th scope="row">First Name</th>
		            <td><s:property value="firstName"/></td>
		            <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>"><a href="getKeyResourcesStaffMember?rowId=<s:property value='id'/>">Edit</a></td>
		            <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>"><a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Are you sure?');">Delete</a></td>
                    <s:hidden name="dtos[%{#rowstatus.index}].firstName"/>
	            </tr>
	            <tr>
		            <th scope="row">Last Name</th>
		            <td><s:property value="lastName"/></td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
                    <s:hidden name="dtos[%{#rowstatus.index}].lastName"/>
	            </tr>
	            <tr>
		            <th scope="row">Title or Function</th>
		            <td><s:property value="titleOrFunction"/></td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
                    <s:hidden name="dtos[%{#rowstatus.index}].titleOrFunction"/>
	            </tr>
	            <tr>
		            <th scope="row">Special Skill</th>
	                <td><s:property value="specialSkill"/></td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
                    <s:hidden name="dtos[%{#rowstatus.index}].specialSkill"/>
	            </tr>
	            <tr>
		            <th scope="row">Additional Comment</th>
	                <td><s:property value="comment"/></td>
		            <td>&nbsp;</td>
		            <td>&nbsp;</td>
	                <s:hidden name="dtos[%{#rowstatus.index}].comment"/>
	            </tr>
	            <tr>
		            <th scope="row">First successor</th>
		            <td>
		               <s:if test="isFirstSuccessor">Yes</s:if><s:else>No</s:else>
		            </td>
	                <td>&nbsp;</td>
	                <td>&nbsp;</td>
                    <s:hidden name="dtos[%{#rowstatus.index}].isFirstSuccessor"/>
	            </tr>
	            <tr>
		            <th scope="row">Second successor</th>
	                <td>
	                   <s:if test="isSecondSuccessor">Yes</s:if><s:else>No</s:else>
	                </td>
	                <td>&nbsp;</td>
	                <td>&nbsp;</td>
                    <s:hidden name="dtos[%{#rowstatus.index}].isSecondSuccessor"/>
	            </tr>
	            <tr>
		            <th scope="row">Third successor</th>
	                <td>
	                   <s:if test="isThirdSuccessor">Yes</s:if><s:else>No</s:else>
	                </td>
	                <td>&nbsp;</td>
	                <td>&nbsp;</td>
                    <s:hidden name="dtos[%{#rowstatus.index}].isThirdSuccessor"/>
	            </tr>
	            <tr>
		            <th scope="row">Holds formal delegation of authority</th>
	                <td>
	                   <s:if test="isHoldingDelegation">Yes</s:if><s:else>No</s:else>
	                </td>
	                <td>&nbsp;</td>
	                <td>&nbsp;</td>
                    <s:hidden name="dtos[%{#rowstatus.index}].isHoldingDelegation"/>
	            </tr>
	            <s:if test='!#rowstatus.last'>
	                <tr><td colspan="3"><hr /></td></tr>
	            </s:if>        
	        </s:iterator>
	    </table>

    </s:if>

    <s:token />
    
</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesStaffMember">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
