/**
 * 
 */
/**
 * 
 */
module AimsProjects {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.swing;
	requires javafx.base;
//	requires java.desktop;
	opens hust.soict.dsai.aims.screen to javafx.graphics, javafx.fxml;
	opens hust.soict.dsai.aims.media to javafx.base;
	//requires javafx.graphics;
}