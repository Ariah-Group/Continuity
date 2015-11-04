// Java script library for HowToSubmit module
// content:
// AddToDocumentList - Add new document to the list
// AddFileElementE - Remove old and add new type='file' element in IE
// AddFileElementF - Remove old and add new type='file' element in Firefox
//======================================================================================

function submitForm(saveType) {
   document.savePlanReview.saveType.value = saveType;
   document.savePlanReview.submit();
}

var myProxy= new howtosubmit ;
myProxy.setHTTPMethod('POST');


function UpdateReview(SaveType, ReviewCheck, ReviewerName, ReviewDate, ReviewBy) {

		if (SaveType == '1' || SaveType == '2') {
			if (ReviewCheck.checked) {
				var ApprovalFlag = '1' ;
			} else {
				var ApprovalFlag = '0' ;
				// clear fields
				// document.getElementById('ReviewerNameID').value = ''
				// document.getElementById('ReviewDateID').value = ''
				
			}
			
			for (Count = 0; Count < ReviewBy.length; Count++) {
       			 if (ReviewBy[Count].checked) {
					var ApproverType = Count + 1;
           		 	break;
				 }
    		}
			
			
			var result = myProxy.UpdateReview(ApprovalFlag,ReviewerName,ReviewDate,ApproverType) ;
			// validate result
			var TempLen = result[1].length ;
			if (TempLen > 0) {
				// store messages
				getElementsByClass('MessageStringClass')[0].value = result[1];
				//Show messages
				ColdFusion.navigate('../Include/ShowMessage.cfm?Type=1&MessageString=' + escape(result[1]),'MessageDIV', ClearHowToSubmitMessage) ;			
			} else {
				// success
				if (SaveType == '1') {
					//return back
					// ColdFusion.navigate('../Include/ShowMessage.cfm?Type=4&MessageString=!','MessageDIV') ;
					ColdFusion.navigate('../Include/ShowMessage.cfm?Type=3&MessageString=!','MessageDIV') ;
					setTimeout("ColdFusion.navigate('../Include/ShowMessage.cfm?Type=4','MessageDIV')",5000) ;

					return true ;
				}
				
				if (SaveType == '2') {
					// redurect
					location.href = "../UCB/mainforms.cfm" ;
					return false ;
				}

			}
			
		} else {
			
			return false
			
		}



}


function ClearHowToSubmitMessage(){
	// document.getElementById('MessageStringID').value = ''
	getElementsByClass('MessageStringClass')[0].value = ''
	// alert('I am here'); 
	return true; 
}


function ShowHideReview(){
	var CheckObj = getElementsByClass('ReviewCheckClass')[0] ;

	// alert(CheckObj.checked) ;
	
	
	
	if (CheckObj.checked) {
		// Show fields and text
		var CurEl = document.getElementById('Note1ID') ;
		CurEl.className = '' ;

		var CurEl = document.getElementById('LabelsID') ;
		CurEl.className = '' ;

		var CurEl = document.getElementById('DetailsID') ;
		CurEl.className = '' ;


		var CurEl = document.getElementById('Note2ID') ;
		CurEl.className = '' ;


	} else {
		// Hide fields and text
		var CurEl = document.getElementById('Note1ID') ;
		CurEl.className = 'HiddenControl' ;

		var CurEl = document.getElementById('LabelsID') ;
		CurEl.className = 'HiddenControl' ;
		
		var CurEl = document.getElementById('DetailsID') ;
		CurEl.className = 'HiddenControl' ;

		var CurEl = document.getElementById('Note2ID') ;
		CurEl.className = 'HiddenControl' ;

	}

}