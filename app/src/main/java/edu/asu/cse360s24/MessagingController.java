package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MessagingController extends RoutingController {
	String msgHistory;

	@FXML
	Label sender;
	@FXML
	Label recipient;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;

	@Override
	protected void init() {
		msgHistory = "";
		// TODO base sender and recipient off of logged in user and current patient
	}

	/**
	 * Append a message to file history
	 */
	private void appendMsg(String add) {
		// TODO get sender from logged in user
		msgHistory += "-----------------\n" + "[doctor name here]" + ":\n" + add + "\n-----------------";
		messageArea.setText(msgHistory);
	}

	@FXML
	protected void sendMessage(ActionEvent evt) {
		System.out.println("Sending message:" + messageBox.getText());
		appendMsg(messageBox.getText());
		
		Message m = new Message(app.currentUser, messageBox.getText());
		messageBox.setText("");
		app.currentPatient.messages.add(m);
		
		messageBox.clear();
	}

	@FXML
	protected void callRecipient(ActionEvent evt) {
		System.out.println("Calling " + recipient.getText());
	}

	@FXML
	protected void returnToPortal(ActionEvent evt) {
		// TODO choose the right return
		if (app.currentUser instanceof Patient) {
			goPatientPortal(evt);
		} else {
			goStaffPortal(evt);
		}
	}
}
