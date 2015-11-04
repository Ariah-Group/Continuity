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
	<h1>Examples of <s:property value="#session.systemDomain.displayConstants.criticalUpper" /> Functions</h1>
	<p>Here are some examples of the choices that other departments have made when asked to designate <s:property value="#session.systemDomain.displayConstants.criticalLower" /> functions.</p>
	<table id="list_table">
	    <tr>
	        <th scope="col">Name of Unit</th>
	        <th scope="col">Function</th>
	        <th scope="col">Level of Criticality</th>
	    </tr>
	    <s:if test="examples.size == 0">
	        <tr><td> - No examples available - </td></tr>
	    </s:if>
	    <s:else>
	        <s:iterator value="examples" status="rowstatus1">
	            <s:iterator value="examples[#rowstatus1.index].criticalFunctions" status="rowstatus2">
	                <tr>
	                    <td>
	                        <s:if test="#rowstatus2.index == 0">
	                            <s:property value="examples[#rowstatus1.index].plan.name"/>
	                        </s:if>
	                        <s:else>
	                            &nbsp;
	                        </s:else>
	                    </td>
	                    <td><s:property value="name"/></td>
	                    <td><s:property value="criticalityLevel.description"/></td>
	                </tr>
	            </s:iterator>
	        </s:iterator> 
	    </s:else>
	</table>
    <s:include value="/pages/widget/BackButton.jsp"/>
</div>