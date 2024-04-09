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

	@Override
	public void start(Stage stage) throws Exception {
		this.primary = stage;
		this.db = new Database();

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
		primary.setScene(new Scene(root, 540, 400));
		
		// call updatePage() because initialize() can't access superclass
		// and therefore can't access the instance of Main
		RoutingController r = (RoutingController) loader.getController();
		r.updatePage();
	}
	
	public boolean checkPatientLogin(String username, String password) {
		HashMap<String, Patient> patientMap = db.getData().patients;
		if (patientMap == null) return false; // if no patients in db
		
		for (HashMap.Entry<String, Patient> entry : patientMap.entrySet()) {
			Patient temp = entry.getValue();
			if (temp.username.equals(username) && temp.password.equals(password)) {
				System.out.println("Login Successful");
				currentPatient = temp;
				return true;
			}
		}
		
		System.out.println("Incorrect username or password");
		return false;
	}
	
	public boolean checkEmployeeLogin(String username, String password) {
		// TODO: actually check lol
		return true;
	}
	
	

	public static void main(String[] args) {
		System.out.println("Yo");
		launch(args);
	}
}
