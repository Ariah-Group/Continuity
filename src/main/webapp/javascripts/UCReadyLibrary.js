// Declaring valid date character, minimum year and maximum year
var dtCh= "/";
var minYear=1800;
var maxYear=3000;

// implement indexOf for arrays
if (!Array.prototype.indexOf)
{
  Array.prototype.indexOf = function(elt /*, from*/)
  {
    var len = this.length;

    var from = Number(arguments[1]) || 0;
    from = (from < 0)
         ? Math.ceil(from)
         : Math.floor(from);
    if (from < 0)
      from += len;

    for (; from < len; from++)
    {
      if (from in this &&
          this[from] === elt)
        return from;
    }
    return -1;
  };
}

// Java script library
// content:
// MM_preloadImages - preload images in the current document
// MM_findObj - find object in specified document
// MM_swapImage - swap Image (onMouseOver event)
// MM_swapImgRestore - restore original image (onMouseOut event)
//======================================================================================

//get IE version
function getIEVersion() {
	var ua = navigator.userAgent
	var IEoffset = ua.indexOf('MSIE')
	var version = parseFloat(ua.substring(IEoffset+5, ua.indexOf(';',IEoffset)))

	return version
}	



 
// **************************************************************************************
// MM_swapImgRestore function
// ---------------------------------------------------
// Used to restore original image (onMouseOut event)
// parameters: none
// return: none
// example:  <a href="../home/Login.cfm" onMouseOut="MM_swapImgRestore()" 
// onMouseOver="MM_swapImage('Button1','','../image/Button1.gif',1)">
// <img name="Button1" border="0" src="../image/Button1.gif" width="25" height="18"></a>
// **************************************************************************************

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

// **************************************************************************************
// MM_preloadImages function
// ---------------------------------------------------
// Used to preload images used in the current document
// parameters: 'image1','image2','image3'...
// return: none
// example:  <body  onLoad="MM_preloadImages('../image/BetsBanner.gif', '../image/BetsLogo.gif')">
// **************************************************************************************

function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

// **************************************************************************************
// MM_findObj function
// ---------------------------------------------------
// Used to find and return object id
// parameters: 'object','document'
// return: Object Id
// example:  
// **************************************************************************************

function MM_findObj(n, d) { //v4.0
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && document.getElementById) x=document.getElementById(n); return x;
}


// **************************************************************************************
// MM_swapImage function
// ---------------------------------------------------
// Used to swap original image with alternate(onMouseOver event)
// parameters: 'image_object1','','swap_image1',1
// return: none
// example:  <a href="../home/Login.cfm" onMouseOut="MM_swapImgRestore()" 
// onMouseOver="MM_swapImage('Button1','','../image/Button1.gif',1)">
// <img name="Button1" border="0" src="../image/Button1.gif" width="25" height="18"></a>
// **************************************************************************************

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}


function getElementsByClass(searchClass,node,tag) {

        var classElements = new Array();
        if (node == null)
                node = document;
        if (tag == null)
                tag = '*';
        var els = node.getElementsByTagName(tag);
        var elsLen = els.length;
        var pattern = new RegExp("(^|\\s)"+searchClass+"(\\s|$)");
        var j = 0;
        for (i = 0; i < elsLen; i++) {
                if (pattern.test(els[i].className) ) {
                        classElements[j] = els[i];
                        j++;
                }
        }
        return classElements;
}


function selectDropDown(elementClass,selValue) { 
	
	// setTimeout("RestoreInstitutionSearchString()",300)
	// var myElement =  document.getElementById(elementID);
	
	var myElement =  getElementsByClass(elementClass)[0];

	for(var i = 0; i < myElement.length; i++){ 
        if(myElement.options[i].value == selValue){ 
           myElement.selectedIndex = i; 
         } 
     } 
 } 


function trim(stringToTrim) {
	return stringToTrim.replace(/^\s+|\s+$/g,"");
}
function ltrim(stringToTrim) {
	return stringToTrim.replace(/^\s+/,"");
}
function rtrim(stringToTrim) {
	return stringToTrim.replace(/\s+$/,"");
}



