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
<div id="maincontainer">
    <div id="instructionhelp">
      <h1>Should we include functions that we do only in times of crisis?</h1>
      <p>Some units have functions that they do not normally perform, but may be called upon to do so in times of crisis.  For example,</p>
      <ul>
        <li>A campus housing department may have to <strong>operate isolation/quarantine facilities</strong> during a pandemic</li>

        <li>A campus police department may have to <strong>enforce closure of the entire campus</strong> following a severe earthquake or flood</li>
        <li>The department that operates campus gym facilities may have to <strong>convert gyms into classrooms.</strong></li>
      </ul>
      <p>These "extraordinary" functions (done only  during crisis) typically require specific and detailed plans.  MOST UNITS WILL NOT HAVE SUCH FUNCTIONS, but if your unit does, you can attach any separate plan on the <a href="getKeyResourcesDocuments">Document Summary</a> screen.  If no separate plan exists, you might create an <a href="getPlanActionItems">Action Item</a> to remind your unit to develop a separate plan.</p>

      <p>In any case, DO NOT include such &ldquo;extraordinary functions&rdquo; on your list of <s:property value="#session.systemDomain.displayConstants.criticalLower"/> functions on the previous screen.</p>
      <br>
        
    </div>
    <!--closes instructionhelp div-->
	<s:include value="/pages/widget/BackButton.jsp"/>  
</div>
<!--closes closes maintcontainer div-->
