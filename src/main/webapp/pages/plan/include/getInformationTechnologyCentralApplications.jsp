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

<h1>Centrally-Owned Applications</h1>           

<a name="bookmark" id="bookmark"></a>   
  
<p>Listed below are some applications owned by the central IT department.  For each, please indicate <strong>how critical the availability of that application would be FOR YOUR DEPARTMENT while you are recovering from disaster.</strong> </p>
<p>The levels of criticality are similar to the levels that you used earlier to classify your <s:property value='#session.systemDomain.displayConstants.criticalLower' /> functions.  See the Guidance at right for expanded definitions.</p>

<s:form name="saveInformationTechnologyCentralApplications" action="saveInformationTechnologyCentralApplications">

	<div class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	
	   <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
	                          
	    <table>
	        <tr>
	            <td>
	                <label for="dto.centralApplication.id"><strong>Centrally Owned Applications</strong>:</label>
	                <s:select
	                    name="dto.centralApplication.id"
	                    list="adminListMap['CentralApplication']"
	                    listKey="id"
	                    listValue="name"
	                    headerKey="0"
	                    headerValue="Please select ..."/>
	            </td>
	            <td>
	                <label for="dto.comment"><strong>Comment</strong></label>
	                <s:textarea name="dto.comment" cols="" rows="2" cssClass="comment"/>
	            </td>
	        </tr>
	    </table>
	    
	    <div class="add_to_list_button">
	        <s:submit name="AddS" value="Add to List" onclick="this.form.saveActionType.value=1;"/>
	    </div>
	                             
	    <p>Are there any <strong>other</strong> centrally-owned applications that should be on this list?</p>   
	    <p>(Centrally-owned means that Central IT is the technical owner.  The functional owner could be any department.)</p>
	    
	    <table>
	        <tr>
	            <td>
	                <label for="newDTO.centralApplication.name"><strong>Name of Application or System</strong>:</label>
	                <s:textfield name="newDTO.centralApplication.name" size="50" maxlength="50"/>
	            </td>
	            <td>
	                <label for="newDTO.comment"><strong>Comment</strong></label>
	                <s:textarea name="newDTO.comment" cols="" rows="2" cssClass="comment"/>
	            </td>
	        </tr>   
	    </table>
	            
	    <div class="add_to_list_button">
	        <s:submit name="AddU" value="Add to List" onclick="this.form.saveActionType.value=2;"/>
	    </div>
	
	    <div class="FloatRight requiredSmall">
            <s:if test="dtos.size > 0">
    	        <div>Before leaving, please select levels of criticality on the list below.</div>
	        </s:if>
	    </div>
	    <br/>

	</div>
	
    <!-- error line -->
    <br/>
    <s:include value="/pages/widget/ActionErrors.jsp" />
    <br/>
        
	<!-- save buttons -->
	<s:include value="/pages/widget/SaveContinueButtons.jsp" />
	    
	
	<s:if test="dtos.size > 0">
	    <table id="editplan_table">
	    <tr>
	        <th scope="col">Application</th>
	        <th scope="col">Not important to my dept.</th>
	        <th scope="col"><s:property value='criticalityLevels[0].name' /></th>
	        <th scope="col"><s:property value='criticalityLevels[1].name' /></th>
	        <th scope="col"><s:property value='criticalityLevels[2].name' /></th>
	        <th scope="col"><s:property value='criticalityLevels[3].name' /></th>
	        <th>Comment?</th>
	        <th class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
	    </tr>
	    <s:iterator value="applicationRows" status="rowstatus">
            <s:set name='radioChecked' value='checked="checked"'/>
            <s:set name='radioDisabled' value='""'/>
            <s:if test='#session.planAccessControl.isSelectDisabled == true'>
                <s:set name='radioDisabled' value='disabled="disabled"'/>
            </s:if>
	        <tr>
	            <td><s:property value="centralApplication.name"/></td>
	            <td>
	               <input
	                   id="criticalityLevel0" 
	                   name="dtos[<s:property value='#rowstatus.index'/>].criticalityLevel.levelNo.id" 
	                   value="0"
	                   type="radio" 
                       <s:property value="#radioDisabled"/>
                       <s:if test='criticalityLevel.levelNo.id == "0"'>
                           <s:property value="#radioChecked"/>
                       </s:if>/>
	            </td>
                <td>
                   <input 
                       id="criticalityLevel1" 
                       name="dtos[<s:property value='#rowstatus.index'/>].criticalityLevel.levelNo.id" 
                       value="1" 
                       type="radio" 
                       <s:property value="#radioDisabled"/>
                       <s:if test='criticalityLevel.levelNo.id == "1"'>
                           <s:property value="#radioChecked"/>
                       </s:if>/>
                </td>
                <td>
                   <input 
                       id="criticalityLevel2" 
                       name="dtos[<s:property value='#rowstatus.index'/>].criticalityLevel.levelNo.id" 
                       value="2" 
                       type="radio" 
                       <s:property value="#radioDisabled"/>
                       <s:if test='criticalityLevel.levelNo.id == "2"'>
                           <s:property value="#radioChecked"/>
                       </s:if>/>
                </td>
                <td>
                   <input 
                       id="criticalityLevel3" 
                       name="dtos[<s:property value='#rowstatus.index'/>].criticalityLevel.levelNo.id" 
                       value="3" 
                       type="radio" 
                       <s:property value="#radioDisabled"/>
                       <s:if test='criticalityLevel.levelNo.id == "3"'>
                           <s:property value="#radioChecked"/>
                       </s:if>/>
                </td>
                <td>
                   <input 
                       id="criticalityLevel4" 
                       name="dtos[<s:property value='#rowstatus.index'/>].criticalityLevel.levelNo.id" 
                       value="4" 
                       type="radio" 
                       <s:property value="#radioDisabled"/>
                       <s:if test='criticalityLevel.levelNo.id == "4"'>
                           <s:property value="#radioChecked"/>
                       </s:if>/>
                </td>
	            <td><s:property value="comment"/></td>
	            <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                <a href="javascript:deleteFormRow(<s:property value='id'/>);" 
	                    onClick="return confirm('Delete application: are you sure?');">Delete</a>
	            </td>
	        </tr>
            <s:hidden name="dtos[%{#rowstatus.index}].id"/>
            <s:hidden name="dtos[%{#rowstatus.index}].centralApplication.id"/>
            <s:hidden name="dtos[%{#rowstatus.index}].centralApplication.name"/>
	        <s:hidden name="dtos[%{#rowstatus.index}].criticalityLevel.description"/>
            <s:hidden name="dtos[%{#rowstatus.index}].comment"/>
            <s:hidden name="dtos[%{#rowstatus.index}].plan.id"/>
	    </s:iterator>
	    </table> 
	</s:if>

    <s:token />
    
</s:form>

<s:form name="DeleteForm" action="deleteInformationTechnologyCentralApplication">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>