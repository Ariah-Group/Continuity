
// Java script library Accounts Control module
// content:
// AccountSearch - Account record search
// DeleteAccount - delete Account record
// InsertAccount - insert new Account record
// UpdateAccount - update Account record
// GetAccountSearchString1 - get Account search string 1
// GetAccountSearchString2 - get Account search string 2
// RestoreAccountSearchString - restore Account search string
// ClearAccountMessage - clear Account validation message
// FormatAccountgrid - formating Account grid
//======================================================================================


var myProxy= new Accounts ;
myProxy.setHTTPMethod('POST');

function SelectUser(AuthID,InstitutionName,FirstName,LastName,EMail,Phone,Fax, DepartmentName, DepartmentOrg, DepartmentOrgHierarchy, Title, InstitutionID, DirectoryID){

	setTimeout("ColdFusion.Window.hide('LDAPinfo')",300) ;

	getElementsByClass('UserIDClass')[0].value = '';
	getElementsByClass('AccountAuthIDClass')[0].value = AuthID;
	
	getElementsByClass('AccountFirstNameClass')[0].value = FirstName;
	getElementsByClass('AccountLastNameClass')[0].value = LastName;
	getElementsByClass('AccountTitleClass')[0].value = Title;

	getElementsByClass('AccountDepartmentNameClass')[0].value = DepartmentName;
	getElementsByClass('AccountDepartmentOrgClass')[0].value = DepartmentOrg;
	getElementsByClass('AccountDepartmentOrgHierarchyClass')[0].value = DepartmentOrgHierarchy;


	// getElementsByClass('AccountInstitutionClass')[0].value = InstitutionName;
	getElementsByClass('AccountInstitutionIDClass')[0].value = InstitutionID;
	
	getElementsByClass('AccountEMailClass')[0].value = EMail;
	getElementsByClass('AccountPhoneClass')[0].value = Phone;
	getElementsByClass('AccountWorkFaxClass')[0].value = Fax;
	
	getElementsByClass('AccountAccessSelectClass')[0].value = '1';
	getElementsByClass('AccountRoleSelectClass')[0].value = '';
	// getElementsByClass('LocationSelectClass')[0].value = '0';
	getElementsByClass('AccountPasswordClass')[0].value = '';
	getElementsByClass('AccountDirectoryIDClass')[0].value = DirectoryID;
	
	// alert(getElementsByClass('InstitutionIDClass')[0].value) ;
	
	// add FAX, Title, DepartmentName, DepartmentId

	//hide  window


	// ColdFusion.Window.hide('LDAPinfo')
	
	// alert(getElementsByClass('InstitutionIDClass')[0].value) ;

}


function AccountSearch(AccountGrid){
	// var s = ColdFusion.getElementValue('SearchString') ;
	getElementsByClass('SearchString1Class')[0].value = getElementsByClass('UserFirstNameClass')[0].value ;
	getElementsByClass('SearchString2Class')[0].value = getElementsByClass('UserLastNameClass')[0].value ; 
	getElementsByClass('SearchString3Class')[0].value = getElementsByClass('InstitutionSelectClass')[0].value ;
	ColdFusion.Grid.refresh(AccountGrid,true);
	// check if nothing found 

	//if  (getElementsByClass('SearchString1Class')[0].value != '' || getElementsByClass('SearchString2Class')[0].value != '') {
		// setTimeout("RestoreAccountSearchString()",300) ;
	//}



	return true; 
}


function LDAPSearch(InstitutionSelectClass,UserFirstNameClass, UserLastNameClass) {
	var InstitutionID = getElementsByClass(InstitutionSelectClass)[0].value ;
	var UserFirstName = getElementsByClass(UserFirstNameClass)[0].value ;
	var UserLastName = getElementsByClass(UserLastNameClass)[0].value ;
	
	// verify if valid search(InstitutionId not '0' and Name not empty)
	if (InstitutionID == '0' || (trim(UserFirstName + UserLastName) === '')) {
		alert('Must enter either first or last name (partial names are OK).');
		
		return false;
	}
	
	//calculate proper position for window
	// var PosY = getElementsByClass(UserLastNameClass)[0].offsetTop + 20;
	// var PosX = getElementsByClass(UserLastNameClass)[0].offsetLeft ;
	
	var targetCFM = '../Include/ShowLDAPSearch.cfm?InstitutionID=' + escape(InstitutionID) + '&UserFirstName=' + 
	escape(UserFirstName) + '&UserLastName=' + escape(UserLastName) + '&Type=1' ;

	ColdFusion.navigate(targetCFM,'LDAPinfo') ;

	//show window
	ColdFusion.Window.show('LDAPinfo') 

	// alert(InstitutionID) ;

	// var result = myProxy.DeleteAccount(UserID,IntegrityCheck,RequestorID) ;
	
	return true; 
}




