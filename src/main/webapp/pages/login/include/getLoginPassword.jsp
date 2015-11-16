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
<form method="post" action="requestLoginPassword">
    <s:token />
    <div id="logincontainer">
        <div id="login">
            <fieldset>
                <legend>&nbsp;Get Login / Password &nbsp;</legend>
                <p></p>
                
                <label>Email: </label>
                <s:textfield name="email"/>
                <br/>
                <label>&nbsp;</label>
                <span class="AttentionClassNotBold">(use your official email from the campus directory)</span>
                <br /><br />
                
                Your login name and a temporary password will be emailed to you at the address above.  Thank you.
                <br /><br />

                <s:include value="/pages/widget/ActionErrors2.jsp" />
                
                <div>
                    <input 
                        name="GetLoginPassword" 
                        type="submit" 
                        class="floatleft" 
                        value="  Get Login / Password  " />
                    <input 
                        name="Exit"
                        type="button" 
                        class="floatright" 
                        value="        Exit        " 
                        onclick="location.href='/continuity/login/ready?sdname=<s:property value='#session.loginSystemDomain.customUrl'/>'"
                    />
                </div>
                
            </fieldset>
     </div>
   </div>
</form>