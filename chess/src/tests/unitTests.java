package tests;

import static org.junit.jupiter.api.Assertions.*;

import chess.*;

import org.junit.jupiter.api.Test;

class unitTests {

	
	@Test
	//--------------------------------------------------------- 
	// Checks to see that black cannot start
	//---------------------------------------------------------
	void whiteStart() {
		game currentGame = new game();
		Player black = currentGame.black;
		
		assertFalse(currentGame.move(black, 0, 6, 0, 5));
	}
	
	@Test
	//--------------------------------------------------------- 
	// Checks to see that piece can't move out of bounds
	//---------------------------------------------------------
	void testOOB(){
		game currentGame = new game();
		Player black = currentGame.black;
		
		assertFalse(currentGame.move(black, 0, 7, 0, 8));
	}

	@Test
	//--------------------------------------------------------- 
	// Tests basic pawn movements
	//---------------------------------------------------------
	void basicPawn() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 0, 1, 0, 3)); // white pawn [0,1] -> [0,3]		
		assertTrue(currentGame.move(black, 0, 6, 0, 5)); // black pawn [0,6] -> [0,5]
		assertFalse(currentGame.move(white, 0, 3, 0, 5)); // white pawn fail move up again
		assertTrue(currentGame.move(white, 1, 1, 1, 2)); // white pawn [1, 1] - >[1, 2]
		assertTrue(currentGame.move(black, 0, 5, 0, 4)); // black pawn [0,5] - > [0,4] 
		assertFalse(currentGame.move(white, 0, 5, 1, 5)); // white pawn fail move right
	}
	
	@Test
	//--------------------------------------------------------- 
	// Tests basic rook movements
	//---------------------------------------------------------
	void basicRook() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 0, 1, 0, 3)); // white pawn [0,1] -> [0,3]
		assertTrue(currentGame.move(black, 0, 6, 0, 5)); // black pawn [0,6] -> [0,5]
		assertTrue(currentGame.move(white, 0, 0, 0, 2)); // white rook [0,0] -> [0,2] - Rook up
		assertTrue(currentGame.move(black, 0, 5, 0, 4)); // black pawn [0,5] -> [0,4]
		assertTrue(currentGame.move(white, 0, 2, 1, 2)); // white rook [0,2] -> [1,2] - Rook right
		assertTrue(currentGame.move(black, 1, 6, 1, 5)); // black pawn [1,6] -> [1,5]
		assertFalse(currentGame.move(white, 0, 2, 1, 2)); // white rook [1,2] -> [2,3] - Rook diagonal
	}
	
	@Test
	//--------------------------------------------------------- 
	//  Tests basic knight movements
	//---------------------------------------------------------
	void basicKnight() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 1, 0, 0, 2)); // white knight [1,0] -> [0,2] - Knight normal
		assertTrue(currentGame.move(black, 0, 6, 0, 5)); // black pawn [0,6] -> [0,5]
		assertFalse(currentGame.move(white, 0, 2, 0, 5)); // white knight [0,2] -> [0,5] - Knight bad
		
	}

	@Test
	//--------------------------------------------------------- 
	//  Tests basic bishop movements
	//---------------------------------------------------------
	void basicBishop() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 1, 1, 1, 3)); // white pawn [1,1] -> [1,3] - get pawn out of way
		assertTrue(currentGame.move(black, 0, 6, 0, 5)); // black pawn [0,6] -> [0,5]
		assertTrue(currentGame.move(white, 2, 0, 1, 1)); // white rook [2,0] -> [1,1] - Bishop good
		assertTrue(currentGame.move(black, 0, 5, 0, 4)); // black pawn [0,5] -> [0,4]
		assertFalse(currentGame.move(white, 1, 1, 1, 2)); // white rook [1,1] -> [1,2] - Bishop bad
	}
	
	@Test
	//--------------------------------------------------------- 
	// Tests basic queen movements
	//---------------------------------------------------------
	void basicQueen() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 3, 1, 3, 3)); // white pawn [3,1] -> [3,3] - get pawn out of way
		assertTrue(currentGame.move(black, 0, 6, 0, 5)); // black pawn [0,6] -> [0,5]
		assertTrue(currentGame.move(white, 3, 0, 3, 2)); // white rook [3,0] -> [3,2] - Queen up
		assertTrue(currentGame.move(black, 0, 5, 0, 4)); // black pawn [0,5] -> [0,4]
		assertTrue(currentGame.move(white, 3, 2, 4, 3)); // white rook [3,2] -> [4,3] - Queen diagonal
	}
	
	@Test
	//--------------------------------------------------------- 
	// Tests basic king movements
	//---------------------------------------------------------
	void basicKing() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 4, 1, 4, 3)); // white pawn [3,1] -> [3,3] - get pawn out of way
		assertTrue(currentGame.move(black, 0, 6, 0, 5)); // black pawn [0,6] -> [0,5]
		assertTrue(currentGame.move(white, 4, 0, 4, 1)); // white rook [3,0] -> [3,2] - King up
		assertTrue(currentGame.move(black, 0, 5, 0, 4)); // black pawn [0,5] -> [0,4]
		assertTrue(currentGame.move(white, 4, 1, 5, 2)); // white rook [4,1] -> [5,2] - King diagonal
	}
	
	@Test
	//--------------------------------------------------------- 
	// Tests basic capture mechanics
	//---------------------------------------------------------
	void basicCapture() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 1, 1, 1, 3)); // white pawn [1,1] -> [1,3] - Move white pawn up two
		assertTrue(currentGame.move(black, 0, 6, 0, 4)); // black pawn [0,6] -> [0,4] - Move black pawn down two
		assertTrue(currentGame.move(white, 1, 3, 0, 4)); // white rook [3,0] -> [3,2] - Capture black pawn
	}
	
	@Test
	//--------------------------------------------------------- 
	// Tests to three-move checkmate, ensures no moves can be made after
	//---------------------------------------------------------
	void threeMoveMate() {
		game currentGame = new game();
		Player white = currentGame.white;
		Player black = currentGame.black;
		
		assertTrue(currentGame.move(white, 5, 1, 5, 2)); // white pawn [5,1] -> [5,2] - Move white pawn up one
		assertTrue(currentGame.move(black, 4, 6, 4, 4)); // black pawn [4,6] -> [4,4] - Move black pawn down two
		assertTrue(currentGame.move(white, 6, 1, 6, 3)); // white rook [6,1] -> [6,3] - Move white pawn up two
		assertTrue(currentGame.move(black, 3, 7, 7, 3)); // black queen [3,7] -> [7,3] - Check mate
		assertFalse(currentGame.move(white, 0, 1, 0, 2)); // shouldn't move - game ended
	}
	
	
	
}
