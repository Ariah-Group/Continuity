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
<style type="text/css">
<!--
#floatingpanel .bd {
    overflow:auto;
    background-color:#CBF2FE;
    padding:10px;
}
-->
</style>
<script>
    YAHOO.util.Event.onDOMReady(
        function() {
            document.getElementById('hd').innerHTML = "Add to Plan";
            createFloatingPanel(644,215,document.getElementById("searchUsers"),"click");
        }
    );

    function showSystemDomainUsers(systemDomainId,isContactTable) {
        // Start the transaction. 
        document.getElementById('bd').innerHTML = '';
        url = "searchSystemDomainUsers?systemDomainId="+systemDomainId+"&contactTable="+isContactTable;
        startAjaxGetRequest(url);
    }

    function getSystemDomainUsers(isContactTable) {
        // Start the transaction. 
        var systemDomainId = document.getElementById('UserSystemDomainId').value;
        var firstName = document.getElementById('UserFirstName').value;
        var lastName = document.getElementById('UserLastName').value;
        // verify if valid search(InstitutionId not '0' and Name not empty)
        if (systemDomainId == '0' || (firstName == '' &&  lastName == '')) {
            alert('Must enter either first or last name (partial names are OK).');
        } else {        
            var cb = {
                success:AjaxObject.handleSuccess,
                failure:AjaxObject.handleFailure,
                scope: AjaxObject,
                argument: 'userList'
            };
            var url = "getSystemDomainUsers?systemDomain.id="+systemDomainId+"&firstName="+firstName+"&lastName="+lastName+"&contactTable="+isContactTable;
            startAjaxGetRequest(url, cb);
        }
    }
    
</script>
