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

<h1>Periods of High Activity</h1>

<p>Please indicate any months when you would expect there to be
especially high activity involved in accomplishing this function. This
might be a peak workload period such as the annual fiscal closing for
accounting functions; or it might denote activities that happen only at
certain times - such as course-registration that happens once per
semester.</p>
<p>Select as many months as needed. Explain if necessary. If this
function has no peak periods, leave blank.</p>

<s:form name="saveCriticalFunctionPeakPeriods"
    action="saveCriticalFunctionPeakPeriods">
    
	<table>
		<tr>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
				name="criticalFunction.peaks[0]"/>
				Jan
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
				disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[3]"/>
                   Apr
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[6]"/>
                   July
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[9]"/>
                   Oct
               </td>
		</tr>
		<tr>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[1]"/>
                   Feb
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[4]"/>
                   May
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[7]"/>
                   Aug
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[10]"/>
                   Nov
               </td>
		</tr>
		<tr>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[2]"/>
                   Mar
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[5]"/>
                   Jun
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[8]"/>
                   Sept
               </td>
			<td>&nbsp;</td>
			<td><s:checkbox
                   disabled='%{#session.planAccessControl.isSelectDisabled}'
                   name="criticalFunction.peaks[11]"/>
                   Dec
               </td>
		</tr>
	</table>
	<br>
	<p>Explanation needed?</p>

    <s:textarea
        readonly='%{#session.planAccessControl.isInputReadOnly}'
        name='criticalFunction.peaksExplantion'
        cssClass='sizelong %{#session.planAccessControl.addClass}'
        rows="3"/>

    <s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
    <s:hidden name='criticalFunction.name' />
    <s:include value="/pages/widget/ActionErrors.jsp" />
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    <s:token />
    
</s:form>