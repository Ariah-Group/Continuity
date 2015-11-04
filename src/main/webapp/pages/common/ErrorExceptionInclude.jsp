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
            <p>We're sorry -- An Error Occurred</p>
            
            <ul>
                <li><b>Your Location:</b> <s:property value="#context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest').getRemoteAddr()"/></li>
                <li><b>Your Browser:</b> <s:property value="#context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest').getHeader('User-Agent')"/></li>
                <li><b>Date and Time the Error Occurred:</b> <%= new java.util.Date() %></li>
                <li><b>Page You Came From:</b> <s:property value="#context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest').getHeader('Referer')"/></li>
                <li><b>Page Error Occured:</b> <s:property value="#request['struts.request_uri']"/></li>
                <li><b>Message Content</b>:
                <p><s:property value="exception"/></p></li>
            </ul>
            
        </fieldset>
    </div>
</div>