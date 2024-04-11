package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller for all Messaging. Assumes that if the current user is a Patient,
 * that they have an existing Doctor as their provider. If the current user is a
 * staff member (Doctor/Nurse), then we assume that there is a current patient
 * they are messaging.
 * 
 * @see Messaging.fxml
 */
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
		refreshMsg();
		if (app.currentUser instanceof Patient) {
			Patient p = (Patient) app.currentUser;
			sender.setText(p.getName());
			recipient.setText(p.doctor.getName());
		} else { // is staff with current
			sender.setText(app.currentUser.getName());
			recipient.setText(app.currentPatient.getName());
		}
	}

	private void refreshMsg() {
		String msgs = "";
		for (Message m : app.currentPatient.messages) {
			msgs += m.getFrom().firstName + " " + m.getFrom().lastName + "\n" + m.getMessage() + "\n";
		}
		messageArea.setText(msgs);
	}

	@FXML
	protected void sendMessage(ActionEvent evt) {
		System.out.println("Sending message:" + messageBox.getText());
		// appendMsg(messageBox.getText());

		Message m = new Message(app.currentUser, messageBox.getText());
		messageBox.setText("");
		app.currentPatient.messages.add(m);
		refreshMsg();

		messageBox.clear();
	}

	@FXML
	protected void callRecipient(ActionEvent evt) {
		System.out.println("Calling " + recipient.getText());
	}

	@FXML
	protected void returnToPortal(ActionEvent evt) {
		if (app.currentUser instanceof Patient)
			goPatientPortal(evt);
		else
			goStaffPortal(evt);
	}
}
