package chess;

//--------------------------------------------------------- 
// Class for Player in chess game
//---------------------------------------------------------
public class Player {
	private boolean white;
	private gamePiece king;
	
	//--------------------------------------------------------- 
	// Constructor for player in game
	//---------------------------------------------------------
	public Player(boolean white, gamePiece king) {
		this.white = white;
		this.king = king;
	}
	
	//--------------------------------------------------------- 
	// Checks whether player is white or black
	//---------------------------------------------------------
	public boolean isWhite() {
		return this.white;
	}
	
	//--------------------------------------------------------- 
	// Gets the associated king
	//---------------------------------------------------------
	public gamePiece getKing() {
		return king;
	}
	
}