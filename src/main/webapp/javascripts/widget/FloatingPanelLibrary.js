function createFloatingPanel(w,h,els,et) {
	var panel = new YAHOO.widget.Panel("floatingpanel", {
		visible: false,
	    draggable: true,
	    fixedcenter: true,
	    width: w+"px",
	    height: h+"px",
	    autofillheight: "body",
	    constraintoviewport:true
	});
	panel.render();
	if (els != null) {
		YAHOO.util.Event.on(els, et, panel.show, panel, true);
	}
}


/*
 * AjaxObject is a hypothetical object that encapsulates the transaction
 *     request and callback logic.
 *
 * handleSuccess( ) provides success case logic
 * handleFailure( ) provides failure case logic
 * processResult( ) displays the results of the response from both the
 * success and failure handlers
 * call( ) calling this member starts the transaction request.
 */

var AjaxObject = {
	
	handleSuccess:function(o){
		if (o.argument == null) {
			document.getElementById('bd').innerHTML = o.responseText;
		} else {
			document.getElementById(o.argument).innerHTML = o.responseText;
		}
	},

	handleFailure:function(o){
		// Failure handler
	}
};

/*
 * Define the callback object for success and failure
 * handlers as well as object scope.
 */
var callback =
{
	success:AjaxObject.handleSuccess,
	failure:AjaxObject.handleFailure,
	scope: AjaxObject
};

function startAjaxGetRequest(url, customCallback) {
	if (customCallback == null) {
		customCallback = callback;
	}
	YAHOO.util.Connect.asyncRequest('GET', url, customCallback, null);
}