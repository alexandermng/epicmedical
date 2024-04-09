package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class DoctorController extends AbstractController {
	String msgHistory;

	@FXML
	Label docName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;

	@FXML
	protected void initialize() {
		msgHistory = "";
		if (docName != null)
			docName.setText("DoctorName from DB");
	}

	/**
	 * Append a message to file history
	 */
	private void appendMsg(String add) {
		// TODO get doc name from logged in Doctor
		msgHistory += "-----------------\n" + "[doctor name here]" + ":\n" + add + "\n-----------------";
		messageArea.setText(msgHistory);
	}

	@FXML
	protected void sendMessage(ActionEvent evt) {
		System.out.println("Sending message:" + messageBox.getText());
		appendMsg(messageBox.getText());
		messageBox.clear();
	}

	@FXML
	protected void sendPrescription(ActionEvent evt) {
		System.out.println("Sending prescription!"); // TODO prescribe... what's expected behavior here?
	}

	@FXML
	protected void endVisit(ActionEvent evt) {
		System.out.println("Ending visit!"); // runs on submit ContinueVisit
		// TODO add to db
		goDoctorPortal(evt);
	}

	/***** ROUTING *****/

	@FXML
	protected void goDoctorPortal(ActionEvent evt) {
		app.loadScene("DoctorPortal.fxml");
	}

	@FXML
	protected void goDoctorMessages(ActionEvent evt) {
		app.loadScene("DoctorMessaging.fxml");
	}

	@FXML
	protected void goNewVisit(ActionEvent evt) { // TODO logic upon deciding new or continue visit
		app.loadScene("NewVisit.fxml");
	}

	@FXML
	protected void goContVisit(ActionEvent evt) {
		app.loadScene("ContinueVisit.fxml");
	}

	@FXML
	protected void goHomeLogin(ActionEvent evt) {
		app.loadScene("Login.fxml");
	}

}
