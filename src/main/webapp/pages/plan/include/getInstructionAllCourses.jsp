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

<h1>All Courses (undergraduate  only)</h1>           

<a name="bookmark" id="bookmark"></a>   
  
<s:form action="saveInstructionAllCourses">

    <p><s:property value="#session.uiText.textMap['INSTR_ALL_COURSES']" escape="false"/></p>
       
    <table id="editplan_table">
		<tr>
		    <th>&nbsp;</th>
		    <th scope="col">Recommended <br />
		      Practice</th>
		    <th scope="col">Estimate your department&rsquo;s current usage of this practice.</th>
		    <th scope="col">Can this practice be expanded in your department?</th>
		    <th scope="col">Comment</th>
		</tr>
    
		<tr>
			<td>1.</td>
    		<td  scope="row"><strong><s:property value="#session.uiText.textMap['INSTR_COURSE_MGMT_TOOL']" escape='false'/> Sites</strong>:  Every course has a <s:property value="#session.uiText.textMap['INSTR_COURSE_MGMT_TOOL']" escape='false'/> site.</td>
            <td>
	            <s:select
	                name="dto.allCoursesPractices['BSPACE'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
	                list="refListMap['InstructionSelect1']"
	                listKey="id"
	                listValue="description"
	                headerKey="0"
	                headerValue="Please select..."/>
	        </td>
            <td>
                <s:select
                    name="dto.allCoursesPractices['BSPACE'].departmentExpansion.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect2']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.allCoursesPractices['BSPACE'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
		</tr>

        <tr>
            <td>2.</td>
            <td scope="row"><strong>Grades Current</strong>: <s:property value="#session.uiText.textMap['INSTR_RECOMMENDED_PRACTICE']" escape='false'/></td>
            <td>
                <s:select
                    name="dto.allCoursesPractices['BSPACE_GRADE'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect1']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td>
                <s:select
                    name="dto.allCoursesPractices['BSPACE_GRADE'].departmentExpansion.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect2']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.allCoursesPractices['BSPACE_GRADE'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
        </tr>

        <tr>
            <td>3.</td>
            <td scope="row"><strong>Good Communication Among GSIs</strong>:  Consistency is achieved across discussion &amp; lab sessions by fostering communication among GSIs.  (Possible methods:  regular meetings, a dedicated <s:property value="#session.uiText.textMap['INSTR_COURSE_MGMT_TOOL']" escape='false'/> site for GSIs, etc.)</td>
            <td>
                <s:select
                    name="dto.allCoursesPractices['GSI_COMMUNICATION'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect1']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td>
                <s:select
                    name="dto.allCoursesPractices['GSI_COMMUNICATION'].departmentExpansion.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect2']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.allCoursesPractices['GSI_COMMUNICATION'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
        </tr>

        <tr>
            <td>4.</td>
            <td scope="row"><strong>Common Course Materials</strong>:  When instructors teach the same or similar courses, common textbooks and other course materials are used.</td>
            <td>
                <s:select
                    name="dto.allCoursesPractices['COMMON_MATERIALS'].currentUsage.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect1']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td>
                <s:select
                    name="dto.allCoursesPractices['COMMON_MATERIALS'].departmentExpansion.id"
                    disabled="#session.planAccessControl.isSelectDisabled"
                    list="refListMap['InstructionSelect2']"
                    listKey="id"
                    listValue="description"
                    headerKey="0"
                    headerValue="Please select..."/>
            </td>
            <td><s:textarea name="dto.allCoursesPractices['COMMON_MATERIALS'].comment" cssClass="comment %{#session.planAccessControl.addClass}"/></td>
        </tr>

    </table> 

    <s:hidden name="insId"/>
    <s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
    <s:hidden name="dto.id"/>
    <s:hidden name="dto.instructionalDepartment.id"/>
    <s:iterator value="dto.departmentalPractices.keys" var="key">
        <s:hidden name="dto.departmentalPractices['%{#key}'].currentUsage.id" value="%{dto.departmentalPractices[#key].currentUsage.id}"/>
        <s:hidden name="dto.departmentalPractices['%{#key}'].comment" value="%{dto.departmentalPractices[#key].comment}"/>
    </s:iterator>

    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>
