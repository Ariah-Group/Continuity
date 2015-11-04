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
<!--- Guidance for Administrator accounts screen --->

<ul>
<li>Definitions:</li>
<ul class="indent">
	<li>System &ndash; shorthand for this software tool</li>
	<li>Institution &ndash; a group of Locations (typically a multi-campus university or community college)</li> 
 	<li>Location &ndash; a campus</li>
	<li>Department &ndash; any subunit of the campus (loosely defined)</li>
    <li>Role &ndash; a set of hierarchical privileges within this Tool.  The 6 roles are described below.</li>
	</ul>

<li>System Administrator (SA)</li>
<ul class="indent">
	<li>Can enable/disable any location's access to this Tool</li>
	<li>Can assign/remove roles for any user in the system</li>
	<li>Has query access to all data in the database (all locations)</li>
	<li>Is automatically a Local Administrator for his home location.</li>
	
    </ul>
    
    <li>Institution Administrator (IA)</li>
<ul class="indent">
	<li>Can enable/disable access to this Tool for any location within his institution</li>
	<li>Can assign/remove roles within his institution</li>
	<li>Is automatically a Local Administrator for his home location.</li>
    </ul>
	
<li>A Local Administrator(LA) </li>
<ul class="indent">
	<li>Can enable/disable access for any or all users at his location</li>
	<li>Can assign/remove roles within his location</li>
	<li>Has access to the Administrator's Control Screens for his location</li>
	<li>Has read/write access to all plans created at his location</li>
	<li>Can delete entire plans at his location.</li>
	</ul>
    <li>Moderator (MO)</li>
<ul class="indent">
	<li>Approves/denies requests for passwords.</li>
	</ul>
	
<li>Universal Viewer (UV)</li>
<ul class="indent">
	<li>Has read-only access to all Plans at his location</li>
	<li>Can access all uploaded documents for his location </li>
	<li>This role exists primarily for times of crisis. It pre-authorizes certain staff to access documents if a tool administrator is not available.</li></ul>
    
<li>Local User (LU)</li>
<ul class="indent">
	<li>This is the default role, held by almost all users</li>
	<li>Local users can access only those Plans for which they have been specifically authorized.</li>
	</ul>


<li>Note: user-accounts created by typing into this screen will be sent a system email conveying login name & password.</li>	

</ul>