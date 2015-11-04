function deleteDepartmentInfoListElement(elToDelete, elId) {
	var elName = "";
	if (elToDelete == 1) {
		elName = "Department Type";
		document.getElementById("deleteDepartmentTypeId").value = elId;
	} else {
		elName = "Building";
		document.getElementById("deleteBuildingId").value = elId;
	}	
		
	var msg = "Delete " + elName + ": Are You Sure?";
	if (!confirm(msg)) {
		return false;
	}
	
	document.getElementById("saveDepartmentInfo").submit();
	return true;
}