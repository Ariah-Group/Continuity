function SubmitPlanUsers(PlanName, FormName) {
	if 	(confirm('Update plan users for (' + PlanName + '). Are you sure?'))  {
		document.getElementById(FormName).submit();
	} else {
		return false
	}
}