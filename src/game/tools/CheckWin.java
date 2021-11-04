package game.tools;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class CheckWin {
	Alert alert = new Alert(AlertType.INFORMATION);
	int countX = 0, countO = 0;

	public boolean check(Button[][] board) {

		if (checkRows(board)) return true;
		if (checkDiagnal(board)) return true;
		if (checkColumns(board)) return true;
		return false;
	}

	private boolean checkColumns(Button[][] board) {

		for (int i = 0; i < board.length; i++) {

			countX = 0; countO = 0;

			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].getText().equalsIgnoreCase("x"))
					countX++;
				if (board[i][j].getText().equalsIgnoreCase("o"))
					countO++;

				if (countX == 3) {
					alert.setHeaderText("You Win!");
					alert.show();
					return true;
				}
				if (countO == 3) {
					alert.setHeaderText("Computer Wins!");
					alert.show();
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagnal(Button[][] board) {

		// If taken spot 5 and (1 and 9) or (3 and 7)
		if ((board[1][1].getText().equalsIgnoreCase("O")
				&& ((board[0][0].getText().equalsIgnoreCase("O") && board[2][2].getText().equalsIgnoreCase("O")) || (board[0][2].getText().equalsIgnoreCase("O") && board[2][0].getText().equalsIgnoreCase("O"))))) {
			alert.setHeaderText("Computer Wins!");
			alert.show();
			return true;
		} else if ((board[1][1].getText().equalsIgnoreCase("X")
				&& ((board[0][0].getText().equalsIgnoreCase("X") && board[2][2].getText().equalsIgnoreCase("X")) || (board[0][2].getText().equalsIgnoreCase("X") && board[2][0].getText().equalsIgnoreCase("X"))))) {
			alert.setHeaderText("You Win!");
			alert.show();
			return true;
		}

		return false;
	}

	private boolean checkRows(Button[][] board) {

		for (int i = 0; i < board.length; i++) {

			countX = 0; countO = 0;

			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i].getText().equalsIgnoreCase("x"))
					countX++;
				if (board[j][i].getText().equalsIgnoreCase("o"))
					countO++;

				if (countX == 3) {
					alert.setHeaderText("You Win!");
					alert.show();
					return true;
				}
				if (countO == 3) {
					alert.setHeaderText("Computer Wins!");
					alert.show();
					return true;
				}
			}
		}
		return false;
	}
}
