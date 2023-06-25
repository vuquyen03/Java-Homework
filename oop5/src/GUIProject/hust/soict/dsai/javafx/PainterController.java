package GUIProject.hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.RadioButton;


public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton rbEraser;

    @FXML
    private RadioButton rbPen;

    private boolean isEraserMode = false;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        rbPen.setOnAction(e -> {
            isEraserMode = false;
        });
        rbEraser.setOnAction(e -> {
            isEraserMode = true;
        });

        Color color = isEraserMode ? Color.WHITE : Color.BLACK;
        Circle newCircle = new Circle(event.getX(), event.getY(),
                4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }
}
