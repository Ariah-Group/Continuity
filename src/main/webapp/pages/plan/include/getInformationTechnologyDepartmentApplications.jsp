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

<s:form action="addInformationTechnologyDepartmentApplication">

    <h1>Departmentally-Owned Applications</h1>
    <p class="alert">Please ask your department's IT manager (or other tech support person) to fill out this page and the subsequent pages in Step 3. If you are not that IT/tech support person, please go now to Step 4.
    </p>
    <hr class="leftline">
    <p>In Step 2 of this questionnaire, the following were identified as "<s:property value='#session.systemDomain.displayConstants.criticalLower' /> functions":</p>
    
    <ul class="bulletlist">
	    <s:iterator value="criticalFunctions">
	        <li><s:property value='name'/></li>
	    </s:iterator>
	</ul>

    <a name="bookmark" id="bookmark"></a>

    <p>Please enter here the IT applications or systems that support these <s:property value='#session.systemDomain.displayConstants.criticalLower' /> functions.  You, as IT person, may want to consult with the functional managers to identify these applications.</p>
    <p>DO NOT include applications whose technical owner (see Guidance) is the central IT department.  These are listed on the previous screen (<em>Centrally-Owned Applications</em>), are under central stewardship, and are not your concern.  Also do not list servers - they will be treated later.</p>
    <p>The applications to list here are those whose technical owner is your department or another department (but not central IT).  Then go to the Detail Screens.</p>
                                
    <table class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
        <tr>
            <th>Name of Application or System </th>
            <th>Functional Owner (dept.)</th>                   
            <th>Technical Owner  (dept.)</th>
        </tr>
        <tr>
            <td><s:textfield name="dto.name" size="40"  maxlength="128"/></td>                               
            <td><s:textfield name="dto.functionalOwner" maxlength="50"/></td>                              
            <td><s:textfield name="dto.technicalOwner"  maxlength="50"/></td>
        </tr>
    </table>

    <div class="add_to_list_button">
        <span  class="<s:property value='#session.planAccessControl.noDisplayClass'/>"> 
            <input type="submit" name="Save" value="Add to List">
        </span>
    </div>
    
    <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
        
    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:if test="dtos.size > 0">
	    <p><strong>Previous Items Entered (<s:property value="dtos.size"/>)</strong></p> 
	    <table id="editplan_table">
		    <tr>
		        <th>Name of Application or System</th>
		        <th>Functional Owner</th>
		        <th>Technical Owner</th>
		        <th>&nbsp;</th>
		        <th class="<s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
		    </tr>
	    
		    <s:iterator value="dtos" status="rowstatus">
		        <tr>
		            <td><s:property value="name"/></td>
		            <td><s:property value="functionalOwner"/></td>
		            <td><s:property value="technicalOwner"/></td>
		            <td class="button"><a href="getInformationTechnologyDepartmentApplication?rowId=<s:property value="id"/>">
		            <img src="/kcpt/images/GoToDetail_screen.gif" alt="go to detail screen" border="0"></a></td>
		            <td class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
		               <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Are you sure?');">Delete</a>
		            </td>
		        </tr>
		        <s:hidden name="dtos[%{#rowstatus.index}].id"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].name"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].functionalOwner"/>
	            <s:hidden name="dtos[%{#rowstatus.index}].technicalOwner"/>
		    </s:iterator>
	    </table>
	</s:if>
	
	<s:token /> 
                                        
</s:form>

<s:form name="DeleteForm" action="deleteInformationTechnologyDepartmentApplication">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>