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

<s:form name="saveInformationTechnologyActionItem" action="saveInformationTechnologyActionItem">
    <span class='<s:property value='#session.planAccessControl.noDisplayClass'/>'>
        <!-- edit page -->
        <s:include value="/pages/plan/include/editActionItem.jsp" />
        
        <!-- error line -->
        <s:include value="/pages/widget/ActionErrors.jsp" />
        
        <!-- add button -->
        <s:div cssClass="add_to_list_button">
            <br/>
            <s:submit name="Update" value="Update" title="Update Action Item"/>
        </s:div>
        <br/>
    </span>
    <s:token />
</s:form>