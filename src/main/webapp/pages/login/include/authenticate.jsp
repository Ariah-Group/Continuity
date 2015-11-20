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
<form method="post" action="j_spring_security_check">
    <s:token />
    <div id="logincontainer">
        <s:include value="/pages/custom/%{#session.loginSystemDomain.customUrl}/authenticate.jsp"/>
        <div id="login">
            <fieldset>
                <legend>&nbsp;Login&nbsp;</legend>
		        <div id="logincontext">
				    <p>Your campus's <span class="bold"><strong>continuity planning tool</strong></span> 
					  is powered by the <a href="http://www.ariahgroup.org">Ariah Group</a>, and hosted
					  here.  This login screen admits you to your campus's tool, which is secure and
					  confidential to your institution.
    				</p>
        		</div>    
                <s:hidden name="systemDomainId" id="systemDomainId" value="%{#domain}"/>
				<label>Institution: </label><s:property value="systemDomainName"/>
                <br /><br />
                
                <label>Login Name: </label>
                <s:textfield name="j_username" id="j_username"/>
                <br /><br />
                
                <label>Password: </label>
                <s:password name="j_password" id="j_password"/>
                <br /><br />
                
                <s:set var="pgName" value="#request['javax.servlet.forward.servlet_path']"/>
                <s:if test="#pgName=='/login/failed'">
                    <span id="MessageDIV" class="MessageDIVClass">
                        Authentication failed. Please input correct user/ password.
                    </span>
                    <br/>
                </s:if>
                <s:if test="#pgName=='/login/disabled'">
                    <span id="MessageDIV" class="MessageDIVClass">
                        Access disabled, please contact administrator.
                    </span>
                    <br/>
                </s:if>
                
                <label class="btn">&nbsp;</label>
                <input name="Login" type="submit" value="  Login  " class="button" />
                <br /><br />
                       <br /><br />
                
                <label class="btn">Don't have an account? </label>
                <input name="NewAccount" type="button" value="  Create New Account  " class="button" onclick="this.form.action='newAccount';this.form.submit()" />
                <label class="btn">Forgot your login or password? </label>
                <input name="GetLoginPassword" type="button" value="  Get Login / Password  " class="button" onclick="this.form.action='getLoginPassword';this.form.submit()" />
            </fieldset>
     </div>
   </div>
   <input type="hidden" name="Nagios" value="service" />
</form>