function findPos(obj) {
	var curleft = curtop = 0;
	if (obj.offsetParent) {
		curleft = obj.offsetLeft
		curtop = obj.offsetTop
		while (obj = obj.offsetParent) {
			curleft += obj.offsetLeft
			curtop += obj.offsetTop
		}
	}
	return [curleft,curtop];
}

function  MyErrorHandler(errorCode,errorMessage){
        alert("[In Error Handler]" + "\n\n" + "Error Code: " + errorCode + "\n\n" + "Error Message: " + errorMessage);
    } 


	// **************************************************************************************
	// Move all options from one list to another
	// ---------------------------------------------------
	// Used to emulate mover for selection list
	// parameters: SourceList, TargetList, FillerString
	// SourceList - object for source list
	// TargetList - object for target list
	// FullList - object for full list
	// FillerString - string to preserve visual layout for empty list
	// return: true
	// <SELECT class="Search" name="FirstList" size="10" 
	// ondblclick="MoveAll(sourceList,targetList,Filler)">
	// **************************************************************************************

	
	function MoveAll(SourceList,TargetList, FillerString) {
		// check source length
		var temp3 = SourceList.length-1 ;
		// set target list length
		var temp4 = TargetList.length ;
		TargetList.length = temp4 + temp3 + 1 ;
		for (var i = 0; i <= temp3; i++) {
			TargetList.options[temp4 + i] = new Option(SourceList.options[i].text,SourceList.options[i].value)
		
		}
		// set source list length
		SourceList.length = 0
		//SourceList.options[0] = new Option(FillerString,'')
		return true
	}




	// **************************************************************************************
	// Move selected option from one list to another
	// ---------------------------------------------------
	// Used to emulate mover for selection list
	// parameters: SourceList, TargetList, EmptyString
	// SourceList - object for source list
	// TargetList - object for target list
	// EmptyString - string to preserve visual layout for empty list
	// return: true
	// <SELECT class="Search" name="FirstList" size="10" 
	// ondblclick="MoveElement(sourceList,targetList,Filler)">
	// **************************************************************************************

	
	function MoveElement(SourceList,TargetList,EmptyString) {
		// check selected element on target
		// alert (SourceList.selectedIndex)
		var Temp = TargetList.length
		if  (SourceList.selectedIndex < 0) {
			return true }
		else {
			Temp = Temp + 1
			TargetList.length = Temp
			TargetList.options[Temp - 1] = new Option(SourceList.options[SourceList.selectedIndex].text,SourceList.options[SourceList.selectedIndex].value)
			//alert (SourceList.options[SourceList.selectedIndex].text)
			// remove option from source
			SourceList.options[SourceList.selectedIndex] = null
			if  (TargetList.selectedIndex >= 0) {
				TargetList.options[TargetList.selectedIndex] = null
			}
		}
		return true
	}
	
	// **************************************************************************************
	// Force navigation in the form when pressing Enter key
	// ---------------------------------------------------
	// Used to navigate in FORM to the next form element
	// parameters: field, event
	// field - form element where key pressed
	// event - event on the form element
	// Usage:
	// <input name="in_name" type="text" size="70" 
	// maxlength="128" onkeypress="return handleEnter(this, event)">
	// **************************************************************************************

	function handleEnter (field, event) {
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyCode == 13) {
			var i;
			for (i = 0; i < field.form.elements.length; i++)
				if (field == field.form.elements[i])
					break;
			i = (i + 1) % field.form.elements.length;
			field.form.elements[i].focus();
			return false;
		}
		return true;
	}      



	// **************************************************************************************
	// Force click event in the form when pressing Enter key
	// ---------------------------------------------------
	// Used to cick on the specified form element whe pressing enter key
	// parameters: field, event, clickfield
	// event - event on the form element
	// clickfield - form element where click applies
	// Usage:
	// <input name="in_name" type="text" size="70" 
	// maxlength="128" onkeypress="return clickOnEnter(event, this.form.Add_to_List)">
	// **************************************************************************************

	function clickOnEnter (event, clickfield) {
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyCode == 13) {
			// alert('I am here') ;
			clickfield.click();
			return false;
		} 
		return true;
	}      


	// **************************************************************************************
	// Removes all HTML child elements in Parent
	// ---------------------------------------------------
	// Used to clear all HTML child elements in specified parent
	// parameters: el - parent element
	// Usage:
	// <input name="in_name" type="text" size="70" 
	// maxlength="128" onkeypress="return clickOnEnter(event, this.form.Add_to_List)">
	// **************************************************************************************


	function cleanElement (el) {
    	while (el.firstChild) {
        // removing all child elements to clean it out
        el.removeChild(el.firstChild);
		}
	}


	function xtractFile(data){
		var m = data.match(/(.*)[\/\\]([^\/\\]+\.\w+)$/);
		return {path: m[1], file: m[2]}
    }



