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
<s:set var="beginPage" value="%{#request['javax.servlet.forward.context_path'] + '/plan/begin'}"/>
<div id="logoutcontainer"> 
  <h1>You are now logged out of the Continuity Planning Tool.</h1>
  <s:if test="exception != null && exception != ''">
  	<p><s:property value='exception'/></p>
  	
  	<ul class="domainurl">
  		 <s:iterator value="domainDTOList">								
			<li>					
				<a href='<s:property value="url"/>'> <s:property value="name"/> </a>									
			</li>			
		 </s:iterator>
  	 </ul> 
  </s:if>
  <s:else>
  <p>Be sure to close your browser window to ensure your logout is complete.</p>
  <br/>
  <a href="<s:property value='backUrl'/>">Click here to log in again.</a>
  </s:else>
</div>
