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

<h1>Staff of Other Units</h1>

<a name="bookmark" id="bookmark"></a>

<p>Who are the <strong>most important people from
elsewhere <s:property value='#session.systemDomain.displayConstants.keyResource' />
</strong> whom your staff will need to contact within the first few hours or days
after a disruptive event?</p>

<table class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    <tr>
        <td>
            <ul class="nameslist">
                <li>
                    <label for="dto.firstName"><strong>First Name</strong>:</label>
                    <s:textfield name="dto.firstName" maxlength="48"/><br> 
                </li>
                <li>
                    <label for="dto.lastName"><strong>Last Name</strong>:</label>
                    <s:textfield name="dto.lastName" maxlength="48" /><br>
                </li>
                <li>
                    <label for="dto.department"><strong>Dept/Organization</strong>:</label>
                    <s:textfield name="dto.department" />
                </li>
                <li>
                    <label for="dto.address"><strong>Address</strong>:</label>
                    <s:textarea name="dto.address" rows="3"/>
                </li>
                <li>
                    <label for="dto.email"><strong>Email</strong>:</label>
                    <s:textfield name="dto.email" maxlength="48" />
                </li>
                <li>
                    <label for="dto.comment"><strong>Comment</strong>:</label>
                    <s:textarea name="dto.comment" rows="3" />
                </li>
            </ul> 
        </td>
        <td>
            <ul class="nameslist">
                <li>
                    <label for="dto.workPhone"><strong>Work Phone</strong>:</label>
                    <s:textfield name="dto.workPhone" maxlength="20" />
                </li>
                <li>
                    <label for="dto.cellPhone"><strong>Cell Phone</strong>:</label>
                    <s:textfield name="dto.cellPhone" maxlength="20" />
                </li>
                <li>
                    <label for="dto.fax"><strong>Fax</strong>:</label>
                    <s:textfield name="dto.fax" maxlength="20" />
                </li>
            </ul>
        </td>
    </tr>
</table>
<s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
