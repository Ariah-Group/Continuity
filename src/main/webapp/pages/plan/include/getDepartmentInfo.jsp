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

<s:include value="/pages/custom/%{#session.systemDomain.customUrl}/getDepartmentInfo.jsp"/>

<s:form id="saveDepartmentInfo" name="saveDepartmentInfo" action='saveDepartmentInfo'>
    <h1><s:property value="#session.systemDomain.displayConstants.deptHeader"/></h1>
    
    <span class="<s:property value='#session.planAccessControl.hideClass'/>">
        <span class="required">*</span>indicates a required answer.
    </span>
    
    <br />
    
    <p><strong>Number of personnel</strong>: (headcount, approximation is OK)</p>
    
    <div id="personnel">
        <ol class="layout">
            <li>
                <label for="departmentInfo.academicStaffCount">Faculty and other academic appointees</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.academicStaffCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
            <li>
                <label for="departmentInfo.residentsAndFellowsCount">Residents/Fellows</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.residentsAndFellowsCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
            <li>
                <label for="departmentInfo.fulltimeStaffCount">Staff (full-time)</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.fulltimeStaffCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
            <li>
                <label for="departmentInfo.parttimeStaffCount">Staff (part-time, excluding students)</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.parttimeStaffCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
            <li>
                <label for="departmentInfo.studentStaffCount">Student-staff</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.studentStaffCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
            <li>
                <label for="departmentInfo.volunteersCount">Volunteers</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.volunteersCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
            <li>
                <label for="departmentInfo.guestsCount">Guests</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.guestsCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
            <li>
                <label for="departmentInfo.otherStaffCount">Other (explain below)</label>:
                <s:textfield readonly="%{#session.planAccessControl.isInputReadOnly}" name="departmentInfo.otherStaffCount" cssClass="%{#session.planAccessControl.addClass}" size="10" maxlength="5"/>
            </li>
        </ol>
    </div>

    <ol class="layout">

        <li>
        
         <label for="addDepartmentTypeId">
             <span class="required <s:property value='#session.planAccessControl.noDisplayClass'/>">*</span><strong>Type of Department:</strong>
             <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                 Please select the description that best fits this unit. Select more than one if appropriate.
             </span>
         </label>

         <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
             <s:select 
                 name="addDepartmentTypeId" 
                 list="departmentTypes"
                 listKey="id"
                 listValue="name"
                 headerKey="0" 
                 headerValue="Please select ..."/>
             <s:submit name="Save_DepartmentType" value="Add to List" />
         </span>
      
         <table id="editplan_table">
             <thead>
                 <tr>
                     <th>Type of Department</th>
                     <th class="<s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
                 </tr>
             </thead>
             <tbody>
                 <s:iterator value='departmentInfo.departmentTypes' status='rowstatus'>
                  <tr>
                      <td>
                          <s:property value='name'/>
                          <s:hidden name="departmentInfo.departmentTypes[%{#rowstatus.index}].id"/> 
                                <s:hidden name="departmentInfo.departmentTypes[%{#rowstatus.index}].name"/> 
                      </td>
                      <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
                          <a href="#" onClick="javascript:deleteDepartmentInfoListElement(1, '<s:property value='id'/>')">
                              Delete
                          </a>
                      </td>
                  </tr>
                 </s:iterator>
             </tbody>
         </table>
        
        </li>

        <li> 
            <label for="addBuildingId"><strong>Location(s) occupied:</strong></label>
            
            <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                Click on a building to add it to your list. 
                Please indicate all space used, including storage space. If a building does not appear on the list, please <a href="/continuity/plan/contactUs">contact us</a> and we will add it.<br />
                <s:select
                    name="addBuildingId"
                    list="buildings"
                    listKey="id"
                    listValue="commonName"
                    headerKey="0" 
                    headerValue="Please select ..."/>
                <s:submit value="Add to List" name="Save_Building" />
            </span>
        
         <table id='editplan_table'>
             <thead>
             <tr>
                 <th scope="col" class="bname">Building</th>
                 <th scope="col">Ownership</th>
                 <th scope="col">Comments, if needed</th>
                 <th class="col <s:property value='#session.planAccessControl.noDisplayClass'/>">&nbsp;</th>
             </tr>
             </thead>
             <tbody>
                 <s:iterator value='departmentInfo.buildings' status='rowstatus'>        
                     <tr>
                         <td>
                             <s:property value='commonName'/>
                             <s:hidden name="departmentInfo.buildings[%{#rowstatus.index}].id"/> 
                                <s:hidden name="departmentInfo.buildings[%{#rowstatus.index}].name"/> 
                                <s:hidden name="departmentInfo.buildings[%{#rowstatus.index}].commonName"/> 
                         </td>
                         <td>
                             <s:property value='ownership.description'/>
                                <s:hidden name="departmentInfo.buildings[%{#rowstatus.index}].ownership.id"/> 
                                <s:hidden name="departmentInfo.buildings[%{#rowstatus.index}].ownership.description"/> 
                         </td>
                         <td>
                             <s:textarea name='departmentInfo.buildings[%{#rowstatus.index}].comment' readonly='%{#session.planAccessControl.isInputReadOnly}' cssClass="%{#session.planAccessControl.addClass}" />
                         </td>
                         <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
                             <a href="#" onClick="javascript:deleteDepartmentInfoListElement(2, '<s:property value='id'/>')">
                                    Delete
                                </a>
                         </td>
                     </tr>
                 </s:iterator>
             </tbody>
         </table>
        
        </li>
        
                    
         <li>
            <label for="departmentInfo.evacuationPlan.id"><strong>Evacuation Plans:</strong> Do all your buildings have evacuation plans?</label>
            <s:select
                name="departmentInfo.evacuationPlan.id"
                disabled='#session.planAccessControl.isSelectDisabled'
                list="evacuationPlans"
                listKey="id"
                listValue="description"
                headerKey="0" 
                headerValue="Please select ..."/>
            <p>You may upload your evacuation plan(s) on the <a href="./getKeyResourcesDocuments">Documents</a> screen.</p>
        </li>

        <li>
            <label for="departmentInfo.costCenter"><strong>Cost Center:</strong> What cost center(s) does this plan cover? (Leave blank if this term is not used in your organization.)</label>
            <s:textfield readonly='%{#session.planAccessControl.isInputReadOnly' name="departmentInfo.costCenter" cssClass="sizelong %{#session.planAccessControl.addClass}" maxlength="40"/>
        </li>
        
        <li>
            <label for="departmentInfo.comment"><strong>Comment or explanation </strong>(if needed):</label>
            <s:textarea name='departmentInfo.comment' readonly='%{#session.planAccessControl.isInputReadOnly}' cssClass="sizelong %{#session.planAccessControl.addClass}" rows="3"/>                
        </li>
        
    </ol>
    
    <s:include value="/pages/widget/ActionErrors.jsp" />
        
    <s:include value="/pages/widget/SaveContinueButtons.jsp"/>
    
    <s:iterator value="departmentTypes" status="rowstatus">
        <s:hidden name="departmentTypes[%{#rowstatus.index}].id"/>
        <s:hidden name="departmentTypes[%{#rowstatus.index}].name"/>
    </s:iterator>
    <s:iterator value="buildings" status="rowstatus">
        <s:hidden name="buildings[%{#rowstatus.index}].id"/>
        <s:hidden name="buildings[%{#rowstatus.index}].name"/>
        <s:hidden name="buildings[%{#rowstatus.index}].commonName"/>
        <s:hidden name="buildings[%{#rowstatus.index}].comment"/>
        <s:hidden name="buildings[%{#rowstatus.index}].ownership.id"/>
        <s:hidden name="buildings[%{#rowstatus.index}].ownership.description"/>
    </s:iterator>
    <s:iterator value="evacuationPlans" status="rowstatus">
        <s:hidden name="evacuationPlans[%{#rowstatus.index}].id"/>
        <s:hidden name="evacuationPlans[%{#rowstatus.index}].description"/>
    </s:iterator>
    <s:hidden id="deleteDepartmentTypeId" name="deleteDepartmentTypeId" value="0"/>
    <s:hidden id="deleteBuildingId" name="deleteBuildingId" value="0"/>   
    
    <s:token />                    

</s:form>