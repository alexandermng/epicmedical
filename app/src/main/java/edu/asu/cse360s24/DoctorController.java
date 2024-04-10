package edu.asu.cse360s24;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class DoctorController extends RoutingController {
	String msgHistory;

	@FXML
	Label docName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;
	@FXML
	GridPane patientList;
	@FXML
	Button newPatientButton;
	
	@FXML
	TextField weight;
	@FXML
	TextField height;
	@FXML
	TextField bodyTemp;
	@FXML
	TextField bloodPressure;
	@FXML
	TextField allergies;
	@FXML
	TextField concerns;
	
	@FXML 
	TextField examNotes;
	@FXML
	TextField recommendations;
	@FXML
	TextField prescriptions;

	@Override
	protected void init() {
		msgHistory = "";
		if (docName != null) {
			docName.setText(app.currentUser.firstName + " " + app.currentUser.lastName);
		}

		// add patients to the list
		if (patientList != null) {
			int i = 0;
			for (HashMap.Entry<String, Patient> entry : app.db.getData().patients.entrySet()) {
				Patient temp = entry.getValue();
				i++;
				patientList.add(new Label(temp.firstName), 0, i);
				patientList.add(new Label(temp.lastName), 1, i);
				patientList.add(new Label(temp.dateOfBirth), 2, i);
				HBox h = new HBox();
				h.setSpacing(10.0);
							
				// TODO: link this to new messages
				Label msgNoti = new Label("  ");
				
				Button visitButton = new Button("Continue Visit");
				
				if (temp.activeVisit==null) {
					visitButton.setDisable(true);
				}
				
				EventHandler<ActionEvent> startVisitAction = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent evt) {
						app.currentPatient = temp;
						continueVisit(evt);
					}
				};
				visitButton.setOnAction(startVisitAction);
							
				Button messageButton = new Button("Send Message");
				EventHandler<ActionEvent> sendMessageAction = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent evt) {
						goDoctorMessages(evt);
					}
				};
				messageButton.setOnAction(sendMessageAction);
							
				h.getChildren().addAll(msgNoti, visitButton, messageButton);
				patientList.add(h, 3, i);
			}
		}
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
	protected void doctorLogout(ActionEvent evt) {
		app.currentUser = null;
		goHomeLogin(evt);
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
		
		Visit v = app.currentPatient.activeVisit;
		v.examNotes = examNotes.getText();
		v.recommendations = recommendations.getText();
		v.prescriptions = prescriptions.getText();
		v.doctor = (Doctor) app.currentUser;
		app.currentPatient.visits.add(v);
		app.currentPatient.activeVisit = null;

		goDoctorPortal(evt);
	}
}
