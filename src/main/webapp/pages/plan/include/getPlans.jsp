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

<s:include value="getPlansFloatingPanel.jsp"/>

<div id="innertube">

<h1>Choose a Plan</h1>

<div class="tagline">
    Listed below are the plans for <s:property value="systemDomainName"/>.
</div>

<s:include value="/pages/custom/%{#session.systemDomain.customUrl}/getPlans.jsp"/>

<div class="MyHeaderDivClass AllignRight"><a
	href="/kcpt/plan/editPlan"> <img src="/kcpt/images/create_new.gif"
	class="NavTopImagesClass" title="Create New Plan" alt="Create New Plan"
	width="120" height="27" border="0" /> </a>
</div>

<div class="MyHeaderDivClass">
	<table id="planTable">
		<thead>
			<tr>
				<th scope="col">Plan Name</th>
				<s:if test="#session.user.securityType.id == 0 || #session.user.securityType.id == 1 || #session.user.securityType.id == 3">
	                <th scope="col" class="CenterIt">Plan ID</th>
				</s:if>
				<th scope="col" class="CenterIt">Created</th>
				<th scope="col" class="CenterIt">Last Accessed</th>
				<th scope="col" class="CenterIt">Status</th>
				<th scope="col" class="CenterIt">To gain <br/>access,<br/>contact ...</th>
				<th colspan="2" scope="col" class="CenterIt">Actions</th>
			</tr>
		</thead>
	
		<tbody>
            <s:iterator var="plan" value="plans" status="rowstatus">
                <tr <s:if test="#rowstatus.odd == true">class='AltRowColor'</s:if>>
                    <td><s:property value="acronymPlusName"/></td>
                    <s:if test="#session.user.securityType.id == 0 || #session.user.securityType.id == 1 || #session.user.securityType.id == 3">
                        <td class="CenterIt"><s:property value="id"/></td>
                    </s:if>
                    <td>
                        <s:if test="isImported == true">
                            (imported)
                        </s:if>
                        <s:else>
                            <s:date format="MM/dd/yyyy" name="createdDate"/>
                        </s:else>
                    </td>
                    <td class="CenterIt">
                        <s:date format="MM/dd/yyyy" name="lastModifiedDate"/>
                    </td>
                    <td nowrap="nowrap"><s:property value="status.description"/></td>
                    <td class="CenterIt">
                        <s:if test="contactsCount != 0">
                            <span id="showPanel" class="myLink"
                                  title="Show (<s:property value='acronymPlusName' escape='true'/>) Contacts Info"
                                onclick="showPlanContacts(<s:property value='id'/>, '<s:property value='acronymPlusName' escapeJavaScript='true'/>');">
                                <img src="/kcpt/images/Contacts.png" />
                            </span>
                        </s:if>
                        <s:else>
                            <img src="/kcpt/images/spacer.gif" width="2px" height="24px"/>
                        </s:else>
                    </td>
                    <td>
                        <s:if test="planAccess != null && planAccess.id != null && planAccess.id != '9'">
                            <a href="javascript: submitForm(<s:property value='id'/>);">
                                <img src="/kcpt/images/goto.gif" class="NavAbsMiddleImagesClass" 
                                   title="Go to (<s:property value='acronymPlusName' escape='true'/>) Plan"
                                     alt="Go to  (<s:property value='acronymPlusName' escape='true'/>) Plan" 
                                   width="59" height="27" border="0"/>
                            </a> 
                        </s:if>
                        <s:else>
                            No Access 
                        </s:else>
                    </td>
                    <td>
                        <s:if test="#session.user.securityType.id == 0 || #session.user.securityType.id == 1 || #session.user.securityType.id == 3">
                            <a href="javascript:deleteFormRow(<s:property value='id'/>);"
                                onClick="return confirm('Delete plan (<s:property value='acronymPlusName' escapeJavaScript='true'/>): are you sure?');">
                                <img src="/kcpt/images/delete_sm.gif" 
                                   class="NavAbsMiddleImagesClass"
                                   title="Delete (<s:property value='acronymPlusName' escape='true'/>) Plan"
                                     alt="Delete (<s:property value='acronymPlusName' escape='true'/>) Plan"
                                   width="35" height="18" border="0">
                            </a>
                        </s:if>
                        <s:else>&nbsp;</s:else>
                    </td>
                </tr>
            </s:iterator>  	
		</tbody>
	</table>
</div>

<s:form name="SelectPlan" action="planHome">
    <s:hidden name="planId"/>
</s:form>

<s:form name="DeleteForm" action="deletePlan">
    <s:hidden id="dRowId" name="planId"/>
    <s:token />
</s:form>

</div>