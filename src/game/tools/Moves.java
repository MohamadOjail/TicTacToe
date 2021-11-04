package game.tools;

import java.util.Random;

import javafx.scene.control.Button;

public class Moves {
	
	public void userMove(Button btn) {
		btn.setText("X");
		btn.getStyleClass().add("btnX");
	}
	
	Random rnd = new Random();
	public void computerMove(Button[][] board) {
		int x = -1, y = -1;
		boolean valid;
		x = rnd.nextInt(3);
		y = rnd.nextInt(3);
		valid = (board[x][y].getText().equalsIgnoreCase("x") || 
				board[x][y].getText().equalsIgnoreCase("o")) ? false : true;
		while (!valid) {
			x = rnd.nextInt(3);
			y = rnd.nextInt(3);
			valid = (board[x][y].getText().equalsIgnoreCase("x") || 
					board[x][y].getText().equalsIgnoreCase("o")) ? false : true;
		}

		board[x][y].setText("O");
		board[x][y].getStyleClass().removeAll("btnX", "btnO");
		board[x][y].getStyleClass().add("btnO");
	}
}
