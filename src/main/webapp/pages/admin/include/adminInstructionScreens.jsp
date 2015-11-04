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

<s:form name="adminInstructionUIText">

<s:hidden id="textKey" name="textKey" />

<h1>Setup Custom Text for Step 4</h1>

<p>The six Instructional Continuity screens (<strong>Step
4: Instruction</strong>) are optional. On the <strong>Setup System
Parameters</strong> screen, you can elect to display either <strong>Step
4: Instruction</strong> (six screens) or <strong>Step 4: Faculty
Preparedness</strong> (single screen). If you elect to use <strong>Step
4: Instruction</strong>, you should set up the five items below.</p>

<br />
<hr />

<h2>Name of Your Campus&#39;s Course Management Tool:</h2>

<p>We make the assumption that every campus uses a <strong>Course
Management Tool</strong> to provide a web adjunct for instructors who choose to
use it. These are also called Learning Management Systems. Some examples
are Blackboard, Moodle, and Sakai, though there are many others.</p>

<p>On two of the Instructional Continuity screens, you will see the
word &quot;bSpace&quot; in several places. bSpace is the course
management tool of the University of California, Berkeley. Please enter
below the name by which your campus&#39;s course management tool is commonly
known. It will then appear instead of the word bSpace. Spacing is tight,
so a single word or short phrase will be best.</p>

<label for=""><strong>Name of your campus&#39;s Course Management Tool:</strong>
&nbsp;&nbsp;<s:textfield name="textMap['INSTR_COURSE_MGMT_TOOL']" id="" size="40" /></label>

<br />
<div class="FloatRight">
    <s:submit 
        id="btnInstall1" 
        name="InstallText1" 
        value="Install This Text"
        tooltip="Install This Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_COURSE_MGMT_TOOL';this.form.action='instructionInstallText';"
    />
    <s:submit 
        id="btnRestore1" 
        name="RestoreText1" 
        value="Restore Default Text" 
        tooltip="Restore Default Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_COURSE_MGMT_TOOL';this.form.action='instructionRestoreText';"
    />
</div>

<br />
<br />
<br />
<hr />

<h2>Your Campus&#39;s Definition of High Priority Course:</h2>

<p>In planning for continuity of instruction, we give a special
level of attention to &quot;high priority courses&quot;. These are the
courses whose interruption would <strong>most</strong> threaten the
progress of students and the integrity of the curriculum. This tool
provides for each campus to enter its own definition of the term
&quot;high priority course&quot;.</p>

<p>The &quot;High Priority Courses&quot; screen as delivered
&quot;out of the box&quot; displays the following default text:</p>

<ul class="bulletlist"><li>Per campus policy, a course is considered High Priority if it
meets these three criteria: it is an undergraduate course, it is a
large-enrollment course, and it is a pre-requisite for a major or part
of a sequence. Graduate-level courses in professional schools (e.g. law,
business, health sciences) that meet the 2nd and 3rd criteria will also
be considered High Priority.</li></ul>

<p>This default text was written for the University of California,
Berkeley&#39;s version of this tool; you should replace it with a
definition that is suitable for your own campus. You may want to consult
with your campus&#39;s appropriate academic officer(s) in crafting this
definition.</p>

<label for=""><strong>Please enter your campus&#39;s definition of High
Priority Course:</strong></label>

<s:textarea name="textMap['INSTR_HIGH_PRIORITY_COURSE']" cssClass="wide" rows="5"/>
<br />
<br />
<div class="FloatRight">
    <s:submit 
        id="btnInstall2" 
        name="InstallText2" 
        value="Install This Text"
        tooltip="Install This Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_HIGH_PRIORITY_COURSE';this.form.action='instructionInstallText';"
    />
    <s:submit 
        id="btnRestore2" 
        name="RestoreText2" 
        value="Restore Default Text" 
        tooltip="Restore Default Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_HIGH_PRIORITY_COURSE';this.form.action='instructionRestoreText';"
    />
</div>

<br />
<br />
<br />
<hr />

<h2>Introductory Text on the &quot;All Courses (Undergraduate
Only)&quot; Screen:</h2>

<p>This screen as delivered &quot;out of the box&quot; displays the
following introductory text:</p>

