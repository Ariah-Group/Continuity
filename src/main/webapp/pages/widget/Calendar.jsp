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
<s:include value="../common/YUI.jsp"/>
<style type="text/css">
    #divCal {display:none; position:absolute; z-index:1}
</style>
<script type="text/javascript">
    calendarInit = function() {
    	function dateToLocaleString(dt) {
    		var dd = dt.getDate();
    		var mm = dt.getMonth()+1;
    		var yyyy = dt.getFullYear();
    		if(dd<10){dd='0'+dd}
    		if(mm<10){mm='0'+mm}
            return (mm+'/'+dd+'/'+yyyy);
        }
        
    	function mySelectHandler(type,args,obj) {
            var selected = args[0];
            var selDate = this.toDate(selected[0]);
            var selDateStr = dateToLocaleString(selDate);
            document.getElementById("dto.reviewDate").value = selDateStr;
            this.hide();
        };

    	var cal = new YAHOO.widget.Calendar("cal","divCal", { title:"Choose a date:", close:true } );
    	cal.render();
    	
        YAHOO.util.Event.on("aCal", "click", cal.show, cal, true);
        cal.selectEvent.subscribe(mySelectHandler, cal, true);
    }
    
    YAHOO.util.Event.onDOMReady(calendarInit);
 
</script>