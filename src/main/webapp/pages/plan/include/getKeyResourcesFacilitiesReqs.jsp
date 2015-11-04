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

<s:form action="saveKeyResourcesFacilitiesReqs">
    
    <h1>Facilities &amp; Transportation</h1>    
 
    <a name="bookmark" id="bookmark"></a>

    <label for=facilitiesNeeds><strong>Facilities: </strong>List any special space or facilities needs that are IN ADDITION TO your office/classroom/lab needs. Be brief. Explain if necessary.</label>
    <s:textarea
        readonly="%{#session.planAccessControl.isInputReadOnly}"
        cssClass="wide %{#session.planAccessControl.addClass}"
        name="facilitiesNeeds"
        rows="4"/>
        
    <p class="<s:property value='#session.planAccessControl.noDisplayClass'/>"><strong>Utilities: </strong> Please indicate, using this drop-down list, the utilities that are very important to the functioning of your department.</p>
        
    <table class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
        <tr>
            <td>
                <label for="utilId"><strong>Select important utilities</strong></label>
                <s:select
                    name="utilId"
                    list="adminListMap['Utility']"
                    listKey="id"
                    listValue="name"
                    headerKey="0"
                    headerValue="Please select ..."/>
            </td>
            <td>
                <label for="utilComment"><strong>Comment</strong></label>
			    <s:textarea
			        name="utilComment"
			        cols=""
			        rows="2"/>
            </td>
        </tr>
    </table>

    <div class="add_to_list_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <s:submit
            name="Add" 
            value="Add to List"
            onclick="this.form.saveActionType.value=1;"/>
        
    </div>

    <table id="editplan_table">
        <tr>
            <th scope="col">Utility Name</th>
            <th scope="col">Comment?</th>
            <th scope="col" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
        </tr>
        <s:iterator value="utilities">
          <tr>
            <td width="34%"><s:property value="utility.name"/></td>
            <td width="60%"><s:property value="comment"/></td>
            <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>" >
                <a href="javascript:deleteFormRow(<s:property value='utility.id'/>)">Delete</a></td>
          </tr>
        </s:iterator>
    </table>

	<label for="transporationNeeds"><strong>Transportation: </strong></label>List any special transportation needs.<br>
    <s:textarea
        readonly="%{#session.planAccessControl.isInputReadOnly}"
        cssClass="wide %{#session.planAccessControl.addClass}"
        name="transporationNeeds"
        rows="4"/>
        
	<label for="otherResourcesNeeds"><strong>Other Resources:</strong> 
	    Are there any OTHER resources you will need to continue/resume your <s:property value="#session.systemDomain.displayConstants.criticalLower"/> functions?</label>
	<ul class="bulletlist">
	     <li>Do not list funds.</li>
	     <li>List staff ONLY IF you will need temporary staff - for recovery - in addition to your current staff.</li>
	</ul>
    <s:textarea
        readonly="%{#session.planAccessControl.isInputReadOnly}"
        cssClass="wide %{#session.planAccessControl.addClass}"
        name="otherResourcesNeeds"
        rows="4"/>
        
	<p>This is the end of the questionnaire.  Please hit "Save".</p>
	<p>You may return to previous screens at any time to edit, or to answer questions you have skipped.</p>
	<p>The final index tab above (<em>Action Item Summary</em>) will display your complete list of 
	Action Items - your department's TO-DO LIST FOR READINESS. </p>
    
	<p><strong>Please record the completion of your plan on the  <a href="planReviewComplete">Mark Your Plan Complete</a> screen.</strong> This is important.</p> 
  
    <p><strong>Please note: Marking your plan "complete" does not require that every on-screen box be filled in, or that your action items have been performed.</strong>  It DOES signify your judgment that this plan and its action items will help your unit to become more resilient against disaster (hence more able to continue functioning).</p>  

    <s:include value="/pages/widget/ActionErrors.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesUtility">
    <s:hidden id="dRowId" name="utilId"/>
    <s:token />
</s:form>
