package chess;

//--------------------------------------------------------- 
// Class for Knight piece in chess
//---------------------------------------------------------
public class Knight extends gamePiece {
	
	//--------------------------------------------------------- 
	// Constructor for Knight piece
	//---------------------------------------------------------
	public Knight(boolean white) {
		super(white);
	}
	
	//--------------------------------------------------------- 
	// Checks whether move is legal for Knight piece
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		int magn_x = xf - xi;
		int magn_y = yf - yi;
		
		// Check if right magnitude combination for movement
		if((Math.abs(magn_x*magn_y) == 2)) {
			return true;
		}
		return false;
	}
	
	//--------------------------------------------------------- 
	// Checks whether attack is legal for Knight
	//---------------------------------------------------------
	public boolean attackPiece(int xi, int yi, int xf, int yf, gameBoard board) {
		return movePiece(xi, yi, xf, yf, board);
	}
	
	//--------------------------------------------------------- 
	// Returns the Unicode representation of the piece
	//---------------------------------------------------------
	public char getUnicode() {
		if(isWhite()) {
			return '\u2658';
		}
		else {
			return '\u265E';
		}
	}
}