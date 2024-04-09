package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController extends AbstractController {

	@FXML
	TextField usernameTxt;

	@FXML
	PasswordField passwordTxt;

	@FXML
	protected void patientLogin(ActionEvent evt) {
		// TODO log in. register logged in user with app before continuing to portal
		System.out.println("Logging in Patient!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		goPatientPortal(evt);
	}

	@FXML
	protected void nurseLogin(ActionEvent evt) {
		// TODO log in. register logged in user with app before continuing to portal
		System.out.println("Logging in Nurse!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		goNursePortal(evt);
	}

	@FXML
	protected void doctorLogin(ActionEvent evt) {
		// TODO log in. register logged in user with app before continuing to portal
		System.out.println("Logging in Doctor!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		goDoctorPortal(evt);
	}

	/***** ROUTING *****/

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
	protected void goHomeLogin(ActionEvent evt) {
		app.loadScene("Login.fxml");
	}

	// DELETE

	@FXML
	protected void saveInfo(ActionEvent evt) {
		System.out.println("Saving Info");
	}

	@FXML
	protected void goPatientMessages(ActionEvent evt) {
		app.loadScene("PatientMessaging.fxml");
	}

	@FXML
	protected void goPatientSignup(ActionEvent evt) {
		app.loadScene("PatientSignup1.fxml");
	}

	@FXML
	protected void goPatientSignup2(ActionEvent evt) {
		app.loadScene("PatientSignup2.fxml");
	}
}
