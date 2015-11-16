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

<div id="innertube">

<h1>Define Levels of Criticality</h1>

<p>We assign &ldquo;level of criticality&rdquo; to (a) critical
functions and (b) IT systems for two reasons: to prioritize, and to set
expectations about recovery times.</p>

<p>Kuali Ready comes &ldquo;out of the box&rdquo; with default
definitions of &ldquo;level of criticality&rdquo;. You can see these
definitions on</p>

<ul class="bulletlist">
	<li>the Step 2 Critical Functions screen, and</li>
	<li>the Step 3 Centrally-Owned Applications screen.</li>
</ul>

<p>If you desire, you may substitute your own language using the
boxes below.</p>

<br />
<hr />

<s:form name="adminCriticalityLevels">

    <s:hidden name="clType"/>
    <s:hidden name="clEnum"/>

    <a name="cfGuidance">&nbsp;</a> 
    <h2>Step 2 Critical Functions (Guidance Column)</h2>
    
    <table>
	    <tr>
	       <td><label for="clFuncMap['LEVEL1'].name"><strong>Term 1:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clFuncMap['LEVEL1'].name" id="clFuncMap['LEVEL1'].name" size="50" maxLength="50" /></td>
	    </tr>
        <tr>
           <td><label for="clFuncMap['LEVEL1'].longDescription"><strong>Definition 1:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clFuncMap['LEVEL1'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clFuncMap['LEVEL1'].id" />
    <s:hidden name="clFuncMap['LEVEL1'].levelNo.id" />
    <s:hidden name="clFuncMap['LEVEL1'].levelNo.description" />
    <s:hidden name="clFuncMap['LEVEL1'].origDescription" />

	<br />

	<div class="FloatRight">
	    <s:submit 
	        id="btnInstall1" 
	        name="InstallText1" 
	        value="Install This Text"
	        tooltip="Install This Text" 
	        cssClass=""
	        onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL1';this.form.action='criticalityLevelsInstallText';"
	    />
	    <s:submit 
	        id="btnRestore1" 
	        name="RestoreText1" 
	        value="Restore Default Text" 
	        tooltip="Restore Default Text" 
	        cssClass=""
	        onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL1';this.form.action='criticalityLevelsRestoreText';"
	    />
	</div>

    <br /><br />
    
    <table>
        <tr>
           <td><label for="clFuncMap['LEVEL2'].name"><strong>Term 2:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clFuncMap['LEVEL2'].name" id="clFuncMap['LEVEL2'].name" size="50" maxLength="50" /></td>
        </tr>
        <tr>
           <td><label for="clFuncMap['LEVEL2'].longDescription"><strong>Definition 2:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clFuncMap['LEVEL2'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clFuncMap['LEVEL2'].id" />
    <s:hidden name="clFuncMap['LEVEL2'].levelNo.id" />
    <s:hidden name="clFuncMap['LEVEL2'].levelNo.description" />
    <s:hidden name="clFuncMap['LEVEL2'].origDescription" />

    <br />

    <div class="FloatRight">
        <s:submit 
            id="btnInstall2" 
            name="InstallText2" 
            value="Install This Text"
            tooltip="Install This Text" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL2';this.form.action='criticalityLevelsInstallText';"
        />
        <s:submit 
            id="btnRestore2" 
            name="RestoreText2" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL2';this.form.action='criticalityLevelsRestoreText';"
        />
    </div>

    <br /><br />
    
    <table>
        <tr>
           <td><label for="clFuncMap['LEVEL3'].name"><strong>Term 3:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clFuncMap['LEVEL3'].name" id="clFuncMap['LEVEL3'].name" size="50" maxLength="50" /></td>
        </tr>
        <tr>
           <td><label for="clFuncMap['LEVEL3'].longDescription"><strong>Definition 3:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clFuncMap['LEVEL3'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clFuncMap['LEVEL3'].id" />
    <s:hidden name="clFuncMap['LEVEL3'].levelNo.id" />
    <s:hidden name="clFuncMap['LEVEL3'].levelNo.description" />
    <s:hidden name="clFuncMap['LEVEL3'].origDescription" />

    <br />

    <div class="FloatRight">
        <s:submit 
            id="btnInstall3" 
            name="InstallText3" 
            value="Install This Text"
            tooltip="Install This Text" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL3';this.form.action='criticalityLevelsInstallText';"
        />
        <s:submit 
            id="btnRestore3" 
            name="RestoreText3" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL3';this.form.action='criticalityLevelsRestoreText';"
        />
    </div>

    <br /><br />

    <table>
        <tr>
           <td><label for="clFuncMap['LEVEL4'].name"><strong>Term 4:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clFuncMap['LEVEL4'].name" id="clFuncMap['LEVEL4'].name" size="50" maxLength="50" /></td>
        </tr>
        <tr>
           <td><label for="clFuncMap['LEVEL4'].longDescription"><strong>Definition 4:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clFuncMap['LEVEL4'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clFuncMap['LEVEL4'].id" />
    <s:hidden name="clFuncMap['LEVEL4'].levelNo.id" />
    <s:hidden name="clFuncMap['LEVEL4'].levelNo.description" />
    <s:hidden name="clFuncMap['LEVEL4'].origDescription" />

    <br />

    <div class="FloatRight">
        <s:submit 
            id="btnInstall4" 
            name="InstallText4" 
            value="Install This Text"
            tooltip="Install This Text" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL4';this.form.action='criticalityLevelsInstallText';"
        />
        <s:submit 
            id="btnRestore4" 
            name="RestoreText4" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL4';this.form.action='criticalityLevelsRestoreText';"
        />
    </div>
    
	<br />
	<br />
	<br />
	<hr />

    <a name="cfDropDown">&nbsp;</a> 
	<h2>Step 2 Critical Functions &ndash; Drop-Down Lists</h2>
	
    <label for="clFuncMap['LEVEL1'].description"><strong>Item 1 on List:</strong>&nbsp;&nbsp;
        <s:textfield name="clFuncMap['LEVEL1'].description" id="clFuncMap['LEVEL1'].description" maxLength="72" cssClass="wide" />
    </label>
    <label for="clFuncMap['LEVEL2'].description"><strong>Item 2 on List:</strong>&nbsp;&nbsp;
        <s:textfield name="clFuncMap['LEVEL2'].description" id="clFuncMap['LEVEL2'].description" maxLength="72" cssClass="wide" />
    </label>
    <label for="clFuncMap['LEVEL3'].description"><strong>Item 3 on List:</strong>&nbsp;&nbsp;
        <s:textfield name="clFuncMap['LEVEL3'].description" id="clFuncMap['LEVEL3'].description" maxLength="72" cssClass="wide" />
    </label>
    <label for="clFuncMap['LEVEL4'].description"><strong>Item 4 on List:</strong>&nbsp;&nbsp;
        <s:textfield name="clFuncMap['LEVEL4'].description" id="clFuncMap['LEVEL4'].description" maxLength="72" cssClass="wide" />
    </label>
    <br />
    <div class="FloatRight">
        <s:submit 
            id="btnInstall4" 
            name="InstallText4" 
            value="Install Text for All 4 Items"
            tooltip="Install Text for All 4 Items" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL0';this.form.action='criticalityLevelsInstallTextCFD';"
        />
        <s:submit 
            id="btnRestore4" 
            name="RestoreText4" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='FUNC';this.form.clEnum.value='LEVEL0';this.form.action='criticalityLevelsRestoreTextCFD';"
        />
    </div>

	<br />
	<br />
	<br />
	<hr />

    <a name="itGuidance">&nbsp;</a> 
    <h2>Step 3 Information Technology &ndash; Centrally-Owned Applications (Guidance Column)</h2>
    
    <p><span class="AttentionClass">Note:</span>&nbsp;&nbsp;<span class="AttentionClassNotBold">Terms 1,2,3 and 4 (marked with **) will also appear as column-headers in the list at the bottom of the Centrally-Owned Applications page.</span></p>
    
    <table>
        <tr>
           <td><label for="clApplMap['LEVEL1'].name"><strong>Term 1:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clApplMap['LEVEL1'].name" id="clApplMap['LEVEL1'].name" size="50" maxLength="50" />&nbsp;&nbsp;<span class="AttentionClassNotBold">**</span></td>
        </tr>
        <tr>
           <td><label for="clApplMap['LEVEL1'].longDescription"><strong>Definition 1:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clApplMap['LEVEL1'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clApplMap['LEVEL1'].id" />
    <s:hidden name="clApplMap['LEVEL1'].levelNo.id" />
    <s:hidden name="clApplMap['LEVEL1'].levelNo.description" />
    <s:hidden name="clApplMap['LEVEL1'].description" />
    <s:hidden name="clApplMap['LEVEL1'].origDescription" />

    <br />

    <div class="FloatRight">
        <s:submit 
            id="btnInstall1" 
            name="InstallText1" 
            value="Install This Text"
            tooltip="Install This Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL1';this.form.action='criticalityLevelsInstallTextITG';"
        />
        <s:submit 
            id="btnRestore1" 
            name="RestoreText1" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL1';this.form.action='criticalityLevelsRestoreTextITG';"
        />
    </div>

    <br /><br />
    
    <table>
        <tr>
           <td><label for="clApplMap['LEVEL2'].name"><strong>Term 2:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clApplMap['LEVEL2'].name" id="clApplMap['LEVEL2'].name" size="50" maxLength="50" />&nbsp;&nbsp;<span class="AttentionClassNotBold">**</span></td>
        </tr>
        <tr>
           <td><label for="clApplMap['LEVEL2'].longDescription"><strong>Definition 2:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clApplMap['LEVEL2'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clApplMap['LEVEL2'].id" />
    <s:hidden name="clApplMap['LEVEL2'].levelNo.id" />
    <s:hidden name="clApplMap['LEVEL2'].levelNo.description" />
    <s:hidden name="clApplMap['LEVEL2'].description" />
    <s:hidden name="clApplMap['LEVEL2'].origDescription" />

    <br />

    <div class="FloatRight">
        <s:submit 
            id="btnInstall2" 
            name="InstallText2" 
            value="Install This Text"
            tooltip="Install This Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL2';this.form.action='criticalityLevelsInstallTextITG';"
        />
        <s:submit 
            id="btnRestore2" 
            name="RestoreText2" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL2';this.form.action='criticalityLevelsRestoreTextITG';"
        />
    </div>

    <br /><br />
    
    <table>
        <tr>
           <td><label for="clApplMap['LEVEL3'].name"><strong>Term 3:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clApplMap['LEVEL3'].name" id="clApplMap['LEVEL3'].name" size="50" maxLength="50" />&nbsp;&nbsp;<span class="AttentionClassNotBold">**</span></td>
        </tr>
        <tr>
           <td><label for="clApplMap['LEVEL3'].longDescription"><strong>Definition 3:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clApplMap['LEVEL3'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clApplMap['LEVEL3'].id" />
    <s:hidden name="clApplMap['LEVEL3'].levelNo.id" />
    <s:hidden name="clApplMap['LEVEL3'].levelNo.description" />
    <s:hidden name="clApplMap['LEVEL3'].description" />
    <s:hidden name="clApplMap['LEVEL3'].origDescription" />

    <br />

    <div class="FloatRight">
        <s:submit 
            id="btnInstall3" 
            name="InstallText3" 
            value="Install This Text"
            tooltip="Install This Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL3';this.form.action='criticalityLevelsInstallTextITG';"
        />
        <s:submit 
            id="btnRestore3" 
            name="RestoreText3" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL3';this.form.action='criticalityLevelsRestoreTextITG';"
        />
    </div>

    <br /><br />

    <table>
        <tr>
           <td><label for="clApplMap['LEVEL4'].name"><strong>Term 4:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textfield name="clApplMap['LEVEL4'].name" id="clApplMap['LEVEL4'].name" size="50" maxLength="50" />&nbsp;&nbsp;<span class="AttentionClassNotBold">**</span></td>
        </tr>
        <tr>
           <td><label for="clApplMap['LEVEL4'].longDescription"><strong>Definition 4:</strong>&nbsp;&nbsp;</label></td>
           <td><s:textarea name="clApplMap['LEVEL4'].longDescription" cssClass="wide" rows="2" /></td>
        </tr>
    </table>

    <s:hidden name="clApplMap['LEVEL4'].id" />
    <s:hidden name="clApplMap['LEVEL4'].levelNo.id" />
    <s:hidden name="clApplMap['LEVEL4'].levelNo.description" />
    <s:hidden name="clApplMap['LEVEL4'].description" />
    <s:hidden name="clApplMap['LEVEL4'].origDescription" />

    <br />

    <div class="FloatRight">
        <s:submit 
            id="btnInstall4" 
            name="InstallText4" 
            value="Install This Text"
            tooltip="Install This Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL4';this.form.action='criticalityLevelsInstallTextITG';"
        />
        <s:submit 
            id="btnRestore4" 
            name="RestoreText4" 
            value="Restore Default Text" 
            tooltip="Restore Default Text" 
            cssClass=""
            onclick="this.form.clType.value='APPL';this.form.clEnum.value='LEVEL4';this.form.action='criticalityLevelsRestoreTextITG';"
        />
    </div>

    <s:token />

</s:form>

<br />
<br />
<br />
<hr />
<br />

<div class="MyButtonsDivClass">
    <div class="FloatLeft AllignLeft">
        <form>
            <input 
                name="back" 
                id="back"  
                type="button" 
                value="      Back     " 
                title="Return"  
                alt="Go back"  
                onclick="location.href='/continuity/admin/adminHome';"
            />
        </form>
    </div>
</div>

</div>