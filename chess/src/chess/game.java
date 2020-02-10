package chess;

//--------------------------------------------------------- 
// Main class, sets the board, dictates commands for the game, and gives results
//---------------------------------------------------------
public class game {
	
	public Player white;
	public Player black;
	private Player currentTurn;
	private gameBoard board;
	private boolean gameEnded;
	
	//--------------------------------------------------------- 
	// Constructor for game, initializes the board and players
	//---------------------------------------------------------
	public game(){
		this.board = new gameBoard();
		
		// Set white pieces
		board.setPiece(0, 0, new Rook(true));
		board.setPiece(1, 0, new Knight(true));
		board.setPiece(2, 0, new Bishop(true));
		board.setPiece(3, 0, new Queen(true));
		board.setPiece(4, 0, new King(true));
		board.setPiece(5, 0, new Bishop(true));
		board.setPiece(6, 0, new Knight(true));
		board.setPiece(7, 0, new Rook(true));
		for(int i=0; i<8; i++) {
			board.setPiece(i, 1, new Pawn(true));
		}
		
		// Set black pieces
		board.setPiece(0, 7, new Rook(false));
		board.setPiece(1, 7, new Knight(false));
		board.setPiece(2, 7, new Bishop(false));
		board.setPiece(3, 7, new Queen(false));
		board.setPiece(4, 7, new King(false));
		board.setPiece(5, 7, new Bishop(false));
		board.setPiece(6, 7, new Knight(false));
		board.setPiece(7, 7, new Rook(false));
		for(int i=0; i<8; i++) {
			board.setPiece(i, 6, new Pawn(false));
		}
		
		this.white  = new Player(true, board.getSpot(4, 0));
		this.black = new Player(false, board.getSpot(4, 7));
		this.currentTurn = white;
		this.gameEnded = false;
		
	}
	
	//--------------------------------------------------------- 
	// Alternates between player turns
	//---------------------------------------------------------
	private void nextTurn() {
		if(currentTurn == white) {
			currentTurn = black;
		}
		else {
			currentTurn = white;
		}
	}
	
	//--------------------------------------------------------- 
	// Checks whether various end game conditions apply
	//---------------------------------------------------------
	private boolean endGame(Player player) {
		return isCheck(player); // TODO: add stale mate to end game check
	}
	
	
	//--------------------------------------------------------- 
	// Checks whether certain player is in Checkmate
	//---------------------------------------------------------
	// TODO: Add king position to Player and update this function
	// TODO: Extend function from CHECK -> CHECKMATE
	private boolean isCheck(Player player) {
		int king_x = 0;
		int king_y = 0;
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				if(board.getSpot(x, y) != null && board.getSpot(x,y) == player.getKing()) {
					king_x = x; 
					king_y = y;
				}
			}
		}
		
		// TODO: check all other pieces attack for king
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				if(board.getSpot(x, y) != null && board.getSpot(x,y).isWhite() != player.isWhite()) {
					if(board.getSpot(x, y).attackPiece(x, y, king_x, king_y, board)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//--------------------------------------------------------- 
	// Attempts commanded game move
	//---------------------------------------------------------
	public boolean move(Player player, int xi, int yi, int xf, int yf) {
		if(gameEnded == true) {
			System.out.println("You cannot make a move, the game has ended");
			return false;
		}

		if(currentTurn == player) {
			if(board.changeSpot(xi, yi, xf, yf, currentTurn)) {
				nextTurn();
				if(endGame(currentTurn)) {
					System.out.println("The game has ended.");
					if(currentTurn.isWhite()) {
						System.out.println("White has won.");
					}
					else {
						System.out.println("Black has won.");
					}
				}
				else {
					return true;
				}
			}			
		}
		return false;
	}

	
}