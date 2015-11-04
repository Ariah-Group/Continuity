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

<p><span class="required">*</span>indicates a required answer</p>
<s:hidden name="document.id"/>
<s:hidden name="document.plan.id" value="%{#session.plan.id}"/>
<s:hidden name="docType" value="%{document.type.name()}"/>
<s:if test="criticalFunction != null">
    <s:hidden name="document.criticalFunction.id" value="%{criticalFunction.id}"/>
</s:if>
<s:else>
    <s:hidden name="document.criticalFunction.id"/>
</s:else>
<table class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    <tr>
        <td>
            <label for="document.name">
            <strong><span class="required">*</span>Name of document or record:</strong></label>
            <s:textfield name="document.name"  id="document.name"  cssClass="DocumentNameClass"/>
        </td>
        <td>&nbsp;</td>
        <td>
            <label for="documentMedia"><strong>Medium:</strong><span class="required">&nbsp;</span></label>
            <s:select 
                name="document.medium.id" 
                cssClass="DocumentMediumClass"
                list="refListMap['DocumentType']"
                listKey="id"
                listValue="description"
                headerKey="0"
                headerValue="Please select ..."/>
        </td>
    </tr>
    <tr>    
        <td>
            <label for="document.description"><strong>Description in your words (brief):</strong></label>
            <s:textarea name="document.description" cssClass="DocumentDescriptionClass"/>
        </td>
        <td>&nbsp;</td>
        <td>
            <label for="document.principalContact"><strong>Principal contact person(s):</strong></label> 
            <s:textarea name="document.principalContact" cssClass="DocumentContactClass"/> 
        </td>
    </tr>   
    <tr>
        <td>    
            <label for="document.ownerDepartment"><strong>Owner (department):</strong></label> 
            <s:textarea name="document.ownerDepartment" cssClass="DocumentOwnerClass" ></s:textarea>
        </td>
        <td>&nbsp;</td>
        <td>
            <label for="document.backupMeasures"><strong>Backup or other loss-protection measures? (be specific)</strong></label>
          <s:textarea name="document.backupMeasures" cssClass="DocumentBackupClass"/> 
        </td>
  </tr>
    <tr>
        <td>
            <label for="document.locationKept"><strong>Location where kept</strong> (typical answers: Jackson Hall room 24 OR Emily Smith's computer OR departmental shared drive):</label> 
            <s:textarea name="document.locationKept" cssClass="DocumentLocationClass"/>
        </td>
        <td>&nbsp;</td>
        <td>
            <label for="document.comment"><strong>Comment (if needed):</strong></label> 
            <s:textarea name="document.comment" cssClass="DocumentCommentClass"></s:textarea>
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <label for="in_link"><strong>Upload file:</strong></label>
            <strong>Caution</strong>: All types of documents will be accepted for upload (20MB per document size limit). But future opening, viewing & downloading requires that the computer being used at that time have the appropriate software. Use Adobe Acrobat (.pdf) format when possible. Avoid less-common document types, and use our system as your secondary repository only - make sure your documents are also available elsewhere.
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <s:file name="uploadedDoc" size="50" />
        </td>
    </tr>
</table>
 