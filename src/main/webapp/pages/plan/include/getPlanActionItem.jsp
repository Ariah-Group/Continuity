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

<s:form name="savePlanActionItem" action="savePlanActionItem">

    <s:hidden name="dto.id"/>
    <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
    <s:hidden name="dto.criticalFunction.id"/>
    <s:hidden name="dto.criticalFunction.name"/>
                
    <h1>Action Item Summary</h1>
    
	<table width="99%" id="list_table">
	    <tr>
	        <th>Action Item</th>
	        <td><s:textarea name="dto.name" cols="60" rows="3" /></td>
	    </tr>
	    <tr>
	        <th width="144"><s:property value='#session.systemDomain.displayConstants.criticalUpper' /> Function</th>
	        <td width="510">
	            <!-- edit mode -->
	            <s:if test="dto.id != 0">
	                <s:hidden name="actionItemType"/>
                    <s:if test='dto.type.name() == "C"'>
                        <s:property value="dto.criticalFunction.name"/>
                    </s:if>
                    <s:elseif test='dto.type.name() == "I"'>
                        Information Technology
                    </s:elseif> 
                    <s:elseif test='dto.type.name() == "F"'>
                        <s:property value='#session.systemDomain.displayConstants.facultyPrepareShort' /> Preparedness
                    </s:elseif>
                    <s:else>
                        Not associated with a <s:property value='#session.systemDomain.displayConstants.criticalLower' /> function
                    </s:else>
                </s:if>
                   <!-- add mode -->
                   <s:else>
                    <s:select
                        name="actionItemType" 
                        list="actionItemTypes"
                        listKey="id"
                        listValue="description"/>
                    </s:else>
               </td>
	    </tr>
		<tr>
		    <th>Cost</th>
		    <td>
				<s:select
				    name="dto.cost.id" 
				    list="refListMap['ActionItemCost']"
				    listKey="id"
				    listValue="description"/>
		    </td>
		</tr>
		<tr>
		    <th>Cost is</th>
		    <td>
				<s:select 
				    name="dto.costCycle.id" 
				    list="refListMap['ActionItemCostCycle']"
				    listKey="id"
				    listValue="description"/>
		    </td>
		</tr>
		<tr>
		    <th>Within Whose Scope</th>
		    <td>
				<s:select
				    name="dto.scope.id" 
				    list="refListMap['ActionItemScope']"
				    listKey="id"
				    listValue="description"/>
		    </td>
		</tr>
		<tr>
		    <th>Status</th>
               <td>
                <s:select
                    name="dto.status.id" 
                    list="refListMap['ActionItemStatus']"
                    listKey="id"
                    listValue="description" />
               </td>
		</tr>
		<tr>
		     <th>Comment</th>
		     <td><s:textarea name="dto.comment" cols="60" rows="3"/></td>
		</tr>                       
	</table>
	
    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
           
	<div class="update_button">
        <input type="submit" name="save" value="Save">
    </div>
    
    <s:token />
         
</s:form>