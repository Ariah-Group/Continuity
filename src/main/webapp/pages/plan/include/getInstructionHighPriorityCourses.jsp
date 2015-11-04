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
.stop {
    color:#CC3300;
    font-weight:bold;
    font-size:14px;
    padding: 0 2px 0 2px;
}
-->
</style>

<h1>High Priority Courses</h1>

<a name="bookmark" id="bookmark"></a>   

<s:form action="saveInstructionHighPriorityCourses">

    <p>On this screen we give special attention to <strong>High Priority courses</strong>: the courses whose interruption would <strong>most</strong> threaten the progress of our students and the integrity of the curriculum.</p>
    <p><s:property value="#session.uiText.textMap['INSTR_HIGH_PRIORITY_COURSE']" escape='false'/></p>
    <p>Please list here any High Priority courses taught by your department. If a course does not meet the above criteria but is important for another compelling reason, you may choose to include it.</p>

    <div class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	    <table id="col_layout">
			<tr>
			    <td class="numbers"><label for="dto.courseNum">Course Number <span class="tagline">(See Guidance at right.)</span></label><s:textfield name="dto.courseNum"/></td>    
			    <td class="titles"><label for="dto.courseTitle">Course Title</label><s:textfield name="dto.courseTitle"/></td>   
			    <td>
					<span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
						<input name="AddS" type="submit" value="Add to List" onclick="this.form.saveActionType.value=1;"/>
				    </span>
			    </td>
			</tr>
		</table>
	</div>

    <s:hidden name="insId"/>
    <s:hidden name="deptName"/>
    <s:hidden name="dto.instruction.id" value="%{insId}"/>

	<s:if test="dtos.size > 0">
	    <p><strong>High Priority Courses.</strong> For each course, please check all items that apply.  If there is an &quot;another compelling reason&quot; (see above) why this course is high priority, explain in the Comment box.</p> 
	    
	    <table id="editplan_table">
	    <tr>
	        <th scope="col">Course Number</th>
	        <th scope="col">Course Title</th>
	        <th scope="col">Course-cast is available</th>
	        <th scope="col">Course-cast is available but may be outdated</th>
	        <th scope="col">Course-cast not available, but course is suitable for course-casting</th>
	        <th scope="col">All current sections have <s:property value="#session.uiText.textMap['INSTR_COURSE_MGMT_TOOL']" escape='false'/> sites</th>
	        <th scope="col">There is another instructor who can teach this course if necessary</th>
	    </tr>
	    
        <s:iterator value="dtos" status="rowstatus">
            <s:hidden name="dtos[%{#rowstatus.index}].id"/>
            <s:hidden name="dtos[%{#rowstatus.index}].name"/>
            <s:hidden name="dtos[%{#rowstatus.index}].instruction.id" value="%{insId}"/>
            <s:hidden name="dtos[%{#rowstatus.index}].courseNum"/>
            <s:hidden name="dtos[%{#rowstatus.index}].courseTitle"/>
            <s:set name='radioDisabled' value='""'/>
            <s:if test='#session.planAccessControl.isSelectDisabled == true'>
                <s:set name='radioDisabled' value='disabled="disabled"'/>
            </s:if>
            <tr>
                <td><s:property value="courseNum"/></td>
                <td><s:property value="courseTitle"/></td>
                <td class="centered">
                    <input
                        id="courseCast1" 
                        name='dtos[<s:property value="#rowstatus.index"/>].courseCast.id'
                        type='radio'
                        value='1'
                        <s:if test="courseCast.id == 1">checked</s:if>
                        <s:property value="#radioDisabled"/>
                    />
                </td>
                <td class="centered">
                    <input 
                        id="courseCast2" 
                        name='dtos[<s:property value="#rowstatus.index"/>].courseCast.id'
                        type='radio'
                        value='2'
                        <s:if test="courseCast.id == 2">checked</s:if>
                        <s:property value="#radioDisabled"/>
                    />
                </td>
                <td class="centered">
                    <input 
                        id="courseCast3" 
                        name='dtos[<s:property value="#rowstatus.index"/>].courseCast.id'
                        type='radio'
                        value='3'
                        <s:if test="courseCast.id == 3">checked</s:if>
                        <s:property value="#radioDisabled"/>
                    />
                </td>
                <td class="centered">
                    <s:checkbox name="dtos[%{#rowstatus.index}].isBspace" disabled="#session.planAccessControl.isSelectDisabled"/>
                </td>
                <td class="centered">
                    <s:checkbox name="dtos[%{#rowstatus.index}].isOtherTeach" disabled="#session.planAccessControl.isSelectDisabled"/>
                </td>
                <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
                    <a href="javascript:deleteFormINRow(<s:property value='insId'/>, <s:property value='id'/>);" onclick="javascript:return confirm('Are you sure?');">delete</a>
                </td>
            </tr>
            <tr>
                <td colspan="7" align="right">
                    <label for="comment">Comment:</label>
                    <s:textarea name="dtos[%{#rowstatus.index}].comment" cssClass="course_comment %{#session.planAccessControl.addClass}"/>
                </td>
                <td>&nbsp;</td>
            </tr>
            <s:if test='!#rowstatus.last'>
                <tr><td colspan="8"><hr class="blueline" /></td></tr>
            </s:if>
        </s:iterator>

        </table> 
    </s:if>
      
    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>

<s:form name="DeleteForm" action="deleteInstructionHighPriorityCourse">
    <s:hidden id="dINRowId" name="insId"/>
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
