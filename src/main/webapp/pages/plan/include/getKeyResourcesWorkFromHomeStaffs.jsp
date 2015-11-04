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

<s:form action="saveKeyResourcesWorkFromHomeStaff">

    <h1>Work from Home<a name="bookmark" id="bookmark">&nbsp;</a></h1>

    <p>Many of us have jobs that could be done (at least partially) from home.&nbsp; 
    Please list below the names of <span style="text-transform: lowercase">
    <s:property value='#session.systemDomain.displayConstants.facultyPreparePrint'/></span> 
    and staff <strong>who could do at least part of their work from home</strong> 
    if they had adequate computers and high-speed internet access. </p>
    
    <p>It is assumed that all faculty belong in this group, so please list them along with staff.</p>

    <table id="rightlist">
        <tr>
            <td class="right">
                <s:checkbox
                    cssClass='inputCheckbox'
                    disabled='%{#session.planAccessControl.isSelectDisabled}'
                    name="workFromHomeStaffBasics.isWorkFromHomeNA"/>
            </td>
            <td>
                <label for="workFromHomeStaffBasics.isWorkFromHomeNA" class="labelCheckbox"><strong>Not applicable</strong>:
                        None of the work that this unit does could be accomplished from home.</label>
            </td>
        </tr>
        <tr>
            <td class="top">
                <label for="workFromHomeStaffBasics.workFromHomeNAExplanation"><strong>Please explain</strong>:</label>
            </td>
            <td>
                <s:textarea name="workFromHomeStaffBasics.workFromHomeNAExplanation" readonly="%{#session.planAccessControl.isInputReadOnly}" cssClass="small %{#session.planAccessControl.addClass}" cols="50" rows="2"/>
                <span class="detail <s:property value='#session.planAccessControl.noDisplayClass'/>"><br />(If you checked the box above, omit the questions below the line.)</span>
            </td>
        </tr>
    </table>

    <hr class="divider">

    <s:include value="/pages/plan/include/editKeyResourcesWorkFromHomeStaff.jsp" />

    <div class="add_to_list_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <s:submit
            name="Add_List" 
            value="Add to List"
            onclick="this.form.saveActionType.value=2;"/>
    </div>

    <s:include value="/pages/widget/ActionErrors.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:iterator value="dtos" status="rowstatus">

        <table id="stacked_table">
            <tr>
                <th scope="col">Name</th>
                <td><s:property value="name"/></td>
                <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>"><a href="getKeyResourcesWorkFromHomeStaff?rowId=<s:property value='id'/>">Edit</a></td>
                <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
                <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Delete home worker: are you sure? ');">Delete</a></td>
             </tr>
            <tr>
                <th scope="col">Position</th>
                <td id="editcell"><s:property value="staffPosition.description"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <th scope="col">Broadband Connection</th>
                <td id="editcell"><s:property value="hasBroadbandConnection.description"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>

            <tr>
                <th scope="col">Currently Connects From Home</th>
                <td id="editcell"><s:property value="doesConnectFromHome.description"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <th scope="col">Office Computer Must Be On</th>
                <td id="editcell"><s:property value="mustOfficeComputerRunning.description"/></td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
               <th scope="col">Comment</th>
               <td><s:property value="comment"/></td>
               <td>&nbsp;</td>
               <td>&nbsp;</td>
           </tr>
        </table>

    </s:iterator>

    <s:token />
    
</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesWorkFromHomeStaff">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
