package chess;

//--------------------------------------------------------- 
// Class for terminal interface logic
//--------------------------------------------------------- 
public class terminalInterface {

	private gameBoard board;

	//--------------------------------------------------------- 
	// Constructor for interface object
	//--------------------------------------------------------- 
	public terminalInterface(gameBoard board) {
		this.board = board;
	}
	
	//--------------------------------------------------------- 
	// Prints out the board into the terminal
	//---------------------------------------------------------	
	public void printBoard() {
		// Loop through board and print each spot
		for(int x=0; x<board.width; x++) {
			
			// Print numbers on the side
			System.out.print(board.width-x);
			System.out.print(' ');
			
			for(int y=0; y<board.width; y++) {
				gamePiece currPiece = board.getSpot(y, board.width - x - 1);
				// Print associated piece or empty space
				if(currPiece == null) {
					System.out.print(' ');
				}
				else {
					System.out.print(currPiece.getUnicode());
				}
			}
			System.out.print('\n');
		}
		System.out.print(' ');
		
		// Print letters on the bottom
		char base = 'A';
		for(int i=0; i<board.width; i++) {			
			System.out.print((char)(base+i));
			System.out.print(' ');
		}
		System.out.print("\n\n");
	}
	
	
	
}
