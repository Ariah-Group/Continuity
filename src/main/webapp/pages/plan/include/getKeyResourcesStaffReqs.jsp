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

<s:form action="addKeyResourcesStaffReq">

    <s:include value="/pages/plan/include/editKeyResourcesStaffReq.jsp" />

    <div class="add_to_list_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <input type="submit" name="save" value="Add to List">
    </div>

    <s:include value="/pages/widget/ActionErrors.jsp" />

    <s:include value="/pages/widget/SaveContinueButtons.jsp" />

    <s:if test="dtos.size > 0">

    <s:set var="temp_fte_normal" value="0"/>

	    <table id="staffing_reqs">
	        <tr>
	            <th scope="row" class="c_function">Function</th>
	            <th scope="row" class="amounts">Criti- cality Level</th>
	            <th scope="row" class="staffcats" >Category of staff</th>
	            <th scope="row" class="staffshifts">Shift</th>
	            <th scope="row" class="amounts">FTE required under normal conditions</th>
	            <th scope="row" class="amounts">FTE required during crisis</th>
	            <th scope="row" class="amounts" >FTE who may be available for reassignment (auto-calculated)</th>
	            <th scope="row" id="link" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
	        </tr>
	
	        <s:iterator value="dtos" status="rowstatus">
	            <tr>
	                <td><s:property value="criticalFunction.name"/></td>
	                <td>
                        <s:property value="criticalFunction.criticalityLevel.levelNo.id"/>
	                </td>
	                <td><s:property value="staffCategory.name"/></td>
	                <td><s:property value="shift.name"/></td>
	                <td><s:text name="dto.fte"><s:param name="value" value="fteNormal"/></s:text></td>
	                <td><s:text name="dto.fte"><s:param name="value" value="fteCrisis"/></s:text></td>
	                <td><s:text name="dto.fte"><s:param name="value" value="%{fteNormal - fteCrisis}"/></s:text></td>
                    <td width="8%" class="editordelete <s:property value='#session.planAccessControl.noDisplayClass'/>">
                        <a href="getKeyResourcesStaffReq?rowId=<s:property value='id'/>">Edit</a>
                    </td>
	                <td width="8%" class="editordelete <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                    <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Delete staffing requirements: are you sure? ');">Delete</a>
	                </td>
	            </tr>
	            <s:set var="temp_fte_normal" value="%{#temp_fte_normal + fteNormal}"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].criticalFunction.id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].criticalFunction.name"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].criticalFunction.criticalityLevel.id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].criticalFunction.criticalityLevel.description"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].staffCategory.id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].staffCategory.name"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].shift.id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].shift.name"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].fteNormal"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].fteCrisis"/>
	        </s:iterator>
	        <tr>
	            <td colspan="4" align="right"><strong>Total FTE required under normal conditions:</strong></td>
	            <td><s:text name="dto.fte"><s:param name="value" value="#temp_fte_normal"/></s:text></td>
	            <td>&nbsp;</td>
	            <td>&nbsp;</td>
	            <td>&nbsp;</td>
                <td>&nbsp;</td>
	        </tr>
	    </table>
    
    </s:if>

    <s:token />
    
</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesStaffReq">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
