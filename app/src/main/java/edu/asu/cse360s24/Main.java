package edu.asu.cse360s24;

import java.io.IOException;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primary;
	Database db;
	Patient currentPatient;
	Person currentUser;

	@Override
	public void start(Stage stage) throws Exception {
		this.primary = stage;
		this.db = new Database();

		// TEMPORARY NURSE LOGIN
		Nurse n = new Nurse();
		n.firstName = "Test";
		n.lastName = "Nurse";
		n.username = "nurse";
		n.password = "";
		db.getData().nurses.put(n.username, n);

		// TEMPORARY NURSE LOGIN
		Doctor d = new Doctor();
		d.firstName = "Test";
		d.lastName = "Doctor";
		d.username = "doctor";
		d.password = "";
		db.getData().doctors.put(d.username, d);

		stage.setTitle("EPIC MEDICAL");
		loadScene("Login.fxml");
		stage.show();
	}

	@Override
	public void stop() {
		db.save(); // write out changes!
	}

	public void loadScene(String fxml) {
		System.out.println("Switching to " + fxml);
		FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
		Parent root;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		RoutingController cont = loader.getController();
		cont.setApp(this);
		primary.setScene(new Scene(root, 800, 600));
	}

	public boolean checkPatientLogin(String username, String password) {
		HashMap<String, Patient> patientMap = db.getData().patients;
		if (patientMap == null)
			return false; // if no patients in db

		for (HashMap.Entry<String, Patient> entry : patientMap.entrySet()) {
			Patient temp = entry.getValue();
			if (temp.username.equals(username) && temp.password.equals(password)) {
				System.out.println("Login Successful");
				currentPatient = temp;
				currentUser = temp;
				return true;
			}
		}

		System.out.println("Incorrect username or password");
		return false;
	}

	public boolean checkNurseLogin(String username, String password) {
		// TODO: actually check lol
		HashMap<String, Nurse> nurseMap = db.getData().nurses;
		if (nurseMap.containsKey(username)) {
			Nurse temp = nurseMap.get(username);
			if (temp.password.equals(password)) {
				currentUser = temp;
				return true;
			}
		}
		return false;
	}

	public boolean checkDoctorLogin(String username, String password) {
		HashMap<String, Doctor> doctorMap = db.getData().doctors;
		if (doctorMap.containsKey(username)) {
			Doctor temp = doctorMap.get(username);
			if (temp.password.equals(password)) {
				currentUser = temp; // TODO set currentPatient
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Yo");
		launch(args);
	}
}
