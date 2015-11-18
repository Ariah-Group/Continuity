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
<!--  NOT USED ANYMORE; TO BE DELETED -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<noscript>
    <font class="AttentionBold">
    Continuity Planning Tool application requires Javascript to be enabled on your browser to operate properly.<br>
    Make sure that Javascript is enabled or ask your computer support for help.
    </font>
</noscript>

<!--  NOT USED ANYMORE; TO BE DELETED -->
<div id="footer">
    <a href="http://www.ucop.edu">UC Home</a> |
    <a href="./contactUs">Contact Us</a>
    <br />
    <div id="copyright">Powered by <em>Ariah Continuity</em>. Copyright &copy; 2015, The Ariah Group, Inc. All rights reserved.</div>
    <div id="copyright">Release ${application.release.version} on 
        <s:property value="#context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest').getServerName()"/>
    </div>
</div>