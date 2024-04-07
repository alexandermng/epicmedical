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
	TextField messageText;

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
	protected void doctorPortal(ActionEvent evt) {
		app.loadScene("DoctorPortal.fxml");
	}

	@FXML
	protected void nurseLogin(ActionEvent evt) {
		app.loadScene("NurseLogin.fxml");
	}
	
	@FXML
	protected void nursePortal(ActionEvent evt) {
		app.loadScene("NursePortal.fxml");
	}

	@FXML
	protected void patientLogin(ActionEvent evt) {
		//System.out.println("Switching to Patient Login!");
		app.loadScene("PatientLogin.fxml");
	}

	@FXML
	protected void homeLogin(ActionEvent evt) {
		app.loadScene("Login.fxml");
	}
	
	@FXML
	protected void patientPortal(ActionEvent evt) {
		app.loadScene("PatientPortal.fxml");
	}
	
	@FXML
	protected void saveInfo(ActionEvent evt) {
		System.out.println("Saving Info");
	}
	
	@FXML
	protected void patientMessages(ActionEvent evt) {
		app.loadScene("PatientMessaging.fxml");
	}
	
	@FXML
	protected void sendMessage(ActionEvent evt) {
		System.out.println("Sending message:" + messageText.getText());
	}
	
	@FXML
	protected void signup(ActionEvent evt) {
		app.loadScene("PatientSignup1.fxml");
	}
	
	@FXML
	protected void nextSignup(ActionEvent evt) {
		app.loadScene("PatientSignup2.fxml");
	}
	
	@FXML
	protected void newVisit(ActionEvent evt) {
		app.loadScene("NewVisit.fxml");
	}
	
	@FXML
	protected void nurseMessages(ActionEvent evt) {
		app.loadScene("NurseMessaging.fxml");
	}
	
	@FXML
	protected void contVisit(ActionEvent evt) {
		app.loadScene("ContinueVisit.fxml");
	}
	
	@FXML
	protected void doctorMessages(ActionEvent evt) {
		app.loadScene("DoctorMessaging.fxml");
	}
	
}
