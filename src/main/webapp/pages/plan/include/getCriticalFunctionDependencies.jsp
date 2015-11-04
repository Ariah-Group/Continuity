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

<style type="text/css">
<!--
#othercf {
	border-style: solid;
	border-width: 1px;
	border-color: #333;
	padding: 6px 6px 8px 6px;
	width: 100%;
	margin: 4px 0 14px 0;
}

.othercf_button {
	padding: 0;
	margin: 0;
}
-->
</style>

<h1>Dependencies<a name="bookmark">&nbsp;</a></h1>

<a name="bookmark"></a>

<p>Please indicate the departments (WITHIN your campus, medical
center, or other institution) whose reduced functioning would seriously
impair your own department's ability to perform the above function.</p>
<p>Conversely, please also indicate those departments that would be
seriously impacted if YOUR DEPARTMENT could not perform the above
function.</p>

<p>In other words, whom do you depend on (upstream dependencies),
and who depends on you (downstream dependencies)?</p>

<s:form name="copyCriticalFunctionDependencies" action="copyCriticalFunctionDependencies">
 
    <s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
    <s:hidden name='criticalFunction.name' />

	<div id="othercf" class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
	
		<p>
		  <label for="copyCriticalFunctionId"><strong>Suggestion</strong>: If
		the entries you would make on this page are similar to the entries you
		have already made for another of your
		  <s:property value='#session.systemDomain.displayConstants.criticalLower' /> 
		functions, you can populate this page automatically. 
		You can edit afterwards.</label></p>
		
		<s:select
		    name="copyCriticalFunctionId"
		    cssClass="PopSelectClass"
		    list="criticalFunctions"
		    listKey="id"
		    listValue="name"
		    headerKey="0"
		    headerValue="Please select %{#session.systemDomain.displayConstants.criticalLower} function..." />
		<s:submit 
		    name="Populate" 
		    type="button" 
		    value="Populate this page"
			cssClass="othercf_button" 
			onclick="confirm('This action will overwrite all the data on this page. All current data will be deleted. Do you want to continue?');" />
	
	</div>
	
	<s:token />
	
</s:form>
	
<s:form name="addCriticalFunctionDependency" action="addCriticalFunctionDependency">

    <s:hidden name='cfNav' />
    <s:hidden name='criticalFunction.id' />
    <s:hidden name='criticalFunction.name' />
    <s:hidden name="addType"/>

	<table id="dependent">
		<tr>
			<td>
			
	            <h2>Upstream Dependencies</h2>
	                  
			    <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
			        <label for="upDependencyId">Select from this list and/or add your own:</label>
			        <s:select
			            name="upDependencyId"
			            cssClass="DepSelectClass"
			            list="upDependencies"
			            listKey="id"
			            listValue="name"
			            headerKey="0"
			            headerValue="Please select ..."/>
			        <s:div cssClass="add_to_list_button">
			            <s:submit
			                name="addUpToList"
			                value="Add to List"
			                onclick="this.form.addType.value=1;"/>
	      				</s:div>
			        <label for="upDependencyName">Add your own:</label>
			        <s:textfield
			            name="upDependencyName"
			            maxlength="100"
				        cssClass="DepInputClass"/>
                    <s:div cssClass="add_to_list_button">
                        <s:submit
                            name="addUpToList"
                            value="Add to List"
                            onclick="this.form.addType.value=2;"/>
                    </s:div>
	                <br />
	                <strong>Upstream Dependencies</strong>
			    </span>
			    
			    <table class="dependencies">
			        <s:iterator value="upCFDependencies">
				        <tr>
					        <td><s:property value="name"/></td>
					        <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
                                     <a href="javascript:deleteFormCFRow(<s:property value="criticalFunction.id"/>, <s:property value='id'/>)" 
                                        title="Delete (<s:property value="name"/>)" 
                                        onclick="return confirm('Delete dependency: are you sure?');">delete</a>
					        </td>
				        </tr>
				    </s:iterator>
			    </table>
			    
			</td>
	
			<td>&nbsp;&nbsp;</td>
			<td bgcolor="#C5C5C5">&nbsp;</td>
			<td>&nbsp;&nbsp;</td>
	
			<td>
			
			    <h2>Downstream Dependencies</h2>
			    
			    <span class="<s:property value='#session.planAccessControl.noDisplayClass'/>">
			        <label for="dnDependencyId">Select from this list and/or add your own:</label>
			        <s:select
			            name="dnDependencyId"
			            cssClass="DepSelectClass"
			            list="dnDependencies"
			            listKey="id"
			            listValue="name"
			            headerKey="0"
			            headerValue="Please select ..."/>
			        <s:div cssClass="add_to_list_button">
			            <s:submit
			                name="addDnToList"
			                value="Add to List"
			                onclick="this.form.addType.value=3;"/>
			        </s:div>
			        <label for="dnDependencyName">Add your own:</label>
			        <s:textfield
			            name="dnDependencyName"
			            maxlength="100"
			            cssClass="DepInputClass"/>
		            <s:div cssClass="add_to_list_button">
		                <s:submit
		                    name="addDnToList"
		                    value="Add to List"
		                    onclick="this.form.addType.value=4;"/>
		            </s:div>
		            <br />
		            <strong>Downstream Dependencies</strong>
			    </span>
			    
			    <table class="dependencies">
			        <s:iterator value="dnCFDependencies">
			            <tr>
			                <td><s:property value="name"/></td>
			                <td class="link <s:property value='#session.planAccessControl.noDisplayClass'/>">
			                    <a href="javascript:deleteFormCFRow(<s:property value="criticalFunction.id"/>, <s:property value='id'/>)" 
			                        title="Delete (<s:property value="name"/>)" 
			                        onclick="return confirm('Delete dependency: are you sure?');">delete</a>
			                </td>
			            </tr>
			        </s:iterator>
			    </table>
			    
			</td>

		</tr>
	
	</table>
	
    <!-- error line -->
    <br/>
    <s:include value="/pages/widget/ActionErrors.jsp" />
        
    <!-- save buttons -->
    <s:include value="/pages/widget/SaveContinueButtons.jsp" />
    
    <s:token />
       
</s:form>

<s:form name="DeleteForm" action="deleteCriticalFunctionDependency">
    <s:hidden id="dCFRowId" name="criticalFunction.id"/>
    <s:hidden id="dRowId" name="deleteDependencyId"/>
    <s:token />
</s:form>
