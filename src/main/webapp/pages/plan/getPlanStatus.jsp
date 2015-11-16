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
<s:include value="../widget/FloatingPanel.jsp"/>
<style type="text/css">
<!--
#floatingpanel {
    height:0px;
}
#floatingpanel .bd {
    overflow:auto;
    background-color:#FAC4C4;
    padding:10px;
}
-->
</style>
<script type="text/javascript" src="/continuity/javascripts/plan/getPlanStatusLibrary.js"></script>

<B class="corner">
    <B class="filler1" style="background-color:#7197B7;"></B>
    <B class="filler2" style="background-color:#7197B7;"></B>
    <B class="filler3" style="background-color:#7197B7;"></B>
    <B class="filler4" style="background-color:#7197B7;"></B>
</B>

<div id="StatusPod_title" class="ypod-bgcolor-hd" style="background-color:#7197B7;">
    Status of Plan
</div>

<div id="StatusPod_body" class="ypod-dlg-body" style="height:auto;overflow:auto;background-color:#E4E9F0; background-position:bottom ; background-repeat:no-repeat; background-image:url(/continuity/images/PODBottom1.gif);  border:none ; ;">

    <span class="AttentionClass"><s:property value="#session.plan.status.description"/></span>
    <br/>

    <!--- check if show buttons --->
    <s:if test='#session.plan.planAccess.id == 2 && #session.plan.status.id == "C"'>
        <br/>
        <span>
            <a href="javascript:setPlanStatus();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image45','','/continuity/images/status_inprogress_over.gif',1)">
                <img id="markStatusBtn" src="/continuity/images/status_inprogress.gif" alt="Mark this Plan IN-PROGRESS" title="Mark this Plan IN-PROGRESS" name="Image45"  border="0">
            </a>
        </span>
    </s:if>
    <s:if test='#session.plan.planAccess.id == 2 && #session.plan.status.id == "N"'>
        <br/>
        <span>
            <a href="javascript:setPlanStatus();" onmouseout="MM_swapImgRestore()" onmouseover="MM_swapImage('Image44','','/continuity/images/status_complete_over.gif',1)">
                <img id="markStatusBtn" src="/continuity/images/status_complete.gif" alt="Mark this Plan COMPLETE" title="Mark this Plan COMPLETE" name="Image44"  border="0">
            </a>
        </span>
    </s:if>
    <br/>
    
    <s:if test="actionErrors.size > 0">
        <s:hidden id='planStatusError' name='planStatusError' value='%{actionErrors[0]}'/>
    </s:if>
    
</div>