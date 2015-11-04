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

<style type="text/css">
<!--
#othercf {
	border-style: solid;
	border-width: 1px;
	border-color: #333;
	padding: 6px 6px 8px 6px;
	width: 85%;
	margin: 4px 0 14px 0;
}

.othercf_button {
	padding: 0;
	margin: 0;
}
-->
</style>

<s:form name="copyCriticalFunctionConsequences" 
    action="copyCriticalFunctionConsequences">
   
	<h1>Consequences of Slow Recovery</h1>

	<p>Suppose the function named above is not restarted quickly enough
	following a disaster. Which of the listed &quot;harmful
	consequences&quot; might occur?</p>
	
	<div id="othercf" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	
		<p>
		  <label for="other_CFs"><strong>Suggestion</strong>: If
		the entries you would make on this page are similar to the entries you
		have already made for another of your
		  <s:property value='#session.systemDomain.displayConstants.criticalLower'/> functions, you can populate this
		page automatically. You can edit afterwards.</label></p>
		
		<s:select
		    name="selectedId"
		    list="criticalFunctions"
		    listKey="id"
		    listValue="name"
		    headerKey="0"
		    headerValue="Please select ..."/>
		    
           <input name="Populate" 
               type="submit"
			value="Populate this page from the selected function"
			class="othercf_button" 
			onclick="return confirm('This action will overwrite all the data on this page. All current data will be deleted. Do you want to continue?');"/>

	</div>
	
    <s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
    <s:hidden name='criticalFunction.name' />
    
    <s:token />

</s:form>
	
<s:form name="saveCriticalFunctionConsequences" 
    action="saveCriticalFunctionConsequences">

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<th scope="col">Harmful Consequence</th>
			<th scope="col">May occur</th>
			<th scope="col">Explain, if needed.</th>
		</tr>
		
		<tr>
			<td>Disruption of teaching?</td>
			<td>
			    <s:checkbox
                       name="criticalFunction.consequences['DISRUPT_TEACHING'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
			        title='Check Disruption of teaching'/>
               </td>
			<td>
			    <s:textfield 
                       name="criticalFunction.consequences['DISRUPT_TEACHING'].explanation"
			        cssClass='%{#session.planAccessControl.addClass}'
			        readonly='%{#session.planAccessControl.isReadOnly}'
				    size="50" 
				    title="Explain Disruption of teaching"/>
			</td>
		</tr>

		<tr>
			<td>Disruption of research?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['DISRUPT_RESEARCH'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Disruption of research'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['DISRUPT_RESEARCH'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Disruption of research"/>
               </td>
		</tr>

		<tr>
			<td>Disruption of patient care?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['DISRUPT_PATIENT_CARE'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Disruption of patient care'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['DISRUPT_PATIENT_CARE'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Disruption of patient care"/>
               </td>
		</tr>

		<tr>
			<td>Departure of faculty?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['DEPARTURE_FACULTY'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Departure of faculty'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['DEPARTURE_FACULTY'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Departure of faculty"/>
               </td>
		</tr>

		<tr>
			<td>Departure of staff?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['DEPARTURE_STAFF'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Departure of staff'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['DEPARTURE_STAFF'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Departure of staff"/>
               </td>
		</tr>

		<tr>
			<td>Departure of students?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['DEPARTURE_STUDENTS'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Departure of students'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['DEPARTURE_STUDENTS'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Departure of students"/>
               </td>
		</tr>

		<tr>
			<td>Well-being of faculty/staff?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['WELLBEING_FACULTY_STAFF'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Well-being of faculty/staff'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['WELLBEING_FACULTY_STAFF'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Well-being of faculty/staff"/>
               </td>
		</tr>

		<tr>
			<td>Well-being of students?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['WELLBEING_STUDENTS'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Well-being of students'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['WELLBEING_STUDENTS'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Well-being of students"/>
               </td>
		</tr>

		<tr>
			<td>Payment deadlines unmet?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['PAYMENT_DEADLINES_UNMET'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Payment deadlines unmet'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['PAYMENT_DEADLINES_UNMET'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Payment deadlines unmet"/>
               </td>
		</tr>

		<tr>
			<td>Loss of revenue?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['LOSS_REVENUE'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Loss of revenue'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['LOSS_REVENUE'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Loss of revenue"/>
               </td>
		</tr>

		<tr>
			<td>Legal obligations unmet?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['LEGAL_OBLIGATIONS_UNMET'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Legal obligations unmet'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['LEGAL_OBLIGATIONS_UNMET'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Legal obligations unmet"/>
               </td>
		</tr>

		<tr>
			<td>Legal harm to the Institution?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['LEGAL_HARM_UNIVERSITY'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Legal harm to the University'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['LEGAL_HARM_UNIVERSITY'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Legal harm to the University"/>
               </td>
		</tr>

		<tr>
			<td>Impact on other unit(s)?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['IMPACT_OTHER_UNITS'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Impact on other unit(s)'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['IMPACT_OTHER_UNITS'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Impact on other unit(s)"/>
               </td>
		</tr>

		<tr>
			<td>Impact on important business partner(s)?</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['IMPACT_BUSINESS_PARTNERS'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Impact on important business partner(s)'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['IMPACT_BUSINESS_PARTNERS'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Impact on important business partner(s)"/>
               </td>
		</tr>

           <tr>
   			<td>Other? (please explain)</td>
               <td>
                   <s:checkbox
                       name="criticalFunction.consequences['OTHER'].isMayOccur"
                       disabled='%{#session.planAccessControl.isSelectDisabled}'
                       title='Check Other'/>
               </td>
               <td>
                   <s:textfield 
                       name="criticalFunction.consequences['OTHER'].explanation"
                       cssClass='%{#session.planAccessControl.addClass}'
                       readonly='%{#session.planAccessControl.isReadOnly}'
                       size="50" 
                       title="Explain Other"/>
               </td>
	</table>
	
    <s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
    <s:hidden name='criticalFunction.name' />
    <s:include value="/pages/widget/ActionErrors.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    <s:token />

</s:form>
