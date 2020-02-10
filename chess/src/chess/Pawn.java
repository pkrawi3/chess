package chess;

//--------------------------------------------------------- 
// Class for Pawn piece in chess
//---------------------------------------------------------
public class Pawn extends gamePiece {
	private boolean unmoved;
	private int direction;
	
	//--------------------------------------------------------- 
	// Constructor for Pawn piece 
	//---------------------------------------------------------
	public Pawn(boolean white) {
		super(white);
		if(white) {
			this.direction = 1;
		}
		else {
			this.direction = -1;
		}
		this.unmoved = true;
	}
	
	//--------------------------------------------------------- 
	// Checks whether move is legal for pawn
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		if((xf-xi) != 0) {
			return false;
		}
		else if(this.unmoved == true && Math.abs(yf-yi) == 2 && board.getSpot(xi, yi+direction) == null && board.getSpot(xi, yf) == null) {
			this.unmoved = false;
			return true;
		}
		else if(Math.abs(yf-yi) == 1 && board.getSpot(xi, yi+direction) == null) {
			this.unmoved = false;
			return true;
		}
		return false;
	}
	
	//--------------------------------------------------------- 
	// Checks whether attack is legal for pawn
	//---------------------------------------------------------
	public boolean attackPiece(int xi, int yi, int xf, int yf, gameBoard board) {
		if(direction == 1 && (yf-yi) == 1 && Math.abs(xf-xi) == 1) {
			return true;
		}
		else if((yf-yi) == -1 && Math.abs(xf-xi) == 1) {
			return true;
		}
		return false;
	}
	
}