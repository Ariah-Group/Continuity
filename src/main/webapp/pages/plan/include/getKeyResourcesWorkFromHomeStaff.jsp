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
<s:form action="updateKeyResourcesWorkFromHomeStaff">
    <h1>Work from Home<a name="bookmark" id="bookmark">&nbsp;</a></h1>

    <p>Many of us have jobs that could be done (at least partially) from home.&nbsp; 
    Please list below the names of <span style="text-transform: lowercase">
    <s:property value='#session.systemDomain.displayConstants.facultyPreparePrint'/></span> 
    and staff <strong>who could do at least part of their work from home</strong> 
    if they had adequate computers and high-speed internet access. </p>
    
    <p>It is assumed that all faculty belong in this group, so please list them along with staff.</p>

	<s:hidden name="dto.id"/>

	<s:include value="/pages/plan/include/editKeyResourcesWorkFromHomeStaff.jsp" />

	<div class="update_button <s:property value='#session.planAccessControl.noDisplayClass'/>">
	    <s:submit
	        name="Update" 
	        value="Update"/>
	</div>

    <s:token />
</s:form>