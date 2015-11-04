// plan users / contacts table javascript

function AddUserRow(FirstName, LastName, EMail, Phone, IsContactTable, AccessList) {

	if (FirstName == null || FirstName == '' ||
		LastName == null || LastName == '' ||
		EMail == null || EMail == '') {
		alert("First Name, Last Name, and EMail are required fields.");
		return false;
	}
	
	if (!ValidateEmail(EMail)) {
		alert("Invalid EMail.")
		return false;
	}
	
	//create array from list
	var arrAccess = AccessList.split( "," );

	//verify if user already in the list
    var CurRow = window.parent.document.getElementById('PeopleInfoTableID').rows.length;
	var UniqueRow = 0;
	var myElement = '';
	var i = 0;
	
	// verify duplicate by directory ID
	for (i = 0; i <= CurRow; i++) {
		myElement = 'users['+i+'].emailRegular';
		if (document.getElementById(myElement)) {
			if ( document.getElementById(myElement).value == EMail) {
				alert('Selected user already has access to this plan') ;
				return false ;
			}
		// continue
		} else {
			UniqueRow = i;
		}
	}

	//add a row to the rows collection and get a reference to the newly added row
    var newRow = document.getElementById('PeopleInfoTableID').insertRow(-1);

	CurRow = UniqueRow ;
    
    //add cells to the new row and set the innerHTML to contain elements
	
	var cellNo = 0;
	var contactoruser = '';
	if (IsContactTable == 'true') {
		contactoruser = 'contact';
	} else {
		contactoruser = '';
	}
	
   // cells
	if (IsContactTable == 'true') {
		if (CurRow == 0) {
	        newRow.insertCell(cellNo++).innerHTML = 
	        	'<input type="radio" checked="yes" id="primaryContact['+CurRow+']" name="isPrimary" class="PrimaryCheckClass" value="true"/>' +
	    	    '<input type="hidden" id="users['+CurRow+'].isPrimary" name="users['+CurRow+'].isPrimary" value="true"/>';
		} else {
	        newRow.insertCell(cellNo++).innerHTML = 
	        	'<input type="radio" id="primaryContact['+CurRow+']" name="isPrimary" class="PrimaryCheckClass" value="false"/>' +
	    	    '<input type="hidden" id="users['+CurRow+'].isPrimary" name="users['+CurRow+'].isPrimary" value="false"/>';
		}
	}
		
    newRow.insertCell(cellNo++).innerHTML = '<input readonly="true" type="text" id="users['+CurRow+'].firstName" name="users['+CurRow+'].firstName" class="UserFirstNameClass ReadOnly" value="' + FirstName +  '"/>';
    newRow.insertCell(cellNo++).innerHTML = '<input readonly="true" type="text" id="users['+CurRow+'].lastName" name="users['+CurRow+'].lastName" class="UserLastNameClass ReadOnly" value="'  +  LastName + '"/>';
    newRow.insertCell(cellNo++).innerHTML = '<input readonly="true" type="text" id="users['+CurRow+'].emailRegular" name="users['+CurRow+'].emailRegular" class="UserEMailClass2  ReadOnly" value="' + EMail + '"/>';
    newRow.insertCell(cellNo++).innerHTML = '<input readonly="true" type="text" id="users['+CurRow+'].workPhone" name="users['+CurRow+'].workPhone" class="UserPhoneClass  ReadOnly" value="' + Phone + '"/>';
    
    if (IsContactTable == 'false') {
    	var TempStr = '<select name="users[' + CurRow +'].planAccessType.id" id="users[' + CurRow +'].planAccessType.id" class="UserAccessSelectClass">' ; 
    	for (i = 0; i < arrAccess.length; i= i + 2) {
    		TempStr = TempStr + '<OPTION VALUE="' + arrAccess[i] + '">' + arrAccess[i+1] + '</OPTION>' 
    	}
    	TempStr = TempStr + '</select>';
    	newRow.insertCell(cellNo++).innerHTML = TempStr;
    	newRow.insertCell(cellNo++).innerHTML = '<select name="users[' + CurRow +'].isGatekeeper" id="users[' + CurRow +'].isGatekeeper" class="UserGatekeeperSelectClass" onchange="EnableSelectAccess(document.getElementById(&#39;users['+CurRow+'].planAccessType.id&#39;), this)"><option value="false" selected="selected">No</option><option value="true">Yes</option></select>'
    }

    newRow.insertCell(cellNo++).innerHTML = '<span onmouseout="this.className=&#39;myLink&#39;" onmouseover="this.className=&#39;myLinkOver&#39;" class="myLink" title="delete ('+FirstName+' '+LastName+')" onclick="RemoveUserRow(document.getElementById(&#39;users['+CurRow+'].id&#39;), &#39;' + IsContactTable + '&#39;, &#39;' + CurRow + '&#39;);">delete '+contactoruser+'</span>';
    newRow.insertCell(cellNo++).innerHTML = '<input type="hidden" id="users['+CurRow+'].id" name="users['+CurRow+'].id"  class="RowIDClass" value="0"/>';
    document.getElementById('user.firstName').value = "";
    document.getElementById('user.lastName').value = "";
    document.getElementById('user.emailRegular').value = "";
    document.getElementById('user.workPhone').value = "";
}

