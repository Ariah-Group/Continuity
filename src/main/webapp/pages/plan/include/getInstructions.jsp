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

<s:include value="/pages/custom/%{#session.systemDomain.customUrl}/getInstructions.jsp"/>

<h1>Identify Your Department</h1>           

<a name="bookmark" id="bookmark"></a>   
  
<s:form action="addInstruction">

    <p>This section (Step 4) is for academic departments that provide instruction &ndash; either undergraduate or graduate.</p>
    <div>If your department does not provide instruction, please move to Step 5.</div>
    <br />
    <hr />
    <div class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	    <p>If your department does provide instruction, please pick your department from this list.&nbsp; If necessary, select more than one (see Guidance at right).</p>
	    
	    <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
	    
		<table id="col_layout">
			<tr>
			    <td class="wider_width">
		            <s:select
		                name="dto.instructionalDepartment.id"
		                list="adminListMap['InstructionalDepartment']"
		                listKey="id"
		                listValue="name"
		                headerKey="0"
		                headerValue="Please select your department ..."/>
			    </td>    
			    <td>
			    <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
			        <span class="add_to_list_button">
			            <input name="AddS" type="submit" value="Add to List" />
			        </span>
			    </span>
			    </td>
			</tr>
		</table>
	
	    <br />
	
	</div>
	
    <s:if test="dtos.size > 0">
        <p><strong>Previous entries:</strong></p> 
              
        <table id="editplan_table">
		    <tr>
		        <th>Department</th>
		        <th>&nbsp;</th>
		        <th>&nbsp;</th>
		    </tr>
		    <s:iterator value="dtos" status="rowstatus">
			    <tr>
			        <td><s:property value="instructionalDepartment.name"/></td>
			        <td class="detailbutton_width"><a href="getInstructionHighPriorityCourses?insId=<s:property value='id'/>">
			            <img src="../images/GoToDetail_screen_cf.gif" alt="go to detail screen" border="0"></a>
			        </td>
			        <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
			            <a href="javascript:deleteFormRow(<s:property value='id'/>);" 
			                onclick="javascript:return confirm('Deleting this department will also delete any data that has been entered on the Step 4 Detail Screens for this department.  Do you wish to proceed with the deleteion?');">
			                    delete
			            </a>
			        </td>
			    </tr>
		    </s:iterator>
        </table> 
    
        <div class="alert">Before leaving this screen, please click &quot;Go To Detail Screens.&quot;</div>                
    </s:if>

    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />

    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>

<s:form name="DeleteForm" action="deleteInstruction">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
