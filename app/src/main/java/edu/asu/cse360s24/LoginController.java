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
	TextField messageText;

	@FXML
	protected void submitLogin(ActionEvent evt) {
		System.out.println("Logging in!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		// TODO
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
		// System.out.println("Switching to Patient Login!");
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
	protected void sendMessage(ActionEvent evt) {
		System.out.println("Sending message:" + messageText.getText());
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
	protected void goNurseMessages(ActionEvent evt) {
		app.loadScene("NurseMessaging.fxml");
	}

	@FXML
	protected void goContinueVisit(ActionEvent evt) {
		app.loadScene("ContinueVisit.fxml");
	}

	@FXML
	protected void goDoctorMessages(ActionEvent evt) {
		app.loadScene("DoctorMessaging.fxml");
	}

}
