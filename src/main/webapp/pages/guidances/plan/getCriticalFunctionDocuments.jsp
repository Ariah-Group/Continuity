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
<!--- Guidance for documents.cfm screen --->
<ul>
<li>Here you can identify any documents that are important to this <s:property value='#session.systemDomain.displayConstants.criticalLower'/> function.</li>
<li>Documents uploaded via this screen are copied to a secure server, for access by authorized people only. They also remain in their current location on your own computer or server. </li>
<li>If a document is <strong>confidential</strong> or <strong>sensitive</strong>, please describe it but do not upload it.  Although your plan lives on a secure server, any current user of your plan can grant access privileges to anyone else.  See <a href="./getPlanUsers">List of Authorized Users</a>.</li>

<li>Users of Word 2007 and Excel 2007 -- Please convert your documents to 2003 format before uploading. In Word or Excel, do a "Save As". Then, in the "Save as type" box, choose Word 2003 or Excel 2003. </li>
</ul>
