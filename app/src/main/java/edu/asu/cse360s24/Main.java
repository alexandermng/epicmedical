package edu.asu.cse360s24;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primary;
	Database db;

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
		AbstractController cont = loader.getController();
		cont.setApp(this);
		primary.setScene(new Scene(root, 540, 400));
	}

	public static void main(String[] args) {
		System.out.println("Yo");
		launch(args);
	}
}
