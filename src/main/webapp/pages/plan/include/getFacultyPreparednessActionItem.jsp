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

<h1><s:property value="#session.systemDomain.displayConstants.facultyPrepare" /> Preparedness</h1>
<br>

<s:form name="saveFacultyPreparednessActionItem" action="saveFacultyPreparednessActionItem">

    <a name="bookmark" id="bookmark"></a>

    <p>Individual <span style="text-transform: lowercase">
    <s:property value="#session.systemDomain.displayConstants.facultyPreparePrint" />
    </span> drive teaching, research, and patient care.   Readiness for disaster is a 
    faculty issue as well as a staff issue.</p>
    
    <p>Please list here anything that your department can do to promote disaster-consciousness 
    and disaster-readiness among your <span style="text-transform: lowercase">
    <s:property value="#session.systemDomain.displayConstants.facultyPreparePrint" />
    </span>.  See the Guidance at right for suggestions.</p>

    <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    
        <!-- edit page -->
        <s:include value="/pages/plan/include/editFacultyPreparednessActionItem.jsp" />
        
        <!-- add button -->
        <s:div cssClass="add_to_list_button">
            <br/>
            <input name="Update" type="submit" value="Update">
        </s:div>

        <!-- error line -->
        <s:include value="/pages/widget/ActionErrors.jsp" />
        
    </span>
    
    <s:token /> 

</s:form>