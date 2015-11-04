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

<s:form action="updateKeyResourcesEquipmentReqs">

    <h1>Equipment &amp; Supplies</h1>
     
    <p>Please indicate on this screen the MINIMUM equipment you will need to perform ALL the 
    <s:property value='#session.systemDomain.displayConstants.criticalLower'/> functions that you listed 
    in Step 2. Estimate, don't agonize. Guess if you need to.</p>
    
    <h1>A.  Office Equipment</h1>

    <table id="equip">
        <tr>
            <th scope="col" class="item">Item</th>
            <th scope="col" class="minimum">Minimum No. Required </th>
            <th  scope="col">Comment?</th>
        </tr>

        <tr>
            <td><label for="equipReqs.officeEquipmentMins.WORKSTATION.minReq">Workstation (includes desktop computer, network connection, table, chair)</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.WORKSTATION.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.WORKSTATION.comment"
                    rows="2"/>
            </td>
        </tr>
        
        <tr>
            <td ><label for="equipReqs.officeEquipmentMins.LAPTOP.minReq">Laptop computer (car charger advised)</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.LAPTOP.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.LAPTOP.comment"
                    rows="2"/>
            </td>
        </tr>
        
        <tr>
            <td ><label for="equipReqs.officeEquipmentMins.TELEPHONE.minReq">Telephone (hard-wired)</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.TELEPHONE.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.TELEPHONE.comment"
                    rows="2"/>
            </td>
        </tr>
        
        <tr>
              <td><label for="equipReqs.officeEquipmentMins.PRINTER.minReq">Printer</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.PRINTER.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.PRINTER.comment"
                    rows="2"/>
            </td>
        </tr>

        <tr>
            <td><label for="equipReqs.officeEquipmentMins.FAX.minReq">Fax</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.FAX.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.FAX.comment"
                    rows="2"/>
            </td>
        </tr>
        
        <tr>
            <td><label for="equipReqs.officeEquipmentMins.COPIER.minReq">Copier</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.COPIER.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.COPIER.comment"
                    rows="2"/>
            </td>
        </tr>
        
        <tr>
            <td ><label for="equipReqs.officeEquipmentMins.SCANNER.minReq">Scanner</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.SCANNER.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.SCANNER.comment"
                    rows="2"/>
            </td>
        </tr>
        
        <tr>
              <td><label for="equipReqs.officeEquipmentMins.SERVER.minReq">Server</label></td>
            <td>
                <s:textfield 
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.SERVER.minReq" 
                    size="8" 
                    maxlength="5"/>
            </td>
            <td>
                <s:textarea
                    readonly="#session.planAccessControl.isInputReadOnly"
                    cssClass="%{#session.planAccessControl.addClass}"
                    name="equipReqs.officeEquipmentMins.SERVER.comment"
                    rows="2"/>
            </td>
        </tr>
    </table>

    <s:include value="/pages/widget/ActionErrors.jsp" />

    <h1>B.  Other Equipment:</h1> 

    <p><label for="equipReqs.otherEquipmentNeeds">List equipment of any type, major items only.
    DO NOT list consumables.  Explain if necessary.  If you prefer, upload lists on the 
    <a href="getKeyResourcesDocuments">Documents</a> screen.</label></p>

    <s:textarea
        readonly="#session.planAccessControl.isInputReadOnly"
        cssClass="wide %{#session.planAccessControl.addClass}"
        name="equipReqs.otherEquipmentNeeds"
        rows="8"/>

    <h1>C.  Supplies:</h1>

    <p><label for="equipReqs.suppliesNeeds">What supplies (consumables) must your unit absolutely have in 
    order to function?  If you prefer, upload lists on the <a href="getKeyResourcesDocuments">
    Documents</a> screen.</label></p>

    <s:textarea
        readonly="#session.planAccessControl.isInputReadOnly"
        cssClass="wide %{#session.planAccessControl.addClass}"
        name="equipReqs.suppliesNeeds"
        rows="8"/>

    <p><label for="equipReqs.supplyCrisisActions">In a severe pandemic, deliveries may slow or cease for
    a couple of months due to employee absences at every level of the supply chain.  
    Might your unit face a supply crisis?  Do you need to adjust your inventory 
    practices, or to stockpile specific items?</label></p>
    
    <s:textarea
        readonly="#session.planAccessControl.isInputReadOnly"
        cssClass="wide %{#session.planAccessControl.addClass}"
        name="equipReqs.supplyCrisisActions"
        rows="4"/>

    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />

</s:form>