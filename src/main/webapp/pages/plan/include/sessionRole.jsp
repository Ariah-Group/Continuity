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

<div id="innertube">
	<div class="FormDivClass">
	
	    <h1>Emulation Screen -- For Administrators Only.</h1>
	
	    <p class="StandardWidth">System Administrators can use this screen to emulate any  location/role. Institution administrators can do the same <em>within their institution only</em>.
	    <br /><br />
	    </p>
	
	    <s:form name="MySessionForm" action="setNewSessionRole">
	        <table cellpadding="1" cellspacing="1">
	            <tr>
	                <td nowrap="nowrap"><b>Current Location/Role</b></td>
	                <td width="100%"><hr></td>
	            </tr>
	        </table>
	            
	        Location <s:textfield readonly="yes" cssClass="CurLocationNameClass  ReadOnly" name="CurLocationName" value="%{#session.user.systemDomain.name}"/>
	        Role <s:textfield readonly="yes" cssClass="CurRoleNameClass  ReadOnly" name="CurRoleName" value="%{#session.user.securityType.description}"/>
	        <br /><br /><br />
	        
	        <table cellpadding="1" cellspacing="1">
	            <tr>
	                <td nowrap="nowrap"><b>Original Location/Role</b></td>
	                <td width="100%"><hr></td>
	            </tr>
	        </table>
	        
	        Location <s:textfield readonly="yes" cssClass="OrgLocationNameClass  ReadOnly" name="OrgLocationName" value="%{#session.systemAdminUser.systemDomain.name}"/>
	        Role <s:textfield readonly="yes" cssClass="OrgRoleNameClass  ReadOnly" name="OrgRoleName" value="%{#session.systemAdminUser.securityType.description}"/>
	        <br /><br /><br />
	
	        <table cellpadding="1" cellspacing="1">
	            <tr>
	                <td nowrap="nowrap"><b>New Location/Role</b></td>
	                <td width="100%"><hr></td>
	            </tr>
	        </table>
	        
	        Location
	        <s:select
	            cssClass="NewLocationNameSelectClass"
	            name="systemDomainId"
	            list="adminListMap['SystemDomain']"
	            listKey="id"
	            listValue="name"/>
	        Role
	        <s:select
	            cssClass="NewRoleNameSelectClass" 
	            name="securityTypeId"
	            list="refListMap['SecurityType']"
	            listKey="id"
	            listValue="description"/>
	        <br /><br />
	
		    <!-- error line -->
		    <s:include value="/pages/widget/ActionErrors.jsp" />
		    <br />
	    
		    <div class="MyButtonsDivClass">
		        <div class="FloatLeft">
		            <input 
		                name="back" 
		                id="back"  
		                type="button" 
		                value="      Back     " 
		                title="Return"  
		                alt="Go back"  
		                onclick="window.history.go(-1);"
		            />
		        </div>
		        <div  class="FloatRight">
		            <s:submit title="Set new Location/Role" cssClass="ButtonClass" name="SetNew" value=" Set new Location/Role " onclick="this.form.action='setNewSessionRole'"/>
		            <s:submit title="Restore Location/Role" cssClass="ButtonClass" name="RestoreOld" value=" Restore Location/Role " onclick="this.form.action='restoreSessionRole'"/>
		        </div>
		    </div>
		    
		    <s:token />
	
	    </s:form>
	
	</div>
</div>