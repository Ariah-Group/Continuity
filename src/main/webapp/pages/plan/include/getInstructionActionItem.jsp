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
       
<p>The previous four screens have raised numerous issues that affect
our readiness to continue teaching under adverse circumstances. Please
focus on some of these issues and answer the following question &ndash;
</p>

<p>What can your department do <strong>before any disaster
strikes</strong> to become more ready to continue the curriculum? Please list
these action items below. See the Guidance at right.</p>

<s:form name="saveInstructionActionItem" action="saveInstructionActionItem">
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
    <s:hidden name='insId'/>
    <s:hidden name="deptName"/>
    <s:hidden name='dto.instruction.id' value='%{insId}'/>
    
    <s:token />
</s:form>