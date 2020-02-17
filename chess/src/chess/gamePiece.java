package chess;

//--------------------------------------------------------- 
// Class which encapsulates all game pieces 
//---------------------------------------------------------
abstract class gamePiece {
	
	private boolean white;

	//--------------------------------------------------------- 
	// Constructor for gamePiece object
	//---------------------------------------------------------
	public gamePiece(boolean white) {
		this.white = white;
	}
	
	//--------------------------------------------------------- 
	// Indicates whether piece is white or black
	//---------------------------------------------------------
	public boolean isWhite() {
		return white;
	}

	//--------------------------------------------------------- 
	// Checks legality of move per piece
	//---------------------------------------------------------
	public boolean movePiece(int xi, int yi, int xf, int yf, gameBoard board) {
		System.out.println("ERROR: Move method failed to be overrident");
		return true;
	}
	
	//--------------------------------------------------------- 
	// Checks legality of attack per piece
	//---------------------------------------------------------
	public boolean attackPiece(int xi, int yi, int xf, int yf, gameBoard board) {
		System.out.println("ERROR: Move method failed to be overrident");
		return true;
	}	

	//--------------------------------------------------------- 
	// Returns the unicode representation of the piece
	//---------------------------------------------------------
	public char getUnicode() {
		return '.';
	}

}
