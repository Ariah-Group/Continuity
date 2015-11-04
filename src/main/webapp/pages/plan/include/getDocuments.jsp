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
<table id="list_table">
    <s:iterator value="documents" var="doc" status="rowstatus">
        <tr>
            <th width="26%" scope="row">Name of document or records</th>
            <td width="58%"><s:property value="name"/></td>
            <td width="8%" class="editordelete <s:property value='#session.planAccessControl.noDisplayClass'/>">
            <s:a href="%{#editDocumentURL + '&rowId=' + id + '&docType=' + type.name()}" title="Edit (%{name}) document info">Edit</s:a></td>
            <td width="8%" class="editordelete <s:property value='#session.planAccessControl.noDisplayClass'/>">
            <s:a href="%{#deleteDocumentURL + id + ', \"' + type.name() + '\")'}" title="Delete (%{name})" onclick="return confirm('Delete document: are you sure?');">Delete</s:a></td>
            <s:hidden name='documents[%{#rowstatus.index}].id'/>
            <s:hidden name='documents[%{#rowstatus.index}].name'/>
        </tr>
        <tr>
            <th scope="row">Description</th>
            <td width="58%"><s:property value="description"/></td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].description'/>
        </tr>
        <tr>
            <th scope="row">Owner (department)</th>
            <td width="58%"><s:property value="ownerDepartment"/></td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].ownerDepartment'/>
        </tr>
        <tr>
            <th scope="row">Location</th>
            <td width="58%"><s:property value="locationKept"/></td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].locationKept'/>
        </tr>
        <tr>
            <th scope="row">Uploaded file</th>
            <td width="58%">
                <s:if test='fileName neq null && fileName neq ""' >
                    <s:url action="getDocumentFile" var="getDocumentFileURL">
                        <s:param name="id"><s:property value="id"/></s:param>
                        <s:param name="type"><s:property value="type.name()"/></s:param>
                    </s:url>
                    <s:a href="%{#getDocumentFileURL}">View uploaded document</s:a>
                </s:if>
            </td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].fileName'/>
        </tr>
        <tr>
            <th scope="row">Medium</th>
            <td width="58%"><s:property value="medium.description"/></td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].medium.id'/>
            <s:hidden name='documents[%{#rowstatus.index}].medium.description'/>
        </tr>
        <tr>
            <th scope="row">Principal contact person(s)</th>
            <td width="58%"><s:property value="principalContact"/></td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].principalContact'/>
        </tr>
        <tr>
            <th scope="row">Backup or other loss-protection measures? (be specific)</th>
            <td width="58%"><s:property value="backupMeasures"/></td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].backupMeasures'/>
        </tr>
        <tr>
            <th scope="row">Comment, if needed</th>
            <td width="58%"><s:property value="comment"/></td>
            <td width="8%">&nbsp;</td>
            <td width="8%">&nbsp;</td>
            <s:hidden name='documents[%{#rowstatus.index}].comment'/>
        </tr>
        <s:if test='!#rowstatus.last'>
	        <tr><td colspan="4"><hr></td></tr>
        </s:if>
    </s:iterator>
</table>