function DeleteAccount(AccountGrid, UserID, UserFirstName, UserLastName, IntegrityCheck, RequestorID) {

	mygrid = ColdFusion.Grid.getGridObject(AccountGrid);
	sm = mygrid.getSelectionModel()
	sm.clearSelections(false);

	// alert(RequestorID) ;
	
	// Check UserID
	// alert(UserID) ;
	
	if (UserID === '') {
		var AlertName = '' ;
	} else {
		var AlertName = UserFirstName + ' ' + UserLastName;
	}
	if 	(confirm('Delete user Account (' + AlertName + '). Are you sure?'))  {
		// submit form
		var result = myProxy.DeleteAccount(UserID,IntegrityCheck,RequestorID) ;

		//verify if delete is success
		var TempLen = result[1].length ;
		if (TempLen > 0) {
			// store messages
			getElementsByClass('MessageStringClass')[0].value = result[1];
			//Show messages (this should be type 2 for warning that deletion will affect existing plans)
			ColdFusion.navigate('../Include/ShowMessage.cfm?Type=1&MessageString=' + escape(result[1]),'MessageDIV', ClearAccountMessage) ;
			
			ColdFusion.objectCache[AccountGrid].selectedRow=-1;

			return false ;

		} else {
			//Refresh grid
			
			ColdFusion.Grid.refresh(AccountGrid,true);
			
			//clear fields
			ClearForm ()
			
			ColdFusion.navigate('../Include/ShowMessage.cfm?Type=3&MessageString=!','MessageDIV') ;
			setTimeout("ColdFusion.navigate('../Include/ShowMessage.cfm?Type=4','MessageDIV')",5000) ;

			
			return true ;
		}



	} else {
		ColdFusion.objectCache[AccountGrid].selectedRow=-1;
		return false
	}
}

function InsertAccount(AccountGrid,InstitutionID, AuthID, FirstName, LastName, EMail, Phone, Fax, DepartmentName, DepartmentOrg, DepartmentOrgHierarchy, Title, Access, Role, Password, DirectoryID) {

	mygrid = ColdFusion.Grid.getGridObject(AccountGrid);
	sm = mygrid.getSelectionModel()
	sm.clearSelections(false);


	// alert(FirstName) ;
	// alert(InstitutionID) ;
	
	// alert(EMail) ;
	
	// alert(getElementsByClass('InstitutionIDClass')[0].value) ;
	
	if 	(confirm('Insert new user Account record. Are you sure?'))  {
		// submit form
		var result = myProxy.InsertAccount(InstitutionID, AuthID, FirstName, LastName, EMail,Phone, Fax, DepartmentName, DepartmentOrg, DepartmentOrgHierarchy, Title, Access, Role, Password, DirectoryID) ;
		// alert(result) ;
		
		//verify if insert is success
		var TempLen = result[1].length ;
		// alert (result) ;
		if (TempLen > 0) {
			// store messages
			getElementsByClass('MessageStringClass')[0].value = result[1];
			//Show messages
			ColdFusion.navigate('../Include/ShowMessage.cfm?Type=1&MessageString=' + escape(result[1]),'MessageDIV', ClearAccountMessage) ;
			ColdFusion.objectCache[AccountGrid].selectedRow=-1;

			return false ;

		} else {
			//Refresh grid
			ColdFusion.Grid.refresh(AccountGrid,true);
			

			//clear fields
			ClearForm ()

			ColdFusion.navigate('../Include/ShowMessage.cfm?Type=3&MessageString=!','MessageDIV') ;
			setTimeout("ColdFusion.navigate('../Include/ShowMessage.cfm?Type=4','MessageDIV')",5000) ;
			
			
			return true ;
		}

		
	} else {
		ColdFusion.objectCache[AccountGrid].selectedRow=-1;
		return false
	}
}


