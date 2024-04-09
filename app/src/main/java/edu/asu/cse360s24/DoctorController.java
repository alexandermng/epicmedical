package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class DoctorController extends RoutingController {
	String msgHistory;

	@FXML
	Label docName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;
	@FXML
	GridPane patientGrid;
	@FXML
	Button newPatientButton;

	@Override
	protected void init() {
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
	protected void continueVisit(ActionEvent evt) {
		System.out.println("Continuing visit!"); // runs on start ContinueVisit
		// TODO: load visit info from DB?
		goContVisit(evt);
	}

	@FXML
	protected void endVisit(ActionEvent evt) {
		System.out.println("Ending visit!"); // runs on submit ContinueVisit
		// TODO add to db
		goDoctorPortal(evt);
	}
}
