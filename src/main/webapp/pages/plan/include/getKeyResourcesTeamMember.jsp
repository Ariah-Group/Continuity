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
<s:form action="addKeyResourcesTeamMember">
    <h1>Add team member</h1>
    <br /><br />First Name:<s:textfield name="dto.firstName" size="20" maxlength="20"/>
    <br /><br />Last Name:<s:textfield name="dto.lastName" size="30" maxlength="30"/>
    <s:hidden name="dto.teamId"/>
    <br /><br /><s:submit name="add" value="Add"/>
    <s:token />
</s:form>