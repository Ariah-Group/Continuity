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
<s:include value="../common/YUI.jsp"/>
<LINK REL="stylesheet" TYPE="text/css" HREF="/continuity/css/widget/FloatingPanel.css">
<script type="text/javascript" src="/continuity/javascripts/widget/FloatingPanelLibrary.js"></script>
<div class="yui-skin-sam">
	<div id="floatingpanel" style="visibility:hidden">
	    <div id="hd" class="hd">text</div>
	    <div id="bd" class="bd">text</div>
	</div>
</div>