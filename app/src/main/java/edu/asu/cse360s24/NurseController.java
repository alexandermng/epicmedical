
package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class NurseController extends RoutingController {
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
	protected void startVisit(ActionEvent evt) {
		System.out.println("Start Visit..."); // runs on start NewVisit
		// TODO: store Visit info in app state
		goNewVisit(evt);
	}

	@FXML
	protected void finishVisit(ActionEvent evt) {
		System.out.println("Sending to Doctor..."); // runs on submit NewVisit
		// TODO add to DB
		goNursePortal(evt);
	}
}
