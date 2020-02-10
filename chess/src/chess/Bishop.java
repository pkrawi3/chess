package chess;

//--------------------------------------------------------- 
// Class for Bishop in chess
//---------------------------------------------------------
public class Bishop extends gamePiece {
	
	//--------------------------------------------------------- 
	// Constructor for Bishop piece
	//---------------------------------------------------------
	public Bishop(boolean white) {
		super(white);
	}
	
	//--------------------------------------------------------- 
	// Checks whether move is legal for Bishop
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		int magn_x = xf - xi;
		int magn_y = yf - yi;
		
		// Check for only diagonal movement
		if(Math.abs(magn_x) != Math.abs(magn_y)) {
			return false;
		}	
		int iter_x = 1;
		if(magn_x < 0) {
			iter_x = -1;
		}	
		int iter_y = 1;
		if(magn_y < 0) {
			iter_y = -1;
		}
		for(int z=1; z < Math.abs(magn_x); z++) {
			if(board.getSpot(xi+iter_x*z, yi+iter_y*z) != null) {
				return false;
			}
		}
		return true;
		
	}
	
	//--------------------------------------------------------- 
	// Checks whether attack is legal for Bishop
	//---------------------------------------------------------
	public boolean attackPiece(int xi, int yi, int xf, int yf, gameBoard board) {
		if(yf-yi > 0 && xf-xi > 0) {
			return movePiece(xi, yi, xf-1, yf-1, board);
		}
		else if(yf-yi > 0 && xf-xi < 0) {
			return movePiece(xi, yi, xf+1, yf-1, board);
		}
		else if(yf-yi < 0 && xf-xi > 0) {
			return movePiece(xi, yi, xf-1, yf+1, board);
		}
		else return movePiece(xi, yi, xf+1, yf+1, board);
	}
}