function RemoveUserRow(src, IsContactTable, idx)   {
	if (IsContactTable == 'true') {
		
		if(!idx){
			if(document.getElementById('primaryContact['+ (src.parentNode.parentNode.rowIndex - 2) +']').checked){
				alert('You may not delete primary contact.  Please add another contact first and set them as primary') ;
				return false;
			}
		} else {	
			if (document.getElementById('primaryContact['+idx+']').checked) {
				alert('You may not delete primary contact.  Please add another contact first and set them as primary') ;
				return false;
			}
		}
	}
	if (confirm('Delete authorized plan user. Are you sure?'))  {
		var oRow = 0;  
		if (IsContactTable == 'true') {
			oRow = src.parentNode.parentNode.rowIndex-2;
		} else {
			oRow = src.parentNode.parentNode.rowIndex-1;
		}
		document.getElementById('PeopleInfoTableID').deleteRow(oRow);
		return true
	} else {
		return false
	}
}

function EnableSelectAccess(SelectAccessElement, GatekeeperElement) {
	gIdx = GatekeeperElement.options.selectedIndex;
	gValue = GatekeeperElement.options[gIdx].value;
	if (gValue == 'true') {
		SelectAccessElement.value = '2';
		SelectAccessElement.disabled = true;
	} else {
		SelectAccessElement.disabled = false;
	}
}

function CheckPrimary() {
    var CurRow = window.parent.document.getElementById('PeopleInfoTableID').rows.length;
    var hasPrimary = false;
    var firstRow = -1;
  	for (var i = CurRow; i >= 0; i--) {
		var elTemp = 'primaryContact['+i+']';
		var elPrim = 'users['+i+'].isPrimary';
		if (document.getElementById(elPrim)) {
			firstRow = i;
			document.getElementById(elPrim).value = false;
			if (document.getElementById(elTemp).checked) {
				hasPrimary = true;
				document.getElementById(elPrim).value = true;
			}
		}
	}
  	if (!hasPrimary & firstRow >= 0) {
		document.getElementById('users['+firstRow+'].isPrimary').value = true;
  	}
}

function UserSearch() {	
	//calculate proper position for window
	// var PosY = getElementsByClass(UserLastNameClass)[0].offsetTop + 20;
	// var PosX = getElementsByClass(UserLastNameClass)[0].offsetLeft ;
	
	// var targetCFM = '../Include/ShowContactSearch.cfm?InstitutionID=' + escape(InstitutionID)

	var targetCFM = '../Include/ShowUserSearch.cfm'
	ColdFusion.navigate(targetCFM,'PlanUsers') ;

	//show window
	ColdFusion.Window.show('PlanUsers') 

	
	return true; 
}

function DirectorySearch(Source,InstitutionSelectClass,UserFirstNameClass, UserLastNameClass) {
	alert(InstitutionSelectClass + " " + UserFirstNameClass + " " + UserLastNameClass);
	var InstitutionID = getElementsByClass(InstitutionSelectClass)[0].value ;
	var UserFirstName = trim(getElementsByClass(UserFirstNameClass)[0].value) ;
	var UserLastName = trim(getElementsByClass(UserLastNameClass)[0].value) ;

	// verify if valid search(InstitutionId not '0' and Name not empty)
	if (InstitutionID == '0' || (UserFirstName == '' &&  UserLastName == '')) {
		alert('Must enter either first or last name (partial names are OK).');
		return false;
	}
	
	document.ContactForm.submit();
//	var targetCFM = './getSystemDomainContacts?systemDomainId=' + escape(InstitutionID) + '&firstName=' + 
//	escape(UserFirstName) + '&lastName=' + escape(UserLastName) + '&Type=3&Source=' + escape(Source);
	
//	ColdFusion.navigate(targetCFM,'UserShowID') ;


	//alert(InstitutionID) ;
	
	
	return true; 
}

function ClearAddRemoveMessage(){
	// document.getElementById('MessageStringID').value = ''
	getElementsByClass('MessageStringClass')[0].value = ''
	// alert('I am here'); 
	
	if (getElementsByClass('ErrorDetailClass')[0]) {
		// nothing
	} else {
		setTimeout("ColdFusion.navigate('../Include/ShowMessage.cfm?Type=4','MessageDIV')",5000) ;
	}
	
	
	return true; 
}


function UpdateUsersOfPlan(Plan_Name) {
	if 	(confirm('Update plan users for (' + Plan_Name + '). Are you sure?'))  {
		// submit form
		ColdFusion.navigate('../actions/addremove_action.cfm','MessageDIV', ClearAddRemoveMessage, MyErrorHandler, 'POST', 'PlanUsers') ;
	} else {
		return false
	}
}

function ValidateEmail(str) {
	var at = "@"
	var dot = "."
	var lat = str.indexOf(at)
	var lstr = str.length
	var ldot = str.indexOf(dot)

	if (str.indexOf(at) == -1) {
		return false
	}

	if (str.indexOf(at) == -1 || str.indexOf(at) == 0
			|| str.indexOf(at) == lstr) {
		return false
	}

	if (str.indexOf(dot) == -1 || str.indexOf(dot) == 0
			|| str.indexOf(dot) == lstr) {
		return false
	}

	if (str.indexOf(at, (lat + 1)) != -1) {
		return false
	}

	if (str.substring(lat - 1, lat) == dot
			|| str.substring(lat + 1, lat + 2) == dot) {
		return false
	}

	if (str.indexOf(dot, (lat + 2)) == -1) {
		return false
	}

	if (str.indexOf(" ") != -1) {
		return false
	}

	return true
}
