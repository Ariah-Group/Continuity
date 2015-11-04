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

<s:form action="addKeyResourcesStakeholder">
    
    <s:include value="/pages/plan/include/editKeyResourcesStakeholder.jsp" />

    <div class="add_to_list_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <s:submit 
            name="save" 
            value="Add to List"/>
    </div>

    <s:include value="/pages/widget/ActionErrors.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />

    <s:if test="dtos.size > 0">
	    <strong>Current List:</strong>
	    <table id="stacked_table"> <!--- B ---> 
	        <s:iterator value="dtos" status="rowstatus">
	            <tr>
	              <th scope="row">First Name</th>
	              <td><s:property value="firstName"/></td>
	              <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                  <a href="getKeyResourcesStakeholder?rowId=<s:property value='id'/>">Edit</a>
	              </td>
	              <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
	                  <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Delete stakeholder: are you sure?');">Delete</a>
	              </td>
	            </tr>
	            <tr>
	              <th scope="row">Last Name</th>
	              <td><s:property value="lastName"/></td>
	              <td>&nbsp;</td>
	              <td>&nbsp;</td>
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
	              <th scope="row">Type of Stakeholder</th>
	              <td colspan="3"><s:property value="stakeholderType.description"/></td>
	            </tr>
	            <tr>
	              <th scope="row">Products/Services</th>
	              <td colspan="3"><s:property value="suppliedProductsOrServices"/></td>
	            </tr>
	            <tr>
	              <th scope="row">Alternate Vendors</th>
	        
	              <td colspan="3"><s:property value="alternateVendors"/></td>
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
 
 <s:form name="DeleteForm" action="deleteKeyResourcesStakeholder">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
 