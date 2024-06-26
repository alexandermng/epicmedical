package edu.asu.cse360s24;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController extends RoutingController {

	@FXML
	TextField usernameTxt;

	@FXML
	PasswordField passwordTxt;

	@Override
	protected void init() {

	}

	@FXML
	protected void patientLogin(ActionEvent evt) {
		// TODO log in. register logged in user with app before continuing to portal
		System.out.println("Logging in Patient!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		if (app.checkPatientLogin(usernameTxt.getText(), passwordTxt.getText())) {
			goPatientPortal(evt);
		}
	}

	@FXML
	protected void nurseLogin(ActionEvent evt) {
		// TODO log in. register logged in user with app before continuing to portal
		System.out.println("Logging in Nurse!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		if (app.checkNurseLogin(usernameTxt.getText(), passwordTxt.getText())) {
			goStaffPortal(evt);
		}
	}

	@FXML
	protected void doctorLogin(ActionEvent evt) {
		// TODO log in. register logged in user with app before continuing to portal
		System.out.println("Logging in Doctor!");
		System.out.println("\tUsername: " + usernameTxt.getText());
		System.out.println("\tPassword: " + passwordTxt.getText());
		if (app.checkDoctorLogin(usernameTxt.getText(), passwordTxt.getText())) {
			goStaffPortal(evt);
		}
	}
}
