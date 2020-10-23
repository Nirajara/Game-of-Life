
public class GameOfLife {

	private static int extraBoundary = 10;

	// Coordinates for live "boxes" with the top left corner being (0, 0)
	
	//Random Points
	// private static int[][] startPopulation = {
	// 		{8, 45}, {8, 46}, {8, 47}, {8, 48}, {8, 49},
	// 		{30, 20}, {30, 21}, {30, 22},
	// 		{33, 20}, {33, 21}, {33, 22}, {33, 23}, {33, 24}, {33, 25},
	// 		{ 49, 4 }, { 49, 3 }, { 49, 2 }, { 49, 1 }, { 49, 0 }, 
	// 		{ 45, 4 }, { 45, 3 }, { 45, 2 }, { 45, 1 }, { 45, 0 },
	// 		{ 0, 0 }, { 2, 0 }, { 1, 1 }, { 2, 1 }, { 1, 2 },
	// 		{15,30 }, {15,31 }, {15,32 }, {16,32 }, {17,31 },
	// 		{20,35}, {20,36 }, {20,37 }, {21,37 }, {22,36 },
	// 		{59,49}, {49,48 }, {49,47 }, {49,46 }, {49,45 },
	// 		{48,49}, {48,45 },
	// 		{47,49}, {47,48 }, {47,47 }, {47,46 }, {47,45 },
	// };
	
	//GOSPER GLIDER GUN POINTS
	private static int [][] startPopulation = {
		{8,20}, {9,20}, {8,21}, {9,21},
		{17,20}, {18,20}, {16,21}, {18,21}, {16,22}, {17,22},
		{24,22}, {24,23}, {24,24}, {25,22}, {26,23},
		{31,18}, {32,18}, {30,19}, {32,19}, {30,20}, {31,20},
		{32,30}, {33,30}, {34,30}, {32,31}, {33,32},
		{43,25}, {43,26}, {43,27}, {44,25}, {45,26},
		{42,18}, {43,18}, {42,19}, {43,19},
	};

	public static void main(String[] args) throws InterruptedException {

		Board gameOfLife = new Board();
		gameOfLife.setBoard(findMax(startPopulation) + extraBoundary);
		gameOfLife.setPopulation(startPopulation);
		GUI gui = new GUI();
		while (true) {
			gui.displayGUI(gameOfLife.getBoard());
			gameOfLife.nextGeneration();
			Thread.sleep(50);
		}
	}

	public static int findMax(int[][] arr) {
		
		int temp = 0;

		for (int ii = 0; ii < arr.length; ii++) {
			for (int jj = 0; jj <arr[ii].length; jj++) {
				if (arr[ii][jj] > temp) temp = arr[ii][jj];
			}
		}

		return temp;

	}

}
