package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.layout.HBox;

import javafx.scene.layout.AnchorPane;

import javafx.scene.image.ImageView;

public class OpsPaneController {
	@FXML private AnchorPane opsPane;
	@FXML private HBox newGameBtnPane;
	@FXML private Button newGameBtn;
	@FXML private AnchorPane compIndicatorPane;
	@FXML private ImageView compIndicatorView;
	@FXML private AnchorPane userIndicatorPane;
	@FXML private ImageView userIndicatorView;
	private BoardPaneController boardPaneController;
	
	int userWins = 0, computerWins = 0;

    @FXML void newGameClicked(ActionEvent event) {
    	this.boardPaneController.initializeAll();
    }
    
    public void injectBoardPaneController(BoardPaneController boardPaneController) {
		this.boardPaneController = boardPaneController;
	}
    
    public void setIndicator(int id) {
		if(userWins == 3 || computerWins == 3) {
			userWins = 0; computerWins = 0;
		}
		
		if(id == 0) {
			setUserInd();
			userWins++;
		}
		
		if(id == 1) {
			setCompInd();
			computerWins++;
		}
	}

	private void setUserInd() {
		switch (userWins) {
		case 0 -> {
			userIndicatorView.getStyleClass().removeAll("imageViewerDefault","imageViewerwin1","imageViewerwin2","imageViewerwin3");
			userIndicatorView.getStyleClass().add("imageViewerwin1");
		}
		case 1 -> {
			userIndicatorView.getStyleClass().removeAll("imageViewerDefault","imageViewerwin1","imageViewerwin2","imageViewerwin3");
			userIndicatorView.getStyleClass().add("imageViewerwin2");
		}
		case 2 -> {
			userIndicatorView.getStyleClass().removeAll("imageViewerDefault","imageViewerwin1","imageViewerwin2","imageViewerwin3");
			userIndicatorView.getStyleClass().add("imageViewerwin3");
		}
		}
	}
	
	private void setCompInd() {
		switch (computerWins) {
		case 0 -> {
			compIndicatorView.getStyleClass().removeAll("imageViewerDefault","imageViewerwin1","imageViewerwin2","imageViewerwin3");
			compIndicatorView.getStyleClass().add("imageViewerwin1");
		}
		case 1 -> {
			compIndicatorView.getStyleClass().removeAll("imageViewerDefault","imageViewerwin1","imageViewerwin2","imageViewerwin3");
			compIndicatorView.getStyleClass().add("imageViewerwin2");
		}
		case 2 -> {
			compIndicatorView.getStyleClass().removeAll("imageViewerDefault","imageViewerwin1","imageViewerwin2","imageViewerwin3");
			compIndicatorView.getStyleClass().add("imageViewerwin3");
		}
		}
	}
}
