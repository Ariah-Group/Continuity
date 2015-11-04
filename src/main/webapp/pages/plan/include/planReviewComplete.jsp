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

<p class="plan">Continuity Plan for <span id="planname"><s:property value="#session.plan.acronymPlusName"/></span></p>

<div id="innertube">

<h1>Mark Your Plan Complete</h1>

<p>This is the final step to complete your continuity plan. </p>
<p>If your plan was completed in the past and you are now doing an annual review of your plan, please omit this screen and move to the <a href="planReviewAnnual">Mark Your Annual Review Complete screen</a>.</p>
<p>Marking your plan &quot;complete&quot; does not require that every on-screen box be filled in.  The principal criterion for completeness is your judgment that the plan and its action items will help your unit to become more resilient against disaster (hence more able to continue functioning). </p>
<p>Please fill in:</p>

<s:form action="savePlanReviewComplete">

<b class="b1"></b> <b class="b2"></b> <b class="b3"></b> <b class="b4"></b>

<s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
<s:hidden name="dto.reviewType" value="C"/>

<div class="contentb">
    <table class="complete">
        <tr>
            <td colspan="4">Completion of our plan is verified by:</td>
        </tr>
        <tr>
            <td>
                <label for="dto.reviewerFirstName"><span class="required">*</span><strong>First Name</strong></label>
                <s:textfield name="dto.reviewerFirstName"/>
            </td>
            <td>
                <label for="dto.reviewerLastName"><span class="required">*</span><strong>Last Name</strong></label>
                <s:textfield name="dto.reviewerLastName"/>
            </td>
            <td>
                <label for="dto.reviewDate"><span class="required">*</span><strong>Date Plan Completed</strong></label>
                <s:date name="dto.reviewDate" var="formattedApprovalDate" format="MM/dd/yyyy"/>
                <s:div id='divCalContainer' cssClass="yui-skin-sam">
                <s:textfield 
                    id="dto.reviewDate"  
                    name="dto.reviewDate" 
                    size="14" 
                    maxlength="10"
                    value="%{formattedApprovalDate}"/>
                    <a id='aCal' name='aCal' href="#"><img src='/kcpt/images/DateChooser.png'/></a>
                    <div id='divCal'></div>
                </s:div>
            </td>
            <td>
                <br />
                <br />
                <input name="dto.reviewerType" type="radio" checked value="H" />
                    Head of Unit&nbsp;&nbsp;
                <input name="dto.reviewerType" type="radio" value="D" />
                    Designee
            </td>
        </tr>
        <tr>
            <td colspan="4"><span class="required_alert">*Required Answer</span> </td>
        </tr>
        <tr>
            <td colspan="4">
                <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
                    <s:submit value="Mark Plan Complete" />
                </span>
            </td>
        </tr>
    </table>
</div>

<!--closed contentb div-->
<b class="b4"></b> <b class="b3"></b> <b class="b2"></b> <b class="b1"></b> <br />

<p>Well done!</p>

<span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    <s:include value="/pages/widget/ActionErrors2.jsp" />
</span>
<br />

<div class="MyButtonsDivClass">
    <div class="FloatLeft AllignLeft">
        <input id="back"
           class="ButtonClass" 
           type="button" 
           name="back" 
           value="       Back      " 
           onclick="location.href='./planHome?doRefresh=true';" 
           alt="Return back"
           title="Return back"/>
    </div>
</div>

<br />
<br />

<s:if test="dtos.size > 0">
    <p><strong>Previous Entries</strong><span class="alert"> (Note: after 7 days, entries become permanent &amp; cannot be deleted.)</span> </p>
    <table id="editplan_table">
        <tr>
            <th>Name</th>
            <th>Date Plan Completed</th>
            <th>Role</th>
            <th>&nbsp;</th>
        </tr>
        <s:iterator value="dtos" status="rowstatus">
        <tr>
            <td><s:property value="reviewerFirstName"/> <s:property value="reviewerLastName"/></td>
            <td><s:date name="reviewDate" format="MM/dd/yyyy"/></td>
            <td>
                <s:if test='reviewerType == "H"'>
                    Head of Unit
                </s:if>
                <s:else>
                    Designee
                </s:else>
            </td>
            <td>
                <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	                <s:if test="deltaReviewDays < 7">
	                    <!---allow delete if within 7 days--->
	                    <a href="javascript:deleteFormRow(<s:property value='id'/>);" onClick="javascript:return confirm('Delete this reviewer: are you sure?');">delete</a>
	                </s:if>
                </span>
            </td>
        </tr>
        </s:iterator>
    </table>
    <p>Note: the date 01/01/1900, if it appears, is a placeholder signifying that this plan was completed in a previous version of this tool.  Previous versions did not record name &amp; date when the plan was marked complete.</p>
</s:if>

<s:token />

</s:form>

<s:form name="DeleteForm" action="deletePlanReviewComplete">
    <s:hidden id="dRowId" name="rowId"/>
    <s:token />
</s:form>

</div>
