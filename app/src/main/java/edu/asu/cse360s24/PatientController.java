package edu.asu.cse360s24;

import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PatientController extends RoutingController {
	String msgHistory;

	@FXML
	Label patientName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;

	@FXML
	TextField FirstName;
	@FXML
	TextField LastName;
	@FXML
	TextField Username;
	@FXML
	PasswordField Password;
	@FXML
	TextField PhoneNum;
	@FXML
	DatePicker Birthdate;

	@FXML
	TextField MemberID;
	@FXML
	TextField InsuranceCompany;
	@FXML
	TextField Pharmacy;

	String FirstName_entry;
	String LastName_entry;
	String Username_entry;
	String Password_entry;
	String PhoneNum_entry;
	String Birthdate_entry;

	@Override
	protected void init() {
		if (patientName != null)
			patientName.setText(app.currentPatient.firstName);
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
		System.out.println("Signed up patient!"); // runs at end of PatientSignup2
		app.currentPatient.setInsuranceID(MemberID.getText());
		app.currentPatient.setInsuranceCompany(InsuranceCompany.getText());
		app.currentPatient.setPharmacy(Pharmacy.getText());
		app.db.addPatient(app.currentPatient.id, app.currentPatient);
		goHomeLogin(evt);
	}

	@FXML
	protected void patientSignup2(ActionEvent evt) {
		String newID = Patient.generateID();
		app.currentPatient = new Patient(newID);
		app.currentPatient.setFirstName(FirstName.getText());
		app.currentPatient.setLastName(LastName.getText());
		app.currentPatient.setUsername(Username.getText());
		app.currentPatient.setPassword(Password.getText());
		app.currentPatient.setPhoneNumber(PhoneNum.getText());
		app.currentPatient.setDateOfBirth(Birthdate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		goPatientSignup2(evt);
	}
}
