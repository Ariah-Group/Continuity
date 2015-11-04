
// Java script library Mainforms
// content:
//======================================================================================


if (window.attachEvent)
{
window.attachEvent("onload", pageInit);
}


 function ShowCustomMessage(CustomMessage) {
	var targetCFM = '../Include/ShowCustomMessage.cfm?CustomMessage=' + escape(CustomMessage);
	
	// alert(' I am here') ;

	ColdFusion.navigate(targetCFM,'CustomErrorMessage') ;
	
	ColdFusion.Window.show('CustomErrorMessage') 

	return true; 
}

function pageInit() {
}

function submitForm(nextPage) {
  document.MainForm.in_page.value = nextPage;
  document.MainForm.submit();
}