function UpdateAccount(AccountGrid, InstitutionID, UserID, AuthID, UserFirstName, UserLastName, EMail,Phone,Fax, DepartmentName, DepartmentOrg, DepartmentOrgHierarchy, Title, Access, Role, RequestorID, RequestorRole, Password, DirectoryID) {
	
	mygrid = ColdFusion.Grid.getGridObject(AccountGrid);
	sm = mygrid.getSelectionModel()
	sm.clearSelections(false);
	
	// alert(UserID) ;
	// alert(InstitutionID) ;

	
	// Check UserId
	if (UserID === '') {
		var AlertName = '' ;
	} else {
		var AlertName = UserFirstName + ' ' + UserLastName;
	}

	if 	(confirm('Update user account (' + AlertName + '): are you sure?'))  {
		
		var result = myProxy.UpdateAccount(InstitutionID, UserID, AuthID, UserFirstName, UserLastName, EMail,Phone, Fax, DepartmentName, DepartmentOrg, DepartmentOrgHierarchy, Title, Access, Role, RequestorID, RequestorRole,Password, DirectoryID) ;
		
		// alert('I am here') ;
		
		//verify if update is success
		var TempLen = result[1].length ;
		// alert (result) ;
		if (TempLen > 0) {
			// store messages
			getElementsByClass('MessageStringClass')[0].value = result[1];
			//Show messages
			ColdFusion.navigate('../Include/ShowMessage.cfm?Type=1&MessageString=' + escape(result[1]),'MessageDIV', ClearAccountMessage) ;
			// document.getElementById('MessageDIV').style.display = 'inline' ;
			ColdFusion.objectCache[AccountGrid].selectedRow=-1;

			return false ;

		} else {
			//Refresh grid
			
			ColdFusion.Grid.refresh(AccountGrid,true);
			ColdFusion.navigate('../Include/ShowMessage.cfm?Type=3&MessageString=!','MessageDIV') ;
			setTimeout("ColdFusion.navigate('../Include/ShowMessage.cfm?Type=4','MessageDIV')",5000) ;

			return true ;
		}
		
	} else {
		
		ColdFusion.objectCache[AccountGrid].selectedRow=-1;
		return false
	}
}

function GetAccountSearchString1(){
	// var s = ColdFusion.getElementValue('SearchString') ;
	var s = getElementsByClass('SearchString1Class')[0].value
	// alert(s); 
	return s; 
}


function GetAccountSearchString2(){
	// var s = ColdFusion.getElementValue('SearchString') ;
	var s = getElementsByClass('SearchString2Class')[0].value
	// alert(s); 
	return s; 
}


function GetAccountSearchString3(){
	// var s = ColdFusion.getElementValue('SearchString') ;
	var s = getElementsByClass('SearchString3Class')[0].value
//	alert(s); 
	return s; 
}




function GetUserID(){
	// var s = ColdFusion.getElementValue('SearchString') ;
	var s = getElementsByClass('UserIDClass')[0].value
	// alert(s); 
	return s; 
}



