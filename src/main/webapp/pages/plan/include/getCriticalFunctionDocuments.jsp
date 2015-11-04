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

<h1>Documents<a name="ShowPoint">&nbsp;</a></h1>

<p>Please identify any documents that are very important to this function &ndash; whether they 
are <strong>individual documents</strong> (such as policy manuals) or <strong>sets of records</strong> 
(such as patient files, research files, vendor invoices, etc.).</p>

<p>The documents listed here may be paper or electronic.</p>

<p>Do not include records that are stored within a database application such as a financial system, 
an HR system, a medical records system, etc.  These will be treated elsewhere.</p>

<!-- document form  -->    
<s:form name="addCriticalFunctionDocument" action="addCriticalFunctionDocument" enctype="multipart/form-data" >
    <!-- edit url -->
    <s:url action="getCriticalFunctionDocument" var="editDocumentURL">
        <s:param name="criticalFunction.id"><s:property value="criticalFunction.id"/></s:param>
    </s:url>
    
    <!-- delete url -->
    <s:set var="deleteDocumentURL" value="%{'javascript:deleteFormCFDocumentRow(' + criticalFunction.id + ','}"/>
    
    <!-- edit document page -->
    <s:include value="/pages/plan/include/editDocument.jsp" />
    
    <!-- add button -->
    <div class="add_to_list_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
        <br/>
        <s:submit name="AddToList" value="Add to List" title="Add Document to List"/>
    </div>
    <br/>
    
    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
	<!-- document list -->
	<s:include value="/pages/plan/include/getDocuments.jsp" />
        
    <!-- hidden -->
    <s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
    <s:hidden name='criticalFunction.name' />
    <s:token />

</s:form>

<s:form name="DeleteForm" action="deleteCriticalFunctionDocument">
    <s:hidden id="dCFRowId" name="criticalFunction.id"/>
    <s:hidden id="dRowId" name="rowId"/>
    <s:hidden id="dDocType" name="docType"/>
    <s:token />
</s:form>
