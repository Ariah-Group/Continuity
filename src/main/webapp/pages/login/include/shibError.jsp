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
<div id="errorcontainer">
    <div id="error">
        <fieldset>
            <legend>Continuity Planning Tool System Message</legend>
            <s:set var="pgName" value="#request['javax.servlet.forward.servlet_path']"/>
            <s:if test="#pgName=='/login/shibFailed'">
                <span id="MessageDIV" class="MessageDIVClass">
                    Authentication failed. Please input correct user/ password.
                </span>
                <br/>
            </s:if>
            <s:if test="#pgName=='/login/shibDisabled'">
                <span id="MessageDIV" class="MessageDIVClass">
                    Access disabled, please contact administrator.
                </span>
                <br/>
            </s:if>
        </fieldset>
    </div>
</div>
