/**
 * 
 */
/**
 * 
 */
module TestjavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	
	opens hust.soict.dsai.screen to javafx.graphics, javafx.fxml;
}