function correctPNG() // correctly handle PNG transparency in Win IE 5.5 & 6.
{
   var arVersion = navigator.appVersion.split("MSIE")
   var version = parseFloat(arVersion[1])
   if ((version >= 5.5) && (version < 7.0) && (document.body.filters)) 
   {
      for(var i=0; i<document.images.length; i++)
      {
         var img = document.images[i]
         var imgName = img.src.toUpperCase()
         if (imgName.substring(imgName.length-3, imgName.length) == "PNG")
         {
            var imgID = (img.id) ? "id='" + img.id + "' " : ""
            var imgClass = (img.className) ? "class='" + img.className + "' " : ""
            var imgTitle = (img.title) ? "title='" + img.title + "' " : "title='" + img.alt + "' "
            var imgStyle = "display:inline-block;" + img.style.cssText 
            if (img.align == "left") imgStyle = "float:left;" + imgStyle
            if (img.align == "right") imgStyle = "float:right;" + imgStyle
            if (img.parentElement.href) imgStyle = "cursor:hand;" + imgStyle
            var strNewHTML = "<span " + imgID + imgClass + imgTitle
            + " style=\"" + "width:" + img.width + "px; height:" + img.height + "px;" + imgStyle + ";"
            + "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader"
            + "(src=\'" + img.src + "\', sizingMethod='scale');\"></span>" 
            img.outerHTML = strNewHTML
            i = i-1
         }
      }
   }    
}



	// **************************************************************************************
	// Sorting Select list 
	// ---------------------------------------------------
	// Used to sort Select lists
	// parameters: 
	// 1. myList - list Id
	// 2. myOrder - ('A' ascending, 'D' - descending)
	// 3. myType - ('A' alpha, 'N' - numeric')
	// 4. myCase - ('N' - no case, 'Y' -  case)
	// Usage:
	// onclick="Sort:ist(myList,myOrder,myType,myCase)"
	// **************************************************************************************


	function SortList(myList,myOrder,myType,myCase) {
		
		// var lb = document.getElementById('myList');
		
		var lb = myList ;
		
		arrText1 = new Array();
		
		// alert(lb) ;

		// populating arrays
		// check if case insentitive
		if (myCase == 'N') {
			for(i=0; i<lb.length; i++)  {
			  arrText1[i] = lb.options[i].text.toUpperCase()+'~'+lb.options[i].value +'~'+lb.options[i].text;
			}
		} else {
			for(i=0; i<lb.length; i++)  {
			  arrText1[i] = lb.options[i].text+'~'+lb.options[i].value +'~'+lb.options[i].text;
			}
		}

		// sort array
		if (myOrder == 'N') {
			// numeric
			arrText1.sort(sortfunction(a, b));
		} else {
			arrText1.sort();
		}

		// check sort order
		if (myOrder == 'D') {
			arrText1.reverse() 
		}
		
		for(i=0; i<lb.length; i++)  {
			 el = arrText1[i].split('~'); 

			
  			lb.options[i].text = el[2];
			lb.options[i].value = el[1];
			
		}
	}

	// used for numeric array sorting
	function sortfunction(a, b){
		return (a - b) //causes an array to be sorted numerically and ascending
	}


	function ClearMessageDiv(){
		// var s = ColdFusion.getElementValue('SearchString') ;
		// alert('I am here') ;
		ColdFusion.navigate('../Include/ShowMessage.cfm?Type=4','MessageDIV')
		// alert(s); 
		return ''; 
	}


	function ClearActionStatus(ActionDiv) {
		// alert('I am here') ;
		var MyDiv = getElementsByClass(ActionDiv)[0] ;
		MyDiv.style.display = 'none'
		return true; 
	}
	
	
	function ShowLink(linkRef) {
		selectList = this.parent.document.activeElement;
		selectList.selectedIndex = 0;
		//check link
		
		// alert(linkRef) ;
		
		//Separate Target if exist
		var newArray = linkRef.split(',') ;
		
		// alert(newArray.length);
		
		if (newArray.length > 1) {
			//alert(newArray[1]);
			window.open(newArray[0],newArray[1]);
		} else {
			window.open(linkRef,'_self');
		}
		
	}
	
	
