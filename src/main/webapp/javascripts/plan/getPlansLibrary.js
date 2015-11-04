
// Java script library for EditPlan module
// content:
// ShowPlanContacts - Show Plan Contacts Info
//======================================================================================


var myProxy= new EditPlan ;
myProxy.setHTTPMethod('POST');


if (window.attachEvent)
{
window.attachEvent("onload", correctPNG);
}

if (window.attachEvent)
{
window.attachEvent("onload", pageInit);
}


function ShowPlanContacts(PlanId, PlanName, WindowName, URL) {
	day = new Date();
	id = day.getTime();
	window.showModalDialog("./getPlanContacts?planId="+PlanId,id,'dialogWidth:644; dialogHeight:174; help:off;scroll:off; status:off; center:on; resizable:off; unadorned:on;');
	//eval("WindowName" + id + " = window.showModalDialog(URL, '" + id + "', dialogWidth:644;, dialogHeight:174; help:no;scroll:no; status:no; center:yes; resizable:no; unadorned:yes;');");
//	<!--    <cfwindow name="PlanContactInfo" center="true" closable="true" height="174" draggable="true" initshow="false" resizable="false" width="644" title="Plan Contacts Info" headerstyle="background-color:##E9E9E9;color:black;"></cfwindow>-->
}

//function ShowPlanContacts(PlanID,PlanName,WndowName) {
//  var myWindow = ColdFusion.Window.getWindowObject(WndowName);
//  // myWindow.toolbox.remove();
//  // myWindow.header.remove();
//  myWindow.setTitle('Contacts for (' + PlanName + ') plan');
//
//
//	//calculate proper position for window
//	// var PosY = getElementsByClass(UserLastNameClass)[0].offsetTop + 20;
//	// var PosX = getElementsByClass(UserLastNameClass)[0].offsetLeft ;
//	
//	var targetCFM = '../Include/ShowPlanContacts.cfm?PlanID=' + escape(PlanID);
//
//	ColdFusion.navigate(targetCFM, WndowName) ;
//
//	//show window
//	ColdFusion.Window.show(WndowName);
//
//	// alert(InstitutionID) ;
//	
//	
//	
//	
//	// var result = myProxy.DeleteAccount(UserID,IntegrityCheck,RequestorID) ;
//	
//	return true; 
//}


function submitForm(pid) {
   document.SelectPlan.planId.value = pid;
   document.SelectPlan.submit();
}

function pageInit() {
}