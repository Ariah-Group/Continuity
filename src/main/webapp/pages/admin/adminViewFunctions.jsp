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

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/1999/REC-html401-19991224/loose.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">

<title>Continuity Planning Tool</title>

<meta name="keywords" content="Ariah Continuity, Kuali Continuity,  Planning, Disaster Recovery">

<link rel="stylesheet" type="text/css" href="/continuity/css/ucreadystyles.css">
<link rel="stylesheet" type="text/css" href="/continuity/css/guidance.css">
<link rel="stylesheet" type="text/css" href="/continuity/css/ucreadyMainElements.css">
	
	<!-- add template specific CSS -->
	<style type="text/css">
	<!--
	#UCReadyhead {
			background-image:url(../images/web-UCReady-banner.png);
			background-repeat:no-repeat;
			background-position:top left; 
			border-bottom: 2px solid #0038A9;
			height: 79px;
			margin: 0;
			padding: 0;
			position: relative;
			text-indent: -9999em;/*Hide Text, keep for SEO*/
		}
	
		#UCReadyhead  a {
			background-image:url(../images/web-UCReady-banner-text.png);
			background-repeat:no-repeat;
			background-position:top right; 
			display: block;
			font-style: normal;
			font-weight: normal;
			height: 100%;
			width: 100%;
		}
	-->
	</style>


</head>
<body>
 <!-- Begin Banner Table -->
 <div id="UCReadyhead">
 <a href="http://ucready-dev.berkeley.edu/begin.cfm">Kuali Continuity Securing our mission: teaching, research, and public service</a>

 
 </div>

<!-- End Banner Table -->

<form name="CFForm_1" id="CFForm_1" action="/UCB/cf_examples.cfm" method="post" onsubmit="return _CF_checkCFForm_1(this)">
<div id="maincontainer">
	<div id="contentwrapper">
    <div id="contentcolumn">
            <div id="innertube">           
            <h1>Examples of Critical Functions</h1>
                 <p>Here are some examples of the choices that other departments have made when asked to designate critical functions.</p>


<table id="list_table">
 <tbody><tr>
			    <th scope="col">Name of Unit</th>
			    <th scope="col">Function</th>
			    <th scope="col">Level of Criticality</th>
			  </tr>
  <s:iterator var="plan" value="plans" status="rowstatus">
 <tr>
 <td><s:property value="name"/>&nbsp;</td>
  <td><s:property value="function"/></td>
 <td><s:property value="level"/> </td>
</tr>

</s:iterator> 
 </table>
 
 
	

				<div class="MyButtonsDivClass">
				<div class="FloatLeft AllignLeft">
					<input name="back" id="back" value="      Back     " class="ButtonClass" onclick="window.history.go(-1);" alt="Go back" title="Return" type="button">
				</div>
			</div><!--closes div--> 
    </div>
            <!--closes innertube div-->    
            </div><!--closes contentcolumn div-->            
    </div><!--closes content wrapper div-->
	<div id="rightcolumn">
	

<!--begin handylinks box code-->
<style type="text/css">
<!--

.contentb h3 {
margin:0;
padding:0 0 7px 0;
text-align:center;
font-size: 12px;
color:#000066;
font-weight:bold;
}

.quicklinks {
padding-bottom: 6px;
text-align:center;


}
-->
</style>



  <b class="b1"></b>
 <b class="b2"></b>
 <b class="b3"></b>
 <b class="b4"></b>
  <div class="contentb"> 
  <h3>HandyLinks</h3> 
   <div class="podcenter">            
          <!-- Begin Quick links Select Statement -->



	<select class="QuickLinksClass" name="quicklinks" onchange="ShowLink(this.options[this.selectedIndex].value);">
	

		<option value="/UCB/cf_examples.cfm" selected="selected">GO TO..</option>

		
		<option value="../UCB/create_new.cfm">Create New Plan</option>
		<option value="../UCB/editPlan.cfm">Choose Different Plan</option>


		
		<option value="../UCB/status.cfm">List of All Plans</option>
		
		<option value="../actions/showSamplePlan.cfm?tm=0717200913:21:12:120,_blank">Sample Plan</option>
		
		
		
		
		<option value="../UCB/annualreview.cfm">Annual Review</option>
		<option value="../UCB/thingstoknow.cfm">Things to Know</option>
		<option value="../UCB/FAQ.cfm">FAQs</option>
		<option value="../UCB/reference.cfm">References</option>
	 	<option value="../UCB/contact.cfm">Contact Us</option>
	
		 
			<option value="../UCB/download_docs.cfm">Download Documents</option>
		
			<option value="../UCB/mySession.cfm">Session Role</option>
			 												  
			<option value="../admin/adminMain.cfm">Admin Control Screen</option>
		
	</select>
	<!-- End Select Statement -->
       
    </div><!--closes podcenter div-->
    </div><!--closes contentb div-->
<b class="b4"></b>
<b class="b3"></b>
<b class="b2"></b><b class="b1">
</b>

<!--end handylinks box code-->
<br>

<!-- Begin Guidance Box section -->

 <b class="b1"></b>
 <b class="b2"></b>
 <b class="b3"></b>
 <b class="b4"></b>
   <div class="contentb"> 
  <h3>Guidance</h3> 
     <div id="guidance">
     <div align="center">
             <img src="cf_examples.cfm_files/blue_line_G.gif" alt="" width="220" height="10"> 
        </div>                   			
               
               
<ul>
<li>
Use these examples to form your thoughts about your own unit's critical functions.
</li></ul> 
              </div> <!--  closes guidance div -->
 </div>
   <!--  closes contentb div -->
<b class="b4"></b>
<b class="b3">
</b><b class="b2"></b>
<b class="b1"></b>


</div> <!--closes right column div-->		




</div><!--closes maincontainer div-->
</form>


<noscript>
	<font class="AttentionBold">
	UCReady application requires Javascript to be enabled on your browser to operate properly.<br>
	Make sure that Javascript is enabled or ask your computer support for help.
	</font>
</noscript>


<div id="footer">
    <a href="./begin">Ariah Continuity Home</a> |
    <a href="http://www.ucop.edu">UC Home</a> |
	<a href="./contactUs">Contact Us</a> |
	<a href="<%=request.getContextPath()%>/j_spring_security_logout">Logout</a>
<br />
<div id="copyright">Copyright 2008 Regents of the University of California. All rights reserved.</div>
</div><!--closes footer div-->

</body></html>