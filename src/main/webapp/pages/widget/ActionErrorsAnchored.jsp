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
<!-- Include/ShowMessage.cfm -->

<a name="aErrors">&nbsp;</a>
<s:include value="ActionErrors.jsp"/>
<s:if test="actionErrors.size > 0 || fieldErrors.size > 0">
	<script type="text/javascript">
	    function gotoAErrors() {
            window.location.href="#aErrors";
	    }
	    window.onload=gotoAErrors;
	</script>
</s:if>