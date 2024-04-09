package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * A View Controller with the ability to Route to different pages and refer
 * back to application state.
 */
public abstract class RoutingController {
	protected Main app;

	public final void setApp(Main app) {
		this.app = app;
		init();
	}

	abstract protected void init();

	/***** ROUTES *****/
	// NOTE: Keep this updated with accessible pages, as new Views (.fxml) are
	// added.

	@FXML
	protected void goHomeLogin(ActionEvent evt) {
		app.loadScene("Login.fxml");
	}

	@FXML
	protected void goDoctorLogin(ActionEvent evt) {
		app.loadScene("DoctorLogin.fxml");
	}

	@FXML
	protected void goDoctorPortal(ActionEvent evt) {
		app.loadScene("DoctorPortal.fxml");
	}

	@FXML
	protected void goNurseLogin(ActionEvent evt) {
		app.loadScene("NurseLogin.fxml");
	}

	@FXML
	protected void goNursePortal(ActionEvent evt) {
		app.loadScene("NursePortal.fxml");
	}

	@FXML
	protected void goPatientLogin(ActionEvent evt) {
		app.loadScene("PatientLogin.fxml");
	}

	@FXML
	protected void goPatientPortal(ActionEvent evt) {
		app.loadScene("PatientPortal.fxml");
	}

	@FXML
	protected void goPatientSignup(ActionEvent evt) {
		app.loadScene("PatientSignup1.fxml");
	}

	@FXML
	protected void goPatientSignup2(ActionEvent evt) {
		app.loadScene("PatientSignup2.fxml");
	}

	@FXML
	protected void goNewVisit(ActionEvent evt) {
		app.loadScene("NewVisit.fxml");
	}

	@FXML
	protected void goContVisit(ActionEvent evt) {
		app.loadScene("ContinueVisit.fxml");
	}

	@FXML
	protected void goDoctorMessages(ActionEvent evt) {
		app.loadScene("DoctorMessaging.fxml");
	}

	@FXML
	protected void goNurseMessages(ActionEvent evt) {
		app.loadScene("NurseMessaging.fxml");
	}

	@FXML
	protected void goPatientMessages(ActionEvent evt) {
		app.loadScene("PatientMessaging.fxml");
	}
}
