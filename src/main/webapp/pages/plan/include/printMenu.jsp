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
		<script type="text/javascript" language="JavaScript">

			 function doit(section, planId) {
				var seclen=section.length;
				secval=-1;
				for (var i=0;i<seclen;i++) {
					 if  (section[i].checked) {
						 secval=i;
					 }

				}
				
				// alert('I got section ' +secval);
			    mainval=1;  // Let 1 be section, 0 be entire.
				mainradio=document.getElementById('entire');
				if (mainradio.checked) {
					mainval=0;
				}
                partradio=secval;         
                
			    // alert(mainval);
                opstr='?entire='+mainval+'&section='+secval + '&id=' + Math.floor(Math.random()*101) * planId * 19 * 27;
				// alert(opstr)
			    window.open('/kcpt/continuity.rpt'+opstr);
		     }
			 function toggleSelect(){
			 	var myElement = document.getElementById("entire");
			 	myElement.checked = false;
			 	var myElement = document.getElementById("part");
			 	myElement.checked = true;
			 	return true;
			 }
			 function toggleSelectSectionOnly(){
				 	var myElement = document.getElementById("entire");
				 	myElement.checked = false;
				 	var myElement = document.getElementById("part");
				 	myElement.checked = true;
				 	var myElement = document.getElementById("section_cf");
				 	myElement.checked = true;
				 	return true;
			  }
			 
			 function resetButtons(buttonGroup) {
				
				   for (i=0; i < buttonGroup.length; i++) { 
				          if (buttonGroup[i].checked == true) { // if a button in group is checked,
					           buttonGroup[i].checked = false;  // uncheck it
					       }
				   }
				 	return true;
			 }
		</script>
