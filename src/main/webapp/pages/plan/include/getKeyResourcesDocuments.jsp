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

<h1>Documents Summary</h1>    
<p>These are the key documents you have identified for all of your <s:property value='#session.systemDomain.displayConstants.criticalUpper' /> Functions:</p>
    
<s:form action="saveKeyResourcesDocuments">
	
    <!-- edit url -->
    <s:url action="getKeyResourcesDocument" var="editDocumentURL">
        <s:param name="kr">true</s:param>
    </s:url>
    
    <!-- delete url -->
    <s:set var="deleteDocumentURL" value="'javascript:deleteFormDocumentRow('"/>
    
    <!-- document list -->
    <s:if test="documents.size > 0">
        <s:include value="/pages/plan/include/getDocuments.jsp" />
    </s:if>
	<s:else>
	    -No documents-
	</s:else>
	    
	<p class="<s:property value='#session.planAccessControl.noDisplayClass'/>">You may add documents directly to this list:&nbsp;&nbsp; 
        <s:submit name="AddToList" value="Add New Document " title="Add Document to List" onclick="this.form.action='getKeyResourcesDocument?documentId=0'"/>
    </p>

    <s:include value="/pages/widget/ActionErrors.jsp" />
	
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>

<s:form name="DeleteForm" action="deleteKeyResourcesDocument">
    <s:hidden id="dRowId" name="rowId"/>
    <s:hidden id="dDocType" name="docType"/>
    <s:hidden id="kr" name="kr" value="true"/>
    <s:token />
</s:form>