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
<s:if test='dtos.size() > 0'>
	<strong> Previous Items Entered</strong>
	<table id="editplan_table">
		<tr>
			<th scope="col">Action Item</th>
			<th scope="col">Within Whose Scope</th>
			<th scope="col" class="cost">Cost</th>
			<th scope="col" class="cost">Cost is</th>
			<th scope="col">Comment</th>
			<th scope="col" class="link">&nbsp;</th>
			<th scope="col" class="link">&nbsp;</th>
		</tr>
		<s:iterator value="dtos" status="rowstatus">
			<tr>
				<td><s:property value='name'/></td>
				<td><s:if test='scope.id neq null && scope.id neq ""'><s:property value='scope.description'/></s:if></td>
				<td><s:if test='cost.id neq null && cost.id neq ""'><s:property value='cost.description'/></s:if></td>
				<td><s:if test='costCycle.id neq null && costCycle.id neq""'><s:property value='costCycle.description'/></s:if></td>
				<td><s:property value='comment'/></td>
				<td class='<s:property value='#session.planAccessControl.noDisplayClass'/>'>
                    <s:a href="%{#editActionItemURL + '&rowId=' + id}" title="Edit (%{name}) action item info">Edit</s:a>
				</td>
                <td class='<s:property value='#session.planAccessControl.noDisplayClass'/>'>
                    <s:a href="%{#deleteActionItemURL + id + ')'}" title="Delete (%{name})" onclick="return confirm('Delete action item: are you sure?');">Delete</s:a>
                </td>
			</tr>
            <s:hidden name='dtos[%{#rowstatus.index}].id'/>
            <s:hidden name='dtos[%{#rowstatus.index}].name'/>
            <s:hidden name='dtos[%{#rowstatus.index}].cost.id'/>
            <s:hidden name='dtos[%{#rowstatus.index}].cost.description'/>
            <s:hidden name='dtos[%{#rowstatus.index}].costCycle.id'/>
            <s:hidden name='dtos[%{#rowstatus.index}].costCycle.description'/>
            <s:hidden name='dtos[%{#rowstatus.index}].scope.id'/>
            <s:hidden name='dtos[%{#rowstatus.index}].scope.description'/>
            <s:hidden name='dtos[%{#rowstatus.index}].status.id'/>
            <s:hidden name='dtos[%{#rowstatus.index}].status.description'/>
            <s:hidden name='dtos[%{#rowstatus.index}].comment'/>
		</s:iterator>
	</table>
</s:if>