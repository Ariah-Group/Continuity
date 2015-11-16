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

<br class="clearfloat" />
<div id="leftcolumn">
    <s:if test='#session.plan.planAccess.id == 2 && #session.plan.status.id == "C"'>        
			<div align="center" id="planstatus">				
				<table id="planstatustable">
					<tr>
						<td align="center">Plan Status:</td>
					</tr>
					<tr>
						<td id="planstatustablesecond" align="center">COMPLETE</td>
					</tr>
				</table>
			</div>
						
	 </s:if>
    <s:if test='#session.plan.planAccess.id == 2 && #session.plan.status.id == "N"'>        
			<div align="center" id="planstatus">				
				<table id="planstatustable">
					<tr>
						<td align="center">Plan Status:</td>
					</tr>
					<tr>
						<td id="planstatustablesecond" align="center">IN PROGRESS</td>
					</tr>
				</table>
			</div>		
    </s:if>  
	<ol class="layout">
		<li><a href="./getPlanDepartment" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image35','','/continuity/images/edit_name_over.gif',1)">      <img src="/continuity/images/edit_name.gif"       alt="Edit Name & Org. Data"   title="Edit Name & Org. Data"   name="Image35" width="100" height="32" border="0"></a></li>
		<s:if test="#session.planGatekeeper neq null">
		    <li><a href="./getPlanUsers" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image36','','/continuity/images/addRemove_over.gif',1)">      <img src="/continuity/images/addRemove.gif"       alt="Add/Remove User"         title="Add/Remove User"         name="Image36" width="100" height="32" border="0"></a></li>
		</s:if>
		<li><a href="./gotoInterviewForms" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image3', '','/continuity/images/interview_forms_over.gif',1)"><img src="/continuity/images/interview_forms.gif" alt="Interview Forms"         title="Interview Forms"         name="Image3"  width="100" height="32" border="0"></a></li>
		<li><a href="./printMenu" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image40','','/continuity/images/print_menu_over.gif',1)">     <img src="/continuity/images/print_menu.gif"      alt="Printing Menu"           title="Printing Menu"           name="Image40" width="100" height="32" border="0"></a></li>
		<li><a href="./getPlans" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image42','','/continuity/images/create_over.gif',1)">         <img src="/continuity/images/create.gif"          alt="Select a Different Plan" title="Select a Different Plan" name="Image42" width="100" height="32" border="0"></a></li>
	</ol>
	<hr class="shortline" />
	<ol class="layout">
		<li><a href="./planReviewComplete" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image60','','/continuity/images/MarkPlanComplete_over.gif',1)"><img src="/continuity/images/MarkPlanComplete.gif" alt="Mark Plan Complete" title="Mark Plan Complete" name="Image60" width="100" height="47" border="0"></a></li>
		<li><a href="./planReviewAnnual" onMouseOut="MM_swapImgRestore()" onMouseOver="MM_swapImage('Image61','','/continuity/images/MarkAnnReviewComplete_over.gif',1)"><img src="/continuity/images/MarkAnnReviewComplete.gif" alt="Mark Annual Review Complete" title="Mark Annual Review Complete" name="Image61" width="100" height="47" border="0"></a></li>
	</ol>
</div>
			
<div id="middlecolumn">
	<div id="innertube_main"> 
		<h1>This is the home page for your plan.</h1> 
		<p>You will be asked a series of questions in Steps 1 through 5 above. When you have done this, you will have created a complete  continuity plan.</p>
		<p><strong> How to build your plan: </strong> Simply answer the questions; your plan will be produced automatically. </p>
		<p><strong> How to navigate:</strong> Use the tabs above. Some tabs will display sub-menus. It&rsquo;s OK to use your browser&rsquo;s <em>Back</em> button.</p>
		<p><strong> Use the HandyLinks.</strong> This drop-down list, at upper right of every page, makes all the features of this tool easy to reach.</p>
		<p><strong> How to save:</strong> Hit the &ldquo;Save&rdquo; button before leaving a page. If you prefer, the &ldquo;Save &amp; Continue&rdquo; buttons will move you through the pages in a pre-set sequence. This is important - leaving a page without saving may lose the data you have just entered.  </p>
		<p><strong> How to give on-line access to others:</strong> Each plan has designated &ldquo;contact persons&rdquo; who control the access list.  On the &ldquo;Choose a Plan&rdquo; screen, click on the green-and-orange &ldquo;people&rdquo; icon to see who they are, and contact one of them.
		
        <p><strong> Time-Out Feature:</strong> For security, the server will log you off after 1 hour of inactivity. Unsaved data will be lost, so save frequently.</p>        
		<p><strong> Must every question be answered?</strong> It is OK to leave blanks; you will be told when an answer is required.</p>
		<p><strong> How to view your plan: </strong> At any stage, you can use the <em>Printing Menu</em> button on the left to   view or print your plan in its then-current state.</p>
		<p><strong> Returning:</strong> You may exit at any time and resume later.</p>
	</div>
</div>

