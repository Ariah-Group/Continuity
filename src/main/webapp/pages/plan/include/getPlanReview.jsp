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
<s:include value='../../widget/Calendar.jsp'/>

<s:if test="approval.isApproved == true">
    <s:set var="showClass" value=""/>
</s:if>
<s:else>
    <s:set var="showClass" value="'HiddenControl'"/>
</s:else>
<s:property value="#session.planAccessControl.addClass"/>

<p class="plan">Continuity Plan for <span id="planname"><s:property value="#session.plan.acronymPlusName"/></span></p>
<div id="innertube">
    <div class="MainSite">
        <h1>What to Do When Your Plan is Done</h1>
        <p> When your planning group has completed its work, the next steps are:</p>
        <p><strong>(1) Departmental review.</strong> Put your draft plan through your department's customary process for review, changes, and approval. The <a href="printMenu">print menu</a> presents your plan in Adobe Acrobat format for printing, emailing, or saving to any location. </p><br />
        <s:form name="savePlanReview" action="savePlanReview">
            <div id="podsizer">   
                <b class="b1"></b>
                <b class="b2"></b>
                <b class="b3"></b>
                <b class="b4"></b>
                <div class="MyPod Padding3x">
                    <table>
                        <tr>
                            <td colspan="4">
                                <label>
                                    <s:checkbox 
                                        disabled="%{#session.planAccessControl.isSelectDisabled}" 
                                        name="approval.isApproved" 
                                        cssClass="ReviewCheckClass"
                                        onclick="ShowHideReview()"
                                    /> 
                                    Please check when departmental review is complete.
                                </label>
                                <br />
                            </td>
                        </tr>
                        <tr class="<s:property value='#showClass'/>" id="Note1ID">
                            <td colspan="4"><label>The review was done by:</label></td>
                        </tr>
                        <tr class="<s:property value='#showClass'/>" id="LabelsID">
                            <td><label for="ReviewerName"><span class="AttentionClassNotBold">*</span>Name:</label></td>
                            <td></td>
                            <td><label for="ReviewDate"><span class="AttentionClassNotBold">*</span>Date:</label></td>
                            <td></td>
                        </tr>
                        <tr class="<s:property value='#showClass'/>" id="DetailsID">
                            <td>
                                <s:textfield
                                    readonly="%{#session.planAccessControl.isInputReadOnly}" 
                                    name="approval.name" 
                                    id="ReviewerNameID" 
                                    cssClass="ReviewerNameClass %{#session.planAccessControl.addClass}" 
                                    size="50"/>
                            </td>
                            <td align="center">&nbsp;on&nbsp;&nbsp;</td>
                            <td>
                                <span  class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                                    <s:date name="approval.date" var="formattedApprovalDate" format="MM/dd/yyyy"/>
                                    <s:div id='divCalContainer' cssClass="yui-skin-sam">
                                    <s:textfield 
                                        id="approval.date"  
                                        name="approval.date" 
                                        size="10"
                                        value="%{formattedApprovalDate}" 
                                        readonly="%{#session.planAccessControl.isInputReadOnly'}"
                                        cssClass="ReviewDateClass %{#session.planAccessControl.addClass}"/>
	                                    <a id='aCal' name='aCal' href="#"><img src='/kcpt/images/DateChooser.png'/></a>
	                                    <div id='divCal'></div>
	                                </s:div>
                                </span>
                                <span  class="<s:property value='#session.planAccessControl.displayClass'/>">
                                    <s:textfield 
                                        id="approval.date"  
                                        name="approval.date" 
                                        size="10"
                                        value="%{formattedApprovalDate}" 
                                        readonly="%{#session.planAccessControl.isInputReadOnly}"
                                        cssClass="ReviewDateClass %{#session.planAccessControl.addClass}"/>
                                </span>
                            </td>
                            <td>
                                <s:iterator var='approvalTypeKey' value='approval.types.keys' status='rowstatus'>
                                    <img src="/kcpt/images/spacer.gif" width="2px">
                                    <s:if test='approval.type == null'>
                                        <s:set var='approval.type' value='#approvalTypeKey'/>
                                    </s:if>
                                    <s:set name='radioChecked' value='""'/>
				                    <s:if test='approval.type == #approvalTypeKey'>
				                        <s:set name='radioChecked' value='checked="checked"'/>
				                    </s:if>
                                    <s:set name='radioDisabled' value='""'/>
				                    <s:if test='#session.planAccessControl.isSelectDisabled == true'>
				                        <s:set name='radioDisabled' value='disabled="disabled"'/>
				                    </s:if>
				                    <input 
				                        id='approval.type.<s:property value="#approvalTypeKey"/>'
				                        name='approval.type'
				                        type='radio'
				                        value='<s:property value="#approvalTypeKey"/>'
				                        <s:property value="#radioDisabled"/>
				                        <s:property value="#radioChecked"/>
				                    />
				                    <s:property value='approval.types[#approvalTypeKey]'/>
				                </s:iterator>
                            </td>
                        </tr>
                        <tr class="<s:property value='#showClass'/>" id="Note2ID">
                            <td colspan="4" class="AttentionClassNotBold">
                                <br />
                                *indicates an answer that is required before your plan can be marked COMPLETE
                            </td>
                        </tr> 
                    </table>
				    <s:include value="/pages/widget/ActionErrors.jsp" />
                </div> 
                <!-- formatting error on s:radio because of css.  this is an alternative -->
                <b class="b4"></b>
                <b class="b3"></b>
                <b class="b2"></b>
                <b class="b1"></b>
            </div>
            <br/>
            <p><strong>(2) Mark your plan COMPLETE on the <a href="./planHome">Plan Home</a> screen.</strong></p>      
            <p><strong>(3) Communicate your plan to your staff.</strong> Distribute your Plan document (electronic or printed) to  your leaders/managers, and communicate the essentials of your plan to all of your faculty and staff. </p>
            <p><strong>(4) Annual Review.</strong> Review your plan at least once a year. See <a href="./annualReviews">Annual Plan Review</a>.</p>
            <p><strong>(5) Update your plan as needed.</strong>
            Your plan will always be accessible for changes and printing via this online tool. Signify that your plan is under revision by marking it <strong>IN-PROGRESS</strong> on the <a href="./planHome">Plan Home</a> screen.</p>
            <s:include value="/pages/widget/SaveContinueButtons.jsp"/>                   
        </s:form>
    </div>
</div>



