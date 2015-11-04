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

<s:hidden name="dto.id"/>
<s:hidden name="dto.status.id"/>
<s:hidden name="dto.status.description"/>

<label for="dto.name"><strong>Action Item</strong></label>
<s:textarea name="dto.name" cssClass="wide" rows="3"/>

<label for="dto.cost.id"><strong>Cost</strong></label>
<s:select
    name="dto.cost.id" 
    list="refListMap['ActionItemCost']"
    listKey="id"
    listValue="description"/>
    
<label for="dto.costCycle.id"><strong>Cost is</strong></label>        
<s:select 
    name="dto.costCycle.id" 
    list="refListMap['ActionItemCostCycle']"
    listKey="id"
    listValue="description"/>

<label for ="dto.scope.id"><strong>Carrying out this action item is within the scope of </strong></label>
<s:select
    name="dto.scope.id" 
    list="refListMap['ActionItemScope']"
    listKey="id"
    listValue="description"/>
                                      
<label for="dto.comment"><strong>Comment?</strong></label>
<s:textarea name="dto.comment" cssClass="wide" rows="3"/>

<s:hidden name="dto.plan.id" value="%{#session.plan.id}"/>

<br />