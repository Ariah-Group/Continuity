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

<div id="innertube">
           
	<h1>Download Documents Here</h1>
	<p>This download screen is accessible only to <em>institution administrators</em>, <em>local administrators</em> and <em>universal viewers</em>.</p>
	<p>Below is a list of all documents stored for all plans in this planning tool.</p>
	<p>Clicking a document link will cause it to be opened on your computer.  You may then view, print, or save any document at will.</p>
	<p><strong>Departmental continuity plans:</strong> to view or print any departmental continuity plan, <a href="/continuity/plan/getPlans">select that plan</a> and and click its Printing Menu button (on the Plan Home screen).</p>
 
    <table id="list_table">

        <tr>
            <th scope="col">Plan Name</th>
            <th scope="col">Document Name</th>
            <th scope="col">Description</th>
        </tr>

        <!-- remove docs with filename equals to '' prior to iterating -->                
        <s:iterator value="documents" status="rowstatus">
            <s:if test="#rowstatus.odd == true">
                <s:set var="MyColorClass" value="'class=AltRowColor'"/>
            </s:if>
            <s:else>
                 <s:set var="MyColorClass" value="''"/>
            </s:else>
            <tr <s:property value="MyColorClass"/>>
	            <td><s:property value="plan.name"/></td>
	            <td>
                    <s:if test='fileName neq null && fileName neq ""' >
		                <a title="Click to View Document" 
		                   href="./getDocumentFile?id=<s:property value='id'/>&type=<s:property value='type'/>" 
		                   target="_blank"><s:property value='name'/></a>
		            </s:if>
		            <s:else>
		                <s:property value='name'/>
		            </s:else>                       
	            </td>
	            <td><s:property value='description'/></td>
            </tr>
        </s:iterator>

    </table>

    <s:include value="/pages/widget/BackButton.jsp"/>
    
 </div>    