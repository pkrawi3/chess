package chess;

//--------------------------------------------------------- 
//Class for first custom piece, movement is diagonal jump 2 moves
//---------------------------------------------------------
public class customPiece1 extends gamePiece {
	
	//--------------------------------------------------------- 
	// Constructor for custom piece 1
	//---------------------------------------------------------
	public customPiece1(boolean white) {
		super(white);
	}
	
	//--------------------------------------------------------- 
	// Checks whether move is legal for custom piece
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		int magn_x = xf - xi;
		int magn_y = yf - yi;
		
		// Check if right magnitude combination for movement
		if(Math.abs(magn_x) == 2 && Math.abs(magn_y) == 2) {
			return true;
		}
		return false;
	}
	
	//--------------------------------------------------------- 
	// Checks whether attack is legal for custom piece 
	//---------------------------------------------------------
	public boolean attackPiece(int xi, int yi, int xf, int yf, gameBoard board) {
		return movePiece(xi, yi, xf, yf, board);
	}
	
	
	
	
	
}
