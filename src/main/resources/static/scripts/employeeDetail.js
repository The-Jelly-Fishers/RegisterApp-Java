let hideEmployeeSavedAlertTimer = undefined;

document.addEventListener("DOMContentLoaded", () => {
	const employeeLookupCodeElement = getEmployeeLookupCodeElement();

	getEmployeeCountElement().addEventListener("keypress", EmployeeCountKeypress);
	employeeLookupCodeElement.addEventListener("keypress", EmployeeLookupCodeKeypress);
	
	getSaveActionElement().addEventListener("click", saveActionClick);
	getDeleteActionElement().addEventListener("click", deleteActionClick);

	if (!employeeLookupCodeElement.disabled) {
		employeeLookupCodeElement.focus();
		employeeLookupCodeElement.select();
	}
});

function employeeLookupCodeKeypress(event) {
	if (event.which !== 13) { // Enter key
		return;
	}

	const employeeCountElement = getEmployeeCountElement();
	employeeCountElement.focus();
	employeeCountElement.select();
}

function employeeCountKeypress(event) {
	if (event.which !== 13) { // Enter key
		return;
	}

	saveActionClick();
}

// Save
function saveActionClick(event) {
	if (!validateSave()) {
		return;
	}

	const saveActionElement = event.target;
	saveActionElement.disabled = true;

	const employeeId = getEmployeeId();
	const employeeIdIsDefined = ((EmployeeId != null) && (EmployeeId.trim() !== ""));
	const saveActionUrl = ("/api/employee/"
		+ (employeeIdIsDefined ? employeeId : ""));
	const saveEmployeeRequest = {
		id: employeeId,
		count: getEmployeeCount(),
		lookupCode: getEmployeeLookupCode()
	};

	if (employeeIdIsDefined) {
		ajaxPut(saveActionUrl, saveEmployeeRequest, (callbackResponse) => {
			saveActionElement.disabled = false;

			if (isSuccessResponse(callbackResponse)) {
				displayEmployeeSavedAlertModal();
			}
		});
	} else {
		ajaxPost(saveActionUrl, saveEmployeeRequest, (callbackResponse) => {
			saveActionElement.disabled = false;

			if (isSuccessResponse(callbackResponse)) {
				displayEmployeeSavedAlertModal();

				if ((callbackResponse.data != null)
					&& (callbackResponse.data.id != null)
					&& (callbackResponse.data.id.trim() !== "")) {

					document.getElementById("deleteActionContainer").classList.remove("hidden");

					setEmployeeId(callbackResponse.data.id.trim());
				}
			}
		});
	}
};

function validateSave() {
	const lookupCode = getEmployeeLookupCode();
	if ((lookupCode == null) || (lookupCode.trim() === "")) {
		displayError("Please provide a valid employee lookup code.");
		return false;
	}

	const count = getEmployeeCount();
	if ((count == null) || isNaN(count)) {
		displayError("Please provide a valid employee count.");
		return false;
	} else if (count < 0) {
		displayError("Employee count may not be negative.");
		return false;
	}

	return true;
}

function displayEmployeeSavedAlertModal() {
	if (hideEmployeeSavedAlertTimer) {
		clearTimeout(hideEmployeeSavedAlertTimer);
	}

	const savedAlertModalElement = getSavedAlertModalElement();
	savedAlertModalElement.style.display = "none";
	savedAlertModalElement.style.display = "block";

	hideEmployeeSavedAlertTimer = setTimeout(hideEmployeeSavedAlertModal, 1200);
}

function hideEmployeeSavedAlertModal() {
	if (hideEmployeeSavedAlertTimer) {
		clearTimeout(hideEmployeeSavedAlertTimer);
	}

	getSavedAlertModalElement().style.display = "none";
}
// End save

// Delete
function deleteActionClick(event) {
	const deleteActionElement = event.target;
	const deleteActionUrl = ("/api/employee/" + getEmployeetId());

	deleteActionElement.disabled = true;

	ajaxDelete(deleteActionUrl, (callbackResponse) => {
		deleteActionElement.disabled = false;

		if (isSuccessResponse(callbackResponse)) {
			window.location.replace("/");
		}
	});
};
// End delete

// Getters and setters
function getSaveActionElement() {
	return document.getElementById("saveButton");
}

function getSavedAlertModalElement() {
	return document.getElementById("employeeSavedAlertModal");
}

function getDeleteActionElement() {
	return document.getElementById("deleteButton");
}

function getEmployeeId() {
	return getEmployeeIdElement().value;
}
function setEmployeeId(EmployeeId) {
	getEmployeeIdElement().value = EmployeeId;
}
function getEmployeeIdElement() {
	return document.getElementById("EmployeeId");
}

function getEmployeeLookupCode() {
	return getEmployeeLookupCodeElement().value;
}
function getEmployeeLookupCodeElement() {
	return document.getElementById("EmployeeLookupCode");
}

function getEmployeeCount() {
	return Number(getEmployeeCountElement().value);
}
function getEmployeeCountElement() {
	return document.getElementById("EmployeeCount");
}
// End getters and setters
