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
<!-- /Include/ShowContactSearch.cfm -->

<span class="NoWrap">
    First Name <s:textfield cssClass="UserFirstNameClass" id="UserFirstName" name="UserFirstName" maxlength="20"/>&nbsp;
    Last Name <s:textfield cssClass="UserLastNameClass" id="UserLastName" name="UserLastName" maxlength="30"/>
    <!--- DirectoryAccess = 1 means institution is LDAP-enabled --->
    &nbsp;&nbsp;
    <s:if test="#session.user.systemDomain.isDirAccessible == true">
        <s:set name='imgTitle' value='Search the directory'/>
    </s:if>
    <s:else>
        <s:set name='imgTitle' value='Search Accounts'/>            
    </s:else>
    <a id="searchUsers" href="javascript:getSystemDomainUsers(<s:property value='#context.parameters.contactTable'/>)">
        <img 
            src='/kcpt/images/Search_aqua.gif' 
            class='NavMiddleImagesClass'
            title='<s:property value='#imgTitle'/>'
        />
    </a>
    <s:hidden cssClass="UserInstitutionIDClass" id="UserSystemDomainId" name="UserSystemDomainId" value="%{#context.parameters.systemDomainId}"/>
</span>
<div id="userList"></div>   
<br>
<span id="UserShowID" class="UserShowDIVClass"></span>