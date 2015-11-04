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

<div id="innertube">

<h1>Moderator's Approval Screen</h1>

<a name="bookmark" id="bookmark"></a>   

<s:form action="approveNewUsers">

    <p>The following persons have requested user-accounts:</p>

    <s:if test="users.size > 0">
    
    <table id="details">
        <tr>
            <th>Select</th>
            <th>Name</th>
            <th>Email</th>
        </tr>
    
            <s:iterator value="users" status="rowstatus">
                <tr>
                    <s:hidden name="users[%{#rowstatus.index}].id"/>
                    <s:hidden name="users[%{#rowstatus.index}].authId"/>
                    <s:hidden name="users[%{#rowstatus.index}].firstName"/>
                    <s:hidden name="users[%{#rowstatus.index}].lastName"/>
                    <s:hidden name="users[%{#rowstatus.index}].emailRegular"/>
                    <s:hidden name="users[%{#rowstatus.index}].systemDomain.id"/>
                    <td><s:checkbox name="users[%{#rowstatus.index}].isSelected"/></td>
                    <td><s:property value="fullName"/></td>
                    <td><s:property value="emailRegular"/></td>
                </tr>
            </s:iterator>
    </table>
    
    <s:hidden id="thisApprove" name="thisApprove"/> 
      
    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <br/>
    
    <!-- save buttons -->
    <input name="ApproveAccounts" type="button" value="  Approve Selected Accounts  " onclick="this.form.thisApprove.value=1;this.form.submit()" />
    <input name="DenyAccounts" type="button" value="  Deny Selected Accounts  " onclick="this.form.thisApprove.value=2;this.form.submit()" />

    </s:if>
    
    <s:else>
        -- No requests are pending -- 
    </s:else>
    <br/>
    <s:token />
    <s:include value="/pages/widget/BackButton.jsp"/>

</s:form>

</div>