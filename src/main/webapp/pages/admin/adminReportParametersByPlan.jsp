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

<s:include value="/pages/common/KCPTHeader.jsp"/>

<div id="maincontainer">
  <div id="contentwrapper">
    <div id="contentcolumn">
      <div id="innertube">
        <div id="admin">

          <h1>Reports</h1>
          <h2>1. [This Report Name]</h2>
          <p>This report lists, [plan-by-plan, the completion status, date of last access, date of leadership review].</p>
          <br />
          <div id="reports">
            <fieldset>
            <legend>[This Report Name]</legend>

            
            <form name="MyForm" id="MyForm" action="report_detail.cfm" method="post" preloader="no" onsubmit="return _CF_checkMyForm(this)">
             <br />
             <label for="allplans">
            <input type="radio" name="r_plan" id="allplans" value="all plans" checked="checked" />
            All Plans
            </label>
            
            <div id="textlayout">or</div>
            <label for="specifyplan">
            <input type="radio" name="r_plan" id="specifyplan" value="specific plan" /></label>

            <label for="plan_name">
            Specify Plan:
            <input name="plan_name" type="text" class="partial" onfocus="toggleSelect();" maxlength="254" />
            </label>
            <div class="tagline">(beginning of the plan name)</div>
            
            <hr class="divider" >
            
            <label for="s_sortby">Sort by</label>
            <select name="s_sortby">

              <option value="1">Plan Name</option>
              <option value="2">Plan Status</option>
              <option value="3">Date of Last Access</option>
            </select>
            <div class="createbutton">
              <input name="Submit" type="submit" value="Create Report" />
            </div><!--closes createbutton div-->

            
              <input type="hidden" name="report_name" value="report_status" />
            </form>

            </fieldset>
            <input type="button" name=" Main_Reports" value="Return to Main Reports Screen" onclick="location.href = '../admin/report_main.cfm' ">
          </div>
          <!--closes reports div-->
        </div>
        <!--closes admin div-->

      </div>
      <!--closes innertube div-->
    </div>
    <!--closes contentcolumn div-->
  </div>
  <!--closes content wrapper div-->

<s:include value="/pages/common/KCPTRightDiv.jsp"/>
</div><!--closes maincontainer div-->

<s:include value="/pages/common/KCPTFooter.jsp"/>

</html>