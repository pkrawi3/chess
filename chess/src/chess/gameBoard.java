package chess;

//--------------------------------------------------------- 
// Class for Game Board map and logic over pieces on board
//---------------------------------------------------------
public class gameBoard {
	private gamePiece [][] board;
	protected int width;
	
	//--------------------------------------------------------- 
	// Constructor for game board
	//---------------------------------------------------------
	public gameBoard(int w) {
		width = w;
		board = new gamePiece [width][width];
	}
	
	//--------------------------------------------------------- 
	// Checks whether coordinates are on the board
	//---------------------------------------------------------
	public boolean isValidSpot(int x, int y){
		if(x < 0 || x > (width-1) || y < 0 || y > (width-1)) {
			return false;
		}
		else {			
			return true;
		}
	}
	
	//--------------------------------------------------------- 
	// Sets the location of a piece, for initialization of board
	//---------------------------------------------------------
	public boolean setPiece(int x, int y, gamePiece piece) {
		if(isValidSpot(x,y)) {
			board[x][y] = piece;
			return true;
		}
		else {
			return false;
		}
	}
	
	//--------------------------------------------------------- 
	// Returns piece on the position of the board
	//---------------------------------------------------------
	public gamePiece getSpot(int x, int y) {
		if(isValidSpot(x,y)) {
			return board[x][y];
		}
		else {
			return null;
		}
	}
	
	//--------------------------------------------------------- 
	// Moves piece on the board, attacking included
	//---------------------------------------------------------
	public boolean changeSpot(int xi, int yi, int xf, int yf, Player player) {
		if(isValidSpot(xi, yi) && isValidSpot(xf, yf)) {
			// Move piece
			if(board[xi][yi] != null && board[xf][yf] == null) {
				// Try object-specific movement
				if((board[xi][yi]).movePiece(xi, yi, xf, yf, this)) {
					board[xf][yf] = board[xi][yi];
					board[xi][yi] = null;
					return true;					
				}				
			}
			// Attack piece
			if(board[xi][yi] != null && board[xf][yf] != null && board[xf][yf].isWhite() != player.isWhite()) {
				if((board[xi][yi]).attackPiece(xi, yi, xf, yf, this)) {
					board[xf][yf] = board[xi][yi];
					board[xi][yi] = null;
					return true;					
				}				
			}
		}
		return false;
	}
	
}