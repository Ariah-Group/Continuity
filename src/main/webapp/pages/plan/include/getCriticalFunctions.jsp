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

<style type="text/css">
<!--
.floatright {
    float:right;
    padding: 3px;
}
-->
</style>
<s:include value="/pages/custom/%{#session.loginSystemDomain.customUrl}/getCriticalFunctions.jsp"/>
<h1>Identify Your <s:property value='#session.systemDomain.displayConstants.criticalUpper'/> Functions</h1>
<a name="bookmark" id="bookmark"></a>
<p>Name the major functions that your unit NORMALLY performs. See Guidance at right.</p>

<span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	<s:form name="addInstruction" action="addCriticalFunction"> 
		<s:if test="#session.systemDomain.settings.isInstructionVisible == true">
			(1) <strong>INSTRUCTION:</strong> Does your unit <strong>provide instruction</strong> (undergrad or grad)?  If so, press here:
			<div class="floatright">
				<s:hidden name="addCriticalFunctionName" value="Instruction"/>
				<s:submit name="AddIN" title="Add Instruction to list" value='Add "Instruction" to List' />
			</div>
			<br class="clearfloat" />
		</s:if>
        <s:iterator value='criticalFunctions' status='rowstatus'>
            <s:hidden name='criticalFunctions[%{#rowstatus.index}].id'/>
            <s:hidden name='criticalFunctions[%{#rowstatus.index}].name'/>
            <s:hidden name='criticalFunctions[%{#rowstatus.index}].plan.id'/>
            <s:hidden name='criticalFunctions[%{#rowstatus.index}].priority'/>
            <s:hidden name='criticalFunctions[%{#rowstatus.index}].criticalityLevel.levelNo.id'/>
        </s:iterator>
        <s:token />
	</s:form>
	
	<s:form id="addCriticalFunction" name="addCriticalFunction" action="addCriticalFunction"> 
	    <s:if test="#session.systemDomain.settings.isInstructionVisible == true">
	        <label for="addCriticalFunctionName">(2) <strong>OTHER FUNCTIONS:</strong> Name your unit's other functions.  After each, press here:</label>
	        <div class="floatright">
	            <s:textfield name="addCriticalFunctionName" size="70" maxlength="60" onkeypress="return handleEnter(this, event)"/>
	            <s:submit name="addCriticalFunction" value="Add Other Function to List"/>
	        </div>
            <br class="clearfloat" />
	    </s:if>
	    <s:else>
	        <label for="addCriticalFunctionName">Enter those functions here.  After each, press &quot;Add to List&quot;.</label>
	        <s:textfield name="addCriticalFunctionName" size="70" maxlength="60" onkeypress="return handleEnter(this, event)"/>
	        <s:submit name="addCriticalFunction" value="Add to List"/>
	    </s:else>
        <s:iterator value='criticalFunctions' status='rowstatus'>
	        <s:hidden name='criticalFunctions[%{#rowstatus.index}].id'/>
	        <s:hidden name='criticalFunctions[%{#rowstatus.index}].name'/>
	        <s:hidden name='criticalFunctions[%{#rowstatus.index}].plan.id'/>
            <s:hidden name='criticalFunctions[%{#rowstatus.index}].priority'/>
            <s:hidden name='criticalFunctions[%{#rowstatus.index}].criticalityLevel.levelNo.id'/>
        </s:iterator>
        <s:token />
	</s:form>
</span>

