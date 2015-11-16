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

<s:if test="actionErrors.size > 0 || fieldErrors.size > 0">
	<span id="MessageDIV" class="MessageDIVClass">
		<img class="NavMiddleImagesRegClass" src="/continuity/images/redlight2.gif">
		Action not complete:<br/>
        <s:iterator value="fieldErrors.keys" var="key">
            <s:iterator value="fieldErrors[#key]">
                <s:property escape='false'/><br/>
            </s:iterator>
        </s:iterator>
        <s:iterator value="actionErrors">
            <s:property escape='false'/><br/>
        </s:iterator>
	</span>
</s:if>
<s:elseif test="actionMessages.size > 0">
    <div class="trans_status">
        <s:iterator value="actionMessages">
            <li><s:property/></li>
        </s:iterator>
    </div>
    <script  type="text/javascript">
        setTimeout("ClearActionStatus('trans_status');", 3000);
    </script>
</s:elseif>