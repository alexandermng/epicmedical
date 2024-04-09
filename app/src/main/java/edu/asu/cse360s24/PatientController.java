package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class PatientController extends AbstractController {
	String msgHistory;

	@FXML
	Label patientName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;

	@FXML
	protected void initialize() {
		if (patientName != null)
			patientName.setText("Patient Name from DB");
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
		goHomeLogin(evt);
	}

	/***** ROUTING *****/

	@FXML
	protected void goHomeLogin(ActionEvent evt) {
		app.loadScene("Login.fxml");
	}

	@FXML
	protected void goPatientPortal(ActionEvent evt) {
		app.loadScene("PatientPortal.fxml");
	}

	@FXML
	protected void goPatientMessages(ActionEvent evt) {
		app.loadScene("PatientMessaging.fxml");
	}

	@FXML
	protected void goPatientSignup(ActionEvent evt) {
		app.loadScene("PatientSignup1.fxml");
	}

	@FXML
	protected void goPatientSignup2(ActionEvent evt) {
		app.loadScene("PatientSignup2.fxml");
	}
}
