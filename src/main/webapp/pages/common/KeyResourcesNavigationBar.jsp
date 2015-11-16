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

<s:set name="chrs" value="{'a','b','c','d','e','f','g','h','i','j'}"/>
<s:set name="navs" value="{'staffbasics','workhome','teams','skills','staffing','ounit','stake','summary','equip','fac_trans'}"/>
<s:set name="alts" value="{'staff basics','work from home','teams','skills','staffing requirements','staff of other units','stakeholders','document summary','equipments & supplies','facilities & transporations'}"/>
<s:set name="kurl" value="{'getKeyResourcesStaffMembers','getKeyResourcesWorkFromHomeStaffs','getKeyResourcesTeams','getKeyResourcesSkills','getKeyResourcesStaffReqs','getKeyResourcesOtherUnitStaffs','getKeyResourcesStakeholders','getKeyResourcesDocuments','getKeyResourcesEquipmentReqs','getKeyResourcesFacilitiesReqs'}"/>

<s:set name="cIndex" value="0"/>
<s:iterator value="#navs" var="nav" status="rowstatus">
    <s:set name="isSkipped" value="false"/>
    <s:if test="#rowstatus.index == 2">
        <s:if test="#session.systemDomain.settings.isTeamsScreenVisible == false">
            <s:set name="isSkipped" value="true"/>
        </s:if>
    </s:if>
    <s:elseif test="#rowstatus.index == 3">
        <s:if test="#session.systemDomain.settings.isSkillsScreenVisible == false">
            <s:set name="isSkipped" value="true"/>
        </s:if>
    </s:elseif>
    <s:elseif test="#rowstatus.index == 4">
        <s:if test="#session.systemDomain.settings.isStaffRequirementsScreenVisible == false">
            <s:set name="isSkipped" value="true"/>
        </s:if>
    </s:elseif>
    <s:if test="#isSkipped == false">
        <s:set name="nav%{#rowstatus.index}" value="%{'subnav_'+#chrs[#cIndex]+'_' + #navs[#rowstatus.index]}"/>
        <s:set name="alt%{#rowstatus.index}" value="%{#chrs[#cIndex]+': ' + #alts[#rowstatus.index]}"/>
        <s:set name="cIndex" value="%{#cIndex+1}"/> 
    </s:if>
    <s:else>
        <s:set name="nav%{#rowstatus.index}" value="''"/>
        <s:set name="alt%{#rowstatus.index}" value="''"/>
    </s:else>
</s:iterator>


<s:if     test='subNav.name() == "STAFF_BASICS"'>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:if>
<s:elseif test='subNav.name() == "WORK_FROM_HOME"'>
    <s:set name="nav1" value="%{#nav1+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "TEAMS"'>
    <s:set name="nav2" value="%{#nav2+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "SKILLS"'>
    <s:set name="nav3" value="%{#nav3+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "STAFF_REQ"'>
    <s:set name="nav4" value="%{#nav4+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "STAFF_OTHER"'>
    <s:set name="nav5" value="%{#nav5+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "STAKEHOLDERS"'>
    <s:set name="nav6" value="%{#nav6+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "DOCUMENTS"'>
    <s:set name="nav7" value="%{#nav7+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "EQUIPMENT"'>
    <s:set name="nav8" value="%{#nav8+'_down'}"/>
</s:elseif>
<s:elseif test='subNav.name() == "FACILITIES"'>
    <s:set name="nav9" value="%{#nav9+'_down'}"/>
</s:elseif>
<s:else>
    <s:set name="nav0" value="%{#nav0+'_down'}"/>
</s:else>

<s:set name="navs" value="{#nav0, #nav1, #nav2, #nav3, #nav4, #nav5, #nav6, #nav7, #nav8, #nav9}"/>
<s:set name="alts" value="{#alt0, #alt1, #alt2, #alt3, #alt4, #alt5, #alt6, #alt7, #alt8, #alt9}"/>

<div id="subnav">
    <ul>
        <s:iterator value="navs" status="rowstatus">
            <s:set name="isSkipped" value="false"/>
            <s:if test="#rowstatus.index == 2">
                <s:if test="#session.systemDomain.settings.isTeamsScreenVisible == false">
                    <s:set name="isSkipped" value="true"/>
                </s:if>
            </s:if>
            <s:elseif test="#rowstatus.index == 3">
                <s:if test="#session.systemDomain.settings.isSkillsScreenVisible == false">
                    <s:set name="isSkipped" value="true"/>
                </s:if>
            </s:elseif>
            <s:elseif test="#rowstatus.index == 4">
                <s:if test="#session.systemDomain.settings.isStaffRequirementsScreenVisible == false">
                    <s:set name="isSkipped" value="true"/>
                </s:if>
            </s:elseif>
            <s:if test="#isSkipped == false">
                <li>
                    <a href="<s:property value='#kurl[#rowstatus.index]'/>">
                        <img src="/continuity/images/keyresources/<s:property value='#navs[#rowstatus.index]'/>.gif" alt="<s:property value='#alts[#rowstatus.index]'/>" border="0">
                    </a>
                </li>
            </s:if>
        </s:iterator>
    </ul>
</div>

