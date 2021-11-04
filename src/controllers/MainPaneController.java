package controllers;

import javafx.fxml.FXML;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class MainPaneController {
	
	@FXML private AnchorPane mainPane;
	@FXML private BoardPaneController boardPaneController;
	@FXML private OpsPaneController opsPaneController;

	// Event Listener on AnchorPane[#mainPane].onMouseDragged
	@FXML
	public void dragPane(MouseEvent event) {
		Stage stage = (Stage) mainPane.getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
	}

	// Event Listener on AnchorPane[#mainPane].onMousePressed
	double x = 0, y = 0;
	@FXML
	public void paneGetPos(MouseEvent event) {
		x = event.getSceneX();
        y = event.getSceneY();
	}
	
	@FXML private void initialize() {
		opsPaneController.injectBoardPaneController(boardPaneController);
		boardPaneController.injectOpsPaneController(opsPaneController);
	}
}
