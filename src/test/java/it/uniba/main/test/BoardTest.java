package it.uniba.main.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniba.main.Board;
import it.uniba.main.Move;
import it.uniba.main.Pawn;
import it.uniba.main.Rook;
import it.uniba.main.Piece;
import it.uniba.main.Bishop;
import it.uniba.main.King;
import it.uniba.main.Knight;
import it.uniba.main.Queen;

class BoardTest {

	private Board board;
	
	@BeforeEach
	void initializatio() {
		board = new Board();
	}
	
	@Test
	void testBoard() {
		assertTrue(board.isEmpty(1, 1));
	}
	
	@Test
	void testGetTotalStory() {
		assertTrue(board.getTotalStory().isEmpty());
	}
	
	@Test
	void testGetFirstTurn() {
		assertTrue(board.getFirstTurn() == true);
	}
	
	@Test
	void testSetFirstTurn() {
		board.setFirstTurn(false);
		assertTrue(board.getFirstTurn() == false);
	}
	
	@Test
	void testGetCapture() {
		board.getCapture(1,true);
		board.getCapture(1,false);
	}
	
	@Test
	void testStoreCaptures() {
		Pawn r2 = new Pawn(6, 0, false); 
	    board.setPiece(r2.getPosition(), r2);
	    Pawn k1 = new Pawn(5, 1, true); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("axb3", board, true);
	    Piece piece = board.getPiece(5,1);
        assertTrue(piece.getName() == 'P');    
	}
	
	@Test
	void test2StoreCaptures() {
		Pawn r2 = new Pawn(6, 0, false); 
	    board.setPiece(r2.getPosition(), r2);
	    Rook k1 = new Rook(5, 1, true); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("axb3", board, true);
	    Piece piece = board.getPiece(5,1);
        assertTrue(piece.getName() == 'P');    
	}
	
	@Test
	void test3StoreCaptures() {
		Pawn r2 = new Pawn(6, 0, false); 
	    board.setPiece(r2.getPosition(), r2);
	    Bishop k1 = new Bishop(5, 1, true); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("axb3", board, true);
	    Piece piece = board.getPiece(5,1);
        assertTrue(piece.getName() == 'P');    
	}
	
	@Test
	void test4StoreCaptures() {
		Pawn r2 = new Pawn(6, 0, false); 
	    board.setPiece(r2.getPosition(), r2);
	    Knight k1 = new Knight(5, 1, true); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("axb3", board, true);
	    Piece piece = board.getPiece(5,1);
        assertTrue(piece.getName() == 'P');    
	}
	
	@Test
	void test5StoreCaptures() {
		Pawn r2 = new Pawn(6, 0, false); 
	    board.setPiece(r2.getPosition(), r2);
	    Queen k1 = new Queen(5, 1, true); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("axb3", board, true);
	    Piece piece = board.getPiece(5,1);
        assertTrue(piece.getName() == 'P');    
	}
	
	@Test
	void test6StoreCaptures() {
		Pawn r2 = new Pawn(5, 1, true); 
	    board.setPiece(r2.getPosition(), r2);
	    Pawn k1 = new Pawn(6, 0, false); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("bxa2", board, false);
	    Piece piece = board.getPiece(6,0);
        assertTrue(piece.getName() == 'p');    
	}
	
	@Test
	void test7StoreCaptures() {
		Pawn r2 = new Pawn(5, 1, true); 
	    board.setPiece(r2.getPosition(), r2);
	    Rook k1 = new Rook(6, 0, false); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("bxa2", board, false);
	    Piece piece = board.getPiece(6,0);
        assertTrue(piece.getName() == 'p');      
	}
	
	@Test
	void test8StoreCaptures() {
		Pawn r2 = new Pawn(5, 1, true); 
	    board.setPiece(r2.getPosition(), r2);
	    Bishop k1 = new Bishop(6, 0, false); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("bxa2", board, false);
	    Piece piece = board.getPiece(6,0);
        assertTrue(piece.getName() == 'p');    
	}
	
	@Test
	void test10StoreCaptures() {
		Pawn r2 = new Pawn(5, 1, true); 
	    board.setPiece(r2.getPosition(), r2);
	    Knight k1 = new Knight(6, 0, false); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("bxa2", board, false);
	    Piece piece = board.getPiece(6,0);
        assertTrue(piece.getName() == 'p');    
	}
	
	@Test
	void test11StoreCaptures() {
		Pawn r2 = new Pawn(5, 1, true); 
	    board.setPiece(r2.getPosition(), r2);
	    Queen k1 = new Queen(6, 0, false); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("bxa2", board, false);
	    Piece piece = board.getPiece(6,0);
        assertTrue(piece.getName() == 'p');    
	}
	
	@Test
	void test12StoreCaptures() {
		Pawn r2 = new Pawn(5, 1, true); 
	    board.setPiece(r2.getPosition(), r2);
	    King k1 = new King(6, 0, false); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("bxa2", board, false);
	    Piece piece = board.getPiece(6,0);
        assertTrue(piece.getName() == 'p');    
	}
	
	@Test
	void test13StoreCaptures() {
		Pawn r2 = new Pawn(5, 1, true); 
	    board.setPiece(r2.getPosition(), r2);
	    King k1 = new King(6, 0, false); 
	    board.setPiece(k1.getPosition(), k1);
	    Move.movePawn("bxa2", board, false);
	    Piece piece = board.getPiece(6,0);
        assertTrue(piece.getName() == 'p');    
	}
	
	

}
