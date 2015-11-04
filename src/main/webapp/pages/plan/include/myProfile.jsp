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

<!--- allow user to modify their personal data on the UserSecurity row, sometimes --->

<s:if test="user.isShibMode == true">
    <s:set var="MyInputControlsNoAccess" value="true"/>
    <s:set var="AddClass" value="'ReadOnly'"/>
</s:if>
<s:else>
    <s:set var="MyInputControlsNoAccess" value="false"/>
    <s:set var="AddClass" value=""/>
</s:else>

<div id="innertube">

    <h1>My Profile - <s:property value="user.fullName"/></h1>
        
    <p>These are your personal details in the Continuity Planning tool:</p>

    <div class="NoWrap">

	    <h2>Location: <s:property value="#session.user.systemDomain.name"/><s:if test="user.systemDomain.id != #session.user.systemDomain.id"> - <s:property value="user.systemDomain.name"/></s:if></h2>
	    
        <table id="list_table">
         
            <s:form action="saveMyProfile">
        
	            <s:hidden name="user.id"/>
                <s:hidden name="referer"/>
	            <s:hidden name="saveActionType" value="1"/>
	   
	            <tr>
	                <td width="10%"><strong>First Name</strong></td>
	                <td width="25%"><s:textfield readonly="%{#MyInputControlsNoAccess}" cssClass="%{#AddClass}" name="user.firstName" maxlength="40" size="40"/></td>
	                <td width="10%"><strong>Last Name</strong></td>
	                <td width="25%"><s:textfield readonly="%{#MyInputControlsNoAccess}" cssClass="%{#AddClass}" name="user.lastName" maxlength="40" size="40"/></td>
	            </tr>
	
	            <tr>
	                <td width="10%"><strong>Job Title</strong></td>
	                <td width="25%"><s:textfield readonly="%{#MyInputControlsNoAccess}" cssClass="%{#AddClass}" name="user.title" maxlength="50" size="40"/></td>
	                <td width="10%"><strong>Dept</strong>.</td>
	                <td width="25%"><s:textfield readonly="%{#MyInputControlsNoAccess}" cssClass="%{#AddClass}" name="user.departmentName" maxlength="100" size="40"/></td>
	            </tr>
	            
	            <tr>
	                <td width="10%"><strong>EMail</strong></td>
	                <td width="25%"><s:textfield readonly="%{#MyInputControlsNoAccess}" cssClass="%{#AddClass}" name="user.emailRegular" maxlength="50" size="40"/></td>
	                <td width="10%"><strong>Phone</strong></td>
	                <td width="25%"><s:textfield readonly="%{#MyInputControlsNoAccess}" cssClass="%{#AddClass}" name="user.workPhone" maxlength="40" size="40"/></td>
	            </tr>
	            
	            <tr>
	                <td width="10%"><strong>Login Name</strong></td>
	                <td width="25%"><s:textfield disabled="yes" cssClass="ReadOnly" name="user.authId" size="40"/></td>
	                <td width="10%"><strong>Role</strong></td>
	                <td width="25%"><s:textfield disabled="yes" cssClass="ReadOnly" name="user.securityType.description" size="40"/></td>
	            </tr>
	            
	             <s:if test="user.isShibMode == false">
	                 <tr>
	                     <td width="10%"><s:submit name="btnUpdate" value=" Update Details "/></td>
	                     <td colspan=3><s:if test="saveActionType == 1"><s:include value="/pages/widget/ActionErrors.jsp"/></s:if></td>
	                 </tr>
	             </s:if>
	             
	             <s:token />
             
             </s:form>
             
             <s:form action="saveMyPassword">
        
                 <s:hidden name="user.id"/>
                 <s:hidden name="referer"/>
                 <s:hidden name="saveActionType" value="2"/>
       
	             <s:if test="user.isShibMode == false">
	                 <tr>
	                     <td colspan=4><hr></td>
	                 </tr>
	                 <tr>
	                     <td width="10%"><strong>New Password</strong></td>
	                     <td width="25%"><s:password name="password" value="" maxlength="40" size="40"/></td>
	                     <td width="10%"><strong>Confirm</strong></td>
	                     <td width="25%"><s:password name="passwordConfirm" value="" maxlength="40" size="40"/></td>
	                 </tr>
	                 <tr>
	                     <td width="10%"><s:submit name="btnPassword" value="Reset Password"/></td>
                         <td colspan=3><s:if test="saveActionType == 2"><s:include value="/pages/widget/ActionErrors.jsp"/></s:if></td>
	                 </tr>
	                 <tr>
	                     <td colspan=4><hr></td>
	                 </tr>
	             </s:if>
	             
	             <s:token />
	             
	         </s:form>
             
        </table>
        
		<div class="MyButtonsDivClass">
		    <div class="FloatLeft AllignLeft">
		        <form>
		            <input 
		                name="back" 
		                id="back"  
		                type="button" 
		                value="      Back     " 
		                title="Return"  
		                alt="Go back"  
				        <s:if test="referer == null || referer == ''">
                            onclick="window.history.go(-1);"
				        </s:if>
				        <s:else>
                            onclick="location.href='<s:property value='referer'/>';"
				        </s:else>
		            />
		        </form>
		    </div>
		</div>
	
	</div>

</div>    