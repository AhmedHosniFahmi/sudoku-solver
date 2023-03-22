public class Solver {
	private static int boxesToCheck = 9;
	private static boolean rowCheck(int[][] board,int num,int row) {
		for (int i = 0; i <boxesToCheck; i++) {
			if(board[row][i]==num) {
				return true;
			}
		}
		return false;
	}

	private static boolean colCheck(int[][] board,int num,int col) {
		for (int i = 0; i < boxesToCheck; i++) {
			if(board[i][col]==num) {
				return true;
			}
		}
		return false;
	}

	private static boolean squareCheck(int[][] board,int num,int row,int col) {
		int rowBox = row - row%3;
		int colBox = col - col%3;
		for (int i = rowBox; i < rowBox+3; i++) {
			for (int j = colBox; j < colBox+3; j++) {
				if(board[i][j]==num) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean boxEmpty(int[][] board,int num,int row,int col) {
		return !rowCheck(board, num, row)&&!colCheck(board, num, col)&&!squareCheck(board, num, row, col);
	}
	private static boolean boardSolving(int[][]board) {
		for(int row = 0; row < boxesToCheck; row++) {
			for (int col = 0; col < boxesToCheck; col++) {
			if(board[row][col] == 0) {
				for (int numToTry = 1; numToTry <= boxesToCheck; numToTry++) {
					if(boxEmpty(board, numToTry, row, col)) {
						board[row][col] = numToTry;
						
						if(boardSolving(board)) {
							return true;
						}
						else {
							board[row][col]=0;
						}
							
					}
				 } 
				return false;
			   }
			}
		}
		return true;
	}
	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (i % 3 == 0 && i != 0) {
		        System.out.println("-------------------");
		      }
			for (int j = 0; j < board[i].length; j++) {
				if (j % 3 == 0 && j != 0) {
			          System.out.print("|");
			        }
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}

public static void main(String[] args) {
	int[][] board = {
			{1 ,0 ,0 ,0 ,5 ,0 ,8 ,0 ,0},
			{8 ,0 ,4 ,6 ,9 ,2 ,0 ,5 ,0},
			{0 ,0 ,0 ,0 ,0 ,3 ,0 ,2 ,0},
			{7 ,0 ,0 ,8 ,0 ,5 ,0 ,0 ,0},
			{0 ,0 ,8 ,0 ,6 ,7 ,0 ,1 ,4},
			{4 ,0 ,0 ,0 ,0 ,1 ,6 ,8 ,0},
			{0 ,4 ,0 ,5 ,0 ,0 ,0 ,0 ,0},
			{5 ,8 ,0 ,4 ,0 ,9 ,1 ,3 ,6},
			{0 ,6 ,0 ,2 ,0 ,8 ,0 ,0 ,5},
	};
	
	if(boardSolving(board)) {
		System.out.println("Solved successfully!");
	}
	else {
		System.out.println("Board can't be solved");
	}

	printBoard(board);
}
}
