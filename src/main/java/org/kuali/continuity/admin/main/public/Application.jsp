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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
   
   
<html>
<head>

<!--                                           -->
<!-- Any title is fine                         -->
<!--                                           -->
<title>Wrapper HTML for </title>

<!--                                           -->
<!-- The module reference below is the link    -->
<!-- between html and your Web Toolkit module  -->
<!--                                           -->
<meta name='gwt:module'
	content='org.kuali.continuity.admin.main.Application' />

</head>

<!--                                           -->
<!-- The body can have arbitrary html, or      -->
<!-- we leave the body empty because we want   -->
<!-- to create a completely dynamic ui         -->
<!--                                           -->
<body>

<!--                                            -->
<!-- This script is required bootstrap stuff.   -->
<!-- You can put it in the HEAD, but startup    -->
<!-- is slightly faster if you include it here. -->
<!--                                            -->
<table>
	<tr>
		<td width="18px">&nbsp;</td>
		<td valign="top">
		<h1>Centrally Owned Applications & Systems Setup</h1>
		<p class="StandardWidth">Please add here the items that will
		appear in the table of Centrally-Owned Applications & Systems on the
		first screen of Step 3 (Information Technology).</p>

		<p class="StandardWidth">"Centrally-Owned" means that Central IT
		is the technical owner of the application, not necessarily the
		functional owner (see Guidance at right). The functional owner might
		be any department.</p>
		<p class="StandardWidth">You may want to consult with Central IT
		to create this list. Remember that these application names must be
		recognized by users - this is not meant to be a comprehensive list of
		Central IT's esoteric applications.</p>

		<p>To modify an existing item, first highlight that row on the
		grid then use the entry-forms at bottom to modify. <br />
		<br />
		</p>


		</td>
	</tr>
	<tr>
		<td width="18px">&nbsp;</td>
		<td valign="top">
		<div id="gwtRoot" title="GWT Area"></div>
		</td>
	</tr>
</table>


<div id="plural" title="Centrally Owned Applications & Systems"></div>
<div id="itemdata" title="Application" class="Heading"></div>
<div id="formelement" title="Name" class="Heading"></div>


<script language="javascript"
	src="org.kuali.continuity.admin.main.Application.nocache.js"></script>

<!-- OPTIONAL: include this if you want history support -->
<iframe id="__gwt_historyFrame" style="width: 0; height: 0; border: 0"></iframe>

</body>
</html>
