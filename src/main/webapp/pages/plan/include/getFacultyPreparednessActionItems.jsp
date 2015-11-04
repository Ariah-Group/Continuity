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

<h1><s:property value="#session.systemDomain.displayConstants.facultyPrepare" /> Preparedness</h1>
<br>
<div class="alert">
    If your unit does not employ <span style="text-transform: lowercase">
    <s:property value="#session.systemDomain.displayConstants.facultyPreparePrint" />
    </span>, please move to the next screen.
</div>    
<br>
<hr>

<s:form name="addFacultyPreparednessActionItem" action="addFacultyPreparednessActionItem">

    <a name="bookmark" id="bookmark"></a>

    <p>Individual <span style="text-transform: lowercase">
    <s:property value="#session.systemDomain.displayConstants.facultyPreparePrint" />
    </span> drive teaching, research, and patient care.   Readiness for disaster is a 
    faculty issue as well as a staff issue.</p>
    
    <p>Please list here anything that your department can do to promote disaster-consciousness 
    and disaster-readiness among your <span style="text-transform: lowercase">
    <s:property value="#session.systemDomain.displayConstants.facultyPreparePrint" />
    </span>.  See the Guidance at right for suggestions.</p>

    <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    
        <!-- edit page -->
        <s:include value="/pages/plan/include/editFacultyPreparednessActionItem.jsp" />
        
        <!-- add button -->
        <s:div cssClass="add_to_list_button">
	       <br/>
	       <input name="Add" type="submit" value="Add to list">
	    </s:div>

        <!-- error line -->
        <s:include value="/pages/widget/ActionErrors.jsp" />
        
    </span> 

    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
	<table id="list_table">
	    <s:iterator value="dtos" status="rowstatus">
	     <s:url action="getFacultyPreparednessActionItem" var="editActionItemURL">
	            <s:param name="rowId"><s:property value="id"/></s:param>
	        </s:url>
	        <tr>
	            <th scope="row">Action Item</th>
	            <td><s:property value="name"/></td>
	            <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                <s:a href="%{#editActionItemURL}" title="Edit (%{name}) action item info">Edit</s:a>
	            </td>
	            <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                <a href="javascript:deleteFormRow(<s:property value='id'/>);" title="Delete (%{name})" onclick="return confirm('Delete action item: are you sure?');">Delete</a>
	            </td>
	        </tr>
	        <tr>
	            <th scope="row">Comment</th>
	            <td><s:property value="comment"/></td>
	            <td class="<s:property value='#session.planAccessControl.displayClass'/>">&nbsp;</td>
	            <td class="<s:property value='#session.planAccessControl.displayClass'/>">&nbsp;</td>
	        </tr>
	        <s:if test='!#rowstatus.last'>
	            <tr><td colspan="4"><hr class="divider"/></td></tr>
	        </s:if>
	     <s:hidden name='dtos[%{#rowstatus.index}].id'/>
	        <s:hidden name='dtos[%{#rowstatus.index}].name'/>
	        <s:hidden name='dtos[%{#rowstatus.index}].comment'/>
	    </s:iterator>
	</table>
	
	<s:token />
 
</s:form>

<s:form name="DeleteForm" action="deleteFacultyPreparednessActionItem">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>