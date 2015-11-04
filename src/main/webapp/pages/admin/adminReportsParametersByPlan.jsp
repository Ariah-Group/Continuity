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
<!--- Reports module --->
<script language="javascript" type="text/javascript">
function toggleSelect(){
	var myElement = document.getElementById("specifyplan");
	myElement.checked = true;
	return true;
}
</script>
<s:include value="/pages/common/KCPTHeaderR.jsp"/>

<div id="maincontainer">
  <div id="contentwrapper">
    <div id="contentcolumn">
      <div id="innertube">
        <div id="admin">

          <h1>Reports</h1>
          <h2><s:property value="adminReportParameterDTO.numberedReportName" /></h2>
          <p><s:property value="adminReportParameterDTO.description" /></p>
          <br />
          <div id="reports">
            <fieldset>
            <legend><s:property value="adminReportParameterDTO.reportName" /></legend>

            
            <form name="MyForm" id="MyForm" action="report_detail" method="post"  >
            <s:if test='adminReportParameterDTO.reportId=="other"'>
            <br>
            <label for="stakeholdertype">Type of stakeholder</label>

			<select name="s_pullby">
				<option value="all" selected>All</option>
						<option value="1">Client</option>
						<option value="2">Donor</option>
						<option value="3">Sponsor</option>
        				<option value="5">Project partner</option>
						<option value="6">Other stakeholder</option>
						<option value="7">Other</option>
			</select>
            </s:if>
			<s:if test='adminReportParameterDTO.reportId=="building"'>
             <label for="s_pullby">Select Building</label>
             <s:if test="adminReportParameterDTO.ispull == true" >

                	<s:select 
 		  	        	 id="s_pullby" 
		  	        	 name="s_pullby" 
 			        	 list="pullList" 
			             listValue="description"
 			    	     listKey="id"
  	            	/>
       

	        	</s:if>
    		</s:if>



			<s:if test='adminReportParameterDTO.reportId=="available"'>
			<label for="s_pullby">Category of Staff</label>
            
               	<s:select 
 		  	        	 id="s_pullby" 
		  	        	 name="s_pullby" 
 			        	 list="pullList" 
			             listValue="description"
 			    	     listKey="id"
  	            	/>

              
         

    		</s:if>
           <s:if test='adminReportParameterDTO.ispull==false && adminReportParameterDTO.reportId!="other"'>
			
             <label for="allplans">
	     		<input type="hidden" name="numberedReportName" value="adminReportParameterDTO.numberedReportName" />
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
          </s:if>
           
            <hr class="divider" >
           
           <s:if test="adminReportParameterDTO.issort == true" >
            <label for="s_sortby">Sort by</label>
         	<s:select 
 		  		 id="s_sortby" 
		  		 name="s_sortby" 
 				   list="sortList" 
				   listValue="description"
 				   listKey="id"
  			  />
       

			</s:if>
             <s:if test="adminReportParameterDTO.excludePhrase.length() >0 " >
                <p><input type="checkbox" CHECKED name="exclude" id="exclude" >
                 Exclude plans <s:property value="adminReportParameterDTO.excludePhrase" /></P>
            </s:if>
        
            <div class="createbutton">
              <input name="Submit" type="submit" value="Create Report" />
            </div><!--closes createbutton div-->

            
              <input type="hidden" name="report_name" value='<s:property value="adminReportParameterDTO.reportId" />' />

            </form>

            </fieldset>
            <input type="button" name=" Main_Reports" value="Return to Main Reports Screen" onclick="location.href = 'adminReports' ">
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