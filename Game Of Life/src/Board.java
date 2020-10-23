public class Board {

	//ONLY SQUARE BOARDS
	private static int[][] board;
	private static int[][] updatingBoard;

	public static int[][] getBoard() {
		return board;
	}
	
	public static void setBoard(int dimensions) {
		board = new int[dimensions][dimensions];
		updatingBoard = new int[dimensions][dimensions];
	}

	public static void setPopulation(int[][] locations) {
		for (int ii = 0; ii < locations.length; ii++) {
			board[locations[ii][1]][locations[ii][0]] = 1;
		}
	}

	public static void printBoard() {
		for (int ii = 0; ii < board.length; ii++) {
			for (int jj = 0; jj < board[ii].length; jj++) {
				if (board[ii][jj] == 0) System.out.print("O");
				else System.out.printf("@");
			}
			System.out.println();
		}
	}

	public static void nextGeneration() {
		for (int ii = 0; ii < board.length; ii++) {
			for (int jj = 0; jj < board[ii].length; jj++) {
				updateBox(ii, jj);
			}
		}
		boardUpdate();
	}
	
	private static void boardUpdate() {
		for (int ii = 0; ii < board.length; ii++) {
			for (int jj = 0; jj < board[ii].length; jj++) {
				board[ii][jj] = updatingBoard[ii][jj];
			}
		}
	}

	private static void updateBox(int xLocation, int yLocation) {
		boolean boxLive = boxLive(xLocation, yLocation);
		if (boxLive) {
			if (liveNeighbors(xLocation, yLocation) == 2 || liveNeighbors(xLocation, yLocation) == 3) 
				updatingBoard[xLocation][yLocation] = 1;
			else 
				updatingBoard[xLocation][yLocation] = 0;
		} else if (!boxLive){
			if (liveNeighbors(xLocation, yLocation) == 3)
				updatingBoard[xLocation][yLocation] = 1;
		}
	}

	private static int liveNeighbors(int xLocation, int yLocation) {
		int liveNeighborsCount = 0;
		
// If box is upper most left corner
		if (xLocation == 0 && yLocation == 0) {
			if (board[xLocation + 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation + 1] == 1)
				liveNeighborsCount++;
			
// If box is upper most right corner
		} else if (xLocation == board.length - 1 && yLocation == 0) {
			if (board[xLocation - 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation + 1] == 1)
				liveNeighborsCount++;
			
// If box is bottom most right corner
		} else if (xLocation == board.length - 1 && yLocation == board.length - 1) {
			if (board[xLocation][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation] == 1)
				liveNeighborsCount++;
			
// If box is bottom most left corner
		} else if (xLocation == 0 && yLocation == board.length - 1) {
			if (board[xLocation][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation] == 1)
				liveNeighborsCount++;
			
// If box is leftmost side
		} else if (xLocation == 0) {
			if (board[xLocation][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation + 1] == 1)
				liveNeighborsCount++;
			
// If box is rightmost side
		} else if (xLocation == board.length - 1) {
			if (board[xLocation][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation + 1] == 1)
				liveNeighborsCount++;
			
// If box is top-most side
		} else if (yLocation == 0) {
			if (board[xLocation - 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation] == 1)
				liveNeighborsCount++;
			
// If box is bottom-most side
		} else if (yLocation == board.length - 1) {
			if (board[xLocation - 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation] == 1)
				liveNeighborsCount++;
			
// If box is not against a side
		} else {
			if (board[xLocation - 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation - 1][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation][yLocation + 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation - 1] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation] == 1)
				liveNeighborsCount++;
			if (board[xLocation + 1][yLocation + 1] == 1)
				liveNeighborsCount++;
		}
		return liveNeighborsCount;
	}
	
	private static boolean boxLive(int xLocation, int yLocation) {
		if (board[xLocation][yLocation] == 0)
			return false;
		else
			return true;
	}
}
