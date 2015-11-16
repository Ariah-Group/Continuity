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

<!-- Include Ext and app-specific scripts: -->
<script type="text/javascript" src="/continuity/javascripts/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="/continuity/javascripts/ext/ext-all-debug.js"></script>
<script type="text/javascript" src="/continuity/javascripts/ext/continuity/accounts.js"></script>
<script type="text/javascript" src="/continuity/javascripts/accountsLibrary.js"></script>

<!-- Include Ext stylesheets here: -->
<link rel="stylesheet" type="text/css" href="/continuity/css/ucreadyAdminElements.css">
<link rel="stylesheet" type="text/css" href="/continuity/javascripts/ext/resources/css/ext-all.css">

<!--- Accounts Control module --->
<!--- accessible by System Admin and Local Admins --->

<!--<cfajaxproxy cfc = "#Request.CFC#.Accounts" jsclassname = "Accounts">-->
<!---->
<!--<cfif NOT IsDefined("This.myAccounts")>-->
<!--	<cfobject component="#Request.CFC#.Accounts" name="This.myAccounts">-->
<!--</cfif>-->
<!---->
<!--<cfif NOT IsDefined("This.myAccessLDAP")>-->
<!--	<cfobject component="#Request.CFC#.AccessLDAP" name="This.myAccessLDAP">-->
<!--</cfif>-->
<!---->
<!---->

<s:if test="currentSystemDomain.authType == 1">
	<s:set name="DirAccessClass" value="''" />
</s:if>
<s:else>
	<s:set name="DirAccessClass" value="'HiddenControl'" />
</s:else>

<div class="AdminSite">
	<h1>Role Management</h1>
	<p class="StandardWidth">Please use this page to manage user accounts and access roles.</p>
	<p>To modify an existing item, first highlight that row on the grid then use the entry-forms at bottom to modify.<br /><br /></p>
	
	<s:form name="AccountForm" action="" method="post">

		<span class="myGridClass"><s:div name="AccountGrid" id="AccountGrid"/></span>
	
<!--<cfgrid name="AccountGrid" format="html" pagesize=8 selectcolor="##C0ADA5"-->
<!--	sort="yes" colheaderbold="yes" selectmode="row" selectOnLoad="false"-->
<!--	preservePageOnSort="true"-->
<!--	bind="cfc: #Request.CFC#.Accounts.GetAccountSet({cfgridpage},{cfgridpagesize},-->
<!--	{cfgridsortcolumn}, {cfgridsortdirection},{InstitutionSelect}, {UserRole},-->
<!--	 GetAccountSearchString1(), GetAccountSearchString2(), GetAccountSearchString3())">-->
<!--	<cfgridcolumn name = "UserID"  display="false">-->
<!--	<cfgridcolumn name = "FirstName"  display="false">-->
<!--	<cfgridcolumn name = "LastName"  display="false">-->
<!--	<cfgridcolumn name = "InstitutionID"  display="false">-->
<!--	<cfgridcolumn name = "Institution"  display="false">-->
<!--	<cfgridcolumn name = "AccessStatus"  display="false">-->
<!--	<cfgridcolumn name = "WorkFax"  display="false">-->
<!--	<cfgridcolumn name = "SecurityType"  display="false">-->
<!--	<cfgridcolumn name = "SecurityAttribute"  display="false">-->
<!--	<cfgridcolumn name = "DepartmentOrg"  display="false">-->
<!--	<cfgridcolumn name = "DepartmentName"  display="false">-->
<!--	<cfgridcolumn name = "DepartmentOrgHierarchy"  display="false">-->
<!--	<cfgridcolumn name = "Title"  display="false">-->
<!--	<cfgridcolumn name = "DirectoryAccess"  display="false">-->
<!--	<cfgridcolumn name = "Location"  display="false" header="Location">-->
<!--	<cfgridcolumn name = "UserName" display="true"  header="Name" width="138">-->
<!--	<cfgridcolumn name = "AuthID"  display="true" header="Login Name" width="150">-->
<!--	<cfgridcolumn name = "EMailRegular"  display="true" header="Email" width="150">-->
<!--	<cfgridcolumn name = "WorkPhone" display="false"  header="Phone" width="100">-->
<!--	<cfgridcolumn name = "DirectoryID"  display="true" header="Directory ID" width="120">-->
<!--	<cfgridcolumn name = "RoleIcon"  display="true" header="Role" width="36">-->
<!--	<cfgridcolumn name = "Access"  display="true"  header="Access" width="50">-->
<!--	<cfgridcolumn name = "BlankField"  display="false">-->
<!--</cfgrid>-->
<!--</span>-->

		<!--- decide how editable accounts will be (this code based on include/AccessControl) --->
	
		<!--- SHIB SHIB SHIB SHIB SHIB --->
		<s:if test="currentSystemDomain.authType == 1">
			<!--- read only --->
