package edu.asu.cse360s24;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primary;

	@Override
	public void start(Stage stage) throws Exception {
		this.primary = stage;
		// VBox root = new VBox();

		stage.setTitle("EPIC MEDICAL");
		loadScene("Login.fxml");
		stage.show();
	}

	public void loadScene(String fxml) {
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
		primary.setScene(new Scene(root, 540, 360));

	}

	public static void main(String[] args) {
		System.out.println("Yo");
		launch(args);
	}
}
