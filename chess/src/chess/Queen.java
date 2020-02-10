package chess;

//--------------------------------------------------------- 
// Class for Queen piece in chess
//---------------------------------------------------------
public class Queen extends gamePiece {
	
	//--------------------------------------------------------- 
	// Queen piece constructor
	//---------------------------------------------------------
	public Queen(boolean white) {
		super(white);
	}
	
	//--------------------------------------------------------- 
	// Checks whether move is legal for Queen
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		int magn_x = xf - xi;
		int magn_y = yf - yi;
		
		// Non-diagonal condition
		if(magn_x == 0 || magn_y == 0) {
			if(magn_x < 0) {
				for(int i=1; i<(-1*magn_x); i++) {
					if(board.getSpot(xi-i, yi) != null) {
						return false;
					}
				}
			}
			else if(magn_x > 0){
				for(int i=1; i<(magn_x); i++) {
					if(board.getSpot(xi+i, yi) != null) {
						return false;
					}
				}
			}
			else if(magn_y < 0) {
				for(int i=1; i<(-1*magn_y); i++) {
					if(board.getSpot(xi, yi-i) != null) {
						return false;
					}
				}
			}
			else {
				for(int i=1; i<(magn_y); i++) {
					if(board.getSpot(xi, yi+i) != null) {
						return false;
					}
				}
			}
			return true;
		}
		
		// Diagonal condition
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
	// Checks whether attack is legal for Queen
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