<!--		<s:set name="Request.OptionAdmin.MyInputControlsAccess" value='readonly="yes"' />-->
			<s:set name="Request.OptionAdmin.MyInputControlsAccess" value="true" />
			<s:set name="Request.OptionAdmin.MySelectControlsAccess" value="'disabled'" />
			<s:set name="Request.OptionAdmin.AddClass" value="'ReadOnly'" />
			<s:set name="Request.OptionAdmin.NoDisplayClass" value="'NoToDisplay'" />
			<s:set name="Request.OptionAdmin.DisplayClass" value="''" />
			<s:set name="Request.OptionAdmin.HideClass" value="'HideElement'" />
			<s:set name="Request.OptionAdmin.ShowClass" value= "''" />
		</s:if>
		<s:else>
			<!--- default to allow modify --->
<!--		<s:set name="Request.OptionAdmin.MyInputControlsAccess" value=''/>-->
			<s:set name="Request.OptionAdmin.MyInputControlsAccess" value="false" />
			<s:set name="Request.OptionAdmin.MySelectControlsAccess" value="''" />
			<s:set name="Request.OptionAdmin.AddClass" value="''" />
			<s:set name="Request.OptionAdmin.NoDisplayClass" value="''" />
			<s:set name="Request.OptionAdmin.DisplayClass" value="'NoToDisplay'" />
			<s:set name="Request.OptionAdmin.HideClass" value="''" />
			<s:set name="Request.OptionAdmin.ShowClass" value="'HideElement'" />
		</s:else>
		
		<br />

		<span class="HiddenControl">
			<s:select cssClass="AuthSelectClass" id="AuthSelect" name="AuthSelect" list="systemDomains" listValue="value.authType"/>
			<s:select cssClass="DirectoryAccessSelectClass" id="DirectoryAccessSelect" name="DirectoryAccessSelect" list="systemDomains" listValue="value.authType"/>
		</span>

		<span class="NoWrap"> 
			<s:select cssClass="InstitutionSelectClass" id="InstitutionSelect" name="InstitutionSelect" list="systemDomains" listValue="value.institution"
				onchange="javascript: this.form.InstitutionID.value = this.form.InstitutionSelect.value; this.form.AuthSelect.value = this.form.InstitutionSelect.value; this.form.DirectoryAccessSelect.value = this.form.InstitutionSelect.value; CheckAuth();"/>
			<span class="%{DirAccessClass}" id="DirSearch">
				First Name <s:textfield cssClass="UserFirstNameClass" name="FirstName" value="" maxlength="20"/>
				Last Name <s:textfield cssClass="UserLastNameClass" name="LastName" value="" maxlength="30"/>
				<img class="NavMiddleImagesClass"  onclick="#" src="/continuity/images/Search2.gif" title="Search the directory" alt="Search the directory">
<!--				LDAPSearch('InstitutionSelectClass','UserFirstNameClass', 'UserLastNameClass');" src="/continuity/images/Search2.gif" title="Search the directory" alt="Search the directory">-->
		 	</span>
		</span>
	 	<p>This locaton is configured for UC Trust authentication.  Only Role and Access fields could be updated.</p>
	
		<table id="list_table">
			<tr>
				<td width="13%" nowrap="nowrap">
					<span class="required">*</span>First Name
				</td>
				<td width="87%" colspan="3">
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountFirstNameClass %{Request.OptionAdmin.AddClass}" name="AccountFirstName" id="AccountFirstNameID" value="" maxlength="20" />
					<span class="required">*</span>Last Name
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountLastNameClass %{Request.OptionAdmin.AddClass}" name="AccountLastName" id="AccountLastNameID" value="" maxlength="30" />
					<span class="required">*</span>Role
					<s:select cssClass="AccountRoleSelectClass" id="AccountRoleSelect" name="AccountRoleSelect" list="userRoles" listKey="id" listValue="description" headerKey="" headerValue="--Select Role--"/>
				</td>
			</tr>
			<tr>
				<td>Title</td>
				<td colspan="3">
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountTitleClass  %{Request.OptionAdmin.AddClass}" name="AccountTitle" id="AccountTitleID"  value="" maxlength="50" />
				</td>
			</tr>
			<tr>
				<td>Department</td>
				<td colspan="3">
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountDepartmentNameClass %{Request.OptionAdmin.AddClass}" name="AccountDepartmentName" id="AccountDepartmentNameID" value="" maxlength="100" />
				</td>
			</tr>
			<tr>
				<td>EMail</td>
				<td colspan="3">
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountEMailClass  %{Request.OptionAdmin.AddClass}" name="AccountEMail" id="AccountEMailID" value="" maxlength="50" />
					Phone
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountPhoneClass  %{Request.OptionAdmin.AddClass}" name="AccountPhone" id="AccountPhoneID" value="" maxlength="20" />
					Access								
					<s:select cssClass="AccountAccessSelectClass" name="AccountAccessSelect" id="AccountAccessSelect" list="userAccess" listKey="id"/>
				</td>
	 		</tr>
			<tr>
				<td nowrap="nowrap">
					<span class="required">*</span>Login Name
				</td>
				<td>
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountAuthIDClass  %{Request.OptionAdmin.AddClass}" name="AccountAuthID" id="AccountAuthIDID" value="" maxlength="256" />
				</td>
				<td colspan="2" align="right" >
					<span class="required">*</span>Password
					<s:password readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountPasswordClass  %{Request.OptionAdmin.AddClass}" name="AccountPassword" id="AccountPasswordID" value="" maxlength="20" />
				</td>
	 		</tr>
			<tr class="%{DirAccessClass}" id="DirID">
				<td nowrap="nowrap">
					<span class="required">*</span>DirectoryID
				</td>
				<td colspan="3">
					<s:textfield readonly="%{Request.OptionAdmin.MyInputControlsAccess}" cssClass="AccountDirectoryIDClass  %{Request.OptionAdmin.AddClass}" name="AccountDirectoryID" id="AccountDirectoryIDID"  value="" maxlength="256" />
				</td>
			</tr>
		</table>
		<br />
		
