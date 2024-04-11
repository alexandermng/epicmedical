package edu.asu.cse360s24;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller for ContinueVisit and NewVisit. Assumes a Doctor is logged in if
 * ContinueVisit is loaded; meanwhile NewVisit can be accessed by either.
 * 
 * @see ContinueVisit.fxml
 * @see NewVisit.fxml
 */
public class VisitController extends RoutingController {
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
	TextArea immunizations;

	@FXML
	TextArea examNotes;
	@FXML
	TextArea recommendations;
	@FXML
	TextField prescriptions;

	@FXML
	Label issuesLabel;
	@FXML
	Label pHistoryLabel;
	@FXML
	Label iHistoryLabel;

	@FXML
	Label patientName;

	@Override
	protected void init() {

		patientName.setText(app.currentPatient.firstName + " " + app.currentPatient.lastName);

		String issues = "";
		String pHistory = "";
		for (Visit i : app.currentPatient.visits) {
			issues += i.examNotes + "\n";
			pHistory += i.prescription + "\n";
		}

		issuesLabel.setText("Previous Health Issues:\n" + issues);
		pHistoryLabel.setText("Prescription History:\n" + pHistory);
		iHistoryLabel.setText("Immunization History:\n" + app.currentPatient.visits.getLast().immuneHistory);
	}

	@FXML
	protected void backToPortal(ActionEvent evt) {
		app.currentUser = null;
		goHomeLogin(evt);
	}

	@FXML
	protected void sendPrescription(ActionEvent evt) {
		System.out.println("Sending prescription!"); // TODO prescribe... what's expected behavior here?
	}

	@FXML
	protected void endNewVisit(ActionEvent evt) {
		System.out.println("Sending to Doctor..."); // runs on submit NewVisit

		Visit v = new Visit();
		v.weight = weight.getText();
		v.height = height.getText();
		v.bodyTemp = bodyTemp.getText();
		v.bloodPressure = bloodPressure.getText();
		v.allergies = allergies.getText();
		v.concerns = concerns.getText();
		v.immuneHistory = immunizations.getText();
		v.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		if (app.currentUser instanceof Nurse)
			v.nurse = (Nurse) app.currentUser;

		app.currentPatient.nurse = v.nurse;
		app.currentPatient.activeVisit = v;

		goStaffPortal(evt);
	}

	@FXML
	protected void endContVisit(ActionEvent evt) {
		System.out.println("Ending visit!"); // runs on submit ContinueVisit

		Visit v = app.currentPatient.activeVisit;
		v.examNotes = examNotes.getText();
		v.recommendations = recommendations.getText();
		v.prescription = prescriptions.getText();
		v.doctor = (Doctor) app.currentUser;

		app.currentPatient.doctor = v.doctor;
		app.currentPatient.visits.add(v);
		app.currentPatient.activeVisit = null;

		goStaffPortal(evt);
	}
}
