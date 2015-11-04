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

<s:form action="saveKeyResourcesSkills">

    <h1>Skills</h1>   

    <a name="bookmark" id="bookmark"></a>

	<p>In time of crisis, we need to enlist the help of others. We
	borrow staff, do temporary hiring, enlist volunteers, or engage
	contractors. Below is a list of <strong>skills, licenses, or
	certifications</strong> that might be needed post-disaster. Please select those
	skills appropriate to the performance of your department's
	<s:property value='#session.systemDomain.displayConstants.criticalLower'/> 
	functions.</p>
	
	<div class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	
	    <p>As a reminder, the <s:property value='#session.systemDomain.displayConstants.criticalLower'/> 
	    functions that you have identified (Levels 1-3) are</p>
	    
	    <ul class="bulletlist">
		    <s:iterator value="criticalFunctions">
		        <li><s:property value="name"/></li>
		    </s:iterator>
	    </ul>
    
        <br />
    
        <table >
            <tr>
                <td>
                    <label for="dto.id"><strong>Choose from this list of skills, if any apply</strong>:</label>
                    <s:select
                        name="dto.id"
                        list="adminListMap['Skill']"
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
            <s:submit 
                name="AddS" 
                value="Add to List"
                onclick="this.form.saveActionType.value=1;"/>
        </div>
    
        <p><strong>If the skills you may need are not listed, please add them:</strong></p>
        
        <table id="dtos">
            <tr>
                <th scope="col"><label for="udDTO.name"><strong>Skills</strong></label></th>
                <th scope="col"><label for="udDTO.description"><strong>Description</strong></label></th>
                <th scope="col"><label for="udDTO.comment"><strong>Comment</strong></label></th>
            </tr>
            <tr>
                <td><s:textfield name="udDTO.name" size="35" maxlength="50"/></td>
                <td><s:textfield name="udDTO.description" size="40"/></td>
                <td><s:textarea name="udDTO.comment" cols="" rows="2" cssClass="comment"/></td>
            </tr>
        </table>
        
        <div class="add_to_list_button">
            <s:submit 
                name="AddU" 
                value="Add to List"
                onclick="this.form.saveActionType.value=2;"/>
        </div>

        <p>Remember to SAVE before leaving.</p>

    </div>
    
    <s:include value="/pages/widget/ActionErrors.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />

    <s:if test="dtos.size > 0">
	    <table id="editplan_table">
		    <tr>
		      <th scope="col">Skill</th>
		      <th scope="col">Description</th>
		      <th scope="col" class="comment">Comment?</th>
		      <th scope="col" class="<s:property value='#session.planAccessControl.noDisplayClass'/>"></th>
		    </tr>
		    <s:iterator value="dtos">
		        <tr>
					<td><s:property value="name"/></td>
					<td><s:property value="description"/></td>
					<td><s:property value="comment"/></td>
					<td class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
					    <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="return confirm('Delete skill: are you sure?');">Delete</a>
					</td>
		        </tr>
		    </s:iterator>
	    </table>
	</s:if>

    <s:token />
    
</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesSkill">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>