<ul class="bulletlist"><li>The following disaster-readiness practices for instructors were
developed by faculty, approved by the Academic Senate, and recommended
by the Executive Vice Chancellor and Provost. Each practice will
facilitate continuity of the curriculum under adverse circumstances.</li></ul>

<p>This default text was written for the University of California,
Berkeley&#39;s version of this tool; you should replace it with your own
text.</p>

<label for=""><strong>Please enter your introductory text for this
screen:</strong></label>

<s:textarea name="textMap['INSTR_ALL_COURSES']" cssClass="wide" rows="5"/>
<br />
<br />
<div class="FloatRight">
    <s:submit 
        id="btnInstall3" 
        name="InstallText3" 
        value="Install This Text"
        tooltip="Install This Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_ALL_COURSES';this.form.action='instructionInstallText';"
    />
    <s:submit 
        id="btnRestore3" 
        name="RestoreText3" 
        value="Restore Default Text" 
        tooltip="Restore Default Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_ALL_COURSES';this.form.action='instructionRestoreText';"
    />
</div>

<br />
<br />
<br />
<hr />

<h2>Introductory Text on the &quot;Departmental Practices&quot;
Screen:</h2>

<p>This screen as delivered &quot;out of the box&quot; displays the
following introductory text:</p>

<ul class="bulletlist"><li>The following disaster-readiness practices <strong>for
departments</strong> were developed by faculty, approved by the Academic Senate,
and recommended by the Executive Vice Chancellor and Provost. Each
practice will facilitate continuity of the curriculum under adverse
circumstances.</li></ul>

<p>This default text was written for the University of California,
Berkeley&#39;s version of this tool; you should replace it with your own
text.</p>

<label for=""><strong>Please enter your introductory text for this
screen:</strong></label>

<s:textarea name="textMap['INSTR_DEPARTMENT_PRACTICES']" cssClass="wide" rows="5"/>
<br />
<br />
<div class="FloatRight">
    <s:submit 
        id="btnInstall4" 
        name="InstallText4" 
        value="Install This Text"
        tooltip="Install This Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_DEPARTMENT_PRACTICES';this.form.action='instructionInstallText';"
    />
    <s:submit 
        id="btnRestore4" 
        name="RestoreText4" 
        value="Restore Default Text" 
        tooltip="Restore Default Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_DEPARTMENT_PRACTICES';this.form.action='instructionRestoreText';"
    />
</div>

<br />
<br />
<br />
<hr />

<h2>Descriptive Text for Recommended Practice #2 on the &quot;All
Courses (Undergraduate Only) &quot; Screen:</h2>

<p>This screen as delivered &quot;out of the box &quot; displays the
following descriptive text to explain how grades are expected to be kept
current:</p>

<ul class="bulletlist"><li>Grades are kept current at all times, using the bSpace gradebook
tool.</li></ul>

<p>This default text was written for the University of California,
Berkeley&#39;s version of this tool; you should replace it with text
that is appropriate for your own campus&#39;s systems &amp; practices.</p>

<p>The intent of this recommended practice is that recording grades
as soon as they are awarded (quizzes, exams, final grades) mitigates a
significant risk &ndash; the risk of an instructor or graduate teaching
assistant becoming suddenly unavailable (due to injury, death, other
cause). Grades are the coin of the realm in academia; loss of grades, or
suspicion about the integrity of grades, can be a showstopper.</p>

<label for=""><strong>Please enter your descriptive text for this
practice (be brief, space is limited):</strong></label>

<s:textarea name="textMap['INSTR_RECOMMENDED_PRACTICE']" cssClass="wide" rows="5"/>
<br />
<br />
<div class="FloatRight">
    <s:submit 
        id="btnInstall5" 
        name="InstallText5" 
        value="Install This Text"
        tooltip="Install This Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_RECOMMENDED_PRACTICE';this.form.action='instructionInstallText';"
    />
    <s:submit 
        id="btnRestore5" 
        name="RestoreText5" 
        value="Restore Default Text" 
        tooltip="Restore Default Text" 
        cssClass=""
        onclick="this.form.textKey.value='INSTR_RECOMMENDED_PRACTICE';this.form.action='instructionRestoreText';"
    />
</div>

<br />
<br />
<br />
<hr />
<s:token />

</s:form>

<br />

<s:include value="/pages/widget/BackButton.jsp"/>

</div>