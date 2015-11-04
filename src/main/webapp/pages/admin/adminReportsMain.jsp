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

<s:include value="/pages/common/KCPTHeaderR.jsp"/>

<div id="maincontainer">
<div id="contentwrapper">
<div id="contentcolumn">

<br/>
<br/>
<div id="innertube">
<div id="admin">
					<h1>View &amp; Print Reports</h1>
                    <p>Select any report for on-screen viewing. Once viewed, the report may be converted to an MS Word document and printed.
</p>
<s:form id="adminReportsMainForm" name="adminReportsMainForm" action="adminReportsParametersByPlan">
<s:hidden name="reportId" id="reportId" value=""/>        
<div id="mainreport">          
 <table cellspacing="0">
  <tbody><tr>
    <th scope="col">&nbsp;</th>
    <th scope="col">Name of Report</th>
    <th scope="col">Description</th>    
  </tr>
  
  <tr>
    <td class="lftborder">1.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='status';adminReportsMainForm.submit();">Status of Continuity Plan</a></td>
    <td>This report lists, plan-by-plan, the completion status, plus the dates of last access, completion, and annual review.</td>
    
  </tr>
  
  <tr>
    <td class="lftborder">2.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='contact';adminReportsMainForm.submit();">Contact Persons</a></td>
    <td>This report lists, plan-by-plan, the contact persons for the plan.</td>
    
  </tr>
  
  
  
  
  <tr>
    <td class="lftborder">3.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='building';adminReportsMainForm.submit();">Location of Departments
</a></td>
    <td>This report associates departments with buildings.</td>
    
  </tr>
  <tr>
    <td class="lftborder">4.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='evacuation';adminReportsMainForm.submit();">Evacuation Plans
</a></td>
    <td>This report lists, for each department, the status of building evacuation plans.
</td>
    
  </tr>
  <tr>
    <td class="lftborder">5.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='criticalFunctions';adminReportsMainForm.submit();">Critical Functions
</a></td>
    <td>Listing of critical functions by department and by criticality level
</td>
    
  </tr>
    <tr>
    <td class="lftborder">6.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='upstream';adminReportsMainForm.submit();">Dependencies - Upstream
</a></td>
    <td>This report lists each department&#39;s upstream
dependencies: the other departments, people, or organizations that the
subject department depends on (needs to be functional).</td>
    
  </tr>
  

  
  
  
  <tr>
    <td class="lftborder">7.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='downstream';adminReportsMainForm.submit();">Dependencies - Downstream</a></td>
    <td>This
report lists each department&#39;s downstream dependencies: the other
departments, people, or organizations that depend on the subject
department (need the subject department to be functional).</td>
    
  </tr>
  
  
  <tr>
     <td class="lftborder">8.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='documents';adminReportsMainForm.submit();">Documents
</a></td>
    <td>This report lists all external documents that are
named within each plan, indicating which documents have been uploaded
into the plan&#39;s database.</td>
    
  </tr>
  

  <tr>
     <td class="lftborder">9.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='actionItems';adminReportsMainForm.submit();">Action Items
</a></td>
    <td>This report lists action items, with several ways to sort.</td>
  </tr>
      <!--  OK UP TO HERE -->
  <tr>
     <td class="lftborder">10.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='backup';adminReportsMainForm.submit();">Workstation Backup
</a></td>
    <td>This report lists, for each department, the percent utilization of various backup arrangements for desktop computers.</td>    
  </tr>
  <tr>
     <td class="lftborder">11.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='support';adminReportsMainForm.submit();">Workstation Support

</a></td>
    <td>This report lists, for each department, who provides tech support.

</td>    
  </tr>
   <tr>
    <td class="lftborder">12.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='ITApplications';adminReportsMainForm.submit();">Centrally-Owned IT Applications</a></td>
    <td>This
report lists the central IT applications used by each department, along
with the department&#39;s ranking of each application for criticality.</td>  
 </tr>
 
  <tr>
    <td class="lftborder">13.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='skills';adminReportsMainForm.submit();">Skills

</a></td>
    <td>This report lists, for each department, some skills, licenses, or certifications that may be needed post-disaster.</td>    
  </tr>
  
   <tr>
     <td class="lftborder">14.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='vendors';adminReportsMainForm.submit();">Vendors
</a></td>
    <td>This report lists vendors identified in plans.</td>
   
  </tr>
  

   <tr>
     <td class="lftborder">15.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='other';adminReportsMainForm.submit();">Other Stakeholders

</a></td>
    <td>This report lists stakeholders identified in plans (excluding vendors).  Several sorting options are offered.
</td>
  </tr>
  <tr>
     <td class="lftborder">16.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='strategies';adminReportsMainForm.submit();">Strategies if Normal Workspace is Unavailable

</a></td>
    <td>This report lists strategies identified by
departments for carrying on critical functions if the normal workspace
is not available.
</td>
  </tr>
  <tr>
    <td class="lftborder">17.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='available';adminReportsMainForm.submit();">Personnel Available for Reassignment


</a></td>
    <td>This report lists, by department, various categories
and numbers of personnel who may be &#34;not-needed&#34; for carrying on
critical functions post-disaster, hence available for temporary
reassignment elsewhere.
</td>
  </tr>
  <!--  OK AFTER HERE -->
  <tr>
  <td class="lftborder">18.</td>
    <td><a href="#" onclick="document.getElementById('reportId').value='staffing';adminReportsMainForm.submit();">Staffing Requirements During Crisis

</a></td>
    <td>This report displays, for certain types of staff,
the number of staff required during crisis versus the number required
under normal circumstances.
</td>
  </tr>
  
    
</tbody></table>    
</div>  <!--closes mainreport div-->
</s:form>

<input name="AdminMain" type="button" value="Return to Admin Main Control Screen" onclick="location.href = 'adminHome' ">
</div> <!--closes admin div-->
</div> <!--closes innertube div-->
</div><!--closes contentcolumn div-->                  
</div><!--closes content wrapper div--> 

<s:include value="/pages/common/KCPTRightDiv.jsp"/>
</div><!--closes maincontainer div-->

<s:include value="/pages/common/KCPTFooter.jsp"/>

</html>