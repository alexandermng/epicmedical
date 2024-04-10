module edu.asu.cse360s24 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;

	opens edu.asu.cse360s24 to javafx.graphics, javafx.fxml;
}
