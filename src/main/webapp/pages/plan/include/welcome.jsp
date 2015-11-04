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

<div id="welcome-text">

	<h1>Welcome <s:property value="#session.user.fullName" /> - <s:property
		value="#session.user.systemDomain.name" /></h1>
	
	<p>This is an online continuity planning tool designed for campuses, medical centers, and other institutions of higher education.</p>
	
	<p>This tool will help your department prepare for those adverse
	events that we call disasters. Disaster-events can be wide in scope
	(earthquake, wildfire, pandemic, terrorism). Disasters can also be more
	localized (fire in your building, or even the failure of your hard
	drive!).</p>
	
	<p>The goal of continuity planning is to enable us to continue our
	mission despite these events. Some departments - particularly in 
	medical centers but also on campuses - will be expected not only to continue but to expand
  their services during these times.</p>
	
	<p>This tool will guide you, step by step, to
  create a continuity plan.&nbsp; Your plan will identify:</p>
	
	<ul>
		<li><strong style="text-transform: uppercase"><s:property
			value="#session.systemDomain.displayConstants.criticalLower" />
		FUNCTIONS</strong> performed by your department, and the factors needed for
		their continuance.</li>
		<li><span class="bold"><strong>INFORMATION AND
		STRATEGIES</strong></span> that will help during and after the disaster-event.</li>
		<li><span class="bold"><strong>ACTION ITEMS</strong></span> that
		can be done, starting now, to lessen the impact of these events and
		make us ready to cope.</li>
	</ul>
	
	<p>This tool is designed for <i>departmental</i>
	continuity planning. <i>Department</i> is loosely defined as any
	sub-unit of the campus, medical center, or other institution. It might be an entire school, college or division, or
	a small specialized unit. The tool is appropriate for all types of
	departments - instructional, research, patient care, as well as
	administrative and other support units.</p>
	
  <p>This tool is easy-to-use and requires no advance
	training. However, we strongly recommend that you begin your project by
	contacting your <a href="./contactUs">local emergency
	planning/continuity planning office</a> who will provide guidance and
	context.</p>
	
	<div id="save_button">
    	<s:form action="getPlans" method="post"><input type="submit"
            name="Submit" value="Begin or Edit Your Plan"></s:form>
	</div>

</div>