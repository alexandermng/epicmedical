package edu.asu.cse360s24;

import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class PatientController extends RoutingController {

	@FXML
	Label patientName;

	@FXML
	Label patDoctor;
	@FXML
	Label patNurse;
	@FXML
	TextField patName;
	@FXML
	TextField patAddress;
	@FXML
	TextField patPhone;

	@FXML
	Label visitBody;
	@FXML
	ComboBox<Visit> visitHistory;

	@Override
	protected void init() {
		if (!(app.currentUser instanceof Patient))
			System.err.println("Something went terribly wrong!");
		Patient self = (Patient) app.currentUser;

		if (patientName != null)
			patientName.setText(app.currentUser.firstName + " " + app.currentUser.lastName);

		if (visitHistory != null) {
			Patient p = (Patient) app.currentUser;
			for (Visit v : p.visits) {
				visitHistory.getItems().add(v);
			}

			EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					visitBody.setText(visitHistory.getValue().visitBody());
				}
			};

			visitHistory.setOnAction(event);
		}

		if (patDoctor != null)
			patDoctor.setText(self.doctor.firstName + " " + self.doctor.lastName);

		if (patNurse != null)
			patNurse.setText(self.nurse.firstName + " " + self.nurse.lastName);

		if (patName != null) {
			patName.setText(self.firstName);
			patAddress.setText(self.pharmacy);
			patPhone.setText(self.phoneNumber);
		}
	}

	@FXML
	protected void saveInfo(ActionEvent evt) {
		Patient self = (Patient) app.currentUser;
		self.firstName = patName.getText();
		self.pharmacy = patAddress.getText();
		self.phoneNumber = patPhone.getText();
		System.out.println("Saving Info");
		goPatientPortal(evt);
	}

	@FXML
	protected void patientLogout(ActionEvent evt) {
		app.currentUser = null;
		goHomeLogin(evt);
	}
}