<p class="plan">Continuity Plan for <span id="planname"><s:property value="#session.plan.acronymPlusName"/></span></p>
<div id="innertube">
    <div class="MyHeaderDivClass">
        <h1>Printing Menu </h1>
        <p>View any of the following documents, then print if desired.</p>
        <h2>A.  Continuity Plan</h2>
        <p>Your Continuity Plan is an Adobe Acrobat document.  You have several options:</p>
        <s:form name="PrintOptions" action="printAction">
        <table id="print_table">
	        <tr>
	            <td scope="row">
	                <input name="entire" id="entire" type="radio" checked="yes" value="E" onClick="resetButtons(document.PrintOptions.section);"  />&nbsp;View Entire Plan
	            </td>
	        </tr>
	        <tr>
	            <td scope="row">
	                <input name="entire" id="part" type="radio" onClick="toggleSelectSectionOnly();" value="S" />&nbsp;View a section only:
	            </td>
	        </tr>
	        <tr>
	            <td scope="row" class="indent">
	                <input name="section" id="section_cf" type="radio"  onClick="toggleSelect();" value="cf"  />&nbsp;<s:property value="#session.systemDomain.displayConstants.criticalUpper"/> Functions
	            </td>
	        </tr>
	        <tr>
	            <td scope="row" class="indent">
	                <input name="section" id="section" type="radio" onClick="toggleSelect();"  value="it"  />&nbsp;Information Technology
	            </td>
	        </tr>
	        <tr>
	            <td scope="row" class="indent">
	                 
                     <s:if test="#session.systemDomain.settings.isInstructionVisible == false">
                     	<input name="section" id="section" type="radio" onClick="toggleSelect();"  value="fr"  />
	                    <s:property value="#session.systemDomain.displayConstants.facultyPrepareShort"/> Preparedness
                     </s:if>
 					<s:if test="#session.systemDomain.settings.isInstructionVisible == true">
 						 <input name="section" id="section" type="radio" onClick="toggleSelect();"  value="in"  />&nbsp;Instruction                    
                    </s:if>
	            </td>
	        </tr>
	        <tr>
	            <td scope="row" class="indent">
	                <input name="section" id="section" type="radio" onClick="toggleSelect();" value="kr"  />&nbsp;Key Resources
	            </td>
	        </tr>
	        <tr>
	            <td scope="row" class="indent">
	                <input name="section" id="section" type="radio" onClick="toggleSelect();"  value="ai"  />&nbsp;Action Items
	            </td>
	        </tr>
	    </table>
        <div class="button">
            <input name="Submit" type="Button" value="View Your Plan As Indicated Above" 
			 onClick="doit(document.forms['PrintOptions'].elements['section'], <s:property value="#session.plan.id"/>);" />
        </div>
        </s:form>
        <h2>B.   Documents that have been Uploaded to Accompany the Continuity Plan </h2>
        <p>(documents may be uploaded at several places in the plan questionnaire)</p>
        <table id="list_table">
            <tr>
                <th  scope="col">Document Name</th>
                <th  scope="col">Description</th>
                <th  scope="col" class="link">&nbsp;</th>
            </tr>
            <s:if test="documents.size() == 0">
                <tr><td>- No documents have been uploaded -</td>
                <td>&nbsp;</td>
                </tr>
            </s:if>
            <s:else>
                <s:iterator value="documents" var="document" status="rowstatus">
                    <s:if test="#rowstatus.odd == true">
                        <s:set var="MyColorClass" value="class='AltRowColor'"/>
                    </s:if>
                    <s:else>
                        <s:set var="MyColorClass" value=""/>
                    </s:else>
                    <tr <s:property value="MyColorClass"/>>
                        <td><s:property value="name"/></td>
                        <td><s:property value="description"/> &nbsp;</td>
                        <td>
                            <s:if test='fileName neq null && fileName neq ""' >
			                    <a title="Click to View Document" 
			                       href="./getDocumentFile?id=<s:property value='id'/>&type=<s:property value='type'/>" 
			                       target="_blank">View</a>
		                    </s:if>
		                </td>
                    </tr>
                </s:iterator>
            </s:else>
        </table>
        <a name="interviewforms">&nbsp;</a> 
        <h2>C.  Interview Forms</h2>
        <p>These are forms you may use when conducting interviews.</p>
        <table id="forms_table">
            <tr>
                <td>Interview Form - Step 1 (<s:property value="#session.systemDomain.displayConstants.deptHeader"/>)</td>
                <td class="formlink" ><a href="../references/InterviewForm_Step1.doc">View</a></td>
            </tr>
            <tr>
                <td class="formname">Interview Form - Step 2 (<s:property value="#session.systemDomain.displayConstants.criticalUpper"/> Functions)</td>
                <td class="formlink" ><a href="../references/InterviewForm_Step2.doc">View</a></td>
            </tr>
            <tr>
                <td class="formname">Interview Form - Step 3 (Information Technology)</td>
                <td class="formlink" >see Guidance at right</td>
            </tr>
            <tr>
                <s:if test="#session.systemDomain.settings.isInstructionVisible == false">
                    <td class="formname">
                        Interview Form - Step 4 (<s:property value="#session.systemDomain.displayConstants.facultyPrepareShort"/> Preparedness)
                    </td>
                    <td class="formlink" ><a href="../references/InterviewForm_Step4.doc">View</a></td>
                </s:if>
                <s:if test="#session.systemDomain.settings.isInstructionVisible == true">
                    <td class="formname">
                         Interview Form - Step 4 (Instruction)                    
                    </td>
                    <td class="formlink" ><a href="../references/InterviewForm_Step4_Instruction.doc">View</a></td>
                </s:if>
            </tr>
            <tr>
                <td class="formname">Interview Form - Step 5 (Key Resources)</td>
                <td class="formlink" ><a href="../references/InterviewForm_Step5.doc">View</a></td>
            </tr>
             <tr>
                <td class="formname">Interview Form - All Steps</td>
                <td class="formlink" ><a href="../references/InterviewForm_All_Steps.doc">View</a></td>
            </tr>
             <tr>
                <td class="formname">Glossary</td>
                <td class="formlink" ><a href="../references/Glossary.pdf">View</a></td>
            </tr>

        </table>
        <s:include value="/pages/widget/BackButton.jsp"/>
    </div>
</div>