function isInteger(s){
	var i;
    for (i = 0; i < s.length; i++){   
        // Check that current character is number.
        var c = s.charAt(i);
        if (((c < "0") || (c > "9"))) return false;
    }
    // All characters are numbers.
    return true;
}

function stripCharsInBag(s, bag){
	var i;
    var returnString = "";
    // Search through string's characters one by one.
    // If character is not in bag, append to returnString.
    for (i = 0; i < s.length; i++){   
        var c = s.charAt(i);
        if (bag.indexOf(c) == -1) returnString += c;
    }
    return returnString;
}

function daysInFebruary (year){
	// February has 29 days in any year evenly divisible by four,
    // EXCEPT for centurial years which are not also divisible by 400.
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function DaysArray(n) {
	for (var i = 1; i <= n; i++) {
		this[i] = 31
		if (i==4 || i==6 || i==9 || i==11) {this[i] = 30}
		if (i==2) {this[i] = 29}
   } 
   return this
}

function isDate(dtStr){
	var daysInMonth = DaysArray(12)
	var pos1=dtStr.indexOf(dtCh)
	var pos2=dtStr.indexOf(dtCh,pos1+1)
	var strMonth=dtStr.substring(0,pos1)
	var strDay=dtStr.substring(pos1+1,pos2)
	var strYear=dtStr.substring(pos2+1)
	strYr=strYear
	if (strDay.charAt(0)=="0" && strDay.length>1) strDay=strDay.substring(1)
	if (strMonth.charAt(0)=="0" && strMonth.length>1) strMonth=strMonth.substring(1)
	for (var i = 1; i <= 3; i++) {
		if (strYr.charAt(0)=="0" && strYr.length>1) strYr=strYr.substring(1)
	}
	month=parseInt(strMonth)
	day=parseInt(strDay)
	year=parseInt(strYr)
	if (pos1==-1 || pos2==-1){
		// alert("The date format should be : mm/dd/yyyy")
		return false
	}
	if (strMonth.length<1 || month<1 || month>12){
		// alert("Please enter a valid month")
		return false
	}
	if (strDay.length<1 || day<1 || day>31 || (month==2 && day>daysInFebruary(year)) || day > daysInMonth[month]){
		alert("Please enter a valid day")
		return false
	}
	if (strYear.length != 4 || year==0 || year<minYear || year>maxYear){
		// alert("Please enter a valid 4 digit year between "+minYear+" and "+maxYear)
		return false
	}
	if (dtStr.indexOf(dtCh,pos2+1)!=-1 || isInteger(stripCharsInBag(dtStr, dtCh))==false){
		// alert("Please enter a valid date")
		return false
	}
return true
}
	
	
	