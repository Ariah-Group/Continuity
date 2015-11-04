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
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Creating a Resizable Panel</title>

<s:include value="../common/YUI.jsp"/>
<LINK REL="stylesheet" TYPE="text/css" HREF="/kcpt/css/widget/FloatingPanel.css">
<script type="text/javascript" src="/kcpt/javascripts/widget/FloatingPanelLibrary.js"></script>

</head>
<div class="yui-skin-sam">
        <button id="showbtn">Show Resizable Panel</button>

        <div id="floatingpanel">
            <div class="hd">Resizable Panel</div>
            <div class="bd">
                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Suspendisse nulla. Fusce mauris massa, rutrum eu, imperdiet ut, placerat at, nunc. Vestibulum consequat ligula ut lacus. Nulla nec pede. Fusce consequat, augue et eleifend ornare, nibh mi dapibus lorem, ut lacinia turpis eros at eros. Proin laoreet. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla velit. Fusce id sem sit amet felis porta mollis. Aliquam erat volutpat. Etiam tortor. Donec dui felis, pretium quis, vulputate et, molestie non, nisi.</p>
            </div>
            <div class="ft"></div>
        </div>

</div>
</html>

<!-- presentbright.corp.yahoo.com uncompressed/chunked Thu Feb 19 10:53:11 PST 2009 -->