<s:form id="saveCriticalFunctions" name="saveCriticalFunctions" action="saveCriticalFunctions"> 
    <s:if test='criticalFunctions.size > 0'>
        <table id="editplan_table" cellspacing="2" >
            <tr>
                <th scope="col">Sort</th>
                <th scope="col">Function</th>
                <th scope="col" colspan="3"><span class="required">*</span>Level of Criticality (see Guidance at right)</th>
            </tr>
            
            <s:iterator value='criticalFunctions' status='rowstatus'>
                <tr>
                 <td>
                     <s:textfield 
                         cssClass="%{#session.planAccessControl.addClass}" 
                         readonly="#session.planAccessControl.isInputReadOnly"
                         name="criticalFunctions[%{#rowstatus.index}].priority"
                            size="3" 
                            maxlength="4" 
                        />
                     <s:hidden name='criticalFunctions[%{#rowstatus.index}].id'/>
                     <s:hidden name='criticalFunctions[%{#rowstatus.index}].name'/>
                     <s:hidden name='criticalFunctions[%{#rowstatus.index}].plan.id'/>
                 </td>
                 <td>
                     <s:property value='name'/>
                 </td>
                 <td scope="row" id="editcell">
                     <s:set var="levelsList" value="criticalityLevels"/>
                     <s:if test="#session.systemDomain.settings.isInstructionVisible == true && name == 'Instruction'">
                         <s:set var="dtlScript" value="%{'changeCriticalFunctionLevel(\\''+#rowstatus.index+'\\',this.value);'}"/>
                     </s:if>
                     <s:elseif test="#session.systemDomain.settings.isCriticalLevelDetailsVisible == true">
                         <s:set var="dtlScript" value="%{'changeCriticalFunctionLevel(\\''+#rowstatus.index+'\\',this.value);'}"/>
                     </s:elseif>
                     <s:else>
                         <s:set var="dtlScript" value="%{'DetailsShowHide(this.value,\\'ButtonOnly'+#rowstatus.index+'\\',\\'TextOnly'+#rowstatus.index+'\\',\\'NoToDisplay\\'); changeCriticalFunctionLevel(\\''+#rowstatus.index+'\\');'}"/>
                     </s:else>
                     <s:select
                         name="criticalFunctions[%{#rowstatus.index}].criticalityLevel.levelNo.id"
                         disabled="#session.planAccessControl.isSelectDisabled"
                         required="yes"
                         onchange="%{#dtlScript}"
                         list="%{#levelsList}"
                         listKey="levelNo.id"
                         listValue="description"
                         headerKey="0"
                         headerValue="Please select ..."
                     />
                 </td>
                 <s:if test="#session.systemDomain.settings.isInstructionVisible == true && name == 'Instruction'">
                     <s:set name='ShowHide1' value='"NoToDisplay"'/>
                     <s:set name='ShowHide2' value= '""'/>
                 </s:if>
                 <s:elseif test="#session.systemDomain.settings.isCriticalLevelDetailsVisible == true">
                     <s:set name='ShowHide1' value='""'/>
                     <s:set name='ShowHide2' value='"NoToDisplay"'/>
                 </s:elseif>
                 <s:elseif test='criticalityLevel.levelNo.id == "1" || criticalityLevel.levelNo.id == "2" || criticalityLevel.levelNo.id == "3"'>  
                     <s:set name='ShowHide1' value='""'/>
                     <s:set name='ShowHide2' value='"NoToDisplay"'/>
                 </s:elseif>
				 <s:else>
                     <s:set name='ShowHide1' value='"NoToDisplay"'/>
                     <s:set name='ShowHide2' value= '""'/>
				 </s:else>
                 <td scope="row" id="editcell">
					<span id="ButtonOnly<s:property value='#rowstatus.index'/>" class="<s:property value='#ShowHide1'/>">
					    <s:submit
					       action="getCriticalFunctionDescriptions"
					       title="go to detail screens"
					       type="image"
					       src="/kcpt/images/GoToDetail_screen_cf.gif"
					       onclick="this.form.criticalFunctionId.value=%{id};this.form.saveType.value=2;"
					    />
					</span>
                    <span id="TextOnly<s:property value='#rowstatus.index'/>" class="<s:property value='#ShowHide2'/>">
                        <s:if test="#session.systemDomain.settings.isInstructionVisible == true && name == 'Instruction'">
	                        <div align="center">
	                            Detail will be<br />
	                            requested later<br />
	                            (in Step 4)
	                        </div>
                        </s:if>
                        <s:else>
                            <div align="center">Detail not required</div>
                        </s:else>
                    </span>
                 </td>
                 <td>
                     <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                         <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Are you sure you want to delete this function and all related information?');">Delete</a>
                     </span>
                 </td>
                </tr>
            </s:iterator>
            <tr>
             <td colspan="5">
                 <div id="button" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                     <input type="submit" name="Reorder" value="Reorder List">
                 </div>
             </td>
            </tr>
        </table>                                    
    </s:if>
    <s:hidden name="criticalFunctionId" value="0"/>
    <s:include value="/pages/widget/ActionErrors1.jsp"/>                   
    <s:include value="/pages/widget/SaveContinueButtons.jsp"/>
    <s:token />
</s:form>

<s:form name="DeleteForm" action="deleteCriticalFunction">
    <s:hidden id="dRowId" name="criticalFunctionId"/>
    <s:token />
</s:form>    
