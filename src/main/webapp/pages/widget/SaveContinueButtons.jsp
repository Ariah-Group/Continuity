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
<script type="text/javascript" src="/continuity/javascripts/widget/SaveContinueButtonsLibrary.js"></script>
<br /> 
<div class="FloatRight">
    <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
        <input id="btnSave" type="button" name="Save" value="Save" alt="Save" title="Save" onClick="javascript:submitActionForm(this.form, 1);">
        <input id="btnSaveContinue" type="button" name="Save_continue" value="Save and Continue" alt="Save and Continue" title="Save and Continue" onClick="javascript:submitActionForm(this.form, 2);">
    </span>
    <span class="<s:property value='#session.planAccessControl.displayClass'/>">
        <input id="btnContinue" name="Continue" type="button" value="Continue" alt="Continue" title="Continue" onClick="javascript:submitActionForm(this.form, 3);">
    </span>
</div>
<s:hidden id="saveType" name="saveType" value="0"/>
<s:hidden id="saveActionType" name="saveActionType" value="0"/>
<br /> 
<br />
