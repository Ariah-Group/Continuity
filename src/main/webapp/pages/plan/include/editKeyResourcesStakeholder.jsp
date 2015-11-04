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

<h1>Other Stakeholders</h1>

<a name="bookmark" id="bookmark"></a>
   
<p>Are there any <strong>other people</strong> that your staff may need to contact after a disruptive event?  
For example - vendors, clients, project partners, donors, sponsors, other stakeholders?</p>
<p>Please list them here.</p>
<p>When listing vendors, please include only those that your department makes individual purchases 
from (as opposed to those vendors who sell in bulk to the central purchasing department). </p> 
<span class="required">*</span>indicates a required answer.
<table class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
    <tr>
        <td>
            <ul class="nameslist">
                <li>
                    <label for="dto.firstName"><strong>First Name</strong>:</label>
                    <s:textfield name="dto.firstName" maxlength="20"/> 
                </li>
                <li>
                    <label for="dto.lastName"><strong>Last Name</strong>:</label>
                    <s:textfield name="dto.lastName" maxlength="30" />
                </li>
                <li>
                    <label for="dto.department"><strong>Dept/Organization</strong>:</label>
                    <s:textfield name="dto.department" maxlength="100" />
                </li>
                <li>
                    <label for="dto.address"><strong>Address</strong>:</label>
                    <s:textarea name="dto.address"  rows="3" />
                </li>
                <li>
                    <label for="dto.email"><strong>Email</strong>:</label>
                    <s:textfield name="dto.email" maxlength="80" />
                </li>
                <li>
                    <label for="dto.suppliedProductsOrServices"><strong>Products/services supplied</strong>&nbsp;(if vendor): </label> 
                    <s:textarea name="dto.suppliedProductsOrServices" rows="3"/>
                </li>
                <li>
                    <label for="dto.comment"><strong>Comment</strong>:</label>
                    <s:textarea name="dto.comment" rows="3"/>
                </li>
                <li>
                    <label for="dto.alternateVendors"><strong>Alternate vendors</strong>: (If vendor, name one or two alternates)</label>
                    <s:textarea name="dto.alternateVendors"  rows="3"/>
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
                    <s:textfield name="dto.fax"  maxlength="20" />
                </li>
                <li>
                    <label for="dto.stakeholderType.id"><span class="requiredSmall">*</span><strong>This is</strong>:</label>
                    <s:select
                        name="dto.stakeholderType.id"
                        list="refListMap['StakeholderType']"
                        listKey="id"
                        listValue="description"
                        headerKey="0"
                        headerValue="Please select ..."/>
                </li>
            </ul>
        </td>
    </tr>
</table>
<s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>
