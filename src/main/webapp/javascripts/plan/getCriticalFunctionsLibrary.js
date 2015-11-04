
// Java script library for edit_dept module
// content:
// ShowPlanContacts - Show Plan Contacts Info
// AddContactRow - add contact row
// RemoveContactRow - remove contact row
// ContactSearch - Search Contac Info
//======================================================================================



if (window.attachEvent)
{
window.attachEvent("onload", pageInit);
}


function DetailsShowHide(SelectedOption, MyButton, Mytext, SwitchClass)
 {
	var ObjButton = document.getElementById(MyButton) ;
	var ObjText = document.getElementById(Mytext) ;
	
//	console.log(SelectedOption + " " + MyButton + " " + Mytext) ;
	
	// check SelectedOption
	if (SelectedOption == '0' || SelectedOption == '4') {
		// No details
		ObjButton.className = SwitchClass ; 
		ObjText.className = '' ;
 	} else {
		// Details
		ObjButton.className = '' ; 
		ObjText.className = SwitchClass ;
 	}
	
	
	return true; 
}

function pageInit() {
   obj = document.CriticalFunctions;
   j = 0;
   for (var i = 0; i < obj.length; ++i) {
//     console.log ("> " + obj.elements[i].type);
     if (obj.elements[i].type.indexOf('select') != -1) {			// firefox returns "select-one"
       j = j + 1;
       MyButton = "ButtonOnly" + j;
       Mytext = "TextOnly" + j;
       DetailsShowHide(obj.elements[i].value, MyButton, Mytext, 'NoToDisplay');
     }
   }
}

function changeCriticalFunctionLevel(id, value) {
	document.forms[0].elements['criticalFunctions['+ id + '].criticalityLevel.id'].value = value;
	document.forms[1].elements['criticalFunctions['+ id + '].criticalityLevel.id'].value = value;	
}

function submitForm(cid, buttononly, textonly) {
  document.CriticalFunctions.in_cid.value = cid;
  DetailsShowHide(cid, buttononly, textonly,'NoToDisplay')
  document.CriticalFunctions.submit();
}
