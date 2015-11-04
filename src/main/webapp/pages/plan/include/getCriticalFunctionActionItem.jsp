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

<h1>Action Items</h1>       

<a name="bookmark" id="bookmark"></a>
       
<p>What can be done to PREPARE?&nbsp; What can your unit (or another unit, or the  campus) do
BEFORE ANY DISASTER STRIKES to lessen its impact on this <s:property value='#session.systemDomain.displayConstants.criticalLower' />
function?&nbsp; Or to make it easier for you  to continue/restart this function?</p>

<s:form name="saveCriticalFunctionActionItem" action="saveCriticalFunctionActionItem">
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
    
    <!-- hidden -->
    <s:hidden name='criticalFunction.id'/>
    <s:hidden name='criticalFunction.name'/>
    <s:hidden name='dto.criticalFunction.id' value='%{criticalFunction.id}'/>
    <s:hidden name='dto.criticalFunction.name' value='%{criticalFunction.name}'/>
    <s:token />
</s:form>