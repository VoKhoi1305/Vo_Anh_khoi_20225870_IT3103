module GUI {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.desktop;
	
	opens hust.soict.dsai.javafx to javafx.graphics, javafx.fxml;
}
