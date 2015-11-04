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
    <h1>Frequently Asked Questions</h1>
	<div>
		<ol class="layout">
		    <s:iterator value="adminListMap['FAQ']">
		        <li><a href="#faq<s:property value='id'/>"><s:property value="name" escape="false"/></a></li>
		    </s:iterator>
		</ol>
	</div>
    <img src="../images/blue_line_G.gif" width="220" height="15">
    <div>
        <s:iterator value="adminListMap['FAQ']">
	        <br />
            <a name="faq<s:property value='id'/>"></a>
            <strong><s:property value="question" escape="false"/></strong>
            <br />
            <s:property value="answer" escape="false"/>
            <br />
        </s:iterator>
    </div>
    <s:include value="/pages/widget/BackButton.jsp"/>
</div>