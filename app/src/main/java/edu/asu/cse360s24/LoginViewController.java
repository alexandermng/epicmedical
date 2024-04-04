package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginViewController extends AbstractController {

	@FXML
	TextField usernameTxt;

	@FXML
	PasswordField passwordTxt;

	@FXML
	protected void submitLogin(ActionEvent evt) {
		System.out.println("Logging in!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		// TODO
	}

	@FXML
	protected void doctorLogin(ActionEvent evt) {
		app.loadScene("DoctorLogin.fxml");
	}

	@FXML
	protected void nurseLogin(ActionEvent evt) {
		app.loadScene("NurseLogin.fxml");
	}

	@FXML
	protected void patientLogin(ActionEvent evt) {
		System.out.println("Switching to Patient Login!");
		// app.loadScene("PatientLogin.fxml");
	}

	@FXML
	protected void homeLogin(ActionEvent evt) {
		app.loadScene("Login.fxml");
	}
}
