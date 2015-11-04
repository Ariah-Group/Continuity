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

<script>
function ShowHidePlanDownload(){
    var CheckObj = document.getElementsByName('mySamplePlan') ;
    if (CheckObj[0].checked==true) {
        // hide upload
        var CurEl = document.getElementById('UploadSpanID') ;
        CurEl.className = 'HiddenControl' ;
    } else {
        var CurEl = document.getElementById('UploadSpanID') ;
        CurEl.className = '' ;
    }
}
</script>

<div id="innertube">

<h1>Setup Sample Plan</h1>

<p class="StandardWidth">The HandyLinks list (the one on the user
screens, not the HandyLinks list on these administrator screens)
includes a link to a Sample Plan. We recommend that you, as Local 
Administrator of this planning tool, create that Sample Plan.</p>

<p class="StandardWidth">The purpose of your Sample Plan is to give
users an example of what you'd like them to produce:</p>

<ul class="bulletlist">
	<li>Clear, briefly-stated <s:property value='#session.systemDomain.displayConstants.criticalLower' />
	functions</li>
	<li>Brief answers to questions</li>
	<li>Meaningful action items (at least some low-cost or no-cost)</li>
</ul>

<p class="StandardWidth">Here are the steps:</p>

<ul class="numberlist">
	<li>Create your Sample Plan as you would create a real plan</li>
	<li>When it is complete, use the Print Menu screen to create your plan document (which will be an Adobe Acrobat document - suffix .pdf)</li>
	<li>Save your Acrobat document to any convenient location on your hard drive or server</li>
	<li>Select the My Sample Plan option below and use the Browse feature to upload your Acrobat document into the tool&#39;s database. It will replace the default Sample Plan at your location.</li>
</ul>

<div class="FormDivClass">

    <s:form name="samplePlanForm1" 
        action="samplePlanUpload" 
        enctype="multipart/form-data">
        
        <s:hidden name="default" value="false"/>
        
        <input type="radio" 
            name="mySamplePlan" 
            id="mySamplePlan1" 
            <s:if test='mySamplePlan == false'>checked="checked"</s:if>
            value="false" 
            onclick="ShowHidePlanDownload()"/>
        Default Sample Plan
        <input type="radio" 
            name="mySamplePlan" 
            id="mySamplePlan2" 
            <s:if test='mySamplePlan == true'>checked="checked"</s:if>
            value="true" 
            onclick="ShowHidePlanDownload()"/>
        My Sample Plan

        <span class="<s:if test='mySamplePlan == false'>HiddenControl</s:if>" id="UploadSpanID">
            <s:file name="uploadedDoc" size="50" />
        </span>

        <br />

        <div class="MyButtonsDivClass">
            <div class="FloatRight">
                <s:submit 
                    tooltip="Set Sample Plan"
                    title="Set Sample Plan" 
                    cssClass="ButtonClass"
                    name="SaveSample" 
                    value="      Set Sample Plan      "/>
            </div>
        </div>
        <s:token />
    </s:form>

    <s:form 
        name="samplePlanForm2" 
        action="samplePlanUpload" 
        enctype="multipart/form-data">

        <s:hidden name="default" value="true"/>
        <s:hidden name="mySamplePlan" value="false"/>

        <!--- check if system admin ---> 
        
        <s:if test="#session.user.securityType.id == 0">
        
	        <br />
	        <hr class="AdminHR" />
	        <br />
	        
	        <p class="AttentionClassNotBold">The following appears only for System Administrators:</p>
	        
	        <!--- allow to set Default Sample Plan ---> 
	        Upload new Default Sample Plan 
	        <span>
	            <s:file name="uploadedDoc" size="50" />
	        </span>
	
	        <div class="MyButtonsDivClass">
	
		        <div class="FloatRight">
		            <s:submit 
		                tooltip="Set Default Sample Plan"
		                title="Set Default Sample Plan" 
		                cssClass="ButtonClass"
		                name="SaveDefault" 
		                value="Set Default Sample Plan"/>
		        </div>

            </div>
    
        </s:if>
       <s:token />


       <!-- error line -->
       <s:include value="/pages/widget/ActionErrors.jsp" />
       <br />
       <s:include value="/pages/widget/BackButton.jsp" />

    </s:form>
    
</div>

</div>