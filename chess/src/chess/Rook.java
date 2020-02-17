package chess;

//--------------------------------------------------------- 
// Class for Rook piece in chess
//---------------------------------------------------------
public class Rook extends gamePiece {
	
	//--------------------------------------------------------- 
	// Constructor for Rook piece
	//---------------------------------------------------------
	public Rook (boolean white) {
		super(white);
	}
	
	//--------------------------------------------------------- 
	// Checks whether move is legal for Rook
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		int magn_x = xf - xf;
		int magn_y = yf - yi;
		
		// Can't move diagonally
		if(magn_x != 0 && magn_y != 0) {
			return false;
		}
		
		// Check each spot on path to ensure no overlap
		int sign = 1;
		if(magn_x < 0 || magn_y < 0) {
			sign = -1;
		}
		if(magn_x != 0) {
			for(int i=1; i<Math.abs(magn_x); i++) {
				if(board.getSpot(xi+sign*i, yi) != null) {
					return false;
				}
			}
		}
		else {
			for(int i=1; i<Math.abs(magn_y); i++) {
				if(board.getSpot(xi, yi+sign*i) != null) {
					return false;
				}
			}
		}
		return true;
	}
	
	//--------------------------------------------------------- 
	// Checks whether attack is legal for Rook
	//---------------------------------------------------------
	public boolean attackPiece(int xi, int yi, int xf, int yf, gameBoard board) {
		if(xf == 0) {
			if(yf - yi > 0) {
				return movePiece(xi, yi, xf, yf-1, board);
			}
			return movePiece(xi, yi, xf, yf+1, board);
		}
		if(yf == 0) {
			if(xf - xi > 0) {
				return movePiece(xi, yi, xf-1, yf, board);
			}
			return movePiece(xi, yi, xf+1, yf, board);
		}
		return false;
	}
	
	//--------------------------------------------------------- 
	// Returns the Unicode representation of the piece
	//---------------------------------------------------------
	public char getUnicode() {
		if(isWhite()) {
			return '\u2656';
		}
		else {
			return '\u265C';
		}
	}
}