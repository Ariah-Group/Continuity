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
<h1>Annual Review of Your Plan</h1>
<ul class="helplist">
    <s:iterator value="adminListMap['AnnualReview']">
        <li><s:property value="name"  escape="false"/></li>
    </s:iterator>
</ul>
<s:include value="/pages/widget/BackButton.jsp"/>
</div>