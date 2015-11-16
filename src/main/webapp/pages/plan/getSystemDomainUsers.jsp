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
<!-- Include/ShowLDAPSearch.cfm -->

    Institution - <s:property value="systemDomain.name"/> <span class="AttentionClassNotBold">[<s:property value="usersCount"/> record(s) found]. If an upper limit prevents all names from displaying, narrow your search by typing one more character. </span>
    
    <br><br>

    <div class="ShowLdapSearch">

        <!--- get PlanUserAccessSet --->
        <s:set name='AccessList' value='""'/>
        <s:iterator var='planAccessType' value='planAccessTypes' status='rowstatus'>
            <s:set name='AccessList' value='%{#AccessList + id + "," + description}'/>
            <s:if test='#rowstatus.last == false'>
                <s:set name='AccessList' value='%{#AccessList + ","}'/>
            </s:if>
        </s:iterator>
        
		<!--- plan user pickup --->
		<table class="UserSelectTable">
		    <thead>
		    <tr class="SearchTableHeader">
		        <th width="25%" align="left" scope="col">Name</th>
		        <th width="30%" align="left" scope="col">Email</th>
		        <th width="35%" align="left" scope="col">Department</th>
		        <th width="10%" scope="col"><img src="/continuity/images/spacer.gif" width="1px" height="20px"></th>
		    </tr>
		    </thead>
		    <tbody>
		    <s:iterator value="users" var="user">
		        <tr>
		            <td align="left"><s:property value="lastName"/> <s:property value="firstName"/></td>
		            <td align="left"><s:property value="emailRegular"/></td>
		            <td align="left"><s:property value="departmentName"/></td>
		            <td align="left">
						<img onClick="AddUserRow(
							'<s:property value='id'/>',
                            <s:if test="#session.systemDomain.isDirAccessible == true">
							    '',
							</s:if>
							<s:else>
                                   '<s:property value='id'/>',
							</s:else>
							'<s:property value='firstName' escapeJavaScript='true'/>',
							'<s:property value='lastName' escapeJavaScript='true'/>',
							'<s:property value='emailRegular' escapeJavaScript='true'/>',
							'<s:property value='workPhone' escapeJavaScript='true'/>',
							'<s:property value='workFax' escapeJavaScript='true'/>',
							'<s:property value='departmentName' escapeJavaScript='true'/>',
							'<s:property value='departmentOrg' escapeJavaScript='true'/>',
							'<s:property value='departmentOrgHierarchy' escapeJavaScript='true'/>',
							'<s:property value='title' escapeJavaScript='true'/>',
							'<s:property value='directoryId' escapeJavaScript='true'/>',
							'<s:property value='#parameters.contactTable' escapeJavaScript='true'/>',
							'<s:property value='#AccessList' escapeJavaScript='true'/>');"
						class="NavTopImagesClass" 
						src="/continuity/images/Add_to_List_aqua.gif" 
						title="Click to Add" 
						alt="Click to Add" 
						border="0"/>
		            </td>
		        </tr>
		    </s:iterator>
		    </tbody>
		</table>
    </div>