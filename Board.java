public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] boardlist;
	private char lastSymbol;
	
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 * You may add private and public methods if you wish. In fact, to achieve
	 * what the assignment is asking, you'll have to
	 * 
	 */
	
	public Board() {
		boardlist = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
	}
	
	public void printBoard() {
		//Print the Board
		char z = ' ';
		for(int x = 0; x < NUM_OF_ROW; x++) {
			System.out.print("|");
			for (int y = 0; y < NUM_OF_COLUMNS; y++) {
				if (boardlist[x][y] != 0) z = boardlist[x][y];
				System.out.print(z + "|");
				z = ' ';
			}
			System.out.println("");
		}
	}
	
	public boolean containsWin() {
		//check horizontal win
		for(int x = 0; x < NUM_OF_ROW; x++) {
			for(int y = 0; y < NUM_OF_COLUMNS - 3; y++) {
				if(boardlist[x][y] != 0 && boardlist[x][y] == boardlist[x][y + 1] && boardlist[x][y] == boardlist[x][y + 2] && boardlist[x][y] == boardlist[x][y + 3]) return true;
			}
		}

		//check vertical win
		for(int z = 0; z < NUM_OF_COLUMNS; z++) {
			for(int c = 0; c < NUM_OF_ROW - 3; c++) {
				if(boardlist[c][z] != 0 && boardlist[c][z] == boardlist[c + 1][z] && boardlist[c][z] == boardlist[c + 2][z] && boardlist[c][z] == boardlist[c + 3][z]) return true;
			}
		}
		//check diagonal wins
		for(int a = 3; a < NUM_OF_ROW; a++) {
			for(int o = 0; o < NUM_OF_COLUMNS - 3; o++) {
				if(boardlist[a][o] != 0 && boardlist[a][o] == boardlist[a - 1][o + 1] && boardlist[a][o] == boardlist[a - 2][o + 2] && boardlist[a][o] == boardlist[a - 3][o + 3]) return true;
			}
		}

		for(int a = 3; a < NUM_OF_ROW; a++) {
			for(int o = 3; o < NUM_OF_COLUMNS; o++) {
				if(boardlist[a][o] != 0 && boardlist[a][o] == boardlist[a - 1][o - 1] && boardlist[a][o] == boardlist[a - 2][o - 2] && boardlist[a][o] == boardlist[a - 3][o - 3]) return true;
			}
		}

		return false;
	}
	
	public boolean isTie() {
		//check if tie
		for(int x = 0; x < NUM_OF_COLUMNS; x++) {
			if (boardlist[0][x] == 0) return false; 
		}
		return true;
	}
	
	public void reset() {
		//reset board
		this.boardlist = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
		lastSymbol = 0;
	}

	public boolean columnFull(int column) {
		//check if column full
		if(boardlist[0][column - 1] == 0) return false;
		else return true;
	}

	public void addSymbol(char symbol, int column) {
		//add symbol to board
		if (columnFull(column)) return;
		this.lastSymbol = symbol;
		int temp = 0;
		for(int x = 0; x<NUM_OF_ROW; x++) {
			if(boardlist[x][column - 1] == 0) {
				temp = x;
			}
			else break;
		}
		boardlist[temp][column - 1] = symbol;
	}

	public int getNumColumn() {
		return NUM_OF_COLUMNS;
	}

	public int getNumRow() {
		return NUM_OF_ROW;
	}

	public char getLastSymbol() {
		return lastSymbol;
	}

	public void removeSymbol(int column) {
		//remove symbol from board (only used in AI logic)
		for(int x = 0; x < NUM_OF_ROW; x++) {
			if(boardlist[x][column - 1] != 0) {
				boardlist[x][column - 1] = 0;
				return;
			}
		}
	}
	
}
