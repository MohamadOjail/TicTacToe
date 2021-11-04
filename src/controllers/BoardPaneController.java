package controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import game.tools.CheckWin;
import game.tools.Moves;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class BoardPaneController {
	
	private OpsPaneController opsPaneController;
	
	@FXML private AnchorPane boardPane;
	@FXML private GridPane xoGridPane;
	@FXML private Button xo1, xo2, xo3, xo4, xo5, xo6, xo7, xo8, xo9;
	private CheckWin checkWin = new CheckWin();
	private Moves move = new Moves();

	private Button[][] board = new Button[3][3];

	int moveCount = 0;

	@FXML void xo_Clicked(ActionEvent e) {

		Button btn = (Button) e.getSource();
		move.userMove(btn);
		disabler();
		moveCount++;

		boolean win = checkWin.check(board);
		if(win) opsPaneController.setIndicator(0);

		if (moveCount < 8 && !win) {
			move.computerMove(board);
			win = checkWin.check(board);
			if(win) opsPaneController.setIndicator(1);
			moveCount++;
			enabler();
		} else if (moveCount == 9) {
			// newGameBtn.setDisable(false);
			moveCount = 0;
		}
		if(win) {
			disabler();
			//TODO set indicators
		}
	}

	private void disabler() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].setDisable(true);
				board[i][j].setOpacity(1);
			}
		}
	}

	private void enabler() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (!board[i][j].getText().equalsIgnoreCase("x") && !board[i][j].getText().equalsIgnoreCase("o"))
					board[i][j].setDisable(false);
			}
		}
	}

	@FXML private void initialize() {
		ObservableList<Node> childrens = xoGridPane.getChildren();
		for (int i = 0, x = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++, x++) {
				board[i][j] = (Button) childrens.get(x);
			}
		}
	}

	@FXML public void initializeAll() {
		moveCount = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].getStyleClass().removeAll("btnX", "btnO");
				board[i][j].setText("");
				board[i][j].setDisable(false);
			}
		}
	}

	public void injectOpsPaneController(OpsPaneController opsPaneController) {
		this.opsPaneController = opsPaneController;
	}
}
