
package edu.asu.cse360s24;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class NurseController extends RoutingController {
	String msgHistory;

	@FXML
	Label nurseName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;
	@FXML
	GridPane patientList;
	
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

	@Override
	protected void init() {
		msgHistory = "";
		if (nurseName != null)
			nurseName.setText(app.currentUser.firstName + " " + app.currentUser.lastName);
		
		// add patients to the list
		if (patientList != null) {
			int i = 0;
			for (HashMap.Entry<String, Patient> entry : app.db.getData().patients.entrySet()) {
				i++;
				Patient temp = entry.getValue();
				patientList.add(new Label(temp.firstName), 0, i);
				patientList.add(new Label(temp.lastName), 1, i);
				patientList.add(new Label(temp.dateOfBirth), 2, i);
				HBox h = new HBox();
				h.setSpacing(10.0);
				
				// TODO: link this to new messages
				Label msgNoti = new Label("  ");
				
				Button visitButton = new Button("New Visit");
				
				if (temp.activeVisit!=null) {
					visitButton.setDisable(true);
				}
				
				EventHandler<ActionEvent> startVisitAction = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent evt) {
						app.currentPatient = temp;
						startVisit(evt);
					}
				};
				visitButton.setOnAction(startVisitAction);
				
				Button messageButton = new Button("Send Message");
				EventHandler<ActionEvent> sendMessageAction = new EventHandler<ActionEvent>() {
					public void handle(ActionEvent evt) {
						goNurseMessages(evt);
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
		// TODO get nurse name from logged in Nurse
		msgHistory += "-----------------\n" + "[nurse name here]" + ":\n" + add + "\n-----------------";
		messageArea.setText(msgHistory);
	}
	
	@FXML
	protected void nurseLogout(ActionEvent evt) {
		app.currentUser = null;
		goHomeLogin(evt);
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
		
		Visit v = new Visit();
		v.weight = weight.getText();
		v.height = height.getText();
		v.bodyTemp = bodyTemp.getText();
		v.bloodPressure = bloodPressure.getText();
		v.allergies = allergies.getText();
		v.concerns = concerns.getText();
		v.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		v.nurse = (Nurse) app.currentUser;
		
		app.currentPatient.activeVisit = v;
		goNursePortal(evt);
	}
}
