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
<LINK REL="stylesheet" TYPE="text/css" HREF="/kcpt/css/plan/planUsersTable.css">
<script type="text/javascript" src="/kcpt/javascripts/plan/planUsersTableLibrary.js"></script>

<p class="plan">Continuity Plan for <span id="planname"><s:property value="#session.plan.acronymPlusName"/></span></p>

<div id="innertube">

    <h1>Add or Remove Authorized Users of This Plan</h1>
    
    <p class="StandardWidth">Listed below are the persons who have on&ndash;line access to this Plan.</p>
    <p class="StandardWidth">To authorize additional users, enter the requested information for each, then hit &ldquo;Add to List&rdquo;.  </p>
    <p class="StandardWidth">When done, hit &ldquo;Update Plan Users&rdquo;.  The new users will each receive an email informing them that they have been given access to this Plan.</p>
    <p class="StandardWidth">You may return at any time to change a person's &ldquo;Access&rdquo; or &ldquo;Gatekeeper&rdquo; status.</p>
    <p class="StandardWidth"><strong>Please note:  Gatekeepers control access to this Plan.</strong>  Only Gatekeepers like yourself can reach this screen &amp; add people to this list. We recommend that at least 1 or 2 people in addition to  yourself be Gatekeepers.   This is a security feature &ndash; see Guidance at right.</p>
    
    <s:include value="/pages/custom/%{#session.loginSystemDomain.customUrl}/getPlanUsers.jsp"/>
    <br/>

    <!--- get PlanUserAccessSet --->
    <s:set name='AccessList' value='""'/>
    <s:iterator var='planAccessType' value='planAccessTypes' status='rowstatus'>
        <s:set name='AccessList' value='%{#AccessList + id + "," + description}'/>
        <s:if test='#rowstatus.last == false'>
            <s:set name='AccessList' value='%{#AccessList + ","}'/>
        </s:if>
    </s:iterator>
        
    <s:form id="PlanUsers" name="PlanUsers" action='savePlanUsers'>
     
        <table>
		    <thead>
		        <tr>
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>EMail <span class="AttentionClassNotBold">(official email from campus directory)</span></th>
		            <th>Phone</th>
		            <th bgcolor="white">
                        <img src="/kcpt/images/spacer.gif" width="210px" height="20px">
                    </th>
		        </tr>
	            <tr class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	                <td><s:textfield id="user.firstName" name="user.firstName" cssClass="UserFirstNameClass"/></td>
	                <td><s:textfield id="user.lastName" name="user.lastName" cssClass="UserLastNameClass"/></td>
	                <td><s:textfield id="user.emailRegular" name="user.emailRegular" cssClass="UserEMailClass "/></td>
                    <td><s:textfield id="user.workPhone" name="user.workPhone" cssClass="UserPhoneClass "/></td>
	                <td bgcolor="white">
	                    <span
	                        id="searchUsers" 
	                        onmouseout="this.className='myLink <s:property value='#hideClass'/>';" 
	                        onmouseover="this.className='myLinkOver <s:property value='#hideClass'/>';" 
	                        class="myLink <s:property value='#hideClass'/>" 
	                        title='add user'
	                        onclick="AddUserRow(
	                            document.getElementById('user.firstName').value,
	                            document.getElementById('user.lastName').value,
	                            document.getElementById('user.emailRegular').value,
	                            document.getElementById('user.workPhone').value, 
	                            '<s:property value='contactTable'/>',
	                            '<s:property value='#AccessList' escapeJavaScript='true'/>');">
	                            <img src="/kcpt/images/Add_to_List.gif" alt='add user'/>
	                    </span>
	                </td>
	            </tr>
		    </thead>
		</table>
		
		<br/>
		<!-- error line -->
		<s:include value="/pages/widget/ActionErrors.jsp" />
       
        <div class="MyButtonsDivClass">
            <div class="FloatLeft AllignLeft">
                <input id="back"
                   class="ButtonClass" 
                   type="button" 
                   name="back" 
                   value="       Back      " 
                   onclick="location.href='./planHome';" 
                   alt="Return back"
                   title="Return back"/>
            </div>
            
           
            <div class="FloatRight AllignRight <s:property value='#session.planAccessControl.noDisplayClass'/>">
                <input id="UpdatePlanUsers"
                   class="ButtonClass" 
                   type="button" 
                   name="UpdatePlanUsers" 
                   value=" Update Plan Users "
                   onclick="SubmitPlanUsers('<s:property value="#session.plan.acronymPlusName" escapeJavaScript="true"/>', 'PlanUsers');" 
                   alt="Update Plan (<s:property value="#session.plan.acronymPlusName" escapeJavaScript="true"/>) Users"
                   title="Update Plan (<s:property value="#session.plan.acronymPlusName" escapeJavaScript="true"/>) Users"/>
            </div>
        </div>
       
        <s:hidden cssClass="MessageStringClass" name="MessageString" value=""/>
        <s:hidden cssClass="MessageLinkClass" name="MessageLink" value=""/>
        <s:hidden cssClass="TotalRowsClass" name="TotalRows" value="#StartRow#"/>
        
        <br/>
		<hr/>
        <br/>
		
		<strong>Current Authorized Users:</strong>

        <div class="FormDivClass">
            <s:include value="planUsersTable.jsp"/>
        </div>

        <br />
       
       <s:token />
       
    </s:form>

</div>

<!--<div style="visibility:hidden">-->
<!--    <cfwindow name="PlanUsers" center="true" closable="true" height="215" draggable="true" initshow="false" resizable="false" width="644" title="Add Plan Users" headerstyle="background-color:##E9E9E9;color:black;" bodystyle="background-color: ##CBF2FE;"></cfwindow>-->
<!--</div>-->
