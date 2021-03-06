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
<s:include value="../../widget/FloatingPanel.jsp"/>
<script>
	YAHOO.util.Event.onDOMReady(
	    function() {
	        createFloatingPanel(525,174,YAHOO.util.Dom.getElementsByClassName('myLink','span'),"click");
        }
	);
	
	function showPlanContacts(planId, planName) {
	    // Start the transaction. 
	    document.getElementById('hd').innerHTML = 'Contact for (' + planName + ') plan';
        document.getElementById('bd').innerHTML = '';
        day = new Date();
        id = day.getTime();
	    url = "/continuity/plan/getPlanContacts?planId="+planId+"&ts="+id;
	    startAjaxGetRequest(url);
	}
</script>
