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
<!--- Guidance for EditPlan screen --->


    <s:if test= "#session.user.isShibMode == false">
	    <s:if test="#session.user.securityType.id == 0 || #session.user.securityType.id == 1 || #session.user.securityType.id == 3|| #session.user.securityType.id == 4">
	        <a href="/continuity/plan/getNewUsers"><img src="/continuity/images/ModerateKR.gif" alt="Monderator's Screen" /></a> <br /><br />
	    </s:if>
    </s:if>     
    <!--- all except local user --->
    <s:if test="#session.user.securityType.id != 9">
        <a href="./getSystemDomainDocuments"><img src="/continuity/images/AccessAllDocumentsKR.gif" alt="Access All Plan Documents" /></a>  <br /><br />
      
    </s:if> 
    <!--- sysadmin, group admin, localadmin  --->
    <s:if test="#session.user.securityType.id == 0 || #session.user.securityType.id == 1 || #session.user.securityType.id == 3">
        <a href="/continuity/admin/adminHome"><img src="/continuity/images/AccessAdminControlsKR.gif" alt="Administrator's Controls" /></a> <br /><br />
    </s:if> 

<ul>
<li>Access to any plan is limited to those who are on that plan's user-list.  To join the user-list of a plan, click on the &ldquo;people&rdquo; icon next to that plan's name. You will see the names of the plan coordinators.  Contact one of them and ask to be given access.</li>
<li>This on-line Planning tool is quite flexible - it works for 
  <ul class="indent">
<li>academic units</li>
<li>research units</li>
<li>patient care units</li>
<li>public service units</li>
<li>support units of any type</li>
</ul>
</li>
<li>An academic department would typically use this Planning Tool to create a single continuity plan.  Research units, centers and institutes would do the same.  Departments that share administrative staff (sometimes called clustered departments) would typically create a single plan encompassing all departments in the cluster.  <a href="./contactUs">Contact us</a> for advice.</li>
<li>If your unit is large and complex, it may be better to create separate plans for your major subunits, rather than a single plan for the entire organization.  <a href="./contactUs">Contact us</a> for advice.</li>
<li><strong>To delete an entire plan</strong>, contact the <a href="./contactUs">System Administrator.</a></li>
</ul>
