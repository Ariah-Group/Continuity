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

<LINK REL="stylesheet" TYPE="text/css" HREF="/continuity/css/plan/planUsersTable.css">
<script type="text/javascript" src="/continuity/javascripts/plan/planUsersTableLibrary.js"></script>

<s:set var="hideClass" value=""/>
<s:set var="isSelectDisabled" value=""/>
<s:if test="newPlan == null || newPlan == false">
    <s:set var="hideClass" value="#session.planAccessControl.hideClass"/>
    <s:set var="isSelectDisabled" value="#session.planAccessControl.isSelectDisabled"/>
</s:if>

<table class="PeopleInfoTable">

    <s:if test="contactTable == true">
        <s:set name='thisElementTitle' value='"contact"'/>
        <s:set name='thisImgSrc' value='"/continuity/images/Add_Contact.gif"'/>
        <s:set name='thisSpacerWidth' value='"1px"'/>
    </s:if>
    <s:else>
        <s:set name='thisElementTitle' value='"user"'/>
        <s:set name='thisImgSrc' value='"/continuity/images/Add_to_List.gif"'/>
        <s:set name='thisSpacerWidth' value='"60px"'/>
    </s:else>
    
    <thead>
        <tr class="TableHeader">
            <s:if test="contactTable == true">
                <th scope="col">
                    <!-- star imaged removed as per JIRA issue KCP 9
                    <img src="/continuity/images/star.png" alt="primary contact" title="primary contact"/>-->
                </th>
            </s:if>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">EMail <s:if test="contactTable == true"><span class="AttentionClassNotBold">(official email from campus directory)</span></s:if></th>
            <th scope="col">Phone</th>
            <s:if test="contactTable == false">
                <th scope="col">Access</th>
                <th scope="col">Gate-<br/>keeper?</th>
            </s:if>
            <th scope="col" bgcolor="white" nowrap="nowrap">
                <img src="/continuity/images/spacer.gif" width="<s:property value='thisSpacerWidth'/>" height="20px">
            </th>
        </tr>

        <s:if test="contactTable == true">
	        <tr class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	            <td></td>
	            <td><s:textfield id="user.firstName" name="user.firstName" cssClass="UserFirstNameClass"/></td>
	            <td><s:textfield id="user.lastName" name="user.lastName" cssClass="UserLastNameClass"/></td>
	            <td><s:textfield id="user.emailRegular" name="user.emailRegular" cssClass="UserEMailClass2 "/></td>
	            <td><s:textfield id="user.workPhone" name="user.workPhone" cssClass="UserPhoneClass "/></td>
				<td bgcolor="white">
				    <span
				        id="searchUsers" 
				        onmouseout="this.className='myLink <s:property value='#hideClass'/>';" 
				        onmouseover="this.className='myLinkOver <s:property value='#hideClass'/>';" 
				        class="myLink <s:property value='#hideClass'/>" 
				        title='add <s:property value='thisElementTitle'/>'
				        onclick="AddUserRow(
				            document.getElementById('user.firstName').value,
				            document.getElementById('user.lastName').value,
				            document.getElementById('user.emailRegular').value,
				            document.getElementById('user.workPhone').value, 
				            '<s:property value='contactTable'/>',
				            '');">
				            <img src="<s:property value='thisImgSrc'/>" alt='add <s:property value='thisElementTitle'/>'/>
				    </span>
				</td>
	        </tr>
        </s:if>
    </thead>

    <tbody id="PeopleInfoTableID">
    
        <s:iterator var="user" value="users" status="rowstatus">
        
            <s:set name="isAccessDisabled" value="false"/>
            <s:if test="#isSelectDisabled == true || users[#rowstatus.index].isGatekeeper == true">
                <s:set name="isAccessDisabled" value="true"/>
            </s:if>

            <tr>
                <s:if test="contactTable == true">
                    <td>
                        <input 
                            type="radio"
                            id="primaryContact[<s:property value='#rowstatus.index'/>]"
                            name="isPrimary"
                            class="PrimaryCheckClass"
                            <s:if test="#isSelectDisabled == true">
                                disabled="true"
                            </s:if>
                            <s:if test="isPrimary == true">
                                value="true"
                                checked="checked"
                            </s:if>
                            <s:else>
                                value="false"
                            </s:else>
                        ></input>
                        <s:hidden id="users[%{#rowstatus.index}].isPrimary" name="users[%{#rowstatus.index}].isPrimary"/>
                    </td>
                </s:if>
                <td><s:textfield readonly="true" id="users[%{#rowstatus.index}].firstName" name="users[%{#rowstatus.index}].firstName" cssClass="UserFirstNameClass ReadOnly"/></td>
                <td><s:textfield readonly="true" id="users[%{#rowstatus.index}].lastName" name="users[%{#rowstatus.index}].lastName" cssClass="UserLastNameClass ReadOnly"/></td>
                <td><s:textfield readonly="true" id="users[%{#rowstatus.index}].emailRegular" name="users[%{#rowstatus.index}].emailRegular" cssClass="UserEMailClass2  ReadOnly"/></td>
                <td><s:textfield readonly="true" id="users[%{#rowstatus.index}].workPhone" name="users[%{#rowstatus.index}].workPhone" cssClass="UserPhoneClass  ReadOnly"/></td>
                <s:if test="contactTable == false">
                    <!--- check if current user --->
                    <s:if test="#session.user.id != id">
                        <td>
	                        <s:select 
                                id="users[%{#rowstatus.index}].planAccessType.id" 
	                            name="users[%{#rowstatus.index}].planAccessType.id" 
	                            cssClass="UserAccessSelectClass"
	                            disabled="%{#isAccessDisabled}" 
	                            list="planAccessTypes"
	                            listKey="id"
	                            listValue="description"
	                        />
                        </td>
	                    <td>
	                        <s:select
                                id="users[%{#rowstatus.index}].isGatekeeper" 
	                            name="users[%{#rowstatus.index}].isGatekeeper" 
	                            cssClass="UserGatekeeperSelectClass"
	                            disabled="%{#isSelectDisabled}" 
	                            list="#{false:'No',true:'Yes'}"
	                            onchange="EnableSelectAccess(document.getElementById('users[%{#rowstatus.index}].planAccessType.id'), this)"
	                        />
	                    </td>
                    </s:if>
                    <s:else>
                        <td>
                            <s:select
                                id="%{'selAccess'+#rowstatus.index}" 
                                name="%{'selAccess'+#rowstatus.index}" 
                                cssClass="UserAccessSelectClass"
                                disabled="true" 
                                list="planAccessTypes"
                                listKey="id"
                                listValue="description"
                                value="%{users[#rowstatus.index].planAccessType.id}"
                            />
                        </td>
                        <td>
                            <s:select
                                id="%{'selGatekeeper'+#rowstatus.index}" 
                                name="%{'selGatekeeper'+#rowstatus.index}" 
                                cssClass="UserGatekeeperSelectClass"
                                disabled="true" 
                                list="#{false:'No',true:'Yes'}"
                                value="%{users[#rowstatus.index].isGatekeeper}"
                            />
                        </td>
                        <s:hidden id="users[%{#rowstatus.index}].planAccessType.id" name="users[%{#rowstatus.index}].planAccessType.id"/>
                        <s:hidden id="users[%{#rowstatus.index}].isGatekeeper" name="users[%{#rowstatus.index}].isGatekeeper"/>
                    </s:else>
                </s:if>
                <td>
                    <!--- check if current user --->
                    <s:if test="contactTable == true || #session.user.id != id">
                        <span 
                            onmouseout="this.className='myLink <s:property value='#hideClass'/>';" 
                            onmouseover="this.className='myLinkOver <s:property value='#hideClass'/>';" 
                            class="myLink <s:property value='#hideClass'/>" 
                            title="delete (<s:property value='fullName'/>) <s:property value='#thisElementTitle'/>"
                            onclick="RemoveUserRow(document.getElementById('users[<s:property value='#rowstatus.index'/>].id'), '<s:property value='contactTable'/>')">
                                delete
                        </span>
                    </s:if>
                    <s:else>
                        &nbsp;
                    </s:else>
                </td>
                <td>
                    <s:hidden id="users[%{#rowstatus.index}].id" name="users[%{#rowstatus.index}].id" cssClass="RowIDClass"/>
                </td>
            </tr>

        </s:iterator>
    
    </tbody>
    
    <s:hidden id="contactTable" name="contactTable"/>
    

</table>