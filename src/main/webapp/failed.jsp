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
<style type="text/css">
<!--
#logincontainer {
width:100%;
padding-top: 60px;
padding-bottom: 90px;
}

#login {
width: 480px;
margin-right:auto;
margin-left:auto;
margin-top: 40px;
font-family:Arial, Helvetica, sans-serif;
font-size: 12px;
}

#login fieldset {
padding: 30px;
border: solid 1px #003366;
}

#login fieldset legend {
font-size:16px;
font-weight: bold;
color:#333;
}

#login fieldset  p{
font-size:100%;
font-weight: normal;
color:#333;
padding-bottom: 10px;
}

#login label {
display:block;
font-family:Verdana, Arial, Helvetica, sans-serif;
float:left;
color:#003399;
font-weight:bold;
width: 70px;
padding-right: 10px;
margin-top: 5px;
}

#login input {
display:inline;
width: 318px;
margin-top: 5px;
}

#login select {
display:inline;
width: 322px;
margin-top: 5px;
}

#login input.floatright {
width: 70px;
float:right;
margin-top: 20px;
}

-->
</style>

<form method="post" action="j_spring_security_check">
    <div id="logincontainer">
        <div id="login">
            <b>The authentication failed. Please input correct user/password.</b>
     </div>
   </div>
</form>