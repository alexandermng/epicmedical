package edu.asu.cse360s24;

import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

	@FXML
	Label patDoctor;
	@FXML
	Label patNurse;
	@FXML
	TextField patName;
	@FXML
	TextField patAddress;
	@FXML
	TextField patPhone;

	@FXML
	Label docMsgName;
	@FXML
	Button callButton;
	
	@FXML
	Label visitBody;

	@FXML
	ComboBox<Visit> visitHistory;

	@Override
	protected void init() {
		Patient self = (Patient) app.currentUser;
		
		if (patientName != null)
			patientName.setText(app.currentUser.firstName + " " + app.currentUser.lastName);

		if (visitHistory != null) {
			Patient p = (Patient) app.currentUser;
			for (Visit v : p.visits) {
				visitHistory.getItems().add(v);
			}
			
			EventHandler<ActionEvent> event =
					new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e)
	            {
	                visitBody.setText(visitHistory.getValue().visitBody());
	            }
	        };
	        
	        visitHistory.setOnAction(event);
		}
		
		if (patDoctor != null)
			patDoctor.setText(self.doctor.firstName+" "+self.doctor.lastName);
		
		if (patNurse != null)
			patNurse.setText(self.nurse.firstName+" "+self.nurse.lastName);
		
		if (patName != null) {
			patName.setText(self.firstName);
			patAddress.setText(self.pharmacy);
			patPhone.setText(self.phoneNumber);
		}
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
		Patient self = (Patient) app.currentUser;
		self.firstName = patName.getText();
		self.pharmacy = patAddress.getText();
		self.phoneNumber = patPhone.getText();
		System.out.println("Saving Info");
		goPatientPortal(evt);
	}

	@FXML
	protected void patientLogout(ActionEvent evt) {
		app.currentUser = null;
		goHomeLogin(evt);
	}

	@FXML
	protected void patientSignup(ActionEvent evt) {
		app.currentPatient.setInsuranceID(insuranceMemberID.getText());
		app.currentPatient.setInsuranceCompany(insuranceCompany.getText());
		app.currentPatient.setPharmacy(pharmacy.getText());
		app.db.addPatient(app.currentPatient.id, app.currentPatient);
		// TODO: if done by Nurse, then go to NursePortal
		System.out.printf("Added patient [%s]:\n\tUsername: %s\n\tPassword: %s",
				app.currentPatient.id, app.currentPatient.username, app.currentPatient.password);
		goNursePortal(evt);
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
		app.currentPatient.setDateOfBirth(birthdate.getValue().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
		goPatientSignup2(evt);
	}
}
