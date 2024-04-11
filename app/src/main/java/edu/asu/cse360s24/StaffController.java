package edu.asu.cse360s24;

import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Staff portal for both Nurses and Doctors. Assumes currentUser is non-null.
 * 
 * @see StaffPortal.fxml
 */
public class StaffController extends RoutingController {

	@FXML
	Label staffName;
	@FXML
	TextArea messageArea;
	@FXML
	TextArea messageBox;
	@FXML
	GridPane patientList;
	@FXML
	Button newPatientButton;

	@Override
	protected void init() {
		staffName.setText(app.currentUser.firstName + " " + app.currentUser.lastName);

		if (app.currentUser instanceof Nurse)
			newPatientButton.setVisible(true);

		// add patients to the list
		if (patientList == null)
			System.err.println("Something went WRONG");

		int i = 0;
		for (HashMap.Entry<String, Patient> entry : app.db.getData().patients.entrySet()) {
			Patient temp = entry.getValue();
			i++;
			patientList.add(new Label(temp.firstName), 0, i);
			patientList.add(new Label(temp.lastName), 1, i);
			patientList.add(new Label(temp.dateOfBirth), 2, i);

			// TODO: link this to new messages
			Label msgNoti = new Label("  ");

			Button visitButton;
			if (temp.activeVisit == null) { // new visit
				visitButton = new Button("New Visit");
				visitButton.setOnAction(evt -> {
					app.currentPatient = temp;
					goNewVisit(evt);
				});

			} else { // visit in progress!
				visitButton = new Button("Continue Visit");
				if (!(app.currentUser instanceof Doctor))
					visitButton.setDisable(true);
				visitButton.setOnAction(evt -> {
					app.currentPatient = temp;
					goContVisit(evt);
				});
			}

			Button messageButton = new Button("Send Message");
			messageButton.setOnAction(e -> {
				app.currentPatient = temp;
				goMessaging(e);
			});

			HBox h = new HBox();
			h.setSpacing(10.0);
			h.getChildren().addAll(msgNoti, visitButton, messageButton);
			patientList.add(h, 3, i);
		}

	}

	@FXML
	protected void logout(ActionEvent evt) {
		app.currentUser = null;
		goHomeLogin(evt);
	}
}
