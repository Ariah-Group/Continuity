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
<!-- Begin Guidance Box section -->

<b class="b1"></b>
<b class="b2"></b>
<b class="b3"></b>
<b class="b4"></b>

<div class="contentb">
    <h3>Guidance</h3>
    <div id="guidance">
		<div align="center">
			<img src="/kcpt/images/blue_line_G.gif" alt="" width="220" height="10"> 
		</div>
		<s:set var="pgName" value="#request['javax.servlet.forward.servlet_path']"/>
		<s:include value="%{'../guidances' + #pgName + '.jsp'}"/>
    </div>
</div>

<b class="b4"></b>
<b class="b3"></b>
<b class="b2"></b>
<b class="b1"></b>