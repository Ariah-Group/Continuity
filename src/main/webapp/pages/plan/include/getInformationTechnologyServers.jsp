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

<s:form action="addInformationTechnologyServer">
 
    <h1>Servers</h1>

    <a name="bookmark" id="bookmark"></a>

    <p class="alert">Please ask your department's IT manager (or other tech support person) to fill out this page and the subsequent pages in Step 3. If you are not that IT/tech support person, please go now to Step 4.</p>
    
    <hr class="leftline">                            

    <p>Does your unit own any <strong>servers</strong>?</p> 

    <table class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
        <tr>
            <th>Name of Server (OK to group) </th>
            <th>Type of Server </th>
            <th>Explanation, if needed </th>
        </tr>
        <tr>
            <td><s:textfield name="dto.name" size="40"  maxlength="128"/></td>                               
            <td>
		        <s:select
		            name="dto.type.id"
		            list="types"
		            listValue="value"
		            headerKey=""
		            headerValue="Please select ..."/>
                     
            </td>
            <td><s:textarea name="dto.explanation" cols="20" rows="2"/></td>
        </tr>
    </table>

    <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>

    <div class="add_to_list_button">
        <span  class="<s:property value='#session.planAccessControl.noDisplayClass'/>"> 
            <input id="btnAdd" type="submit" name="Save" value="Add to List">
        </span>
    </div>
        
    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />                    
                                    
    <s:if test="dtos.size > 0">
	    <p><strong>Previous Items Entered (<s:property value="dtos.size"/>)</strong></p> 
	    <table id="editplan_table">
	        <tr>
	            <th>Name of Server</th>
	            <th>Type of Server </th>
	            <th id="comment">Explanation</th>
	            <th>&nbsp;</th>
	            <th class="<s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
	        </tr>
	    
	        <s:iterator value="dtos" status="rowstatus">
	            <tr>
	                <td><s:property value="name"/></td>
	                <td><s:property value="type.description"/></td>
	                <td><s:property value="explanation"/></td>
	                <td class="button"><a href="getInformationTechnologyServer?rowId=<s:property value="id"/>">
	                <img src="/kcpt/images/GoToDetail_screen.gif" alt="go to detail screen" border="0"></a></td>
	                <td class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	                   <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Are you sure?');">Delete</a>
	                </td>
	            </tr>
	            <s:hidden name="dtos[%{#rowstatus.index}].id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].name"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].type.id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].type.description"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].explanation"/>
	        </s:iterator>
	    </table>
	</s:if>
	
	<s:token /> 
                                        
</s:form>

<s:form name="DeleteForm" action="deleteInformationTechnologyServer">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
