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

<h1>Special Teaching Issues</h1>           

<a name="bookmark" id="bookmark"></a>   
  
<s:form action="saveInstructionTeachingIssues">
    <p>Many courses require specialized resources and logistics, for example: </p>
    <ul class="lists">
	    <li>Laboratories</li>
	    <li>Design or performance studios</li>
		<li>Field work / internships / experiential learning</li>
		<li>Specialized instructional software</li>
		<li>Access to collections (library, museum etc.)</li>
	</ul>
    <p>These may pose particular challenges to the continuation of instruction during and after a major disaster.  If your department teaches courses that have such specialized requirements, please identify them here.  Be brief.</p>

    <s:hidden name="insId"/>
    <s:hidden name="deptName"/>
    <s:hidden name="dto.instruction.id" value="%{insId}"/>
    <s:hidden name="dto2.instruction.id" value="%{insId}"/>

    <div class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	    <table id="col_layout">
	        <tr>
			    <td colspan="3">
			        <label for="dto.name">Special teaching issue:</label>
	                <s:select
	                    name="dto.name"
	                    list="refListMap['SpecialTeachingIssue']"
	                    listKey="description"
	                    listValue="description"
	                    headerKey=""
	                    headerValue="Please select..."/>
			    </td>
			</tr>
			<tr>
			    <td class="wider_width">
				    <label for="dto.impact">Describe this issue&rsquo;s potential impact on your teaching program:</label>
				    <s:textarea name="dto.impact" rows="3"/>
			    </td>
			    <td class="wider_width" >
				    <label for="dto.alternatives">Are there potential alternatives?</label>
				    <s:textarea name="dto.alternatives" rows="3"/>
				</td>
			    <td>
	                <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
			            <input name="AddS1" type="submit" value="Add to List"  onclick="this.form.saveActionType.value=1;"/>
			        </span>
			    </td>
			</tr>
		</table>
	
	    <hr class="thickline"/>
	
	    <table id="col_layout">
	        <tr>
	            <td>
	                <label for="dto2.name">Other special teaching issue that is not on the list above:</label>
	                <s:textarea name="dto2.name" rows="3"/>
	            </td>
			    <td>&nbsp;</td>
			    <td>&nbsp;</td>
	            
	        </tr>
	        <tr>
	            <td class="wider_width">
	                <label for="dto2.impact">Describe this issue&rsquo;s potential impact on your teaching program:</label>
	                <s:textarea name="dto2.impact" rows="3"/>
	            </td>
	            <td class="wider_width" >
	                <label for="dto2.alternatives">Are there potential alternatives?</label>
	                <s:textarea name="dto2.alternatives" rows="3"/>
	            </td>
	            <td>
	                <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	                    <input name="AddS2" type="submit" value="Add to List"  onclick="this.form.saveActionType.value=2;"/>
	                </span>
	            </td>
	        </tr>
	    </table>
    </div>

    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
        
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />

	<s:if test="dtos.size > 0">
	    <br />
	    <p><strong>Previous entries:</strong></p> 
	    <table id="editplan_table">
	    <tr>
	        <th scope="col">Special Teaching Issue</th>
	        <th scope="col">Potential Impact</th>
	        <th scope="col">Potential Alternatives</th>
	        <th>&nbsp;</th>
	    </tr>
	    <s:iterator value="dtos" status="rowstatus">
            <s:hidden name="dtos[%{#rowstatus.index}].id"/>
            <s:hidden name="dtos[%{#rowstatus.index}].name"/>
            <s:hidden name="dtos[%{#rowstatus.index}].instruction.id" value="%{insId}"/>
            <s:hidden name="dtos[%{#rowstatus.index}].impact"/>
            <s:hidden name="dtos[%{#rowstatus.index}].alternatives"/>
	        <tr>
	            <td><s:property value='name'/></td>
                <td><s:property value='impact'/></td>
                <td><s:property value='alternatives'/></td>
	            <td class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	               <a href="javascript:deleteFormINRow(<s:property value='insId'/>, <s:property value='id'/>);" onclick="javascript:return confirm('Are you sure?');">
	                   delete
	               </a>
	           </td>
	        </tr>
	    </s:iterator>
	    </table> 
	</s:if>

    <s:token />
    
</s:form>


<s:form name="DeleteForm" action="deleteInstructionTeachingIssue">
    <s:hidden id="dINRowId" name="insId"/>
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>