<!--		<s:div id="MessageDIV" cssClass="MessageDIVClass" tagname="SPAN" />-->
		<div class="MyButtonsDivClass">
			<div class="FloatLeft">
				<input class="ButtonClass" onClick="window.history.go(-1);" type="button" name="back" value="      Back     " alt="Return back" title="Return back"/>
			</div>
			<div  class="FloatRight">
				<input type="button" class="ButtonClass" name="Insert" value=" Insert Account "
					onClick="#" />
<!--					InsertAccount('AccountGrid', this.form.InstitutionID.value, this.form.AccountAuthID.value, this.form.AccountFirstName.value, this.form.AccountLastName.value, this.form.AccountEMail.value, this.form.AccountPhone.value, this.form.AccountWorkFax.value,this.form.AccountDepartmentName.value, this.form.AccountDepartmentOrg.value, this.form.AccountDepartmentOrgHierarchy.value, this.form.AccountTitle.value, this.form.AccountAccessSelect.value, this.form.AccountRoleSelect.value, this.form.AccountPassword.value, this.form.AccountDirectoryID.value); "/>-->
				<input type="button" class="ButtonClass" name="Update" value=" Update Account "
					onClick="#" />
<!--					UpdateAccount('AccountGrid',this.form.InstitutionID.value,  this.form.UserID.value, this.form.AccountAuthID.value, this.form.AccountFirstName.value, this.form.AccountLastName.value, this.form.AccountEMail.value, this.form.AccountPhone.value, this.form.AccountWorkFax.value, this.form.AccountDepartmentName.value, this.form.AccountDepartmentOrg.value, this.form.AccountDepartmentOrgHierarchy.value, this.form.AccountTitle.value, this.form.AccountAccessSelect.value, this.form.AccountRoleSelect.value, #Request.UserData.UserID#, '#Request.UserData.SecurityType#', this.form.AccountPassword.value, this.form.AccountDirectoryID.value); "/>-->
				<input type="button" class="ButtonClass" name="Delete" value=" Delete Account "
					onClick="#" />
<!--					DeleteAccount('AccountGrid', this.form.UserID.value, this.form.AccountFirstName.value, this.form.AccountLastName.value, this.form.IntegrityCheck.value, #Request.UserData.UserID#) ;">-->
			</div>
		</div>
		
		<s:hidden cssClass="UserIDClass" name="UserID"  value=""  />
		<s:hidden cssClass="AccountInstitutionIDClass" name="AccountInstitutionID" value="" />
		<s:hidden cssClass="AccountWorkFaxClass" name="AccountWorkFax" value="" />
		<s:hidden cssClass="AccountDepartmentOrgClass" name="AccountDepartmentOrg" value="" />
		<s:hidden cssClass="AccountDepartmentOrgHierarchyClass" name="AccountDepartmentOrgHierarchy" value="" />
		<s:hidden cssClass="DirectoryAccessClass" name="DirectoryAccess" value="" />
		<s:hidden cssClass="InstitutionIDClass" name="InstitutionID" value="#Request.UserData.MemberInstitutionID#" />
		<s:hidden cssClass="AccountRoleClass" name="AccountRole" value="" />
		<s:hidden cssClass="AccountAccessClass" name="AccountAccess" value="" />
		<s:hidden cssClass="UserRoleClass" name="UserRole" value="#Request.UserData.SecurityType#" />
		<s:hidden cssClass="SearchString1Class" name="SearchString1" value="%" />
		<s:hidden cssClass="SearchString2Class" name="SearchString2" value="%" />
		<s:hidden cssClass="SearchString3Class" name="SearchString3" value="#Request.UserData.MemberInstitutionID#" />
		<s:hidden cssClass="MessageStringClass" name="MessageString" value="" />
		<s:hidden cssClass="MessageLinkClass" name="MessageLink" value="" />
		<s:hidden cssClass="IntegrityCheckClass" name="IntegrityCheck" value="YES" />
	
	</s:form>

<!--<cfset AjaxOnLoad("formatAccountgrid")>-->

</div><!--closes admin div-->

<div style="visibility:hidden">
<!--    <window name="LDAPinfo" closable="true" height="300" draggable="true" initshow="false" resizable="true" width="650" title="Directory Search Results" headerstyle="background-color:##E9E9E9;color:black;" bodystyle="background-color: ##CBF2FE;"/>-->
</div>
