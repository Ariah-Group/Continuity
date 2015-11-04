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

<h1>IT Action Items</h1>       

<a name="bookmark" id="bookmark"></a>
       
<p class="alert">Please ask your department's IT manager (or other tech support person) to 
fill out this page and the subsequent pages in Step 3. If you are not that IT/tech support person, 
please go now to Step 4.</p>

<hr class="leftline">

<p><strong>Action Items</strong> - What can be done to PREPARE?&nbsp; What can your unit (or another
unit, or the  campus) do BEFORE ANY DISASTER STRIKES to lessen its impact on your IT?&nbsp;
Or to make it easier for you to  recover/rebuild your IT. </p>

<s:form name="addInformationTechnologyActionItem" action="addInformationTechnologyActionItem">
    <span class='<s:property value='#session.planAccessControl.noDisplayClass'/>'>

     <s:url action="getInformationTechnologyActionItem" var="editActionItemURL">
        <s:param name="it">true</s:param>
     </s:url>
     <s:set var="deleteActionItemURL" value="'javascript:deleteFormRow('"/>
     
     <!-- edit page -->
     <s:include value="/pages/plan/include/editActionItem.jsp" />
     
     <!-- error line -->
     <s:include value="/pages/widget/ActionErrors.jsp" />
     
     <!-- add button -->
        <s:div cssClass="add_to_list_button">
            <br/>
            <s:submit name="AddToList" value="Add to List" title="Add Action Item to List"/>
        </s:div>
     <br/>
     
    </span>
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />

    <!-- actionItem list -->
    <s:include value="/pages/plan/include/getActionItems.jsp" />
    
    <s:token />
        
</s:form>

<s:form name="DeleteForm" action="deleteInformationTechnologyActionItem">
    <s:hidden id="dRowId" name="rowId"/>
    <s:hidden id="it" name="it" value="true"/>
    <s:token />
</s:form>