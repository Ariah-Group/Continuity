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

<s:form name="savePlanActionItemsStatus" action="savePlanActionItemsStatus">
                
    <h1>Action Item Summary</h1>

    <p>These are the action items you have identified:</p>
    
    <s:if test="dtos.size > 0">
    
        <table id="list_table">
            <s:iterator value="dtos" status="rowstatus">
                <s:url action="getPlanActionItem" var="editActionItemURL">
                    <s:param name="rowId"><s:property value="id"/></s:param>
                    <s:param name="actionItemType"><s:property value="type.name()"/></s:param>
                </s:url>
                <tr>
                    <th>Action Item</th>
                    <td><s:property value="name"/></td>
                    <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
                        <s:a href="%{#editActionItemURL}" title="Edit (%{name}) action item info">Edit</s:a>
                    </td>
                    <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
                        <a href="javascript:deleteFormRow(<s:property value='id'/>);" title="Delete (<s:property value="name"/>})" onclick="return confirm('Delete action item: are you sure?');">Delete</a>
                    </td>
                </tr>
                <tr>
                    <th width="132"><s:property value='#session.systemDomain.displayConstants.criticalUpper' /> Function</th>
                    <td width="439">
                        <s:if test='type.name() == "C"'>
                            <s:property value="criticalFunction.name"/>
                        </s:if>
                        <s:elseif test='type.name() == "I"'>
                            Information Technology
                        </s:elseif> 
                        <s:elseif test='type.name() == "T"'>
                            Instruction
                        </s:elseif> 
                        <s:elseif test='type.name() == "F"'>
                            <s:property value='#session.systemDomain.displayConstants.facultyPrepareShort' /> Preparedness
                        </s:elseif>
                        <s:else>
                           Not associated with a <s:property value='#session.systemDomain.displayConstants.criticalLower' /> function
                        </s:else>
                    </td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th>Cost</th>
                    <td><s:if test='cost.id neq null && cost.id neq ""'><s:property value='cost.description'/></s:if></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th>Cost is</th>
                    <td><s:if test='costCycle.id neq null && costCycle.id neq""'><s:property value='costCycle.description'/></s:if></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th>Within Whose Scope</th>
                    <td><s:if test='scope.id neq null && scope.id neq ""'><s:property value='scope.description'/></s:if></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th>Status</th>
                    <td>
                        <s:select
                            disabled="<s:property value='#session.planAccessControl.isSelectDisabled'/>"
                            name="actionItemStatusMap['%{id}']"
                            size="1" 
                            list="refListMap['ActionItemStatus']"
                            listKey="id"
                            listValue="description"
                            />
                    </td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <th>Comment</th>
                    <td><s:property value="comment"/></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <s:if test='!#rowstatus.last'>
                       <tr><td colspan="5"><hr></td></tr>
                </s:if>
            </s:iterator>
        </table>
    </s:if>
    <s:else>
        -No action items-
    </s:else>                  


    <div id="add_new" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
        You may add action items directly to this list:&nbsp;&nbsp; 
        <s:submit value="Add New Action Item" name="addnew" onclick="this.form.action='getPlanActionItem'"/>
    </div>       

    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />
        
</s:form>

<s:form name="DeleteForm" action="deletePlanActionItem">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>