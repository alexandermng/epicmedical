
package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class NurseController extends AbstractController {
	String msgHistory;

	@FXML
	Label nurseName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;

	@FXML
	protected void initialize() {
		msgHistory = "";
		if (nurseName != null)
			nurseName.setText("NurseName from DB");
	}

	/**
	 * Append a message to file history
	 */
	private void appendMsg(String add) {
		// TODO get nurse name from logged in Nurse
		msgHistory += "-----------------\n" + "[nurse name here]" + ":\n" + add + "\n-----------------";
		messageArea.setText(msgHistory);
	}

	@FXML
	protected void sendMessage(ActionEvent evt) {
		System.out.println("Sending message: " + messageBox.getText());
		appendMsg(messageBox.getText());
		messageBox.clear();
	}

	@FXML
	protected void registerPatient(ActionEvent evt) {
		System.out.println("Registering Patient..."); // runs on submit NewVisit
		// TODO add to DB
		goNursePortal(evt);
	}

	/***** ROUTING *****/

	@FXML
	protected void goNursePortal(ActionEvent evt) {
		app.loadScene("NursePortal.fxml");
	}

	@FXML
	protected void goNurseMessages(ActionEvent evt) {
		app.loadScene("NurseMessaging.fxml");
	}

	@FXML
	protected void goNewVisit(ActionEvent evt) { // TODO logic upon deciding new visit, get from db
		app.loadScene("NewVisit.fxml");
	}

	@FXML
	protected void goHomeLogin(ActionEvent evt) {
		app.loadScene("Login.fxml");
	}

}
