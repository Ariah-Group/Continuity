
// Java script library for create_new module
// content:
// ShowPlanContacts - Show Plan Contacts Info
// AddContactRow - add contact row
// RemoveContactRow - remove contact row
// ContactSearch - Search Contac Info
//======================================================================================


var myProxy= new create_new ;
myProxy.setHTTPMethod('POST');

  function AddContactRow(AuthID, UserID, FirstName, LastName, EMail, Phone, Fax, DepartmentName, DepartmentOrg, DepartmentOrgHierarchy, Title, DirectoryID)
    {

	//verify if contact already in the list
    var CurRow = document.getElementById('PeopleInfoTableID').rows.length;

	var UniqueRow = 0;

	 alert(CurRow);
	
	//Get Available Uniq Row No
	for (var i = 0; i <= CurRow; i++) {
		var myElement = 'DirectoryID' + i ;
		if (document.getElementById(myElement)) {
			// continue
		} else {
			var UniqueRow = i;
		}
	}

	if (UserID == '') {
		<!--- verify duplicate by directory ID --->
		for (var i = 0; i <= CurRow; i++) {
			var myElement = 'DirectoryID' + i ;
	
			if (document.getElementById(myElement) && document.getElementById(myElement).value == DirectoryID) {
				alert('Selected contact already associated with this plan') ;
				return false
			}
		}
	} else {
		<!--- verify duplicate by UserID --->
		for (var i = 0; i <= CurRow; i++) {
			var myElement = 'RowID' + i ;
			
			//if (document.getElementById(myElement)) {
				//alert(document.getElementById(myElement).value);
			//}
			
			if (document.getElementById(myElement) && document.getElementById(myElement).value == UserID) {
				alert('Selected contact already associated with this plan') ;
				return false
			}
		}
		
	}




	//add a row to the rows collection and get a reference to the newly added row
    var newRow = document.getElementById('PeopleInfoTableID').insertRow(-1);
 	// CurRow = document.getElementById('PeopleInfoTableID').rows.length - 1;
	CurRow = UniqueRow;
    
    //add cells to the new row and set the innerHTML to contain elements
   // Contact Primary if CurRow is 0
    var oCell = newRow.insertCell(0);
	if (CurRow == 0) {
    	oCell.innerHTML = '<input checked="yes" type="radio" id="PrimaryCheck' + CurRow + '" name="PrimaryCheck"  class="PrimaryCheckClass" value="' +  CurRow + '">';
	} else {
		oCell.innerHTML = '<input type="radio" id="PrimaryCheck' + CurRow + '" name="PrimaryCheck"  class="PrimaryCheckClass" value="' +  CurRow + '">';

	}
   // Contact Name
    var oCell = newRow.insertCell(1);
    oCell.innerHTML = '<input readonly="true" type="text" name="UserFirstName' + CurRow +'"   class="ContactUserFirstNameClass ReadOnly" value="' + FirstName +  '">';

    var oCell = newRow.insertCell(2);
    oCell.innerHTML = '<input readonly="true" type="text" name="UserLastName' + CurRow +'"  class="ContactUserLastNameClass ReadOnly" value="'  +  LastName + '">';

	// Contact EMail
    var oCell = newRow.insertCell(3);
    oCell.innerHTML = '<input readonly="true" type="text" name="Email' + CurRow +'"  class="ContactEMailClass  ReadOnly" value="' + EMail + '">';

   // Contact Phone
    var oCell = newRow.insertCell(4);
    oCell.innerHTML = '<input readonly="true" type="text" name="Phone' + CurRow +'"  class="ContactPhoneClass  ReadOnly" value="' + Phone + '">';

   // Row ID cell
    var oCell = newRow.insertCell(5);
    oCell.innerHTML = '<input  type="hidden" id="RowID' + CurRow + '" name="RowID' + CurRow +'"  class="RowIDClass" value="' + UserID + '">';

	// Delete Contact
    var oCell = newRow.insertCell(6);
    oCell.innerHTML = '<span onmouseout="this.className=&#39;myLink&#39;" onmouseover="this.className=&#39;myLinkOver&#39;" class="myLink" title="delete contact" onclick="RemoveContactRow(document.getElementById(&#39;RowID' + CurRow + '&#39;),document.getElementById(&#39;PrimaryCheck' + CurRow + '&#39;))">delete contact</span>';

   // Contact Department
    var oCell = newRow.insertCell(7);
    oCell.innerHTML = '<input type="hidden" name="ContactDepartment' + CurRow +'"  class="ContactDepartmentClass" value="' + DepartmentName + '">';
	
   // ContactTitle
    var oCell = newRow.insertCell(8);
    oCell.innerHTML = '<input type="hidden" name="ContactTitle' + CurRow +'"  class="ContactTitleClass" value="' + Title + '">';
	
   // Directory ID
    var oCell = newRow.insertCell(9);
    oCell.innerHTML = '<input type="hidden" id="DirectoryID' + CurRow +'"  name="DirectoryID' + CurRow + '" class="DirectoryIDClass" value="' + DirectoryID + '">';
	
   }
   
   //deletes the specified row from the table
   function RemoveContactRow(src, PrimaryCheck)
   {
    /* src refers to the input button that was clicked. 
       to get a reference to the containing <tr> element,
       get the parent of the parent (in this case <tr>)
    */ 
	
	
	if (PrimaryCheck.checked) {
		alert('You may not delete primary contact.  Please add another contact first and set them as primary') ;
		return false
	} else {
		
		// Confirmation on Delete
		if 	(confirm('Delete Plan Contact. Are you sure?'))  {
		
			var oRow = src.parentNode.parentNode.rowIndex-1;  
		
			//once the row reference is obtained, delete it passing in its rowIndex   
			document.getElementById('PeopleInfoTableID').deleteRow(oRow);
			return true
		} else {
			return false
		}
		
	}

   }


