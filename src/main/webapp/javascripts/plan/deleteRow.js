function deleteFormRow(rowValue) {
	document.DeleteForm.dRowId.value = rowValue;
	document.DeleteForm.submit();
}

function deleteFormCFRow(cfRowValue, rowValue) {
	document.DeleteForm.dCFRowId.value = cfRowValue;
	deleteFormRow(rowValue);
}

function deleteFormINRow(inRowValue, rowValue) {
	document.DeleteForm.dINRowId.value = inRowValue;
	deleteFormRow(rowValue);
}

function deleteFormDocumentRow(rowValue, docTypeValue) {
	document.DeleteForm.dDocType.value = docTypeValue;
	deleteFormRow(rowValue);
}

function deleteFormCFDocumentRow(cfRowValue, rowValue, docTypeValue) {
	document.DeleteForm.dDocType.value = docTypeValue;
	deleteFormCFRow(cfRowValue, rowValue);
}
