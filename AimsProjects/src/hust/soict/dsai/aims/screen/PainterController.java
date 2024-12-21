package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton pen;

    @FXML
    private RadioButton eraser;

    @FXML
    private ToggleGroup drawTools;

    private boolean isErasing = false;  // Flag to track if eraser is active

    @FXML
    void initialize() {
        // Set up listeners for radio button selection change
        drawTools.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == eraser) {
                isErasing = true;
            } else {
                isErasing = false;
            }
        });
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();  // Clear the drawing area
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (isErasing) {
            erase(event);
        } else {
            draw(event);
        }
    }

    private void draw(MouseEvent event) {
        // Draw with black circle (Pen)
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);
    }

    private void erase(MouseEvent event) {
        // Erase with white circle (Eraser)
        Circle newCircle = new Circle(event.getX(), event.getY(), 10, Color.WHITE);  // Larger radius for better erasing
        drawingAreaPane.getChildren().add(newCircle);
    }
}