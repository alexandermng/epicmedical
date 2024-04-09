package edu.asu.cse360s24;

import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PatientController extends RoutingController {
	String msgHistory;

	@FXML
	Label patientName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;

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
		if (patientName != null)
			patientName.setText(app.currentUser.firstName);
	}

	/**
	 * Append a message to file history
	 */
	private void appendMsg(String add) {
		// TODO get patient name from logged in Patient
		msgHistory += "-----------------\n" + "[doctor name here]" + ":\n" + add + "\n-----------------";
		messageArea.setText(msgHistory);
	}

	@FXML
	protected void sendMessage(ActionEvent evt) {
		System.out.println("Sending message: " + messageBox.getText());
		appendMsg(messageBox.getText());
		messageBox.clear();
	}

	@FXML
	protected void saveInfo(ActionEvent evt) {
		System.out.println("Saving Info");
	}

	@FXML
	protected void patientSignup(ActionEvent evt) {
		app.currentPatient.setInsuranceID(insuranceMemberID.getText());
		app.currentPatient.setInsuranceCompany(insuranceCompany.getText());
		app.currentPatient.setPharmacy(pharmacy.getText());
		app.db.addPatient(app.currentPatient.id, app.currentPatient);
		// TODO: if done by Nurse, then go to NursePortal
		goHomeLogin(evt);
	}

	@FXML
	protected void patientSignup2(ActionEvent evt) {
		String newID = Patient.generateID();
		app.currentPatient = new Patient(newID);
		app.currentPatient.setFirstName(firstName.getText());
		app.currentPatient.setLastName(lastName.getText());
		app.currentPatient.setUsername(username.getText());
		app.currentPatient.setPassword(password.getText());
		app.currentPatient.setPhoneNumber(phoneNum.getText());
		app.currentPatient.setDateOfBirth(birthdate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		goPatientSignup2(evt);
	}
}
