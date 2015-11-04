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
<s:form name="saveCriticalFunctionDocument" action="saveCriticalFunctionDocument" enctype="multipart/form-data" >
    <!-- edit document page -->
    <s:include value="/pages/plan/include/editDocument.jsp" />
    
    <!-- error line -->
    <s:include value="/pages/widget/ActionErrors.jsp" />
    
    <!-- add button -->
    <div class="add_to_list_button">
        <br/>
        <s:submit name="Update" value="Update" title="Update Document"/>
    </div>
    <br/>
    
    <!-- hidden -->
    <s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
    <s:hidden name='criticalFunction.name' />
    <s:token />
</s:form>