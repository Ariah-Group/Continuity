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
<noscript>
    <font class="AttentionBold">
    Continuity Planning Tool application requires Javascript to be enabled on your browser to operate properly.<br>
    Make sure that Javascript is enabled or ask your computer support for help.
    </font>
</noscript>

<s:set var="ns" value="#request['javax.servlet.forward.servlet_path'].substring(1,6)"/>
<s:set var="beginPage" value="%{#request['javax.servlet.forward.context_path'] + '/plan/begin'}"/>
<s:set var="contactUsPage" value="%{#request['javax.servlet.forward.context_path'] + '/plan/contactUs'}"/>
<s:set var="acknowledgmentsPage" value="%{#request['javax.servlet.forward.context_path'] + '/plan/acknowledgments'}"/>
<s:if test="#ns == 'login'">
    <s:set var="contactUsPage" value="'mailto:info@ariahgroup.org'"/>
</s:if>
<div id="footer">
	<s:if test="#ns != 'login'">
        <a href="<s:property value='#beginPage'/>">Home</a> |
    </s:if>
    <a href="<s:property value='#contactUsPage'/>">Contact Us</a>
    <s:if test="#ns != 'login' && #ns != 'logou'">
         | <a href="<%=request.getContextPath()%>/j_spring_security_logout">Logout</a>
    </s:if>
    <br />
    <div id="copyright">
    	Powered by <em>Ariah Continuity</em>. Copyright &copy; 2015, The Ariah  Group, Inc. All rights reserved.<br />
    	Portions of <em>Ariah Continuity</em> are copyrighted by other parties as described on the <a href="<s:property value='#acknowledgmentsPage'/>">Acknowledgments</a> page.<br />
    	Release ${application.release.version} on <s:property value="#context.get('com.opensymphony.xwork2.dispatcher.HttpServletRequest').getHeader('Host')"/>
    </div>
</div>	