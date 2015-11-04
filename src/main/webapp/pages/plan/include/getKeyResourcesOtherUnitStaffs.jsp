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

<s:form action="addKeyResourcesOtherUnitStaff">

    <s:include value="/pages/plan/include/editKeyResourcesOtherUnitStaff.jsp" />

    <div class="add_to_list_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <s:submit 
            name="save" 
            value="Add to List"/>
    </div>

    <s:include value="/pages/widget/ActionErrors.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />

	<s:if test="dtos.size > 0">
	    <strong>Current List:</strong>
	    <table id="stacked_table" > <!--- B --->    
	        <s:iterator value="dtos" status="rowstatus">
	          <!-- Names table begins -->
	            <tr>
	              <th scope="row">Name</th>
	              <td><s:property value="firstName"/> <s:property value="lastName"/></td>
	              <td width="8%" class="editordelete <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                  <a href="getKeyResourcesOtherUnitStaff?rowId=<s:property value='id'/>">Edit</a>
	              </td>
	              <td width="8%" class="editordelete <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                  <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Delete key resource: are you sure?');">Delete</a>
	              </td>
	            </tr>
	            <tr>
	              <th scope="row">Department/Organization</th>
	              <td><s:property value="department"/></td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	            <tr>
	              <th scope="row">Work Phone</th>
	              <td><s:property value="workPhone"/></td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	            <tr>
	              <th scope="row">Cell Phone</th>
                  <td><s:property value="cellPhone"/></td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	            <tr>
	              <th scope="row">Fax</th>
                  <td><s:property value="fax"/></td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	            <tr>
	              <th scope="row">Email</th>
                  <td><s:property value="email"/></td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	            <tr>
	              <th scope="row">Address</th>
                  <td><s:property value="address"/></td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
	            </tr>
	            <tr>
	              <th scope="row">Comment</th>
                  <td colspan="3"><s:property value="comment"/></td>
	            </tr>
                <s:if test='!#rowstatus.last'>
                    <tr><td colspan="4"><hr /></td></tr>
                </s:if>        
	        </s:iterator>
	    </table> 
	</s:if>
	
	<s:token />

</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesOtherUnitStaff">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