function ContactSearch(InstitutionID) {
	// alert(InstitutionID) ;
	
	// verify if valid search(InstitutionId not '0' )
	if (InstitutionID == '0') {
		alert('Institution required');
		
		return false;
	}
	
	day = new Date();
	id = day.getTime();
	window.showModalDialog("./searchSystemDomainContacts?systemDomainId="+InstitutionID,id,'dialogWidth:644; dialogHeight:174; help:off;scroll:off; status:off; center:on; resizable:off; unadorned:on;');

	//calculate proper position for window
	// var PosY = getElementsByClass(UserLastNameClass)[0].offsetTop + 20;
	// var PosX = getElementsByClass(UserLastNameClass)[0].offsetLeft ;
	
//	var targetCFM = '../Include/ShowContactSearch.cfm?InstitutionID=' + escape(InstitutionID)
//
//	ColdFusion.navigate(targetCFM,'PlanContacts') ;
//
//	//show window
//	ColdFusion.Window.show('PlanContacts') 

	// alert(InstitutionID) ;
	
	return true; 
}

function LDAPSearch(InstitutionSelectClass,UserFirstNameClass, UserLastNameClass) {
	var InstitutionID = getElementsByClass(InstitutionSelectClass)[0].value ;
	var UserFirstName = getElementsByClass(UserFirstNameClass)[0].value ;
	var UserLastName = getElementsByClass(UserLastNameClass)[0].value ;
	
	
	// alert('I am here');
	
	// verify if valid search(InstitutionId not '0' and Name not empty)
	if (InstitutionID == '0' ) {
		alert('Must enter either first or last name (partial names are OK).');
		
		return false;
	}
	
	//calculate proper position for window
	// var PosY = getElementsByClass(UserLastNameClass)[0].offsetTop + 20;
	// var PosX = getElementsByClass(UserLastNameClass)[0].offsetLeft ;
	
	var targetCFM = '../Include/ShowLDAPSearch.cfm?InstitutionID=' + escape(InstitutionID) + '&UserFirstName=' + 
	escape(UserFirstName) + '&UserLastName=' + escape(UserLastName) + '&Type=2';

	ColdFusion.navigate(targetCFM,'ContactShowID') ;

	//show window
	// ColdFusion.Window.show('LDAPinfo') 

	// alert(InstitutionID) ;
	
	
	
	
	// var result = myProxy.DeleteAccount(UserID,IntegrityCheck,RequestorID) ;
	
	return true; 
}



//function DirectorySearch(Source,InstitutionSelectClass,UserFirstNameClass, UserLastNameClass) {
//	var InstitutionID = getElementsByClass(InstitutionSelectClass)[0].value ;
//	var UserFirstName = trim(getElementsByClass(UserFirstNameClass)[0].value) ;
//	var UserLastName = trim(getElementsByClass(UserLastNameClass)[0].value) ;
//	
//	
//	// alert('I am here');
//	
//	// verify if valid search(InstitutionId not '0' and Name not empty)
//	if (InstitutionID == '0' || (UserFirstName == '' &&  UserLastName == '')) {
//		alert('Must enter either first or last name (partial names are OK).');
//		
//		return false;
//	}
//	
//	
//	var targetCFM = '../Include/ShowLDAPSearch.cfm?InstitutionID=' + escape(InstitutionID) + '&UserFirstName=' + 
//	escape(UserFirstName) + '&UserLastName=' + escape(UserLastName) + '&Type=2&Source=' + escape(Source);
//
//	ColdFusion.navigate(targetCFM,'ContactShowID') ;
//
//
//	//alert(InstitutionID) ;
//	
//	
//	return true; 
//}


function ClearCreateNewMessage(){
	// document.getElementById('MessageStringID').value = ''
	getElementsByClass('MessageStringClass')[0].value = ''
	// alert('I am here'); 
	return true; 
}


function SubmitPlan(IsNewPlan,UnitName,FormName) {

	var msg = "";
	if (IsNewPlan) {
		msg = 'Create new plan for (' + getElementsByClass(UnitName)[0].value + '). Are you sure?';
	} else {
		msg = 'Update plan (' + getElementsByClass(UnitName)[0].value + '). Are you sure?';
	}
	
	if 	(confirm(msg))  {
		// submit form
		document.getElementById(FormName).submit();
	} else {
		return false
	}
}