function CheckAuth(){
	var AuthObj = getElementsByClass('AuthSelectClass')[0] ;
	var CurAuth = AuthObj.options[AuthObj.selectedIndex].text ;
	
	var DirectoryAccessObj = getElementsByClass('DirectoryAccessSelectClass')[0] ;
	var CurDir = DirectoryAccessObj.options[DirectoryAccessObj.selectedIndex].text ;
	//alert(CurAuth);
	
	ClearForm() ;
	
	
	if (CurDir == 1) {
		// Show fields and text
		var CurEl = document.getElementById('DirSearch') ;
		CurEl.className = '' ;
		
		var CurEl = document.getElementById('DirID') ;
		CurEl.className = '' ;


	} else {
		// Hide fields and text
		var CurEl = document.getElementById('DirSearch') ;
		CurEl.className = 'HiddenControl' ;

		var CurEl = document.getElementById('DirID') ;
		CurEl.className = 'HiddenControl' ;

	}
	
	// alert(CurAuth) ;
	
	if (CurAuth == 1) {
		
		
		var CurEl = document.getElementById('NamePsw') ;
		CurEl.className = 'HiddenControl' ;
		
		
		//disable moust fields
		var CurEl = document.getElementById('AccountFirstNameID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountFirstNameClass ReadOnly' ;

		var CurEl = document.getElementById('AccountLastNameID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountLastNameClass ReadOnly' ;

		var CurEl = document.getElementById('AccountTitleID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountTitleClass ReadOnly' ;

		var CurEl = document.getElementById('AccountDepartmentNameID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountDepartmentNameClass ReadOnly' ;

		var CurEl = document.getElementById('AccountDepartmentNameID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountDepartmentNameClass ReadOnly' ;

		var CurEl = document.getElementById('AccountEMailID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountEMailClass ReadOnly' ;


		var CurEl = document.getElementById('AccountPhoneID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountPhoneClass ReadOnly' ;
		
		var CurEl = document.getElementById('AccountAuthIDID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountAuthIDClass ReadOnly' ;

		var CurEl = document.getElementById('AccountPasswordID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountPasswordClass ReadOnly' ;


		var CurEl = document.getElementById('AccountDirectoryIDID') ;
		CurEl.setAttribute('readOnly','readOnly');
		CurEl.className = 'AccountDirectoryIDClass ReadOnly' ;




	} else {
		
		var CurEl = document.getElementById('NamePsw') ;
		CurEl.className = '' ;

		
		
		// enable moust fields
		var CurEl = document.getElementById('AccountFirstNameID') ;
		CurEl.removeAttribute('readOnly'); 
		CurEl.className = 'AccountFirstNameClass' ;

		var CurEl = document.getElementById('AccountLastNameID') ;
		CurEl.removeAttribute('readOnly'); 
		CurEl.className = 'AccountLastNameClass' ;
		
		var CurEl = document.getElementById('AccountTitleID') ;
		CurEl.removeAttribute('readOnly'); 
		CurEl.className = 'AccountTitleClass' ;

		var CurEl = document.getElementById('AccountDepartmentNameID') ;
		CurEl.removeAttribute('readOnly'); 
		CurEl.className = 'AccountDepartmentNameClass' ;


		var CurEl = document.getElementById('AccountEMailID') ;
		CurEl.removeAttribute('readOnly'); 
		CurEl.className = 'AccountEMailClass' ;


		var CurEl = document.getElementById('AccountPhoneID') ;
		CurEl.removeAttribute('readOnly');
		CurEl.className = 'AccountPhoneClass' ;

		var CurEl = document.getElementById('AccountAuthIDID') ;
		CurEl.removeAttribute('readOnly');
		CurEl.className = 'AccountAuthIDClass' ;

		var CurEl = document.getElementById('AccountPasswordID') ;
		CurEl.removeAttribute('readOnly'); 
		CurEl.className = 'AccountPasswordClass' ;


		var CurEl = document.getElementById('AccountDirectoryIDID') ;
		CurEl.removeAttribute('readOnly');
		CurEl.className = 'AccountDirectoryIDClass' ;


	}
	
	return true; 
}


function ClearForm () {
	//clear fields
	getElementsByClass('UserIDClass')[0].value = '';
	getElementsByClass('AccountAuthIDClass')[0].value = '';
	
	getElementsByClass('AccountFirstNameClass')[0].value = '';
	getElementsByClass('AccountLastNameClass')[0].value = '';
	//getElementsByClass('AccountInstitutionClass')[0].value = '';
	
	getElementsByClass('AccountEMailClass')[0].value = '';
	getElementsByClass('AccountPhoneClass')[0].value = '';

	getElementsByClass('AccountAccessSelectClass')[0].value = '1';
	getElementsByClass('AccountRoleSelectClass')[0].value = '';
	
	getElementsByClass('AccountTitleClass')[0].value = '';
	getElementsByClass('AccountDepartmentNameClass')[0].value = '';
	
	getElementsByClass('AccountPasswordClass')[0].value = '';
	getElementsByClass('AccountDirectoryIDClass')[0].value = '';
	
	return true;	
}




function RestoreAccountSearchString(){
	// var s = ColdFusion.getElementValue('SearchString') ;
	getElementsByClass('UserFirstNameClass')[0].value = getElementsByClass('SearchString1Class')[0].value
	getElementsByClass('UserLastNameClass')[0].value = getElementsByClass('SearchString2Class')[0].value
	getElementsByClass('InstitutionSelectClass')[0].value = getElementsByClass('SearchString3Class')[0].value
	// alert(s); 
	return true; 
}



function ClearAccountMessage(){
	// document.getElementById('MessageStringID').value = ''
	getElementsByClass('MessageStringClass')[0].value = ''
	// alert('I am here'); 
	return true; 
}

function formatAccountgrid() {
	
	mygrid = ColdFusion.Grid.getGridObject('AccountGrid');

	var gridHead = mygrid.getView().getHeaderPanel(true);
	var headerobj = new Ext.Toolbar(gridHead);
	headerobj.add(new Ext.Toolbar.TextItem('<strong>Accounts</strong>' )); 

	ds = mygrid.getDataSource();

	cm = mygrid.getColumnModel();
	
	sm = mygrid.getSelectionModel();
	
	vm = mygrid.getView();
	// cm.setRenderer(3,myf);
	// cm.setRenderer(5,myf);

    // Get the Footer 
    var gridFoot = mygrid.getView().getFooterPanel(true);
    // Create a new Paging Toolbar 
    var paging = new Ext.PagingToolbar(gridFoot,ds,{
      pageSize:8, //number of records displayed in grid 
      displayInfo:true,
      displayMsg:'({2})',
      emptyMsg:"0 Rec"
   });
   
   // mygrid.addListener("rowclick",updateLocationSelect); 		// register custom event listener
   // grid.getDataSource().totalLength 
    
    // mygrid.trackMouseOver = false ;
   // mygrid.render()
   // reconfigure the grid 
   mygrid.reconfigure(ds,cm);
   
   
  
   for(var a in cm.config) {
	    if(a=='remove'){continue;}

	    cm.config[a].resizable = false ;  
  }
  
  
  
     var myWindow = ColdFusion.Window.getWindowObject('LDAPinfo');
  // myWindow.toolbox.remove();
//     myWindow.header.remove();
//     myWindow.setTitle('');
  
  
   // var  winEl = myWindow.getEl();


	// var PosY = getElementsByClass('UserFirstNameClass')[0].offsetTop + 21;
	// var PosX = getElementsByClass('UserFirstNameClass')[0].offsetLeft ;
	// var Parent = getElementsByClass('UserFirstNameClass')[0].offsetParent.id
	
	var PosY =  findPos(getElementsByClass('UserFirstNameClass')[0])[0] ; 
	var PosX =  findPos(getElementsByClass('UserFirstNameClass')[0])[1] ;
	
	// alert(PosY) ;
	// alert(PosX);
	// alert(Parent) ;
	// myWindow.x = PosX + 200 ;
	// myWindow.y = PosY ;
	

   //move the window up 5 pixels from it's current position    
   myWindow.moveTo(10,PosY - 5);


  
   // ds.setDefaultSort('NAME') ;
   // ColdFusion.Grid.refresh('AccountGrid',true);
   
   // row selection
   
   
  // ds.on('beforeload',function(){alert('beforeload loading the Data Store')}); 
   
  // ds.on('load',function(){alert('it just loaded the Data Store')});
  ColdFusion.Grid.refresh('AccountGrid',true);
 
}

// this is a grid listener to handle a rowclick - we examine the clicked row and manipulate control state accordingly
// the target control (the Location select) is also manipulated by other controls on the form through their onChange event

//function updateLocationSelect(grid,rowIndex,e) {
//   var record = grid.getDataSource().getAt(rowIndex);
//   document.AccountForm.LocationSelect.disabled = checkControlState(record.data.SECURITYTYPE);  
//   document.AccountForm.AccountPassword.value = '';
// }

//function checkControlState(controlValue){
 // processing the Role select 
//    if (controlValue == 1 || controlValue == 2)				// for local admin or universal viewer, do not disable the location select control
//      return false;
//    else 
//      return true;
//}