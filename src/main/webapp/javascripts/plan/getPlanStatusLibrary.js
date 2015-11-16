var onPlanStatusError = new YAHOO.util.CustomEvent("onPlanStatusError");

showPanel = function() {
	var panel = new YAHOO.widget.Panel("floatingpanel", {
	    draggable: true,
	    width: "400px",
	    height: "120px",
	    autofillheight: "body",
	    constraintoviewport:true,
	    context: ["markStatusBtn", "tl", "bl"]
	});
	panel.render();
	panel.show();
}

onPlanStatusError.subscribe(showPanel);

var PlanStatusAjaxObject = {
	
	handleSuccess:function(o){
	 
	 //newdiv is a dummy element for IE to host ajax returning text. 
	 //Then we append newdiv to DOM document. Then update hd and bd for message box.
	//Lastly, remove the dummy div. This is for IE fix.
	
	 var newdiv = document.createElement("newdiv");
	 newdiv.innerHTML = o.responseText;

	 var container = document.getElementById("StatusPod");
	 container.appendChild(newdiv);
	 
	 if (document.getElementById('planStatusError')) {
			document.getElementById('hd').innerHTML =
				"Message Center";
			document.getElementById('bd').innerHTML = 
				"<img src='/continuity/images/Info3.gif'/> " +
				document.getElementById('planStatusError').value;
			onPlanStatusError.fire();
	 }	
	 container.removeChild(newdiv);	
	},

	handleFailure:function(o){
		// Failure handler
	}

};

function setPlanStatus() {
    var cb = {
        success:PlanStatusAjaxObject.handleSuccess,
        failure:PlanStatusAjaxObject.handleFailure,
        scope: PlanStatusAjaxObject
    };
    startAjaxGetRequest('./savePlanStatus', cb);
	
}