package controllers;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TitlePaneController {
	@FXML
	private AnchorPane titlePane;
	@FXML
	private Button minimizeBtn;
	@FXML
	private Button quitBtn;

	// Event Listener on Button[#minimizeBtn].onAction
	@FXML
	public void minimize(ActionEvent event) {
		Stage stage = (Stage) titlePane.getScene().getWindow();
    	stage.setIconified(true);
	}
	
	// Event Listener on Button[#quitBtn].onAction
	@FXML
	public void quit(ActionEvent event) {
		Platform.exit();
	}
}
