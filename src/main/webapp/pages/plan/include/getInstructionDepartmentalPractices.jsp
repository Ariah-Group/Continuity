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

<h1>Departmental Practices </h1>           

<a name="bookmark" id="bookmark"></a> 

<s:form action="saveInstructionDepartmentalPractices">

    <p><s:property value="#session.uiText.textMap['INSTR_DEPARTMENT_PRACTICES']" escape='false'/></p>

	<table id="editplan_table">
		<tr>
		    <th>&nbsp;</th>
		    <th scope="col">Recommended Practice</th>
		    <th  scope="col">Is this currently being done?</th>
		    <th  scope="col">Comment</th>
		</tr>
    
        <tr>
            <td>1.</td>
            <td scope="row"><strong>Strategy for Disaster Communications</strong>:  The department has a plan that details how it will communicate rapidly with faculty, staff &amp; students if disaster strikes.</td>
            <td>
                <s:select
                    name="dto.departmentalPractices['COMMUNICATION'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect3']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.departmentalPractices['COMMUNICATION'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
        </tr>
        
        <tr>
            <td>2.</td>
            <td scope="row"><strong>Backup Plan for Academic Personnel</strong>:  The department has a plan for instructor substitution if necessary.  The groundwork is laid by practices such as team-teaching, rotating instructors, or substituting &quot;topics in&quot; courses.</td>
            <td>
                <s:select
                    name="dto.departmentalPractices['BACKUP_PERSONNEL'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect3']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.departmentalPractices['BACKUP_PERSONNEL'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
        </tr>
        
        <tr>
            <td>3.</td>
            <td scope="row"><strong>Faculty Leaves</strong>:  When faculty leaves are approved, faculty members are informed of the possibility of recall.</td>
            <td>
                <s:select
                    name="dto.departmentalPractices['FACULTY_RECALL'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect3']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.departmentalPractices['FACULTY_RECALL'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
        </tr>
        
        <tr>
            <td>4.</td>
            <td scope="row"><strong>Innovative Pedagogy</strong>:  Faculty are actively encouraged to experiment with teaching tools before disaster strikes and to share experiences with colleagues.</td>
            <td>
                <s:select
                    name="dto.departmentalPractices['PEDAGOGY'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect3']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.departmentalPractices['PEDAGOGY'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
        </tr>
        
    </table> 
                    
    <s:hidden name="insId"/>
    <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
    <s:hidden name="dto.id"/>
    <s:hidden name="dto.instructionalDepartment.id"/>
    <s:iterator value="dto.allCoursesPractices.keys" var="key">
        <s:hidden name="dto.allCoursesPractices['%{#key}'].departmentExpansion.id" value="%{dto.allCoursesPractices[#key].departmentExpansion.id}"/>
        <s:hidden name="dto.allCoursesPractices['%{#key}'].currentUsage.id" value="%{dto.allCoursesPractices[#key].currentUsage.id}"/>
        <s:hidden name="dto.allCoursesPractices['%{#key}'].comment" value="%{dto.allCoursesPractices[#key].comment}"/>
    </s:iterator>

    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>
