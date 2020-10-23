import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;

public class GUI {
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = (JPanel) frame.getContentPane();
	private static JLabel[] label;
	private static String[][] fancyBoard;

	
	public static void displayGUI(int[][] board) {
		panel.removeAll();
		setDimensionsForFancyBoard(board.length);
		boardTranslateIntoFanciness(board);
		setGUI();
		Dimension size;
		for (int ii = 0; ii < board.length; ii++) {
			label[ii].setText(message(ii));
			panel.add(label[ii]);
			size = label[ii].getPreferredSize();
			label[ii].setBounds(50, 25 + (ii * 10), board.length * 10, 16);
		}
	}
	
	private static void setDimensionsForFancyBoard(int dimension) {
		label = new JLabel[dimension];
		for (int ii = 0; ii < dimension; ii++) {
			label[ii] = new JLabel("");
		}
	}
	
	private static String message(int ii) {
		String message = "";
		for (int jj = 0; jj < fancyBoard.length; jj++) {
			message += fancyBoard[ii][jj];
		}
		return message;
	}
	
	private static void boardTranslateIntoFanciness(int[][] board) {
		
		fancyBoard = new String[board.length][board.length];
		
		for (int ii = 0; ii < board.length; ii++) {
			for (int jj = 0; jj < board[ii].length; jj++) {
				if (board[ii][jj] == 1) fancyBoard[ii][jj] = "|||";
				else fancyBoard[ii][jj] = "   ";
			}
		}
	}
	
	private static void setGUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize((fancyBoard.length * 10) + 100, (fancyBoard.length * 10) + 100);
		frame.setVisible(true);
	}
}
