package edu.asu.cse360s24;

import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PatientSignupController extends RoutingController {

	@FXML
	TextField firstName;
	@FXML
	TextField lastName;
	@FXML
	TextField username;
	@FXML
	PasswordField password;
	@FXML
	TextField phoneNum;
	@FXML
	DatePicker birthdate;

	@FXML
	TextField insuranceMemberID;
	@FXML
	TextField insuranceCompany;
	@FXML
	TextField pharmacy;

	@Override
	protected void init() {
	}

	@FXML
	protected void submitPatientSignup2(ActionEvent evt) {
		app.currentPatient.setInsuranceID(insuranceMemberID.getText());
		app.currentPatient.setInsuranceCompany(insuranceCompany.getText());
		app.currentPatient.setPharmacy(pharmacy.getText());
		app.db.addPatient(app.currentPatient.id, app.currentPatient);
		System.out.printf("Added patient [%s]:\n\tUsername: %s\n\tPassword: %s",
				app.currentPatient.id, app.currentPatient.username, app.currentPatient.password);
		if (app.currentUser == null)
			goHomeLogin(evt);
		else
			goStaffPortal(evt);
	}

	@FXML
	protected void submitPatientSignup1(ActionEvent evt) {
		String newID = Patient.generateID();
		app.currentPatient = new Patient(newID);
		app.currentPatient.firstName = firstName.getText();
		app.currentPatient.lastName = lastName.getText();
		app.currentPatient.username = username.getText();
		app.currentPatient.password = password.getText();
		app.currentPatient.setPhoneNumber(phoneNum.getText());
		app.currentPatient.setDateOfBirth(birthdate.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		goPatientSignup2(evt);
	}
}
