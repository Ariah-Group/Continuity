/*
 * validate method checks if the value of id is 0 then pops up an alert window;
 * Otherwise, direct to the action passed in. 
 * It's used in the authenticate.jsp to validate the required location select. 
 * */

function validate(id, action){
	var systemDomainId = document.getElementById(id);
	if(systemDomainId){
		if(systemDomainId.value == 0){
			alert ("Location is required. Please select a location from the location list.");
			this.window.document.forms[0].action = 'ready';
		} else{
			this.window.document.forms[0].action = action;
		}		
	} 
}