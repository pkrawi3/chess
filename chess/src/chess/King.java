package chess;

//--------------------------------------------------------- 
// Class for King piece 
//---------------------------------------------------------
public class King extends gamePiece {
	
	//--------------------------------------------------------- 
	// King piece constructor
	//---------------------------------------------------------
	public King(boolean white) {
		super(white);
	}
	
	//--------------------------------------------------------- 
	// Checks whether move is legal for King piece
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		int magn_x = xf - xi;
		int magn_y = yf - yi;
		
		// Ensures that movement is one spot
		if(magn_x + magn_y == 1 || magn_x * magn_y == 1) {
			return true;
		}
		return false;
	}	
	
	//--------------------------------------------------------- 
	// Checks whether attacking move is legal for King
	//---------------------------------------------------------
	public boolean attackPiece(int xi, int yi, int xf, int yf, gameBoard board) {
		if(movePiece(xi, yi, xf, yf, board)) {
			return true;
		}
		return false;
	}
	
	//--------------------------------------------------------- 
	// Returns the Unicode representation of the piece
	//---------------------------------------------------------
	public char getUnicode() {
		if(isWhite()) {
			return '\u2654';
		}
		else {
			return '\u265A';
		}
	}

}