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
<form method="post" action="createAccount">
    <s:token />
    <div id="logincontainer">
        <div id="login">
            <fieldset>
                <legend>&nbsp;Create a New Account&nbsp;</legend>
                <p></p>
                
                <s:hidden name="dto.systemDomain.id"/>

                <label>First Name: </label>
                <s:textfield name="dto.firstName"/>
                <br /><br />
                
                <label>Last Name: </label>
                <s:textfield name="dto.lastName"/>
                <br /><br />
                
                <label>Email: </label>
                <s:textfield name="dto.emailRegular"/>
                <br/>
                <label>&nbsp;</label>
                <span class="AttentionClassNotBold">(use your official email from the campus directory)</span>
                <br /><br />
                
                <label>Login Name:</label>
                <s:textfield name="dto.authId"/>
                <br /><br />
                
                <strong>Password: </strong>
                a password will be emailed to you at the address above.  
                Because all requests must be approved by the system administrator, 
                there will be a delay.  Thank you for your patience.
                <br /><br />

                <s:include value="/pages/widget/ActionErrors2.jsp" />
                
                <div>
                    <input 
                        name="RequestPassword" 
                        type="submit"
                        class="floatleft" 
                        value="  Request Password  " />
                    <input 
                        name="Exit"
                        type="button" 
                        class="floatright" 
                        value="        Exit        " 
                        onclick="location.href='/kcpt/login/ready?sdname=<s:property value='#session.loginSystemDomain.customUrl'/>'"
                    />
                </div>
                
            </fieldset>
     </div>
   </div>
</form>