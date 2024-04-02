/**
 * 
 */
/**
 * 
 */
module epicmedical {
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	opens epicmedical to javafx.fxml;
	
	exports epicmedical;
}