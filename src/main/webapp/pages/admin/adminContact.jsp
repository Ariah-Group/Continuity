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
<meta name='gwt:module'
	content='org.kuali.continuity.admin.main.Application' />
</head>
<body>
<s:include value="/pages/common/KCPTHeader.jsp"/>

<div id="maincontainer">
<div id="contentwrapper">
<div id="contentcolumn">

<script>
    window.name="mainwindow";
    function exitPage() {
        window.location="/kcpt/admin/adminHome";
    }
</script>
<br/>

<br/>
 <iframe name=frame2 style="width:800px;height:1000px" id=frame2 src="/kcpt/org.kuali.continuity.admin.main.Reference/Contact.html" frameborder="0">
</iframe>
<br/>

</div><!--closes contentcolumn div-->                  
</div><!--closes content wrapper div--> 

<s:include value="/pages/common/KCPTRightDiv.jsp"/>
</div><!--closes maincontainer div-->

<s:include value="/pages/common/KCPTFooter.jsp"/>

</html>